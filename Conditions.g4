grammar Conditions;
import Arithmetic;


ruleConditions: condition;
	
condition
	: left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	| LPAREN condition RPAREN #ConditionParenthetical
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
    |  left = condExpr relop=(RELOP_EQ | RELOP_NEQ | RELOP_GT | RELOP_GTE | RELOP_LT | RELOP_LTE) right =condExpr  #Relop
	| function = VARIABLE LPAREN arguments=condExpr ( ',' condExpr)* RPAREN #Function
	;

condExpr
   : expression #expr;

RELOP_GT: '>';
RELOP_LT: '<';
RELOP_EQ: '==';
RELOP_NEQ: '!=';
RELOP_GTE: '>=';
RELOP_LTE: '<=';

OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';