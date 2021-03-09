package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Arithmetic.ArithmeticBaseVisitor;
import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;

public class BuildAstVisitor extends ArithmeticBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;
	ArrayList<Rule> rules;

	int depth;

	public BuildAstVisitor(ArrayList<Rule> ruleSet, int depth) {
		rules = ruleSet;
		this.depth = depth;
	}

	public BuildAstVisitor(LinkedHashMap<String, ExpressionNode> variables, ArrayList<Rule> rules, int depth) {

		this.variables = variables;
		this.rules = rules;
		this.depth = depth;
	}

	@Override
	public ExpressionNode visitCompileUnit(ArithmeticParser.CompileUnitContext context) {
		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitNum(ArithmeticParser.NumContext context) {
		return new NumberNode(Double.valueOf(context.value.getText()));
	}

	@Override
	public ExpressionNode visitVar(ArithmeticParser.VarContext context) {
		return new VariableNode(context.getText());
	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {
		if (this.variables.get(context.getText()) != null) {
			return this.variables.get(context.getText());
		}

		return new RuleVariableNode(context.getText());
	}

	@Override
	public ExpressionNode visitParenthetical(ArithmeticParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitUnaryExpression(ArithmeticParser.UnaryExpressionContext context) {
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

		node.Left = visit(context.left);
		node.Right = visit(context.right);

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
		if (this.depth > 400) {
			return null;
		}
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}
		boolean conditionsHold;
		Rule appliedRule = null;
		EvaluateTree argumentEvaluator = new EvaluateTree();
		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		
		if (rules != null) {
			for (Rule r : rules) {
				conditionsHold = false;
				if (argumentEvaluator.Visit(r.lhsNode, f)) {
					appliedRule = new Rule(r.lhs, r.rhs, r.conditions);

					if (!(argumentsValid(argumentEvaluator))) {
						System.out.println("Error: Variables with the same identifiers must match");
					}
					for (String key : appliedRule.variables.keySet()) {
						if (appliedRule.variables.get(key) == null) {
							appliedRule.variables.put(key, argumentEvaluator.arguments.get(0));
							argumentEvaluator.arguments.remove(0);
						} 
					}
			
					if (appliedRule.conditions != null) {
						ExpressionNode conditionsNode = new BuildConditionsVisitor(appliedRule.variables)
								.visitRuleConditions(appliedRule.conditions);
						conditionsHold = new EvaluateConditionsVisitor(appliedRule.variables).Visit(conditionsNode);
					}
					if (conditionsHold || appliedRule.conditions == null) {
						appliedRule.rhsNode = new BuildAstVisitor(appliedRule.variables, rules, this.depth + 1)
								.visitCompileUnit(appliedRule.rhs);
						return appliedRule.rhsNode;
					}
				}
			}
		}
		return f;

		}

	public boolean argumentsValid(EvaluateTree argumentEvaluator) {
		ArrayList<String> vars = argumentEvaluator.variables;
		ArrayList<ExpressionNode> args  = argumentEvaluator.arguments;
		for (int i = 0 ; i < vars.size() ; i++) {
			if (i != vars.indexOf(vars.get(i))) {
				if (!(argumentEvaluator.Visit(args.get(i), args.get(vars.indexOf(vars.get(i)))))) {
					return false;
				}
			}
		}
		return true;
	}
	
}
