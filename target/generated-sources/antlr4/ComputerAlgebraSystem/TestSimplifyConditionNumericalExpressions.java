package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestSimplifyConditionNumericalExpressions {

	@Test
	public void testSimpleAddition() {
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
	public void testSimpleSubtraction() {
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
	public void testSimpleMultiplication() {
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
	public void testSimpleDivision() {
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
	public void testSimpleExponentiation() {
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
	public void testParentheticalOperation() {
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
	public void testUnaryOperation() {
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
	public void testComplexOperationAdditionUnaryParenthetical() {
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
	public void testNonNumericalExpression_False () {
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
	public void testComplexOperationLogicalAND_True() {
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
	public void testComplexOperationLogicalOR_True() {
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
	public void testComplexOperationLogicalNOT_True() {
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
