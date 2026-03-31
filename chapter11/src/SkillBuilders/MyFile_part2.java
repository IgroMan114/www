package SkillBuilders;
import java.util.Scanner;
import java.io.*;
public class MyFile_part2 {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

		File textFile = new File("zzz.txt");
		if (textFile.exists()) 
		{
			System.out.println("File already exists");
		}
		else 
		{
			try 
			{
				textFile.createNewFile();
				System.out.println("New file was created");
			} 
			catch (IOException e) 
			{
				System.out.println("File could not be created.");
				System.out.println("IOException" + e.getMessage());
			}
		}
		System.out.println("Do you want to delete or keep the file?(K/D): ");
		String answer = input.next();
		if (answer.equals("K")) 
		{
			System.out.println("Keeping the file.");
		}
		else if(answer.equals("D")) 
		{
			textFile.delete();
			System.out.println("The file was deleted.");
		}
		else 
		{
			System.out.println("Wrong input");
		}
	}

}