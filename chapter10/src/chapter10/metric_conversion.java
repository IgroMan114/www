package chapter10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class metric_conversion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					metric_conversion window = new metric_conversion();
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
	public metric_conversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnSelectAConversion = new JTextPane();
		txtpnSelectAConversion.setEditable(false);
		txtpnSelectAConversion.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnSelectAConversion.setText("Select a conversion type:");
		txtpnSelectAConversion.setBounds(65, 19, 308, 30);
		panel.add(txtpnSelectAConversion);
		
		JTextPane convert = new JTextPane();
		convert.setFont(new Font("SimSun", Font.PLAIN, 16));
		convert.setBounds(65, 153, 308, 97);
		panel.add(convert);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SimSun", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conversion Types", "feet to meters", "inches to centimeters", "gallons to litres", "pounds to kilogramms"}));
		comboBox.setBounds(65, 60, 308, 39);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				
			
				if(comboBox.getSelectedItem().equals("feet to meters")) 
				{
					convert.setText("1 foot = 0.3048 meters");
				}
				else if(comboBox.getSelectedItem().equals("inches to centimeters")) 
				{
					convert.setText("1 inch = 2.54 centimeters");
				}
				else if(comboBox.getSelectedItem().equals( "gallons to litres")) 
				{
					convert.setText("1 gallon = 4.5461 liters");
				}
				else if(comboBox.getSelectedItem().equals("pounds to kilogramms")) 
				{
					convert.setText("1 pound = 0.4536 kilogramms");
				}
				else 
				{
					convert.setText("");
				}
				
			}
		});
		
		
		
	}
}
