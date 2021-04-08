package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestFetchConditionRuleVariables {

	
	@Test
	public void testFetchSimpleRuleVariable() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(rv);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testNoRuleVariable_Number() {
		ExpressionNode v= new VariableNode("x");
		
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getVariables().keySet().isEmpty());
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testNoRuleVariable_Variable() {
		ExpressionNode v= new VariableNode("x");
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(v);
			assertTrue(f.getVariables().keySet().isEmpty());
		} catch (Exception e) {e.printStackTrace();}	

	}
	

	@Test
	public void testFetchComplexRuleVariable_Subtraction() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode subtraction = new SubtractionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(subtraction);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Multiplication() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode multiplication = new MultiplicationNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(multiplication);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Division() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode division = new DivisionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(division);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Addition() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode addition = new AdditionNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(addition);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Exponentiation() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode power = new PowerNode(new VariableNode("x"), rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(power);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}

	@Test
	public void testFetchComplexRuleVariable_Function_no_variable() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		ExpressionNode notRv =	new VariableNode("x");
		arguments.add(notRv);
		ExpressionNode addition = new FunctionNode("testFunc", arguments);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(addition);
			assertTrue(f.getVariables().keySet().isEmpty());
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	
	@Test
	public void testFetchComplexRuleVariable_Unary() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode unary = new UnaryNode(rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(unary);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	
	@Test
	public void testFetchComplexRuleVariable_Parenthetical() {
		ExpressionNode rv = new RuleVariableNode("n");
		ExpressionNode parenthetical = new ParentheticalNode(rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(parenthetical);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	@Test
	public void testFetchComplexRuleVariable_Function() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(2));
		arguments.add(rv);
		ExpressionNode parenthetical = new ParentheticalNode(rv);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(parenthetical);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Relop() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(2.1), rv, ConditionsLexer.RELOP_GT, ">");
		
		ExpressionNode parenthetical = new ParentheticalNode(relop);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(parenthetical);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	
	@Test
	public void testFetchComplexRuleVariable_Logical_NOT() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(2.1), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode not = new NotNode(relop);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(not);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Logical_AND() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new NumberNode(2.1), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new NumberNode(2.1), new RuleVariableNode("a"), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode and = new ConditionAndNode(relop, relop2);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(and);
			assertTrue(f.getVariables().keySet().contains("$n"));
			assertTrue(f.getVariables().keySet().contains("$a"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_Logical_OR() {
		ExpressionNode rv = new RuleVariableNode("n");
		
		ExpressionNode relop = new RelopNode(new RuleVariableNode("q"), rv, ConditionsLexer.RELOP_GT, ">");
		ExpressionNode relop2 = new RelopNode(new RuleVariableNode("w"), new RuleVariableNode("a"), ConditionsLexer.RELOP_GT, ">");
		ExpressionNode or = new ConditionOrNode(relop, relop2);
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(or);
			assertTrue(f.getVariables().keySet().contains("$n"));
			assertTrue(f.getVariables().keySet().contains("$a"));
			assertTrue(f.getVariables().keySet().contains("$q"));
			assertTrue(f.getVariables().keySet().contains("$w"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	@Test
	public void testFetchComplexRuleVariable_ConditionFunction() {
		ExpressionNode rv = new RuleVariableNode("n");
		ArrayList<ExpressionNode > arguments = new ArrayList<ExpressionNode>();
		arguments.add(rv);
		ExpressionNode cf = new ConditionFunctionNode("_is_number",arguments );
		FetchConditionRuleVariables f = new FetchConditionRuleVariables();

		try {
			f.Visit(cf);
			assertTrue(f.getVariables().keySet().contains("$n"));
		} catch (Exception e) {e.printStackTrace();}	

	}
	
	
}