package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SimplifyNumericalOperations extends TermVisitor<ExpressionNode> {
	
	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(new BigDecimal(Math.pow(((NumberNode) node.Left).getValue().doubleValue(), ((NumberNode) node.Right).getValue().doubleValue())));
		}
		return new PowerNode(left, right);
	}
	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue().add(((NumberNode) right).getValue()));
		}
		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue().subtract(((NumberNode) right).getValue()));
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue().multiply(((NumberNode) right).getValue()));
		}
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() .divide(((NumberNode) right).getValue()));
		}
		return new DivisionNode(left, right);
	}


//	@Override
//	public ExpressionNode Visit(ParentheticalNode node) throws Exception {
//		ExpressionNode innerNode = Visit(node.innerNode);
//		if (innerNode instanceof NumberNode) {
//			return ((NumberNode)innerNode);
//		}
//		return new ParentheticalNode(innerNode);
//	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			return new NumberNode( (((NumberNode)innerNode).getValue()).multiply(new BigDecimal(-1)));
			
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
