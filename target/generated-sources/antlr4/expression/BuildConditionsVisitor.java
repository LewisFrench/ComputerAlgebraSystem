package expression;

import Conditions.ConditionsBaseVisitor;

import java.util.LinkedHashMap;

import Arithmetic.ArithmeticLexer;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;

public class BuildConditionsVisitor extends ConditionsBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;

	public BuildConditionsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
		System.out.println(this.variables);
	}

	@Override
	public ExpressionNode visitConditionOperation(ConditionsParser.ConditionOperationContext context) {
		ConditionOperationNode node = null;

		if (context.op.getType() == ConditionsLexer.OP_AND) {
			node = new ConditionAndNode();
		} else if (context.op.getType() == ConditionsLexer.OP_OR) {
			node = new ConditionOrNode();
		}
		node.left = visit(context.left);
		node.right = visit(context.right);

		return node;
	}

	@Override
	public ExpressionNode visitRuleConditions(ConditionsParser.RuleConditionsContext context) {
		System.out.println("Visit Rule Conditions");
		return visit(context.condition());
	}

	@Override
	public ExpressionNode visitNot(ConditionsParser.NotContext context) {
		System.out.println("Visiitng Not");

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

	// Likely need something here, should I allow user-written functions? or
	// something like sin(y) only?
	@Override
	public ExpressionNode visitFunction(ConditionsParser.FunctionContext context) {
		return new ConditionFunctionNode(context.function.getText(), visit(context.condExpr()));
	}

	@Override
	public ExpressionNode visitRelop(ConditionsParser.RelopContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		return new RelopNode(left, right, context.relop.getText());
	}

	@Override
	public ExpressionNode visitExpr(ConditionsParser.ExprContext context) {

		System.out.println(context.getText());
		System.out.println(context.expression().getText());
		ExpressionNode n = visit(context.expression());

		return n;
	}

	@Override
	public ExpressionNode visitUnaryExpression(ConditionsParser.UnaryExpressionContext context) {
		ExpressionNode node = null;
		switch (context.op.getType()) {
		case ArithmeticLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case ArithmeticLexer.OP_SUB:
			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(ConditionsParser.OperationContext context) {
		OperationNode node = null;

		switch (context.op.getType()) {
		case ConditionsLexer.OP_ADD:
			node = new AdditionNode();

			break;

		case ConditionsLexer.OP_SUB:
			node = new SubtractionNode();

			break;

		case ConditionsLexer.OP_MUL:
			node = new MultiplicationNode();
			break;

		case ConditionsLexer.OP_DIV:
			node = new DivisionNode();
			break;

		default:
			System.out.println("FAIL");
		}
		node.Left = visit(context.left);
		node.Right = visit(context.right);

		// Should outsource to another method
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof AdditionNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() + ((NumberNode) node.Right).getValue());
		}
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof SubtractionNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() - ((NumberNode) node.Right).getValue());
		}
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof MultiplicationNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() * ((NumberNode) node.Right).getValue());
		}
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof DivisionNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() / ((NumberNode) node.Right).getValue());
		}

		return node;
	}

	@Override
	public ExpressionNode visitNum(ConditionsParser.NumContext context) {
		System.out.println("\nVisitng Number " + context.getText());
		return new NumberNode(Double.valueOf(context.getText()));
	}

	@Override
	public ExpressionNode visitRuleVariable(ConditionsParser.RuleVariableContext context) {

		if (this.variables.get(context.getText()) != null) {
			return variables.get(context.getText());
		}
		System.out.println("TEST");
		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitVar(ConditionsParser.VarContext context) {
		return new VariableNode(context.value.getText());
	}
}
