grammar Conditions;
ruleConditions: condition EOF;
	
/**
* Definition of the symbols used to build the conditions of a rule.
*/
condition
	: LPAREN condition RPAREN #ConditionParenthetical
	| left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	|  OP_NOT value = condition  #ConditionNotOperation
    |  left = expression relop=(RELOP_EQ | RELOP_NEQ | RELOP_GT | RELOP_GTE | RELOP_LT | RELOP_LTE) right =expression  #ConditionRelop
	| function = CONDITION_VARIABLE LPAREN arguments= expression ( COMMA expression)* RPAREN #ConditionFunction
	;
	
/**
 * Definition of the expressions that can be compared and evaluated in the conditions of a rule
 */
expression
   :  value = VARIABLE  #Variable
   | RULEVARIDENTIFIER value = VARIABLE #RuleVariable
   //|  numerator = INTEGER OP_DIV denominator = INTEGER #Rational 
   |  value = INTEGER #Integer
   |  value = DECIMALNUMBER #Decimal
   |  LPAREN expression RPAREN #Parenthetical  
   |  op = (OP_ADD | OP_SUB) expression #Unary
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #Function
   ;
   

/* Word comprised of upper case or lower case characters
 * Beginning with an underscore
 */
CONDITION_VARIABLE
   : UNDERSCORE VALID_CONDITION_CHAR+
   ;
   
   /* Word comprised of upper case or lower case characters */
VARIABLE
   : VALID_CONDITION_CHAR+
   ;
   
   
/* Integer definition */
INTEGER
   : UNSIGNED_INTEGER
   ;

/* Decimal number definition: integer each side of decimal point */
 DECIMALNUMBER
   : UNSIGNED_INTEGER (POINT UNSIGNED_INTEGER)
   ;




fragment VALID_CONDITION_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') | '_' 
   ;
   
fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;
   
fragment VALID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z')  
   ;
      
/* Relop symbol definition */
RELOP_EQ: '==';
RELOP_NEQ: '!=';
RELOP_GT: '>';
RELOP_GTE: '>=';
RELOP_LT: '<';
RELOP_LTE: '<=';

/* Logical operation symbol definition */
OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';
      
     
/* Operation symbol definition */   
OP_POW: '^';
OP_MUL: '*';
OP_DIV: '/';
OP_ADD: '+';
OP_SUB: '-';

/*Miscellaneous symbol definition */
COMMA: 	',';
LPAREN: '(';
RPAREN: ')';
POINT: 	'.'; 
RULEVARIDENTIFIER: '$';
UNDERSCORE: '_';

/* Ignore whitespace */
WS
   : [ \r\n\t] + -> skip
   ;