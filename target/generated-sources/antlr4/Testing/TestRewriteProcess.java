package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import ComputerAlgebraSystem.RewriteError;
import ComputerAlgebraSystem.Rule;
import Conditions.ConditionsLexer;
import Nodes.*;
import VisitorClasses.RewriteProcess;

public class TestRewriteProcess {

	@Test
	public void testRewriteProcess_EmptyRuleSet() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		RewriteProcess rewrite = new RewriteProcess(rules);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(2)) == 0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1)) == 0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_NullRuleSet() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		RewriteProcess rewrite = new RewriteProcess(rules);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(2)) == 0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1)) == 0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_SimpleTransformation_Number() {
		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new NumberNode(BigInteger.valueOf(2));
		ExpressionNode ruleRhs = new NumberNode(BigInteger.valueOf(3));

		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(3)) == 0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(1)) == 0);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_SimpleTransformation_Variable() {
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
	public void testRewriteProcess_SimpleTransformation_Addition() {
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
	public void testRewriteProcess_SimpleTransformation_Subtraction() {
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
	public void testRewriteProcess_SimpleTransformation_Multiplication() {
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
	public void testRewriteProcess_SimpleTransformation_Division() {
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
	public void testRewriteProcess_SimpleTransformation_Exponentiation() {
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
	public void testRewriteProcess_SimpleTransformation_Unary() {
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
	public void testRewriteProcess_SimpleTransformation_Unary_Numerical() {
		ExpressionNode term = new UnaryNode(new NumberNode(BigInteger.valueOf(221), BigInteger.valueOf(5)));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new UnaryNode(new NumberNode(BigInteger.valueOf(221), BigInteger.valueOf(5)));
		ExpressionNode ruleRhs = new UnaryNode(new NumberNode(BigInteger.valueOf(224), BigInteger.valueOf(3)));

		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator().compareTo(BigInteger.valueOf(-224)) == 0);
			assertTrue(((NumberNode) result).getDenominator().compareTo(BigInteger.valueOf(3)) == 0);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_SimpleTransformation_Function() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		// ExpressionNode function = new FunctionNode("testRewriteProcess_Function", arguments);

		ExpressionNode term = new FunctionNode("testRewriteProcess_Function", arguments);
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new FunctionNode("testRewriteProcess_Function", arguments);
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
	public void testRewriteProcess_RuleVariableTransformation_Variable() {

		ExpressionNode term = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("z"));
		ArrayList<Rule> rules = new ArrayList<>();

		try {
			rules.add(new Rule(new AdditionNode(new RuleVariableNode("n"), new VariableNode("z")),
					new VariableNode("xy")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertEquals(VariableNode.class, result.getClass());
			assertEquals("xy", ((VariableNode) result).getValue());

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testRewriteProcess_RuleVariableTransformation_Addition() {

		ExpressionNode term = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("xy"));
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
	public void testRewriteProcess_RuleVariableTransformation_Subtraction() {

		ExpressionNode term = new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("xy"));
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
	public void testRewriteProcess_RuleVariableTransformation_Multiplication() {

		ExpressionNode term = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("xy"));
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
	public void testRewriteProcess_RuleVariableTransformation_Division() {

		ExpressionNode term = new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("xy"));
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
	public void testRewriteProcess_RuleVariableTransformation_Exponentiation() {

		ExpressionNode term = new PowerNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("xy"));
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
	public void testRewriteProcess_RuleVariableTransformation_Unary() {

		ExpressionNode term = new UnaryNode(new VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode lhs = new UnaryNode(new RuleVariableNode("n"));
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
	public void testRewriteProcess_RuleVariableTransformation_Function() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new NumberNode(BigInteger.valueOf(2)));
		arguments.add(new RuleVariableNode("n"));

		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new NumberNode(BigInteger.valueOf(2)));
		termArguments.add(new VariableNode("xy"));

		ExpressionNode term = new FunctionNode("testRewriteProcess_Function", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode lhs = new FunctionNode("testRewriteProcess_Function", arguments);
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
	public void testRewriteProcess_RuleVariableTransformation_ArgumentsMatchFalse_NoRuleApplied() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));

		arguments.add(new RuleVariableNode("n"));
		arguments.add(new RuleVariableNode("n"));

		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new NumberNode(BigInteger.valueOf(2)));
		termArguments.add(new VariableNode("xy"));

		ExpressionNode term = new FunctionNode("testRewriteProcess_Function", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode lhs = new FunctionNode("testRewriteProcess_Function", arguments);
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			rewrite.Visit(term);
			// assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testRewriteProcess_RuleVariableTransformation_ArgumentsMatchTrue_RuleApplied() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new RuleVariableNode("n"));
		arguments.add(new RuleVariableNode("n"));

		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new VariableNode("xy"));
		termArguments.add(new VariableNode("xy"));

		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode lhs = new FunctionNode("testRewriteProcess_Function", arguments);
		ExpressionNode term = new FunctionNode("testRewriteProcess_Function", termArguments);
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
	public void testRewriteProcess_RuleVariableTransformation_ConditionsHold() {

		ExpressionNode term = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));
		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode conditionsNode = new RelopNode(new NumberNode(BigInteger.valueOf(2)),
				new NumberNode(BigInteger.valueOf(3)), ConditionsLexer.RELOP_LTE, "<");
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
	public void testRewriteProcess_RuleVariableTransformation_ConditionsHold_False() {

		ExpressionNode term = new NumberNode(BigInteger.valueOf(2));
		ArrayList<Rule> rules = new ArrayList<>();

		ExpressionNode conditionsNode = new RelopNode(new NumberNode(BigInteger.valueOf(4)),
				new NumberNode(BigInteger.valueOf(3)), ConditionsLexer.RELOP_LTE, "<");
		try {
			rules.add(new Rule(new RuleVariableNode("n"), new VariableNode("xy"), conditionsNode));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			// assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleDivision() {
		ExpressionNode div = new DivisionNode(new UnaryNode(new VariableNode("u")),
				new PowerNode(new VariableNode("u"), new VariableNode("j")));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), div);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleMultiplication() {
		ExpressionNode mult = new MultiplicationNode(new UnaryNode(new VariableNode("u")),
				new PowerNode(new VariableNode("c"), new VariableNode("j")));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), mult);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleSubtraction() {
		ExpressionNode sub = new SubtractionNode(new UnaryNode(new VariableNode("u")),
				new PowerNode(new VariableNode("u"), new VariableNode("j")));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"),sub);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleExponentiation() {
		ExpressionNode exp = new PowerNode(new UnaryNode(new VariableNode("u")),
				new PowerNode(new VariableNode("c"), new VariableNode("j")));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), exp);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleAddition() {
		ExpressionNode add = new AdditionNode(new UnaryNode(new VariableNode("u")),
				new PowerNode(new VariableNode("c"), new VariableNode("j")));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), add);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleFunction() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		
		ExpressionNode add = new FunctionNode("testRewriteProcess_", arguments);
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), add);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRewriteProcess_TraversalStopsAfterApplyingRuleUnary() {
		
		
		ExpressionNode add = new UnaryNode(new VariableNode("p"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode initAdd = new AdditionNode(new VariableNode("var"), add);

		try {
			rules.add(new Rule(new VariableNode("var"), new VariableNode("m")));
			RewriteProcess rewrite = new RewriteProcess(rules);
			ExpressionNode result = rewrite.Visit(initAdd);
			assertTrue(result.getClass() == AdditionNode.class);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRewriteProcess_CatchRewriteError() {		
		//ExpressionNode divByZero = new DivisionNode(new VariableNode("d"), new NumberNode(BigInteger.ZERO));
		ExpressionNode var = new VariableNode("var");
		ArrayList<Rule> rules = new ArrayList<>();
		try {
			rules.add(new Rule(new VariableNode("var"), new DivisionNode(new VariableNode("d"), new NumberNode(BigInteger.ZERO))));
			RewriteProcess rewrite = new RewriteProcess(rules);
			assertThrows(RewriteError.class, () -> rewrite.Visit(var));

		} catch (Exception e) {
			fail();
		}
	}

}
