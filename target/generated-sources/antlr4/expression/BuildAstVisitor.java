package expression;

import java.util.ArrayList;

import Arithmetic.ArithmeticBaseVisitor;
import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;

public class BuildAstVisitor extends ArithmeticBaseVisitor<ExpressionNode> {

	ArrayList<Rule> rules;

	public BuildAstVisitor(ArrayList<Rule> ruleSet) {
		rules = ruleSet;
	}

	@Override
	public ExpressionNode visitCompileUnit(ArithmeticParser.CompileUnitContext context) {
		System.out.println("\n\nAST - CompileUnit: " + context.getText());

		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitNum(ArithmeticParser.NumContext context) {
		System.out.println("\nAST Number : " + context.getText());
		return new NumberNode(Double.valueOf(context.value.getText()));
	}

	@Override
	public ExpressionNode visitVar(ArithmeticParser.VarContext context) {
		System.out.println("\nAST Variable : " + context.getText());
		return new RuleVariableNode(context.getText());
	}

	@Override
	public ExpressionNode visitParenthetical(ArithmeticParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitUnaryExpression(ArithmeticParser.UnaryExpressionContext context) {
		System.out.println("\nAST Unary");
		ExpressionNode node = null;
		switch (context.op.getType()) {
		case ArithmeticLexer.OP_ADD:
			System.out.println("Positive Unary");
			node = visit(context.expression());
			break;

		case ArithmeticLexer.OP_SUB:
			System.out.println("Negative Unary");
			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			System.out.println("Unary Number");
		}
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {
		System.out.println("Variable : " + context.value.getText());

		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitOperation(ArithmeticParser.OperationContext context) {

		OperationNode node = null;
		NumberNode calculation = null;
		switch (context.op.getType()) {
		case ArithmeticLexer.OP_ADD:
			System.out.println("Addition: ");
			node = new AdditionNode();

			break;

		case ArithmeticLexer.OP_SUB:
			System.out.println("Subtractison: ");
			node = new SubtractionNode();

			break;

		case ArithmeticLexer.OP_MUL:
			System.out.println("Multiplication: ");
			node = new MultiplicationNode();
			break;

		case ArithmeticLexer.OP_DIV:
			System.out.println("Division: ");
			node = new DivisionNode();
			break;

		default:
			System.out.println("FAIL");
		}

		System.out.println("VISITING LEFT");
		node.Left = visit(context.left);

		System.out.println("VISITING RIGHT");
		node.Right = visit(context.right);

		System.out.println("Visitng Operation : " + node.getClass() + "          :       " + node.Left.toString()
				+ " ,  " + node.Right.toString());
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
		System.out.println("\nAST Function : " + context.getText());
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			// HERE - call to a thing that gets the real arguments 
			// e.g. arguments for additionNode
			
			arguments.add(visit(context.expression(i)));
			System.out.println("HERE " + arguments.get(i).getClass());
		}
		System.out.println(arguments);

		Rule appliedRule = null;

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		if (rules != null) {
			for (Rule r : rules) {
				 System.out.println("\nMatching " + context.getText() + " to " +
				 r.lhs.getText());

				if (((FunctionNode) r.lhsNode).match(f)) {
					System.out.println("Rule Matched");
					appliedRule = new Rule(r.lhs, r.rhs, r.conditions);
					System.out.println("\n applied rule set");
					break;
				}
			}
		}
		// for safety, maybe convert the function arguments into a separate data
		// structure, so I don't mess with the FunctionNode

		if (appliedRule != null) {
			System.out.println(appliedRule.variables + " " + f.arguments.get(0).getClass());
			// Handlea thing that allows for operations to feed into the arguments
			
			
			// Empty ArrayList = {} , call a method for each argument, determines how to get each of the base variables
			
			
			for (String key : appliedRule.variables.keySet()) {
				if (appliedRule.variables.get(key) == null) {
					appliedRule.variables.put(key, arguments.get(0));
				} else if (appliedRule.variables.get(key) != null) {
					// variable is implicitly a number
				}
				f.arguments.remove(0);
			}

			// Handle the conditions.
			/*
			 * I need to consider these before the rule is applied. 2 rules can have the
			 * same LHS but opposing constraints Likely solution: When a matching LHS is
			 * found, take the variables of that rule into a separate data structure. Fill a
			 * new LinkedHashMap and use those variables to consider whether the constraints
			 * hold Create the new AppliedRule object using the boolean returned from the
			 * evaluateConditionsVisitor
			 * 
			 */
			System.out.println("\n\n ---------------  Building Condition Nodes  ---------------------- \n\n");
			ExpressionNode conditionsTest = new BuildConditionsVisitor().visitRuleConditions(appliedRule.conditions);

			System.out.println("\n\n -----------------  Evaluating Condition Tree  -------------------- \n\n");
			System.out.println("\n\n Conditions Valid : "
					+ new EvaluateConditionsVisitor(appliedRule.variables).Visit(conditionsTest));
			// System.out.println(appliedRule.rhsNode.getClass()+ " " +
			// appliedRule.rhs.getText());
			System.out.println("\n\n------------------------------------------------------\n\n");
			appliedRule.rhsNode = new BuildRhsVisitor(appliedRule.variables, rules, 0)
					.visitCompileUnit(appliedRule.rhs);
			return appliedRule.rhsNode;
			// Should be:
			// return new
			// BuildAstVisitor(appliedRule.variables).visitCompileUnit(appliedRule.rhs);

		} else {
			System.out.println("\n\nNO RULES MATCHED\n\n");
		}
		return f;

	}
	
	
	
	
	
	
	
	
	

}
