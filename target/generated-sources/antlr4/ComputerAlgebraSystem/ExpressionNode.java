package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

//class ParentheticalNode extends ExpressionNode {
//	public ExpressionNode innerNode;
//
//	public ParentheticalNode(ExpressionNode innerNode) {
//		this.innerNode = innerNode;
//	}
//
//	public String toString() {
//		return "(" + this.innerNode.toString() + ")";
//	}
//}

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

abstract class NumberNode extends ExpressionNode {
	/// Might need to make these return ExpressionNode in the case of
	/// rational/decimal unmanageable cases
	// e.g. am I handling 2.428^(1/31)
	abstract public ExpressionNode add(NumberNode augend);

	abstract public ExpressionNode subtract(NumberNode subtrahend);

	abstract public ExpressionNode multiply(NumberNode multiplicand);

	abstract public ExpressionNode divide(NumberNode divisor) throws Exception;

	abstract public ExpressionNode exponentiate(NumberNode exponent);

	abstract public int compareNumber(NumberNode node);

}

class DecimalNode extends NumberNode {
	public BigDecimal value;

	public DecimalNode(BigDecimal b) {
		this.value = b;
	}

	public DecimalNode(double d) {
		BigDecimal b = BigDecimal.valueOf(Double.valueOf(d));
		this.value = b;
	}

	public String toString() {
		return String.valueOf(this.getValue().stripTrailingZeros().toPlainString());
	}

	public BigDecimal getValue() {
		return this.value;
	}

	@Override

	public ExpressionNode add(NumberNode augend) {
		// Decimal + Decimal
		if (augend instanceof DecimalNode) {
			return new DecimalNode(((DecimalNode) this).getValue().add(((DecimalNode) augend).getValue()));
		}
		// Decimal + Integer
		else  if (augend instanceof IntegerNode) {
			return new DecimalNode(
					((DecimalNode) this).getValue().add(BigDecimal.valueOf(((IntegerNode) augend).getValue())));
		}
		// Decimal + Rational
		else {
			return new AdditionNode(this, augend);
		}
	}

	@Override
	public ExpressionNode subtract(NumberNode subtrahend) {
		// Decimal - Decimal
		if (subtrahend instanceof DecimalNode) {
			return new DecimalNode(((DecimalNode) this).getValue().subtract(((DecimalNode) subtrahend).getValue()));
		} 
		// Decimal - Integer
		else if (subtrahend instanceof IntegerNode)
		{
			return new DecimalNode(((DecimalNode) this).getValue()
					.subtract(BigDecimal.valueOf(((IntegerNode) subtrahend).getValue())));
		} 
		// Decimal - Rational
		else {
			return new SubtractionNode (this, subtrahend);
		}
	}

	@Override
	public ExpressionNode multiply(NumberNode multiplicand) {
		// Decimal * Decimal
		if (multiplicand instanceof DecimalNode) {
			return new DecimalNode(((DecimalNode) this).getValue().multiply(((DecimalNode) multiplicand).getValue()));
		} 
		// Decimal * Integer
		else if (multiplicand instanceof IntegerNode) {
			return new DecimalNode(((DecimalNode) this).getValue()
					.multiply(BigDecimal.valueOf(((IntegerNode) multiplicand).getValue())));
		}
		// Decimal * Rational
		else {
			return new MultiplicationNode(this, multiplicand);
		}
	}

	@Override
	// Make corrections for divisions by zero
	// Add a divisionScale most likely

	// This currently doesn't work : EAch of th e cases ( divisor instanceof
	// decimal, and integer) must have a try and catch, currently the catch-all just
	// does decimal divisions, will throw error
	public ExpressionNode divide(NumberNode divisor) throws Exception {
		try {
			// Decimal / Decimal
			if (divisor instanceof DecimalNode) {
				
				// do I need a check for /0.0 here? Probably, since 0.0 would be a decimal and have a val of 0
				
				return new DecimalNode(((DecimalNode) this).getValue().divide(((DecimalNode) divisor).getValue()));
			} 
			// Decimal / Integer
			else if (divisor instanceof IntegerNode){
				if (((IntegerNode) divisor).getValue() == 0) {
					throw new IllegalArgumentException("Attempted to divide by zero");
				}
				return new DecimalNode(
						((DecimalNode) this).getValue().divide(BigDecimal.valueOf(((IntegerNode) divisor).getValue())));
			}
			// Decimal / Rational
			else {
				return new DivisionNode(this, divisor);
			}
		} catch (ArithmeticException ae) {
			return new DecimalNode(((DecimalNode) this).getValue().divide(((DecimalNode) divisor).getValue(), 30,
					RoundingMode.CEILING));
		
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Attempted to divide a decimal number by zero");
		}
	}

