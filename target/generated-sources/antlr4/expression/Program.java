package expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;
import Arithmetic.ArithmeticParser.CompileUnitContext;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;
import Conditions.ConditionsParser.RuleConditionsContext;

/**
 * Things to do
 * 
 * 
 * 
 * Further abstract class removing repeated code in the BuildXyzVisitors
 * 
 * @author lewis
 *
 */

public class Program {

	public static void main(String[] args) {
		/*
		 * String[] strRules = {"sumOfSquares($n, $m, 0, $a) = sumOfSquares(0, $n, $m)",
		 * "sumOfSquares($n, $m, $a) = sumOfSquares($m,$a)",
		 * "sumOfSquares($n, $m) = $n*$n + $m*$m" };
		 * 
		 */
		// String[] strRules = { "fib(0)=0", "fib(1)=1", "fib($n)=fib($n-1) + fib($n-2)"
		// };
		// String[] strRules = { "func($a, 0) = func($a)" , "func($a) = 4" };
		// String[] strRules = { "lucas(0) = 2" , "lucas(1) = 1", "lucas($n) =
		// lucas($n-2) + lucas($n-1)" };
		//String[] strRules = { "testFunc($n) = 2 + $n if !(is_Integer($n))" };
		String[] strRules = { "d($x) = 4 if 3 > 2" };
		ArrayList<Rule> rules = new ArrayList<>();
		String[] splitRule = new String[3];
		for (String rule : strRules) {

			splitRule = rule.split("(=|if)", 3);
			for (String s : splitRule) {
				System.out.println(s);
			}
			ArithmeticParser lhsParser = getParser(splitRule[0]);
			CompileUnitContext lhsAST = lhsParser.compileUnit();
			ArithmeticParser rhsParser = getParser(splitRule[1]);
			CompileUnitContext rhsAST = rhsParser.compileUnit();

			System.out.println(Arrays.toString(splitRule));
			ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
			RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();
			
			// Muust account for a rule having no condition
			rules.add(new Rule(lhsAST, rhsAST, conditionsAST));
		}
		;

		String expression = "d(ln($x))";
		ArithmeticParser parser = getParser(expression);
		CompileUnitContext antlrAST = parser.compileUnit();

		ExpressionNode ast = new BuildAstVisitor(rules).visitCompileUnit(antlrAST);
		System.out.println(ast.toString());
		System.out.println("\n\nEVALUATING");
		String value = new EvaluateExpressionVisitor().Visit(ast);
	

	}

	private static ArithmeticParser getParser(String expression) {

		ArithmeticParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		ArithmeticLexer lexer = new ArithmeticLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ArithmeticParser(tokens);
		return parser;
	}

	private static ConditionsParser getConditionsParser(String expression) {

		ConditionsParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		ConditionsLexer lexer = new ConditionsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ConditionsParser(tokens);
		return parser;
	}
}

class Rule {
	CompileUnitContext lhs;
	CompileUnitContext rhs;
	RuleConditionsContext conditions;
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	LinkedHashMap<String, ExpressionNode> variables;

	public Rule(CompileUnitContext lhs, CompileUnitContext rhs, RuleConditionsContext conditions) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = conditions;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visitCompileUnit(lhs);
	}

	public String toString() {
		return (this.lhs.getText() + " = " + this.rhs.getText());
	}

	public ExpressionNode getLhsNode() {
		return this.lhsNode;

	}

}
