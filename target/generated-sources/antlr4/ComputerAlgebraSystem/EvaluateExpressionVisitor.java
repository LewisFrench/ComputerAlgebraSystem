package ComputerAlgebraSystem;

// Make into <expressionNode> and implement solver?
class EvaluateExpressionVisitor extends TermVisitor<String> {

	@Override
	public String Visit(PowerNode node) throws Exception {
		System.out
				.println("\nvisiting Power : " + "\nLHS :" + node.Left.toString() + "\nRHS: " + node.Right.toString());
		return Visit(node.Left) + "^" + Visit(node.Right);
	}

	@Override
	public String Visit(AdditionNode node) throws Exception {
		System.out.println(
				"\nvisiting Addition : " + "\nLHS :" + node.Left.toString() + "\nRHS: " + node.Right.toString());
		return  Visit(node.Left) + "+" + Visit(node.Right) ;
	}

	@Override
	public String Visit(SubtractionNode node) throws Exception {
		System.out.println(
				"\nvisiting Subtraction : " + "\nLHS :" + node.Left.toString() + "\nRHS: " + node.Right.toString());
		return Visit(node.Left) + "-" + Visit(node.Right);
	}

	@Override
	public String Visit(MultiplicationNode node) throws Exception {
		System.out.println(
				"\nvisiting Multiplication : " + "\nLHS :" + node.Left.toString() + "\nRHS: " + node.Right.toString());
		return Visit(node.Left) + "*" + Visit(node.Right);
	}

	@Override
	public String Visit(DivisionNode node) throws Exception {
		System.out.println(
				"\nvisiting Division : " + "\nLHS :" + node.Left.toString() + "\nRHS: " + node.Right.toString());
		// divide by 0 errors
		return Visit(node.Left) + "/" + Visit(node.Right);
	}

	@Override
	public String Visit(NumberNode node) {
		// If denoinator is 1, output denominator
		// If representation is not finite, return as rationa;
		// if representation is finite but long, return as rational
		// If representation is finish and has fewer than N decimal places, output as
		// decimal.
		return node.toString();
		// return String.valueOf(node.value);
	}

	@Override
	public String Visit(UnaryNode node) throws Exception {
		System.out.println("\nvisiting Unary : " + node.toString());
		return ("-" + Visit(node.innerNode).toString());
	}

	@Override
	public String Visit(FunctionNode node) {
		System.out.println("\nvisiting Function : " + node.toString());
		return node.toString();
	}

	@Override
	public String Visit(VariableNode node) {
		System.out.println("\nvisiting Variable : " + node.toString());
		return node.toString();
	}

}