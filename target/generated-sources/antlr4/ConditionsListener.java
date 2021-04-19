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
	 * Enter a parse tree produced by the {@code ConditionNotOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionNotOperation(ConditionsParser.ConditionNotOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionNotOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionNotOperation(ConditionsParser.ConditionNotOperationContext ctx);
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
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ConditionsParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ConditionsParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ConditionsParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ConditionsParser.FunctionContext ctx);
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
	 * Enter a parse tree produced by the {@code Rational}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRational(ConditionsParser.RationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rational}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRational(ConditionsParser.RationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(ConditionsParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(ConditionsParser.DecimalContext ctx);
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
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ConditionsParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ConditionsParser.UnaryContext ctx);
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