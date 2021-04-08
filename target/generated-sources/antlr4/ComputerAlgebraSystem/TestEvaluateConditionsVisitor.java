package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestEvaluateConditionsVisitor {

	@Test
	public void testSimple_Relop_GT_Numerical_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		
		try { 
			assertTrue(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}

	@Test
	public void testSimple_Relop_GT_Numerical_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(2)), ConditionsLexer.RELOP_GT, ">");
		
		try { 
			assertFalse(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}


	
	@Test
	public void testSimple_Relop_GTE_Numerical_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(1)), ConditionsLexer.RELOP_GTE, ">=");
		
		try { 
			assertTrue(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}

	@Test
	public void testSimple_Relop_GTE_Numerical_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(2)), ConditionsLexer.RELOP_GTE, ">=");
		
		try { 
			assertFalse(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	
	
	@Test
	public void testSimple_Relop_LT_Numerical_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(2)), ConditionsLexer.RELOP_LT, "<");
		
		try { 
			assertTrue(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}

	@Test
	public void testSimple_Relop_LT_Numerical_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(3)), new NumberNode(new BigDecimal(2)), ConditionsLexer.RELOP_LT, "<");
		
		try { 
			assertFalse(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	
	@Test
	public void testSimple_Relop_LTE_Numerical_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new NumberNode(new BigDecimal(1)), ConditionsLexer.RELOP_LTE, "<=");
		
		try { 
			assertTrue(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}

	@Test
	public void testSimple_Relop_LTE_Numerical_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(3)), new NumberNode(new BigDecimal(2)), ConditionsLexer.RELOP_LTE, "<=");
		
		try { 
			assertFalse(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
	}
	
	@Test
	public void testSimple_Relop_NonNumerical_Exception() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(new BigDecimal(0)), new VariableNode("x"), ConditionsLexer.RELOP_GT, ">");
		assertThrows(Exception.class, () -> e.Visit(relop));
		assertThrows(Exception.class, () -> e.Visit(relop2));
		
	}
	
	@Test
	public void testSimple_Relop_EQ_Simple_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new VariableNode("x"), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode relopNum = new RelopNode(new NumberNode(new BigDecimal(5.4)), new NumberNode(new BigDecimal(5.4)), ConditionsLexer.RELOP_EQ, "==");
		
		try { 
			assertTrue(e.Visit(relop));
			assertTrue(e.Visit(relopNum));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	@Test
	public void testSimple_Relop_EQ_Simple_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new VariableNode("x"), ConditionsLexer.RELOP_EQ, "==");
		
		try { 
			assertFalse(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	@Test
	public void testSimple_Relop_NEQ_Simple_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(1)), new VariableNode("x"), ConditionsLexer.RELOP_NEQ, "!=");
		
		try { 
			assertTrue(e.Visit(relop));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	@Test
	public void testSimple_Relop_NEQ_Simple_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new VariableNode("x"), new VariableNode("x"), ConditionsLexer.RELOP_NEQ, "!=");
		ExpressionNode relopNum = new RelopNode(new NumberNode(new BigDecimal(5.4)), new NumberNode(new BigDecimal(5.4)), ConditionsLexer.RELOP_NEQ, "!=");
		
		try { 
			assertFalse(e.Visit(relop));
			assertFalse(e.Visit(relopNum));
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	
	@Test
	public void testSimple_Relop_LogicalNOT() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode not = new NotNode(relop);
		try { 
			assertFalse(e.Visit(not));
			assertTrue(e.Visit(new NotNode(not)));
			
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}
	@Test
	public void testSimple_Relop_LogicalAND_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		try { 
			assertTrue(e.Visit(and));
			
			
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}	
	@Test
	public void testSimple_Relop_LogicalAND_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(4)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		try { 
			assertFalse(e.Visit(and));
			assertFalse(e.Visit(new ConditionAndNode(relop2, relop)));
			
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}	
	
	@Test
	public void testSimple_Relop_LogicalOR_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(0)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(4)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionOrNode(relop, relop2);
		try { 
			assertTrue(e.Visit(and));
			assertTrue(e.Visit(new ConditionOrNode(relop2, relop)));
			assertFalse(e.Visit(new ConditionOrNode(relop2, relop2)));
			assertTrue(e.Visit(new ConditionOrNode(relop, relop)));
			
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}	
	@Test
	public void testSimple_Relop_LogicalOR_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ExpressionNode relop = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(4)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(new BigDecimal(2)), new NumberNode(new BigDecimal(4)), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionOrNode(relop, relop2);
		try { 
			assertFalse(e.Visit(and));
			assertFalse(e.Visit(new ConditionOrNode(relop2, relop)));
			
		} catch (Exception e1) { e1.printStackTrace(); }
		
	}	
	
	
	
	@Test
	public void testSimple_ConditionFunction_True() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2)));
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		try { 
			assertTrue(e.Visit(c));			
		} catch (Exception e1) { e1.printStackTrace(); }
	}

	@Test
	public void testSimple_ConditionFunction_False() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		try { 
			assertFalse(e.Visit(c));			
		} catch (Exception e1) { e1.printStackTrace(); }
	}

	@Test
	public void testSimple_ConditionFunction_ArgumentException() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode c = new ConditionFunctionNode("_is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(c));
		arguments.add(new NumberNode(new BigDecimal(2)));
		arguments.add(new NumberNode(new BigDecimal(2)));
		assertThrows(Exception.class, () -> e.Visit(c));
	}

	@Test
	public void testSimple_ConditionFunction_NameException() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode c = new ConditionFunctionNode("is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(c));
		arguments.add(new NumberNode(new BigDecimal(2)));
		arguments.add(new NumberNode(new BigDecimal(2)));
		assertThrows(Exception.class, () -> e.Visit(c));
	}

	@Test
	public void testVisiting_Unavailable_Nodes_Exception() {
		EvaluateConditionsVisitor e = new EvaluateConditionsVisitor();
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode c = new ConditionFunctionNode("is_number", arguments);
		assertThrows(Exception.class, () -> e.Visit(new AdditionNode(new NumberNode(new BigDecimal(2)), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new SubtractionNode(new NumberNode(new BigDecimal(2)), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new DivisionNode(new NumberNode(new BigDecimal(2)), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new MultiplicationNode(new NumberNode(new BigDecimal(2)), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new PowerNode(new NumberNode(new BigDecimal(2)), new VariableNode("v"))));
		assertThrows(Exception.class, () -> e.Visit(new UnaryNode(new NumberNode(new BigDecimal(2)))));
		assertThrows(Exception.class, () -> e.Visit(new ParentheticalNode(new NumberNode(new BigDecimal(2)))));
		assertThrows(Exception.class, () -> e.Visit(new FunctionNode("TestFunction", new ArrayList<ExpressionNode>())));
		assertThrows(Exception.class, () -> e.Visit(new VariableNode("x")));
		assertThrows(Exception.class, () -> e.Visit(new NumberNode(new BigDecimal(2))));
		assertThrows(Exception.class, () -> e.Visit(new RuleVariableNode("x")));
		
		
		
	}

	
	
}
