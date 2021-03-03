// Generated from Arithmetic.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(ArithmeticParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(ArithmeticParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ArithmeticParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ArithmeticParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(ArithmeticParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(ArithmeticParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNum(ArithmeticParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNum(ArithmeticParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(ArithmeticParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(ArithmeticParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthetical(ArithmeticParser.ParentheticalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthetical}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthetical(ArithmeticParser.ParentheticalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exponential}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExponential(ArithmeticParser.ExponentialContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exponential}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExponential(ArithmeticParser.ExponentialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ArithmeticParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ArithmeticParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRuleVariable(ArithmeticParser.RuleVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RuleVariable}
	 * labeled alternative in {@link ArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRuleVariable(ArithmeticParser.RuleVariableContext ctx);
}