package expression;

abstract class ConditionVisitor<T> {

	// Condition Nodes
	public abstract T Visit(ConditionAndNode node);

	public abstract T Visit(ConditionOrNode node);

	public abstract T Visit(NotNode node);

	public abstract T Visit(RelopNode node);

	public abstract T Visit(ConditionFunctionNode node);

	// Expression Nodes
	public abstract T Visit(PowerNode node);

	public abstract T Visit(AdditionNode node);

	public abstract T Visit(SubtractionNode node);

	public abstract T Visit(MultiplicationNode node);

	public abstract T Visit(DivisionNode node);

	public abstract T Visit(ParentheticalNode node);

	public abstract T Visit(UnaryNode node);

	public abstract T Visit(FunctionNode node);

	public abstract T Visit(VariableNode node);

	public abstract T Visit(NumberNode node);

	public abstract T Visit(RuleVariableNode node);

	// Can talk about how this could be more efficient in C#, see bookmark page
	public T Visit(ExpressionNode node) {
		if (node instanceof ConditionAndNode) {
			return Visit((ConditionAndNode) node);
		} else if (node instanceof ConditionOrNode) {
			return Visit((ConditionOrNode) node);
		} else if (node instanceof NotNode) {
			return Visit((NotNode) node);
		} else if (node instanceof RelopNode) {
			return Visit((RelopNode) node);
		} else if (node instanceof ConditionFunctionNode) {
			return Visit((ConditionFunctionNode) node);
		} else if (node instanceof PowerNode) {
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
		} else if (node instanceof RuleVariableNode) {
			return Visit((RuleVariableNode) node);
		} else {
			// Exception
			System.out.println("No expressionNode of suitable type");
			return null;
		}
	}
}