	@Override
	public ExpressionNode exponentiate(NumberNode exponent) {
		if (exponent instanceof DecimalNode) {
			return new DecimalNode(new BigDecimal(Math.pow(((DecimalNode) this).getValue().doubleValue(),
					((DecimalNode) exponent).getValue().doubleValue())));
		} else { // exponent is integernode
			return new DecimalNode(new BigDecimal(Math.pow(((DecimalNode) this).getValue().doubleValue(),
					BigDecimal.valueOf(((IntegerNode) exponent).getValue()).doubleValue())));
		}
	}

	@Override
	// Currently a placeholder
	public int compareNumber(NumberNode node) {
		if (node instanceof DecimalNode) {
			return this.getValue().compareTo(((DecimalNode) node).getValue());
		} else {
			return this.getValue().compareTo(BigDecimal.valueOf(((IntegerNode) node).getValue()));
		} // need case for rational

	}

}

class IntegerNode extends NumberNode {
	public long value;

	public IntegerNode(long l) {
		this.value = l;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

	public long getValue() {
		return this.value;
	}

	@Override
	public ExpressionNode add(NumberNode augend) {
		// Integer + Integer
		if (augend instanceof IntegerNode) {
			return new IntegerNode(((IntegerNode) this).getValue() + ((IntegerNode) augend).getValue());
		}
		// Integer + Decimal
		else if (augend instanceof DecimalNode) {
			return new DecimalNode(
					((DecimalNode) augend).getValue().add(BigDecimal.valueOf(((IntegerNode) this).getValue())));
		}
		// Integer + Rational
		else {
			RationalNode rationalAugend = (RationalNode) augend;
			long numerator = (rationalAugend.denominator * this.value) + rationalAugend.numerator;
			return new RationalFactory().createRational(numerator, rationalAugend.denominator);
		}
	}

	@Override
	public ExpressionNode subtract(NumberNode subtrahend) {
		// Integer - Integer
		if (subtrahend instanceof IntegerNode) {
			return new IntegerNode(this.getValue() - ((IntegerNode) subtrahend).getValue());

		}
		// Integer - Decimal
		else if (subtrahend instanceof DecimalNode) {
			return new DecimalNode(BigDecimal.valueOf(((IntegerNode) this).getValue())
					.subtract(((DecimalNode) subtrahend).getValue()));
		}
		// Integer - Rational
		else {
			RationalNode rationalSubtrahend = (RationalNode) subtrahend;
			return new RationalFactory().createRational(
					this.value * rationalSubtrahend.denominator - rationalSubtrahend.numerator,
					rationalSubtrahend.denominator);
		}
	}

	@Override
	public ExpressionNode multiply(NumberNode multiplicand) {
		// Integer * Integer
		if (multiplicand instanceof IntegerNode) {
			return new IntegerNode(((IntegerNode) this).getValue() * ((IntegerNode) multiplicand).getValue());
		}
		// Integer * Decimal
		else if (multiplicand instanceof DecimalNode) {
			return new DecimalNode(((DecimalNode) multiplicand).getValue()
					.multiply(BigDecimal.valueOf(((IntegerNode) this).getValue())));
		}
		// Integer * Rational
		else {
			RationalNode rationalMultiplicand = (RationalNode) multiplicand;
			return new RationalFactory().createRational(rationalMultiplicand.numerator * this.value,
					rationalMultiplicand.denominator);
		}
	}

	@Override
	public ExpressionNode divide(NumberNode divisor) {
		// Integer / Integer
		if (divisor instanceof IntegerNode) {
			if (((IntegerNode) divisor).getValue() == 0) {
				throw new IllegalArgumentException("Attempted to divide by 0, please check your rules");
			}
			return new RationalFactory().createRational(this.value, ((IntegerNode) divisor).getValue());
		}
		// Integer / Decimal
		else if (divisor instanceof DecimalNode) {
			// throw division by 0 error here too, this one is less concrete
			return new DecimalNode(
					BigDecimal.valueOf(((IntegerNode) this).getValue()).divide(((DecimalNode) divisor).getValue()));
		}
		// Integer / Rational
		else {
			RationalNode rationalDivisor = (RationalNode) divisor;
			return new RationalFactory().createRational(this.value * rationalDivisor.denominator,
					rationalDivisor.numerator);
		}
	}

	@Override
	public ExpressionNode exponentiate(NumberNode exponent) {
		if (exponent instanceof IntegerNode) {
			if (((IntegerNode) exponent).getValue() > 0) {
				return new IntegerNode((long) Math.pow((double) ((IntegerNode) this).getValue(),
						(double) ((IntegerNode) exponent).getValue()));

				// Do I want to do this? It's a bit loss of accuracy - return rational
				// 1/(this^exponent?
				// Should be rational 1/*this.value)^abs(exponent)
			} else {
				System.out.println("Raising integer to negative power" + "");
				return new DecimalNode(
						new BigDecimal(Math.pow(BigDecimal.valueOf(((IntegerNode) this).getValue()).doubleValue(),
								(BigDecimal.valueOf(((IntegerNode) exponent).getValue()).doubleValue()))));

			}
		} else {
			return new DecimalNode(
					new BigDecimal(Math.pow(BigDecimal.valueOf(((IntegerNode) this).getValue()).doubleValue(),
							((DecimalNode) exponent).getValue().doubleValue())));
		}
	}

	@Override
	// Placeholder
	public int compareNumber(NumberNode node) {
		if (node instanceof IntegerNode) {
			return Long.compare(this.getValue(), (((IntegerNode) node).getValue()));
		} else {
			// Check for clarity of long value conversion, might be better the other way
			return Long.compare(this.getValue(), (((DecimalNode) node).getValue().longValue()));
		}
	}
}

class RationalNode extends NumberNode {
	public long numerator;
	public long denominator;

