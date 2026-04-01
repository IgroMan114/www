/*

Program: StudentSemesterAverageGUI.java           Last Date of this Revision: April 1, 2026

Purpose: 
Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
  

*/

package mast;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class StudentSemesterAverageGUI {

	// Keeps track of lines (not really used in logic)
	private int lines = 1;
	
	// Main window
	private JFrame frame;
	
	// Input fields
	private JTextField sname;
	private JTextField gradelvl;
	private JTextField semestr;
	private JTextField grade1;
	private JTextField grade2;
	private JTextField grade3;
	private JTextField grade4;
	
	// -------- FILE HANDLING --------
	
	// File where student data is stored
	File textFile = new File("C:\\Users\\1100107770\\git\\www\\chapter10\\src\\mast\\Students.txt");
	
	FileReader in;
	BufferedReader readFile;
	String lineOfText;
	
	FileWriter out;
	BufferedWriter writeFile;
	
	
	/**
	 * Launch the application (runs GUI safely)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSemesterAverageGUI window = new StudentSemesterAverageGUI();
					window.frame.setVisible(true); // Show window
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor (calls initialize method)
	 */
	public StudentSemesterAverageGUI() {
		initialize();
	}

	/**
	 * Builds and sets up GUI components
	 */
	private void initialize() {
		
		// -------- FRAME SETUP --------
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 598, 492); // Window size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute positioning
		
		// Text area to display file content or messages
		JTextArea fileInfo = new JTextArea();
		fileInfo.setBackground(new Color(235, 237, 233));
		fileInfo.setBounds(0, 222, 582, 160);
		frame.getContentPane().add(fileInfo);
		
		// -------- LABELS --------
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 22, 131, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblGradeLevel.setBounds(10, 47, 131, 14);
		frame.getContentPane().add(lblGradeLevel);
		
		JLabel lblSemesterNumber = new JLabel("Semester Number:");
		lblSemesterNumber.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblSemesterNumber.setBounds(10, 72, 155, 14);
		frame.getContentPane().add(lblSemesterNumber);
		
		JLabel lblGrade = new JLabel("Grade 1:");
		lblGrade.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblGrade.setBounds(10, 97, 131, 14);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblGrade_1 = new JLabel("Grade 2:");
		lblGrade_1.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblGrade_1.setBounds(10, 122, 131, 14);
		frame.getContentPane().add(lblGrade_1);
		
		JLabel lblGrade_2 = new JLabel("Grade 3:");
		lblGrade_2.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblGrade_2.setBounds(10, 147, 131, 14);
		frame.getContentPane().add(lblGrade_2);
		
		JLabel lblGrade_3 = new JLabel("Grade 4:");
		lblGrade_3.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblGrade_3.setBounds(10, 172, 121, 14);
		frame.getContentPane().add(lblGrade_3);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("SimSun", Font.PLAIN, 17));
		lblAverage.setBounds(10, 197, 155, 14);
		frame.getContentPane().add(lblAverage);
		
		// -------- INPUT FIELDS --------
		
		sname = new JTextField();
		sname.setBounds(175, 19, 397, 20);
		frame.getContentPane().add(sname);
		sname.setColumns(10);
		
		gradelvl = new JTextField();
		gradelvl.setColumns(10);
		gradelvl.setBounds(175, 44, 397, 20);
		frame.getContentPane().add(gradelvl);
		
		semestr = new JTextField();
		semestr.setColumns(10);
		semestr.setBounds(175, 69, 397, 20);
		frame.getContentPane().add(semestr);
		
		grade1 = new JTextField();
		grade1.setColumns(10);
		grade1.setBounds(175, 94, 397, 20);
		frame.getContentPane().add(grade1);
		
		grade2 = new JTextField();
		grade2.setColumns(10);
		grade2.setBounds(175, 119, 397, 20);
		frame.getContentPane().add(grade2);
		
		grade3 = new JTextField();
		grade3.setColumns(10);
		grade3.setBounds(175, 144, 397, 20);
		frame.getContentPane().add(grade3);
		
		grade4 = new JTextField();
		grade4.setColumns(10);
		grade4.setBounds(175, 169, 397, 20);
		frame.getContentPane().add(grade4);
		
		// -------- SAVE BUTTON --------
		
		JButton saveButton = new JButton("Save to File");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				// Clear previous messages
				fileInfo.setText("");
				
				// Get user input
				String sNameInput = sname.getText().trim();
	            String gradelvlInput = gradelvl.getText().trim();
	            String semestrInput = semestr.getText().trim();
	            String grade1Input = grade1.getText().trim();
	            String grade2Input = grade2.getText().trim();
	            String grade3Input = grade3.getText().trim();
	            String grade4Input = grade4.getText().trim();
	            
	            // Validate empty fields
	            if(sNameInput.isEmpty() || gradelvlInput.isEmpty() || semestrInput.isEmpty() ||
					grade1Input.isEmpty() || grade2Input.isEmpty() || grade3Input.isEmpty() || grade4Input.isEmpty())
	            {
					fileInfo.append("Please fill in all fields.");
	                return;
	            }

				try 
				{
					// Convert inputs to numbers
					double grdlvl = Double.parseDouble(gradelvlInput);
		            double semestr = Double.parseDouble(semestrInput);
		            double grd1 = Double.parseDouble(grade1Input);
					double grd2 = Double.parseDouble(grade2Input);
					double grd3 = Double.parseDouble(grade3Input);
					double grd4 = Double.parseDouble(grade4Input);
					
					// Validate ranges
					if(grdlvl > 12 || grdlvl < 1) 
					{
						fileInfo.append("Grade level must be 1–12");
					}
					else if(semestr > 2 || semestr < 1) 
					{
						fileInfo.append("Semester must be 1–2");
					}
					else if(grd1 > 100 || grd1 < 0 || grd2 > 100 || grd2 < 0 || grd3 > 100 || grd3 < 0 || grd4 > 100 || grd4 < 0) 
					{
						fileInfo.append("Grades must be 0–100");
					}
					
					// Write data to file (append mode)
					fileInfo.setText("");
					out = new FileWriter(textFile, true);
					writeFile = new BufferedWriter(out);
					
					// Calculate average
					double avg  = ((grd1 + grd2 + grd3 + grd4) / 4);
					String score = String.valueOf(avg) + "%";
					
					// Write formatted data
					writeFile.write("Name: " + sNameInput + ", Grade Level: " + gradelvlInput + 
							", Semester: " + semestrInput + ", Grades: " + grade1Input + ", " + 
							grade2Input + ", " + grade3Input + ", " + grade4Input + ", " + "Average: " + score);
					writeFile.newLine();
					
					// Close file
					writeFile.close();
					out.close();
					
					// Update GUI
					lblAverage.setText("Average: " + score);
					JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
					
				}	
				catch(NumberFormatException ex) 
				{
					fileInfo.append("Inputs must be valid numbers.");
				}
				catch(IOException e1) 
				{
					fileInfo.setText("IOException: " + e1.getMessage());
				}
			}
		});
		
		// -------- VIEW FILE BUTTON --------
		
		JButton btnViewFileContents = new JButton("View File Contents");
		btnViewFileContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					// Open file
					in = new FileReader(textFile);
					readFile = new BufferedReader(in);
					
					fileInfo.setText("");
					
					// Read and display file contents
					while ((lineOfText = readFile.readLine()) != null) 
					{
						fileInfo.append(lineOfText + "\n");
					}
					
					// Close file
					readFile.close();
					in.close();
				} 
				catch(FileNotFoundException e1) 
				{
					fileInfo.setText("File not found.");
				}
				catch(IOException e1) 
				{
					fileInfo.setText("IOException: " + e1.getMessage());
				}
			}
		});
	}
}