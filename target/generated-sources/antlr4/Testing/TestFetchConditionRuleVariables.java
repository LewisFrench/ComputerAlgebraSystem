package Testing;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;
import Nodes.*;
import VisitorClasses.FetchConditionRuleVariables;
public class TestFetchConditionRuleVariables {

	
	@Test
	public void testFetchConditionRuleVariables_SimpleRuleVariable() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(rv);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testNoRuleVariable_Number() {
		ExpressionNode v= new VariableNode("x");
		
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getRuleVariables().isEmpty());
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testNoRuleVariable_Variable() {
		ExpressionNode v= new VariableNode("x");
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getRuleVariables().isEmpty());
		} catch (Exception e) {fail();}	

	}
	

	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Subtraction() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode subtraction = new SubtractionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(subtraction);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Multiplication() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode multiplication = new MultiplicationNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(multiplication);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Division() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode division = new DivisionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(division);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Addition() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(addition);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Exponentiation() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode power = new PowerNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(power);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}

	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Function_no_variable() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode notRv =	new VariableNode("x");
		arguments.add(notRv);
		ExpressionNode addition = new FunctionNode("testFunc", arguments);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(addition);
			assertTrue(f.getRuleVariables().isEmpty());
		} catch (Exception e) {fail();}	

	}
	
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Unary() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode unary = new UnaryNode(rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	

	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Function() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2)));
		arguments.add(rv);
		ExpressionNode unary = new UnaryNode(rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Relop() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(2)), rv, ConditionsLexer.RELOP_GT, ">");
		
		ExpressionNode unary = new UnaryNode(relop);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Logical_NOT() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode not = new ConditionNotNode(relop);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(not);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Logical_AND() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(4)), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)), new RuleVariableNode("a"), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(and);
			assertTrue(f.getRuleVariables().contains("$n"));
			assertTrue(f.getRuleVariables().contains("$a"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_Logical_OR() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new RuleVariableNode("q"), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new RuleVariableNode("w"), new RuleVariableNode("a"), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode or = new ConditionOrNode(relop, relop2);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(or);
			assertTrue(f.getRuleVariables().contains("$n"));
			assertTrue(f.getRuleVariables().contains("$a"));
			assertTrue(f.getRuleVariables().contains("$q"));
			assertTrue(f.getRuleVariables().contains("$w"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchConditionRuleVariables_ComplexRuleVariable_ConditionFunction() {
		ExpressionNode rv = new RuleVariableNode("n");
		ArrayList<ExpressionNode > arguments = new ArrayList<ExpressionNode>();
		arguments.add(rv);
		ExpressionNode cf = new ConditionFunctionNode("_is_number",arguments );
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(cf);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	
}
