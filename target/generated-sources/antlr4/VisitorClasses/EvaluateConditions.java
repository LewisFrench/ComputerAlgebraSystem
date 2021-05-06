package VisitorClasses;

import ConditionFunctions.ConditionFunctionEvaluator;
import Conditions.ConditionsLexer;
import Nodes.*;
import VisitClasses.VisitConditionNodes;

/**
 * Traverses the condition node of a rule and determines if the conditions
 * listen are true or false.
 * 
 * @author lewis
 *
 */
public class EvaluateConditions extends VisitConditionNodes<Boolean> {
	ConditionFunctionEvaluator conditionFunctions;

	public EvaluateConditions() {
		this.conditionFunctions = new ConditionFunctionEvaluator();
	}

	@Override
	public Boolean Visit(ConditionAndNode node) throws Exception {
		return (Visit(node.getLeft()) && Visit(node.getRight()));
	}

	@Override
	public Boolean Visit(ConditionOrNode node) throws Exception {
		return (Visit(node.getLeft()) || Visit(node.getRight()));
	}

	@Override
	public Boolean Visit(ConditionNotNode node) throws Exception {
		return !(Visit(node.getInnerNode()));
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) throws Exception {
		return this.conditionFunctions.determineFunction(node.getFunctionName(), node.getArguments());
	}

	@Override
	public Boolean Visit(RelopNode node) throws Exception {
		boolean relopResult = evaluateRelop(node);
		return relopResult;
	}

	public boolean evaluateRelop(RelopNode relopNode) throws Exception {

		// Decide equivalence between any two nodes
		
		// Simplify numerical expressions for inequality comparison
		ExpressionNode evaluatedLeft = new EvaluateNumericalOperations().Visit(relopNode.getLeft());
		ExpressionNode evaluatedRight = new EvaluateNumericalOperations().Visit(relopNode.getRight());

		EvaluateTree treeMatcher = new EvaluateTree();
		if (relopNode.getRelop() == ConditionsLexer.RELOP_EQ) {
			return treeMatcher.Visit(relopNode.getLeft(), relopNode.getRight());
		} else if (relopNode.getRelop() == ConditionsLexer.RELOP_NEQ) {
			return !(treeMatcher.Visit(relopNode.getLeft(), relopNode.getRight()));
		}

		// Throw exception if trying to compare non-numerical values
		if (!(evaluatedLeft instanceof NumberNode && evaluatedRight instanceof NumberNode)) {
			throw new Exception("Check your rule conditions. You cannot evaluate inequalities of non-numerical terms");
		}

		// If numerical, cast as such and carry out comparison.
		NumberNode l = (NumberNode) (evaluatedLeft);
		NumberNode r = (NumberNode) (evaluatedRight);

		boolean relopResult = false;
		
		// perform comparisons based on type of operator
		switch (relopNode.getRelop()) {

		case ConditionsLexer.RELOP_LT:
			relopResult = l.compareTo(r) < 0;
			break;
		case ConditionsLexer.RELOP_LTE:
			relopResult = l.compareTo(r) <= 0;
			break;
		case ConditionsLexer.RELOP_GT:
			relopResult = l.compareTo(r) > 0;
			break;
		case ConditionsLexer.RELOP_GTE:
			relopResult = l.compareTo(r) >= 0;
		}
		return relopResult;
	}

}
