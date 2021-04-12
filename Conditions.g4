grammar Conditions;


ruleConditions: condition EOF;
	
condition
	: left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	| LPAREN condition RPAREN #ConditionParenthetical
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
    |  left = expression relop=(RELOP_EQ | RELOP_NEQ | RELOP_GT | RELOP_GTE | RELOP_LT | RELOP_LTE) right =expression  #ConditionRelop
	| function = CONDITION_VARIABLE LPAREN arguments= expression ( ',' expression)* RPAREN #ConditionFunction
	;

expression
   :  value = VARIABLE  #Variable
   | ('-')? numerator = INTEGER '/' ('-')? denominator = INTEGER #Rational
   | VARIDENTIFIER value = VARIABLE #RuleVariable
   |  value = DECIMALNUMBER #Decimal
   |  value = INTEGER #Integer
   |  LPAREN expression RPAREN #Parenthetical  
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #FunctionExpression
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   ;
   
OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';
OP_POW: '^';


RELOP_EQ: '==';
RELOP_NEQ: '!=';
RELOP_GT: '>';
RELOP_GTE: '>=';
RELOP_LT: '<';
RELOP_LTE: '<=';

OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';

 INTEGER
   : UNSIGNED_INTEGER
   ;

 DECIMALNUMBER
   : UNSIGNED_INTEGER ('.' UNSIGNED_INTEGER)
   ;
fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;


CONDITION_VARIABLE
   : '_'VALID_CONDITION_CHAR+
   ;

fragment VALID_CONDITION_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') | '_' 
   ;
   
VARIABLE
   : VALID_CONDITION_CHAR+
   ;

fragment VALID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z')  
   ;
      
      
COMMA
   : ','
   ;

LPAREN
   : '('
   ;

VARIDENTIFIER
   : '$' 
   ;

RPAREN
   : ')'
   ;

POINT
   : '.'
   ;

WS
   : [ \r\n\t] + -> skip
   ;