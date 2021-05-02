grammar Algebra;

term : expression EOF;

/**
 * Definition of the series of algebraic expressions supported by the system
 */
expression
   // Define terminal symbols 
   :  value = VARIABLE  #Variable 
   |  value = INTEGER #Integer
   |  value = DECIMALNUMBER #Decimal
   // Priority for parentheses to alter order of operations
   |  LPAREN expression RPAREN #Parenthetical  
   // Maintain order of operations for mathematical operations
   |  <assoc=right> left = expression  op = OP_POW right = expression #Operation
   |  op = (OP_ADD | OP_SUB) expression #Unary
   |  <assoc=left> left = expression  op = (OP_MUL| OP_DIV) right = expression #Operation
   |  <assoc=left> left = expression  op = (OP_ADD|OP_SUB) right = expression #Operation
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
   

/* Ignore whitespace */
WS
   : [ \r\n\t] + -> skip
   ;