package expression;

import java.util.ArrayList;

public class EvaluateTree extends AstComparator<Boolean> {

	ArrayList<ExpressionNode> arguments;
	
	public EvaluateTree() {
		this.arguments = new ArrayList<>();
	}
	
	
	
	@Override
	public Boolean Visit(AdditionNode lhsNode, ExpressionNode node) {
		System.out.println("\nAddition");
		System.out.println(lhsNode.toString()  + "    " +  node.toString());
		if (lhsNode.getClass() == node.getClass()) {
			
			System.out.println("\nMatching Left : " + lhsNode.Left.toString() + lhsNode.Left.getClass());
			System.out.println(((AdditionNode)node).Left.toString() + ((AdditionNode)node).Left.getClass());
			boolean l = Visit(lhsNode.Left , ((AdditionNode)node).Left);
			System.out.println("\nMatching Right : " + lhsNode.Right.toString() + lhsNode.Right.getClass());
			System.out.println(((AdditionNode)node).Right.toString() + ((AdditionNode)node).Right.getClass());
			boolean r = Visit(lhsNode.Right , ((AdditionNode)node).Right);
		
		}
		
		return true;
		

	}

	@Override
	public Boolean Visit(SubtractionNode lhsNode, ExpressionNode node) {
		System.out.println("Subtraction");
		
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left , ((SubtractionNode)node).Left);
			boolean r = Visit(lhsNode.Left , ((SubtractionNode)node).Right);
		
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean Visit(MultiplicationNode lhsNode, ExpressionNode node) {
		System.out.println("Multiplication");
		if (lhsNode.getClass() == node.getClass()) {
			boolean l = Visit(lhsNode.Left , ((MultiplicationNode)node).Left);
			boolean r = Visit(lhsNode.Left , ((MultiplicationNode)node).Right);
		
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean Visit(DivisionNode lhsNode, ExpressionNode node) {
		System.out.println("Division");
		
		boolean l = false;
		boolean r = false;
		if (lhsNode.getClass() == node.getClass()) {
			l = Visit(lhsNode.Left , ((DivisionNode)node).Left);
			r = Visit(lhsNode.Left , ((DivisionNode)node).Right);
		}
		return l&&r;
	}

	@Override
	public Boolean Visit(NumberNode lhsNode, ExpressionNode node) {
		System.out.println("NumberNode");
		if (lhsNode.getClass() == node.getClass()) {
			if (lhsNode.getValue() == ((NumberNode)node).getValue()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean Visit(UnaryNode lhsNode, ExpressionNode node) {
		boolean match = false;
		if (lhsNode.getClass() == node.getClass()) {
			match = Visit(lhsNode.innerNode, ((UnaryNode)node).innerNode);
		
		}
		return match;
	}

	@Override
	public Boolean Visit(FunctionNode lhsNode, ExpressionNode node) {
		boolean argumentsMatch = false;
	
		if (lhsNode.getClass() == node.getClass()) {
			if (lhsNode.arguments.size() == ((FunctionNode)node).arguments.size()){
				argumentsMatch = true;
				for (int i = 0; i< lhsNode.arguments.size(); i ++ ) {
					System.out.println("Match  " + lhsNode.arguments.get(i) + lhsNode.arguments.get(i).getClass() + "  vs  " + ((FunctionNode)node).arguments.get(i) + ((FunctionNode)node).arguments.get(i).getClass());
					argumentsMatch = argumentsMatch && Visit(lhsNode.arguments.get(i), ((FunctionNode)node).arguments.get(i));
				}
				
			}
		}
		// TODO Auto-generated method stub
		return argumentsMatch;
	}

	@Override
	public Boolean Visit(RuleVariableNode lhsNode, ExpressionNode node) {

		System.out.println("\n Argument added  :  " + lhsNode.toString() + "  =  " + node.toString());
		// TODO Auto-generated method stub
		this.arguments.add(node);
		return true;
	}

	@Override
	public Boolean Visit(VariableNode lhsNode, ExpressionNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(ConditionFunctionNode lhsNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(NotNode lhsNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Visit(RelopNode lhsNode) {
		// TODO Auto-generated method stub
		return null;
	}

}
