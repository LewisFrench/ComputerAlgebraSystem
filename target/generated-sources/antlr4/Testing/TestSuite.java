package Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDependsEvaluator.class, TestEvaluateTree.class, TestRuleAlgebraParser.class,
		TestSimplifyNumericalOperations.class, TestSubstituteRuleVariables.class, TestTermParser.class,
		TestFetchRuleVariables.class, TestConditionFunctions.class, TestSubstituteConditionRuleVariables.class,
		TestEvaluateTermOutput.class, TestFetchConditionRuleVariables.class, TestEvaluateConditionsVisitor.class,
		TestRule.class, TestRewriteProcess.class, TestProgram.class, TestNumericalOperations.class,
		TestRationalNumbers.class, TestGUI.class, TestExpressionNodeOutput.class })
public class TestSuite {

}
