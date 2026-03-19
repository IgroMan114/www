package SkillBuilders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang. Math;

public class Roll implements ActionListener {
	
	JFrame frame;
	
	JPanel contentPane;
	
	JButton rollDie;
	
	JLabel dieFace;
	
	ImageIcon one = new ImageIcon("../chapter10/src/dice.png");
	
	ImageIcon two = new ImageIcon("../chapter10/src/dice (1).png");
	
	ImageIcon three = new ImageIcon("../chapter10/src/dice (2).png");
	
	ImageIcon four = new ImageIcon("../chapter10/src/dice (3).png");
	
	ImageIcon five = new ImageIcon("../chapter10/src/dice (4).png");
	
	ImageIcon six = new ImageIcon("../chapter10/src/dice (5).png");
	
	private JLabel dieFace2;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					Roll window = new Roll();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}
	
	public Roll() {
		
	/* Create and set up the frame */
		
	frame = new JFrame("Roll");
	
	frame.setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE);
	
	/* Create a content pane with a BoxLayout and
	empty borders */
	
	contentPane = new JPanel();
	
	contentPane.setBorder (BorderFactory.createEmptyBorder(100, 100, 100, 100));
	
	contentPane.setBackground (Color.white);
	
	contentPane.setLayout(new BoxLayout (contentPane,BoxLayout.PAGE_AXIS));
	
	/* Create a label that shows a die face */ 
	/* Create a Roll Die button */ 
	
	rollDie = new JButton("Roll Die");
	
	rollDie.setAlignmentX(JButton.CENTER_ALIGNMENT);
	
	rollDie.addActionListener(this); 
	
	dieFace2 = new JLabel();
	
	dieFace2 = new JLabel(one); 
	
	dieFace2.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
	
	dieFace2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	
	contentPane.add(dieFace2);
	
	dieFace = new JLabel(one); 
	
	dieFace.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
	
	dieFace.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	
	contentPane.add(dieFace);
	
	contentPane.add(rollDie);
	
	/* Add content pane to Erame */ 
	
	frame.setContentPane(contentPane);
	
	/* Size and then display the frame. */ 
	
	frame.pack();
	
	frame.setVisible(true);
	
	}
	/**
	* Handle a button click
	* pre: none
	* post: A die has been rolled. Matching image shown.
	*/
	
	public void actionPerformed(ActionEvent event) {
		
	int secondRoll;
	
	secondRoll = (int) (6 * Math.random() + 1);
	
	int newRoll;
	
	newRoll = (int) (6 * Math.random() + 1);
	
	int loop = 0;
	
	if (newRoll == 1) 
		{
		dieFace.setIcon(one); 
		} 
	if (newRoll == 2) 
		{
		dieFace.setIcon(two); 
		} 
	if (newRoll == 3) 
		{
		dieFace.setIcon(three); 
		}
	if (newRoll == 4) 
		{
		dieFace.setIcon(four); 
		} 
	if (newRoll == 5) 
		{
		dieFace.setIcon(five);
		}
	if (newRoll == 6) 
		{
		dieFace.setIcon(six);
		}
	if (secondRoll == 1) 
		{
		dieFace2.setIcon(one); 
		} 
	if (secondRoll == 2) 
		{
		dieFace2.setIcon(two); 
		} 
	if (secondRoll == 3) 
		{
		dieFace2.setIcon(three); 
		}
	if (secondRoll == 4) 
		{
		dieFace2.setIcon(four); 
		} 
	if (secondRoll == 5) 
		{
		dieFace2.setIcon(five);
		}
	if (secondRoll == 6) 
		{
		dieFace2.setIcon(six);
		}
	}
}

