package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SimplifyConditionNumericalExpressions extends ConditionVisitor<ExpressionNode> {

	@Override
	public ExpressionNode Visit(ConditionAndNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionAndNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ConditionOrNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionOrNode(left, right);
	}

	@Override
	public ExpressionNode Visit(NotNode node) throws Exception {
		return new NotNode(Visit(node.innerNode));
	}

	@Override
	public ExpressionNode Visit(RelopNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new RelopNode(left, right, node.relop, node.relopText);
	}

	@Override
	public ExpressionNode Visit(ConditionFunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return new ConditionFunctionNode(node.functionName, arguments);
	}
	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			
			return ((NumberNode)left).exponentiate((NumberNode)right);
		}
		return new PowerNode(left, right);
	}
	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode)left).add((NumberNode)right);
		}
		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode)left).subtract((NumberNode)right);
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode)left).multiply((NumberNode)right);
		}
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		// Divide by zero error
		if (right instanceof NumberNode) {
			if (((NumberNode)right).compareTo(new NumberNode(0)) == 0) {
				throw new ArithmeticException("Attempted to divide by zero. Please check your rules");
			}
		}
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode)left).divide((NumberNode)right);
		}
		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			return ((NumberNode)innerNode).multiply(new NumberNode(-1));
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

	@Override
	public ExpressionNode Visit(RuleVariableNode node) throws Exception {
		throw new Exception("Rulevariablenode persists in condition. Please check the structure of your rules. ");
	}

}
