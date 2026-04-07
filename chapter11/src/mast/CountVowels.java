/*

Program: CountVowels.java          Last Date of this Revision: April 1, 2026

Purpose: Create a CountVowels application that prompts the user for a file name. 
After the file was entered program displays the number of vowels in the file.

Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
  

*/
package mast;

import java.util.Scanner;      // Used to get user input from keyboard
import java.io.*;              // Used for file handling (FileReader, BufferedReader, etc.)
// import java.lang.String;   // Not needed because it's automatically included

public class CountVowels {

    public static void main(String[] args) 
    {
        // File reading objects
        FileReader in;
        BufferedReader readFile;
        String lineOfText;  // Stores each line read from the file
        
        // Variables for processing text
        String text, lowercaseText;  // Original line and lowercase version
        String letter;               // Stores one character at a time
        
        int vowelSum = 0;  // Keeps total count of vowels in the file

        try 
        {
            // Create Scanner object to get file path from user
            Scanner input = new Scanner(System.in);
            
            // Ask user to enter file path
            System.out.println("Enter the path to a file(for example: C:\\Users\\User\\Documents\\Text.txt) : ");
            String filename = input.nextLine().trim();  // Remove extra spaces
            
            // Create File object using the path
            File textFile = new File(filename);
            
            System.out.println("The text in the file: \n");
            
            // Open the file for reading
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            
            // Read file line by line until there are no more lines
            while ((lineOfText = readFile.readLine()) != null) 
            {
                // Print the current line
                System.out.println(lineOfText);
                
                // Remove leading/trailing spaces from the line
                text = lineOfText.trim();
                
                // Convert text to lowercase so vowel check is case-insensitive
                lowercaseText = text.toLowerCase();
                
                // Loop through each character in the line
                for (int i = 1; i <= lowercaseText.length(); i++) 
                {
                    // Extract one character at a time using substring
                    // (i-1 because Java uses 0-based indexing)
                    letter = lowercaseText.substring(i - 1, i);  
                    
                    // Check if the character is a vowel
                    if (letter.equals("a") || letter.equals("e") || 
                        letter.equals("o") || letter.equals("i") || 
                        letter.equals("u"))
                    {
                        // If it is a vowel, increase the count
                        vowelSum += 1;
                    }
                }
            }
            
            // Close the file after reading
            readFile.close();
            in.close();
        } 
        
        // If file is not found
        catch(FileNotFoundException e) 
        {
            System.out.println("File does not exist or could not be found");
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        
        // If there is an error while reading the file
        catch(IOException e) 
        {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        
        // Output total number of vowels found in the file
        System.out.println("\nThe number of vowels in the file text is " + vowelSum);
    }
}
/*

Enter the path to a file(for example: C:\Users\User\Documents\Text.txt) : 
C:\Users\1100107770\git\www\chapter11\src\mast\Text.txt
The text in the file: 

The transistor was developed in Bell laboratories by a group of scientists which included: William Shockley,
John Bardeen and Walter Brattain. A transistor is a semiconductor device with at least three terminals for a connection to an electric circuit.
In the common case, the third terminal controls the flow  of current between the other two terminals.
This can be used for amplification like in a radio receiver , or for rapid switching like in the case of digital circuits.
Transistors replaced bulky and unreliable vacuum tubes, making computers smaller, more efficient and more powerful. 
A microprocessor is a type of miniature electronic device that contains arithmetic, 
logic and control circuitry necessary to perform the functions of a digital computer central processing unit. 
In effect this kind of integrated circuit can interpret and execute the programme as well as handle arithmetic operations. 
In the early 1970s the introduction of large-scale integration (LSI)—which made it possible to pack thousands of transistors, diodes, 
and resistors onto a silicon chip less than 0.2 inch (5 mm) square—led to the development of the microprocessor. 
The first microprocessor was the Intel 4004, which was introduced in 1971.

The number of vowels in the file text is 379

*/