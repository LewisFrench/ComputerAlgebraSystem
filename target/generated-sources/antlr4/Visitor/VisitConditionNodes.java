package Visitor;
import Nodes.*;

public abstract class VisitConditionNodes<T> {

	public abstract T Visit(ConditionAndNode node) throws Exception;

	public abstract T Visit(ConditionOrNode node) throws Exception;

	public abstract T Visit(ConditionNotNode node) throws Exception;

	public abstract T Visit(RelopNode node) throws Exception;

	public abstract T Visit(ConditionFunctionNode node) throws Exception;

	public T Visit(ExpressionNode node) throws Exception {
		if (node instanceof ConditionAndNode) {
			return Visit((ConditionAndNode) node);
		} else if (node instanceof ConditionOrNode) {
			return Visit((ConditionOrNode) node);
		} else if (node instanceof ConditionNotNode) {
			return Visit((ConditionNotNode) node);
		} else if (node instanceof RelopNode) {
			return Visit((RelopNode) node);
		} else if (node instanceof ConditionFunctionNode) {
			return Visit((ConditionFunctionNode) node);
		} else {
			throw new IllegalArgumentException("Attempted to visit invalid node. Please check the struture of your rules");
		}
	}
}