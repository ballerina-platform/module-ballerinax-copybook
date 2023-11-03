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

import ballerina/test;
import ballerina/io;

@test:Config
isolated function testConvertor() returns error? {
    Converter convertor = check new("resources/mainframe.cpy");
    string input = check io:fileReadString("resources/input.txt");

    map<json> jsonData = check convertor.toJson(input);
    string output = check convertor.toCopybook(jsonData);
    test:assertEquals(output, input);
}