package VisitorClasses;

import Nodes.*;
import VisitClasses.VisitTerm;
/**
 * Fulfills the function of the '_depends' condition function. A story passed as
 * a subtree as a dependency and traverses a subtree to determine if the
 * dependency subtree occurs anywhere within the visited subtree.
 * 
 * Returns true if a visited node matches the structure of the dependency. 
 * If not, continues tree traversal to determine if depdendency exists in a subtree
 * 
 * @author lewis
 *
 */
public class DependsEvaluator extends VisitTerm<Boolean> {

	ExpressionNode dependency;
	// Performs checks on subtrees to see if structure matches dependency.
	EvaluateTree treeMatcher = new EvaluateTree();

	public DependsEvaluator(ExpressionNode dependency) {
		this.dependency = dependency;
	}

	@Override
	public Boolean Visit(PowerNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.getLeft()) || Visit(node.getRight());
	}

	@Override
	public Boolean Visit(AdditionNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		boolean left = Visit(node.getLeft());
		boolean right = Visit(node.getRight());
		return left || right;
	}

	@Override
	public Boolean Visit(SubtractionNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.getLeft()) || Visit(node.getRight());
	}

	@Override
	public Boolean Visit(MultiplicationNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.getLeft()) || Visit(node.getRight());
	}

	@Override
	public Boolean Visit(DivisionNode node) throws Exception {

		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.getLeft()) || Visit(node.getRight());
	}

	@Override
	public Boolean Visit(NumberNode node) {
		return node.getClass() == dependency.getClass() && node.compareTo((NumberNode) dependency) == 0;
	}

	@Override
	public Boolean Visit(UnaryNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.innerNode);
	}

	@Override
	public Boolean Visit(FunctionNode node) throws Exception {

		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}

		boolean argumentMatch = false;
		for (ExpressionNode argument : node.arguments) {
			argumentMatch = argumentMatch || Visit(argument);
		}
		return argumentMatch;
	}

	@Override
	public Boolean Visit(VariableNode node) {
		return node.getClass() == dependency.getClass()
				&& node.getValue().equals(((VariableNode) dependency).getValue());

	}

}
