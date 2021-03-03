package expression;

import java.util.LinkedHashMap;

public class EvaluateConditionsVisitor extends AstVisitor<Boolean> {

	LinkedHashMap<String, ExpressionNode> variables;
	ConditionFunctionEvaluator conditionFunctions;

	public EvaluateConditionsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
		this.conditionFunctions = new ConditionFunctionEvaluator(this.variables);
	}

	@Override
	public Boolean Visit(AdditionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(SubtractionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(MultiplicationNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(DivisionNode node) {
		// TODO Auto-generated method stub
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
	public Boolean Visit(RelopNode node) {

		// Interesting talking point: if the variable in the thing isn't comparable
		// (e.g. (x^2) > 1) then do I return true or false?

		// Current solution is ensuring that the value will be a number
		
		// Will need to outsource this method to handle < , > , == in switch statement

		boolean relopResult = calculateRelop(node.left, node.right, node.relop);
		return relopResult;
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

	public boolean calculateRelop(ExpressionNode left, ExpressionNode right, String relop) {
		NumberNode l;
		NumberNode r;
		if (left instanceof RuleVariableNode) {
			l = (NumberNode) this.variables.get(((RuleVariableNode) left).getValue());
		} else {
			l = (NumberNode) left;
		}
		if (right instanceof RuleVariableNode) {
			r = (NumberNode) this.variables.get(((RuleVariableNode) right).getValue());
		} else {
			r = (NumberNode) right;
		}

		boolean relopResult = false;
		// Use Constants for the reloperators
		switch (relop) {
		case "<":
			relopResult = l.getValue() < r.getValue();
			break;
		case ">":
			relopResult = l.getValue() > r.getValue();
			break;
		case "==":
			relopResult = l.getValue() == r.getValue();
			break;
		default:
			// Exception for the weird case
		}
		return relopResult;
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) {
		boolean test = this.conditionFunctions.determineFunction(node.functionName, node.argument);
		return test;

	}

	@Override
	public Boolean Visit(NotNode node) {
		return !(Visit(node.innerNode));
	}

}
