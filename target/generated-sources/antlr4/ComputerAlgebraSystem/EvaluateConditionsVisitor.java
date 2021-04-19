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
		return (Visit(node.getLeft()) && Visit(node.getRight()));
	}

	@Override
	public Boolean Visit(ConditionOrNode node) throws Exception {
		return (Visit(node.getLeft()) || Visit(node.getRight()));
	}

	@Override
	public Boolean Visit(ConditionNotNode node) throws Exception {
		return !(Visit(node.getInnerNode()));
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) throws Exception {
		return this.conditionFunctions.determineFunction(node.getFunctionName(), node.getArguments());
	}

	@Override
	public Boolean Visit(RelopNode node) throws Exception {
		boolean relopResult = calculateRelop(node);
		return relopResult;
	}

	public boolean calculateRelop(RelopNode relopNode) throws Exception {

		// Decide equivalence between any two nodes
		EvaluateTree treeMatcher = new EvaluateTree();
		if (relopNode.getRelop() == ConditionsLexer.RELOP_EQ) {
			return treeMatcher.Visit(relopNode.getLeft(), relopNode.getRight());
		} else if (relopNode.getRelop() == ConditionsLexer.RELOP_NEQ) {
			return !(treeMatcher.Visit(relopNode.getLeft(), relopNode.getRight()));
		}

		if (!(relopNode.getLeft() instanceof NumberNode && relopNode.getRight() instanceof NumberNode)) {
			throw new Exception("Check your rule conditions. You cannot evaluate inequalities of non-numerical terms");
		}
		NumberNode l = (NumberNode) (relopNode.getLeft());
		NumberNode r = (NumberNode) (relopNode.getRight());

		boolean relopResult = false;

		switch (relopNode.getRelop()) {

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