	public RationalNode(long numerator, long denominator) {
		long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
		
		// Normalise negative denominators
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		// Simplify
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	private static long gcd(long numerator, long denominator) {
		if (denominator == 0) {
			return numerator;
		}
		return gcd(denominator, numerator % denominator);

	}
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
//	private static void normaliseAndSimplify() {
//		
//	}

	@Override
	public ExpressionNode add(NumberNode augend) {
		// Rational + Decimal
		if (augend instanceof DecimalNode) {
			return new AdditionNode(this, augend);
			// Rational + Integer
		} else if (augend instanceof IntegerNode) {
			long numerator = (this.denominator * (((IntegerNode) augend).getValue()) + this.numerator);
			return new RationalFactory().createRational(numerator, denominator);
			// Rational + Rational
		} else {// (augend instanceof RationalNode)
			RationalNode rationalAugend = (RationalNode) augend;
			long numerator = (this.numerator * rationalAugend.denominator)
					+ (this.denominator * rationalAugend.denominator);
			long denominator = this.denominator * rationalAugend.denominator;
			return new RationalFactory().createRational(numerator, denominator);

		}

	}

	@Override
	public ExpressionNode subtract(NumberNode subtrahend) {
		// Rational - Decimal
		if (subtrahend instanceof DecimalNode) {
			return new SubtractionNode(this, subtrahend);
			// Rational + Decimal
		} else if (subtrahend instanceof IntegerNode) {
			long numerator = (this.denominator * (((IntegerNode) subtrahend).getValue()) - this.numerator);
			return new RationalFactory().createRational(numerator, denominator);
		} else {
			RationalNode rationalSubtrahend = (RationalNode) subtrahend;
			long numerator = (this.numerator * rationalSubtrahend.denominator)
					- (this.denominator * rationalSubtrahend.denominator);
			long denominator = this.denominator * rationalSubtrahend.denominator;
			return new RationalFactory().createRational(numerator, denominator);
		}
	}

	@Override
	public ExpressionNode multiply(NumberNode multiplicand) {
		if (multiplicand instanceof DecimalNode) {
			return new MultiplicationNode(this, multiplicand);
		} else if (multiplicand instanceof IntegerNode) {
			return new RationalFactory().createRational(this.numerator * (((IntegerNode) multiplicand).getValue()),
					this.denominator);
		} else {
			RationalNode rationalMultiplicand = (RationalNode) multiplicand;
			return new RationalFactory().createRational(this.numerator * rationalMultiplicand.numerator,
					this.denominator * rationalMultiplicand.denominator);
		}
	}

	@Override
	public ExpressionNode divide(NumberNode divisor) throws Exception {
		if (divisor instanceof DecimalNode) {
			return new DivisionNode(this, divisor);
		} else if (divisor instanceof IntegerNode) {
			return new RationalFactory().createRational(this.numerator,
					this.denominator * ((IntegerNode) divisor).getValue());
		} else { // is instance of rationalNode
			RationalNode rationalDivisor = (RationalNode) divisor;
			return new RationalFactory().createRational(this.numerator * rationalDivisor.denominator,
					this.denominator * rationalDivisor.numerator);
		}
	}

	@Override
	public ExpressionNode exponentiate(NumberNode exponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareNumber(NumberNode node) {
		// TODO Auto-generated method stub
		return 0;
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
