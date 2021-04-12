package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		new GUI();
	}

	public String Rewrite(ArrayList<Rule> rules, ExpressionNode termAst, int ruleApplicationLimit) throws Exception {
		
		
		String outputValue = "";
		try {
			System.out.println(termAst.getClass());
			System.out.println(termAst.toString());
			
			ExpressionNode ast2 = new RewriteProcess(rules, ruleApplicationLimit).Visit(termAst);
			ExpressionNode simplified = new SimplifyNumericalOperations().Visit(ast2);
			System.out.println("Simplified : " + simplified.toString());
			outputValue = new EvaluateExpressionVisitor().Visit(simplified);
			return outputValue;

			// Catch different type of exceptions here, determine if I can customise the
			// error messages.
			// if not - evaluate that I would've liked to dedicate more time to determining
			// the causes of every issue, but time constraints.
		} catch (StackOverflowError soe) {
			throw new StackOverflowError(
					"Check for any infinitely-recursive rules or choose a lower rule application limit");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Rewrite Error: " + e.getMessage() + "  " + e.toString());
		}
	}

	private static String[] splitRuleString(String ruleString) throws Exception {
		ruleString = ruleString.replaceAll(" ", "");
		String[] splitByEquals = ruleString.split("=", 2);
		if (splitByEquals.length != 2) {
			throw new Exception("All rules must contain a '=' symbol");
		}

		if (splitByEquals[0].replaceAll(" ", "").equals(null) || splitByEquals[0].replaceAll(" ", "").equals("")) {
			throw new Exception("Rules must have symbols on their either side of the '=' ");
		}
		String[] splitByCondition = splitByEquals[1].split(":", 2);
		
		// MAybe a check for balnk here? Can throw a better exception
		if (splitByCondition.length > 1) {
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

			
			RuleAlgebraParser lhsParser = getRuleParser(splitRule[0]);
			RuleAlgebraParser rhsParser = getRuleParser(splitRule[1]);

			// See if I can get an exception going here, my be difficult
			RuleTermContext lhs = lhsParser.ruleTerm();
			RuleTermContext rhs = rhsParser.ruleTerm();
			BuildLhsVisitor lhsVisitor = new BuildLhsVisitor(new LinkedHashMap<String, ExpressionNode>());
			ExpressionNode lhsNode = lhsVisitor.visitRuleTerm(lhs);
			System.out.println("Visiting rhs term");
			ExpressionNode rhsNode = new BuildRhsVisitor().visitRuleTerm(rhs);


			if (splitRule.length == 3) {

				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditions = conditionsParser.ruleConditions();
				ExpressionNode conditionsNode = new BuildConditionsVisitor().visit(conditions);

				r = (new Rule(lhsNode, rhsNode, conditionsNode));
				r.variables = lhsVisitor.variables;
				
				// Check if rule variables correlate from LHS --> Conditions
				FetchConditionRuleVariables fCond = new FetchConditionRuleVariables();
				fCond.Visit(conditionsNode);
				if (!(r.variables.keySet().containsAll(fCond.variables.keySet()))) {
					throw new Exception("Condition contains a rule variable that isn't present in the LHS of a rule");
				}
			} else if (splitRule.length == 2) {
				r = (new Rule(lhsNode, rhsNode));
				r.variables = lhsVisitor.variables;
			} else {
				throw new ParseCancellationException("Rule entered with invalid length. Please check the structure of your rules");
			}

			FetchRuleVariables f = new FetchRuleVariables();
			f.Visit(rhsNode);
			if (!(r.variables.keySet().containsAll(f.variables.keySet()))) {
				throw new Exception("A rule contains rule variables that don't correspond from LHS to RHS");
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
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

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

		if (expression.equals(null) || expression.equals("")) {
			throw new Exception("Please enter an algebraic term");
		}
		try {
			CharStream input;
			input = CharStreams.fromString(expression);

			AlgebraLexer lexer = new AlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
			System.out.println("Finished lexing");
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			
			AlgebraParser parser = new AlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
			TermContext termTree = parser.term();
			System.out.println("Got Context");
			termAst = new BuildTermVisitor().visitTerm(termTree);
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}
		System.out.println("\nTerm Ast: "+termAst);
		return termAst;
	}

	private static ConditionsParser getConditionsParser(String expression)
			throws ParseCancellationException, Exception {

		ConditionsParser parser = null;
		CharStream input;
		try {
			input = CharStreams.fromString(expression);

			ConditionsLexer lexer = new ConditionsLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			parser = new ConditionsParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}

		return parser;
	}
}
