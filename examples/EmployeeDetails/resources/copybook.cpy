01 EmployeeRecord.
   05 EmployeeId        PIC XXXX.
   05 EmployeeName.
      10 FirstName      PIC X(10).
      10 LastName       PIC X(10).
   05 EmployeeFullName  REDEFINES
           EmployeeName PIC X(20).
   05 EmployeeSalary    PIC Z(2)99999.99.
   05 EmployeeGrade     PIC X(1).
   05 EmployeeRating    PIC +9(2).9.
   05 EmployeeDepartments OCCURS 4 TIMES.
      10 DeptCode       PIC 9(5).
      10 DeptName       PIC X(10).
   05 EmployeeAddress   PIC X(20).
   05 EmployeeAddressRed REDEFINES EmployeeAddress.
      10 Street          PIC X(10).
      10 City            PIC X(10).
   05 FineAmount        PIC -9(4).99.
   05 PenaltyRating      PIC -9(2).9.
