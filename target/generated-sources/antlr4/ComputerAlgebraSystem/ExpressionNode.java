package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

abstract class CompileUnitNode {
	ExpressionNode expression;

}

public abstract class ExpressionNode {
}

abstract class OperationNode extends ExpressionNode {

	public ExpressionNode Left;
	public ExpressionNode Right;
	public String operator;

	public ExpressionNode getLeft() {
		return Left;
	}

	public ExpressionNode getRight() {
		return Right;
	}
}

class PowerNode extends OperationNode {

	public PowerNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;

	}

	public String toString() {
		return (getLeft().toString() + " ^ " + getRight().toString());
	}
}

class AdditionNode extends OperationNode {

	public AdditionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;

	}

	public String toString() {
		return (getLeft().toString() + " + " + getRight().toString());
	}
}

class SubtractionNode extends OperationNode {
	public SubtractionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;

	}

	public String toString() {
		return (getLeft().toString() + " - " + getRight().toString());
	}
}

class MultiplicationNode extends OperationNode {
	public MultiplicationNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;

	}

	public String toString() {
		return (getLeft().toString() + " * " + getRight().toString());
	}
}

class DivisionNode extends OperationNode {
	public DivisionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;

	}

	public String toString() {
		return (getLeft().toString() + " / " + getRight().toString());
	}
}

class UnaryNode extends ExpressionNode {
	public ExpressionNode innerNode;

	public UnaryNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "-" + this.innerNode.toString();
	}
}

class FunctionNode extends ExpressionNode {
	public String function;
	public ArrayList<ExpressionNode> arguments;

	public FunctionNode(String function, ArrayList<ExpressionNode> arguments) {
		this.function = function;
		this.arguments = arguments;
	}

	public ArrayList<ExpressionNode> getArguments() {
		return this.arguments;
	}

	public String toString() {
		return this.function + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}
}

class NumberNode extends ExpressionNode {

	long numerator;
	long denominator;

	public NumberNode(long numerator, long denominator) {
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long gcdValue = gcd(numerator, denominator);
		this.numerator = numerator / gcdValue;
		this.denominator = denominator / gcdValue;
	}

	public NumberNode(long numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}

	public String toString() {
		if (!isInteger()) {
			// Handle recurring and complicated decimal output. Only print as decimal if
			// under a certain amount of dp

			return String.valueOf(this.numerator + "/" + this.denominator);
		} else {
			return String.valueOf(this.numerator);
		}
	}

	public int compareTo(NumberNode n) {
		long lhs = this.numerator * n.denominator;
		long rhs = this.denominator * n.numerator;
		if (lhs < rhs) {
			return -1;
		} else if (lhs > rhs) {
			return 1;
		} else {
			return 0;
		}
	}

	public NumberNode getReciprocal() {
		return new NumberNode(this.denominator, this.numerator);
	}

	public NumberNode add(NumberNode node) {
		return new NumberNode((this.numerator * node.denominator) + (this.denominator * node.numerator),
				this.denominator * node.denominator);
	}

	public NumberNode subtract(NumberNode node) {
		return new NumberNode(this.numerator * node.denominator - this.denominator * node.numerator,
				this.denominator * node.denominator);
	}

	public NumberNode multiply(NumberNode node) {
		System.out.println("multipying " + this.toString() + "  *  " + node.toString());
		return new NumberNode(this.numerator * node.numerator, this.denominator * node.denominator);
	}

	public NumberNode divide(NumberNode node) {
		return this.multiply(node.getReciprocal());
	}
	
	public ExpressionNode exponentiate(NumberNode node) {
		if (node.isInteger()) {
			
			long exponent = node.getNumerator();
			if (node.getNumerator() < 0) {
				// Here
			
				return new NumberNode(LongMath.raiseToPowerLong(this.getDenominator(), Math.abs(exponent)) , LongMath.raiseToPowerLong(this.getNumerator(), Math.abs(exponent)));
			} else {
				return new NumberNode(LongMath.raiseToPowerLong(this.getNumerator(), exponent) , LongMath.raiseToPowerLong(this.getDenominator(), exponent));
			}
		}
		return new PowerNode(this, node);
	}

	public long getNumerator() {
		return this.numerator;
	}

	public long getDenominator() {
		return this.denominator;
	}

	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return Math.abs(gcd(b, a % b));
	}

	private boolean isInteger() {
		return this.denominator == 1;
	}

}

class VariableNode extends ExpressionNode {
	public String value;

	public VariableNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return this.getValue();
	}

}

class RuleVariableNode extends ExpressionNode {
	public String value;

	public RuleVariableNode(String value) {
		this.value = value;
	}

	public String toString() {
		return "$" + this.value;
	}

}

class ConditionOperationNode extends ExpressionNode {

	ExpressionNode left;
	ExpressionNode right;

}

class ConditionAndNode extends ConditionOperationNode {
	public ConditionAndNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return this.left.toString() + " & " + this.right.toString();
	}
}

class ConditionOrNode extends ConditionOperationNode {
	public ConditionOrNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return this.left.toString() + " | " + this.right.toString();
	}
}

class RelopNode extends ExpressionNode {
	ExpressionNode left;
	ExpressionNode right;
	int relop;
	String relopText;

	public RelopNode(ExpressionNode left, ExpressionNode right, int relop, String relopText) {
		this.left = left;
		this.right = right;
		this.relop = relop;
		this.relopText = relopText;
	}

	public String toString() {
		return left.toString() + relopText + right.toString();
	}
}

class ConditionFunctionNode extends ExpressionNode {
	String functionName;
	ArrayList<ExpressionNode> arguments;

	public ConditionFunctionNode(String functionName, ArrayList<ExpressionNode> arguments) {
		this.functionName = functionName;
		this.arguments = arguments;
	}

	public ArrayList<ExpressionNode> getArguments() {
		return this.arguments;
	}

	public String toString() {
		return this.functionName + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}

}

class NotNode extends ExpressionNode {

	public ExpressionNode innerNode;

	public NotNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "!" + this.innerNode.toString();
	}

}
