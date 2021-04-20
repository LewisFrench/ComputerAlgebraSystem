package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.FetchRuleVariables;
public class TestFetchRuleVariables {

	@Test
	public void testFetchSimpleRuleVariable() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(rv);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testNoRuleVariable_Number() {
		ExpressionNode v= new VariableNode("x");
		
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getRuleVariables().isEmpty());
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testNoRuleVariable_Variable() {
		ExpressionNode v= new VariableNode("x");
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getRuleVariables().isEmpty());
		} catch (Exception e) {fail();}	

	}
	

	@Test
	public void testFetchComplexRuleVariable_Subtraction() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode subtraction = new SubtractionNode(new VariableNode("x"), rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(subtraction);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Multiplication() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode multiplication = new MultiplicationNode(new VariableNode("x"), rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(multiplication);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Division() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode division = new DivisionNode(new VariableNode("x"), rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(division);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Addition() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(addition);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Exponentiation() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode power = new PowerNode(new VariableNode("x"), rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(power);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}

	
	@Test
	public void testFetchComplexRuleVariable_Unary() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode unary = new UnaryNode(rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Function() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(2));
		arguments.add(rv);
		ExpressionNode unary = new UnaryNode(rv);
		FetchRuleVariables f = new FetchRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getRuleVariables().contains("$n"));
		} catch (Exception e) {fail();}	

	}
	
	
	
}
