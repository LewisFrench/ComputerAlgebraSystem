package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RewriteProcess extends TermVisitor<ExpressionNode> {
	// LinkedHashMap<String, ExpressionNode> variables;
	ArrayList<Rule> rules;
	int ruleApplicationLimit = 10;
	int ruleApplicationCount = 0;
	// Maximum Rule Applications

	public RewriteProcess(ArrayList<Rule> ruleSet) {
		rules = ruleSet;

	}

	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		// node.Left = rwLeft;
		// node.Right = rwRight;

		return rewrite(new PowerNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));

		return rewrite(new AdditionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));

		return rewrite(new SubtractionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(new MultiplicationNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(new DivisionNode(visitedLeft, visitedRight));
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) {

		return rewrite(new ParentheticalNode(Visit(node.innerNode)));
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		return rewrite(new UnaryNode(Visit(node.innerNode)));

	}

	@Override
	public ExpressionNode Visit(FunctionNode node) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return rewrite(new FunctionNode(node.function, arguments));
	}

//	@Override
//	public ExpressionNode Visit(RuleVariableNode node) {
//		System.out.println("EXCEPTION");
//
//		return node;
//	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return rewrite(node);
	}

	public ExpressionNode rewrite(ExpressionNode node) {

		if (this.ruleApplicationLimit <= this.ruleApplicationCount && !(ruleApplicationLimit == 0)) {
			System.out.println("Rule application limit reached");
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

						this.ruleApplicationCount++;

						LinkedHashMap<String, ExpressionNode> newRuleVariables = new LinkedHashMap<String, ExpressionNode>();
						for (int i = 0; i < argumentEvaluator.variables.size(); i++) {
							newRuleVariables.put(argumentEvaluator.variables.get(i),
									argumentEvaluator.arguments.get(i));
						}

						if (r.conditionsNode != null) {
							System.out.println("\n Checking Conditions: " + r.conditionsNode.toString()  + "\n");
							ExpressionNode substitutedConditions = new SubstituteConditionRuleVariables(newRuleVariables).Visit(r.conditionsNode);
							System.out.println(substitutedConditions.toString());
							ExpressionNode simplified = new SimplifyConditionNumericalExpressions().Visit(substitutedConditions);
							System.out.println(simplified.toString());
							conditionsHold = new EvaluateConditionsVisitor(newRuleVariables).Visit(simplified);
							System.out.println("Conditions hold : "  + conditionsHold);
							//ExpressionNode conditionsNode = new BuildConditionsVisitor(newRuleVariables)
							//		.visitRuleConditions(r.conditions);
							//conditionsHold = new EvaluateConditionsVisitor(r.variables).Visit(conditionsNode);
						}

						if (conditionsHold || r.conditionsNode == null) {
							System.out.println("\napply rule " + r.toString() + " to  " + node.toString());
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

	public static boolean argumentsValid(EvaluateTree argumentEvaluator) {
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
