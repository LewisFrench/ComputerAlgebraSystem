package ComputerAlgebraSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class GUI implements ActionListener {
	JFileChooser fileChooser;
	JButton openFileButton;
	JTextField enterTerm;
	JButton beginRewriteButton;
	JLabel termLabel;
	JLabel term;
	JLabel filePath;

	//JLabel result;
	JTextArea result;

	File rulesFile = null;

	JTextArea errorMessage;

	JTextField enterRuleApplicationLimit;

//	public static void main(String[] args) {
//		new GUI();
//
//	}

	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		fileChooser = new JFileChooser(".");
		fileChooser.setCurrentDirectory(new java.io.File("./RewriteRules"));
		fileChooser.setDialogTitle("Open Rewrite Rules");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
		fileChooser.setFileFilter(filter);
		// panel.add(fileChooser, BorderLayout.PAGE_START);

		openFileButton = new JButton("Load Rules");
		openFileButton.addActionListener(this);
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(openFileButton, c);

		termLabel = new JLabel("Enter an algebraic term:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 04;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel.add(termLabel, c);

		enterTerm = new JTextField("enter term");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 30;
		c.gridwidth = 3;
		panel.add(enterTerm, c);

		beginRewriteButton = new JButton("Apply Rewrite Rules");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 10;
		c.gridwidth = 3;
		beginRewriteButton.addActionListener(this);
		panel.add(beginRewriteButton, c);

		result = new JTextArea(2, 20);
		result.setWrapStyleWord(true);
		result.setLineWrap(true);
		result.setOpaque(false);
		result.setEditable(false);
		result.setText("OIAWNN");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 9;
		c.ipady = 10;

		c.gridwidth = 3;
		panel.add(result,c);

		errorMessage = new JTextArea();
		
		errorMessage.setWrapStyleWord(true);
		errorMessage.setLineWrap(true);
		errorMessage.setOpaque(false);
		errorMessage.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 14;
		
		panel.add(errorMessage,c);
		
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Computer Algebra System");
		frame.pack();
		frame.setVisible(true);

//		JFrame frame = new JFrame();
//
//		openFileButton = new JButton("Load Rules");
//		enterTerm = new JTextField("", 30);
//		beginRewriteButton = new JButton("Apply Rewrite Rules");
//		// Program p = new Program();
//		term = new JLabel("");
//		filePath = new JLabel("");
//		result = new JLabel("");
//		errorMessage = new JLabel("");
//		enterRuleApplicationLimit = new JTextField("", 10);
//		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//
//		JPanel panel = new JPanel();
//
//		panel.setLayout(new GridBagLayout());
//		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//		panel.setLayout(new GridLayout(0, 1));
//
//		panel.add(openFileButton);
//		panel.add(enterTerm);
//		panel.add(enterRuleApplicationLimit);
//		panel.add(beginRewriteButton);
//		panel.add(term);
//		panel.add(filePath);
//		panel.add(result);
//		panel.add(errorMessage);
//
//		openFileButton.addActionListener(this);
//		beginRewriteButton.addActionListener(this);
//		frame.add(panel, BorderLayout.CENTER);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("Computer Algebra System");
//		frame.pack();
//		frame.setVisible(true);
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
			errorMessage.setText("");
			result.setText("");
			Program p = new Program();
			try {

				ArrayList<String> ruleStringList = readRules(fileChooser.getSelectedFile());
				ArrayList<Rule> rules = this.getRules(ruleStringList, p);
				if (rules != null) {
					ExpressionNode term = p.parseTerm(enterTerm.getText());
					String output = p.Rewrite(rules, term, Integer.MAX_VALUE - 1);
					result.setText(output);

				}
			} catch (StackOverflowError soe) {
				errorMessage.setText(soe.getLocalizedMessage());
			} catch (NumberFormatException nfe) {
				errorMessage.setText("Please select a valid positive integer below " + Integer.MAX_VALUE
						+ " as the rule application limit");
			} catch (FileNotFoundException fnfe) {
				errorMessage.setText("ERROR : " + fnfe.getMessage());
			} catch (NullPointerException npe) {
				errorMessage.setText("ERROR : " + npe.getMessage());
			} catch (ParseCancellationException pce) {
				errorMessage.setText(pce.getMessage());
			} catch (Exception ex) {
				errorMessage.setText(ex.getMessage());
				
			}
		}
	}

	public ArrayList<Rule> getRules(ArrayList<String> ruleStringList, Program p) throws Exception {
		try {
			ArrayList<Rule> rules = new ArrayList<Rule>();
			System.out.println("RULE STRING : " + ruleStringList.toString());
			for (String ruleString : ruleStringList) {

				Rule rule = p.parseRule(ruleString);
				if (rule != null) {
					rules.add(rule);
				}
			}
			return rules;
		} catch (ParseCancellationException pce) {
			errorMessage.setText(pce.getMessage());
		} catch (Exception ex) {
			errorMessage.setText(ex.getMessage());
		}
		return null;
	}

	public void setOutput(String output) {
		result.setText(output);
	}

	public static ArrayList<String> readRules(File f) throws FileNotFoundException, Exception {

		ArrayList<String> ruleStrings = new ArrayList<>();
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				ruleStrings.add(s.nextLine());
			}
			s.close();
			return ruleStrings;
		} catch (NullPointerException npe) {
			throw new FileNotFoundException("Rules file does not exist");
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

}