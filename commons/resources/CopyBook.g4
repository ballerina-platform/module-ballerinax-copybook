grammar CopyBook;
@header {package io.ballerina.lib.copybook.commons.generated;}

@members {
    int redefinesUsed = 0;
    int blankWhenZeroUsed = 0;
    int externalUsed = 0;
    int globalUsed = 0;
    int justifiedUsed = 0;
    int occursUsed = 0;
    int pictureUsed = 0;
    int signUsed = 0;
    int synchronizedUsed = 0;
    int usageUsed = 0;
    int dataValueUsed = 0;
}

startRule : dataDescription EOF;

dataDescription
   : dataDescriptionEntry+
   ;

dataDescriptionEntry
   : dataDescriptionEntryFormat1 | dataDescriptionEntryFormat2 | dataDescriptionEntryFormat3 | COMMENT
   ;

dataDescriptionEntryFormat1
   : (INTEGERLITERAL | LEVEL_NUMBER_77) (FILLER | dataName)? dataDescriptionEntryClauses DOT_FS
   ;

dataDescriptionEntryClauses:
    (
      {redefinesUsed == 0}? dataRedefinesClause {redefinesUsed++;}
    | {externalUsed == 0}? dataExternalClause {externalUsed++;}
    | {globalUsed == 0}? dataGlobalClause {globalUsed++;}
    | {pictureUsed == 0}? dataPictureClause {pictureUsed++;}
    | {usageUsed == 0}? dataUsageClause {usageUsed++;}
    | {dataValueUsed == 0}? dataValueClause {dataValueUsed++;}
    | {occursUsed == 0}? dataOccursClause {occursUsed++;}
    | {signUsed == 0}? dataSignClause {signUsed++;}
    | {synchronizedUsed == 0}? dataSynchronizedClause {synchronizedUsed++;}
    | {justifiedUsed == 0}? dataJustifiedClause {justifiedUsed++;}
    | {blankWhenZeroUsed == 0}? dataBlankWhenZeroClause {blankWhenZeroUsed++;}
    )*
     {
        redefinesUsed = 0;
        blankWhenZeroUsed = 0;
        externalUsed = 0;
        globalUsed = 0;
        justifiedUsed = 0;
        occursUsed = 0;
        pictureUsed = 0;
        signUsed = 0;
        synchronizedUsed = 0;
        usageUsed = 0;
        dataValueUsed = 0;
    }
    ;

dataDescriptionEntryFormat2
   : LEVEL_NUMBER_66 dataName dataRenamesClause DOT_FS
   ;

dataDescriptionEntryFormat3
   : LEVEL_NUMBER_88 conditionName dataValueClause DOT_FS
   ;

dataBlankWhenZeroClause
   : BLANK WHEN? (ZERO | ZEROS | ZEROES)
   ;

dataExternalClause
   : IS? EXTERNAL (BY literal)?
   ;

dataGlobalClause
   : IS? GLOBAL
   ;

dataJustifiedClause
   : (JUSTIFIED | JUST) RIGHT?
   ;

dataOccursClause
   : OCCURS integerLiteral dataOccursTo? TIMES? (DEPENDING ON? qualifiedDataName)? dataOccursSort* (INDEXED BY? LOCAL? indexName+)?
   ;

dataOccursTo
   : TO integerLiteral
   ;

dataOccursSort
   : (ASCENDING | DESCENDING) KEY? IS? qualifiedDataName+
   ;

dataPictureClause
   : (PICTURE | PIC) IS? pictureString
   ;

pictureString
   : (pictureChars+ pictureCardinality?)+
   ;

pictureChars
   : DOLLARCHAR | IDENTIFIER | NUMERICLITERAL | SLASHCHAR | COMMACHAR | DOT | COLONCHAR | ASTERISKCHAR | DOUBLEASTERISKCHAR | PLUSCHAR | MINUSCHAR | LESSTHANCHAR | MORETHANCHAR | integerLiteral
   ;

pictureCardinality
   : LPARENCHAR integerLiteral RPARENCHAR
   ;

dataRedefinesClause
   : REDEFINES dataName
   ;

dataRenamesClause
   : RENAMES qualifiedDataName ((THROUGH | THRU) qualifiedDataName)?
   ;

dataSignClause
   : (SIGN IS?)? (LEADING | TRAILING) (SEPARATE CHARACTER?)?
   ;

dataSynchronizedClause
   : (SYNCHRONIZED | SYNC) (LEFT | RIGHT)?
   ;

