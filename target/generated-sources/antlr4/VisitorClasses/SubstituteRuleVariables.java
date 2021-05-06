package VisitorClasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import Nodes.*;
import VisitClasses.VisitRule;

/**
 * Handles the traversal of the RHS of a rule, substituting instances of
 * RuleVariableNode with their value in the LinkedHashMap containing their
 * corresponding values E.g. $n + a given LinkedHashMap "$n" : NumberNode(1) -->
 * 1 + a
 * 
 * @author lewis
 *
 */
public class SubstituteRuleVariables extends VisitRule<ExpressionNode> {

	LinkedHashMap<String, ExpressionNode> ruleVariableMap;

	public SubstituteRuleVariables(LinkedHashMap<String, ExpressionNode> ruleVariableMap) {
		this.ruleVariableMap = ruleVariableMap;
	}

	@Override
	public ExpressionNode Visit(PowerNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		return new PowerNode(left, right);
	}

	@Override
	public ExpressionNode Visit(AdditionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		return new AdditionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(SubtractionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		return new SubtractionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(MultiplicationNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		return new MultiplicationNode(left, right);
	}

	@Override
	public ExpressionNode Visit(DivisionNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());

		return new DivisionNode(left, right);
	}

	@Override
	public ExpressionNode Visit(UnaryNode node) throws Exception {
		return new UnaryNode(Visit(node.innerNode));
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.getArguments().get(i)));

		}

		return new FunctionNode(node.getFunction(), arguments);
	}

	@Override
	public ExpressionNode Visit(VariableNode node) {
		return node;
	}

	@Override
	public ExpressionNode Visit(NumberNode node) {
		return node;
	}


	/**
	 * Checks if rule variable visited can be found in the map storing rule variables and their values
	 * Throw exception if not found
	 * If found, replace the RuleVariableNode with the ExpressionNode instance stored with the RuleVariable in the map
	 */
	@Override
	public ExpressionNode Visit(RuleVariableNode node) throws Exception {
		if (this.ruleVariableMap.get(node.toString()) != null) {
			return this.ruleVariableMap.get(node.toString());
		}
		throw new Exception(
				"Attemped to substitute a non-existent rule variable. Check the use of rule variables in your rewrite rules.");
	}

}
