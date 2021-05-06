package VisitorClasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import Nodes.*;
import VisitClasses.VisitConditions;
/**
 * Handles the traversal of the conditions of a rule, substituting instances of RuleVariableNode with their value in the LinkedHashMap containing their corresponding values
 * E.g. conditions $n > 3  given LinkedHashMap "$n" : NumberNode(1)  --> 1 > 3
 * @author lewis
 *
 */
public class SubstituteConditionRuleVariables extends VisitConditions<ExpressionNode>{
	LinkedHashMap<String, ExpressionNode> ruleVariableMap;
	
	
	public SubstituteConditionRuleVariables(LinkedHashMap<String, ExpressionNode> ruleVariableMap) {
		this.ruleVariableMap = ruleVariableMap;
	}
	
	@Override
	public ExpressionNode Visit(ConditionAndNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		return new ConditionAndNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ConditionOrNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		return new ConditionOrNode(left, right);
	}

	@Override
	public ExpressionNode Visit(ConditionNotNode node) throws Exception {
		return new ConditionNotNode(Visit(node.innerNode));
	}

	@Override
	public ExpressionNode Visit(RelopNode node) throws Exception {
		ExpressionNode left = Visit(node.getLeft());
		ExpressionNode right = Visit(node.getRight());
		return new RelopNode(left, right, node.getRelop(), node.getRelopText());
	}

	@Override
	public ExpressionNode Visit(ConditionFunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.getArguments().get(i)));
		}

		return new ConditionFunctionNode(node.getFunctionName(), arguments);
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
		return new UnaryNode(Visit(node.getInnerNode()));
	}

	@Override
	public ExpressionNode Visit(FunctionNode node) throws Exception {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < node.getArguments().size(); i++) {
			arguments.add(Visit(node.getArguments().get(i)));

		}
		return new FunctionNode(node.function, arguments);
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
		throw new Exception("Attempting to substitute a non-existent rule variable. Please check the structure of your rules");
	}

}