dataUsageClause
   : (USAGE IS?)? (BINARY (TRUNCATED | EXTENDED)? | BIT | COMP | COMP_1 | COMP_2 | COMP_3 | COMP_4 | COMP_5 | COMPUTATIONAL | COMPUTATIONAL_1 | COMPUTATIONAL_2 | COMPUTATIONAL_3 | COMPUTATIONAL_4 | COMPUTATIONAL_5 | CONTROL_POINT | DATE | DISPLAY | DISPLAY_1 | DOUBLE | EVENT | FUNCTION_POINTER | INDEX | KANJI | LOCK | NATIONAL | PACKED_DECIMAL | POINTER | PROCEDURE_POINTER | REAL | TASK)
   ;

dataValueClause
   : (VALUE IS? | VALUES ARE?)? dataValueInterval (COMMACHAR? dataValueInterval)*
   ;

dataValueInterval
   : dataValueIntervalFrom dataValueIntervalTo?
   ;

dataValueIntervalFrom
   : literal | cobolWord
   ;

dataValueIntervalTo
   : (THROUGH | THRU) literal
   ;

// identifier ----------------------------------

identifier
   : qualifiedDataName
   ;

// qualified data name ----------------------------------

qualifiedDataName
   : (dataName | conditionName)
   ;


// names ----------------------------------

conditionName
   : cobolWord
   ;

dataName
   : cobolWord
   ;

indexName
   : cobolWord
   ;

// literal ----------------------------------

cobolWord
   : IDENTIFIER
   ;

literal
   : NONNUMERICLITERAL | figurativeConstant | numericLiteral | booleanLiteral | cicsDfhRespLiteral | cicsDfhValueLiteral
   ;

booleanLiteral
   : TRUE | FALSE
   ;

numericLiteral
   : NUMERICLITERAL | ZERO | integerLiteral
   ;

integerLiteral
   : INTEGERLITERAL | LEVEL_NUMBER_66 | LEVEL_NUMBER_77 | LEVEL_NUMBER_88
   ;

cicsDfhRespLiteral
   : DFHRESP LPARENCHAR (cobolWord | literal) RPARENCHAR
   ;

cicsDfhValueLiteral
   : DFHVALUE LPARENCHAR (cobolWord | literal) RPARENCHAR
   ;

// keywords ----------------------------------

figurativeConstant
   : ALL literal | HIGH_VALUE | HIGH_VALUES | LOW_VALUE | LOW_VALUES | NULL_ | NULLS | QUOTE | QUOTES | SPACE | SPACES | ZERO | ZEROS | ZEROES
   ;

// lexer rules --------------------------------------------------------------------------------

