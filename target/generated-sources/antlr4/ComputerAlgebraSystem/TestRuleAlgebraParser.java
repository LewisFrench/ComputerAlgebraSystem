package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

public class TestRuleAlgebraParser {

	@Test
	public void testParseSimpleNumber_Integer() {
		Program p = new Program();

		try {
			Rule n = p.parseRule("3=3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(3, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);

			n = p.parseRule("-3=-3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(-3, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(-3, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);

			n = p.parseRule("-0=0");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(0, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);

		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseSimpleNumber_Rational() {
		Program p = new Program();

		try {
			Rule n = p.parseRule("1/3=1/3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.lhsNode).numerator);
			assertEquals(3, ((NumberNode) n.lhsNode).denominator);
			assertEquals(1, ((NumberNode) n.rhsNode).numerator);
			assertEquals(3, ((NumberNode) n.rhsNode).denominator);

			n = p.parseRule("0/3=0/3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(0, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);
			
			n = p.parseRule("1/-3=1/-3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(-1, ((NumberNode) n.lhsNode).numerator );
			assertEquals(3, ((NumberNode) n.lhsNode).denominator );
			assertEquals(-1, ((NumberNode) n.rhsNode).numerator );
			assertEquals(3, ((NumberNode) n.rhsNode).denominator );

			n = p.parseRule("-1/-3=-1/-3");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.lhsNode).numerator );
			assertEquals(3, ((NumberNode) n.lhsNode).denominator );
			assertEquals(1, ((NumberNode) n.rhsNode).numerator );
			assertEquals(3, ((NumberNode) n.rhsNode).denominator );

			n = p.parseRule("0001/0003=0001/0003");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.lhsNode).numerator );
			assertEquals(3, ((NumberNode) n.lhsNode).denominator );
			assertEquals(1, ((NumberNode) n.rhsNode).numerator );
			assertEquals(3, ((NumberNode) n.rhsNode).denominator );

			
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseSimpleNumber_DecimalInteger() {
		Program p = new Program();

		try {
			
			Rule n = p.parseRule("3.000=3.0000000");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(3, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);
			
			n = p.parseRule("00000003.000=0003.0000000");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(3, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);
			
			n = p.parseRule("-00000003.000=-0003.0000000");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(-3, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(-3, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);
			
			n = p.parseRule("-0000000.000=-000.0000000");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.lhsNode).numerator);
			assertEquals(1, ((NumberNode) n.lhsNode).denominator);
			assertEquals(0, ((NumberNode) n.rhsNode).numerator);
			assertEquals(1, ((NumberNode) n.rhsNode).denominator);

		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseSimpleNumber_Decimal() {
		Program p = new Program();

		try {
			
			Rule n = p.parseRule("3.7 = 3.7");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(37, ((NumberNode) n.lhsNode).numerator);
			assertEquals(10, ((NumberNode) n.lhsNode).denominator);
			assertEquals(37, ((NumberNode) n.rhsNode).numerator);
			assertEquals(10, ((NumberNode) n.rhsNode).denominator);
			
			n = p.parseRule("-3.2001 = -3.2001");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(-32001, ((NumberNode) n.lhsNode).numerator);
			assertEquals(10000, ((NumberNode) n.lhsNode).denominator);
			assertEquals(-32001, ((NumberNode) n.rhsNode).numerator);
			assertEquals(10000, ((NumberNode) n.rhsNode).denominator);

			n = p.parseRule("-0.0001 = 0.0001");
			assertTrue(n.lhsNode instanceof NumberNode);
			assertTrue(n.rhsNode instanceof NumberNode);
			assertEquals(-1, ((NumberNode) n.lhsNode).numerator);
			assertEquals(10000, ((NumberNode) n.lhsNode).denominator);
			assertEquals(1, ((NumberNode) n.rhsNode).numerator);
			assertEquals(10000, ((NumberNode) n.rhsNode).denominator);


		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseSimpleNumber_Rational_DenominatorZero() {
		Program p = new Program();		
		try {
			assertThrows(ArithmeticException.class, () -> p.parseRule("1/0 = 1"));
			assertThrows(ArithmeticException.class, () -> p.parseRule("1 = 1/0"));
			assertThrows(ArithmeticException.class, () -> p.parseRule("1 = 1 : 1/0 == 1"));
			assertThrows(ArithmeticException.class, () -> p.parseRule("1 = 1 : 1 == 1/0"));

		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}
	
	@Test
	public void testValidRuleNoConditions_Variable_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Variable_NegativeNumber() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=-1");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(((NumberNode) result.rhsNode).getNumerator() == -1);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	
	
	@Test
	public void testValidRuleNoConditions_Number_Variable() {
		Program p = new Program();
		try {
			Rule result = p.parseRule("1=x");
			assertTrue(result.rhsNode instanceof VariableNode);
			assertTrue(result.lhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_RuleVariable_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x=1");
			assertTrue(result.lhsNode instanceof RuleVariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	
	@Test
	public void testValidRuleNoConditions_PositiveUnary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("+x = +x");
			assertTrue(result.lhsNode instanceof VariableNode);
			
			assertTrue(result.rhsNode instanceof VariableNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleNoConditions_PositiveUnary_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("+2 = +2");
			assertTrue(result.lhsNode instanceof NumberNode);
			
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testValidRuleNoConditions_Unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("-func(x, 3) = - func(x, 3)");
			assertTrue(result.lhsNode instanceof UnaryNode);
			
			assertTrue(result.rhsNode instanceof UnaryNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleNoConditions_Parentheses() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("(-func(x, 3)) = (- func(x, 3))");
			assertTrue(result.lhsNode instanceof UnaryNode);
			
			assertTrue(result.rhsNode instanceof UnaryNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	

	@Test
	public void testValidRuleNoConditions_RuleVariablesNotCorrespond_Exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("$x=$y"));
	}

	@Test
	public void testValidRuleNoConditions_RuleVariable_RuleVariable() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x=$x");
			assertTrue(result.lhsNode instanceof RuleVariableNode);
			assertTrue(result.rhsNode instanceof RuleVariableNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_ConditionRuleVariablesNotCorrespond_Exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("$x=$x:$y>1"));
	}

	@Test
	public void testValidRuleNoConditions_Addition_Subtraction() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x+1=1-x");
			assertTrue(result.lhsNode instanceof AdditionNode);
			assertTrue(result.rhsNode instanceof SubtractionNode);
			assertTrue(result.conditionsNode == null);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Subtraction_Addition() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x-1=1+x");
			assertTrue(result.lhsNode instanceof SubtractionNode);
			assertTrue(result.rhsNode instanceof AdditionNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Multiplication_Division() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x*1=1/x");
			assertTrue(result.lhsNode instanceof MultiplicationNode);
			assertTrue(result.rhsNode instanceof DivisionNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Division_Multiplication() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x/1=1*x");
			assertTrue(result.lhsNode instanceof DivisionNode);
			assertTrue(result.rhsNode instanceof MultiplicationNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Function_Exponentiation() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("f(x)=1^x");
			assertTrue(result.lhsNode instanceof FunctionNode);
			assertTrue(result.rhsNode instanceof PowerNode);
			assertTrue(result.conditionsNode == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_Rational() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1/3>0/2");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, ">");

		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testValidRuleValidConditions_Relop_Decimal() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:0.33>00.20");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, ">");

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_UnaryNumber() {
		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:-(1.0)>-00.20");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, ">");

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_Unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:-x==-x");
			System.out.println(result.conditionsNode.toString());
			System.out.println(result.conditionsNode.getClass());
			
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(UnaryNode.class,((RelopNode) result.conditionsNode).left.getClass());
			assertEquals(UnaryNode.class,((RelopNode) result.conditionsNode).right.getClass());
			assertEquals(((RelopNode) result.conditionsNode).relopText, "==");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopGT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, ">");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopGTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, ">=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopLT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, "<");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopLTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, "<=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1==0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, "==");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopNEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1!=0");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertEquals(((RelopNode) result.conditionsNode).relopText, "!=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_Depends() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_depends(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.conditionsNode).functionName.equals("_depends"));

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_literal() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_literal(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof ConditionFunctionNode);
			assertEquals(((ConditionFunctionNode) result.conditionsNode).functionName, ("_is_literal"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_number(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.conditionsNode).functionName.equals("_is_number"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_integer() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_integer(x)");
			assertTrue(result.lhsNode instanceof VariableNode);
			assertTrue(result.rhsNode instanceof NumberNode);
			assertTrue(result.conditionsNode instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.conditionsNode).functionName.equals("_is_integer"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_OR() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 | 1>0");
			assertTrue(result.conditionsNode instanceof ConditionOrNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_AND() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 & 1>0");
			assertTrue(result.conditionsNode instanceof ConditionAndNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_NOT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:!(1>0)");
			assertTrue(result.conditionsNode instanceof ConditionNotNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_parenthetical_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1>+0)");
			assertTrue(result.conditionsNode instanceof RelopNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Addition_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1+3>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof AdditionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Subtraction_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1-3>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof SubtractionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Multiplication_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1*3>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof MultiplicationNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Division_relop_Rational() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1)/3>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof NumberNode);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Division_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1/3)/4>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof DivisionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Exponentiation_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1^3>0");
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof PowerNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Compare_EQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("+x=1:testFunc(x) == testFunc(x)");
			System.out.println(result.toString());
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof FunctionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Relop_RuleVariable() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x^2 = 1 : $x > 1");
			System.out.println(result.toString());
			assertTrue(result.conditionsNode instanceof RelopNode);
			assertTrue(((RelopNode) result.conditionsNode).left instanceof RuleVariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_relop_containing_unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1>-0)");
			assertTrue(result.conditionsNode instanceof RelopNode);

		} catch (Exception e) {
			fail();
		}
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

	@Test
	public void testInvalidRuleNoConditions_NoRHS_NoEquals() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("f(x)"));

	}

	@Test
	public void testInvalidRuleNoConditions_NoRHS() {

		Program p = new Program();
		assertThrows(ParseCancellationException.class, () -> p.parseRule("f(x)="));

	}

	@Test
	public void testInvalidRuleNoConditions_NoLHS() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("=f(x)"));
	}

	@Test
	public void testInvalidRuleNoConditions_NoConditions() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("x=f(x):"));
	}

	@Test
	public void testInvalidRuleNoConditions_invalid_relop_exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1>"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1>="));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1<"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1<="));
	}

	@Test
	public void testInvalidRuleNoConditions_invalid_Equality_exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1=="));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1!="));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1=="));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): !="));
	}

	@Test
	public void testInvalidRuleNoConditions_invalid_logical_AND_exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1>0 &"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): & 1>0"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): &"));

	}

	@Test
	public void testInvalidRuleNoConditions_invalid_logical_OR_exception() {

		Program p = new Program();
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): 1>0 |"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): | 1>"));
		assertThrows(Exception.class, () -> p.parseRule("x=f(x): |"));

	}

}
