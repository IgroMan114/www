/*
package chapter10;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class semesteraverage {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					semesteraverage window = new semesteraverage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public semesteraverage() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

*/
package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;

public class semesteraverage implements ActionListener {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					semesteraverage window = new semesteraverage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JFrame frame;
	JPanel contentPane;
	JLabel prompt1, prompt2, prompt3, average;
	JTextField grade1, grade2, grade3;
	JButton avgButton;
	public semesteraverage() {
	/* Create and set up the frame */
	frame = new JFrame("Semestr Average");
	frame.setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE);
	/* Create a content pane with a GridLayout */ 
	contentPane = new JPanel();
	contentPane.setLayout(new GridLayout (0, 2, 10, 5)); 
	contentPane.setBorder(BorderFactory.createEmptyBorder (10, 10, 10, 10));
	/* Create and add a prompt and then a text field */ 
	prompt1 = new JLabel("Enter the first grade: "); 
	contentPane.add(prompt1);
	grade1 = new JTextField (10);
	contentPane.add(grade1);
	/* Create and add a second prompt and
	then a text field */
	prompt2 = new JLabel("Enter the second grade: ");
	contentPane.add(prompt2);
	grade2 = new JTextField(10);
	contentPane.add(grade2);
	/* Create and add a third prompt and then a text field */ prompt3 = new JLabel("Enter the third grade: ");
	contentPane.add(prompt3);
	grade3 = new JTextField (10);
	contentPane.add(grade3);
	/* Create and add button that will display the average of the grades */
	avgButton = new JButton("Average");
	avgButton.setActionCommand("Average"); avgButton.addActionListener(this); contentPane.add(avgButton);
	/* Create and add a label that will display the
	average */
	average = new JLabel(" ");
	contentPane.add(average);
	
	/* Add content pane to frame */ 
	frame.setContentPane (contentPane);
	}
	public void actionPerformed(ActionEvent e) 
	{
		String fgr,sgr,tgr;
		if(grade1.getText().trim().isEmpty() ||
			    grade2.getText().trim().isEmpty() ||
			    grade3.getText().trim().isEmpty())
		{
			average.setText("Fill all grades to calculate the average");
		}
		else {
			
		fgr = (grade1.getText());
		
		sgr = (grade2.getText());
		
		tgr = (grade3.getText());

		int gr1 = Integer.parseInt(fgr);
		int gr2 = Integer.parseInt(sgr);
		int gr3 = Integer.parseInt(tgr);
		int average1 = (gr1 + gr2 + gr3) / 3;
		
		average.setText("Average: " + average1);
		}
	}
}