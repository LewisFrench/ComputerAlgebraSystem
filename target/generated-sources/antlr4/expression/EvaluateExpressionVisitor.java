package expression;

// Make into <expressionNode> and implement solver?
class EvaluateExpressionVisitor extends TermVisitor<String> {

	@Override
	public String Visit(PowerNode node) {
		return Visit(node.Left) + "^" + Visit(node.Right);
	}

	@Override
	public String Visit(AdditionNode node) {
		return Visit(node.Left) + "+" + Visit(node.Right);
	}

	@Override
	public String Visit(SubtractionNode node) {

		return Visit(node.Left) + "-" + Visit(node.Right);
	}

	@Override
	public String Visit(MultiplicationNode node) {
		return Visit(node.Left) + "*" + Visit(node.Right);
	}

	@Override
	public String Visit(DivisionNode node) {
		// divide by 0 errors
		return Visit(node.Left) + "/" + Visit(node.Right);
	}

	@Override
	public String Visit(ParentheticalNode node) {
		return "(" + Visit(node.innerNode) + ")";
	}

	@Override
	public String Visit(NumberNode node) {
		return String.valueOf(node.value);
	}

	@Override
	public String Visit(UnaryNode node) {
		return ("-" + Visit(node.innerNode).toString());
	}

	@Override
	public String Visit(FunctionNode node) {
		return node.toString();
	}
//
//	@Override
//	public String Visit(RuleVariableNode node) {
//
//		return node.toString();
//	}

	@Override
	public String Visit(VariableNode node) {
		return node.toString();
	}

}