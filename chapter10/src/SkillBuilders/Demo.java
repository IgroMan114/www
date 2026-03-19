package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Demo {

	private JFrame frame;
	private JTextField fname;
	private JTextField lname;
	private JComboBox schools;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		ImageIcon w = new ImageIcon("../chapter10/src/western.png");
		ImageIcon c = new ImageIcon("../chapter10/src/crescent.png");
		ImageIcon p = new ImageIcon("../chapter10/src/pearson.jpg");
		ImageIcon ch = new ImageIcon("../chapter10/src/churchill.jpg");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		fname = new JTextField();
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(fname.getText().equals("First Name")) {
					fname.setText("");
				}
			}
			
		});
		fname.setForeground(new Color(127, 127, 127));
		fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fname.setText("First Name");
		fname.setBounds(35, 11, 146, 49);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(lname.getText().equals("Last Name")) {
					lname.setText("");
				}
			}
		});
		lname.setForeground(new Color(127, 127, 127));
		lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lname.setText("Last Name");
		lname.setColumns(10);
		lname.setBounds(231, 11, 146, 49);
		panel.add(lname);
		
		JComboBox grades = new JComboBox();
		grades.setModel(new DefaultComboBoxModel(new String[] {"Select Grade", "10", "11", "12"}));
		grades.setBounds(35, 81, 146, 22);
		panel.add(grades);
		
		schools = new JComboBox();
		schools.setModel(new DefaultComboBoxModel(new String[] {"Select School", "Crescent", "Western", "Piercing", "Churchil"}));
		schools.setBounds(231, 81, 146, 22);
		panel.add(schools);
		
		JTextArea disp = new JTextArea();
		disp.setBackground(new Color(210, 210, 210));
		disp.setBounds(35, 132, 342, 65);
		panel.add(disp);
		
		JLabel pic = new JLabel("");
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		pic.setBounds(35, 208, 342, 289);
		panel.add(pic);
		
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String fn = fname.getText();
				String ln = lname.getText();
				String grade = "";
				String school = "";
				
				if(grades.getSelectedItem().equals("12")) 
				{
					grade = "12";
				}
				else if(grades.getSelectedItem().equals("11")) 
				{
					grade = "11";
				}
				else if(grades.getSelectedItem().equals("10")) 
				{
					grade = "10";
				}
				if(schools.getSelectedItem().equals("Crescent")) 
				{
					school = "Crescent";
					pic.setIcon(c);
				}
				
				else if(schools.getSelectedItem().equals("Western")) 
				{
					school = "Western";
					pic.setIcon(w);
				}
				else if(schools.getSelectedItem().equals("Churchil")) 
				{
					school = "Churchil";
					pic.setIcon(ch);
				}
				else if(schools.getSelectedItem().equals("Piercing")) 
				{
					school = "Piercing";
					pic.setIcon(p);
				}
				
				disp.setText(fn + " " + ln + " is in grade " + grade + " and goes to " + school );
			}
		});
		submit.setBackground(Color.RED);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submit.setBounds(455, 11, 171, 186);
		panel.add(submit);
		
		
	}
}
