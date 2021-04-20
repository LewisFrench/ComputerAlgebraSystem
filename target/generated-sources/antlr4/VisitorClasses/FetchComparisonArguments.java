package VisitorClasses;

import java.util.ArrayList;
import Nodes.*;
import Visitor.VisitAstComparison;
public class FetchComparisonArguments extends VisitAstComparison<Void> {

	/**
	 * Visitor class to fill a LinkedHashMap with a key of the string value of the
	 * rule variable node, and a null value. Traverses a tree and upon visiting a
	 * rule variable node, puts this instance in the LinkedHashMap variables.
	 * 
	 * @author lewis
	 *
	 */

	ArrayList<String> ruleVariables = new ArrayList<>();
	ArrayList<ExpressionNode> ruleArguments = new ArrayList<>();
	public ArrayList<String> getRuleVariables() {
		return this.ruleVariables;
	}
	public ArrayList<ExpressionNode> getRuleArguments() {
		return this.ruleArguments;
	}

	@Override
	public Void Visit(PowerNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getLeft(), ((PowerNode) node).getLeft());
		Visit(lhsNode.getRight(), ((PowerNode) node).getRight());
		return null;
	}

	@Override
	public Void Visit(AdditionNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getLeft(), ((AdditionNode) node).getLeft());
		Visit(lhsNode.getRight(), ((AdditionNode) node).getRight());
		return null;
	}

	@Override
	public Void Visit(SubtractionNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getLeft(), ((SubtractionNode) node).getLeft());
		Visit(lhsNode.getRight(), ((SubtractionNode) node).getRight());
		return null;
	}

	@Override
	public Void Visit(MultiplicationNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getLeft(), ((MultiplicationNode) node).getLeft());
		Visit(lhsNode.getRight(), ((MultiplicationNode) node).getRight());
		return null;
	}

	@Override
	public Void Visit(DivisionNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getLeft(), ((DivisionNode) node).getLeft());
		Visit(lhsNode.getRight(), ((DivisionNode) node).getRight());

		return null;
	}

	@Override
	public Void Visit(UnaryNode lhsNode, ExpressionNode node) throws Exception {
		Visit(lhsNode.getInnerNode(), ((UnaryNode)node).getInnerNode());
		return null;
	}

	@Override
	public Void Visit(FunctionNode lhsNode, ExpressionNode node) throws Exception {
		for (int i = 0; i < lhsNode.getArguments().size(); i++) {
			Visit(lhsNode.getArguments().get(i), ((FunctionNode)node).getArguments().get(i));

		}
		return null;
	}

	@Override
	public Void Visit(VariableNode lhsNode, ExpressionNode node) {
		return null;
	}

	@Override
	public Void Visit(NumberNode lhsNode, ExpressionNode node) {
		return null;
	}

	@Override
	public Void Visit(RuleVariableNode lhsNode, ExpressionNode node) {
		this.ruleVariables.add(lhsNode.toString());
		this.ruleArguments.add(node);

		return null;
	}

}
