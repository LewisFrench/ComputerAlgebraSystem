grammar RuleAlgebra;

ruleTerm : expression EOF;

/**
 * Definition of the series of expressions supported in the LHS or RHS of a rewrite rule.
 */
expression
   :  value = VARIABLE  #Variable
   | RULEVARIDENTIFIER value = VARIABLE #RuleVariable
   |  (OP_SUB)? numerator = INTEGER OP_DIV (OP_SUB)? denominator = INTEGER #Rational 
   |  value = INTEGER #Integer
   |  value = DECIMALNUMBER #Decimal
   |  LPAREN expression RPAREN #Parenthetical  
   |  op = (OP_ADD | OP_SUB) expression #Unary
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #Function
   ;
/* Integer definition */
INTEGER
   : UNSIGNED_INTEGER
   ;

/* Decimal number definition: integer each side of decimal point */
 DECIMALNUMBER
   : UNSIGNED_INTEGER (POINT UNSIGNED_INTEGER)
   ;

   
VARIABLE
   : VALID_ID_CHAR+
   ;
   
/* Fragment definition for number comprised of digits 0-9 */
fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;
   
/* Fragment definition of any upper case or lower case character */
fragment VALID_ID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') 
   ;
   
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

/* Ignore whitespace */
WS
   : [ \r\n\t] + -> skip
   ;
   
   