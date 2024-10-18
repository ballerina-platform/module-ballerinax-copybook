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

import ballerina/io;
import ballerina/test;

@test:Config
isolated function testParseSchemaFile() returns error? {
    Schema schema = check parseSchemaFile(getCopybookPath("copybook-1"));
    json expected = check io:fileReadJson(getSchemaPath("copybook-1"));
    json actual = check schema.toString().fromJsonString();
    test:assertEquals(actual, expected);
}

@test:Config {
    dataProvider: testConverterDataProvider
}
isolated function testConverter(string copybookName) returns error? {
    Converter converter = check new (getCopybookPath(copybookName));
    string[] input = check io:fileReadLines(getAsciiFilePath(copybookName));
    foreach string line in input {
        map<json> jsonData = check (check converter.fromBytes(line.toBytes())).get(DATA).ensureType();
        byte[] output = check converter.toBytes(jsonData);
        test:assertEquals(string:fromBytes(output), line);
    }
}

isolated function testConverterDataProvider() returns map<[string]> {
    map<[string]> filePaths = {};
    foreach int i in 1 ... 5 {
        filePaths[i.toString()] = [string `copybook-${i}`];
    }
    return filePaths;
}

@test:Config
isolated function testConverterWithTargetRecordName() returns error? {
    Converter converter = check new (getCopybookPath("copybook-6"));
    string[] input = check io:fileReadLines(getAsciiFilePath("copybook-6"));
    foreach string line in input {
        map<json> jsonData = check (check converter.fromBytes(line.toBytes(), "DATA-DETAIL-REGISTRY")).get(DATA).ensureType();
        byte[] output = check converter.toBytes(jsonData, "DATA-DETAIL-REGISTRY");
        test:assertEquals(string:fromBytes(output), line);
    }
}

@test:Config
isolated function testConverterWithInvalidTargetRecordName() returns error? {
    Converter converter = check new (getCopybookPath("copybook-7"));
    string input = check io:fileReadString(getAsciiFilePath("copybook-7"));
    map<json>|Error copybook = converter.fromBytes(input.toBytes(), "InvalidName");
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(copybook.message(), "Invalid target record name 'InvalidName'");
}

@test:Config
isolated function testConverterReturningResultWithErrors() returns error? {
    Converter converter = check new (getCopybookPath("copybook-8"));
    string input = check io:fileReadString(getAsciiFilePath("copybook-8"));
    map<json> copybook = check converter.fromBytes(input.toBytes());
    json data = check trap copybook.remove("data");
    json expectedData = check io:fileReadJson(getCopybookJsonPath("copybook-8"));
    test:assertEquals(data, expectedData);
    json expectedErrors = check getErrorDetail("copybook-8");
    test:assertEquals(copybook, expectedErrors);
}

