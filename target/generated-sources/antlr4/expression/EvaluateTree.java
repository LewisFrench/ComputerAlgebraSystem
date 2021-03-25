package expression;

import java.util.ArrayList;

public class EvaluateTree extends AstComparator<Boolean> {

	ArrayList<ExpressionNode> arguments;
	ArrayList<String> variables;
	

	public EvaluateTree() {
		this.arguments = new ArrayList<>();
		this.variables = new ArrayList<>();
	}

	@Override
	public Boolean Visit(PowerNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left, ((PowerNode) node).Left);
			boolean r = Visit(lhsNode.Right, ((PowerNode) node).Right);
			return l && r;
		}
		return false;
	}
	@Override
	public Boolean Visit(AdditionNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left, ((AdditionNode) node).Left);
			boolean r = Visit(lhsNode.Right, ((AdditionNode) node).Right);
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(SubtractionNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left, ((SubtractionNode) node).Left);
			boolean r = Visit(lhsNode.Right, ((SubtractionNode) node).Right);
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(MultiplicationNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left, ((MultiplicationNode) node).Left);
			boolean r = Visit(lhsNode.Right, ((MultiplicationNode) node).Right);
			return l && r;
		}
		return false;
	}

	@Override
	public Boolean Visit(DivisionNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left, ((DivisionNode) node).Left);
			boolean r = Visit(lhsNode.Right, ((DivisionNode) node).Right);
			return l && r;
		}
		return false;

	}

	@Override
	public Boolean Visit(NumberNode lhsNode, ExpressionNode node) {
		if (lhsNode.getClass() == node.getClass()) {
			if (lhsNode.getValue() == ((NumberNode) node).getValue()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean Visit(ParentheticalNode lhsNode, ExpressionNode node) {
		boolean match = false;
		if (lhsNode.getClass() == node.getClass()) {
			match = Visit(lhsNode.innerNode, ((ParentheticalNode) node).innerNode);

		}
		return match;
	}
	@Override
	public Boolean Visit(UnaryNode lhsNode, ExpressionNode node) {
		boolean match = false;
		if (lhsNode.getClass() == node.getClass()) {
			match = Visit(lhsNode.innerNode, ((UnaryNode) node).innerNode);

		}
		return match;
	}

	@Override
	public Boolean Visit(FunctionNode lhsNode, ExpressionNode node) {
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
	public Boolean Visit(RuleVariableNode lhsNode, ExpressionNode node) {
		this.arguments.add(node);
		this.variables.add(lhsNode.toString());
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
