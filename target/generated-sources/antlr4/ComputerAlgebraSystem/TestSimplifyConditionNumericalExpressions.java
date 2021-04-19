package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestSimplifyConditionNumericalExpressions {

	@Test
	public void testSimpleAddition() {
		ExpressionNode addition = new AdditionNode(new NumberNode(1,2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimpleAddition_cannot_simplify() {
		ExpressionNode addition = new AdditionNode(new VariableNode("q"), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertFalse(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleSubtraction() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(1,2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(subtraction, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimpleSubtraction_cannot_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(1), new VariableNode("q"));
		ExpressionNode relopGT = new RelopNode(subtraction, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertFalse(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleMultiplication() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(1,2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(multiplication, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimpleMultiplication_cannot_simplify() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(2));
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(1),
				new FunctionNode("TestFunc", arguments));
		ExpressionNode relopGT = new RelopNode(multiplication, new NumberNode(-0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertFalse(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleDivision() {
		ExpressionNode division = new DivisionNode(new NumberNode(11,2), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(division, new NumberNode(-0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	@Test
	public void testSimpleDivision_DivideByZero() {
		ExpressionNode division = new DivisionNode(new NumberNode(2,1), new NumberNode(0,2));
		ExpressionNode relopGT = new RelopNode(new NumberNode(-0), division, ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		assertThrows(ArithmeticException.class ,() -> s.Visit(relopGT));
	}
	
	@Test
	public void testComplexDivision_DivideByZero() {
		AdditionNode add = new AdditionNode(new NumberNode(2) , new NumberNode(3));
		SubtractionNode subtract = new SubtractionNode(add, new NumberNode(10,2));
		ExpressionNode division = new DivisionNode(new NumberNode(2,1), subtract);
		ExpressionNode relopGT = new RelopNode( new NumberNode(-0), division, ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		assertThrows(ArithmeticException.class ,() -> s.Visit(relopGT));
	}
	
	

	@Test
	public void testSimpleExponentiation() {
		ExpressionNode power = new PowerNode(new NumberNode(12), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(power, new NumberNode(03), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

//	@Test
//	public void testParentheticalOperation() {
//		ExpressionNode power = new PowerNode(new NumberNode(1.2), new NumberNode(1));
//		ExpressionNode parenthetical = new ParentheticalNode(power);
//		ExpressionNode relopGT = new RelopNode(parenthetical, new NumberNode(0.0), ConditionsLexer.RELOP_GT, ">");
//		SimplifyConditionNumericalExpressions s = new SimplifyConditionNumericalExpressions();
//
//		try {
//			ExpressionNode result = s.Visit(relopGT);
//			assertTrue(result instanceof RelopNode);
//			assertTrue(((RelopNode) result).left instanceof NumberNode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			fail();
//		}
//
//	}

	
	@Test
	public void testUnaryOperation() {
		ExpressionNode power = new PowerNode(new NumberNode(1,2), new NumberNode(1));
		ExpressionNode unary = new UnaryNode(power);
		ExpressionNode relopGT = new RelopNode(unary, new NumberNode(0), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();

		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryOperation_cannot_Simplify() {
		ExpressionNode power = new DivisionNode(new UnaryNode(new VariableNode("o")), new NumberNode(1));
		ExpressionNode unary = new UnaryNode(power);
		ExpressionNode relopGT = new RelopNode(unary, new NumberNode(3), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		
		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof UnaryNode);
			assertTrue(((RelopNode)result).right instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testComplexOperationAdditionUnary() {
		ExpressionNode parenthetical = new NumberNode(3);
		ExpressionNode unaryNode = new UnaryNode(parenthetical);
		ExpressionNode addition = new AdditionNode(new NumberNode(1), unaryNode);
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(88,3), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(relopGT);
			assertTrue(result instanceof RelopNode);
			assertTrue(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testNonNumericalExpression_False() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode relopGT = new RelopNode(addition, new NumberNode(044,2), ConditionsLexer.RELOP_GT, ">");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(relopGT);
			assertFalse(((RelopNode) result).left instanceof NumberNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testComplexOperationLogicalAND_True() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ExpressionNode conditionAndNode = new ConditionAndNode(
				new RelopNode(addition, new NumberNode(53,2), ConditionsLexer.RELOP_GT, ">"),
				new RelopNode(addition, new NumberNode(0), ConditionsLexer.RELOP_GT, ">"));
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(conditionAndNode);
			assertFalse(((ConditionAndNode) result).left instanceof NumberNode);
			assertFalse(((ConditionAndNode) result).right instanceof NumberNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testComplexOperationLogicalOR_True() {
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), new NumberNode(1));
		ArrayList<ExpressionNode> conditionFunctionArguments = new ArrayList<ExpressionNode>();
		conditionFunctionArguments.add(new AdditionNode(new NumberNode(2,1), new NumberNode(1)));
		ExpressionNode conditionOrNode = new ConditionOrNode(
				new RelopNode(addition, new NumberNode(0), ConditionsLexer.RELOP_GT, ">"),
				new ConditionFunctionNode("_is_number", conditionFunctionArguments));
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(conditionOrNode);
			assertTrue(((ConditionOrNode) result).left instanceof RelopNode);
			assertTrue(((ConditionOrNode) result).right instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode)((ConditionOrNode) result).right).arguments.get(0) instanceof NumberNode);
			
		} catch (Exception e) {
			fail();
		}
	}
	

	@Test
	public void testComplexOperationLogicalNOT_True() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(2), new NumberNode(1));
		ExpressionNode conditionOrNode = new ConditionOrNode(
				new RelopNode(subtraction, new VariableNode("p"), ConditionsLexer.RELOP_GT, ">"),
				new RelopNode(subtraction, new NumberNode(0), ConditionsLexer.RELOP_GT, ">"));
		ExpressionNode not = new ConditionNotNode(conditionOrNode);
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		try {
			ExpressionNode result = s.Visit(not);
			ConditionNotNode notResult = (ConditionNotNode) result;
			assertTrue(notResult.innerNode instanceof ConditionOrNode);
			RelopNode leftRelop = (RelopNode) (((ConditionOrNode) notResult.innerNode).left);
			RelopNode rightRelop = (RelopNode) (((ConditionOrNode) notResult.innerNode).right);
			assertTrue(leftRelop.left instanceof NumberNode);
			assertTrue(leftRelop.right instanceof VariableNode);
			assertTrue(rightRelop.left instanceof NumberNode);
			assertTrue(rightRelop.right instanceof NumberNode);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test 
	public void testVisitRuleVariable_Exception() {
		ExpressionNode rv = new RuleVariableNode("c");
		EvaluateConditionNumericalExpressions s = new EvaluateConditionNumericalExpressions();
		
		ExpressionNode relop = new RelopNode(new PowerNode(new NumberNode(2,3), new VariableNode("x")), rv,ConditionsLexer.RELOP_GT, ">");
		assertThrows(Exception.class, () -> s.Visit(relop) );
	}

}
