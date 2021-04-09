// Generated from Conditions.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConditionsParser}.
 */
public interface ConditionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConditionsParser#ruleConditions}.
	 * @param ctx the parse tree
	 */
	void enterRuleConditions(ConditionsParser.RuleConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionsParser#ruleConditions}.
	 * @param ctx the parse tree
	 */
	void exitRuleConditions(ConditionsParser.RuleConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionRelop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionRelop(ConditionsParser.ConditionRelopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionRelop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionRelop(ConditionsParser.ConditionRelopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionFunction}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionFunction(ConditionsParser.ConditionFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionFunction}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionFunction(ConditionsParser.ConditionFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionParenthetical}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionParenthetical(ConditionsParser.ConditionParentheticalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionParenthetical}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionParenthetical(ConditionsParser.ConditionParentheticalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterNot(ConditionsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitNot(ConditionsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionOperation(ConditionsParser.ConditionOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionOperation(ConditionsParser.ConditionOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ConditionsParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ConditionsParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ConditionsParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ConditionsParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthetical(ConditionsParser.ParentheticalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthetical(ConditionsParser.ParentheticalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(ConditionsParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(ConditionsParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ConditionsParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ConditionsParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRuleVariable(ConditionsParser.RuleVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRuleVariable(ConditionsParser.RuleVariableContext ctx);
}