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

@constraint:String {maxLength: 4}
public type AlphaNumeric4 string;

@constraint:String {maxLength: 10}
public type AlphaNumeric10 string;

@constraint:String {maxLength: 20}
public type AlphaNumeric20 string;

@constraint:Number {minValue: 0, maxIntegerDigits: 7, maxFractionDigits: 2}
public type UnsignedDecimal7V2 decimal;

@constraint:String {maxLength: 1}
public type AlphaNumeric1 string;

@constraint:Number {maxIntegerDigits: 2, maxFractionDigits: 1}
public type Decimal2V1 decimal;

@constraint:Int {minValue: 0, maxDigits: 5}
public type UnsignedInteger5 int;

@constraint:Number {maxIntegerDigits: 3, maxFractionDigits: 2}
public type Decimal3V2 decimal;

public type EmployeeRecord record {
    AlphaNumeric4 EmployeeId?;
    record {AlphaNumeric10 FirstName?; AlphaNumeric10 LastName?;} EmployeeName?;
    AlphaNumeric20 EmployeeFullName?;
    UnsignedDecimal7V2 EmployeeSalary?;
    AlphaNumeric1 EmployeeGrade?;
    Decimal2V1 EmployeeRating?;
    record {UnsignedInteger5 DeptCode?; AlphaNumeric10 DeptName?;}[4] EmployeeDepartments?;
    AlphaNumeric20 EmployeeAddress?;
    record {AlphaNumeric10 Street?; AlphaNumeric10 City?;} EmployeeAddressRed?;
    Decimal3V2 FineAmount?;
    Decimal2V1 PenaltyRating?;
};
