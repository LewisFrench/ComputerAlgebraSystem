// Generated from Conditions.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConditionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConditionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConditionsParser#ruleConditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleConditions(ConditionsParser.RuleConditionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ConditionsParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ConditionsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(ConditionsParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrCondition}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondition(ConditionsParser.OrConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndCondition}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondition(ConditionsParser.AndConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ConditionsParser.NumberContext ctx);
}