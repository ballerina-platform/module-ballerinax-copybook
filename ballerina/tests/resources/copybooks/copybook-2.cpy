01 DATA1-DETAIL-REGISTRY.
   03 DATA1-REGISTRY-TYPE             PIC 9(002).
      88 DATA1-REGISTRY-TYPE-HEADER     VALUE 01.
      88 DATA1-REGISTRY-TYPE-DETAIL     VALUE 02.
      88 DATA1-REGISTRY-TYPE-TRAILLER   VALUE 99.
   03 DATA1-COMPANY                   PIC 9(003).
   03 DATA1-USER-ACCOUNT              PIC X(019).
   03 DATA1-BIRTH-DATE                PIC X(010).
   03 DATA1-NAME                      PIC X(040).
   03 DATA1-CREDIT-LIMIT              PIC 9999999.
   03 DATA1-LIMIT-USED                PIC +99999.99.
   03 DATA1-STATUS OCCURS 4 TIMES.
      05 DATA1-STATUS-FLAG            PIC X(001).
   03 FILLER                            PIC X(003).
