grammar Conditions;

ruleConditions: condition;
	
condition
	: left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	| LPAREN condition RPAREN #ConditionParenthetical
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
    |  left = var relop=(RELOP_GT | RELOP_LT | RELOP_EQ) right =var  #Relop
	| function = FUNCTION LPAREN value=var RPAREN #Function
	;

var
   : value = VARIABLE #Variable
   | value = SCIENTIFIC_NUMBER #Number; 

// Handling is_literal( expression ) 
// Can handle numbers, variables as per above implementation not anything more complicated e.g. (x + 2 + y)

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