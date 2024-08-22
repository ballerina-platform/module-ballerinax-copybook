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

isolated function getEncodedCopybookBinaryValue(int value, int packLength, Encoding encoding) returns byte[]|error =>
    value < 0 ? encodeNegativeValue(value, packLength, encoding) : encodeCopybookBinaryValue(value, packLength, encoding);

isolated function encodeNegativeValue(int value, int packLength, Encoding encoding) returns byte[]|error {
    string binary = decimalToBinary(value.abs());
    int expectedNumOfBits = packLength * 8;
    binary = check findTwosComplement(binary.padZero(expectedNumOfBits));
    int decimalValue = binaryToDecimal(binary);
    return encodeCopybookBinaryValue(decimalValue, packLength, encoding);
}

isolated function encodeCopybookBinaryValue(int value, int packLength, Encoding encoding) returns byte[]|error {
    string hex = int:toHexString(value).padZero(packLength * 2);
    string[] doubles = splitHexToByteChunks(hex);
    if encoding == EBCDIC {
        return doubles.'map(r => check int:fromHexString(r)).cloneWithType();
    }
    return doubles.reverse().'map(r => check int:fromHexString(r)).cloneWithType();
}

isolated function decodeBinaryValue(int[] bytes, Encoding encoding) returns int|error {
    string[] binaryValues = encoding == ASCII ? bytes.reverse().'map(r => decimalToBinary(r).padStart(8, "0")) :
        bytes.'map(r => decimalToBinary(r).padStart(8, "0"));
    string value = "".'join(...binaryValues);
    if value.startsWith("1") {
        value = check findTwosComplement(value);
        return -binaryToDecimal(value);
    }
    return binaryToDecimal(value);
}

// This function map the hex string into string array where each element represent a byte
isolated function splitHexToByteChunks(string hex) returns string[] {
    string[] byteChunks = [];
    int i = 0;
    while i < hex.length() - 1 {
        string chunk = hex.substring(i, i + 2);
        byteChunks.push(chunk);
        i += 2;
    }
    return byteChunks;
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
