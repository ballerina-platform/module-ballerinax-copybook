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

class DataCoercer {
    private final Schema schema;
    private final string? targetRecordName;
    private final error[] errors = [];

    isolated function init(Schema schema, string? targetRecordName) {
        self.schema = schema;
        self.targetRecordName = targetRecordName;
    }

    isolated function coerce(GroupValue data) returns map<json>|error {
        if self.errors.length() > 0 {
            string[] errorMsgs = self.errors.'map(err => err.message());
            map<string[]> errorDetail = {errors: errorMsgs};
            return error Error("Data coercion failed.", detail = errorDetail);
        }
        return self.coerceData(data, self.schema).cloneWithType();
    }

    private isolated function coerceData(GroupValue data, Node parentNode) returns GroupValue {
        GroupValue coercedValue = {};

        foreach [string, anydata] [name, 'field] in data.entries() {
            Node? node = findNodeByName(parentNode, name);
            if node is () {
                continue;
            }
            if 'field is string|string[] && node is DataItem {
                anydata|error coercedItemValue = coerceDataItemValue('field, node);
                if coercedItemValue is error {
                    self.errors.push(coercedItemValue);
                    continue;
                }
                coercedValue[name] = coercedItemValue;
            } else if 'field is GroupValue {
                coercedValue[name] = self.coerceData('field, node);
            } else if 'field is GroupValue[] {
                GroupValue[] corecedArray = [];
                foreach GroupValue groupValue in 'field {
                    corecedArray.push(self.coerceData(groupValue, node));
                }
                coercedValue[name] = corecedArray;
            }
        }
        return coercedValue;
    }
}

isolated function coerceDataItemValue(string|string[] data, DataItem dataItem) returns anydata|error {
    // Trim to remove spaces allocated for sing or Z prefix in decimal
    if data is string {
        if dataItem.isDecimal() {
            string decimalString = data.trim();
            check validateMaxByte(decimalString, dataItem);
            return decimal:fromString(decimalString);
        }
        if dataItem.isNumeric() {
            string intString = data.trim();
            check validateMaxByte(intString, dataItem);
            return int:fromString(intString);
        }
        check validateMaxByte(data, dataItem);
        return data;
    }
    anydata[] elements = [];
    if dataItem.isDecimal() {
        foreach string element in data {
            string decimalString = element.trim();
            check validateMaxByte(decimalString, dataItem);
            elements.push(check decimal:fromString(decimalString));
        }
        return elements;
    }
    if dataItem.isNumeric() {
        foreach string element in data {
            string intString = element.trim();
            check validateMaxByte(intString, dataItem);
            elements.push(check int:fromString(intString));
        }
        return elements;
    }
    foreach string element in data {
        check validateMaxByte(element, dataItem);
    }
    return data;
}

isolated function validateMaxByte(string value, DataItem dataItem) returns error? {
    if dataItem.isDecimal() {
        int? seperatorIndex = value.indexOf(".");
        int wholeNumberMaxLength = dataItem.getReadLength() - dataItem.getFloatingPointLength() - 1;
        if (seperatorIndex is int && seperatorIndex > wholeNumberMaxLength) || (seperatorIndex is () && value.length() > wholeNumberMaxLength) {
            return error Error(string `The whole number part of decimal value ${value} exceeds the maximum byte size of ${wholeNumberMaxLength}`);
        }
        if seperatorIndex is int && value.substring(seperatorIndex + 1).length() > dataItem.getFloatingPointLength() {
            return error Error(string `The fractional part of the decimal value ${value} exceeds the maximum byte size of ${dataItem.getFloatingPointLength()}`);
        }
    }
    int maxReadBytes = dataItem.getReadLength(); 
    if dataItem.isNumeric() {
        // handle pic with optional sign ex: s9(9)
        boolean valueHasSign = value.startsWith("+") || value.startsWith("-");
        maxReadBytes = dataItem.getReadLength() + (dataItem.isSigned() && valueHasSign ? 1 : 0);
    }
    if value.length() > maxReadBytes {
        return error Error(string `Value ${value} exceeds the max byte size ${maxReadBytes}`);
    }
}
