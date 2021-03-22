grammar Arithmetic;

compileUnit : expression;

expression
   :  func = VARIABLE LPAREN  arguments =  expression( COMMA expression)* RPAREN #FunctionExpression
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   |  LPAREN expression RPAREN #Parenthetical
   |  left = expression  OP_POW right = expression #Power
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  value = VARIABLE #Variable
   |   VARIDENTIFIER value = VARIABLE #RuleVariable
   |  value = NUMBER #Number
   ;
   
OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';
OP_POW: '^';

VARIABLE
   : VALID_ID_START VALID_ID_CHAR*
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;

fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;

 NUMBER
   : UNSIGNED_INTEGER ('.' UNSIGNED_INTEGER)?
   ;

fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;

fragment SIGN
   : ('+' | '-')
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