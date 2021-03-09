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

		//String[] strRules = { "d($A) = 1.01", "d($A + $B) = d($A) + d($B)"  };
		
		//String[] strRules = { "d($A + $B) = d($A) + d($B)"  };
		//String[] strRules = {"d(ln($x)) = d($x) + $x"};
		String[] strRules = {"func($x, $y, $x) = $x"};
		//String[] strRules = {"fib(0) = 0" , "fib(1) = 1", "fib($n) = fib($n-1) + fib($n-2)"};

		

		//String[] strRules = {"d($n) = $n if x+2 != $n"};
		
		ArrayList<Rule> rules = new ArrayList<>();
		String[] splitRule = new String[3];
		
		for (String rule : strRules) {
			
			splitRule = rule.split("(=|\\sif\\s)", 3);
			System.out.println(Arrays.toString(splitRule));
			ArithmeticParser lhsParser = getParser(splitRule[0]);
			CompileUnitContext lhsAST = lhsParser.compileUnit();
			ArithmeticParser rhsParser = getParser(splitRule[1]);
			CompileUnitContext rhsAST = rhsParser.compileUnit();

			if (splitRule.length >2) {
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();
				rules.add(new Rule(lhsAST, rhsAST, conditionsAST));
			} else {
				rules.add(new Rule(lhsAST, rhsAST));
			}
			
		}
		
		//String expression = "d(x+2)";
		String expression = "func(4*u,4*x, 4*u)";
		ArithmeticParser parser = getParser(expression);
		CompileUnitContext antlrAST = parser.compileUnit();

		ExpressionNode ast = new BuildAstVisitor(rules, 0).visitCompileUnit(antlrAST);
		System.out.println(ast.toString() + "  " + ast.getClass());
		String value = new EvaluateExpressionVisitor().Visit(ast);
		System.out.println("\n\n- - - - Evaluated Value - - - -\n\n" + value);
	

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
	ExpressionNode conditionsNode;
	LinkedHashMap<String, ExpressionNode> variables;

	public Rule(CompileUnitContext lhs, CompileUnitContext rhs, RuleConditionsContext conditions) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = conditions;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visitCompileUnit(lhs);
		//this.conditionsNode = new BuildConditionsVisitor()
	}
	public Rule(CompileUnitContext lhs, CompileUnitContext rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = null;
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
