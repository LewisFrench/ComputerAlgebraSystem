grammar RuleAlgebra;

ruleTerm : expression EOF;

expression
   :  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #FunctionExpression
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   |  LPAREN expression RPAREN #Parenthetical
   |  left = expression  op = OP_POW right = expression #Operation
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  value = VARIABLE #Variable
   | VARIDENTIFIER value = VARIABLE #RuleVariable
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