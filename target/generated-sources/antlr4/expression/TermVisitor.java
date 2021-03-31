package expression;

abstract class TermVisitor<T> {
	public abstract T Visit(PowerNode node) throws Exception;

	public abstract T Visit(AdditionNode node)throws Exception;

	public abstract T Visit(SubtractionNode node) throws Exception;

	public abstract T Visit(MultiplicationNode node)throws Exception;

	public abstract T Visit(DivisionNode node) throws Exception;

	public abstract T Visit(ParentheticalNode node)throws Exception;

	public abstract T Visit(UnaryNode node)throws Exception;

	public abstract T Visit(FunctionNode node)throws Exception;

	public abstract T Visit(VariableNode node) throws Exception;

	public abstract T Visit(NumberNode node) throws Exception;

	// public abstract T Visit(RuleVariableNode node);

	// Can talk about how this could be more efficient in C#, see bookmark page
	public T Visit(ExpressionNode node) throws Exception {
		if (node instanceof PowerNode) {
			return Visit((PowerNode) node);
		} else if (node instanceof AdditionNode) {
			return Visit((AdditionNode) node);
		} else if (node instanceof SubtractionNode) {
			return Visit((SubtractionNode) node);
		} else if (node instanceof MultiplicationNode) {
			return Visit((MultiplicationNode) node);
		} else if (node instanceof DivisionNode) {
			return Visit((DivisionNode) node);
		} else if (node instanceof ParentheticalNode) {
			return Visit((ParentheticalNode) node);
		} else if (node instanceof UnaryNode) {
			return Visit((UnaryNode) node);
		} else if (node instanceof FunctionNode) {
			return Visit((FunctionNode) node);
		} else if (node instanceof VariableNode) {
			return Visit((VariableNode) node);
		} else if (node instanceof NumberNode) {
			return Visit((NumberNode) node);
		}
//		else if (node instanceof RuleVariableNode) {
//			return Visit((RuleVariableNode) node);
//		}
		else {
			throw new Exception("Attempted to visit a valid node");
		}
	}
}