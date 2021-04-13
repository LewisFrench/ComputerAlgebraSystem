package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestRewriteProcess {

	@Test
	public void testEmptyRuleSet() {
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		int ruleApplicationLimit = 10;
		RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 2);
			assertTrue(((NumberNode) result).getDenominator() == 1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testNullRuleSet() {
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		int ruleApplicationLimit = 10;
		RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
		try {
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 2);
			assertTrue(((NumberNode) result).getDenominator() == 1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testZero_RuleApplicationLimit() {
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new NumberNode(2);
		ExpressionNode ruleRhs = new NumberNode(3);

		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			int ruleApplicationLimit = 0;
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 2);
			assertTrue(((NumberNode) result).getDenominator() == 1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Number() {
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new NumberNode(2);
		ExpressionNode ruleRhs = new NumberNode(3);

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 3);
			assertTrue(((NumberNode) result).getDenominator() == 1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Variable() {
		ExpressionNode term = new VariableNode("x");
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new VariableNode("x");
		ExpressionNode ruleRhs = new VariableNode("xy");

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).value.equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Addition() {
		ExpressionNode term = new AdditionNode(new NumberNode(2), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new AdditionNode(new NumberNode(2), new VariableNode("x"));
		ExpressionNode ruleRhs = new AdditionNode(new VariableNode("z"), new VariableNode("c"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == AdditionNode.class);
			assertTrue(((AdditionNode) result).Left instanceof VariableNode);
			assertTrue(((AdditionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Subtraction() {
		ExpressionNode term = new SubtractionNode(new NumberNode(2), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new SubtractionNode(new NumberNode(2), new VariableNode("x"));
		ExpressionNode ruleRhs = new SubtractionNode(new VariableNode("z"), new VariableNode("c"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == SubtractionNode.class);
			assertTrue(((SubtractionNode) result).Left instanceof VariableNode);
			assertTrue(((SubtractionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Multiplication() {
		ExpressionNode term = new MultiplicationNode(new NumberNode(2), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new MultiplicationNode(new NumberNode(2), new VariableNode("x"));
		ExpressionNode ruleRhs = new MultiplicationNode(new VariableNode("z"), new VariableNode("c"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == MultiplicationNode.class);
			assertTrue(((MultiplicationNode) result).Left instanceof VariableNode);
			assertTrue(((MultiplicationNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Division() {
		ExpressionNode term = new DivisionNode(new NumberNode(2), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new DivisionNode(new NumberNode(2), new VariableNode("x"));
		ExpressionNode ruleRhs = new DivisionNode(new VariableNode("z"), new VariableNode("c"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == DivisionNode.class);
			assertTrue(((DivisionNode) result).Left instanceof VariableNode);
			assertTrue(((DivisionNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Exponentiation() {
		ExpressionNode term = new PowerNode(new NumberNode(2), new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new PowerNode(new NumberNode(2), new VariableNode("x"));
		ExpressionNode ruleRhs = new PowerNode(new VariableNode("z"), new VariableNode("c"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == PowerNode.class);
			assertTrue(((PowerNode) result).Left instanceof VariableNode);
			assertTrue(((PowerNode) result).Right instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}



	@Test
	public void testSimpleTransformation_Unary() {
		ExpressionNode term = new UnaryNode(new VariableNode("x"));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new UnaryNode(new VariableNode("x"));
		ExpressionNode ruleRhs = new UnaryNode(new VariableNode("y"));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == UnaryNode.class);
			assertTrue(((UnaryNode) result).innerNode instanceof VariableNode);
			UnaryNode unaryResult = (UnaryNode) result;
			assertTrue(((VariableNode) unaryResult.innerNode).value.equals("y"));

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testSimpleTransformation_Unary_Numerical() {
		ExpressionNode term = new UnaryNode(new NumberNode(221,5));
		ArrayList<Rule> rules = new ArrayList<>();
		ExpressionNode ruleLhs = new UnaryNode(new NumberNode(221,5));
		ExpressionNode ruleRhs = new UnaryNode(new NumberNode(224,3));

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);

			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == -224);
			assertTrue(((NumberNode) result).getDenominator() == 3);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
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

		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(ruleLhs, ruleRhs));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			System.out.println("HERE " + result.toString());
			assertTrue(result.getClass() == FunctionNode.class);
			assertTrue(((FunctionNode) result).function.equals("transformedFunction"));
			assertTrue(((FunctionNode) result).getArguments().get(0) instanceof VariableNode);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Test
	public void testRuleVariableTransformation_Variable() {
		
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		
		
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(new RuleVariableNode("n"), new VariableNode("xy")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).value.equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Addition() {
		
		ExpressionNode term = new AdditionNode(new NumberNode(2), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new AdditionNode(new NumberNode(2), new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Subtraction() {
		
		ExpressionNode term = new SubtractionNode(new NumberNode(2), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new SubtractionNode(new NumberNode(2), new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	
	@Test
	public void testRuleVariableTransformation_Multiplication() {
		
		ExpressionNode term = new MultiplicationNode(new NumberNode(2), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new MultiplicationNode(new NumberNode(2), new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	@Test
	public void testRuleVariableTransformation_Division() {
		
		ExpressionNode term = new DivisionNode(new NumberNode(2), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new DivisionNode(new NumberNode(2), new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Exponentiation() {
		
		ExpressionNode term = new PowerNode(new NumberNode(2), new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new PowerNode(new NumberNode(2), new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	@Test
	public void testRuleVariableTransformation_Unary() {
		
		ExpressionNode term = new UnaryNode(new  VariableNode("xy"));
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new UnaryNode( new RuleVariableNode("n"));
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}	
	
	
	@Test
	public void testRuleVariableTransformation_Function() {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new NumberNode(2));
		arguments.add(new RuleVariableNode("n"));
		
		ArrayList<ExpressionNode> termArguments = new ArrayList<>();
		termArguments.add(new VariableNode("x"));
		termArguments.add(new NumberNode(2));
		termArguments.add(new VariableNode("xy"));
		
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
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
		termArguments.add(new NumberNode(2));
		termArguments.add(new VariableNode("xy"));
		
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			rewrite.Visit(term);
			assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
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
		
		ExpressionNode term = new FunctionNode("testFunction", termArguments);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode lhs = new FunctionNode("testFunction", arguments);
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(lhs, new RuleVariableNode("n")));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).getValue().equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}	
	
	
	@Test
	public void testRuleVariableTransformation_ConditionsHold() {
		
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode conditionsNode = new RelopNode(new NumberNode(2), new NumberNode(3), ConditionsLexer.RELOP_LTE, "<");
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(new RuleVariableNode("n"), new VariableNode("xy"), conditionsNode));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == VariableNode.class);
			assertTrue(((VariableNode) result).value.equals("xy"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	@Test
	public void testRuleVariableTransformation_ConditionsHold_False() {
		
		ExpressionNode term = new NumberNode(2);
		ArrayList<Rule> rules = new ArrayList<>();
		
		ExpressionNode conditionsNode = new RelopNode(new NumberNode(4), new NumberNode(3), ConditionsLexer.RELOP_LTE, "<");
		int ruleApplicationLimit = 1;
		try {
			rules.add(new Rule(new RuleVariableNode("n"), new VariableNode("xy"), conditionsNode));
			RewriteProcess rewrite = new RewriteProcess(rules, ruleApplicationLimit);
			ExpressionNode result = rewrite.Visit(term);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(rewrite.ruleApplicationCount == 0);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	
	
	
	
	
	
}
