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

import ballerina/jballerina.java;
import ballerina/lang.regexp;

isolated function stringify(FieldValue fieldValue) returns string {
    if fieldValue is string {
        return fieldValue;
    }
    if fieldValue is string[] {
        return "".'join(...fieldValue);
    }
    if fieldValue is GroupValue {
        string[] groupFieldValues = [];
        foreach [string, anydata] [_, value] in fieldValue.entries() {
            if value !is FieldValue {
                continue;
            }
            groupFieldValues.push(stringify(value));
        }
        return "".'join(...groupFieldValues);
    }
    if fieldValue is GroupValue[] {
        string[] elements = [];
        foreach GroupValue item in fieldValue {
            elements.push(stringify(item));
        }
        return "".'join(...elements);
    }
    return "";
}

isolated function sanitize(GroupValue data) returns GroupValue {
    GroupValue sanitizedValue = {};
    foreach [string, anydata] [name, 'field] in data.entries() {
        if 'field is string {
            // Trim only the trailing spaces to preserve spaces appeard in PIC X or PIC A
            string trimmedValue = trimRight('field);
            if 'field.trim() != "" {
                sanitizedValue[name] = trimmedValue;
            }
        } else if 'field is string[] {
            string[] sanitizedElements = [];
            foreach string fieldValue in 'field {
                string trimmedValue = trimRight(fieldValue);
                if fieldValue.trim() != "" {
                    sanitizedElements.push(trimmedValue);
                }
            }
            if sanitizedElements.length() > 0 {
                sanitizedValue[name] = sanitizedElements;
            }
        } else if 'field is GroupValue {
            GroupValue sanitizedGroup = sanitize('field);
            if sanitizedGroup.entries().length() > 0 {
                sanitizedValue[name] = sanitizedGroup;
            }
        } else if 'field is GroupValue[] {
            GroupValue[] sanitizedElements = [];
            foreach GroupValue groupValue in 'field {
                GroupValue santizedGroup = sanitize(groupValue);
                if santizedGroup.entries().length() > 0 {
                    sanitizedElements.push(santizedGroup);
                }
            }
            if sanitizedElements.length() > 0 {
                sanitizedValue[name] = sanitizedElements;
            }
        }
    }
    return sanitizedValue;
}

isolated function trimRight(string data) returns string {
    return re `\s+$`.replace(data, "");
}

isolated function computeSize(Node node, boolean withOccurence = true) returns int {
    int size = 0;
    if node is DataItem {
        size = node.getReadLength();
    } else if node is GroupItem {
        foreach var child in node.getChildren() {
            size += computeSize(child);
        }
    }
    int occuringTime = node.getElementCount();
    return withOccurence && occuringTime > 0 ? size * occuringTime : size;
}

isolated function isArray(Node item) returns boolean {
    if item is GroupItem {
        return item.getElementCount() != -1;
    } else if item is DataItem {
        return item.getElementCount() != -1;
    }
    return false;
}

isolated function decimalToString(decimal value) returns string {
    string decimalString = value.toString();
    int? seperatorIdx = decimalString.indexOf(".");
    if seperatorIdx is () {
        decimalString += ".0";
    }
    return decimalString;
}

isolated function externToString(Node node) returns string = @java:Method {
    'class: "io.ballerina.lib.copybook.runtime.converter.Utils"
} external;

isolated function getTypeDefinition(Schema schema, string targetRecordName) returns Node {
    foreach Node node in schema.getTypeDefinitions() {
        if targetRecordName == node.getName() {
            return node;
        }
    }
    panic error(string `Unable to find targert record ${targetRecordName}`);
}

isolated function isRedefiningItem(Node node) returns boolean {
    if node is DataItem {
        return node.getRedefinedItemName() != ();
    } else if node is GroupItem {
        return node.getRedefinedItemName() != ();
    }
    return false;
}

isolated function getRedefiningItemNames(GroupItem parent, string redefinedItemName) returns string[] {
    string[] redefiningItems = [];
    foreach Node child in parent.getChildren() {
        boolean isRedefiningItem = false;
        if child is DataItem {
            isRedefiningItem = child.getRedefinedItemName() == redefinedItemName;
        } else if child is GroupItem {
            isRedefiningItem = child.getRedefinedItemName() == redefinedItemName;
        }
        if isRedefiningItem {
            redefiningItems.push(child.getName());
        }
    }
    return redefiningItems;
}

isolated function findChildByName(GroupItem parent, string childName) returns Node? {
    foreach Node child in parent.getChildren() {
        if child.getName() == childName {
            return child;
        }
    }
    return;
}

