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

class JsonToCopybookConvertor {
    *Visitor;

    private final string[] value = [];
    private final Error[] errors = [];
    private final string[] path = [];
    private final map<Node> redefinedItems;
    private final string? targetRecordName;
    private final map<()> visitAllowedRedefiningItems = {};

    isolated function init(Schema schema, string? targetRecordName) {
        self.redefinedItems = schema.getRedefinedItems();
        self.targetRecordName = targetRecordName;
    }

    isolated function visitSchema(Schema schema, anydata data = ()) {
        self.path.push(ROOT_JSON_PATH);
        Node typedef = getTypeDefinition(schema, self.targetRecordName);
        if data !is map<json> {
            self.errors.push(error Error(string `Invalid value '${data.toString()}' found at ${self.getPath()}`));
            _ = self.path.pop();
            return;
        }
        if data.hasKey(typedef.getName()) {
            typedef.accept(self, data.get(typedef.getName()));
        }
        _ = self.path.pop();
    }

    isolated function visitGroupItem(GroupItem groupItem, anydata data = ()) {
        if isRedefiningItem(groupItem) && !self.visitAllowedRedefiningItems.hasKey(groupItem.getName()) {
            return;
        }
        self.path.push(groupItem.getName());

        int elementCount = groupItem.getElementCount();
        if elementCount < 0 && data is map<json> {
            foreach Node node in groupItem.getChildren() {
                self.visitChild(groupItem, node, data);
            }
        } else if elementCount > 0 && data is map<json>[] {
            foreach map<json> element in data {
                foreach Node node in groupItem.getChildren() {
                    self.visitChild(groupItem, node, element);
                }
            }
            int elementSize = computeSize(groupItem, false);
            int remainingElements = (groupItem.getElementCount() - data.length());
            int paddLength = remainingElements * elementSize;
            self.value.push("".padEnd(paddLength));
        } else {
            self.errors.push(error Error(string `Found an invalid value '${data is () ? "null" : data.toString()}'`
                + string `at ${self.getPath()}. A '${groupItem.getElementCount() < 0 ? "map<json>" : "map<json>[]"}'`
                + "value is expected"));
        }
        _ = self.path.pop();
    }

    private isolated function visitChild(GroupItem parent, Node child, map<json> value) {
        if isRedefiningItem(child) {
            return;
        }
        Node targetChild = child;
        string[] redefiningItems = getRedefiningItemNames(parent, child.getName());
        string? redefiningItemNameWithValue = ();
        if !value.hasKey(child.getName()) {
            redefiningItemNameWithValue = self.findRedefiningItemNameWithValue(value, redefiningItems);
            if redefiningItemNameWithValue is () {
                self.value.push("".padEnd(computeSize(child)));
                return;
            }
            self.visitAllowedRedefiningItems[redefiningItemNameWithValue] = ();
            // Assuming that all the redefined fields/groups share identical JSON content.
            Node? redifiningItem = findChildByName(parent, redefiningItemNameWithValue);
            if redifiningItem is () {
                return;
            }
            targetChild = redifiningItem;
        }
        targetChild.accept(self, value.get(targetChild.getName()));
        if redefiningItemNameWithValue is string
            && self.visitAllowedRedefiningItems.hasKey(redefiningItemNameWithValue) {
            _ = self.visitAllowedRedefiningItems.remove(redefiningItemNameWithValue);
        }
    }

    private isolated function findRedefiningItemNameWithValue(map<json> parentValue, string[] redefiningItemdNames)
    returns string? {
        foreach string itemName in redefiningItemdNames {
            if parentValue.hasKey(itemName) {
                return itemName;
            }
        }
        return;
    }

