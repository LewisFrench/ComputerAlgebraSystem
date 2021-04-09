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
	 * Visit a parse tree produced by the {@code ConditionRelop}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionRelop(ConditionsParser.ConditionRelopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionFunction}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionFunction(ConditionsParser.ConditionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionParenthetical}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionParenthetical(ConditionsParser.ConditionParentheticalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ConditionsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOperation(ConditionsParser.ConditionOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(ConditionsParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ConditionsParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthetical(ConditionsParser.ParentheticalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(ConditionsParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(ConditionsParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleVariable(ConditionsParser.RuleVariableContext ctx);
}