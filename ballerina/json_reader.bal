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

class JsonReader {
    *Visitor;

    private final string[] value = [];
    private final Error[] errors = [];
    private final string[] path = [];
    private final map<string> processedItemValues = {};
    private final map<Node> redefinedItems;

    isolated function init(Schema schema) {
        self.redefinedItems = schema.getRedefinedItems();
    }

    isolated function visitSchema(Schema schema, anydata data = ()) {
        self.path.push(ROOT_JSON_PATH);
        Node typedef = schema.getTypeDefinitions()[0];
        if data !is map<json> {
            self.errors.push(error Error(string `Invalid value ${data.toString()} found at ${self.getPath()}`));
            _ = self.path.pop();
            return;
        }
        if data.hasKey(typedef.getName()) {
            if typedef is GroupItem {
                self.visitGroupItem(typedef, data.get(typedef.getName()));
            } else if typedef is DataItem {
                self.visitDataItem(typedef, data.get(typedef.getName()));
            }
        }
        _ = self.path.pop();
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        // TODO: handle redefined value
        string? redefinedItem = groupItem.getRedefinedItemName();
        if redefinedItem is string && self.processedItemValues.hasKey(redefinedItem) {
            return;
        }
        self.path.push(groupItem.getName());
        // int lastValueIndex = self.value.length() == 0 ? 0 : self.value.length() - 1;

        int elementCount = groupItem.getElementCount();
        if elementCount < 0 && data is map<json> {
            foreach Node node in groupItem.getChildren() {
                self.visitChild(node, data);
            }
        } else if elementCount > 0 && data is map<json>[] {
            foreach map<json> element in data {
                foreach Node node in groupItem.getChildren() {
                    self.visitChild(node, element);
                }
            }
            int elementSize = computeSize(groupItem, false);
            int remainingElements = (groupItem.getElementCount() - data.length());
            int paddLength = remainingElements * elementSize;
            self.value.push("".padEnd(paddLength));
        } else {
            self.errors.push(error Error(string `Found an invalid value ${data.toString()} at ${self.getPath()}.` +
                    string `A '${groupItem.getElementCount() < 0 ? "map<json>" : "map<json>[]"}' value is expected`));
        }
        // TODO: handle redefined value
        // int currentValueIndex = self.value.length();
        // string groupValue = string:'join("", ...self.value.slice(lastValueIndex, currentValueIndex));
        // self.processedItemValues[groupItem.getName()] = groupValue;
        // if redefinedItem is string {
        //     // Since we now know the redefind group item value set that as well
        //     self.processedItemValues[redefinedItem] = groupValue;
        // }
        _ = self.path.pop();
    }

    private isolated function visitChild(Node child, map<json> value) {
        if !value.hasKey(child.getName()) {
            self.value.push("".padEnd(computeSize(child)));
            return;
        }
        if child is GroupItem {
            self.visitGroupItem(child, value.get(child.getName()));
        } else if child is DataItem {
            self.visitDataItem(child, value.get(child.getName()));
        }
    }

    isolated function visitDataItem(DataItem dataItem, anydata data = ()) {
        // TODO: handle redefined value
        string? redefinedItem = dataItem.getRedefinedItemName();
        if redefinedItem is string && self.processedItemValues.hasKey(redefinedItem) {
            return;
        }
        self.path.push(dataItem.getName());
        do {
            string? primitiveValue = ();
            if dataItem.getElementCount() < 0 && data is PrimitiveType {
                primitiveValue = check self.handlePrimitive(data, dataItem);
            } else if dataItem.getElementCount() > 0 && data is PrimitiveArrayType {
                primitiveValue = check self.handlePrimitiveArray(data, dataItem);
            }
            if primitiveValue is () {
                check error Error(string `Found an invalid value ${data.toString()} at ${self.getPath()}.` +
                    string `A ${dataItem.getElementCount() < 0 ? "primitive" : "array"} value is expected`);
                return;
            }
            self.value.push(primitiveValue);
            // TODO: handle redefined value
            self.processedItemValues[dataItem.getName()] = primitiveValue;
            if redefinedItem is string {
                // Since we now know the redefind item value set that as well
                self.processedItemValues[redefinedItem] = primitiveValue;
            }
        } on fail error e {
            if e is Error {
                self.errors.push(e);
            }
        }
        _ = self.path.pop();
    }

    private isolated function handlePrimitive(PrimitiveType value, DataItem dataItem) returns string|error {
        if value is string {
            return self.handleStringVlaue(value, dataItem);
        }
        if value is int {
            return self.handleIntValue(value, dataItem);
        }
        return self.handleDecimalValue(<decimal>value, dataItem);
    }