@test:Config
isolated function testConverterWithoutRedefinedItems() returns error? {
    Converter converter = check new (getCopybookPath("copybook-1"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-1"));
    byte[] output = check converter.toBytes(check jsonInput.cloneWithType());
    string expectedAscii = check io:fileReadString(getAsciiFilePath("copybook-1"));
    test:assertEquals(string:fromBytes(output), expectedAscii);
}

@test:Config
isolated function testToBytesReturningError() returns error? {
    Converter converter = check new (getCopybookPath("copybook-9"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-9"));
    byte[]|Error copybook = converter.toBytes(check jsonInput.cloneWithType());
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error' but found 'byte[]'");
    }
    json expectedErrorDetail = check getErrorDetail("copybook-9");
    json actualErrorDetail = check copybook.detail().ensureType();
    test:assertEquals(actualErrorDetail.toJson(), expectedErrorDetail);
}

@test:Config
isolated function testDecimalWithoutFraction() returns error? {
    Converter converter = check new (getCopybookPath("copybook-10"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-10"));
    byte[] output = check converter.toBytes(check jsonInput.cloneWithType());
    string expectedAscii = check io:fileReadString(getAsciiFilePath("copybook-10"));
    test:assertEquals(string:fromBytes(output), expectedAscii);
}

@test:Config {
    dataProvider: testEnumValidationDataProvider
}
isolated function testEnumValidation(string copybookName) returns error? {
    Converter converter = check new (getCopybookPath(copybookName));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath(string `valid-${copybookName}`));
    byte[] validCopybook = check converter.toBytes(check jsonInput.cloneWithType());
    test:assertEquals(string:fromBytes(validCopybook), check io:fileReadString(getAsciiFilePath(copybookName)));

    jsonInput = check io:fileReadJson(getCopybookJsonPath(string `invalid-${copybookName}`));
    byte[]|Error invalidCopybook = converter.toBytes(check jsonInput.cloneWithType());
    if invalidCopybook !is Error {
        test:assertFail("Expected a 'copybook:Error' but found 'byte[]'");
    }
    test:assertEquals(invalidCopybook.detail(), check getErrorDetail(copybookName));
}

isolated function testEnumValidationDataProvider() returns map<[string]> {
    map<[string]> copybookNames = {};
    foreach int i in 11 ... 13 {
        copybookNames[i.toString()] = [string `copybook-${i}`];
    }
    return copybookNames;
}

@test:Config
isolated function testInvalidEnumSchema() returns error? {
    Converter|Error converter = new (getCopybookPath("copybook-14"));
    if converter !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(converter.detail(), check getErrorDetail("copybook-14"));
}

@test:Config
isolated function testIntegerPicDefaulValues() returns error? {
    Converter converter = check new (getCopybookPath("copybook-15"));
    byte[] output = check converter.toBytes({});
    test:assertEquals(string:fromBytes(output), check io:fileReadString(getAsciiFilePath("copybook-15")));
}

@test:Config
isolated function testValueClauseWithDefaulValues() returns error? {
    Converter converter = check new (getCopybookPath("copybook-16"));
    byte[] output = check converter.toBytes({});
    test:assertEquals(string:fromBytes(output), check io:fileReadString(getAsciiFilePath("copybook-16")));
}

@test:Config
isolated function testUnsupportedValueClauses() returns error? {
    Converter|Error converter = new (getCopybookPath("copybook-17"));
    if converter !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(converter.detail(), check getErrorDetail("copybook-17"));
}

@test:Config
isolated function testAsciiEbcdicConvertion() returns error? {
    byte[] ascii = check io:fileReadBytes(getAsciiFilePath("copybook-1"));
    byte[] ebcdic = check io:fileReadBytes(getEbcdicFilePath("copybook-1"));
    test:assertEquals(toEbcdicBytes(ascii), ebcdic);
    test:assertEquals(toAsciiBytes(ebcdic), ascii);
}

@test:Config
isolated function testCopybookWithMultipleRootRecords() returns error? {
    Converter converter = check new (getCopybookPath("copybook-18"));
    string ascii = check io:fileReadString(getAsciiFilePath("copybook-18"));
    json data = check io:fileReadJson(getCopybookJsonPath("copybook-18"));
    byte[] output = check converter.toBytes(check data.cloneWithType());
    test:assertEquals(string:fromBytes(output), ascii);

    map<json> jsonOutput = check converter.fromBytes(ascii.toBytes());
    test:assertEquals(check jsonOutput.data, data);
}

@test:Config {
    dataProvider: testCopybookWithBinaryUsageDataProvider
}
isolated function testCopybookWithBinaryUsage(string fileName, string targetRecord) returns error? {
    Converter converter = check new (getCopybookPath(fileName));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath(fileName));
    byte[] bytes = check converter.toBytes(check jsonInput.cloneWithType(), targetRecord);
    map<json> toJson = check converter.fromBytes(bytes, targetRecord);
    test:assertEquals(check toJson.data, jsonInput);
}

function testCopybookWithBinaryUsageDataProvider() returns string[][] {
    return [
        ["copybook-19", "MQCIH"],
        ["copybook-20", "MQCIH"]
    ];
}

@test:Config {
    dataProvider: dataProviderBytesEncoding
}
isolated function testEbcdicEncoding(string fileName, string targetRecord) returns error? {
    Converter converter = check new (getCopybookPath(fileName));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath(fileName));
    byte[] bytes = check converter.toBytes(check jsonInput.cloneWithType(), targetRecord, EBCDIC);
    map<json> toJson = check converter.fromBytes(bytes, targetRecord, EBCDIC);
    test:assertEquals(jsonInput, check toJson.data);
}

function dataProviderBytesEncoding() returns string[][] {
    return [
        ["copybook-19", "MQCIH"],
        ["copybook-20", "MQCIH"]
    ];
}

@test:Config
isolated function testBinaryFieldsHavingDefaultValue() returns error? {
    Converter converter = check new (getCopybookPath("copybook-20"));
    byte[] bytes = check converter.toBytes({}, encoding = EBCDIC);
    map<json> toJson = check converter.fromBytes(bytes, encoding = EBCDIC);
    json expected = check io:fileReadJson(getCopybookJsonPath("default-value-copybook-20"));
    test:assertEquals(check toJson.data, expected);
}

@test:Config
isolated function testEbcidiValueHavingOptionalSignedInteger() returns error? {
    // Test PIC S9(003) with data having optional minus sign
    Converter converter = check new (getCopybookPath("copybook-6"));
    string[] input = check io:fileReadLines(getAsciiFilePath("copybook-6"));
    string targetRecordName = "DATA-DETAIL-REGISTRY";
    foreach string line in input {
        map<json> jsonData = check (check converter.fromBytes(line.toBytes(), targetRecordName)).get(DATA).ensureType();
        byte[] ebcdic = check converter.toBytes(jsonData, targetRecordName, EBCDIC);
        map<json> jsonFromEbcdic = check (check converter.fromBytes(ebcdic, targetRecordName, EBCDIC)).get(DATA).ensureType();
        test:assertEquals(jsonFromEbcdic, jsonData);
    }
}

@test:Config
isolated function testImpliedDecimal() returns error? {
    Converter converter = check new (getCopybookPath("copybook-21"));
    byte[] ascii = check io:fileReadBytes(getAsciiFilePath("copybook-21"));

    json actual = check converter.fromBytes(ascii);
    json jsonVal = check io:fileReadJson(getCopybookJsonPath("copybook-21"));
    test:assertEquals(actual.toJsonString(), {data: jsonVal}.toJsonString());

    byte[] bytes = check converter.toBytes(check jsonVal.ensureType());
    test:assertEquals(string:fromBytes(bytes), check string:fromBytes(ascii));
}

@test:Config
isolated function testImpliedDecimalForDefaultValue() returns error? {
    Converter converter = check new (getCopybookPath("copybook-21"));
    byte[] bytes = check converter.toBytes({});
    test:assertEquals(string:fromBytes(bytes), "                                       ");
}

@test:Config
isolated function testImpliedDecimalWithEbcidic() returns error? {
    Converter converter = check new (getCopybookPath("copybook-21"));
    json jsonVal = check io:fileReadJson(getCopybookJsonPath("copybook-21"));

    byte[] bytes = check converter.toBytes(check jsonVal.ensureType(), encoding = EBCDIC);
    check io:fileWriteBytes(getEbcdicFilePath("copybook-21"), bytes);
    byte[] ebcdic = check io:fileReadBytes(getEbcdicFilePath("copybook-21"));
    test:assertEquals(bytes, ebcdic);
    
    json actual = check converter.fromBytes(ebcdic, encoding = EBCDIC);
    test:assertEquals(actual.toJsonString(), {data: jsonVal}.toJsonString());
}
