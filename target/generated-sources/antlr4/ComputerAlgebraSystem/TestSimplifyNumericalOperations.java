package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TestSimplifyNumericalOperations {


	@Test
	public void testSimpleAddition_can_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(2.1), new NumberNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSimpleAddition_cannot_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == AdditionNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSimpleSubtraction() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(2.1), new NumberNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSimpleSubtraction_cannot_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == SubtractionNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSimpleMultiplication() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(2.1), new NumberNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSimpleMultiplication_cannot_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == MultiplicationNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testSimpleDivision() {
		ExpressionNode division = new DivisionNode(new NumberNode(2.1), new NumberNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSimpleDivision_cannot_simplify() {
		ExpressionNode division = new DivisionNode(new NumberNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == DivisionNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testSimpleExponentiation() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2.1), new NumberNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSimpleExponentiation_cannot_simplify() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == PowerNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testComplexAddition() {

		ExpressionNode subAddition = new AdditionNode(new NumberNode(2.1), new NumberNode(3.2));
		ExpressionNode addition = new AdditionNode(new NumberNode(1.0), subAddition);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == NumberNode.class);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUnary() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));

		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() < 0.0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUnaryNumberAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		AdditionNode unaryAddition = new AdditionNode(unaryNode, new NumberNode(4.3));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() < 5.0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUnaryUnaryAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2.0));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() < 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testUnaryUnaryAddition_cannot_simplify() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new VariableNode("x"));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == AdditionNode.class);
		
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	@Test
	public void testUnaryUnarySubtraction() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2.0));

		ExpressionNode unarySubtracttion = new SubtractionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unarySubtracttion);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() > 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUnaryUnaryMultiplication() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2.0));

		ExpressionNode unaryMultiplication = new MultiplicationNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryMultiplication);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() > 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUnaryUnaryDivision() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2.0));

		ExpressionNode unaryDivisionNode = new DivisionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryDivisionNode);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() > 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void testParentheticalNumberAddition() {
		ExpressionNode addition = new AdditionNode(new NumberNode(1.1), new NumberNode(2.2));

		ExpressionNode parentheticalNode = new ParentheticalNode(addition);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(parentheticalNode);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getValue() > 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParentheticalNumberAddition_cannot_simplify() {
		ArrayList<ExpressionNode > arguments = new ArrayList<ExpressionNode>();
		arguments.add(new NumberNode(2));
		ExpressionNode addition = new AdditionNode(new NumberNode(1.1), new FunctionNode("testFunc", arguments));

		ExpressionNode parentheticalNode = new ParentheticalNode(addition);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(parentheticalNode);
			assertTrue(result.getClass() == ParentheticalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testVisitRuleVariableNode_Exception() {
		
		ExpressionNode rv = new RuleVariableNode("x");

		ExpressionNode parentheticalNode = new ParentheticalNode(rv);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		assertThrows(Exception.class, () -> s.Visit(rv));
	}
	

}
