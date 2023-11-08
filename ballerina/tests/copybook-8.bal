// This file generated using copybook-tools

import ballerina/constraint;

@constraint:Int {minValue: 0, maxDigits: 2}
public type UnsignedInteger2 int;

@constraint:Number {minValue: 0, maxIntegerDigits: 6, maxFractionDigits: 2}
public type UnsignedDecimal6V2 decimal;

@constraint:Number {minValue: 0, maxIntegerDigits: 4, maxFractionDigits: 3}
public type UnsignedDecimal4V3 decimal;

public type Employee record {
    Integer3 EmployeeId?;
    UnsignedInteger2 ContractYears?;
    UnsignedDecimal6V2 Salary?;
    UnsignedDecimal4V3 Bonus?;
};
