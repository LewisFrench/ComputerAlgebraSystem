package expression;

import java.util.ArrayList;
import java.util.Arrays;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;
import Algebra.AlgebraParser.TermContext;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;
import Conditions.ConditionsParser.RuleConditionsContext;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;
import RuleAlgebra.RuleAlgebraParser.RuleTermContext;

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

				RuleAlgebraParser lhsParser = getRuleParser(splitRule[0]);
				RuleTermContext lhsAST = lhsParser.ruleTerm();
				RuleAlgebraParser rhsParser = getRuleParser(splitRule[1]);
				RuleTermContext rhsAST = rhsParser.ruleTerm();

				if (splitRule.length == 3) {
					ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
					RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();
					rules.add(new Rule(lhsAST, rhsAST, conditionsAST));
				} else {
					rules.add(new Rule(lhsAST, rhsAST));
				}
			}
			AlgebraParser parser = getTermParser(term);
			TermContext antlrAST = parser.term();
			ExpressionNode ast = new BuildTermVisitor().visitTerm(antlrAST);
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

				RuleAlgebraParser lhsParser = getRuleParser(splitRule[0]);
				RuleTermContext lhsAST = lhsParser.ruleTerm();
				RuleAlgebraParser rhsParser = getRuleParser(splitRule[1]);
				RuleTermContext rhsAST = rhsParser.ruleTerm();

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
			System.out.println("Exception here");
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

	private static RuleAlgebraParser getRuleParser(String expression) {

		RuleAlgebraParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		RuleAlgebraLexer lexer = new RuleAlgebraLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new RuleAlgebraParser(tokens);
		return parser;
	}

	
	private static AlgebraParser getTermParser(String expression) {

		AlgebraParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		AlgebraLexer lexer = new AlgebraLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new AlgebraParser(tokens);
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
