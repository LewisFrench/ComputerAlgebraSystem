package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FetchConditionRuleVariables extends ConditionVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

	public FetchConditionRuleVariables() {
	}

	@Override
	public ExpressionNode Visit(ConditionAndNode node) {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionAndNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ConditionOrNode node) {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionOrNode(left, right);
	}

	@Override
	public ExpressionNode Visit(NotNode node) {
		return new NotNode(Visit(node.innerNode));
	}

	@Override
	public ExpressionNode Visit(RelopNode node) {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new RelopNode(left, right, node.relop, node.relopText);
	}

	@Override
	public ExpressionNode Visit(ConditionFunctionNode node) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return new ConditionFunctionNode(node.functionName, arguments);
	}

	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) {
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			return ((NumberNode) innerNode);
		}
		return new ParentheticalNode(innerNode);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {

		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			double invertedValue = (((NumberNode) innerNode).getValue()) * -1;
			return new NumberNode(invertedValue);
		}
		return new UnaryNode(innerNode);
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

	@Override
	public ExpressionNode Visit(RuleVariableNode node) {
		this.variables.put(node.toString(), null);
		return node;
	}
}