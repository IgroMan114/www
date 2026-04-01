/*

Program: WordGuess.java           Last Date of this Revision: April 1, 2026

Purpose: 

Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
  

*/

package mast;

import java.io.*;        // For file handling (FileReader, BufferedReader)
import java.util.Scanner; // For user input
import java.math.*;      // Math functions (though not really needed here)

public class WordGuess {

	public static void main(String[] args) 
	{
		// ---------------- FILE READING SETUP ----------------
		
		String SECRET_WORD = ""; // Stores the randomly selected word
		
		// File containing list of words
		File textFile = new File("C:\\Users\\1100107770\\git\\www\\chapter10\\src\\mast\\words.txt");
		
		FileReader in;            // Reads characters from file
		BufferedReader readFile;  // Reads file line-by-line
		
		// Generate random line number between 1 and 20
		int randomNum =  (int) (20 * (Math.random()) + 1);
		
		int currentLine = 1;  // Keeps track of current line number
		String randomWord;    // Stores each word read from file
		
		try 
		{
			// Open file
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			
			// Read file line-by-line
			while ((randomWord = readFile.readLine()) != null) 
			{
				// If current line matches random number, select that word
				if (currentLine == randomNum) 
				{
					SECRET_WORD = randomWord;
					break; // Stop reading file once word is found
				}
				currentLine++; // Move to next line
			}
			
			// Close file
			readFile.close();
			in.close();
		} 
		
		// Error if file not found
		catch(FileNotFoundException e) 
		{
			System.out.println("File does not exist or could not be found");
			System.err.println("FileNotDoundExcpetion: " + e.getMessage());
		}
		
		// Error while reading file
		catch(IOException e)
		{
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
		
		
		// ---------------- GAME CONSTANTS ----------------
		
		final String FLAG = "!"; // Special input to guess the whole word
		final int LOW = 'A';    // ASCII value of 'A'
		final int HIGH = 'Z';   // ASCII value of 'Z'

		// ---------------- GAME VARIABLES ----------------
		
		String wordSoFar = "", updatedWord = ""; // Tracks progress of guessed word
		String letterGuess = "", wordGuess = ""; // Stores user input
		
		int numGuesses = 0; // Counts total guesses
		
		Scanner input = new Scanner(System.in); // Input object
		
		// Array to track how many times each letter is guessed
		int[] letterCounts = new int[HIGH - LOW + 1];
		
		char[] wordLetters; // Converts guess string into characters
		int countletters = 0; // Used to track index of guessed letter
		
		System.out.println("WordGuess game.\n");

		// ---------------- INITIAL DISPLAY ----------------
		
		// Replace each letter in the word with "-"
		for (int i = 0; i < SECRET_WORD.length(); i++){
			wordSoFar += "-";
		}
		
		// Show hidden word
		System.out.println(wordSoFar + "\n");
		
		// ---------------- MAIN GAME LOOP ----------------
		
		do {
			// Ask player for input
			System.out.println("Enter a letter (" + FLAG + " to guess entire word): ");
			
			// Convert input to uppercase
			letterGuess = input.nextLine().toUpperCase();
			
			// Convert input into character array
			wordLetters = letterGuess.toCharArray();

			// -------- INVALID INPUT (MORE THAN 1 LETTER) --------
			if (letterGuess.length() > 1) {
				System.out.println("Only 1 letter can be entered.\n");
				
				// Process each entered character (though not really needed here)
				for (int letter = 0; letter < wordLetters.length; letter++) {
					countletters = wordLetters[letter] - LOW;
					
					// Attempt to track guessed letters
					if (letterCounts[countletters] == 1) {
						letterCounts[countletters] = 1;
					} else {
						letterCounts[countletters] = 0;
					}
				}
				continue; // Skip rest of loop
			}
			
			// -------- VALID SINGLE LETTER GUESS --------
			else if (!letterGuess.equals(FLAG) && letterGuess.length() == 1) {
				
				// Update guess count for this letter
				for (int letter = 0; letter < wordLetters.length; letter++) {
					countletters = wordLetters[letter] - LOW;
					letterCounts[countletters] += 1;
				}
			}

			// Increase total guesses
			numGuesses += 1;

			// -------- CORRECT LETTER GUESS --------
			if (SECRET_WORD.indexOf(letterGuess) >= 0 && letterCounts[countletters] <= 1) {
				
				updatedWord = ""; // Reset updated word
				
				// Loop through each letter in secret word
				for (int i = 0; i < SECRET_WORD.length(); i++) {
					
				    // If guessed letter matches position in word
				    if (SECRET_WORD.charAt(i) == letterGuess.charAt(0)) {
				        updatedWord += letterGuess; // Reveal letter
				    } 
				    else {
				        updatedWord += wordSoFar.charAt(i); // Keep previous state
				    }
				}

				// Update displayed word
				wordSoFar = updatedWord;
			}
			
			// -------- PLAYER CHOOSES TO GUESS WHOLE WORD --------
			else if (letterGuess.equals(FLAG)) {
				System.out.println(" ");
			}
			
			// -------- LETTER ALREADY GUESSED --------
			else if (letterCounts[countletters] > 1){
				System.out.println("You already guessed this letter.\n");
				
				// Fix over-counting
				letterCounts[countletters] -= 1;
			}
			
			// Show current progress
			System.out.println(wordSoFar + "\n");
		
		} 
		// Continue until player guesses word or enters FLAG
		while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD));
		
		// ---------------- FULL WORD GUESS ----------------
		
		if (letterGuess.equals(FLAG)) {
			System.out.println("What is your guess? ");
			wordGuess = input.nextLine().toUpperCase();
		}

		// ---------------- FINAL RESULT ----------------
		
		if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
			System.out.println("You Won!");
		} else {
			System.out.println("Sorry. You lose.");
		}
		
		// Show correct answer and stats
		System.out.println("The secret word is " + SECRET_WORD);
		System.out.println("You made " + numGuesses + " guesses");
	}
}
/*
WordGuess game.

-----

Enter a letter (! to guess entire word): 
f
-----

Enter a letter (! to guess entire word): 
g
-----

Enter a letter (! to guess entire word): 
h
H----

Enter a letter (! to guess entire word): 
j
H----

Enter a letter (! to guess entire word): 
a
HA---

Enter a letter (! to guess entire word): 
p
HAPP-

Enter a letter (! to guess entire word): 
y
HAPPY

You Won!
The secret word is HAPPY
You made 7 guesses
______________________________________________________________

WordGuess game.

-----

Enter a letter (! to guess entire word): 
g
-----

Enter a letter (! to guess entire word): 
h
-----

Enter a letter (! to guess entire word): 
j
-----

Enter a letter (! to guess entire word): 
k
-----

Enter a letter (! to guess entire word): 
l
-----

Enter a letter (! to guess entire word): 
i
-----

Enter a letter (! to guess entire word): 
o
--O--

Enter a letter (! to guess entire word): 
y
--O--

Enter a letter (! to guess entire word): 
t
--O--

Enter a letter (! to guess entire word): 
r
-RO--

Enter a letter (! to guess entire word): 
e
-RO--

Enter a letter (! to guess entire word): 
a
-RO--

Enter a letter (! to guess entire word): 
w
-ROW-

Enter a letter (! to guess entire word): 
c
CROW-

Enter a letter (! to guess entire word): 
!
 
CROW-

What is your guess? 
crown
You Won!
The secret word is CROWN
You made 15 guesses

*/