// keywords
ALL : A L L;
ARE : A R E;
ASCENDING : A S C E N D I N G;
BINARY : B I N A R Y;
BIT : B I T;
BLANK : B L A N K;
BY : B Y;
CHANNEL : C H A N N E L;
CHARACTER : C H A R A C T E R;
COBOL : C O B O L;
COMP : C O M P;
COMP_1 : C O M P MINUSCHAR '1';
COMP_2 : C O M P MINUSCHAR '2';
COMP_3 : C O M P MINUSCHAR '3';
COMP_4 : C O M P MINUSCHAR '4';
COMP_5 : C O M P MINUSCHAR '5';
COMPUTATIONAL : C O M P U T A T I O N A L;
COMPUTATIONAL_1 : C O M P U T A T I O N A L MINUSCHAR '1';
COMPUTATIONAL_2 : C O M P U T A T I O N A L MINUSCHAR '2';
COMPUTATIONAL_3 : C O M P U T A T I O N A L MINUSCHAR '3';
COMPUTATIONAL_4 : C O M P U T A T I O N A L MINUSCHAR '4';
COMPUTATIONAL_5 : C O M P U T A T I O N A L MINUSCHAR '5';
CONTROL_POINT : C O N T R O L MINUSCHAR P O I N T;
DATA : D A T A;
DATE : D A T E;
DEPENDING : D E P E N D I N G;
DESCENDING : D E S C E N D I N G;
DFHRESP : D F H R E S P;
DFHVALUE : D F H V A L U E;
DISPLAY : D I S P L A Y;
DISPLAY_1 : D I S P L A Y MINUSCHAR '1';
DOUBLE : D O U B L E;
EVENT : E V E N T;
EXTENDED : E X T E N D E D;
EXTERNAL : E X T E R N A L;
FALSE : F A L S E;
FILLER : F I L L E R;
FULL : F U L L;
FUNCTION_POINTER : F U N C T I O N MINUSCHAR P O I N T E R;
GLOBAL : G L O B A L;
HIGH_VALUE : H I G H MINUSCHAR V A L U E;
HIGH_VALUES : H I G H MINUSCHAR V A L U E S;
INDEX : I N D E X;
INDEXED : I N D E X E D;
INTEGER : I N T E G E R;
IS : I S;
JUST : J U S T;
JUSTIFIED : J U S T I F I E D;
KANJI : K A N J I;
KEY : K E Y;
LEADING : L E A D I N G;
LEFT : L E F T;
LINE : L I N E;
LOCAL : L O C A L;
LOCK : L O C K;
LOW_VALUE : L O W MINUSCHAR V A L U E;
LOW_VALUES : L O W MINUSCHAR V A L U E S;
NATIONAL : N A T I O N A L;
NULL_ : N U L L;
NULLS : N U L L S;
OCCURS : O C C U R S;
OF : O F;
ON : O N;
PACKED_DECIMAL : P A C K E D MINUSCHAR D E C I M A L;
PIC : P I C;
PICTURE : P I C T U R E;
POINTER : P O I N T E R;
PROCEDURE_POINTER : P R O C E D U R E MINUSCHAR P O I N T E R;
QUOTE : Q U O T E;
QUOTES : Q U O T E S;
REAL : R E A L;
REDEFINES : R E D E F I N E S;
RENAMES : R E N A M E S;
RIGHT : R I G H T;
SEPARATE : S E P A R A T E;
SIGN : S I G N;
SPACE : S P A C E;
SPACES : S P A C E S;
STOP : S T O P;
STRING : S T R I N G;
SYNC : S Y N C;
SYNCHRONIZED : S Y N C H R O N I Z E D;
TASK : T A S K;
THROUGH : T H R O U G H;
THRU : T H R U;
TIMES : T I M E S;
TO : T O;
TRAILING : T R A I L I N G;
TRUE : T R U E;
TRUNCATED : T R U N C A T E D;
TYPE : T Y P E;
USAGE : U S A G E;
VALUE : V A L U E;
VALUES : V A L U E S;
WHEN : W H E N;
WITH : W I T H;
ZERO : Z E R O;
ZEROS : Z E R O S;
ZEROES : Z E R O E S;

// symbols
ASTERISKCHAR : '*';
DOUBLEASTERISKCHAR : '**';
COLONCHAR : ':';
COMMACHAR : ',';
DOLLARCHAR : '$';

// period full stop
DOT_FS : '.' ('\r' | '\n' | '\f' | '\t' | ' ')+ | '.' EOF;
DOT : '.';

LESSTHANCHAR : '<';
LPARENCHAR : '(';
MINUSCHAR : '-';
MORETHANCHAR : '>';
PLUSCHAR : '+';
RPARENCHAR : ')';
SLASHCHAR : '/';

// literals
NONNUMERICLITERAL : STRINGLITERAL | DBCSLITERAL | HEXNUMBER  | NULLTERMINATED;

fragment HEXNUMBER :
	X '"' [0-9A-F]+ '"'
	| X '\'' [0-9A-F]+ '\''
;

fragment NULLTERMINATED :
	Z '"' (~["\n\r] | '""' | '\'')* '"'
	| Z '\'' (~['\n\r] | '\'\'' | '"')* '\''
;

fragment STRINGLITERAL :
	'"' (~["\n\r] | '""' | '\'')* '"'
	| '\'' (~['\n\r] | '\'\'' | '"')* '\''
;

fragment DBCSLITERAL :
	[GN] '"' (~["\n\r] | '""' | '\'')* '"'
	| [GN] '\'' (~['\n\r] | '\'\'' | '"')* '\''
;

LEVEL_NUMBER_66 : '66';
LEVEL_NUMBER_77 : '77';
LEVEL_NUMBER_88 : '88';

INTEGERLITERAL : (PLUSCHAR | MINUSCHAR)? [0-9]+;
NUMERICLITERAL : (PLUSCHAR | MINUSCHAR)? [0-9]* (DOT | COMMACHAR) [0-9]+ (('e' | 'E') (PLUSCHAR | MINUSCHAR)? [0-9]+)?;
IDENTIFIER : [a-zA-Z0-9]+ ([-_]+ [a-zA-Z0-9]+)*;

// whitespace, line breaks, comments, ...
NEWLINE : '\r'? '\n' -> channel(HIDDEN);
WS : [ \t\f;]+ -> channel(HIDDEN);
COMMENT:  '*' ~( '\r' | '\n' )* -> skip;

// case insensitive chars
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
