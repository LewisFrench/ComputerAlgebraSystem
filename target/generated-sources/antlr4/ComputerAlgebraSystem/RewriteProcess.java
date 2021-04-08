package ComputerAlgebraSystem;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RewriteProcess extends TermVisitor<ExpressionNode> {
	ArrayList<Rule> rules;
	int ruleApplicationLimit;
	int ruleApplicationCount = 0;

	public RewriteProcess(ArrayList<Rule> ruleSet, int ruleApplicationLimit) {
		rules = ruleSet;
		this.ruleApplicationLimit = ruleApplicationLimit;
	}

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));

		return rewrite(new PowerNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));

		return rewrite(new AdditionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));

		return rewrite(new SubtractionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(new MultiplicationNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(new DivisionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) throws Exception {

		return rewrite(new ParentheticalNode(Visit(node.innerNode)));
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

	public ExpressionNode rewrite(ExpressionNode node) throws Exception {
		if (!(this.ruleApplicationLimit > this.ruleApplicationCount)) {
			return node;
		}
		
		EvaluateTree argumentEvaluator;
		if (rules != null) {
			for (Rule r : rules) {
				boolean conditionsHold = false;
				argumentEvaluator = new EvaluateTree();

				boolean ruleMatches = argumentEvaluator.Visit(r.lhsNode, node);

				if (ruleMatches) {
					boolean validArguments = argumentsValid(argumentEvaluator);

					if (validArguments) {
						LinkedHashMap<String, ExpressionNode> newRuleVariables = new LinkedHashMap<String, ExpressionNode>();
						for (int i = 0; i < argumentEvaluator.variables.size(); i++) {
							newRuleVariables.put(argumentEvaluator.variables.get(i),
									argumentEvaluator.arguments.get(i));
						}

						if (r.conditionsNode != null) {
							ExpressionNode substitutedConditions = new SubstituteConditionRuleVariables(
									newRuleVariables).Visit(r.conditionsNode);

							ExpressionNode simplified = new SimplifyConditionNumericalExpressions()
									.Visit(substitutedConditions);

							conditionsHold = new EvaluateConditionsVisitor().Visit(simplified);

						}

						if (conditionsHold || r.conditionsNode == null) {
//							System.out.println("Matched rule " + r.toString() + "to term  " + node.toString());
							this.ruleApplicationCount++;
							ExpressionNode substituted = new SubstituteRuleVariables(newRuleVariables).Visit(r.rhsNode);
							ExpressionNode solved = new SimplifyNumericalOperations().Visit(substituted);

							return Visit(solved);
						}

					}
				}

			}

		}

		return node;

	}

	public static boolean argumentsValid(EvaluateTree argumentEvaluator) throws Exception {
		// Maybe validate to check size are equal or something idk what this does
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
