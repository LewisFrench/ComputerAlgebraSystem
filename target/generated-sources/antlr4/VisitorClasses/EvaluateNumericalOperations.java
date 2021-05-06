package VisitorClasses;

import java.math.BigInteger;
import java.util.ArrayList;
import Nodes.*;
import VisitClasses.VisitTerm;
/**
 * Evaluates numerical operations present in an algebraic term or a rule RHS
 * once the rule variables have been substituted. OperationNode nodes between
 * two instances of NumberNode can often be evaluated.
 * 
 * @author lewis
 *
 */
public class EvaluateNumericalOperations extends VisitTerm<ExpressionNode> {

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		// Perform Exponentiation if LHS and RHS are numerical
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode) left).exponentiate((NumberNode) right);
		}
		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		// Perform addition if LHS and RHS are numerical
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode) left).add((NumberNode) right);
		}
		
		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		// Perform subtraction if LHS and RHS are numerical
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode) left).subtract((NumberNode) right);
		}
		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		// Perform multiplication if LHS and RHS are numerical
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode) left).multiply((NumberNode) right);
		}
		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		// Divide by zero error
		if (right instanceof NumberNode) {
			if (((NumberNode) right).compareTo(new NumberNode(BigInteger.ZERO)) == 0) {
				throw new ArithmeticException("Attempted to divide by zero.");
			}
		}
		
		// Perform division if LHS and RHS are numerical
		if (left instanceof NumberNode && right instanceof NumberNode) {
			return ((NumberNode) left).divide((NumberNode) right);
		}
		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {

		ExpressionNode innerNode = Visit(node.getInnerNode());
		// Negate numerical value 
		if (innerNode instanceof NumberNode) {
			return ((NumberNode) innerNode).multiply(new NumberNode(BigInteger.valueOf(-1)));
		}
		return new UnaryNode(innerNode);
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.getArguments().get(i)));

		}

		return new FunctionNode(node.getFunction(), arguments);
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return node;
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return node;
	}

}
