grammar RuleAlgebra;

ruleTerm : expression EOF;

expression
   :  value = VARIABLE  #Variable
   | VARIDENTIFIER value = VARIABLE #RuleVariable
   |  ('-')? numerator = INTEGER '/' ('-')? denominator = INTEGER #Rational 
   |  value = INTEGER #Integer
   |  value = DECIMALNUMBER #Decimal
   |  LPAREN expression RPAREN #Parenthetical  
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #FunctionExpression
   ;
   
OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';
OP_POW: '^';

VARIABLE
   : VALID_ID_CHAR+
   ;

fragment VALID_ID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') 
   ;

 INTEGER
   : UNSIGNED_INTEGER
   ;


 DECIMALNUMBER
   : UNSIGNED_INTEGER ('.' UNSIGNED_INTEGER)
   ;

fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
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