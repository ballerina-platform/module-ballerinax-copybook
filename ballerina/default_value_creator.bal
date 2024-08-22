// Copyright (c) 2024 WSO2 LLC. (http://www.wso2.com).
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

class DefaultValueCreator {
    *Visitor;
    private byte[][] defaultValueFragments = [];
    private Error[] errors = [];
    private final Encoding encoding;

    isolated function init(Encoding encoding) {
        self.encoding = encoding;
    }

    isolated function visitSchema(Schema schema, anydata data = ()) {
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        if groupItem.getRedefinedItemName() is string {
            return;
        }
        byte[][] defaultValues = self.defaultValueFragments;
        self.defaultValueFragments = [];
        foreach Node node in groupItem.getChildren() {
            node.accept(self);
        }
        byte[] groupItemDefaultValue = flattenByteArrayChunks(self.defaultValueFragments);
        defaultValues.push(self.generateRepeatedByte(groupItemDefaultValue, groupItem.getElementCount()));
        self.defaultValueFragments = defaultValues;
    }

    isolated function visitDataItem(DataItem dataItem, anydata data = ()) {
        if dataItem.getRedefinedItemName() is string {
            return;
        }
        string dataItemDefaultValue = dataItem.getDefaultValue() ?: "";
        if (dataItem.isNumeric() && !dataItem.isDecimal()) || (dataItem.isDecimal() && dataItemDefaultValue != "") {
            dataItemDefaultValue = dataItemDefaultValue.padZero(dataItem.getReadLength());
        } else {
            dataItemDefaultValue = dataItemDefaultValue.padEnd(dataItem.getReadLength());
        }
        byte[] defaultValue = dataItemDefaultValue.toBytes();
        if dataItem.isBinary() {
            defaultValue = self.handleBinaryValue(dataItemDefaultValue, dataItem);
        } else if self.encoding == EBCDIC {
            defaultValue = toEbcdicBytes(defaultValue);
        }
        defaultValue = self.generateRepeatedByte(defaultValue, dataItem.getElementCount());
        self.defaultValueFragments.push(defaultValue);
    }

    private isolated function handleBinaryValue(string dataItemDefaultValue, DataItem dataItem) returns byte[] {
        do {
            int intValue = check int:fromString(dataItemDefaultValue);
            return check getEncodedCopybookBinaryValue(intValue, dataItem.getPackLength(), self.encoding);
        } on fail error e {
            self.errors.push(
                error Error(string `Failed to convert '${dataItemDefaultValue}' in to a binary encoded value: `
                        + e.message()));
            return getZeroBytesArray(dataItem.getPackLength());
        }
    }

    private isolated function generateRepeatedByte(byte[] value, int count) returns byte[] {
        if count < 0 {
            return value;
        }
        byte[][] values = [];
        foreach int i in 1 ... count {
            values.push(value);
        }
        return flattenByteArrayChunks(values);
    }

    isolated function getDefaultValue() returns byte[] {
        return flattenByteArrayChunks(self.defaultValueFragments);
    }

    public isolated function getErrors() returns Error[]? {
        return self.errors.length() > 0 ? self.errors : ();
    };
}
