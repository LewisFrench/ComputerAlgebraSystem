package ComputerAlgebraSystem;

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

	/**
	 * Applies the rewrite process to the algebraic term entered by the user,
	 * evaluates any algebraic operations and returns the produced output.
	 * 
	 * @param rules   An arraylist containing the rewrite rules
	 * @param termAst The root node of the AST representing the user's algebraic
	 *                term.
	 * @return String representation of the rewritten AST
	 * @throws Exception Catches a rewrite error and throws to be caught by the GUI
	 */
	public String Rewrite(ArrayList<Rule> rules, ExpressionNode termAst) throws Exception {
		try {
			ExpressionNode ast2 = new RewriteProcess(rules).Visit(termAst);
			ExpressionNode simplified = new EvaluateNumericalOperations().Visit(ast2);
			return new EvaluateExpressionVisitor().Visit(simplified);
		} catch (StackOverflowError soe) {
			throw new StackOverflowError(
					"Check for any infinitely-recursive rules or choose a lower rule application limit");
			// } catch (RewriteError re) {
			// Do I do anything here???
		} catch (Exception e) {
			throw new Exception("Rewrite Error: " + e.getMessage());
		}
	}

	/**
	 * Takes the string value of an input rule and splits the string into the LHS,
	 * RHS, and Conditions (if applicable)
	 * 
	 * @param ruleString String containing a rule from the rewrite rule txt file
	 * @return String[] Rule split into two or three parts for each part to be
	 *         parsed. {LHS, RHS} or {LHS, RHS, Conditions}
	 * @throws Exception if the rule does not contain the necessary components.
	 */
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

		if (splitByCondition.length > 1) {
			if (splitByCondition[1].replaceAll(" ", "").equals("")) {
				throw new Exception("Rules containing a : symbol should contain valid condition symbols");
			}
			return new String[] { splitByEquals[0], splitByCondition[0], splitByCondition[1] };
		} else {
			return new String[] { splitByEquals[0], splitByCondition[0] };
		}
	}

	/**
	 * Converts a line of text from the rewrite rules file selected by the user and
	 * converts it into to a rule Object consisting of ASTs representing the LHS,
	 * RHS, and conditions (where applicable).
	 * 
	 * @param ruleInput
	 * @return Rule object containing AST represents of LHS, RHS and optional
	 *         Conditions
	 * @throws ParseCancellationException
	 * @throws Exception                  if the LHS, RHS, or conditions do not
	 *                                    follow the rules defined by the grammars
	 *                                    (RuleAlgebra.g4 and Conditions.g4)
	 */
	public Rule parseRule(String ruleInput) throws ParseCancellationException, Exception {
		Rule r = null;
		if (ruleInput.replaceAll(" ", "").equals("") || ruleInput.equals(null)) {
			throw new Exception("File contains no rules");
		}
		String[] splitRule;
		try {
			splitRule = splitRuleString(ruleInput);

			// Get parsers for the LHS and RHS and convert strings into parse trees
			RuleAlgebraParser lhsParser = getRuleParser(splitRule[0]);
			RuleAlgebraParser rhsParser = getRuleParser(splitRule[1]);
			RuleTermContext lhs = lhsParser.ruleTerm();
			RuleTermContext rhs = rhsParser.ruleTerm();

			// Convert the parse trees into abstract syntax trees made up of ExpressionNode
			// objects
			BuildLhsVisitor lhsVisitor = new BuildLhsVisitor(new LinkedHashMap<String, ExpressionNode>());
			ExpressionNode lhsNode = lhsVisitor.visitRuleTerm(lhs);
			ExpressionNode rhsNode = new BuildRhsVisitor().visitRuleTerm(rhs);

			// If rule contains conditions
			if (splitRule.length == 3) {
				// Create an AST representation of the conditions
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditions = conditionsParser.ruleConditions();
				ExpressionNode conditionsNode = new BuildConditionsVisitor().visit(conditions);

				//
				r = (new Rule(lhsNode, rhsNode, conditionsNode));
				r.variables = lhsVisitor.variables;

				// Throws exception if rule variables found in conditions are not a subset of
				// those in the LHS of the rule
				FetchConditionRuleVariables fCond = new FetchConditionRuleVariables();
				fCond.Visit(conditionsNode);
				if (!(r.variables.keySet().containsAll(fCond.variables.keySet()))) {
					throw new Exception("Condition contains a rule variable that isn't present in the LHS of a rule");
				}
				// If rule has no conditions, create a rule object from the LHS and RHS nodes
			} else if (splitRule.length == 2) {
				r = (new Rule(lhsNode, rhsNode));
				r.variables = lhsVisitor.variables;
				// Throw exception if rule is in invalid form.
			} else {
				throw new ParseCancellationException(
						"Rule entered with invalid length. Please check the structure of your rules");
			}

			// Throw exception if rule variables found in RHS are not a subset of those
			// found in LHS of rule.
			FetchRuleVariables f = new FetchRuleVariables();
			f.Visit(rhsNode);
			if (!(r.variables.keySet().containsAll(f.variables.keySet()))) {
				throw new Exception("A rule contains rule variables that don't correspond from LHS to RHS");
			}
			// Divide by zero error
		} catch (ArithmeticException ae) {
			throw new ArithmeticException(
					"Attempting to create a rule containing a rational number of denominator zero");
			// Rule in invalid format
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Check the structure of your rules");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Rule Parse Error: " + ex.getMessage());
		}
		return r;
	}

	/**
	 * Creates the ANTLR4 parser for the generation of the parse tree for the LHS
	 * and RHS of a rule. Performs lexical analysis on the input string and
	 * generates a stream of tokens. Returns a parser created from these tokens. and
	 * RHS of a rewrite rule.
	 * 
	 * @param expression
	 * @return RuleAlgebraParser
	 * @throws ParseCancellationException when input string does not align with the
	 *                                    rules of the grammar RuleAlgebra.g4
	 */
	private static RuleAlgebraParser getRuleParser(String expression) throws ParseCancellationException {

		RuleAlgebraParser parser = null;
		CharStream input;
		input = CharStreams.fromString(expression);
		try {
			// Perform lexical analysis
			RuleAlgebraLexer lexer = new RuleAlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			parser = new RuleAlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);

		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException(pce.getMessage());
		}
		return parser;
	}

	/**
	 * Converts the string entered by the user into a parse tree using the ANTLR4
	 * parser generator. Converts this parse tree into an AST using the
	 * BuildTermVisitor
	 * 
	 * @param expression String entered by the user representing the algebraic term
	 * @return ExpressionNode of the root of the generated abtract syntax tree.
	 * @throws ParseCancellationException
	 * @throws Exception
	 */
	public ExpressionNode parseTerm(String expression) throws ParseCancellationException, Exception {

		ExpressionNode termAst = null;

		if (expression.equals(null) || expression.equals("")) {
			throw new Exception("Please enter an algebraic term");
		}
		try {
			CharStream input;
			input = CharStreams.fromString(expression);
			// Perform lexical analysis
			AlgebraLexer lexer = new AlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			AlgebraParser parser = new AlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
			TermContext termTree = parser.term();
			termAst = new BuildTermVisitor().visitTerm(termTree);

		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (ArithmeticException iae) {
			throw new ArithmeticException(
					"Attempted to create a rational number with a denominator of zero. Please check the structure of your term");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}

		return termAst;
	}

	/**
	 * Creates the ANTLR4 parser for the generation of the parse tree for the
	 * conditions of a rule. Performs lexical analysis on the input string and
	 * generates a stream of tokens. Returns a parser created from these tokens. and
	 * RHS of a rewrite rule.
	 * 
	 * @param expression
	 * @return RuleAlgebraParser
	 * @throws ParseCancellationException when input string does not align with the
	 *                                    rules of the grammar Conditions.g4
	 */
	private static ConditionsParser getConditionsParser(String expression)
			throws ParseCancellationException, Exception {

		ConditionsParser parser = null;
		CharStream input;
		try {
			input = CharStreams.fromString(expression);

			// Perform lexical analysis
			ConditionsLexer lexer = new ConditionsLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			parser = new ConditionsParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (ArithmeticException iae) {
			throw new ArithmeticException(
					"Attempted to create a rational number with a denominator of zero. Please check the structure of your term");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}

		return parser;
	}
}
