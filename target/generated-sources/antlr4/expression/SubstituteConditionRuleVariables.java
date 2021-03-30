package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SubstituteConditionRuleVariables extends ConditionVisitor<ExpressionNode>{
	LinkedHashMap<String, ExpressionNode> ruleVariables = new LinkedHashMap<>();
	
	
	public SubstituteConditionRuleVariables(LinkedHashMap<String, ExpressionNode> ruleVariables) {
		this.ruleVariables = ruleVariables;
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

		return new FunctionNode(node.functionName, arguments);
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
		return new ParentheticalNode(Visit(node.innerNode));

	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		return new UnaryNode(Visit(node.innerNode));
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
		if (this.ruleVariables.get(node.toString()) != null) {
			return this.ruleVariables.get(node.toString());
		}
		// Exception;
		return null;
	}

}
