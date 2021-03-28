package expression;

import java.util.ArrayList;
import java.util.Arrays;
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
	public Program() {
		
	}

	public String Rewrite(ArrayList<String> strRules, String term) {
		String outputValue = "";
		ArrayList<Rule> rules = new ArrayList<>();
		String[] splitRule;
		try {
			for (String rule : strRules) {
				splitRule = splitRuleString(rule);
				System.out.println(Arrays.toString(splitRule));

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
			ArithmeticParser parser = getParser(term);
			CompileUnitContext antlrAST = parser.compileUnit();
			ExpressionNode ast = new BuildAstVisitor().visitCompileUnit(antlrAST);
			ExpressionNode ast2 = new RewriteProcess(rules).Visit(ast);
			outputValue = new EvaluateExpressionVisitor().Visit(ast2);
		} catch (Exception e) {

		}

		return outputValue;
	}

	public static ArrayList<Rule> loadRules(String[] ruleInput) {

		ArrayList<Rule> rules = new ArrayList<>();
		String[] splitRule;
		try {
			for (String rule : ruleInput) {
				splitRule = splitRuleString(rule);
				System.out.println(Arrays.toString(splitRule));

				ArithmeticParser lhsParser = getParser(splitRule[0]);
				CompileUnitContext lhsAST = lhsParser.compileUnit();
				ArithmeticParser rhsParser = getParser(splitRule[1]);
				CompileUnitContext rhsAST = rhsParser.compileUnit();

				if (splitRule.length == 3) {
					ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
					RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();
					rules.add(new Rule(lhsAST, rhsAST, conditionsAST));
				} else if (splitRule.length == 2) {
					rules.add(new Rule(lhsAST, rhsAST));
				} else {
					System.out.println("Incorrect rule exists");
				}

			}
		} catch (Exception e) {
			System.out.println("Fucked it");
		}
		return rules;
	}

	private static String[] splitRuleString(String term) throws Exception {
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
