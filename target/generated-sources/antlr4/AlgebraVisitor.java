// Generated from Algebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgebraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgebraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgebraParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(AlgebraParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(AlgebraParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AlgebraParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(AlgebraParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(AlgebraParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthetical(AlgebraParser.ParentheticalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(AlgebraParser.OperationContext ctx);
}