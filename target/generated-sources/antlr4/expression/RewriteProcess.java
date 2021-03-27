package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RewriteProcess extends AstVisitor<ExpressionNode> {
	//LinkedHashMap<String, ExpressionNode> variables;
	ArrayList<Rule> rules;
	
	// Maximum Rule Applications

	public RewriteProcess(ArrayList<Rule> ruleSet) {
		rules = ruleSet;
		

	}

	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode rwLeft = (Visit(node.Left));
		ExpressionNode rwRight = (Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		ExpressionNode visitedLeft = (Visit(node.Left));
		ExpressionNode visitedRight = (Visit(node.Right));
		node.Left = visitedLeft;
		node.Right = visitedRight;

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) {
		node.innerNode = rewrite(Visit(node.innerNode));
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		node.innerNode = rewrite(node.innerNode);

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) {
		for (int i = 0; i < node.getArguments().size(); i++) {
			node.arguments.set(i, rewrite(Visit(node.arguments.get(i))));

		}

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(RuleVariableNode node) {
		System.out.println("EXCEPTION");

		return node;
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return rewrite(node);
	}

	public ExpressionNode rewrite(ExpressionNode node) {
		boolean conditionsHold;
		Rule appliedRule = null;
		EvaluateTree argumentEvaluator;
		if (rules != null) {
			for (Rule r : rules) {
				argumentEvaluator = new EvaluateTree();

				conditionsHold = false;
				if (argumentEvaluator.Visit(r.lhsNode, node)) {
					
					if (argumentsValid(argumentEvaluator)) {
						appliedRule = new Rule(r.lhs, r.rhs, r.conditions);

						for (String key : appliedRule.variables.keySet()) {
							if (appliedRule.variables.get(key) == null) {
								appliedRule.variables.put(key, argumentEvaluator.arguments.get(0));
								argumentEvaluator.arguments.remove(0);
							}
						}
						if (appliedRule.conditions != null) {
							ExpressionNode conditionsNode = new BuildConditionsVisitor(appliedRule.variables)
									.visitRuleConditions(appliedRule.conditions);
							conditionsHold = new EvaluateConditionsVisitor(appliedRule.variables).Visit(conditionsNode);
						}
						if (conditionsHold || appliedRule.conditions == null) {

							appliedRule.rhsNode = new BuildRhsVisitor(appliedRule.variables).visit(appliedRule.rhs);
							System.out.println("\nMatch Rule " + appliedRule.toString() + " to node " + node.toString());
							System.out.println(node.toString() + " --->  " + appliedRule.rhsNode.toString());
							return Visit(appliedRule.rhsNode);
						}
					}
				}
			}
		}
		return node;
	}

	public boolean argumentsValid(EvaluateTree argumentEvaluator) {
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
