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
	 * Visit a parse tree produced by the {@code ConditionNotOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNotOperation(ConditionsParser.ConditionNotOperationContext ctx);
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
	 * Visit a parse tree produced by the {@code ConditionOperation}
	 * labeled alternative in {@link ConditionsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOperation(ConditionsParser.ConditionOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(ConditionsParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ConditionsParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ConditionsParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(ConditionsParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthetical(ConditionsParser.ParentheticalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(ConditionsParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(ConditionsParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ConditionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleVariable(ConditionsParser.RuleVariableContext ctx);
}