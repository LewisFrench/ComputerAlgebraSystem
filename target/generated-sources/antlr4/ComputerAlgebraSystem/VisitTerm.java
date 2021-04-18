package ComputerAlgebraSystem;
/**
 * Visitor class that specifies nodes that can be visited while traversing an algebraic term.
 * Throws exception if attempting to visit a node that is not specified 
 * 
 * @author Lewis
 *
 * @param <T> Generic type 
 */
abstract class VisitTerm<T> {
	public abstract T Visit(PowerNode node) throws Exception;

	public abstract T Visit(AdditionNode node)throws Exception;

	public abstract T Visit(SubtractionNode node) throws Exception;

	public abstract T Visit(MultiplicationNode node)throws Exception;

	public abstract T Visit(DivisionNode node) throws Exception;

	public abstract T Visit(UnaryNode node)throws Exception;

	public abstract T Visit(FunctionNode node)throws Exception;

	public abstract T Visit(VariableNode node) throws Exception;

	public abstract T Visit(NumberNode node) throws Exception;
	/**
	 * Visitor methods for the algebraic term entered by a user.
	 * 
	 * @param node A node present in the AST representing an algebraic term
	 * @return
	 * @throws IllegalArgumentException if attempting to visit a node that shouldn't be present in an algebraic term
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
		}
		else {
			throw new IllegalArgumentException("Attempted to visit an unaccepted type of node.");
		}
	}
}