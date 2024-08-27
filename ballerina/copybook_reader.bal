// Copyright (c) 2023 WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
//
// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

class CopybookReader {
    *Visitor;

    private final GroupValue value = {};
    private final map<string> redfinedValues = {};
    private final map<Node> redefinedItems;
    private ByteIterator copybookIterator;
    private final string? targetRecordName;
    private final Encoding encoding;
    private Error[] errors;

    isolated function init(byte[] copybookData, Schema schema, Encoding encoding, string? targetRecordName = ()) {
        self.copybookIterator = new (copybookData);
        self.redefinedItems = schema.getRedefinedItems();
        self.encoding = encoding;
        self.targetRecordName = targetRecordName;
        self.errors = [];
    }

    isolated function visitSchema(Schema schema, anydata data = ()) {
        string? targetRecordName = self.targetRecordName;
        if targetRecordName is string {
            Node typeDef = getTypeDefinition(schema, targetRecordName);
            typeDef.accept(self);
            return;
        }
        foreach Node typeDef in schema.getTypeDefinitions() {
            typeDef.accept(self);
        }
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        ByteIterator temp = self.copybookIterator;
        self.copybookIterator = self.getIteratorForItem(groupItem);

        if isArray(groupItem) {
            GroupValue[] elements = [];
            foreach int i in 0 ..< groupItem.getElementCount() {
                GroupValue groupValue = {};
                foreach var child in groupItem.getChildren() {
                    child.accept(self, groupValue);
                }
                elements.push(groupValue);
            }
            self.addValue(groupItem.getName(), elements, data);
        } else {
            GroupValue groupValue = {};
            foreach var child in groupItem.getChildren() {
                child.accept(self, groupValue);
            }
            self.addValue(groupItem.getName(), groupValue, data);
        }

        // Reset the iterator to previous text iterator
        self.copybookIterator = temp;
    }

    isolated function visitDataItem(DataItem dataItem, anydata data = ()) {
        ByteIterator temp = self.copybookIterator;
        self.copybookIterator = self.getIteratorForItem(dataItem);
        if isArray(dataItem) {
            string[] elements = [];
            foreach int i in 0 ..< dataItem.getElementCount() {
                elements.push(self.read(dataItem));
            }
            self.addValue(dataItem.getName(), elements, data);
        } else {
            self.addValue(dataItem.getName(), self.read(dataItem), data);
        }

        // Reset the iterator to previous text iterator
        self.copybookIterator = temp;
    }

    private isolated function getIteratorForItem(DataItem|GroupItem item) returns ByteIterator {
        string? redefinedItemName = ();
        if item is GroupItem {
            redefinedItemName = item.getRedefinedItemName();
        }
        if item is DataItem {
            redefinedItemName = item.getRedefinedItemName();
        }
        if redefinedItemName is string {
            // Obtain the iterator from redfinedValues map if the provided item is a redefining item
            ByteIterator iterator = new (self.redfinedValues.get(redefinedItemName).toBytes());
            return iterator;
        }
        return self.copybookIterator;
    }

    private isolated function read(DataItem dataItem) returns string {
        do {
            byte[] bytes = [];
            int readLength = dataItem.isBinary() ? dataItem.getPackLength() : dataItem.getReadLength();
            foreach int i in 0 ..< readLength {
                var data = self.copybookIterator.next();
                if data is () {
                    break;
                }
                bytes.push(data.value);
            }
            if dataItem.isBinary() {
                int intValue = check decodeBinaryValue(bytes, self.encoding);
                return intValue.toString();
            }
            if self.encoding == EBCDIC {
                bytes = toAsciiBytes(bytes);
            }
            string token = check string:fromBytes(bytes);
            // Handle optional sign in PIC S9
            if dataItem.isSigned() && re `^(\+|-).*$`.find(token.trim()) !is () {
                var additionalChar = self.copybookIterator.next();
                if additionalChar !is () {
                    bytes.push(additionalChar.value);
                    return check string:fromBytes(bytes);
                }
            }
            return token;
        } on fail error e {
            Error err = createError(e);
            self.errors.push(err);
            return "";
        }
    }

    private isolated function addValue(string fieldName, FieldValue fieldValue, anydata parent) {
        if parent is GroupValue {
            parent[fieldName] = fieldValue;
        } else if parent is () {
            self.value[fieldName] = fieldValue;
        }

        if self.redefinedItems.hasKey(fieldName) {
            self.redfinedValues[fieldName] = stringify(fieldValue);
        }
    }

    isolated function getValue() returns GroupValue {
        return sanitize(self.value);
    }

    public isolated function getErrors() returns Error[]? {
        return self.errors.length() > 0 ? self.errors : ();
    };
}
