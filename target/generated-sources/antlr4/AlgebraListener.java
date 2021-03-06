// Generated from Algebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlgebraParser}.
 */
public interface AlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlgebraParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(AlgebraParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgebraParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(AlgebraParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInteger(AlgebraParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInteger(AlgebraParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction(AlgebraParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction(AlgebraParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AlgebraParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AlgebraParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(AlgebraParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(AlgebraParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthetical(AlgebraParser.ParentheticalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthetical(AlgebraParser.ParentheticalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation(AlgebraParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation(AlgebraParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary(AlgebraParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link AlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary(AlgebraParser.UnaryContext ctx);
}