    private isolated function handleStringVlaue(string value, DataItem dataItem) returns string|Error {
        int maxLength = dataItem.getReadLength();
        if dataItem.isNumeric() {
            return error Error(string `Expected a numeric value at ${self.getPath()} but found string "${value}"`);
        }
        if value.length() > dataItem.getReadLength() {
            return error Error(string `Value ${value} exceeds the max length ${maxLength} at ${self.getPath()}`);
        }
        return value.padEnd(maxLength);
    }

    private isolated function handleIntValue(int value, DataItem dataItem) returns string|error {
        if !dataItem.isNumeric() {
            return error Error(string `Numeric value ${value} found at ${self.getPath()}. Expecting a non-numeric value`);
        }
        if dataItem.isDecimal() {
            return self.handleDecimalValue(<decimal>value, dataItem);
        }
        int maxByteSize = dataItem.getReadLength();
        if value.toString().length() > maxByteSize {
            return error Error(string `Value ${value} exceeds maximux byte size ${maxByteSize} at ${self.getPath()}`);
        }
        boolean hasSignInPicture = dataItem.getPicture().startsWith("-") || dataItem.getPicture().startsWith("+");
        if hasSignInPicture {
            // Add " " in the begining of the string if the data has is positive
            return value < 0 ? value.toString().padZero(maxByteSize)
                : value.toString().padZero(maxByteSize - 1).padStart(maxByteSize);
        }
        boolean hasSInPicture = dataItem.getPicture().startsWith("S"); // handle S9(9)
        if hasSInPicture && value < 0 {
            return value.toString().padZero(maxByteSize + 1); // +1 for sign byte
        }
        return value.toString().padZero(maxByteSize);
    }

    private isolated function handlePrimitiveArray(PrimitiveArrayType array, DataItem dataItem) returns string|error {
        string[] elements = [];
        PrimitiveType[] primitiveArray = array; // This is allowed by covariance
        foreach int i in 0 ..< primitiveArray.length() {
            self.path.push(string `[${i}]`);
            elements.push(check self.handlePrimitive(primitiveArray[i], dataItem));
            _ = self.path.pop();
        }
        int maxElementCount = dataItem.getElementCount();
        if array.length() > maxElementCount {
            return error Error(string `Number of elements exceeds the max size ${maxElementCount} at ${self.getPath()}`);
        }
        return "".'join(...elements).padEnd(computeSize(dataItem));
    }

    private isolated function handleDecimalValue(decimal input, DataItem dataItem) returns string|error {
        // TODO: skipped decimal with V, implment seperately for decimal containing V
        // TODO: handle special case Z for fraction
        // TODO: handle S9V9(0)
        if !dataItem.isDecimal() && !dataItem.isNumeric() {
            string expectedType = dataItem.isNumeric() ? "int" : "string";
            return error Error(string `Found invalid value ${input.toString()} at ${self.getPath()}. A '${expectedType}' value is expected`);
        }
        if dataItem.isNumeric() && !dataItem.isDecimal() {
            return self.handleIntValue(<int>input, dataItem);
        }
        string coercedDecimalString = decimalToString(input);
        int seperatorIndex = <int>coercedDecimalString.indexOf(".");
        string wholeNumber = coercedDecimalString.substring(0, seperatorIndex);
        string fraction = coercedDecimalString.substring(seperatorIndex + 1, coercedDecimalString.length());

        int expectedWholeNumberLength = dataItem.getReadLength() - dataItem.getFloatingPointLength() - 1; // -1 here for "."
        if wholeNumber.length() > expectedWholeNumberLength {
            return error Error(string `Value ${input} exceeds the max byte limit of whole number ${expectedWholeNumberLength} at ${self.getPath()}`);
        } else if fraction.length() > dataItem.getFloatingPointLength() {
            fraction = fraction.substring(0, dataItem.getFloatingPointLength());
        }

        boolean hasSignInPicture = dataItem.getPicture().startsWith("-") || dataItem.getPicture().startsWith("+");
        boolean hasZInPic = dataItem.getPicture().startsWith("Z");
        string decimalString = wholeNumber + "." + fraction.padEnd(dataItem.getFloatingPointLength(), "0");
        if hasSignInPicture && input >= 0d {
            // -1 for sign place holder (first char)
            return " " + decimalString.padZero(dataItem.getReadLength() - 1, hasZInPic ? " " : "0");
        }
        return decimalString.padZero(dataItem.getReadLength(), hasZInPic ? " " : "0");
    }

    private isolated function getPath() returns string {
        return string `'${".".'join(...self.path)}'`;
    }

    isolated function getValue() returns string {
        return "".'join(...self.value);
    }
}
