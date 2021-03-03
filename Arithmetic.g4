grammar Arithmetic;

compileUnit : expression;

expression
   :  func = VARIABLE LPAREN  arguments =  expression( ',' expression)* RPAREN #FunctionExpression
   |  base = expression OP_EXP exponent = expression #Exponential
   |  op = (OP_ADD | OP_SUB) expression #UnaryExpression
   |  LPAREN expression RPAREN #Parenthetical
   |  left = expression  op = (OP_MUL | OP_DIV) right = expression #Operation
   |  left = expression  op = (OP_ADD | OP_SUB) right = expression #Operation
   |  value = VARIABLE #Var
   |  '$' value=VARIABLE #RuleVariable
   |  value = SCIENTIFIC_NUMBER #Num
   ;
   
  
   
OP_EXP: '^';
OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';

RELOP_EQ: '=';
RELOP_LT: '<';
RELOP_GT: '>';

VARIABLE
   : VALID_ID_START VALID_ID_CHAR*
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;

fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;

//The NUMBER part gets its potential sign from "(PLUS | MINUS)* atom" in the expression rule
SCIENTIFIC_NUMBER
   : NUMBER (E SIGN? UNSIGNED_INTEGER)?
   ;

fragment NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;


fragment E
   : 'E' | 'e'
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

POINT
   : '.'
   ;

POW
   : '^'
   ;

WS
   : [ \r\n\t] + -> skip
   ;