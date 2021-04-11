package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SimplifyConditionNumericalExpressions extends ConditionVisitor<ExpressionNode> {

	@Override
	public ExpressionNode Visit(ConditionAndNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionAndNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ConditionOrNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new ConditionOrNode(left, right);
	}

	@Override
	public ExpressionNode Visit(NotNode node) throws Exception {
		return new NotNode(Visit(node.innerNode));
	}

	@Override
	public ExpressionNode Visit(RelopNode node) throws Exception {
		ExpressionNode left = Visit(node.left);
		ExpressionNode right = Visit(node.right);
		return new RelopNode(left, right, node.relop, node.relopText);
	}

	@Override
	public ExpressionNode Visit(ConditionFunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return new ConditionFunctionNode(node.functionName, arguments);
	}
//	
//	@Override
//	public ExpressionNode Visit(PowerNode node) throws Exception {
//		ExpressionNode left = Visit(node.Left);
//		ExpressionNode right = Visit(node.Right);
//
//		if (left instanceof DecimalNode && right instanceof DecimalNode) {
//			return new DecimalNode(new BigDecimal(Math.pow(((DecimalNode) node.Left).getValue().doubleValue(), ((DecimalNode) node.Right).getValue().doubleValue())));
//		}
//		return new PowerNode(left, right);
//	}
//	@Override
//	public ExpressionNode Visit(AdditionNode node) throws Exception {
//		ExpressionNode left = Visit(node.Left);
//		ExpressionNode right = Visit(node.Right);
//		if (left instanceof DecimalNode && right instanceof DecimalNode) {
//			return new DecimalNode(((DecimalNode) left).getValue().add(((DecimalNode) right).getValue()));
//		}
//		return new AdditionNode(left, right);
//	}
//
//	@Override
//	public ExpressionNode Visit(SubtractionNode node) throws Exception {
//		ExpressionNode left = Visit(node.Left);
//		ExpressionNode right = Visit(node.Right);
//		if (left instanceof DecimalNode && right instanceof DecimalNode) {
//			return new DecimalNode(((DecimalNode) left).getValue().subtract(((DecimalNode) right).getValue()));
//		}
//		return new SubtractionNode(left, right);
//	}
//
//	@Override
//	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
//		ExpressionNode left = Visit(node.Left);
//		ExpressionNode right = Visit(node.Right);
//		if (left instanceof DecimalNode && right instanceof DecimalNode) {
//			return new DecimalNode(((DecimalNode) left).getValue().multiply(((DecimalNode) right).getValue()));
//		}
//		return new MultiplicationNode(left, right);
//	}
//
//	@Override
//	public ExpressionNode Visit(DivisionNode node) throws Exception {
//		ExpressionNode left = Visit(node.Left);
//		ExpressionNode right = Visit(node.Right);
//		if (left instanceof DecimalNode && right instanceof DecimalNode) {
//			return new DecimalNode(((DecimalNode) left).getValue() .divide(((DecimalNode) right).getValue()));
//		}
//		return new DivisionNode(left, right);
//	}

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof IntegerNode) {
				return ((IntegerNode)left).exponentiate((NumberNode)right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode)left).exponentiate((NumberNode)right);
			}
		}
		return new PowerNode(left, right);
	}
	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		
		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof IntegerNode) {
				return ((IntegerNode)left).add((NumberNode)right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode)left).add((NumberNode)right);
			}
		}
		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof IntegerNode) {
				return ((IntegerNode)left).subtract((NumberNode)right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode)left).subtract((NumberNode)right);
			}
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof NumberNode && right instanceof NumberNode) {
				if (left instanceof IntegerNode) {
					return ((IntegerNode)left).multiply((NumberNode)right);
				} else if (left instanceof DecimalNode) {
					return ((DecimalNode)left).multiply((NumberNode)right);
				}
			}
		}
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);
		
		// Handle division by 0 exception
		// Add bigdecimal division scale, rounding method
		
		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof NumberNode && right instanceof NumberNode) {
				if (left instanceof IntegerNode) {
					return ((IntegerNode)left).divide((NumberNode)right);
				} else if (left instanceof DecimalNode) {
					return ((DecimalNode)left).divide((NumberNode)right);
				}
			}
		}
		return new DivisionNode(left, right);
	}


//	@Override
//	public ExpressionNode Visit(ParentheticalNode node) throws Exception {
//		ExpressionNode innerNode = Visit(node.innerNode);
//		if (innerNode instanceof DecimalNode) {
//			return ((DecimalNode)innerNode);
//		}
//		return new ParentheticalNode(innerNode);
//	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		
		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof DecimalNode) {
			return new DecimalNode( (((DecimalNode)innerNode).getValue()).multiply(new BigDecimal(-1)));
			
		}
		return new UnaryNode(innerNode);
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.arguments.get(i)));

		}

		return new FunctionNode(node.function, arguments);
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return node;
	}

	@Override
	public ExpressionNode Visit(DecimalNode node) {
		return node;
	}
	
	@Override
	public ExpressionNode Visit(IntegerNode node) throws Exception {
		return node;
	}

	

	@Override
	public ExpressionNode Visit(RuleVariableNode node) throws Exception {
		throw new Exception("Rulevariablenode persists in condition. Please check the structure of your rules. ");
	}


}
