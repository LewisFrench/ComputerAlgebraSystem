package ComputerAlgebraSystem;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FetchRuleVariables extends RuleTermVisitor<ExpressionNode> {

	LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

	public FetchRuleVariables() {

	}

	public LinkedHashMap<String, ExpressionNode> getVariables() {
		return this.variables;
	}

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		return new DivisionNode(left, right);
	}

//	@Override
//	public ExpressionNode Visit(ParentheticalNode node) throws Exception {
//		return new ParentheticalNode(Visit(node.innerNode));
//	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		return new UnaryNode(Visit(node.innerNode));
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
	public ExpressionNode Visit(DecimalNode node) {
		return node;
	}
	@Override
	public ExpressionNode Visit(IntegerNode node)  {
		return node;
	}
	
	@Override
	public ExpressionNode Visit(RationalNode node) throws Exception {
		return  node;
	}
	
	
	@Override
	public ExpressionNode Visit(RuleVariableNode node) {
		this.variables.put(node.toString(), null);
		return node;
	}

	



}
