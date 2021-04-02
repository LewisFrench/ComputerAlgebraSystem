package ComputerAlgebraSystem;

abstract class AstComparator<T> {
	public abstract T Visit(PowerNode LhsNode, ExpressionNode node)throws Exception; 

	public abstract T Visit(AdditionNode LhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(SubtractionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(MultiplicationNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(DivisionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(ParentheticalNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(UnaryNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(FunctionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(RuleVariableNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(VariableNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(NumberNode lhsNode, ExpressionNode node)throws Exception;

	// Can talk about how this could be more effieint in C#, see bookmark page
	public T Visit(ExpressionNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode instanceof PowerNode) {
			return Visit((PowerNode) lhsNode, node);
		} else if (lhsNode instanceof AdditionNode) {
			return Visit((AdditionNode) lhsNode, node);
		} else if (lhsNode instanceof SubtractionNode) {
			return Visit((SubtractionNode) lhsNode, node);
		} else if (lhsNode instanceof MultiplicationNode) {
			return Visit((MultiplicationNode) lhsNode, node);
		} else if (lhsNode instanceof DivisionNode) {
			return Visit((DivisionNode) lhsNode, node);
		} else if (lhsNode instanceof ParentheticalNode) {
			return Visit((ParentheticalNode) lhsNode, node);
		} else if (lhsNode instanceof UnaryNode) {
			return Visit((UnaryNode) lhsNode, node);
		} else if (lhsNode instanceof FunctionNode) {
			return Visit((FunctionNode) lhsNode, node);
		} else if (lhsNode instanceof RuleVariableNode) {
			return Visit((RuleVariableNode) lhsNode, node);
		} else if (lhsNode instanceof VariableNode) {
			return Visit((VariableNode) lhsNode, node);
		} else if (lhsNode instanceof NumberNode) {
			return Visit((NumberNode) lhsNode, node);
		}

		else {
			throw new Exception("Tree matching error: attempted to visit an unreachable node. Please check the structure of your rules");
		}
	}
}