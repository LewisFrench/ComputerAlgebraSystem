package ComputerAlgebraSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Conditions.ConditionsLexer;

class TestSimplifyConditionNumericalExpressions {

	@Test
	void testSimpleAddition() {
		ExpressionNode addition = new AdditionNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testSimpleSubtraction() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(subtraction, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void testSimpleMultiplication() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(multiplication, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void testSimpleDivision() {
		ExpressionNode division= new DivisionNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(division, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void testSimpleExponentiation() {
		ExpressionNode power = new PowerNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(power, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void testParentheticalOperation() {
		ExpressionNode power = new PowerNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode parenthetical = new ParentheticalNode(power);
		ExpressionNode relopGT = new RelopNode(parenthetical, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void testUnaryOperation() {
		ExpressionNode power = new PowerNode(new NumberNode(1.2), new NumberNode(1));
		ExpressionNode unary = new UnaryNode(power);
		ExpressionNode relopGT = new RelopNode(unary, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void testComplexOperationAdditionUnaryParenthetical() {
		ExpressionNode parenthetical = new ParentheticalNode(new NumberNode(3));
		ExpressionNode unaryNode = new UnaryNode(parenthetical);
		ExpressionNode addition = new AdditionNode(new NumberNode(1), unaryNode);
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void testNonNumericalExpression_False () {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
		try { 
		ExpressionNode result = s.Visit(relopGT);
		assertFalse(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testComplexOperationLogicalAND_True() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode conditionAndNode = new ConditionAndNode(new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"), new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"));
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
		try { 
		ExpressionNode result = s.Visit(conditionAndNode);
		assertFalse(((ConditionAndNode) result).left instanceof NumberNode);
		assertFalse(((ConditionAndNode) result).right instanceof NumberNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testComplexOperationLogicalOR_True() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode conditionOrNode = new ConditionOrNode(new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"), new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"));
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
		System.out.println("HERE " +s.toString());
		try { 
		ExpressionNode result = s.Visit(conditionOrNode);
		assertFalse(((ConditionOrNode) result).left instanceof NumberNode);
		assertFalse(((ConditionOrNode) result).right instanceof NumberNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testComplexOperationLogicalNOT_True() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode conditionOrNode = new ConditionOrNode(new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"), new RelopNode(addition, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">"));
		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
		try { 
		ExpressionNode result = s.Visit(conditionOrNode);
		assertFalse(((ConditionOrNode) result).left instanceof NumberNode);
		assertFalse(((ConditionOrNode) result).right instanceof NumberNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
