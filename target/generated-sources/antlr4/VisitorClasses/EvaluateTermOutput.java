package VisitorClasses;

import Nodes.*;
import VisitClasses.VisitTerm;

/**
 * Visitor class to traverse the tree and generate a string representation of
 * the tree. Differs from toString() methods for sake of customisation of output
 * while maintaining the toString output for RewriteErrors
 * 
 * @author lewis
 *
 */
public class EvaluateTermOutput extends VisitTerm<String> {

	@Override
	public String Visit(PowerNode node) throws Exception {

		return Visit(node.getLeft()) + "^" + Visit(node.getRight());
	}

	@Override
	public String Visit(AdditionNode node) throws Exception {
		return  "("+Visit(node.getLeft()) + "+" + Visit(node.getRight())+")" ;
	}

	@Override
	public String Visit(SubtractionNode node) throws Exception {
		return Visit(node.getLeft()) + "-" + Visit(node.getRight());
	}

	@Override
	public String Visit(MultiplicationNode node) throws Exception {
		return "(" + Visit(node.getLeft()) + "*" + Visit(node.getRight()) + ")";
	}

	@Override
	public String Visit(DivisionNode node) throws Exception {
		return Visit(node.getLeft()) + "/" + Visit(node.getRight());
	}


	@Override
	public String Visit(UnaryNode node) throws Exception {
		return ("-" + Visit(node.getInnerNode()).toString());
	}

	@Override
	public String Visit(FunctionNode node) throws Exception {
		String output = node.getFunction() + "(";
		for (int i = 0 ; i < node.getArguments().size() ; i ++) {
			output += Visit(node.getArguments().get(i));
			if (!(i == node.getArguments().size() -1)) {
				output+= ",";
			}
		}
		output += ")";

		return output;
	}

	@Override
	public String Visit(VariableNode node) {
		return node.toString();
	}
	
	@Override
	public String Visit(NumberNode node) {
		return node.toString();
	}


}