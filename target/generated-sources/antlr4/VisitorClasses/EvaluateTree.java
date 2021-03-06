package VisitorClasses;

import Nodes.*;
import VisitClasses.VisitAstComparison;
/**
 * Class that extends the AstComparator. Traverses the left-hand side of a
 * rewrite role alongside the selected redex. Determines if the subtrees share
 * the exact same structure except in the case of a rule ariable being present,
 * in which case the rule variable matches unquestionably the corresponding
 * subtree in the redex. Returns true if the structure of the LHS and redex are
 * equivalent.
 * 
 * @author Lewis
 *
 * @param <T> Generic type
 */
public class EvaluateTree extends VisitAstComparison<Boolean> {

	public EvaluateTree() {
	}

	/**
	 * Comparison of binary operations
	 * Confirms left-hand side of each tree matches
	 * Confirms right-hand side of each tree matches
	 * returns true of both match
	 * 
	 */
	@Override
	public Boolean Visit(PowerNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.getLeft(), ((PowerNode) node).getLeft());
			boolean r = Visit(lhsNode.getRight(), ((PowerNode) node).getRight());
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(AdditionNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.getLeft(), ((AdditionNode) node).getLeft());
			boolean r = Visit(lhsNode.getRight(), ((AdditionNode) node).getRight());
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(SubtractionNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.getLeft(), ((SubtractionNode) node).getLeft());
			boolean r = Visit(lhsNode.getRight(), ((SubtractionNode) node).getRight());
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(MultiplicationNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.getLeft(), ((MultiplicationNode) node).getLeft());
			boolean r = Visit(lhsNode.getRight(), ((MultiplicationNode) node).getRight());
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(DivisionNode lhsNode, ExpressionNode node) throws Exception {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.getLeft(), ((DivisionNode) node).getLeft());
			boolean r = Visit(lhsNode.getRight(), ((DivisionNode) node).getRight());
			return l && r;
		}
		return false;

	}

	// Match if both nodes are NumberNodes and both hold the same value
	@Override
	public Boolean Visit(NumberNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			return lhsNode.compareTo(((NumberNode) node)) == 0;
		}
		return false;
	}

	// Match if both nodes are instances of UnaryNode and their innerNodes match
	@Override
	public Boolean Visit(UnaryNode lhsNode, ExpressionNode node) throws Exception {
		boolean match = false;
		if (lhsNode.getClass() == node.getClass()) {
			match = Visit(lhsNode.getInnerNode(), ((UnaryNode) node).getInnerNode());

		}
		return match;
	}

	// Match if both nodes are functions, both their function name attributes match, and if their arguments match
	@Override
	public Boolean Visit(FunctionNode lhsNode, ExpressionNode node) throws Exception {
		boolean argumentsMatch = false;
		if (lhsNode.getClass() == node.getClass()) {
			if (lhsNode.getArguments().size() == ((FunctionNode) node).getArguments().size()) {
				argumentsMatch = lhsNode.getFunction().equals(((FunctionNode) node).getFunction());
				for (int i = 0; i < lhsNode.getArguments().size(); i++) {
					argumentsMatch = argumentsMatch
							&& Visit(lhsNode.getArguments().get(i), ((FunctionNode) node).getArguments().get(i));
				}
			}
		}
		return argumentsMatch;
	}
	
	// Throw exception if RuleVariablenode found in term
	// Match in any other case. 
	@Override
	public Boolean Visit(RuleVariableNode lhsNode, ExpressionNode node) throws Exception {
		if (node instanceof RuleVariableNode) {
			throw new Exception("Attempted to match rule variable. Please check the structure of your rules");
		}

		return true;
	}

	// Match if both nodes are VariableNode instances and their values are equivalent
	@Override
	public Boolean Visit(VariableNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {

			return (lhsNode.getValue().equals(((VariableNode) node).getValue()));
		}
		return false;
	}
}
