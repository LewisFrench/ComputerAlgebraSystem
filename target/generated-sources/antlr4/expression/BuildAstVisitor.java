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
		return new RuleVariableNode(context.getText());
	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {
		if (variables.get("$" + context.value.getText()) != null) {
			return variables.get("$" + context.value.getText());
		}

		return new RuleVariableNode(context.value.getText());
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
		NumberNode calculation = null;
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
		System.out.println("\n\n Visit FUnction " + context.getText() + "\n\n");
		//System.out.println("Visitng Function : " + context.getText());
		
		//System.out.println("\nVisiting function arguments : ");
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			//ExpressionNode n = visit(context.expression(i));
			arguments.add(visit(context.expression(i)));
		}
		System.out.println("ARGUMENTS" + arguments);
		
		
		
		Rule appliedRule = null;

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		if (rules != null) {
			for (Rule r : rules) {
				if (((FunctionNode) r.lhsNode).match(f)) {
					System.out.println("\n\n"+ context.getText() + "  matched to   " + r.toString());
					appliedRule = new Rule(r.lhs, r.rhs, r.conditions);
					break;
				}
			}
		}
		
		// for safety, maybe convert the function arguments into a separate data
		// structure, so I don't mess with the FunctionNode

		
		/*
		 * 
		 * Need to transmute : Operations nodes should add their Left and Right into an arrayList
		 * This couldbe made more efficient
		 * 
		 */
		ArrayList<ExpressionNode> temp = new ArrayList<>();
		for (ExpressionNode n : arguments) {
			if (n instanceof FunctionNode) {
				for (ExpressionNode arg : ((FunctionNode) n).arguments ) {
					temp.add(arg);
				}
			}
		}
		
		//ArrayList<ExpressionNode> temp = new ArrayList<>();
		for (ExpressionNode arg : arguments) {
			System.out.println("arg : " + arg.toString());
			if (arg instanceof OperationNode) {
				System.out.println("OperationNode");
				temp.add(((OperationNode)arg).Left);
				temp.add(((OperationNode)arg).Right);
			}
		}
		
		
		
		if (appliedRule != null) {

			arguments = temp;
			System.out.println(arguments);
			// Handlea thing that allows for operations to feed into the arguments

			// Empty ArrayList = {} , call a method for each argument, determines how to get
			// each of the base variables
	
			System.out.println("\n\nVariables : " + appliedRule.variables);
			System.out.println(temp);
			System.out.println("\nApplied Rule "  + appliedRule.toString());
			System.out.println(appliedRule.variables.keySet());
			for (String key : appliedRule.variables.keySet()) {
				System.out.println("-----------------\n" + key);
				if (appliedRule.variables.get(key) == null) {
					System.out.println("\n" + key + " is null   " + temp.get(0));
					appliedRule.variables.put(key, temp.get(0));
				} else if (appliedRule.variables.get(key) != null) {
					
					// variable is implicitly a number
				}
				temp.remove(0);
				//arguments.remove(0);
			}
			System.out.println(appliedRule.variables);
			//System.out.println("Applied rule variables  :   " + appliedRule.variables);
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

			// Can likely move this first line into the constructor of the Rule object, and
			// invoke it in the subsequent line using appliedRule.conditionsNode or
			// something
			if( appliedRule.conditions!= null) {
				ExpressionNode conditionsTest = new BuildConditionsVisitor().visitRuleConditions(appliedRule.conditions);
			}
			appliedRule.rhsNode = new BuildAstVisitor(appliedRule.variables, rules, this.depth + 1).visitCompileUnit(appliedRule.rhs);
			System.out.println(appliedRule.rhsNode);
			return appliedRule.rhsNode;

		} else {
			//System.out.println("\n\nNO RULES MATCHED to " + f.toString() + "\n\n");
		}
		//System.out.println("Returning Function :  " + f.toString());
		return f;

	}

}
