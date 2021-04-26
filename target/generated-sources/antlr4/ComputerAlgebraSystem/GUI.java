package ComputerAlgebraSystem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import Nodes.*;

public class GUI implements ActionListener {
	JFileChooser fileChooser;
	JButton openFileButton;
	JTextArea enterTerm;
	JButton beginRewriteButton;
	JLabel termLabel;
	JLabel term;
	JLabel filePath;
	JTextArea result;
	File rulesFile = null;
	JTextArea errorMessage;
	JTextField enterRuleApplicationLimit;
	JLabel limitLabel;
	JTextField enterLimit;
	JTextArea rewriteData;

	public GUI() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.insets = new Insets(5, 5, 5, 5);
		
		//Set JFileChooser settings to only accept text files
		fileChooser = new JFileChooser(".");
		fileChooser.setCurrentDirectory(new java.io.File("./RewriteRules"));
		fileChooser.setDialogTitle("Open Rewrite Rules");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
		fileChooser.setFileFilter(filter);

		// Add button to load rewrite rules
		openFileButton = new JButton("Load Rules");
		openFileButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;

		c.ipadx = 0;
		panel.add(openFileButton, c);

		// Add label to point to rule application limit
		limitLabel = new JLabel("Rule Application Limit:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 0;
		panel.add(limitLabel, c);

		// Add text field to enter rule application limit
		enterLimit = new JTextField("10000");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.6;
		c.gridx = 2;
		c.ipadx = 40;
		c.ipady = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel.add(enterLimit, c);

		// Add label to show where to enter algebraic term
		termLabel = new JLabel("Enter an algebraic term:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.ipadx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel.add(termLabel, c);

		// Add area to enter algebraic term
		enterTerm = new JTextArea("enter term");
		enterTerm.setLineWrap(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 30;
		c.gridwidth = 3;
		panel.add(enterTerm, c);

		// Add button to begin rewriting process
		beginRewriteButton = new JButton("Apply Rewrite Rules");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 10;
		c.gridwidth = 3;
		beginRewriteButton.addActionListener(this);
		panel.add(beginRewriteButton, c);

		
		// Add area to display result from rewriting
		result = new JTextArea(2, 20);
		result.setWrapStyleWord(true);
		result.setLineWrap(true);
		result.setOpaque(false);
		result.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 4;
		c.ipadx = 100;
		c.ipady = 500;
		
		// Make display area scrollable
		JScrollPane scroll = new JScrollPane(result);
		c.gridwidth = 3;
		// panel.add(result, c);
		panel.add(scroll, c);

		
		// Add area to display error messages
		errorMessage = new JTextArea();
		errorMessage.setWrapStyleWord(true);
		errorMessage.setLineWrap(true);
		errorMessage.setOpaque(false);
		errorMessage.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 5;
		c.ipadx = 0;
		c.ipady = 0;
		panel.add(errorMessage, c);

		// Add area to show statistics about rewriting process
		rewriteData = new JTextArea("");
		rewriteData.setWrapStyleWord(true);
		rewriteData.setEditable(false);
		rewriteData.setLineWrap(true);
		rewriteData.setOpaque(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		c.ipadx = 0;
		c.gridwidth = 1;
		panel.add(rewriteData, c);

		
		// Add all components to the frame
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Computer Algebra System");
		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Handles on click events for the GUI. 
	 * Opens file chooser window if user clicks to 'load rules'
	 * Begins the rewrite process if user clicks to 'Apply Rewrite Rules'
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Open File chooser window
		if (e.getSource() == openFileButton) {
			if (fileChooser.showOpenDialog(openFileButton) == JFileChooser.APPROVE_OPTION) {
				rulesFile = fileChooser.getSelectedFile();
			}
		}
		// Begin rewriting process
		if (e.getSource() == beginRewriteButton) {
			errorMessage.setText("");
			result.setText("");
			Program p = new Program();
			try {
				// Check validity of rule application limit input
				int ruleApplicationLimit;
				if (!(validateRuleApplicationLimit(enterLimit.getText()))) {
					throw new NumberFormatException("Rule Application Limit must be an integer greater than zero");
				} else {
					ruleApplicationLimit = Integer.valueOf(enterLimit.getText());
				}
				// Read file and convert rules to string
				ArrayList<String> ruleStringList = readRules(fileChooser.getSelectedFile());
				// Parse rule strings and store in ArrayList
				ArrayList<Rule> rules = this.getRules(ruleStringList, p);
				// Parse Term and begin Rewriting process if no errors occured during parsing
				if (rules != null) {
					ExpressionNode term = p.parseTerm(enterTerm.getText());
					String output = p.Rewrite(rules, term, ruleApplicationLimit);
					//String output = p.RewriteDeterministic(rules, term, ruleApplicationLimit);
					result.setText(output);
					rewriteData.setText("Rules Applied: " + p.getRulesApplied() + "\nTime taken: "
							+ p.getExecutionTime() + " nanoseconds");
				}
			// Display logical errors to the user

			// Rule application limit is not a positive integer
			} catch (NumberFormatException nfe) {
				errorMessage.setText(nfe.getMessage());
			// Rewrite rules file is not found
			} catch (FileNotFoundException fnfe) {
				errorMessage.setText(fnfe.getMessage());
			// No rewrite rules file is entered
			// No algebraic term is entered
			} catch (NullPointerException npe) {
				errorMessage.setText( npe.getMessage());
			// Division by zero in algebraic term
			} catch (ArithmeticException ae) {
				errorMessage.setText(ae.getMessage());
			// Error parsing algebraic term
			} catch (ParseCancellationException pce) {
				errorMessage.setText(pce.getMessage());
			
			/*
			 * Logical errors in rewriting
			 */
			// Enormous (usually infinitely recursive term) fills java stack
			} catch (StackOverflowError soe) {
				errorMessage.setText(soe.getLocalizedMessage());
			// Logical error occurs during rewriting
			} catch (RewriteError re) {
				errorMessage.setText(re.getMessage());
			// Unexpected error occurs during rewriting, less specific feedback can be given. 
			} catch (Exception ex) {
				System.out.println(ex.getClass());
				ex.printStackTrace();
				errorMessage.setText(ex.getMessage());
			}
		}
	}

	/**
	 * Ensure that rule application limit is a valid integer greater than 0.
	 * 
	 * @param limit
	 * @return boolean validity of rule application limit input
	 */
	public static boolean validateRuleApplicationLimit(String limit) {
		try {
			int limitInt = Integer.valueOf(limit);
			return (limitInt > 0);
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Reads each string representation of rules
	 * 
	 * @param ruleStringList ArrayList of string representations of rewrite rules
	 * @param p              instance of Program class
	 * @return ArrayList containing converted Rule objects for each rewrite rule
	 * @throws Exception, ParseCancellationException in case of invalid syntactic
	 *                    input
	 */
	public ArrayList<Rule> getRules(ArrayList<String> ruleStringList, Program p) throws Exception {
		try {
			ArrayList<Rule> rules = new ArrayList<Rule>();
			for (String ruleString : ruleStringList) {
				Rule rule = p.parseRule(ruleString);
				if (rule != null) {
					rules.add(rule);
				}
			}
			return rules;
		// Display errors in parsing to the user
			
		// Error in structure of rule 
		} catch ( RewriteRuleFormatException rrfe) {
			errorMessage.setText(rrfe.getMessage());
		// Error in syntax of rule
		} catch (ParseCancellationException pce) {
			errorMessage.setText(pce.getMessage());
		} catch (Exception ex) {
			errorMessage.setText(ex.getMessage());
		}
		return null;
	}

	/**
	 * Reads the file selected by the user and converts each line to a string to be
	 * stored in an ArrayList
	 * 
	 * @param f  File entered by the user
	 * @return
	 * @throws FileNotFoundException in case the selected file cannot be found
	 * @throws Exception in case of missing or mis-formatted file
	 */
	public static ArrayList<String> readRules(File f) throws FileNotFoundException, Exception {

		ArrayList<String> ruleStrings = new ArrayList<>();
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				ruleStrings.add(s.nextLine());
			}
			s.close();
			return ruleStrings;
		}  catch (FileNotFoundException fe) {
			throw new FileNotFoundException("Rules file does not exist: " + f.getAbsolutePath());
		} catch (NullPointerException npe) {
			throw new NullPointerException("A file containing rewrite rules must be entered");
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

}