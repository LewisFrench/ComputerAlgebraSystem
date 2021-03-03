grammar RuleLHS;


lhs : expression;

expression
   :  func = WORD LPAREN  arg = expression( ',' expression)* RPAREN  #FunctionExpression
   |  VARIABLE #Var
   |  value = SCIENTIFIC_NUMBER #Num	
   ;   
   
   
   
   
VARIABLE : VARID WORD ;
   
   
WORD
   : VALID_ID_START VALID_ID_CHAR*
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;

fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;
   
   
   
SCIENTIFIC_NUMBER
   : NUMBER ( SIGN? UNSIGNED_INTEGER)?
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



   
VARID
   : '$'
   ;   
   
LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;
   
   
COMMA
   : ','
   ;
   
WS
   : [ \r\n\t] + -> skip
   ;