package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import Nodes.*;
import org.junit.Test;

import Conditions.ConditionsLexer;


public class TestExpressionNodeOutput {

	@Test
	public void testExpressionNodeOutput_UnaryNode() {
		ExpressionNode unary = new UnaryNode(new VariableNode("x"));
		assertEquals("-x", unary.toString());
	}
	
	@Test
	public void testExpressionNodeOutput_AdditionNode() {
		ExpressionNode add = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		assertEquals("x+y", add.toString());
	}
	
	@Test
	public void testExpressionNodeOutput_SubtractionNode() {
		ExpressionNode sub = new SubtractionNode(new VariableNode("x"), new VariableNode("y"));
		assertEquals("x - y", sub.toString());
	}
	@Test
	public void testExpressionNodeOutput_MultiplicationNode() {
		ExpressionNode mult = new MultiplicationNode(new VariableNode("x"), new VariableNode("y"));
		assertEquals("x*y", mult.toString());
	}
	@Test
	public void testExpressionNodeOutput_DivisionNode() {
		ExpressionNode div = new DivisionNode(new VariableNode("x"), new VariableNode("y"));
		assertEquals("x / y", div.toString());
	}
	
	@Test
	public void testExpressionNodeOutput_PowerNode() {
		ExpressionNode exp = new PowerNode(new VariableNode("x"), new VariableNode("y"));
		assertEquals("x^y", exp.toString());
	}
	
	
	@Test
	public void testExpressionNodeOutput_ConditionAndNode() {
		RelopNode r = new RelopNode(new VariableNode("x"), new VariableNode("y"), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode condAnd = new ConditionAndNode(r, r);
		assertEquals("x==y & x==y", condAnd.toString());

	}
	
	@Test
	public void testExpressionNodeOutput_ConditionOrNode() {
		RelopNode r = new RelopNode(new VariableNode("x"), new VariableNode("y"), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode condOr = new ConditionOrNode(r, r);
		assertEquals("x==y | x==y", condOr.toString());

	}
	
	@Test
	public void testExpressionNodeOutput_ConditionNotNode() {
		RelopNode r = new RelopNode(new VariableNode("x"), new VariableNode("y"), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode condNot = new ConditionNotNode( r);
		assertEquals("!x==y", condNot.toString());

	}
	
	@Test
	public void testExpressionNodeOutput_ConditionFunctionNode() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		ExpressionNode cFunc = new ConditionFunctionNode("_is_number", arguments);
		assertEquals("_is_number(x)", cFunc.toString());

	}
	
	@Test
	public void testExpressionNodeOutput_FunctionNode() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		ExpressionNode func = new FunctionNode("func", arguments);
		assertEquals("func(x)", func.toString());

	}
	
}
