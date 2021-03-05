package expression;



// Make into <expressionNode> and implement solver?
class EvaluateExpressionVisitor extends AstVisitor<String>
{
	
    @Override
    public String Visit(AdditionNode node)
    {	
        return Visit(node.Left) + "+"+ Visit(node.Right);
    }

    @Override
    public String Visit(SubtractionNode node)
    {
    	
        return Visit(node.Left) + "-" + Visit(node.Right);
    }

    @Override
    public  String Visit(MultiplicationNode node)
    {
    	System.out.println("MUL");
        return Visit(node.Left) + "*" + Visit(node.Right);
    }

    @Override
    public  String Visit(DivisionNode node)
    {
    	// divide by 0 errors
        return Visit(node.Left) +"/" + Visit(node.Right);
    }
    
    @Override
    public String Visit(NumberNode node)
    {
        return String.valueOf(node.value);
    }
    
    @Override
    public String Visit(UnaryNode node)
    {
        return ("-" +String.valueOf(Visit(node.innerNode).toString()));
    }
    @Override
    public String Visit(FunctionNode node) {
    	return node.function + node.arguments;
    }

	@Override
	public String Visit(RuleVariableNode node) {
		
		return node.toString();
	}

	@Override
	public String Visit(VariableNode node) {;
		
		return node.toString();
	}
	/*
	 * 
	 * Condition Nodes 
	 * 
	 */
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

	@Override
	public String Visit(ConditionAndNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Visit(ConditionOrNode node) {
		// TODO Auto-generated method stub
		return null;
	}
}