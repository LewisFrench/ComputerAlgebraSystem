package ComputerAlgebraSystem;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;
import Algebra.AlgebraParser.TermContext;
import AstConversion.BuildConditionsVisitor;
import AstConversion.BuildRuleVisitor;
import AstConversion.BuildTermVisitor;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;
import Conditions.ConditionsParser.RuleConditionsContext;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;
import RuleAlgebra.RuleAlgebraParser.RuleTermContext;
import VisitorClasses.EvaluateNumericalOperations;
import VisitorClasses.EvaluateTermOutput;
import VisitorClasses.FetchConditionRuleVariables;
import VisitorClasses.FetchRuleVariables;
import VisitorClasses.RewriteProcess;
import Nodes.*;

public class Program {

	int rulesApplied = 0;
	long executionTime = 0;

	public Program() {

	}

	public static void main(String[] args) {
		new GUI();
	}

	public int getRulesApplied() {
		return this.rulesApplied;
	}

	public long getExecutionTime() {
		return this.executionTime;
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
	public String Rewrite(ArrayList<Rule> rules, ExpressionNode termAst, int ruleApplicationLimit) throws Exception {
		long startTime = System.nanoTime();
		try {
			int ruleApplicationCount = 0;
			boolean ruleApplied = true;
			ExpressionNode term = termAst;

			RewriteProcess r = new RewriteProcess(rules);
			/*
			 * Apply rules until no further rules can be applied, or the rule application
			 * limit is reached
			 */
			while (ruleApplied && ruleApplicationCount < ruleApplicationLimit) {
				r.setRuleApplied(false);
				term = r.Visit(term);
				ruleApplied = r.getRuleApplied();
				if (ruleApplied) {
					ruleApplicationCount++;
				}

			}
			// Evaluate numerical operations in case no rules are applied
			ExpressionNode evaluatedTerm = new EvaluateNumericalOperations().Visit(term);
			long endTime = System.nanoTime();
			this.executionTime = endTime - startTime;
			this.rulesApplied = ruleApplicationCount;

			return new EvaluateTermOutput().Visit(evaluatedTerm);
		} catch (StackOverflowError soe) {
			throw new StackOverflowError("Check for any infinitely-recursive rules");
		} catch (RewriteError re) {
			throw re;
		} catch (Exception e) {

			throw new Exception("Rewrite Error: " + e.getMessage());
		}
	}

	/**
	 * Applies rules deterministically
	 * 
	 * @param rules   An arraylist containing the rewrite rules
	 * @param termAst The root node of the AST representing the user's algebraic
	 *                term.
	 * @return String representation of the rewritten AST
	 * @throws Exception Catches a rewrite error and throws to be caught by the GUI
	 */
	public String RewriteDeterministic(ArrayList<Rule> rules, ExpressionNode termAst, int ruleApplicationLimit)
			throws Exception {
		long startTime = System.nanoTime();
		try {
			int ruleApplicationCount = 0;
			boolean ruleApplied = true;
			ExpressionNode term = termAst;

			RewriteProcess r = new RewriteProcess(rules);

			int ruleIndex = 0;

			Rule currentRule;
			ArrayList<Rule> currentRuleArray = new ArrayList<>();
			while (ruleIndex < rules.size() && ruleApplicationCount < ruleApplicationLimit) {
				currentRule = rules.get(ruleIndex);
				currentRuleArray.clear();
				currentRuleArray.add(currentRule);
				r = new RewriteProcess(currentRuleArray);
				term = r.Visit(term);
				ruleApplied = r.getRuleApplied();
				if (ruleApplied) {
					ruleIndex = 0;
					ruleApplicationCount++;
				} else {
					ruleIndex++;
				}
				System.out.println(ruleIndex + "   " + ruleApplicationCount);
			}

			ExpressionNode evaluatedTerm = new EvaluateNumericalOperations().Visit(term);
			long endTime = System.nanoTime();

			this.executionTime = endTime - startTime;
			this.rulesApplied = ruleApplicationCount;

			return new EvaluateTermOutput().Visit(evaluatedTerm);
		} catch (StackOverflowError soe) {
			throw new StackOverflowError("Check for any infinitely-recursive rules");
		} catch (RewriteError re) {
			throw re;
		} catch (Exception e) {

			throw new Exception("Rewrite Error: " + e.getMessage());
		}
	}

	/**
	 * Takes the string value of an input rule and splits the string into the LHS,
	 * RHS, and Conditions (if applicable)
	 * 
	 * @param ruleString String containing a rule from the rewrite rule .txt file
	 * @return String[] Rule split into two or three parts for each part to be
	 *         parsed. {LHS, RHS} or {LHS, RHS, Conditions}
	 * @throws Exception if the rule does not contain the necessary components.
	 */
	private static String[] splitRuleString(String ruleString) throws RewriteRuleFormatException {
		ruleString = ruleString.replaceAll(" ", "");
		String[] splitByEquals = ruleString.split("=", 2);
		if (splitByEquals.length != 2) {
			throw new RewriteRuleFormatException("All rules must contain a '=' symbol");
		}

		// Rule is invalid if LHS or RHS do not contain symbols
		if (splitByEquals[0].replaceAll(" ", "").equals(null) || splitByEquals[0].replaceAll(" ", "").equals("")
				|| splitByEquals[1].replaceAll(" ", "").equals(null)
				|| splitByEquals[1].replaceAll(" ", "").equals("")) {
			throw new RewriteRuleFormatException("Rules must have symbols on their either side of the '=' ");
		}
		String[] splitByCondition = splitByEquals[1].split(":", 2);

		// Rule is invalid if ':' symbol is not followed by conditions
		if (splitByCondition.length > 1) {
			if (splitByCondition[1].replaceAll(" ", "").equals("")) {
				throw new RewriteRuleFormatException(
						"Rules containing a ':' symbol should contain valid condition symbols");
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
	public Rule parseRule(String ruleInput)
			throws ParseCancellationException, NullPointerException, RewriteRuleFormatException, Exception {
		Rule r = null;
		if (ruleInput.replaceAll(" ", "").equals("") || ruleInput.equals(null)) {
			throw new NullPointerException("Please ensure all lines in file contain a rewrite rule");
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
			ExpressionNode lhsNode = new BuildRuleVisitor().visitRuleTerm(lhs);
			ExpressionNode rhsNode = new BuildRuleVisitor().visitRuleTerm(rhs);

			// Rule is invalid if rule variables in RHS of rule are a subset of those in the
			// LHS
			FetchRuleVariables fetchLhsRuleVariables = new FetchRuleVariables();
			FetchRuleVariables fetchRhsRuleVariables = new FetchRuleVariables();
			fetchLhsRuleVariables.Visit(lhsNode);
			fetchRhsRuleVariables.Visit(rhsNode);
			if (!(fetchLhsRuleVariables.getRuleVariables().containsAll(fetchRhsRuleVariables.getRuleVariables()))) {
				throw new RewriteRuleFormatException(
						"RHS of rule contains rule variables that aren't present in the LHS of the rule.");
			}
			// If rule contains conditions
			if (splitRule.length == 3) {
				// Create an AST representation of the conditions
				ConditionsParser conditionsParser = getConditionsParser(splitRule[2]);
				RuleConditionsContext conditions = conditionsParser.ruleConditions();
				ExpressionNode conditionsNode = new BuildConditionsVisitor().visit(conditions);

				// Rule is invalid if rule variables in conditions are not a subset of those in
				// LHS
				FetchConditionRuleVariables fetchConditionRuleVariables = new FetchConditionRuleVariables();
				fetchConditionRuleVariables.Visit(conditionsNode);
				if (!(fetchLhsRuleVariables.getRuleVariables())
						.containsAll(fetchConditionRuleVariables.getRuleVariables())) {
					throw new RewriteRuleFormatException(
							"Rule has conditions that contain rule variables that aren't present in the LHS of a rule.");
				}

				// Create rule
				r = (new Rule(lhsNode, rhsNode, conditionsNode));

				// If rule has no conditions, create a rule object from the LHS and RHS nodes
			} else if (splitRule.length == 2) {
				r = (new Rule(lhsNode, rhsNode));
				// Throw exception if rule is in invalid form.
			} else {
				throw new RewriteRuleFormatException("Rule does not contain all of the necessary components");
			}
			// Catch format exceptions and append message to the offending rule string for
			// specific feedback
		} catch (RewriteRuleFormatException rrfe) {
			throw new RewriteRuleFormatException("Invalid rule entered: " + ruleInput + "\n" + rrfe.getMessage());
			// Logical divide by zero error when parsing input
		} catch (ArithmeticException ae) {
			throw new ArithmeticException("Rule: " + ruleInput + " attempts to create a division by zero");
			// Syntactic error when parsing input
		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error!\nRule: " + ruleInput + "\nis not syntactically valid.");
		}
		return r;
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
			throw new NullPointerException("Please enter an algebraic term");
		}
		try {
			CharStream input;
			input = CharStreams.fromString(expression);
			// Perform lexical analysis
			AlgebraLexer lexer = new AlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ParsingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			AlgebraParser parser = new AlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ParsingErrorListener.INSTANCE);
			// Conversion to parse tree
			TermContext termTree = parser.term();
			// Conversion to AST
			termAst = new BuildTermVisitor().visitTerm(termTree);

		} catch (ParseCancellationException pce) {
			throw new ParseCancellationException("Syntax error: Please check the syntax of your algebraic term");
		} catch (ArithmeticException iae) {
			throw new ArithmeticException("Algebraic term contains a division by zero.");
		} catch (Exception e) {
			throw new Exception("Error when parsing algebraic term");
		}

		return termAst;
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
//		try {
			// Perform lexical analysis
			RuleAlgebraLexer lexer = new RuleAlgebraLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ParsingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			parser = new RuleAlgebraParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ParsingErrorListener.INSTANCE);

//		} catch (ParseCancellationException pce) {
//			throw new ParseCancellationException(pce.getMessage());
//		}
		
		return parser;
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
	private static ConditionsParser getConditionsParser(String expression) throws Exception {

		ConditionsParser parser = null;
		CharStream input;
		try {
			input = CharStreams.fromString(expression);

			// Perform lexical analysis
			ConditionsLexer lexer = new ConditionsLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ParsingErrorListener.INSTANCE);

			// Generate tokens from lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Create from tokens
			parser = new ConditionsParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ParsingErrorListener.INSTANCE);

		} catch (Exception e) {
			throw new Exception("Error when parsing conditions");
		}

		return parser;
	}
}
