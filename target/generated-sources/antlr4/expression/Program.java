package expression;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;
import Arithmetic.ArithmeticParser.CompileUnitContext;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;
import Conditions.ConditionsParser.RuleConditionsContext;

public class Program {

	public static void main(String[] args) {

		ArrayList<String> strRules = new ArrayList<>();
		try {
			Path path = Paths.get(args[0]);
			Files.lines(path).map(s -> s.trim()).filter(s -> !s.isEmpty()).forEach(strRules::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("START");
		ArrayList<Rule> rules = new ArrayList<>();

		for (String rule : strRules) {

			String[] splitRule = splitRuleString(rule);
			System.out.println(Arrays.toString(splitRule));

			if (splitRule.length <= 1 || splitRule.length > 3) {
				// throw new RuleFormatException();
				System.out.println("RuleFormatException");
			}
			ArithmeticParser lhsParser = getParser(splitRule[0]);
			CompileUnitContext lhsAST = lhsParser.compileUnit();

			ArithmeticParser rhsParser = getParser(splitRule[1]);
			CompileUnitContext rhsAST = rhsParser.compileUnit();

			if (splitRule.length == 3) {
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();
				rules.add(new Rule(lhsAST, rhsAST, conditionsAST));
			} else {
				rules.add(new Rule(lhsAST, rhsAST));
			}

		}
		System.out.println("Enter a term:\n");
		Scanner scanner = new Scanner(System.in);
		boolean userEnds = false;
		while (!userEnds) {
			String term = scanner.nextLine();
			if (!(term.equals("end"))) {
				// System.out.println("\nTerm: " + term + "\nRewrite Process:\n");
				ArithmeticParser parser = getParser(term);
				CompileUnitContext antlrAST = parser.compileUnit();

				ExpressionNode ast = new BuildAstVisitor(rules, 0).visitCompileUnit(antlrAST);
				String value = new EvaluateExpressionVisitor().Visit(ast);
				System.out
						.println("\n- - - - Evaluated Value - - - -\n" + value + "\n- - - - - - - - - - - - - - - -\n");
			} else {
				userEnds = true;
			}
		}
		scanner.close();
	}

	private static String[] splitRuleString(String term) {
		String[] splitByEquals = term.split("=", 2);
		String[] splitByCondition = splitByEquals[1].split("\\sif\\s", 2);
		if (splitByCondition.length > 1) {
			return new String[] { splitByEquals[0], splitByCondition[0], splitByCondition[1] };
		} else {
			return new String[] { splitByEquals[0], splitByCondition[0] };
		}
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
