package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

import ComputerAlgebraSystem.Program;
import ComputerAlgebraSystem.Rule;
import Nodes.*;
public class TestRuleAlgebraParser {

	@Test
	public void testParseSimpleNumber_Integer() {
		Program p = new Program();

		try {
			Rule n = p.parseRule("3=3");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(3, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());

			n = p.parseRule("-3=-3");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(-3, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(-3, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());

			n = p.parseRule("-0=0");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(0, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());

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
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(3, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(3, ((NumberNode) n.getRhsNode()).getDenominator());

			n = p.parseRule("0/3=0/3");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(0, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());
			
			n = p.parseRule("1/-3=1/-3");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(-1, ((NumberNode) n.getLhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getLhsNode()).getDenominator() );
			assertEquals(-1, ((NumberNode) n.getRhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getRhsNode()).getDenominator() );

			n = p.parseRule("-1/-3=-1/-3");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.getLhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getLhsNode()).getDenominator() );
			assertEquals(1, ((NumberNode) n.getRhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getRhsNode()).getDenominator() );

			n = p.parseRule("0001/0003=0001/0003");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(1, ((NumberNode) n.getLhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getLhsNode()).getDenominator() );
			assertEquals(1, ((NumberNode) n.getRhsNode()).getNumerator() );
			assertEquals(3, ((NumberNode) n.getRhsNode()).getDenominator() );

			
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
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(3, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());
			
			n = p.parseRule("00000003.000=0003.0000000");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(3, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(3, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());
			
			n = p.parseRule("-00000003.000=-0003.0000000");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(-3, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(-3, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());
			
			n = p.parseRule("-0000000.000=-000.0000000");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(0, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(0, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getDenominator());

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
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(37, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(10, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(37, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(10, ((NumberNode) n.getRhsNode()).getDenominator());
			
			n = p.parseRule("-3.2001 = -3.2001");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(-32001, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(10000, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(-32001, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(10000, ((NumberNode) n.getRhsNode()).getDenominator());

			n = p.parseRule("-0.0001 = 0.0001");
			assertTrue(n.getLhsNode() instanceof NumberNode);
			assertTrue(n.getRhsNode() instanceof NumberNode);
			assertEquals(-1, ((NumberNode) n.getLhsNode()).getNumerator());
			assertEquals(10000, ((NumberNode) n.getLhsNode()).getDenominator());
			assertEquals(1, ((NumberNode) n.getRhsNode()).getNumerator());
			assertEquals(10000, ((NumberNode) n.getRhsNode()).getDenominator());


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
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Variable_NegativeNumber() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=-1");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(((NumberNode) result.getRhsNode()).getNumerator() == -1);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	
	
	@Test
	public void testValidRuleNoConditions_Number_Variable() {
		Program p = new Program();
		try {
			Rule result = p.parseRule("1=x");
			assertTrue(result.getRhsNode() instanceof VariableNode);
			assertTrue(result.getLhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_RuleVariable_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("$x=1");
			assertTrue(result.getLhsNode() instanceof RuleVariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	
	@Test
	public void testValidRuleNoConditions_PositiveUnary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("+x = +x");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			
			assertTrue(result.getRhsNode() instanceof VariableNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleNoConditions_PositiveUnary_Number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("+2 = +2");
			assertTrue(result.getLhsNode() instanceof NumberNode);
			
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testValidRuleNoConditions_Unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("-func(x, 3) = - func(x, 3)");
			assertTrue(result.getLhsNode() instanceof UnaryNode);
			
			assertTrue(result.getRhsNode() instanceof UnaryNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleNoConditions_Parentheses() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("(-func(x, 3)) = (- func(x, 3))");
			assertTrue(result.getLhsNode() instanceof UnaryNode);
			
			assertTrue(result.getRhsNode() instanceof UnaryNode);
			assertTrue(result.getConditionsNode() == null);

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
			assertTrue(result.getLhsNode() instanceof RuleVariableNode);
			assertTrue(result.getRhsNode() instanceof RuleVariableNode);
			assertTrue(result.getConditionsNode() == null);

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
			assertTrue(result.getLhsNode() instanceof AdditionNode);
			assertTrue(result.getRhsNode() instanceof SubtractionNode);
			assertTrue(result.getConditionsNode() == null);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Subtraction_Addition() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x-1=1+x");
			assertTrue(result.getLhsNode() instanceof SubtractionNode);
			assertTrue(result.getRhsNode() instanceof AdditionNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Multiplication_Division() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x*1=1/x");
			assertTrue(result.getLhsNode() instanceof MultiplicationNode);
			assertTrue(result.getRhsNode() instanceof DivisionNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Division_Multiplication() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x/1=1*x");
			assertTrue(result.getLhsNode() instanceof DivisionNode);
			assertTrue(result.getRhsNode() instanceof MultiplicationNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleNoConditions_Function_Exponentiation() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("f(x)=1^x");
			assertTrue(result.getLhsNode() instanceof FunctionNode);
			assertTrue(result.getRhsNode() instanceof PowerNode);
			assertTrue(result.getConditionsNode() == null);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_Rational() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1/3>0/2");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), ">");

		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testValidRuleValidConditions_Relop_Decimal() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:0.33>00.20");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), ">");

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_UnaryNumber() {
		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:-(1.0)>-00.20");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), ">");

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Relop_Unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:-x==-x");
			System.out.println(result.getConditionsNode().toString());
			System.out.println(result.getConditionsNode().getClass());
			
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(UnaryNode.class,((RelopNode) result.getConditionsNode()).getLeft().getClass());
			assertEquals(UnaryNode.class,((RelopNode) result.getConditionsNode()).getRight().getClass());
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), "==");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopGT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), ">");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopGTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>=0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), ">=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopLT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), "<");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopLTE() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1<=0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), "<=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1==0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), "==");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_RelopNEQ() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1!=0");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertEquals(((RelopNode) result.getConditionsNode()).getRelopText(), "!=");

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_Depends() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_depends(x)");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.getConditionsNode()).getFunctionName().equals("_depends"));

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
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof ConditionFunctionNode);
			assertEquals(((ConditionFunctionNode) result.getConditionsNode()).getFunctionName(), ("_is_literal"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_number() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_number(x)");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.getConditionsNode()).getFunctionName().equals("_is_number"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_ConditionFunction_is_integer() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:_is_integer(x)");
			assertTrue(result.getLhsNode() instanceof VariableNode);
			assertTrue(result.getRhsNode() instanceof NumberNode);
			assertTrue(result.getConditionsNode() instanceof ConditionFunctionNode);
			assertTrue(((ConditionFunctionNode) result.getConditionsNode()).getFunctionName().equals("_is_integer"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_OR() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 | 1>0");
			assertTrue(result.getConditionsNode() instanceof ConditionOrNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_AND() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1>0 & 1>0");
			assertTrue(result.getConditionsNode() instanceof ConditionAndNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_logical_NOT() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:!(1>0)");
			assertTrue(result.getConditionsNode() instanceof ConditionNotNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_parenthetical_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1>+0)");
			assertTrue(result.getConditionsNode() instanceof RelopNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Addition_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1+3>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof AdditionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Subtraction_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1-3>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof SubtractionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Multiplication_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1*3>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof MultiplicationNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Division_relop_Rational() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1)/3>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof NumberNode);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidRuleValidConditions_Division_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1/3)/4>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof DivisionNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_Exponentiation_relop() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:1^3>0");
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof PowerNode);

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
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof FunctionNode);

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
			assertTrue(result.getConditionsNode() instanceof RelopNode);
			assertTrue(((RelopNode) result.getConditionsNode()).getLeft() instanceof RuleVariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidRuleValidConditions_relop_containing_unary() {

		Program p = new Program();
		try {
			Rule result = p.parseRule("x=1:(1>-0)");
			assertTrue(result.getConditionsNode() instanceof RelopNode);

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
