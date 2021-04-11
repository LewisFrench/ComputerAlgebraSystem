package ComputerAlgebraSystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDependsEvaluator.class, TestEvaluateTree.class, TestRuleAlgebraParser.class,
		TestSimplifyConditionNumericalExpressions.class, TestSimplifyNumericalOperations.class,
		TestSubstituteRuleVariables.class, TestTermAlgebraParser.class, TestFetchRuleVariables.class, 
		TestConditionFunctions.class, TestSubstituteConditionRuleVariables.class, 
		TestEvaluateExpressionVisitor.class, TestFetchConditionRuleVariables.class, TestEvaluateConditionsVisitor.class, 
		TestRule.class, TestRewriteProcess.class, TestProgram.class, TestNumericalOperations.class})
public class TestSuite {

}
