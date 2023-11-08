01 Record1.
   03 Data1RegistryType             PIC 9(002).
      88 Data1RegistryTypeHeader     Value 01.
      88 Data1RegistryTypeDetail     Value 02.
      88 Data1RegistryTypeTrailler   Value 99.
   03 Data1Company                   PIC 9(003).
   03 Data1UserAccount              PIC X(019).
   03 Data1BirthDate                PIC X(010).
   03 Data1Name                      PIC X(040).
   03 Data1CreditLimit              PIC 9999999.
   03 Data1LimitUsed                PIC +99999.99.
   03 Data1Status OCCURS 4 TIMES.
      05 Data1StatusFlag            PIC X(001).
   03 FILLER                            PIC X(003).

01 Record2.
   03 Data1RegistryType             PIC 9(002).
      88 Data1RegistryTypeHeader     Value 01.
      88 Data1RegistryTypeDetail     Value 02.
      88 Data1RegistryTypeTrailler   Value 99.
   03 Data1CompanyId                   PIC 9(003).
   03 Data1CompanyIdRed REDEFINES
      Data1CompanyId                   PIC X(003).
   03 Data1UserAccount              PIC X(019).
   03 Data1BirthDate                PIC X(010).
   03 Data1Name                      PIC X(040).
   03 Data1CreditLimit              PIC 9999999.
   03 Data1LimitUsed                PIC +99999.99.
   03 Data1Status OCCURS 4 TIMES.
      05 Data1StatusFlag            PIC X(001).
   03 FILLER                            PIC X(003).
