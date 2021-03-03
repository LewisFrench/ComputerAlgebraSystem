package expression;

import java.util.ArrayList;

public class ArgumentEvaluator extends AstVisitor<String>{

	ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
	
	
	@Override
	public String Visit(AdditionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(SubtractionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(MultiplicationNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(DivisionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(NumberNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(UnaryNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(FunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(RuleVariableNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(VariableNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(RelopNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(ConditionFunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(NotNode node) {
		// TODO Auto-generated method stub
		return null;
	}

}
