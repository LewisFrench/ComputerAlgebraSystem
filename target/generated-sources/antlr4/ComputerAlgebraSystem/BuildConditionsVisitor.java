package ComputerAlgebraSystem;

import Conditions.ConditionsBaseVisitor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import RuleAlgebra.RuleAlgebraLexer;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;

public class BuildConditionsVisitor extends ConditionsBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;

//	public BuildConditionsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
//		this.variables = variables;
//	}

	public BuildConditionsVisitor() {

	}

	@Override
	public ExpressionNode visitConditionOperation(ConditionsParser.ConditionOperationContext context) {
		ConditionOperationNode node = null;
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		if (context.op.getType() == ConditionsLexer.OP_AND) {
			node = new ConditionAndNode(left, right);
		} else if (context.op.getType() == ConditionsLexer.OP_OR) {
			node = new ConditionOrNode(left, right);
		}

		return node;
	}

	@Override
	public ExpressionNode visitRuleConditions(ConditionsParser.RuleConditionsContext context) {
		return visit(context.condition());
	}

	@Override
	public ExpressionNode visitNot(ConditionsParser.NotContext context) {

		return new NotNode(visit(context.condition()));
	}

	@Override
	public ExpressionNode visitParenthetical(ConditionsParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitConditionParenthetical(ConditionsParser.ConditionParentheticalContext context) {
		return visit(context.condition());
	}

	// Needs looking at - only my functions are allowed
	// Comparisons to sin($A) etc. ?
	@Override
	public ExpressionNode visitConditionFunction(ConditionsParser.ConditionFunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}
		return new ConditionFunctionNode(context.function.getText(), arguments);
	}

	@Override
	public ExpressionNode visitConditionRelop(ConditionsParser.ConditionRelopContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		return new RelopNode(left, right, context.relop.getType(), context.relop.getText());
	}

	@Override
	public ExpressionNode visitUnaryExpression(ConditionsParser.UnaryExpressionContext context) {
		ExpressionNode node = null;

		switch (context.op.getType()) {
		case ConditionsLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case ConditionsLexer.OP_SUB:
			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			return node;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(ConditionsParser.OperationContext context) {
		OperationNode node = null;
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		switch (context.op.getType()) {
		case ConditionsLexer.OP_POW:
			node = new PowerNode(left, right);
			break;
		case ConditionsLexer.OP_ADD:
			node = new AdditionNode(left, right);

			break;

		case ConditionsLexer.OP_SUB:
			node = new SubtractionNode(left, right);

			break;

		case ConditionsLexer.OP_MUL:
			node = new MultiplicationNode(left, right);
			break;

		case ConditionsLexer.OP_DIV:
			node = new DivisionNode(left, right);
			break;

		default:
			System.out.println("FAIL");
		}

		return node;
	}

	public ExpressionNode visitFunctionExpression(ConditionsParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		return f;

	}

	@Override
	public ExpressionNode visitNumber(ConditionsParser.NumberContext context) {
		return new NumberNode(Double.valueOf(context.getText()));
	}

	@Override
	public ExpressionNode visitRuleVariable(ConditionsParser.RuleVariableContext context) {

//		if (this.variables.get(context.getText()) != null) {
//			return variables.get(context.getText());
//		}
		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitVariable(ConditionsParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}
}