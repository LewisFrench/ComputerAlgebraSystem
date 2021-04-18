package ComputerAlgebraSystem;

import java.util.ArrayList;

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

//	ArrayList<ExpressionNode> arguments;
//	ArrayList<String> variables;

	public EvaluateTree() {
//		this.arguments = new ArrayList<>();
//		this.variables = new ArrayList<>();
	}

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

	@Override
	public Boolean Visit(NumberNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			return lhsNode.compareTo(((NumberNode) node)) == 0;
		}
		return false;
	}

	@Override
	public Boolean Visit(UnaryNode lhsNode, ExpressionNode node) throws Exception {
		boolean match = false;
		if (lhsNode.getClass() == node.getClass()) {
			match = Visit(lhsNode.innerNode, ((UnaryNode) node).innerNode);

		}
		return match;
	}

	@Override
	public Boolean Visit(FunctionNode lhsNode, ExpressionNode node) throws Exception {
		boolean argumentsMatch = false;
		if (lhsNode.getClass() == node.getClass()) {
			if (lhsNode.arguments.size() == ((FunctionNode) node).arguments.size()) {
				argumentsMatch = lhsNode.function.equals(((FunctionNode) node).function);
				for (int i = 0; i < lhsNode.arguments.size(); i++) {
					argumentsMatch = argumentsMatch
							&& Visit(lhsNode.arguments.get(i), ((FunctionNode) node).arguments.get(i));
				}
			}
		}
		return argumentsMatch;
	}

	@Override
	public Boolean Visit(RuleVariableNode lhsNode, ExpressionNode node) throws Exception {
		if (node instanceof RuleVariableNode) {
			throw new Exception("Attempted to match rule variable. Please check the structure of your rules");
		}
//		this.arguments.add(node);
//		this.variables.add(lhsNode.toString());
		return true;
	}

	@Override
	public Boolean Visit(VariableNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {

			return (lhsNode.getValue().equals(((VariableNode) node).getValue()));
		}
		return false;
	}
}
