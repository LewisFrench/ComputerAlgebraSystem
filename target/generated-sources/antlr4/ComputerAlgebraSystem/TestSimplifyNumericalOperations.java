package ComputerAlgebraSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimplifyNumericalOperations {

	@Test
	void testSimpleAddition() {
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
	void testSimpleSubtraction() {
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
	void testSimpleMultiplication() {
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
	void testSimpleDivision() {
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
	void testSimpleExponentiation() {
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
	void testComplexAddition() {

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
	void testUnary() {
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
	void testUnaryNumberAddition() {
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
	void testUnaryUnaryAddition() {
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
	void testUnaryUnarySubtraction() {
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
	void testUnaryUnaryMultiplication() {
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
	void testUnaryUnaryDivision() {
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
	void testParentheticalNumberAddition() {
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
}
