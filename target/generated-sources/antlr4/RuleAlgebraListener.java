// Generated from RuleAlgebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleAlgebraParser}.
 */
public interface RuleAlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RuleAlgebraParser#ruleTerm}.
	 * @param ctx the parse tree
	 */
	void enterRuleTerm(RuleAlgebraParser.RuleTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleAlgebraParser#ruleTerm}.
	 * @param ctx the parse tree
	 */
	void exitRuleTerm(RuleAlgebraParser.RuleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInteger(RuleAlgebraParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInteger(RuleAlgebraParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction(RuleAlgebraParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction(RuleAlgebraParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(RuleAlgebraParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(RuleAlgebraParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rational}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRational(RuleAlgebraParser.RationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rational}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRational(RuleAlgebraParser.RationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(RuleAlgebraParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(RuleAlgebraParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthetical(RuleAlgebraParser.ParentheticalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthetical(RuleAlgebraParser.ParentheticalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation(RuleAlgebraParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation(RuleAlgebraParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary(RuleAlgebraParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary(RuleAlgebraParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRuleVariable(RuleAlgebraParser.RuleVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link RuleAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRuleVariable(RuleAlgebraParser.RuleVariableContext ctx);
}