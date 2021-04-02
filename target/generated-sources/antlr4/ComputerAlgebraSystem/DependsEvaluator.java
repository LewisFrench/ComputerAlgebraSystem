package ComputerAlgebraSystem;

public class DependsEvaluator extends TermVisitor<Boolean> {

	ExpressionNode dependency;
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
		return Visit(node.Left) || Visit(node.Right);
	}

	// Methods determine if dependency is present in the tree
	@Override
	public Boolean Visit(AdditionNode node) throws Exception {
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
	public Boolean Visit(SubtractionNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(MultiplicationNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(DivisionNode node) throws Exception {

		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.Left) || Visit(node.Right);
	}

	@Override
	public Boolean Visit(ParentheticalNode node) throws Exception {
		if (node.getClass() == dependency.getClass()) {
			if (treeMatcher.Visit(node, dependency)) {
				return true;
			}
		}
		return Visit(node.innerNode);
	}

	@Override
	public Boolean Visit(NumberNode node) {
		return node.getClass() == dependency.getClass() && node.getValue() == ((NumberNode) dependency).getValue();
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

//	@Override
//	public Boolean Visit(RuleVariableNode node) {
//		// Exception here?? Shouldn't be able to reach
//		// Should I make this the case in a a new parent class e.g. not list abstract
//		// Visit(RuleVariableNode node) and have it flag error if visited?
//		return null;
//	}

	@Override
	public Boolean Visit(VariableNode node) {
		return node.getClass() == dependency.getClass()
				&& node.getValue().equals(((VariableNode) dependency).getValue());

	}

}