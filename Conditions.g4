grammar Conditions;
import RuleAlgebra;


ruleConditions: condition;
	
condition
	: left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	| LPAREN condition RPAREN #ConditionParenthetical
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
    |  left = condExpr relop=(RELOP_EQ | RELOP_NEQ | RELOP_GT | RELOP_GTE | RELOP_LT | RELOP_LTE) right =condExpr  #ConditionRelop
	| function = VARIABLE LPAREN arguments=condExpr ( ',' condExpr)* RPAREN #ConditionFunction
	;

condExpr
   : expression #Expression;
   


RELOP_EQ: '==';
RELOP_NEQ: '!=';
RELOP_GT: '>';
RELOP_GTE: '>=';
RELOP_LT: '<';
RELOP_LTE: '<=';

OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';

VARIABLE
   : VALID_ID_CHAR+
   ;

fragment VALID_ID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') | '_' 
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