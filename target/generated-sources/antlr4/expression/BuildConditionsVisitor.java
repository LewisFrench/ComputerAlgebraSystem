package expression;
import Conditions.ConditionsBaseVisitor;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;

public class BuildConditionsVisitor extends ConditionsBaseVisitor<ExpressionNode> {
	
	
	@Override 
	public ExpressionNode visitConditionOperation(ConditionsParser.ConditionOperationContext context) {
		ConditionOperationNode node = null;
		
		if (context.op.getType() == ConditionsLexer.OP_AND) {
			node = new ConditionAndNode();
		} else if (context.op.getType() == ConditionsLexer.OP_OR) {
			node = new ConditionOrNode();
		}
		node.left = visit(context.left);
		node.right = visit(context.right);
		
		return node;
	}
	
	@Override
	public ExpressionNode visitRuleConditions(ConditionsParser.RuleConditionsContext context) {
		System.out.println("Visit Rule Conditions");
		return visit(context.condition());
	}
	
	@Override
	public ExpressionNode visitNot(ConditionsParser.NotContext context) {
		System.out.println("Visiitng Not");
		
		return new NotNode(visit(context.condition()));
	}
	
	@Override
	public ExpressionNode visitConditionParenthetical(ConditionsParser.ConditionParentheticalContext context) {
		return visit(context.condition());
	}
	
	@Override
	public ExpressionNode visitFunction(ConditionsParser.FunctionContext context) {
		System.out.println("Visiting Function " + context.function.getText());
		System.out.println(visit(context.var()).toString());
		
		
		return new ConditionFunctionNode(context.function.getText(), visit(context.var()));
	}

	@Override
	public ExpressionNode visitRelop(ConditionsParser.RelopContext context) {
		System.out.println("Visit Relop");
		ExpressionNode left =  visit(context.left);
		ExpressionNode right = visit(context.right);
		//RelopNode r = new RelopNode(n,v, context.relop.getText());
		
		return new RelopNode(left, right, context.relop.getText()); 
	}
	@Override
	public ExpressionNode visitNumber(ConditionsParser.NumberContext context) {
		System.out.println("Visit Number");
		return new NumberNode(Double.valueOf(context.value.getText()));
	}
	@Override
	public ExpressionNode visitVariable(ConditionsParser.VariableContext context) {
		System.out.println("Visit Variable");
		return new RuleVariableNode(context.value.getText());
	}
	

}




