package expression;

import java.util.LinkedHashMap;

import Conditions.ConditionsLexer;

// Could likely split the AstVisitor into two visitors, one for the expression only nodes, and one for conditionnodes
// Assuming I don't need them all for the is_literal() implementation

public class EvaluateConditionsVisitor extends AstVisitor<Boolean> {

	LinkedHashMap<String, ExpressionNode> variables;
	ConditionFunctionEvaluator conditionFunctions;

	public EvaluateConditionsVisitor(LinkedHashMap<String, ExpressionNode> variables) {
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

		// Interesting talking point: if the variable in the thing isn't comparable
		// (e.g. (x^2) > 1) then do I return true or false?

		// Current solution is ensuring that the value will be a number

		// Will need to outsource this method to handle < , > , == in switch statement

		//boolean relopResult = calculateRelop(node.left, node.right, node.relop);
		boolean relopResult = calculateRelop(node);
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
		if (this.variables.get(node.toString()) != null) {

		}
		return null;
	}

	@Override
	public Boolean Visit(VariableNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	//public boolean calculateRelop(ExpressionNode left, ExpressionNode right, String relop) {
	public boolean calculateRelop(RelopNode relopNode) {

		// Decide equivalence between any two nodes
		EvaluateTree treeMatcher = new EvaluateTree();
		if (relopNode.relop == ConditionsLexer.RELOP_EQ) {
			return treeMatcher.Visit(relopNode.left, relopNode.right);
		} else if (relopNode.relop == ConditionsLexer.RELOP_NEQ) {
			return !(treeMatcher.Visit(relopNode.left, relopNode.right));
		}
		NumberNode l;
		NumberNode r;
		l = getNumberNode(relopNode.left);
		r = getNumberNode(relopNode.right);
		
		boolean relopResult = false;
		
		switch (relopNode.relop) {
		
		case ConditionsLexer.RELOP_LT:
			relopResult = l.getValue() < r.getValue();
			break;
		case ConditionsLexer.RELOP_LTE:
			relopResult = l.getValue() <= r.getValue();
			break;
		case ConditionsLexer.RELOP_GT:
			relopResult = l.getValue() > r.getValue();
			break;
		case ConditionsLexer.RELOP_GTE:
			relopResult = l.getValue() >= r.getValue();
		default:
			// Exception for the weird case
		}
		return relopResult;
	}
	
	// Support for UnaryNode comparisons
	public NumberNode getNumberNode(ExpressionNode node) {
		if (node instanceof RuleVariableNode) {
			ExpressionNode value = this.variables.get(((RuleVariableNode) node).toString());
			if (value instanceof NumberNode) {
				return (NumberNode) value;
			}
		} else if (node instanceof NumberNode) {
			return (NumberNode) node;
		} else if (node instanceof UnaryNode) {
			if (((UnaryNode)node).innerNode instanceof NumberNode) {
				return new NumberNode(-1* ((NumberNode)((UnaryNode)node).innerNode).getValue());
			}
		}
		// Exception? - cannot compare the two nodes using > >= < <= operators
		
		return null;
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) {
		return this.conditionFunctions.determineFunction(node.functionName, node.arguments);
	}

	@Override
	public Boolean Visit(NotNode node) {
		return !(Visit(node.innerNode));
	}

	@Override
	public Boolean Visit(ConditionAndNode node) {
		return (Visit(node.left) && Visit(node.right));
	}

	@Override
	public Boolean Visit(ConditionOrNode node) {
		return (Visit(node.left) || Visit(node.right));
	}

	@Override
	public Boolean Visit(PowerNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ParentheticalNode node) {
		// TODO Auto-generated method stub
		return null;
	}

}
