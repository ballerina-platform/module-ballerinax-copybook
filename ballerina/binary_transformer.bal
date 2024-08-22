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

isolated function getEncodedCopybookBinaryValue(int value, int length, Encoding encoding) returns byte[]|error {
    if value < 0 {
        return encodeNegativeValue(value, length, encoding);
    }
    return encodeCopybookBinaryValue(value, length, encoding);
}

isolated function encodeNegativeValue(int value, int length, Encoding encoding) returns byte[]|error {
    string binaryString = decimalToBinary(value.abs());
    binaryString = check findTwosComplement(binaryString.padZero(32));
    int complementValue = binaryToDecimal(binaryString);
    return encodeCopybookBinaryValue(complementValue, length, encoding);
}

isolated function encodeCopybookBinaryValue(int value, int length, Encoding encoding) returns byte[]|error {
    string hexString = int:toHexString(value).padZero(length * 2);
    string[] doubles = splitAs2Chars(hexString);
    if encoding == EBCDIC {
        int[] bytes = doubles.'map(r => check int:fromHexString(r));
        return bytes.cloneWithType();
    }
    int[] bytes = doubles.reverse().'map(r => check int:fromHexString(r));
    return bytes.cloneWithType();
}

isolated function decodeBinaryValue(int[] bytes, Encoding encoding) returns int|error {
    string[] binaryValues = [];
    if encoding == ASCII {
        binaryValues = bytes.reverse().'map(r => decimalToBinary(r).padStart(8, "0"));
    } else {
        binaryValues = bytes.'map(r => decimalToBinary(r).padStart(8, "0"));
    }
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
