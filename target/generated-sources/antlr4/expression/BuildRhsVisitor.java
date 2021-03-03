package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Arithmetic.ArithmeticBaseVisitor;
import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;

public class BuildRhsVisitor extends ArithmeticBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;
	ArrayList<Rule> rules;
	int depth;

	public BuildRhsVisitor(LinkedHashMap<String, ExpressionNode> variables, ArrayList<Rule> rules, int depth) {

		this.variables = variables;
		this.rules = rules;
		this.depth = depth;
	}

	@Override
	public ExpressionNode visitCompileUnit(ArithmeticParser.CompileUnitContext context) {
		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {

		if (variables.get("$" + context.value.getText()) != null) {
			return variables.get("$" + context.value.getText());
		}

		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitNum(ArithmeticParser.NumContext context) {
		return new NumberNode(Double.valueOf(context.value.getText()));
	}

	@Override
	public ExpressionNode visitOperation(ArithmeticParser.OperationContext context) {

		OperationNode node = null;
		switch (context.op.getType()) {
		case ArithmeticLexer.OP_ADD:

			node = new AdditionNode();

			break;

		case ArithmeticLexer.OP_SUB:

			node = new SubtractionNode();
			break;

		case ArithmeticLexer.OP_MUL:

			node = new MultiplicationNode();
			break;

		case ArithmeticLexer.OP_DIV:

			node = new DivisionNode();
			break;

		default:
			System.out.println("FAIL");
		}
		// System.out.println("Variables : " + variables);

		node.Left = visit(context.left);
		node.Right = visit(context.right);

		// Likely have a method here for possible types of calculations, e.g. variable +
		// variable = 2Variable
		// number + number, number - number, number * number, number/number
		// Depends on how my solver will work!;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof AdditionNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() + ((NumberNode) node.Right).getValue());
		} else if (node.Left instanceof NumberNode && node.Right instanceof NumberNode
				&& node instanceof SubtractionNode) {
			return new NumberNode(((NumberNode) node.Left).getValue() - ((NumberNode) node.Right).getValue());
		}
		return node;
	}

	@Override
	public ExpressionNode visitFunctionExpression(ArithmeticParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		Rule appliedRule = null;

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		if (rules != null) {
			for (Rule r : rules) {

				if (((FunctionNode) r.lhsNode).match(f)) {

					appliedRule = new Rule(r.lhs, r.rhs, r.conditions);
					break;
				}
			}
		}
		// for safety, maybe convert the function arguments into a seperate data
		// structure, so I don't mess with the FunctionNode

		if (appliedRule != null) {

			for (String key : appliedRule.variables.keySet()) {

				if (appliedRule.variables.get(key) == null) {

					appliedRule.variables.put(key, arguments.get(0));
				} else if (appliedRule.variables.get(key) != null) {

					// variable is implicitly a number
					appliedRule.variables.put(key, arguments.get(0));
				}
				f.arguments.remove(0);

			}

			// Can likely move this first line into the constructor of the Rule object, and
			// invoke it in the subsequent line using appliedRule.conditionsNode or
			// something
			ExpressionNode conditionsTest = new BuildConditionsVisitor().visitRuleConditions(appliedRule.conditions);
			System.out.println("\n\n Conditions Valid : "
					+ new EvaluateConditionsVisitor(appliedRule.variables).Visit(conditionsTest));

			// System.out.println("DEPTH : " + this.depth + " variables : " + this.variables
			// );
			// System.out.println("\nLayer in > > > > > > > > > > ");

			// System.out.println(appliedRule.toString());

			appliedRule.rhsNode = new BuildRhsVisitor(appliedRule.variables, rules, this.depth + 1)
					.visitCompileUnit(appliedRule.rhs);
			// System.out.println("Layer out < < < < < < < < < < \n");
			// System.out.println("DEPTH : " + this.depth + " variables : " + this.variables
			// );

			return appliedRule.rhsNode;
			// Should be:
			// return new
			// BuildAstVisitor(appliedRule.variables).visitCompileUnit(appliedRule.rhs);

		}
		return f;

	}

}
