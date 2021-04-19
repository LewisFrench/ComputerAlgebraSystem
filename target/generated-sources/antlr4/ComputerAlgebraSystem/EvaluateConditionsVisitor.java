package ComputerAlgebraSystem;

import Conditions.ConditionsLexer;

// Could likely split the AstVisitor into two visitors, one for the expression only nodes, and one for conditionnodes
// Assuming I don't need them all for the is_literal() implementation

public class EvaluateConditionsVisitor extends VisitConditionNodes<Boolean> {
	ConditionFunctionEvaluator conditionFunctions;

	public EvaluateConditionsVisitor() {
		this.conditionFunctions = new ConditionFunctionEvaluator();
	}

	@Override
	public Boolean Visit(ConditionAndNode node) throws Exception {
		return (Visit(node.left) && Visit(node.right));
	}

	@Override
	public Boolean Visit(ConditionOrNode node) throws Exception {
		return (Visit(node.left) || Visit(node.right));
	}

	@Override
	public Boolean Visit(ConditionNotNode node) throws Exception {
		return !(Visit(node.innerNode));
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) throws Exception {
		return this.conditionFunctions.determineFunction(node.functionName, node.arguments);
	}

	@Override
	public Boolean Visit(RelopNode node) throws Exception {
		boolean relopResult = calculateRelop(node);
		return relopResult;
	}

	public boolean calculateRelop(RelopNode relopNode) throws Exception {

		// Decide equivalence between any two nodes
		EvaluateTree treeMatcher = new EvaluateTree();
		if (relopNode.relop == ConditionsLexer.RELOP_EQ) {
			return treeMatcher.Visit(relopNode.left, relopNode.right);
		} else if (relopNode.relop == ConditionsLexer.RELOP_NEQ) {
			return !(treeMatcher.Visit(relopNode.left, relopNode.right));
		}

		if (!(relopNode.left instanceof NumberNode && relopNode.right instanceof NumberNode)) {
			throw new Exception("Check your rule conditions. You cannot evaluate inequalities of non-numerical terms");
		}
		NumberNode l = (NumberNode) (relopNode.left);
		NumberNode r = (NumberNode) (relopNode.right);

		boolean relopResult = false;

		switch (relopNode.relop) {

		case ConditionsLexer.RELOP_LT:
			relopResult = l.compareTo(r) < 0;
			break;
		case ConditionsLexer.RELOP_LTE:
			relopResult = l.compareTo(r) <= 0;
			break;
		case ConditionsLexer.RELOP_GT:
			relopResult = l.compareTo(r) > 0;
			break;
		case ConditionsLexer.RELOP_GTE:
			relopResult = l.compareTo(r) >= 0;
		}
		return relopResult;
	}

}
