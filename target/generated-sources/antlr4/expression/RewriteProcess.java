package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RewriteProcess extends AstVisitor<ExpressionNode>{
	LinkedHashMap<String, ExpressionNode> variables;
	ArrayList<Rule> rules;

	int depth;

	public RewriteProcess(ArrayList<Rule> ruleSet, int depth) {
		rules = ruleSet;
		this.depth = depth;
		
	}

	public RewriteProcess(LinkedHashMap<String, ExpressionNode> variables, ArrayList<Rule> rules, int depth) {

		this.variables = variables;
		this.rules = rules;
		this.depth = depth;
	}
	@Override
	public ExpressionNode Visit(PowerNode node) {
		ExpressionNode rwLeft =  rewrite(Visit(node.Left));
		ExpressionNode rwRight =  rewrite(Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode) {
			return rewrite(new NumberNode(Math.pow((((NumberNode) node.Left).getValue()) , ((NumberNode) node.Right).getValue())));
		}
	
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) {
		ExpressionNode rwLeft =  rewrite(Visit(node.Left));
		ExpressionNode rwRight =  rewrite(Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode) {
			return rewrite(new NumberNode(((NumberNode) node.Left).getValue() + ((NumberNode) node.Right).getValue()));
		}
	
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) {
		ExpressionNode rwLeft =  rewrite(Visit(node.Left));
		ExpressionNode rwRight =  rewrite(Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode) {
			return rewrite(new NumberNode(((NumberNode) node.Left).getValue() - ((NumberNode) node.Right).getValue()));
		}
	
		return rewrite(node);
	}


	@Override
	public ExpressionNode Visit(MultiplicationNode node) {
		ExpressionNode rwLeft =  rewrite(Visit(node.Left));
		ExpressionNode rwRight =  rewrite(Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode) {
			return rewrite(new NumberNode(((NumberNode) node.Left).getValue() * ((NumberNode) node.Right).getValue()));
		}
	
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) {
		// TODO Auto-generated method stub
		ExpressionNode rwLeft =  rewrite(Visit(node.Left));
		ExpressionNode rwRight =  rewrite(Visit(node.Right));
		node.Left = rwLeft;
		node.Right = rwRight;
		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode) {
			return rewrite(new NumberNode(((NumberNode) node.Left).getValue() / ((NumberNode) node.Right).getValue()));
		}
	
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) {
		node.innerNode = rewrite(node.innerNode);
		
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) {
		for (int i = 0 ; i < node.getArguments().size() ; i ++) {
			node.arguments.set(i, rewrite(Visit(node.arguments.get(i))));
			
		}

		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(RuleVariableNode node) {
		if (this.variables.get(node.toString()) != null){
			return this.variables.get(node.toString());
		}

		return node;
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return rewrite(node);
	}

	@Override
	public ExpressionNode Visit(RelopNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressionNode Visit(ConditionFunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressionNode Visit(NotNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressionNode Visit(ConditionAndNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressionNode Visit(ConditionOrNode node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ExpressionNode rewrite(ExpressionNode node) {
		boolean conditionsHold;
		Rule appliedRule = null;
		EvaluateTree argumentEvaluator = new EvaluateTree();
		if (rules != null) {
			for (Rule r : rules) {
				conditionsHold = false;
				if (argumentEvaluator.Visit(r.lhsNode, node)) {
					appliedRule = new Rule(r.lhs, r.rhs, r.conditions);
					
					if (!(argumentsValid(argumentEvaluator))) {
						System.out.println("Error: Variables with the same identifiers must match");
					}
					// TODO : else { here so that arguments that don't match with the rule (with repeating argument variables)
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
						
						// For getting poster screenshot
						//System.out.println("Matched Term " + node.toString() + "\nto rule " + appliedRule.toString());
						//appliedRule.rhsNode = new BuildAstVisitor(appliedRule.variables, rules, this.depth + 1)
								//.visitCompileUnit(appliedRule.rhs);
						appliedRule.rhsNode = new RewriteProcess(appliedRule.variables, rules, this.depth+1).Visit(new BuildAstVisitor().visitCompileUnit(appliedRule.rhs));
								
								return appliedRule.rhsNode;
					}
				}
			}
		}
		return node;
	}
	public boolean argumentsValid(EvaluateTree argumentEvaluator) {
		ArrayList<String> vars = argumentEvaluator.variables;
		ArrayList<ExpressionNode> args = argumentEvaluator.arguments;
		for (int i = 0; i < vars.size(); i++) {
			if (i != vars.indexOf(vars.get(i))) {
				if (!(argumentEvaluator.Visit(args.get(i), args.get(vars.indexOf(vars.get(i)))))) {
					return false;
				}
			}
		}
		return true;
	}
}
