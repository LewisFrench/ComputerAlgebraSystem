grammar Algebra;

term : expression EOF;

expression
   :  LPAREN expression RPAREN #Parenthetical  
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #FunctionExpression
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   |  value = VARIABLE  #Variable
   |  value = NUMBER #Number
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

 NUMBER
   : UNSIGNED_INTEGER ('.' UNSIGNED_INTEGER)?
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