package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;
import Nodes.*;
import VisitorClasses.EvaluateConditions;
public class TestEvaluateConditionsVisitor {

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_GT_Numerical_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");

		try {
			assertTrue(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_GT_Numerical_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf((2))), ConditionsLexer.RELOP_GT, ">");

		try {
			assertFalse(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_GTE_Numerical_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new NumberNode(BigInteger.valueOf((1))), ConditionsLexer.RELOP_GTE, ">=");

		try {
			assertTrue(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_GTE_Numerical_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new NumberNode(BigInteger.valueOf((2))), ConditionsLexer.RELOP_GTE, ">=");

		try {
			assertFalse(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LT_Numerical_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new NumberNode(BigInteger.valueOf((2))), ConditionsLexer.RELOP_LT, "<");

		try {
			assertTrue(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LT_Numerical_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((3))), new NumberNode(BigInteger.valueOf((2))), ConditionsLexer.RELOP_LT, "<");

		try {
			assertFalse(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LTE_Numerical_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new NumberNode(BigInteger.valueOf((1))), ConditionsLexer.RELOP_LTE, "<=");

		try {
			assertTrue(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LTE_Numerical_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((3))), new NumberNode(BigInteger.valueOf((2))), ConditionsLexer.RELOP_LTE, "<=");

		try {
			assertFalse(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_NonNumerical_Exception() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf((0))), new VariableNode("x"), ConditionsLexer.RELOP_GT,
				">");
		assertThrows(Exception.class, () -> e.Visit(relop));
		assertThrows(Exception.class, () -> e.Visit(relop2));

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_EQ_Simple_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new VariableNode("x"), ConditionsLexer.RELOP_EQ,
				"==");
		ExpressionNode relopNum = new RelopNode(new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4)), new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4)), ConditionsLexer.RELOP_EQ,
				"==");

		try {
			assertTrue(e.Visit(relop));
			assertTrue(e.Visit(relopNum));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_EQ_Simple_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new VariableNode("x"), ConditionsLexer.RELOP_EQ,
				"==");

		try {
			assertFalse(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_NEQ_Simple_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((1))), new VariableNode("x"), ConditionsLexer.RELOP_NEQ,
				"!=");

		try {
			assertTrue(e.Visit(relop));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_NEQ_Simple_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new VariableNode("x"), ConditionsLexer.RELOP_NEQ,
				"!=");
		ExpressionNode relopNum = new RelopNode(new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4)), new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4)), ConditionsLexer.RELOP_NEQ,
				"!=");

		try {
			assertFalse(e.Visit(relop));
			assertFalse(e.Visit(relopNum));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LogicalNOT() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode not = new ConditionNotNode(relop);
		try {
			assertFalse(e.Visit(not));
			assertTrue(e.Visit(new ConditionNotNode(not)));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LogicalAND_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		try {
			assertTrue(e.Visit(and));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LogicalAND_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((4))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		try {
			assertFalse(e.Visit(and));
			assertFalse(e.Visit(new ConditionAndNode(relop2, relop)));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LogicalOR_True() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((0))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((4))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionOrNode(relop, relop2);
		try {
			assertTrue(e.Visit(and));
			assertTrue(e.Visit(new ConditionOrNode(relop2, relop)));
			assertFalse(e.Visit(new ConditionOrNode(relop2, relop2)));
			assertTrue(e.Visit(new ConditionOrNode(relop, relop)));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_Relop_LogicalOR_False() {
		EvaluateConditions e = new EvaluateConditions();
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((4))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf((2))), new NumberNode(BigInteger.valueOf((4))), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionOrNode(relop, relop2);
		try {
			assertFalse(e.Visit(and));
			assertFalse(e.Visit(new ConditionOrNode(relop2, relop)));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_ConditionFunction_True() {
		EvaluateConditions e = new EvaluateConditions();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf((2))));
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		try {
			assertTrue(e.Visit(c));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_ConditionFunction_False() {
		EvaluateConditions e = new EvaluateConditions();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		try {
			assertFalse(e.Visit(c));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_ConditionFunction_ArgumentException() {
		EvaluateConditions e = new EvaluateConditions();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(c));
		arguments.add(new NumberNode(BigInteger.valueOf((2))));
		arguments.add(new NumberNode(BigInteger.valueOf((2))));
		assertThrows(Exception.class, () -> e.Visit(c));
	}

	@Test
	public void testEvaluateConditionsVisitor_Simple_ConditionFunction_NameException() {
		EvaluateConditions e = new EvaluateConditions();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode c = new ConditionFunctionNode("is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(c));
		arguments.add(new NumberNode(BigInteger.valueOf((2))));
		arguments.add(new NumberNode(BigInteger.valueOf((2))));
		assertThrows(Exception.class, () -> e.Visit(c));
	}

	@Test
	public void testVisiting_Unavailable_Nodes_Exception() {
		EvaluateConditions e = new EvaluateConditions();
		//ArrayList<ExpressionNode> arguments = new ArrayList<>();
		//ExpressionNode c = new ConditionFunctionNode("is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(new AdditionNode(new NumberNode(BigInteger.valueOf((2))), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new SubtractionNode(new NumberNode(BigInteger.valueOf((2))), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new DivisionNode(new NumberNode(BigInteger.valueOf((2))), new VariableNode("v"))));
		assertThrows(Exception.class,
				() -> e.Visit(new MultiplicationNode(new NumberNode(BigInteger.valueOf((2))), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new PowerNode(new NumberNode(BigInteger.valueOf((2))), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new UnaryNode(new NumberNode(BigInteger.valueOf((2))))));

		assertThrows(Exception.class, () -> e.Visit(new FunctionNode("TestFunction", new ArrayList<ExpressionNode>())));
		assertThrows(Exception.class, () -> e.Visit(new VariableNode("x")));
		assertThrows(Exception.class, () -> e.Visit(new NumberNode(BigInteger.valueOf((2)))));
		assertThrows(Exception.class, () -> e.Visit(new RuleVariableNode("x")));

	}

}
