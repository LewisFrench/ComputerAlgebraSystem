package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

public class TestRuleAlgebraParser {

	@Test
	public void testValidRuleNoConditions_Variable_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	@Test
	public void testValidRuleNoConditions_Number_Variable() {
		Program p = new Program();
		try {
			Rule result = p.parseRule("1=x");
			assertTrue(result.rhsNode instanceof VariableNode);
			assertTrue(result.lhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	
	@Test
	public void testValidRuleNoConditions_RuleVariable_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x=1");
			assertTrue(result.lhsNode instanceof RuleVariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleNoConditions_RuleVariable_RuleVariable() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x=$x");
			assertTrue(result.lhsNode instanceof RuleVariableNode);
			assertTrue(result.rhsNode instanceof RuleVariableNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleNoConditions_Unary_Parenthetical() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("-x=(x)");
			assertTrue(result.lhsNode instanceof UnaryNode);
			assertTrue(result.rhsNode instanceof ParentheticalNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleNoConditions_Parenthetical_Unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("(x)=-x");
			assertTrue(result.lhsNode instanceof ParentheticalNode);
			assertTrue(result.rhsNode instanceof UnaryNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleNoConditions_Addition_Subtraction() {
		
		Program p = new Program();
		try {
			Rule result = p.parseRule("x+1=1-x");
			assertTrue(result.lhsNode instanceof AdditionNode);
			assertTrue(result.rhsNode instanceof SubtractionNode);
			assertTrue(result.conditionsNode == null);
		} catch(Exception e) {e.printStackTrace();}
	}

	@Test
	public void testValidRuleNoConditions_Subtraction_Addition() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x-1=1+x");
			assertTrue(result.lhsNode instanceof SubtractionNode);
			assertTrue(result.rhsNode instanceof AdditionNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleNoConditions_Multiplication_Division() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x*1=1/x");
			assertTrue(result.lhsNode instanceof MultiplicationNode);
			assertTrue(result.rhsNode instanceof DivisionNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace(); }
	}
	
	@Test
	public void testValidRuleNoConditions_Division_Multiplication() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x/1=1*x");
			assertTrue(result.lhsNode instanceof DivisionNode);
			assertTrue(result.rhsNode instanceof MultiplicationNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace(); }
	}
	
	
	@Test
	public void testValidRuleNoConditions_Function_Exponentiation() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("f(x)=1^x");
			assertTrue(result.lhsNode instanceof FunctionNode);
			assertTrue(result.rhsNode instanceof PowerNode);
			assertTrue(result.conditionsNode == null);
			
		} catch(Exception e) {e.printStackTrace(); }
	}
	
	

	@Test
	public void testValidRuleValidConditions_RelopGT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, ">");
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleValidConditions_RelopGTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, ">=");
			
		} catch(Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testValidRuleValidConditions_RelopLT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, "<");
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_RelopLTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, "<=");
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	@Test
	public void testValidRuleValidConditions_RelopEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1==0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, "==");
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_RelopNEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1!=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode)result.conditionsNode).relopText, "!=");
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_Depends() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_depends(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof  ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode)result.conditionsNode).functionName.equals("_depends"));
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_literal() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_literal(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof  ConditionFunctionNode);
			assertEquals(((ConditionFunctionNode)result.conditionsNode).functionName,("_is_literal"));
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_number(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof  ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode)result.conditionsNode).functionName.equals("_is_number"));
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_integer() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_integer(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof  ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode)result.conditionsNode).functionName.equals("_is_integer"));
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_logical_OR() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 | 1>0");
			assertTrue(result.conditionsNode instanceof  ConditionOrNode);			
			
		} catch(Exception e) {e.printStackTrace();}
	}	

	@Test
	public void testValidRuleValidConditions_logical_AND() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 & 1>0");
			assertTrue(result.conditionsNode instanceof  ConditionAndNode);			
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_logical_NOT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:!(1>0)");
			assertTrue(result.conditionsNode instanceof  NotNode);			
			
		} catch(Exception e) {e.printStackTrace();}
	}	
	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_no_underscore_is_integer_Exception() {

		Program p = new Program();
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x=1:is_integer(x)"));
	}	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_no_underscore_is_literal_Exception() {

		Program p = new Program();
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x=1:is_literal(x)"));
	}		
	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_no_underscore_is_numberException() {

		Program p = new Program();
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x=1:is_number(x)"));
	}	
	
	@Test
	public void testValidRuleValidConditions_ConditionFunction_no_underscore_depends_Exception() {

		Program p = new Program();
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x=1:depends(x)"));
	}	
	public void testInvalidRuleNoConditions_NoRHS_NoEquals() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("f(x)"));

	}
	@Test
	public void testInvalidRuleNoConditions_NoRHS() {

		Program p = new Program();
		assertThrows(ParseCancellationException.class, ()-> p.parseRule("f(x)="));

	}
	@Test
	public void testInvalidRuleNoConditions_NoLHS() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("=f(x)"));
	}
	
	@Test
	public void testInvalidRuleNoConditions_NoConditions() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x):"));
	}
	
	@Test
	public void testInvalidRuleNoConditions_invalid_relop_exception() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1>"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1>="));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1<"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1<="));
	}
	
	@Test
	public void testInvalidRuleNoConditions_invalid_Equality_exception() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1=="));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1!="));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1=="));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): !="));
	}
	
	@Test
	public void testInvalidRuleNoConditions_invalid_logical_AND_exception() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1>0 &"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): & 1>0"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): &"));
		
	}
	
	@Test
	public void testInvalidRuleNoConditions_invalid_logical_OR_exception() {

		Program p = new Program();
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): 1>0 |"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): | 1>"));
		assertThrows(Exception.class, ()-> p.parseRule("x=f(x): |"));
		
	}	
	
	

}
