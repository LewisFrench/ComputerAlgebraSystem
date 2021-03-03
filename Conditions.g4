grammar Conditions;


ruleConditions: condition;
	
condition
	: left = condition op = OP_AND  right = condition #AndCondition
	| left = condition op = OP_OR right = condition #OrCondition
    |  left = var relop=(RELOP_GT | RELOP_LT | RELOP_EQ) right =var  #Relop
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
	| function = FUNCTION LPAREN value=var RPAREN #Function
	;


var
   : value = VARIABLE #Variable
   | value = SCIENTIFIC_NUMBER #Number; 

/*

condition
	: left = condition op = OP_AND  right = condition #AndCondition
	| left = condition op = OP_OR right = condition #OrCondition
	|  left = VARIABLE relop=(RELOP_GT | RELOP_LT | RELOP_EQ) right =SCIENTIFIC_NUMBER #Relop
	|  left = SCIENTIFIC_NUMBER relop=(RELOP_GT | RELOP_LT | RELOP_EQ) right =VARIABLE #Relop
	| OP_NOT  LPAREN condition RPAREN #Not
	| function = FUNCTION LPAREN value=VARIABLE RPAREN #Function
	| VARIABLE #Variable
	//| value = SCIENTIFIC_NUMBER #Num
	;

*/

RELOP_GT: '>';
RELOP_LT: '<';
RELOP_EQ: '==';


OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';

VARIABLE : '$' FUNCTION;

FUNCTION
   : VALID_ID_START+
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;
   
SCIENTIFIC_NUMBER
   : NUMBER (SIGN? UNSIGNED_INTEGER)?
   ;

fragment NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;


fragment SIGN
   : ('+' | '-')
   ;
   
LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;
   
   
   
   
   
WS
   : [ \r\n\t] + -> skip
   ;