isolated function findNodeByName(Node parent, string name) returns Node? {
    if parent is Schema {
        foreach var typedef in parent.getTypeDefinitions() {
            if typedef.getName() == name {
                return typedef;
            }
        }
    }
    if parent is GroupItem {
        return findChildByName(parent, name);
    }
    if parent is DataItem && name == parent.getName() {
        return parent;
    }
    return;
}

isolated function getSupressZeroCount(string pictureString) returns int {
    regexp:Groups? groups = re `^Z\((\d+)\).*$`.findGroups(pictureString);
    if groups is () {
        return 0;
    }
    regexp:Span? span = groups[1];
    if span is () {
        return 0;
    }
    return checkpanic int:fromString(span.substring());
}

isolated function createError(error err) returns Error {
    if err is Error {
        return err;
    }
    return error Error(err.message(), err);
}

// Introduced as a workaround for https://github.com/wso2-enterprise/internal-support-ballerina/issues/759
isolated function toDecimalArray(string[] possibleEnumValues) returns decimal[]|error =>
    possibleEnumValues.'map(possibleValue => check decimal:fromString(possibleValue));

isolated function toIntArray(string[] possibleEnumValues) returns int[]|error =>
    possibleEnumValues.'map(possibleValue => check int:fromString(possibleValue));

isolated function toByteArray(int[] possibleEnumValues, int length) returns byte[][]|error {
    return possibleEnumValues.'map(intValue => check encodeCopybookBinaryValue(intValue, length));
}

isolated function fromByteToStringArray(string[] possibleEnumValues, int length) returns int[]|error {
    return possibleEnumValues.'map(possibleValue => check int:fromString(possibleValue));
}

isolated function getEncodedCopybookBinaryValue(int value, int length) returns byte[]|error {
    if value < 0 {
        return encodeNegativeValue(value, length);
    }
    return encodeCopybookBinaryValue(value, length);
}

isolated function encodeNegativeValue(int value, int length) returns byte[]|error {
    string binaryString = decimalToBinary(value.abs());
    binaryString = check findTwosComplement(binaryString.padZero(32));
    int complementValue = binaryToDecimal(binaryString);
    return encodeCopybookBinaryValue(complementValue, length);
}

isolated function encodeCopybookBinaryValue(int value, int length) returns byte[]|error {
    string hexString = int:toHexString(value).padZero(length * 2);
    string[] doubles = splitAs2Chars(hexString);
    int[] bytes = doubles.reverse().'map(r => check int:fromHexString(r));
    return bytes.cloneWithType();
}

isolated function decodeBinaryValue(int[] bytes) returns int|error {
    string[] binaryValues = bytes.reverse().'map(r => decimalToBinary(r).padStart(8, "0"));
    string value = "";
    foreach string name in binaryValues {
        value += name;
    }
    if value.startsWith("1") {
        value = check findTwosComplement(value);
        return -binaryToDecimal(value);
    }
    return binaryToDecimal(value);
}

isolated function splitAs2Chars(string hexString) returns string[] {
    string[] doubles = [];
    int i = 0;
    while i < hexString.length() - 1 {
        string double = hexString.substring(i, i + 2);
        doubles.push(double);
        i += 2;
    }
    return doubles;
}

isolated function decimalToBinary(int decimalValue) returns string {
    if decimalValue == 0 {
        return "0";
    }
    string binary = "";
    int val = decimalValue;
    int i = 0;
    while val > 0 {
        binary = (val % 2).toString() + binary;
        val = val / 2;
        i += 1;
    }
    return binary;
}

isolated function binaryToDecimal(string binary) returns int {
    int decimalValue = 0;
    int length = binary.length();
    foreach int i in 0 ..< length {
        if binary[length - i - 1] == "1" {
            decimalValue += 1 << i;
        }
    }
    return decimalValue;
}

isolated function findTwosComplement(string binary) returns string|error {
    string onesComplement = "";
    foreach string:Char char in binary {
        onesComplement += (char == "0" ? "1" : "0");
    }
    int[] twosComplement = onesComplement.toCodePointInts();
    int codePointInt0 = string:toCodePointInt("0");
    int codePointInt1 = string:toCodePointInt("1");
    boolean carry = true;
    foreach int i in int:range(onesComplement.length() - 1, 0, -1) {
        if twosComplement[i] == codePointInt1 && carry {
            twosComplement[i] = codePointInt0;
        } else if carry {
            twosComplement[i] = codePointInt1;
            carry = false;
        }
    }
    if carry {
        twosComplement.unshift(codePointInt1);
    }
    return check string:fromCodePointInts(twosComplement);
}
