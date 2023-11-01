import ballerina/test;
import ballerina/io;

@test:Config
isolated function testConvertor() returns error? {
    Converter convertor = check new("mainfram.cob");
    string originalContent = check io:fileReadString("resp.txt");

    map<json> val = check convertor.toJson(originalContent);
    check io:fileWriteJson("result.json", val);
    string recreatedContent = check convertor.toCopybook(val);
    test:assertEquals(recreatedContent, originalContent);
}