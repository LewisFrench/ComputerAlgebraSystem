package ComputerAlgebraSystem;
/**
 * Visitor class that specifies nodes that can be visited while traversing the
 * left-hand side or right-hand side of a rewrite rule.
 * Throws exception if attempting to visit a node that is not specified 
 * 
 * @author Lewis
 *
 * @param <T> Generic type 
 */
abstract class VisitRuleTerm<T> {
	public abstract T Visit(PowerNode node) throws Exception;

	public abstract T Visit(AdditionNode node) throws Exception;

	public abstract T Visit(SubtractionNode node) throws Exception;

	public abstract T Visit(MultiplicationNode node) throws Exception;

	public abstract T Visit(DivisionNode node) throws Exception;

	public abstract T Visit(UnaryNode node) throws Exception;

	public abstract T Visit(FunctionNode node) throws Exception;

	public abstract T Visit(VariableNode node) throws Exception;

	public abstract T Visit(NumberNode node) throws Exception;

	public abstract T Visit(RuleVariableNode node) throws Exception;

	/**
	 * Visitor methods for the nodes present in the left-hand-side or right-hand side of a rewrite rule.
	 * 
	 * @param node A node present in the AST representing an rule.
	 * @return
	 * @throws IllegalArgumentException if attempting to visit a node that shouldn't be present in an rule.
	 */
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
			throw new IllegalArgumentException("Attempting to visit an unreachable node");
		}
	}
}