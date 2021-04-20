package VisitorClasses;

import java.util.ArrayList;
import Nodes.*;
import Visitor.VisitConditionsRule;
/**
 * Visitor class to fill a ArrayList with a key of the string value of the
 * rule variable nodes. Traverses a tree and upon visiting a
 * rule variable node, puts this instance in the LinkedHashMap variables.
 * 
 * @author lewis
 *
 */
public class FetchConditionRuleVariables extends VisitConditionsRule<Void> {
	ArrayList<String> ruleVariables = new ArrayList<>();

	public FetchConditionRuleVariables() {
	}

	public ArrayList<String> getRuleVariables() {
		return this.ruleVariables;
	}

	@Override
	public Void Visit(ConditionAndNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(ConditionOrNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(ConditionNotNode node) throws Exception {
		Visit(node.getInnerNode());
		return null;
	}

	@Override
	public Void Visit(RelopNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(ConditionFunctionNode node) throws Exception {
		for (int i = 0; i < node.getArguments().size(); i++) {
			Visit(node.getArguments().get(i));
		}
		return null;
	}

	@Override
	public Void Visit(PowerNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(AdditionNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(SubtractionNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(MultiplicationNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(DivisionNode node) throws Exception {
		Visit(node.getLeft());
		Visit(node.getRight());
		return null;
	}

	@Override
	public Void Visit(UnaryNode node) throws Exception {

		Visit(node.getInnerNode());
		return null;
	}

	@Override
	public Void Visit(FunctionNode node) throws Exception {
		for (int i = 0; i < node.getArguments().size(); i++) {
			Visit(node.getArguments().get(i));
		}
		return null;
	}

	@Override
	public Void Visit(VariableNode node) {
		return null;
	}

	@Override
	public Void Visit(NumberNode node) {
		return null;
	}

	@Override
	public Void Visit(RuleVariableNode node) {
		this.ruleVariables.add(node.toString());
		return null;
	}
}