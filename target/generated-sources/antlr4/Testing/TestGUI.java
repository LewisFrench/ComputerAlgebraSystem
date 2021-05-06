package Testing;

import java.util.ArrayList;

import org.junit.Test;

import ComputerAlgebraSystem.GUI;
import ComputerAlgebraSystem.Program;

public class TestGUI {

	@Test
	public void testGUI_GetRulesValid() {
		GUI g = new GUI();
		ArrayList<String> mockRule = new ArrayList<>();
		mockRule.add("x = y");
		try {
			g.getRules(mockRule, new Program());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGUI_GetRules_FormatException() {
		GUI g = new GUI();
		ArrayList<String> mockRule = new ArrayList<>();
		mockRule.add("x = ");
		try {
			g.getRules(mockRule, new Program());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGUI_GetRules_ParseCancellation() {
		GUI g = new GUI();
		ArrayList<String> mockRule = new ArrayList<>();
		mockRule.add("x2 =x ");
		try {
			g.getRules(mockRule, new Program());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
