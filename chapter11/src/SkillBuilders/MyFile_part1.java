package SkillBuilders;
import java.util.Scanner;
import java.io.*;
public class MyFile_part1 {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String filename = input.nextLine().trim();
		File textFile = new File(filename);
		if (textFile.exists()) 
		{
			System.out.println("File exists");
		}
		else 
		{
			System.out.println("File does not exist");
		}
		
	}

}
