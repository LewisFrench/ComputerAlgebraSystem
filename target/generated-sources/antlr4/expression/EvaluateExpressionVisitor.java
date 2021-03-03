package expression;



// Make into <expressionNode> and implement solver?
class EvaluateExpressionVisitor extends AstVisitor<String>
{
	
    @Override
    public String Visit(AdditionNode node)
    {	
    	System.out.println("Visit addition");
        return Visit(node.Left) + "+"+ Visit(node.Right);
    }

    @Override
    public String Visit(SubtractionNode node)
    {
    	
    	System.out.println("Visit Subtraction");
        return Visit(node.Left) + "-" + Visit(node.Right);
    }

    @Override
    public  String Visit(MultiplicationNode node)
    {
    	System.out.println("Visit multiplication");
        return Visit(node.Left) + "*" + Visit(node.Right);
    }

    @Override
    public  String Visit(DivisionNode node)
    {
    	System.out.println("Visit division");
    	// divide by 0 errors
        return Visit(node.Left) +"/" + Visit(node.Right);
    }
    
    @Override
    public String Visit(NumberNode node)
    {
    	System.out.println("Visit number");
        return String.valueOf(node.value);
    }
    
    @Override
    public String Visit(UnaryNode node)
    {
    	System.out.println("Visit unary");
        return ("-" +String.valueOf(Visit(node.innerNode).toString()));
    }
    @Override
    public String Visit(FunctionNode node) {
    	System.out.println("Visit function");
    	return node.function + node.arguments;
    }

	@Override
	public String Visit(RuleVariableNode node) {
		System.out.println("Visit rulevariable");
		return node.toString();
	}

	@Override
	public String Visit(VariableNode node) {
		System.out.println("Visit variable, maybe Compile UNIT???");//" + node.toString());
		//return node.toString();
		return null;
	}

	@Override
	public String Visit(RelopNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(ConditionFunctionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(NotNode node) {
		// TODO Auto-generated method stub
		return null;
	}
}