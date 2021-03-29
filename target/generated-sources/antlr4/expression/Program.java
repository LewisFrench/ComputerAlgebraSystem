package expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.LinkedHashMap;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

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

	public static void main(String[] args) {
		GUI g = new GUI();
	}

	public String Rewrite(ArrayList<Rule> rules, ExpressionNode termAst) {
		String outputValue = "";
		try {
			ExpressionNode ast2 = new RewriteProcess(rules).Visit(termAst);
			outputValue = new EvaluateExpressionVisitor().Visit(ast2);
		} catch (Exception e) {
			System.out.println("Rewrite Error Thrown");
		}

		return outputValue;
	}

	private static String[] splitRuleString(String term) throws Exception {
		term = term.replaceAll(" ", "");
		String[] splitByEquals = term.split("=", 2);
		if (splitByEquals.length != 2) {
			throw new Exception("All rules must contain a '=' symbol");
		}
		String[] splitByCondition = splitByEquals[1].split(":", 2);
		if (splitByCondition.length > 1) {
			System.out.println("RuleHasConditions");
			return new String[] { splitByEquals[0], splitByCondition[0], splitByCondition[1] };
		} else {
			return new String[] { splitByEquals[0], splitByCondition[0] };
		}
	}

	public Rule parseRule(String ruleInput) throws ParseCancellationException, Exception {
		Rule r = null;
		if (ruleInput.replaceAll(" ", "").equals("") || ruleInput.equals(null)) {
			throw new Exception("File contains no rules");
		}
		String[] splitRule;
		try {

			// Catch format exception here
			splitRule = splitRuleString(ruleInput);
			
			System.out.println(Arrays.deepToString(splitRule));
			RuleAlgebraParser lhsParser = getRuleParser(splitRule[0]);
			RuleAlgebraParser rhsParser = getRuleParser(splitRule[1]);

			// See if I can get an exception going here, my be difficult
			RuleTermContext lhs = lhsParser.ruleTerm();
			RuleTermContext rhs = rhsParser.ruleTerm();

			ExpressionNode lhsNode = new BuildLhsVisitor(new LinkedHashMap<String, ExpressionNode>())
					.visitRuleTerm(lhs);
			ExpressionNode rhsNode = new BuildRhsVisitor().visitRuleTerm(rhs);

			// Check rulevariables correlate : throw exception if not
			// if (! ruleVariablesCorrelate( lhsNode, rhsNode) { throw exception };

			if (splitRule.length == 3) {
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditionsAST = conditionsParser.ruleConditions();

				r = (new Rule(lhsNode, rhsNode, conditionsAST));
			} else if (splitRule.length == 2) {
				r = (new Rule(lhsNode, rhsNode));
			} else {

				// Throw exception here
				System.out.println("Incorrect rule exists");
			}
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Check the structure of your rules");
		} catch (Exception ex) {
			throw new Exception("Rule Parse Error: " + ex.getMessage());
		}
		return r;
	}

	private static RuleAlgebraParser getRuleParser(String expression) throws ParseCancellationException {

		RuleAlgebraParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		try {
			RuleAlgebraLexer lexer = new RuleAlgebraLexer(input);
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
			lexer.removeErrorListeners();

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			parser = new RuleAlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);

		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException(pce.getMessage());
		}
		return parser;
	}

	public ExpressionNode parseTerm(String expression) throws ParseCancellationException, Exception {

		ExpressionNode termAst = null;

		System.out.println("Expression : " + expression);
		if (expression.equals(null) || expression.equals("")) {
			throw new Exception("Please enter an algebraic term");
		}
		try {
			CharStream input;
			input = CharStreams.fromString(expression);

			AlgebraLexer lexer = new AlgebraLexer(input);
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
			lexer.removeErrorListeners();
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			AlgebraParser parser = new AlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);

			TermContext termTree = parser.term();
			termAst = new BuildTermVisitor().visitTerm(termTree);
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}
		return termAst;
	}

	private static ConditionsParser getConditionsParser(String expression) {

		ConditionsParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		ConditionsLexer lexer = new ConditionsLexer(input);
		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
		lexer.removeErrorListeners();
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ConditionsParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		return parser;
	}
}
