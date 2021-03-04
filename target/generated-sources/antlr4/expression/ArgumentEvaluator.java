package expression;

import java.util.ArrayList;

public class ArgumentEvaluator extends AstVisitor<Boolean>{
	
	ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
	ExpressionNode contextNode;
	
	public ArgumentEvaluator(ExpressionNode contextNode) {
		this.contextNode = contextNode;
	}
	
	@Override
	public Boolean Visit(AdditionNode node) {
		System.out.println(node.toString());
		System.out.println(contextNode.toString());
		
		return null;
	}
	

	@Override
	public Boolean Visit(SubtractionNode node) {
		return null;
	}

	@Override
	public Boolean Visit(MultiplicationNode node) {
		return null;
	}

	@Override
	public Boolean Visit(DivisionNode node) {
		this.arguments.add(node.Left);
		this.arguments.add(node.Right);
		return null;
	}

	@Override
	public Boolean Visit(NumberNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(UnaryNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(FunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(RuleVariableNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(VariableNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(RelopNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(NotNode node) {
		// TODO Auto-generated method stub
		return null;
	}

}
