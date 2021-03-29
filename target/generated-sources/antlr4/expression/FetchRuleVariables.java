package expression;

import java.util.LinkedHashMap;

public class FetchRuleVariables extends RuleTermVisitor<ExpressionNode> {

	LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

	public FetchRuleVariables() {

	}

	public LinkedHashMap<String, ExpressionNode> getVariables() {
		return this.variables;
	}

	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		node.Left = left;
		node.Right = right;
		return node;
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		node.Left = left;
		node.Right = right;
		return node;
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		node.Left = left;
		node.Right = right;
		return node;// TODO Auto-generated method stub
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		node.Left = left;
		node.Right = right;
		return node;
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		node.Left = left;
		node.Right = right;
		return node;
	}

	@Override
	public ExpressionNode Visit(ParentheticalNode node) {
		node.innerNode = Visit(node.innerNode);
		return node;
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		node.innerNode = Visit(node.innerNode);
		return node;
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) {
		for (int i = 0; i < node.getArguments().size(); i++) {
			node.arguments.set(i, (Visit(node.arguments.get(i))));

		}

		return node;
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
