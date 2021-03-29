package expression;

import java.util.ArrayList;

public class SimplifyNumericalOperations extends TermVisitor<ExpressionNode> {

	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(Math.pow(((NumberNode) node.Left).getValue(), ((NumberNode) node.Right).getValue()));
		}
		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		System.out.println("Visiting simplified addition" + node.toString());
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() + ((NumberNode) right).getValue());
		}

		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() - ((NumberNode) right).getValue());
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() * ((NumberNode) right).getValue());
		}

		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			return new NumberNode(((NumberNode) left).getValue() / ((NumberNode) right).getValue());
		}
		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) {
		return new ParentheticalNode(Visit(node));

	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		return new UnaryNode(Visit(node));
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) {
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

//	@Override
//	public ExpressionNode Visit(RuleVariableNode node) {
//		System.out.println("\nVISITING RULEVARLABLENODE " + node.toString() + "  " + this.variables);
//		if (this.variables.get(node.toString())!= null) {
//			System.out.println("Returning " + this.variables.get(node.toString()) + this.variables.get(node.toString()).getClass());
//			return this.variables.get(node.toString());
//		}
//		// Exception
//		return node;
//	}

}
