package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import RuleAlgebra.RuleAlgebraBaseVisitor;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;

public class BuildLhsVisitor extends RuleAlgebraBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;

	public BuildLhsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}

	@Override
	public ExpressionNode visitRuleTerm(RuleAlgebraParser.RuleTermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitDecimal(RuleAlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.getText());
		
		String formattedDecimal = b.stripTrailingZeros().toPlainString();
		if (!(formattedDecimal.contains("."))){
			return new NumberNode(Long.valueOf(formattedDecimal));
		}

		String[] splitByDecimalPoint = formattedDecimal.split("\\.");		
		long numerator = Long.valueOf(formattedDecimal.replaceAll("\\.", ""));
		
		int numberOfDecimalPlaces = splitByDecimalPoint[1].length();
		long denominator = 1;
		for (int i = 0; i < numberOfDecimalPlaces ; i ++) {
			denominator *= 10;
		}
		return new NumberNode(numerator, denominator);
	}
	
	@Override
	public ExpressionNode visitInteger(RuleAlgebraParser.IntegerContext context) {
		return new NumberNode(Long.valueOf(context.getText()));
	}
	
	@Override
	public ExpressionNode visitRational(RuleAlgebraParser.RationalContext context) {
		String[] split = context.getText().split("/");
		long numerator = Long.valueOf(split[0]);
		long denominator = Long.valueOf(split[1]);
		return new NumberNode(numerator, denominator);
	}
	

	@Override
	public ExpressionNode visitParenthetical(RuleAlgebraParser.ParentheticalContext context) {
		return (visit(context.expression()));
	}

	@Override
	public ExpressionNode visitOperation(RuleAlgebraParser.OperationContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		OperationNode node = null;
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
			node = new DivisionNode(left, right);
			break;
		}

		return node;
	}

	@Override
	public ExpressionNode visitUnaryExpression(RuleAlgebraParser.UnaryExpressionContext context) {

		ExpressionNode node = visit(context.expression());
		switch (context.op.getType()) {
		case RuleAlgebraLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case RuleAlgebraLexer.OP_SUB:
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode)node).getNumerator()* -1 , ((NumberNode)node).getDenominator());
			}
			node = new UnaryNode(visit(context.expression()));
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(RuleAlgebraParser.RuleVariableContext context) {
		variables.put(context.getText(), null);

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
