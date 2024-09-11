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
    private final Error[] errors = [];
    private final string[] path = [];

    isolated function init(Schema schema) {
        self.schema = schema;
    }

    isolated function coerce(GroupValue data) returns map<json>|Error {
        self.path.push(ROOT_JSON_PATH);
        map<json>|error coercedData = self.coerceData(data, self.schema).cloneWithType();
        if coercedData is error {
            return createError(coercedData);
        }
        map<json> result = {data: coercedData};
        if self.errors.length() > 0 {
            string[] errorMsgs = self.errors.'map(err => err.message());
            result[ERRORS] = errorMsgs;
        }
        _ = self.path.pop();
        return result;
    }

    private isolated function coerceData(GroupValue data, Node parentNode) returns GroupValue {
        GroupValue coercedValue = {};

        foreach [string, anydata] [name, 'field] in data.entries() {
            Node? node = findNodeByName(parentNode, name);
            if node is () {
                continue;
            }
            self.path.push(name);
            if 'field is string|string[] && node is DataItem {
                coercedValue[name] = self.coerceDataItemValue('field, node);
            } else if 'field is GroupValue {
                coercedValue[name] = self.coerceData('field, node);
            } else if 'field is GroupValue[] {
                GroupValue[] corecedArray = [];
                int i = 0;
                foreach GroupValue groupValue in 'field {
                    self.path.push(string `[${i}]`);
                    corecedArray.push(self.coerceData(groupValue, node));
                    _ = self.path.pop();
                    i += 1;
                }
                coercedValue[name] = corecedArray;
            }
            _ = self.path.pop();
        }
        return coercedValue;
    }

    private isolated function coerceDataItemValue(string|string[] data, DataItem dataItem) returns anydata {
        // Trim to remove spaces allocated for sign or Z prefix in decimal
        if data is string {
            if dataItem.isDecimal() {
                return self.coerceDecimal(data, dataItem);
            }
            if dataItem.isNumeric() {
                return self.coerceInt(data, dataItem);
            }
            return self.getValidatedString(data, dataItem);
        }
        anydata[] elements = [];
        if dataItem.isDecimal() {
            int i = 0;
            foreach string element in data {
                self.path.push(string `[${i}]`);
                elements.push(self.coerceDecimal(element, dataItem));
                _ = self.path.pop();
                i += 1;
            }
            return elements;
        }
        if dataItem.isNumeric() {
            int i = 0;
            foreach string element in data {
                self.path.push(string `[${i}]`);
                elements.push(self.coerceInt(element, dataItem));
                _ = self.path.pop();
                i += 1;
            }
            return elements;
        }
        foreach string element in data {
            int i = 0;
            self.path.push(string `[${i}]`);
            elements.push(self.getValidatedString(element, dataItem));
            _ = self.path.pop();
            i += 1;
        }
        return;
    }

    private isolated function coerceDecimal(string data, DataItem dataItem) returns decimal? {
        string decimalString = data.trim();
        error|decimal coercedValue = trap decimal:fromString(decimalString);
        if coercedValue is error {
            self.errors.push(error Error(string `Failed to convert the value '${data}' to a 'decimal' `
                + string `at ${self.getPath()}.`));
            return;
        }
        Error? validation = self.validateMaxByte(decimalString, dataItem);
        if validation is Error {
            self.errors.push(validation);
            return;
        }
        return coercedValue;
    }

    private isolated function coerceInt(string data, DataItem dataItem) returns int? {
        string intString = data.trim();
        error|int coercedValue = int:fromString(intString);
        if coercedValue is error {
            self.errors.push(error Error(string `Failed to convert the value '${data}' to an 'int' `
                + string `at ${self.getPath()}.`));
            return;
        }
        Error? validation = self.validateMaxByte(intString, dataItem);
        if validation is Error {
            self.errors.push(validation);
            return;
        }
        return coercedValue;
    }

    private isolated function getValidatedString(string data, DataItem dataItem) returns string? {
        Error? validation = self.validateMaxByte(data, dataItem);
        if validation is Error {
            self.errors.push(validation);
        }
        return data;
    }

    private isolated function validateMaxByte(string value, DataItem dataItem) returns Error? {
        if dataItem.isDecimal() {
            int? seperatorIndex = value.indexOf(".");
            int wholeNumberMaxLength = dataItem.getReadLength() - dataItem.getFloatingPointLength() - 1;
            if (seperatorIndex is int && seperatorIndex > wholeNumberMaxLength)
                || (seperatorIndex is () && value.length() > wholeNumberMaxLength) {
                return error Error(string `The integral part of the decimal value` +
                    string ` '${value}' exceeds the maximum byte size of ${wholeNumberMaxLength} at ${self.getPath()}.`);
            }
            if seperatorIndex is int
                && value.substring(seperatorIndex + 1).length() > dataItem.getFloatingPointLength() {
                return error Error(string `The decimal value '${value}' has a fractional part that exceeds the maximum` +
                string ` byte size of ${dataItem.getFloatingPointLength()} at ${self.getPath()}.`);
            }
        }
        int maxReadBytes = dataItem.getReadLength();
        if dataItem.isNumeric() {
            // handle pic with optional sign ex: s9(9)
            boolean valueHasSign = value.startsWith("+") || value.startsWith("-");
            maxReadBytes = dataItem.getReadLength() + (dataItem.isSigned() && valueHasSign ? 1 : 0);
        }
        if value.length() > maxReadBytes {
            return error Error(string `The value '${value}' exceeds the maximum byte size of ${maxReadBytes} ` +
                string `at ${self.getPath()}.`);
        }
    }

    private isolated function getPath() returns string {
        return string `'${".".'join(...self.path)}'`;
    }

    isolated function addErrors(Error[] errors) {
        self.errors.push(...errors);
    }
}
