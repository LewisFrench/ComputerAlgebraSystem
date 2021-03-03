package Conditions;
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
	 * Enter a parse tree produced by the {@code Relop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterRelop(ConditionsParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitRelop(ConditionsParser.RelopContext ctx);
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
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ConditionsParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ConditionsParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ConditionsParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ConditionsParser.NumberContext ctx);
}