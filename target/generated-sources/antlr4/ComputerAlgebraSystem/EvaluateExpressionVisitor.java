package ComputerAlgebraSystem;

class EvaluateExpressionVisitor extends VisitTerm<String> {

	@Override
	public String Visit(PowerNode node) throws Exception {

		return Visit(node.getLeft()) + "^" + Visit(node.getRight());
	}

	@Override
	public String Visit(AdditionNode node) throws Exception {
		return Visit(node.getLeft()) + "+" + Visit(node.getRight()) ;
	}

	@Override
	public String Visit(SubtractionNode node) throws Exception {
		return Visit(node.getLeft()) + "-" + Visit(node.getRight());
	}

	@Override
	public String Visit(MultiplicationNode node) throws Exception {
		return Visit(node.getLeft()) + "*" + Visit(node.getRight()) ;
	}

	@Override
	public String Visit(DivisionNode node) throws Exception {
		return Visit(node.getLeft()) + "/" + Visit(node.getRight());
	}

	@Override
	public String Visit(NumberNode node) {
		return node.toString();
	}

	@Override
	public String Visit(UnaryNode node) throws Exception {
		return ("-" + Visit(node.getInnerNode()).toString());
	}

	@Override
	public String Visit(FunctionNode node) {
		return node.toString();
	}

	@Override
	public String Visit(VariableNode node) {
		return node.toString();
	}

}