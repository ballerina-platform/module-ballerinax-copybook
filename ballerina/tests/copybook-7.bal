// This file generated using copybook-tools

import ballerina/constraint;

@constraint:Int {minValue: 0, maxDigits: 2}
public type Integer2 int;

@constraint:Int {minValue: 0, maxDigits: 3}
public type Integer3 int;

@constraint:String {maxLength: 19}
public type AlphaNumeric19 string;

@constraint:String {maxLength: 10}
public type AlphaNumeric10 string;

@constraint:String {maxLength: 40}
public type AlphaNumeric40 string;

@constraint:Int {minValue: 0, maxDigits: 7}
public type Integer7 int;

@constraint:Number {maxIntegerDigits: 5, maxFractionDigits: 2}
public type Decimal5V2 decimal;

@constraint:String {maxLength: 1}
public type AlphaNumeric1 string;

@constraint:String {maxLength: 3}
public type AlphaNumeric3 string;

public type Record1 record {
    Integer2 Data1RegistryType?;
    Integer3 Data1Company?;
    AlphaNumeric19 Data1UserAccount?;
    AlphaNumeric10 Data1BirthDate?;
    AlphaNumeric40 Data1Name?;
    Integer7 Data1CreditLimit?;
    Decimal5V2 Data1LimitUsed?;
    record {AlphaNumeric1 Data1StatusFlag?;}[4] Data1Status?;
    AlphaNumeric3 FILLER?;
};

public type Record2 record {
    Integer2 Data1RegistryType?;
    Integer3 Data1CompanyId?;
    AlphaNumeric3 Data1CompanyIdRed?;
    AlphaNumeric19 Data1UserAccount?;
    AlphaNumeric10 Data1BirthDate?;
    AlphaNumeric40 Data1Name?;
    Integer7 Data1CreditLimit?;
    Decimal5V2 Data1LimitUsed?;
    record {AlphaNumeric1 Data1StatusFlag?;}[4] Data1Status?;
    AlphaNumeric3 FILLER?;
};
