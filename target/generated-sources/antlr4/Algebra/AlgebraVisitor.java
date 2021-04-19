package Algebra;
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
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(AlgebraParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(AlgebraParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AlgebraParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rational}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRational(AlgebraParser.RationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(AlgebraParser.DecimalContext ctx);
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
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(AlgebraParser.UnaryContext ctx);
}