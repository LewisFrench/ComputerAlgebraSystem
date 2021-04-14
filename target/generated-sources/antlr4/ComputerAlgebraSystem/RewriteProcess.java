package ComputerAlgebraSystem;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Class handling the traversal of nodes in a user's algebraic term, and the
 * application of the rewrite process on the term. Visitor class traverses the
 * tree and attempts to apply rewrite rules in a leftmost, innermost order.
 * 
 * @author lewis
 *
 */
public class RewriteProcess extends TermVisitor<ExpressionNode> {
	ArrayList<Rule> rules;
	static final int RULE_APPLICATION_LIMIT = Integer.MAX_VALUE-1;
	int ruleApplicationCount = 0;

	public RewriteProcess(ArrayList<Rule> ruleSet) {
		rules = ruleSet;

	}

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.getLeft()));
		ExpressionNode visitedRight = (Visit(node.getRight()));

		return rewrite(new PowerNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.getLeft()));
		ExpressionNode visitedRight = (Visit(node.getRight()));

		return rewrite(new AdditionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.getLeft()));
		ExpressionNode visitedRight = (Visit(node.getRight()));

		return rewrite(new SubtractionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.getLeft()));
		ExpressionNode visitedRight = (Visit(node.getRight()));

		return rewrite(new MultiplicationNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.getLeft()));
		ExpressionNode visitedRight = (Visit(node.getRight()));

		return rewrite(new DivisionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(NumberNode node) throws Exception {
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		ExpressionNode innerNode = Visit(node.innerNode);
		return rewrite(new UnaryNode(innerNode));

	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return rewrite(new FunctionNode(node.function, arguments));
	}

	@Override
	public ExpressionNode Visit(VariableNode node) throws Exception {
		return rewrite(node);
	}

	/**
	 * Carries out the rewriting process on the redex of an algebraic term currently
	 * being visited. The subtree is compared to the left-hand side of each of the
	 * rewrite rules. Each comparison checks if the redex and the LHS of a rule
	 * match Then determines if the arguments represented by the rule variables in
	 * the LHS match with the order they are presented e.g. rule LHS $x+$y+$x
	 * matches with redex a+b+a, but not redex a+b+c The conditions for a rule are
	 * then evaluated, and the rule is applied if these conditions hold. Algebraic
	 * operations are evaluated, and the redex is replaced by the RHS of the applied
	 * rule (with rule variables substituted).
	 * 
	 * @param node The root node of the redex being visited
	 * @return an ExpressionNode of the rewritten redex, or the original redex if no
	 *         rules can be applied.
	 * @throws Exception
	 */
	public ExpressionNode rewrite(ExpressionNode node) throws Exception {
		if (!(RULE_APPLICATION_LIMIT > this.ruleApplicationCount)) {
			return node;
		}
		EvaluateTree argumentEvaluator;
		if (rules != null) {

			for (Rule r : rules) {
				try {
					boolean conditionsHold = false;
					argumentEvaluator = new EvaluateTree();

					// compare rule to redex
					boolean ruleMatches = argumentEvaluator.Visit(r.lhsNode, node);
					if (ruleMatches) {

						// determine if rule repeated rule variables are valid
						boolean validArguments = argumentsValid(argumentEvaluator);
						if (validArguments) {

							// Construct LinkedHashMap of rule variables and their corresponding values.
							LinkedHashMap<String, ExpressionNode> newRuleVariables = new LinkedHashMap<String, ExpressionNode>();
							for (int i = 0; i < argumentEvaluator.variables.size(); i++) {
								newRuleVariables.put(argumentEvaluator.variables.get(i),
										argumentEvaluator.arguments.get(i));
							}

							// if rule has conditions, determine if they hold.
							if (r.conditionsNode != null) {
								ExpressionNode substitutedConditions = new SubstituteConditionRuleVariables(
										newRuleVariables).Visit(r.conditionsNode);

								ExpressionNode simplified = new EvaluateConditionNumericalExpressions()
										.Visit(substitutedConditions);

								conditionsHold = new EvaluateConditionsVisitor().Visit(simplified);

							}
							// rewrite the subtree with the substituted RHS of the rule
							if (conditionsHold || r.conditionsNode == null) {
								this.ruleApplicationCount++;
								ExpressionNode substituted = new SubstituteRuleVariables(newRuleVariables)
										.Visit(r.rhsNode);
								ExpressionNode solved = new EvaluateNumericalOperations().Visit(substituted);
								return Visit(solved);
							}

						}
					}
				} catch (Exception e) {
					if (!(e.getClass().equals(RewriteError.class))) {
						throw new RewriteError(e.getMessage(), r, node);
					} else {
						throw e;
					}
				}

			}

		}

		return node;

	}

	/**
	 * Determines if repeated instances of rule variables in the LHS of a rule are
	 * complemented by repeating instances of subtrees of the redex being matched.
	 * $x+$y+$x must be complemented by a subtree in which the nodes that correspond
	 * to $x are identical
	 * 
	 * @param argumentEvaluator
	 * @return
	 * @throws Exception
	 */
	public static boolean argumentsValid(EvaluateTree argumentEvaluator) throws Exception {
		ArrayList<String> vars = argumentEvaluator.variables;
		ArrayList<ExpressionNode> args = argumentEvaluator.arguments;
		for (int i = 0; i < vars.size(); i++) {
			if (i != vars.indexOf(vars.get(i))) {
				if (!(argumentEvaluator.Visit(args.get(i), args.get(vars.indexOf(vars.get(i)))))) {
					return false;
				}
			}
		}
		return true;
	}

}
