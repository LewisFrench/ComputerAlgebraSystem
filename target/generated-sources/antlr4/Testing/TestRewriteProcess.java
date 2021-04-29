package Testing;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import ComputerAlgebraSystem.Rule;
import Conditions.ConditionsLexer;
import Nodes.*;
import VisitorClasses.RewriteProcess;
public class TestRewriteProcess {

	@Test
	public void testEmptyRuleSet() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		RewriteProcess rewrite = new RewriteProcess(rules);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(2))==0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1))==0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testNullRuleSet() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		RewriteProcess rewrite = new RewriteProcess(rules);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(2))==0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1))==0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Number() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new NumberNode(BigInteger.valueOf(2));
		ExpressionNode ruleRhs = new NumberNode(BigInteger.valueOf(3));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(3))==0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1))==0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Variable() {
		ExpressionNode term = new VariableNode("x");
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new VariableNode("x");
		ExpressionNode ruleRhs = new VariableNode("xy");

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).value.equals("xy"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Addition() {
		ExpressionNode term = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ExpressionNode ruleRhs = new AdditionNode(new VariableNode("z"), new VariableNode("c"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == AdditionNode.class);
			assertTrue(((AdditionNode) result).getLeft() instanceof VariableNode);
			assertTrue(((AdditionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Subtraction() {
		ExpressionNode term = new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ExpressionNode ruleRhs = new SubtractionNode(new VariableNode("z"), new VariableNode("c"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == SubtractionNode.class);
			assertTrue(((SubtractionNode) result).getLeft() instanceof VariableNode);
			assertTrue(((SubtractionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Multiplication() {
		ExpressionNode term = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ExpressionNode ruleRhs = new MultiplicationNode(new VariableNode("z"), new VariableNode("c"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == MultiplicationNode.class);
			assertTrue(((MultiplicationNode) result).getLeft() instanceof VariableNode);
			assertTrue(((MultiplicationNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Division() {
		ExpressionNode term = new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ExpressionNode ruleRhs = new DivisionNode(new VariableNode("z"), new VariableNode("c"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == DivisionNode.class);
			assertTrue(((DivisionNode) result).getLeft() instanceof VariableNode);
			assertTrue(((DivisionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Exponentiation() {
		ExpressionNode term = new PowerNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new PowerNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("x"));
		ExpressionNode ruleRhs = new PowerNode(new VariableNode("z"), new VariableNode("c"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == PowerNode.class);
			assertTrue(((PowerNode) result).getLeft() instanceof VariableNode);
			assertTrue(((PowerNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}



	@Test
	public void testSimpleTransformation_Unary() {
		ExpressionNode term = new UnaryNode(new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new UnaryNode(new VariableNode("x"));
		ExpressionNode ruleRhs = new UnaryNode(new VariableNode("y"));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == UnaryNode.class);
			assertTrue(((UnaryNode) result).innerNode instanceof VariableNode);
			UnaryNode unaryResult = (UnaryNode) result;
			assertTrue(((VariableNode) unaryResult.innerNode).value.equals("y"));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Unary_Numerical() {
		ExpressionNode term = new UnaryNode(new NumberNode(BigInteger.valueOf(221),BigInteger.valueOf(5)));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new UnaryNode(new NumberNode(BigInteger.valueOf(221),BigInteger.valueOf(5)));
		ExpressionNode ruleRhs = new UnaryNode(new NumberNode(BigInteger.valueOf(224),BigInteger.valueOf(3)));

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf(-224))==0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(3))==0);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSimpleTransformation_Function() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		// ExpressionNode function = new FunctionNode("testFunction", arguments);

		ExpressionNode term = new FunctionNode("testFunction", arguments);
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new FunctionNode("testFunction", arguments);
		ExpressionNode ruleRhs = new FunctionNode("transformedFunction", arguments);

		
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == FunctionNode.class);
			assertTrue(((FunctionNode) result).function.equals("transformedFunction"));
			assertTrue(((FunctionNode) result).getArguments().get(0) instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRuleVariableTransformation_Variable() {
		
		ExpressionNode term = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("z"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		
		
		try {
			rules.add(new Rule(new AdditionNode(new RuleVariableNode("n"), new VariableNode("z")), new VariableNode("xy")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertEquals(VariableNode.class, result.getClass());
			assertEquals("xy", ((VariableNode)result).getValue());
			
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Addition() {
		
		ExpressionNode term = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
		
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Subtraction() {
		
		ExpressionNode term = new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
		
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}

	
	@Test
	public void testRuleVariableTransformation_Multiplication() {
		
		ExpressionNode term = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
		
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}
	@Test
	public void testRuleVariableTransformation_Division() {
		
		ExpressionNode term = new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
		
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Exponentiation() {
		
		ExpressionNode term = new PowerNode(new NumberNode(BigInteger.valueOf(2)), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new PowerNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Unary() {
		
		ExpressionNode term = new UnaryNode(new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new UnaryNode( new RuleVariableNode("n"));
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}	
	
	
	@Test
	public void testRuleVariableTransformation_Function() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new NumberNode(BigInteger.valueOf(2)));
		arguments.add(new RuleVariableNode("n"));
		
		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new NumberNode(BigInteger.valueOf(2)));
		termArguments.add(new VariableNode("xy"));
		
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}	
	
	
	@Test
	public void testRuleVariableTransformation_ArgumentsMatchFalse_NoRuleApplied() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		
		arguments.add(new RuleVariableNode("n"));
		arguments.add(new RuleVariableNode("n"));
		
		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new NumberNode(BigInteger.valueOf(2)));
		termArguments.add(new VariableNode("xy"));
		
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			rewrite.Visit(term);
			//assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			fail();
		}

	}	
	
	@Test
	public void testRuleVariableTransformation_ArgumentsMatchTrue_RuleApplied() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new RuleVariableNode("n"));
		arguments.add(new RuleVariableNode("n"));
		
		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new VariableNode("xy"));
		termArguments.add(new VariableNode("xy"));
		
		
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}	
	
	
	@Test
	public void testRuleVariableTransformation_ConditionsHold() {
		
		ExpressionNode term = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode conditionsNode = new RelopNode(new NumberNode(BigInteger.valueOf(2)), new NumberNode(BigInteger.valueOf(3)), ConditionsLexer.RELOP_LTE, "<");
		try {
			rules.add(new Rule(new UnaryNode(new RuleVariableNode("p")), new VariableNode("xy"), conditionsNode));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).value.equals("xy"));
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testRuleVariableTransformation_ConditionsHold_False() {
		
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode conditionsNode = new RelopNode(new NumberNode(BigInteger.valueOf(4)), new NumberNode(BigInteger.valueOf(3)), ConditionsLexer.RELOP_LTE, "<");
		try {
			rules.add(new Rule(new RuleVariableNode("n"), new VariableNode("xy"), conditionsNode));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			//assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			fail();
		}

	}
	
	
	
	
	
	
	
}
