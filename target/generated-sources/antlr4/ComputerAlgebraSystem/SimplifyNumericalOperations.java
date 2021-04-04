package ComputerAlgebraSystem;

import java.util.ArrayList;

public class SimplifyNumericalOperations extends TermVisitor<ExpressionNode> {

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(Math.pow(((NumberNode) node.Left).getValue(), ((NumberNode) node.Right).getValue()));
		}
		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() + ((NumberNode) right).getValue());
		}

		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() - ((NumberNode) right).getValue());
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() * ((NumberNode) right).getValue());
		}

		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() / ((NumberNode) right).getValue());
		}
		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) throws Exception {
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			return ((NumberNode)innerNode);
		}
		return new ParentheticalNode(innerNode);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			double invertedValue = (((NumberNode)innerNode).getValue()) * -1;
			return new NumberNode(invertedValue);
		}
		return new UnaryNode(innerNode);
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return new FunctionNode(node.function, arguments);
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return node;
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return node;
	}

}