    isolated function visitDataItem(DataItem dataItem, anydata data = ()) {
        if isRedefiningItem(dataItem) && !self.visitAllowedRedefiningItems.hasKey(dataItem.getName()) {
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
                check error Error(string `Found an invalid value '${data.toString()}' at ${self.getPath()}.` +
                    string `A ${dataItem.getElementCount() < 0 ? "primitive" : "array"} value is expected`);
                return;
            }
            self.value.push(primitiveValue);
        } on fail error e {
            if e is Error {
                self.errors.push(e);
            }
        }
        _ = self.path.pop();
    }

    private isolated function handlePrimitive(PrimitiveType value, DataItem dataItem) returns string|error {
        if value is string {
            return self.handleStringValue(value, dataItem);
        }
        if value is int {
            return self.handleIntValue(value, dataItem);
        }
        return self.handleDecimalValue(<decimal>value, dataItem);
    }

    private isolated function handleStringValue(string value, DataItem dataItem) returns string|Error {
        int maxLength = dataItem.getReadLength();
        if dataItem.isNumeric() {
            return error Error(string `Expected a numeric value at ${self.getPath()} but found string "${value}"`);
        }
        if value.length() > dataItem.getReadLength() {
            return error Error(string `Value '${value}' exceeds the max length ${maxLength} at ${self.getPath()}`);
        }
        return value.padEnd(maxLength);
    }

    private isolated function handleIntValue(int value, DataItem dataItem) returns string|error {
        if !dataItem.isNumeric() {
            return error Error(string `Numeric value ${value} found at ${self.getPath()}.`
                + " Expecting a non-numeric value");
        }
        if dataItem.isDecimal() {
            return self.handleDecimalValue(<decimal>value, dataItem);
        }
        int maxByteSize = dataItem.getReadLength();
        if value.toString().length() > maxByteSize
            || (dataItem.getPicture().startsWith("+") && value > 0 && value.toString().length() > maxByteSize - 1) {
            return error Error(string `Value ${value} exceeds maximum byte size ${maxByteSize} at ${self.getPath()}`);
        }
        if dataItem.getPicture().startsWith("-") {
            // Add " " in the beginning of the string if the data has is positive
            return value < 0 ? value.toString().padZero(maxByteSize)
                : value.toString().padZero(maxByteSize - 1).padStart(maxByteSize);
        } else if dataItem.getPicture().startsWith("+") {
            // Add "+" in the beginning of the string if the data has is positive
            return value < 0 ? value.toString().padZero(maxByteSize)
                : "+" + value.toString().padZero(maxByteSize - 1).padStart(maxByteSize - 1);
        }
        // handle S9(9)
        if dataItem.isSigned() && value < 0 {
            return value.toString().padZero(maxByteSize + 1); // +1 for sign byte
        }
        return value.toString().padZero(maxByteSize);
    }

    private isolated function handlePrimitiveArray(PrimitiveArrayType array, DataItem dataItem)
    returns string|error {
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
        if !dataItem.isDecimal() && !dataItem.isNumeric() {
            string expectedType = dataItem.isNumeric() ? "int" : "string";
            return error Error(string `Found invalid value '${input.toString()}' at ${self.getPath()}.`
                + string ` A '${expectedType}' value is expected`);
        }
        if dataItem.isNumeric() && !dataItem.isDecimal() {
            return self.handleIntValue(<int>input, dataItem);
        }
        string coercedDecimalString = decimalToString(input);
        int seperatorIndex = <int>coercedDecimalString.indexOf(".");
        string wholeNumber = coercedDecimalString.substring(0, seperatorIndex);
        string fraction = coercedDecimalString.substring(seperatorIndex + 1, coercedDecimalString.length());

        check self.checkDecimalLength(wholeNumber, fraction, input, dataItem);
        // Handle trailing zeros in decimal
        if fraction.length() < dataItem.getFloatingPointLength() {
            fraction = fraction.padEnd(dataItem.getFloatingPointLength(), "0");
        } else if fraction.length() > dataItem.getFloatingPointLength() {
            fraction = fraction.substring(0, dataItem.getFloatingPointLength());
        }
        // Handle supress zero ex: Z(9)9.8;
        int supressZeroCount = getSupressZeroCount(dataItem.getPicture());
        string decimalString = wholeNumber + "." + fraction.padEnd(dataItem.getFloatingPointLength(), "0");
        if dataItem.getPicture().startsWith("-") && input >= 0d {
            // A deducted of 1 made from readLength for sign place holder " "
            return " " + decimalString.padZero(dataItem.getReadLength() - 1 - supressZeroCount)
                .padStart(dataItem.getReadLength() - 1);
        }
        if dataItem.getPicture().startsWith("+") && input > 0d {
            // A deducted of 1 made from readLength for sign char "+"
            return "+" + decimalString.padZero(dataItem.getReadLength() - 1 - supressZeroCount)
                .padStart(dataItem.getReadLength() - 1);
        }
        return decimalString.padZero(dataItem.getReadLength() - supressZeroCount).padStart(dataItem.getReadLength());
    }

    private isolated function checkDecimalLength(string wholeNumber, string fraction, decimal input,
            DataItem dataItem) returns error? {
        // A deducted of 1 made from readLength for decimal seperator "."
        int expectedWholeNumberLength = dataItem.getReadLength() - dataItem.getFloatingPointLength() - 1;
        // If PIC has + or -, then remove the space allocated for the sign
        string picture = dataItem.getPicture();
        expectedWholeNumberLength -= (picture.startsWith("+") || picture.startsWith("-")) is true ? 1 : 0;
        string integerPart = wholeNumber.startsWith("-") ? wholeNumber.substring(1) : wholeNumber;
        if integerPart.length() > expectedWholeNumberLength {
            return error Error(string `Value '${input}' exceeds the maximum number of integer digits `
                + string `${expectedWholeNumberLength} at ${self.getPath()}`);
        } else if fraction.length() > dataItem.getFloatingPointLength() {
            string exeedingFractionDigits = fraction.substring(dataItem.getFloatingPointLength());
            if check int:fromString(exeedingFractionDigits) > 0 {
                return error Error(string `Value '${input}' exceeds the maximum number of fraction digits `
                    + string `${dataItem.getFloatingPointLength()} at ${self.getPath()}`);
            }
        }
        return;
    }

    private isolated function getPath() returns string {
        return string `'${".".'join(...self.path)}'`;
    }

    isolated function getValue() returns string|Error {
        if self.errors.length() > 0 {
            string[] errorMsgs = self.errors.'map(err => err.message());
            return error Error("JSON to copybook data conversion failed.", errors = errorMsgs);
        }
        return "".'join(...self.value);
    }
}
