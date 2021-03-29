package expression;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI implements ActionListener {
	JFileChooser fileChooser;
	JButton openFileButton;
	JTextField enterTerm;
	JButton beginRewriteButton;

	JLabel term;
	JLabel filePath;

	JLabel result;

	File rulesFile = null;

	JLabel errorMessage;

	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		JFrame frame = new JFrame();
		fileChooser = new JFileChooser(".");
		fileChooser.setCurrentDirectory(new java.io.File("./RewriteRules"));
		fileChooser.setDialogTitle("Open Rewrite Rules");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
		fileChooser.setFileFilter(filter);
		openFileButton = new JButton("Load Rules");
		enterTerm = new JTextField("", 30);
		beginRewriteButton = new JButton("Apply Rewrite Rules");

		term = new JLabel("");
		filePath = new JLabel("");
		result = new JLabel("");
		errorMessage = new JLabel("");

		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));

		panel.add(openFileButton);
		panel.add(enterTerm);
		panel.add(beginRewriteButton);
		panel.add(term);
		panel.add(filePath);
		panel.add(result);
		panel.add(errorMessage);

		openFileButton.addActionListener(this);
		beginRewriteButton.addActionListener(this);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Computer Algebra System");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openFileButton) {
			if (fileChooser.showOpenDialog(openFileButton) == JFileChooser.APPROVE_OPTION) {
				rulesFile = fileChooser.getSelectedFile();
				System.out.println("File : " + rulesFile);
			}
		}
		if (e.getSource() == beginRewriteButton) {
			try {
				Program p = new Program();
				ArrayList<String> ruleStringList = readRules(fileChooser.getSelectedFile());
				ArrayList<Rule>rules = new ArrayList<>();
				for (String ruleString : ruleStringList) {
					Rule rule = p.parseRules(ruleString);
					if (rule != null) {
						rules.add(rule);
					}
				}
				//ArrayList<Rule> ruleObjects = p.generateRules(rules);
				for (Rule rule: rules) {
					System.out.println("Rule : " + rule.toString());
				}
				//result.setText("Output:  " + readRules(r, enterTerm.getText()));
			} catch (FileNotFoundException ex) {
				errorMessage.setText("ERROR: " + ex.getMessage());
			}
		}
	}

//	public static String applyRewrite(ArrayList<String> rules, String term) {
//		try {
//			Program p = new Program();
//			ArrayList<Rule> ruleObjects = p.generateRules(rules);
//			//return p.generateRules(rules);
//			//return p.Rewrite(rules, term);
//		} catch (Exception e) {
//			System.out.println("Fucked it in GUI");
//			return "";
//		}
//		return "output goes here";
//	}

	public void setOutput(String output) {
		result.setText(output);
	}

	public static ArrayList<String> readRules(File f) throws FileNotFoundException {
		ArrayList<String> ruleStrings = new ArrayList<>();
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			ruleStrings.add(s.nextLine());
		}
		// System.out.println("Rules: " + ruleStrings.toString());
		s.close();
		return ruleStrings;

	}

}