// Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
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

import ballerina/test;
import ballerina/http;
import ballerina/io;

http:Client testClient = check new("http://localhost:9090");

@test:Config
function testConvertToJson() returns error? {
    http:Request req = new;
    string payload = check io:fileReadString("tests/resources/copybook.txt");
    req.setTextPayload(payload);
    http:Response res = check testClient->post("/convertToJson", req);
    test:assertEquals(res.statusCode, 201, "Status code should be 201");
    json expectedJson = check io:fileReadJson("tests/resources/result.json");
    test:assertEquals(res.getJsonPayload(), expectedJson);
}

@test:Config
function testConvertToAscii() returns error? {
    http:Request req = new;
    json payload = check io:fileReadJson("tests/resources/payload.json");
    req.setJsonPayload(payload);
    http:Response res = check testClient->post("/convertToAscii", req);
    test:assertEquals(res.statusCode, 201, "Status code should be 201");
    string expectedText = check io:fileReadString("tests/resources/copybook.txt");
    test:assertEquals(res.getTextPayload(), expectedText);
}

@test:Config
function testGetEmployeeSalary() returns error? {
    http:Request req = new;
    string payload = check io:fileReadString("tests/resources/copybook.txt");
    req.setTextPayload(payload);
    http:Response res = check testClient->post("/getEmployeeSalary", req);
    test:assertEquals(res.statusCode, 201, "Status code should be 201");
    test:assertEquals(res.getTextPayload(), "1500.00");
}

@test:Config
function testValidateJsonData() returns error? {
    http:Request req = new;
    json payload = check io:fileReadJson("tests/resources/invalid_payload.json");
    req.setJsonPayload(payload);
    http:Response res = check testClient->post("/validateJsonData", req);
    test:assertEquals(res.statusCode, 400, "Status code should be 400");
    http:ErrorPayload errorPayload = check (check res.getJsonPayload()).fromJsonWithType();
    string expectedMsg = "payload validation failed: Validation failed for '$.EmployeeRecord.EmployeeDepartments[0].DeptCode:maxDigits','$.EmployeeRecord.EmployeeName.FirstName:maxLength','$.EmployeeRecord.EmployeeRating:maxIntegerDigits' constraint(s).";
    test:assertEquals(errorPayload.message, expectedMsg);
}
