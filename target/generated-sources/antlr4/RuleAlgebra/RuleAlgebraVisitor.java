package RuleAlgebra;
// Generated from RuleAlgebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleAlgebraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RuleAlgebraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RuleAlgebraParser#ruleTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleTerm(RuleAlgebraParser.RuleTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(RuleAlgebraParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(RuleAlgebraParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(RuleAlgebraParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(RuleAlgebraParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthetical(RuleAlgebraParser.ParentheticalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(RuleAlgebraParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(RuleAlgebraParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleVariable(RuleAlgebraParser.RuleVariableContext ctx);
}