package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class SimplifyNumericalOperations extends TermVisitor<ExpressionNode> {

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.Left);
		ExpressionNode right = Visit(node.Right);

		if (left instanceof NumberNode && right instanceof NumberNode) {
			if (left instanceof IntegerNode) {
				return ((IntegerNode) left).exponentiate((NumberNode) right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode) left).exponentiate((NumberNode) right);
			}
			if (left instanceof RationalNode) {
				return ((RationalNode) left).exponentiate((NumberNode) right);
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
				return ((IntegerNode) left).add((NumberNode) right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode) left).add((NumberNode) right);
			}
			if (left instanceof RationalNode) {
				return ((RationalNode) left).add((NumberNode) right);
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
				return ((IntegerNode) left).subtract((NumberNode) right);
			} else if (left instanceof DecimalNode) {
				return ((DecimalNode) left).subtract((NumberNode) right);
			}
			if (left instanceof RationalNode) {
				return ((RationalNode) left).subtract((NumberNode) right);
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
					return ((IntegerNode) left).multiply((NumberNode) right);
				} else if (left instanceof DecimalNode) {
					return ((DecimalNode) left).multiply((NumberNode) right);
				}
				if (left instanceof RationalNode) {
					return ((RationalNode) left).multiply((NumberNode) right);
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
					return ((IntegerNode) left).divide((NumberNode) right);
				} else if (left instanceof DecimalNode) {
					return ((DecimalNode) left).divide((NumberNode) right);
				}
				if (left instanceof RationalNode) {
					return ((RationalNode) left).divide((NumberNode) right);
				}
			}
		}
		return new DivisionNode(left, right);
	}

//	@Override
//	public ExpressionNode Visit(ParentheticalNode node) throws Exception {
//		ExpressionNode innerNode = Visit(node.innerNode);
//		if (innerNode instanceof NumberNode) {
//			return ((NumberNode)innerNode);
//		}
//		return new ParentheticalNode(innerNode);
//	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {

		ExpressionNode innerNode = Visit(node.innerNode);
		if (innerNode instanceof NumberNode) {
			if (innerNode instanceof DecimalNode) {
				return new DecimalNode((((DecimalNode) innerNode).getValue()).multiply(BigDecimal.valueOf(-1)));
			}
			if (innerNode instanceof IntegerNode){
				return new IntegerNode(((IntegerNode)innerNode).getValue() * -1);
			}
			if (innerNode instanceof RationalNode) {
				return RationalFactory.createRational(((RationalNode)innerNode).numerator * -1, ((RationalNode)innerNode).denominator);
			}

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
	public ExpressionNode Visit(RationalNode node) throws Exception {
		return node;
	}

}
