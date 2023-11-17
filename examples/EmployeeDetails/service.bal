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

import ballerina/constraint;
import ballerina/http;
import ballerinax/copybook;

type Copybook record {
    EmployeeRecord EmployeeRecord?;
};

service on new http:Listener(9090) {
    private final copybook:Convertor convertor;

    isolated function init() returns error? {
        self.convertor = check new ("resources/copybook.cpy");
    }

    isolated resource function post convertToJson(@http:Payload string asciiData) returns json|error {
        return self.convertor.toJson(asciiData);
    }

    isolated resource function post convertToAscii(@http:Payload map<json> jsonData) returns string|error {
        return self.convertor.toCopybook(jsonData);
    }

    isolated resource function post getEmployeeSalary(@http:Payload string asciiData) returns decimal|error {
        Copybook cb = check self.convertor.fromCopybook(asciiData);
        decimal? salary = cb.EmployeeRecord?.EmployeeSalary;
        if salary is () {
            return error("No value found for EmployeeSalary");
        }
        return salary;
    }

    isolated resource function post validateJsonData(@http:Payload Copybook copybookData) returns error|http:Ok {
        Copybook _ = check constraint:validate(copybookData);
        return http:OK;
    }
}
