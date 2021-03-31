package expression;

import java.util.ArrayList;
import java.util.Arrays;
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

	public String Rewrite(ArrayList<Rule> rules, ExpressionNode termAst, int ruleApplicationLimit) {
		System.out.println("\n Rule application Limit : " + ruleApplicationLimit);
		for (Rule r : rules) {
			System.out.println(r);
		}
		String outputValue = "";
		try {
			ExpressionNode ast2 = new RewriteProcess(rules, ruleApplicationLimit).Visit(termAst);
			System.out.println("Output: " + ast2.toString());
			ExpressionNode simplified = new SimplifyNumericalOperations().Visit(ast2);

			System.out.println(simplified.toString());
			outputValue = new EvaluateExpressionVisitor().Visit(simplified);
			return outputValue;
			
			// Catch different type of exceptions here, determine if I can customise the error messages. 
				// if not - evaluate that I would've liked to dedicate more time to determining the causes of every issue, but time constraints. 
		} catch (Exception e) {
			System.out.println("Rewrite Error Thrown: " + e.getMessage() + "  " + e.toString());
		}

		return outputValue;
	}

	private static String[] splitRuleString(String term) throws Exception {
		term = term.replaceAll(" ", "");
		String[] splitByEquals = term.split("=", 2);
		if (splitByEquals.length != 2) {
			throw new Exception("All rules must contain a '=' symbol");
		}
		
		if (splitByEquals[0].replaceAll(" ","").equals(null) || splitByEquals[0].replaceAll(" ","").equals("")) {
			throw new Exception("Rules must have symbols on their either side of the '=' ");
		}
		System.out.println("currently ok");
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
		System.out.println("Rule: " + ruleInput);
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
			BuildLhsVisitor lhsVisitor = new BuildLhsVisitor(new LinkedHashMap<String, ExpressionNode>());
			ExpressionNode lhsNode = lhsVisitor.visitRuleTerm(lhs);

			ExpressionNode rhsNode = new BuildRhsVisitor().visitRuleTerm(rhs);

			
		
			
			// Check rulevariables correlate : throw exception if not
			// if (! ruleVariablesCorrelate( lhsNode, rhsNode) { throw exception };

			if (splitRule.length == 3) {
				
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditions = conditionsParser.ruleConditions();
				ExpressionNode conditionsNode = new BuildConditionsVisitor().visit(conditions);
				System.out.println("\nSHOULD BE CONDITIONNODE" +conditionsNode.getClass());
				// check contains all variables here too (LHS --> Condition)
				
				
				r = (new Rule(lhsNode, rhsNode, conditionsNode));
				//System.out.println()
				r.variables = lhsVisitor.variables;
				
				
				FetchConditionRuleVariables fCond = new FetchConditionRuleVariables();
				fCond.Visit(conditionsNode);
				System.out.println("\nCondition node test: " + r.variables + "  " + fCond.variables);
				if (!(r.variables.keySet().containsAll(fCond.variables.keySet()))){
					throw new Exception("Condition contains a rule variable that isn't present in the LHS of a rule");
				}
			} else if (splitRule.length == 2) {
				r = (new Rule(lhsNode, rhsNode));
				r.variables = lhsVisitor.variables;
			} else {
				// Throw exception here
				System.out.println("Incorrect rule exists");
			}
			
			FetchRuleVariables f = new FetchRuleVariables();
			f.Visit(rhsNode);
			if (!(r.variables.keySet().containsAll(f.variables.keySet()))){
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

		System.out.println("Expression : " + expression);
		if (expression.equals(null) || expression.equals("")) {
			throw new Exception("Please enter an algebraic term");
		}
		try {
			CharStream input;
			input = CharStreams.fromString(expression);

			AlgebraLexer lexer = new AlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
			
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

	private static ConditionsParser getConditionsParser(String expression) throws ParseCancellationException, Exception {

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
