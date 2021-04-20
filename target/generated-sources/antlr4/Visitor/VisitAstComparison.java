package Visitor;
import Nodes.*;
/**
 * Visitor class that specifies the comparison of two nodes at each visit.
 * Throws exception if attempting to visit a node that is not specified
 * 
 * @author Lewis
 *
 * @param <T>
 */
public abstract class VisitAstComparison<T> {
	public abstract T Visit(PowerNode LhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(AdditionNode LhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(SubtractionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(MultiplicationNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(DivisionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(UnaryNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(FunctionNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(VariableNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(NumberNode lhsNode, ExpressionNode node) throws Exception;

	public abstract T Visit(RuleVariableNode lhsNode, ExpressionNode node) throws Exception;

	/**
	 * 
	 * @param lhsNode The node in the AST representing the left-hand side of a rule
	 * @param node    A node present in the redex of the algebraic term entered by
	 *                the user
	 * @return
	 * @throws IllegalArgumentException if attempting to visit a node that shouldn't
	 *                                  exist in either subtree
	 */
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
		} else if (lhsNode instanceof UnaryNode) {
			return Visit((UnaryNode) lhsNode, node);
		} else if (lhsNode instanceof FunctionNode) {
			return Visit((FunctionNode) lhsNode, node);
		} else if (lhsNode instanceof VariableNode) {
			return Visit((VariableNode) lhsNode, node);
		} else if (lhsNode instanceof NumberNode) {
			return Visit((NumberNode) lhsNode, node);
		} else if (lhsNode instanceof RuleVariableNode) {
			return Visit((RuleVariableNode) lhsNode, node);
		} else {
			throw new IllegalArgumentException("Attempted to visit an unaccepted type of node.");
		}
	}
}
