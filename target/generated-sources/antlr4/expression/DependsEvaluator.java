package expression;

public class DependsEvaluator extends AstVisitor<Boolean> {

	ExpressionNode dependency;
	EvaluateTree treeMatcher = new EvaluateTree();

	public DependsEvaluator(ExpressionNode dependency) {
		this.dependency = dependency;
	}

	// Methods determine if dependency is present in the tree
	@Override
	public Boolean Visit(AdditionNode node) {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		boolean left = Visit(node.Left);
		boolean right = Visit(node.Right);
		return left || right;
	}

	@Override
	public Boolean Visit(SubtractionNode node) {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(MultiplicationNode node) {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(DivisionNode node) {

		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(NumberNode node) {
		return node.getClass() == dependency.getClass() && node.getValue() == ((NumberNode) dependency).getValue();
	}

	@Override
	public Boolean Visit(UnaryNode node) {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}

		return Visit(node.innerNode);
	}

	@Override
	public Boolean Visit(FunctionNode node) {

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
	public Boolean Visit(RuleVariableNode node) {
		// Exception here?? Shouldn't be able to reach
		// Should I make this the case in a a new parent class e.g. not list abstract
		// Visit(RuleVariableNode node) and have it flag error if visited?
		return null;
	}

	@Override
	public Boolean Visit(VariableNode node) {
		return node.getClass() == dependency.getClass()
				&& node.getValue().equals(((VariableNode) dependency).getValue());

	}

	@Override
	public Boolean Visit(RelopNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ConditionFunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(NotNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ConditionAndNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ConditionOrNode node) {
		// TODO Auto-generated method stub
		return null;
	}

}