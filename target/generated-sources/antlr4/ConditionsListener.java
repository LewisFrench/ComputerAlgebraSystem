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
	 * Enter a parse tree produced by the {@code expr}
	 * labeled alternative in {@link ConditionsParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ConditionsParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link ConditionsParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ConditionsParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionsParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(ConditionsParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionsParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(ConditionsParser.CompileUnitContext ctx);
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
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(ConditionsParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(ConditionsParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNum(ConditionsParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNum(ConditionsParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPow(ConditionsParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPow(ConditionsParser.PowContext ctx);
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