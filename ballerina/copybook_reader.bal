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
    private Iterator copybookIterator;
    private final string? targetRecordName;

    isolated function init(Iterator copybookIterator, Schema schema, string? targetRecordName = ()) {
        self.copybookIterator = copybookIterator;
        self.redefinedItems = schema.getRedefinedItems();
        self.targetRecordName = targetRecordName;
    }

    isolated function visitSchema(Schema schema, anydata data = ()) {
        Node typeDef = getTypeDefinition(schema, self.targetRecordName);
        typeDef.accept(self);
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        Iterator temp = self.copybookIterator;
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
        Iterator temp = self.copybookIterator;
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

    private isolated function getIteratorForItem(DataItem|GroupItem item) returns Iterator {
        string? redefinedItemName = ();
        if item is GroupItem {
            redefinedItemName = item.getRedefinedItemName();
        }
        if item is DataItem {
            redefinedItemName = item.getRedefinedItemName();
        }
        if redefinedItemName is string {
            // Obtain the iterator from redfinedValues map if the provided item is a redefining item
            return self.redfinedValues.get(redefinedItemName).iterator();
        }
        return self.copybookIterator;
    }

    private isolated function read(DataItem dataItem) returns string {
        string:Char[] chars = [];
        foreach int i in 0 ..< dataItem.getReadLength() {
            var data = self.copybookIterator.next();
            if data is () {
                break;
            }
            chars.push(data.value);
        }
        string token = "".'join(...chars);
        // Handle optional sign in PIC S9
        if dataItem.isSigned() && re `^(\+|-).*$`.find(token.trim()) !is () {
            var additionalChar = self.copybookIterator.next();
            if additionalChar !is () {
                chars.push(additionalChar.value);
            }
        }
        return "".'join(...chars);
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
}
