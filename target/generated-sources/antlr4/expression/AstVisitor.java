package expression;

abstract class AstVisitor<T>
{
    public abstract T Visit(AdditionNode node);
    public abstract T Visit(SubtractionNode node);
    public abstract T Visit(MultiplicationNode node);
    public abstract T Visit(DivisionNode node);
    public abstract T Visit(NumberNode node);
    public abstract T Visit(UnaryNode node); 
    
    public abstract T Visit(FunctionNode node);
    public abstract T Visit(RuleVariableNode node);
    public abstract T Visit(VariableNode node);
    
    
    // Condition Nodes
    public abstract T Visit(RelopNode node);
    public abstract T Visit(ConditionFunctionNode node);
    public abstract T Visit(NotNode node);
    
    //public abstract T Visit(CompileUnitNode node);
    // Can talk about how this could be more effieint in C#, see bookmark page 
    public T Visit(ExpressionNode node)
    {
    	System.out.println("Visiting node "+ node.toString());
    	if (node instanceof AdditionNode) {
    	    return Visit((AdditionNode)node);
    	} else if (node instanceof SubtractionNode) {
    	    return Visit((SubtractionNode)node);
    	} else if (node instanceof MultiplicationNode) {
    	    return Visit((MultiplicationNode)node);
    	}  else if (node instanceof DivisionNode) {
    	    return Visit((DivisionNode)node);
    	} else if (node instanceof NumberNode) {
    	    return Visit((NumberNode)node);
    	} else if (node instanceof FunctionNode){
    		return Visit((FunctionNode) node);
    	} else if (node instanceof RuleVariableNode) {
    		return Visit((RuleVariableNode) node);
    	} else if (node instanceof UnaryNode) {
    		return Visit((UnaryNode) node);
    	}
    	else if (node instanceof VariableNode) {
    		return Visit((VariableNode) node);
    	} 
    	/*
    	 * Condition Nodes
    	 * 
    	 */
    	else if (node instanceof RelopNode) {
    		return Visit((RelopNode) node);
    	}
    	else if (node instanceof ConditionFunctionNode) {
    		return Visit((ConditionFunctionNode) node);
    	}
    	else if (node instanceof NotNode) {
    		return Visit((NotNode) node);
    	}
    	
    	
    	
    	
    	else {
    		
    		System.out.println("No expressionNode of suitable type");
    		return null;
    	}
    }
}