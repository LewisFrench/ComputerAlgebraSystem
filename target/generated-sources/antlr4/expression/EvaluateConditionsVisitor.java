package expression;

import java.util.LinkedHashMap;

public class EvaluateConditionsVisitor extends AstVisitor<Boolean> {

	LinkedHashMap<String, ExpressionNode> variables;
	ConditionFunctionEvaluator conditionFunctions;

	public EvaluateConditionsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
		// this.variables = new LinkedHashMap<String, ExpressionNode>();
		// this.variables.put("$n", new NumberNode(3));
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

		System.out.println("VISITING RELOP EVALUATOR");
		System.out.println(node.left.toString() + node.relop + node.right.toString());
		System.out.println(this.variables);

		// Interesting talking point: if the variable in the thing isn't comparable
		// (e.g. (x^2) > 1) then do I return true or false?

		// Current solution is ensuring that the value will be a number
		System.out.println(
				"\nRelop\nVariable : " + variables.get(node.left.toString()) + "\nNumber : " + node.right.toString());
		// Will need to outsource this method to handle < , > , == in switch statement

		System.out.println("Visited Relop :  " + node.left.toString() + " " + node.relop + " " + node.right.toString());
		boolean relopResult = calculateRelop(node.left, node.right, node.relop);
		System.out.println("Relop Result " + relopResult);
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
			System.out.println("Left is a rulevariablenode");
			l = (NumberNode) this.variables.get(((RuleVariableNode) left).getValue());
		} else {
			System.out.println("Left is a NumberNode");
			l = (NumberNode) left;
		}
		if (right instanceof RuleVariableNode) {
			System.out.println("Right is a rulevariablenode");
			r = (NumberNode) this.variables.get(((RuleVariableNode) right).getValue());
		} else {
			System.out.println("Right is a NumberNode");
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
		System.out.println("Evaluating Function " + node.functionName);
		boolean test = this.conditionFunctions.determineFunction(node.functionName, node.argument);
		System.out.println("Function holds " + test);
		return test;

	}

	@Override
	public Boolean Visit(NotNode node) {
		System.out.println("Evaluating NOT");
		return !(Visit(node.innerNode));
	}

}
