grammar Conditions;
import Arithmetic;


ruleConditions: condition;
	
condition
	: left = condition op = (OP_AND | OP_OR) right = condition #ConditionOperation
	| LPAREN condition RPAREN #ConditionParenthetical
	|  OP_NOT  LPAREN  value = condition RPAREN #Not
    |  left = condExpr relop=(RELOP_GT | RELOP_LT | RELOP_EQ) right =condExpr  #Relop
	| function = VARIABLE LPAREN value=condExpr RPAREN #Function
	;

condExpr
   : expression #expr;

// Handling is_literal( expression ) 
// Can handle numbers, variables as per above implementation not anything more complicated e.g. (x + 2 + y)

RELOP_GT: '>';
RELOP_LT: '<';
RELOP_EQ: '==';

OP_AND: '&';
OP_OR: '|';
OP_NOT: '!';