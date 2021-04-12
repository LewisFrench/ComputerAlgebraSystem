package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import RuleAlgebra.RuleAlgebraBaseVisitor;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;

public class BuildRhsVisitor extends RuleAlgebraBaseVisitor<ExpressionNode> {
	HashMap<String, ExpressionNode> variables;


	@Override
	public ExpressionNode visitRuleTerm(RuleAlgebraParser.RuleTermContext context) {
		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitDecimal(RuleAlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.value.getText());
		if (context.getText().contains("-")) {
			return new DecimalNode(b.multiply(new BigDecimal("-1")));
		}
		return new DecimalNode(b);
		
	}

	@Override
	public ExpressionNode visitInteger(RuleAlgebraParser.IntegerContext context) {
		System.out.println("VISITING INTEGER");
		if (context.getText().contains("-")) {
			return new IntegerNode(-1*Long.parseLong(context.value.getText()));
		}
		return new IntegerNode(Long.parseLong(context.value.getText()));
	}
	
	@Override
	public ExpressionNode visitRational(RuleAlgebraParser.RationalContext context) {
		long numerator;
		long denominator;
		String[] splitRational = context.getText().split("/");
		numerator = Long.parseLong(splitRational[0]);
		denominator = Long.parseLong(splitRational[1]);
		return (RationalFactory.createRational(numerator, denominator));
	}
	
	
	@Override
	public ExpressionNode visitParenthetical(RuleAlgebraParser.ParentheticalContext context) {
		return (visit(context.expression()));
	}

	@Override
	public ExpressionNode visitOperation(RuleAlgebraParser.OperationContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		ExpressionNode node = null;
		switch (context.op.getType()) {

		case RuleAlgebraLexer.OP_POW:
			node = new PowerNode(left, right);
			break;
		case RuleAlgebraLexer.OP_ADD:
			node = new AdditionNode(left, right);

			break;

		case RuleAlgebraLexer.OP_SUB:
			node = new SubtractionNode(left, right);

			break;

		case RuleAlgebraLexer.OP_MUL:
			node = new MultiplicationNode(left, right);
			break;

		case RuleAlgebraLexer.OP_DIV:
			if (left instanceof IntegerNode && right instanceof IntegerNode) {
				node = RationalFactory.createRational(((IntegerNode)left).getValue(), ((IntegerNode)right).getValue());
			} else {
				node = new DivisionNode(left, right);
			}
			break;

		}
		return node;
	}

	@Override
	public ExpressionNode visitUnaryExpression(RuleAlgebraParser.UnaryExpressionContext context) {
		System.out.println("VISITING UNARY");
		ExpressionNode node = visit(context.expression());
		switch (context.op.getType()) {
		case RuleAlgebraLexer.OP_ADD:
			node = visit(context.expression());
			break;
		case RuleAlgebraLexer.OP_SUB:
			if (node instanceof NumberNode) {
					if (node instanceof DecimalNode) {
						return new DecimalNode(((DecimalNode)node).getValue().multiply(BigDecimal.valueOf(-1)));
					}
					if (node instanceof IntegerNode) {
						return new IntegerNode(((IntegerNode)node).getValue()*-1);
					}
					if (node instanceof RationalNode) {
						return RationalFactory.createRational(-1*((RationalNode)node).numerator, ((RationalNode)node).denominator);
					}
			}
			node = new UnaryNode(visit(context.expression()));
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(RuleAlgebraParser.RuleVariableContext context) {
		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitVariable(RuleAlgebraParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitFunctionExpression(RuleAlgebraParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		return f;

	}

}
