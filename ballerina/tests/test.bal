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
        map<json> jsonData = check (check converter.toJson(line)).get(DATA).ensureType();
        string output = check converter.toCopybook(jsonData);
        test:assertEquals(output, line);
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
        map<json> jsonData = check (check converter.toJson(line, "DATA-DETAIL-REGISTRY")).get(DATA).ensureType();
        string output = check converter.toCopybook(jsonData, "DATA-DETAIL-REGISTRY");
        test:assertEquals(output, line);
    }
}

@test:Config
isolated function testToJsonWithInvalidTargetRecordName() returns error? {
    Converter converter = check new (getCopybookPath("copybook-7"));
    string input = check io:fileReadString(getAsciiFilePath("copybook-7"));
    Copybook7|Error copybook = converter.fromCopybook(input, "InvalidName");
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(copybook.message(), "Invalid target record name 'InvalidName'");
}

@test:Config
isolated function testToJsonRequiresTargetRecordName() returns error? {
    Converter converter = check new (getCopybookPath("copybook-7"));
    string input = check io:fileReadString(getAsciiFilePath("copybook-7"));
    Copybook7|Error copybook = converter.fromCopybook(input);
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(copybook.message(), "The copybook schema has multiple record definitions. The targetRecordName must not be nil");
}

@test:Config
isolated function testfromCopybookApi() returns error? {
    Converter converter = check new (getCopybookPath("copybook-7"));
    string[] input = check io:fileReadLines(getAsciiFilePath("copybook-7"));
    foreach string line in input {
        Copybook7 copybook = check converter.fromCopybook(line, "Record2");
        string output = check converter.toCopybook(copybook, "Record2");
        test:assertEquals(output, line);
    }
}

@test:Config
isolated function testfromCopybookReturningError() returns error? {
    Converter converter = check new (getCopybookPath("copybook-8"));
    string input = check io:fileReadString(getAsciiFilePath("copybook-8"));
    Copybook8|Error copybook = converter.fromCopybook(input);
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error' but found a 'string'");
    }
    json expectedErrorDetail = check getErrorDetail("copybook-8");
    json actualErrorDetail = check copybook.detail().ensureType();
    test:assertEquals(actualErrorDetail.toJson(), expectedErrorDetail);
}

@test:Config
isolated function testToCopybookWithoutRedefinedItems() returns error? {
    Converter converter = check new (getCopybookPath("copybook-1"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-1"));
    string asciiData = check converter.toCopybook(check jsonInput.cloneWithType());
    string expectedAscii = check io:fileReadString(getAsciiFilePath("copybook-1"));
    test:assertEquals(asciiData, expectedAscii);
}

@test:Config
isolated function testToCopybookReturningError() returns error? {
    Converter converter = check new (getCopybookPath("copybook-9"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-9"));
    string|Error copybook = converter.toCopybook(check jsonInput.cloneWithType());
    if copybook !is Error {
        test:assertFail("Expected a 'copybook:Error' but found a 'string'");
    }
    json expectedErrorDetail = check getErrorDetail("copybook-9");
    json actualErrorDetail = check copybook.detail().ensureType();
    test:assertEquals(actualErrorDetail.toJson(), expectedErrorDetail);
}

@test:Config
isolated function testDecimalWithoutFraction() returns error? {
    Converter converter = check new (getCopybookPath("copybook-10"));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath("copybook-10"));
    string copybook = check converter.toCopybook(check jsonInput.cloneWithType());
    string expectedAscii = check io:fileReadString(getAsciiFilePath("copybook-10"));
    test:assertEquals(copybook, expectedAscii);
}

@test:Config {
    dataProvider: testEnumValidationDataProvider
}
isolated function testEnumValidation(string copybookName) returns error? {
    Converter converter = check new (getCopybookPath(copybookName));
    json jsonInput = check io:fileReadJson(getCopybookJsonPath(string `valid-${copybookName}`));
    string validCopybook = check converter.toCopybook(check jsonInput.cloneWithType());
    test:assertEquals(validCopybook, check io:fileReadString(getAsciiFilePath(copybookName)));

    jsonInput = check io:fileReadJson(getCopybookJsonPath(string `invalid-${copybookName}`));
    Error|string invalidCopybook = converter.toCopybook(check jsonInput.cloneWithType());
    if invalidCopybook !is Error {
        test:assertFail("Expected a 'copybook:Error' but found a 'string'");
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
    string validCopybook = check converter.toCopybook({});
    test:assertEquals(validCopybook, check io:fileReadString(getAsciiFilePath("copybook-15")));
}

@test:Config
isolated function testValueClauseWithDefaulValues() returns error? {
    Converter converter = check new (getCopybookPath("copybook-16"));
    string validCopybook = check converter.toCopybook({});
    test:assertEquals(validCopybook, check io:fileReadString(getAsciiFilePath("copybook-16")));
}

@test:Config
isolated function testUnsupportedValueClauses() returns error? {
    Converter|Error converter = new (getCopybookPath("copybook-17"));
    if converter !is Error {
        test:assertFail("Expected a 'copybook:Error'");
    }
    test:assertEquals(converter.detail(), check getErrorDetail("copybook-17"));
}
