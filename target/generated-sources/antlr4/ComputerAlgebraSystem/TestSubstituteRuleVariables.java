package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

public class TestSubstituteRuleVariables {

	@Test
	public void testSubstituteVariable() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteNumber() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new NumberNode(1.4));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof NumberNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteAddition() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

		variables.put("$test", new AdditionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof AdditionNode);
			assertTrue(((AdditionNode) result).Left instanceof NumberNode);
			assertTrue(((AdditionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteSubstitution() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new SubtractionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof SubtractionNode);
			assertTrue(((SubtractionNode) result).Left instanceof NumberNode);
			assertTrue(((SubtractionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteMultiplication() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new MultiplicationNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof MultiplicationNode);
			assertTrue(((MultiplicationNode) result).Left instanceof NumberNode);
			assertTrue(((MultiplicationNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteDivision() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new DivisionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof DivisionNode);
			assertTrue(((DivisionNode) result).Left instanceof NumberNode);
			assertTrue(((DivisionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSubstituteExponentiation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new PowerNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof PowerNode);
			assertTrue(((PowerNode) result).Left instanceof NumberNode);
			assertTrue(((PowerNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Exponentiation error");
		}

	}

	@Test
	public void testSubstituteParenthetical() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new ParentheticalNode(new NumberNode(2)));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(((ParentheticalNode) result).innerNode instanceof NumberNode);
			ExpressionNode resultNode = (((ParentheticalNode) result).innerNode);
			assertTrue(((NumberNode) resultNode).getValue() == 2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSubstituteUnary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new UnaryNode(new NumberNode(2)));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof UnaryNode);

			assertTrue(((UnaryNode) result).innerNode instanceof NumberNode);
			ExpressionNode resultNode = (((UnaryNode) result).innerNode);
			assertTrue(((NumberNode) resultNode).getValue() == 2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test
	public void testSubstituteFunction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		
		ArrayList<ExpressionNode> functionArguments = new ArrayList<ExpressionNode>();
		functionArguments.add(new NumberNode(2.1));
		functionArguments.add(new VariableNode("xa"));
		ExpressionNode functionNode = new FunctionNode("TestFunction", functionArguments);
		
		
		variables.put("$test", functionNode);
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof FunctionNode);

			assertTrue(((FunctionNode)result).getArguments().get(0) instanceof NumberNode);
			assertTrue(((FunctionNode)result).getArguments().get(1) instanceof VariableNode);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testSubstituteNullVariables_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		//variables.put("$n", new VariableNode("x"));
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		assertThrows(Exception.class, () -> s.Visit(rv));

	}
	
	@Test
	public void testSubstituteNullVariable_Node_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", null);
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		assertThrows(Exception.class, () -> s.Visit(rv));

	}
	
	@Test 
	public void TestSubstituteComplex_Addition() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode additionNode = new AdditionNode(new NumberNode(2), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(additionNode);
			assertTrue(result instanceof AdditionNode);
			AdditionNode addResult = (AdditionNode)result;
			assertTrue(addResult.Left instanceof NumberNode);
			assertTrue(addResult.Right instanceof VariableNode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test 
	public void TestSubstituteComplex_Subtraction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode subtractionNode = new SubtractionNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(subtractionNode);
			assertTrue(result instanceof SubtractionNode);
			SubtractionNode addResult = (SubtractionNode)result;
			assertTrue(addResult.Left instanceof VariableNode);
			assertTrue(addResult.Right instanceof VariableNode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void TestSubstituteComplex_Multiplication() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode multiplicationNode = new MultiplicationNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(multiplicationNode);
			assertTrue(result instanceof MultiplicationNode);
			MultiplicationNode addResult = (MultiplicationNode)result;
			assertTrue(addResult.Left instanceof VariableNode);
			assertTrue(addResult.Right instanceof VariableNode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void TestSubstituteComplex_DivisionNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode divisionNode = new DivisionNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(divisionNode);
			assertTrue(result instanceof DivisionNode);
			DivisionNode addResult = (DivisionNode)result;
			assertTrue(addResult.Left instanceof VariableNode);
			assertTrue(addResult.Right instanceof VariableNode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void TestSubstituteComplex_Exponentiation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode powerNode = new PowerNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(powerNode);
			assertTrue(result instanceof PowerNode);
			PowerNode addResult = (PowerNode)result;
			assertTrue(addResult.Left instanceof VariableNode);
			assertTrue(addResult.Right instanceof VariableNode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void TestSubstituteComplex_Unary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode unaryNode = new UnaryNode(new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result instanceof UnaryNode);
			UnaryNode addResult = (UnaryNode)result;
			assertTrue(addResult.innerNode instanceof VariableNode);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void TestSubstituteComplex_Parenthetical() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ExpressionNode parentheticalNode = new ParentheticalNode(new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(parentheticalNode);
			assertTrue(result instanceof ParentheticalNode);
			ParentheticalNode addResult = (ParentheticalNode)result;
			assertTrue(addResult.innerNode instanceof VariableNode);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void TestSubstituteComplex_FunctionNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new AdditionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new SubtractionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new MultiplicationNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new DivisionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new PowerNode(new NumberNode(3), new RuleVariableNode("n")));
		
		ExpressionNode functionNode = new FunctionNode("TestFunction", arguments);
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		
		try {
			ExpressionNode result = s.Visit(functionNode);
			assertTrue(result instanceof FunctionNode);
			FunctionNode addResult = (FunctionNode)result;
			assertTrue(((PowerNode)addResult.arguments.get(4)).Right instanceof VariableNode);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
