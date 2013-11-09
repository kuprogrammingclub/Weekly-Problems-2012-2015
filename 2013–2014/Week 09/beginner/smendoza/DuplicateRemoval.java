/*
 * File Name: DuplicateRemoval.java
 * Author: Stefan Mendoza
 * Created: 11/8/13
 * Last Modified: 11/8/13
 * Description: Given a string, removes consecutive duplicate letters and puts them in a separate string.
 * 				Prints out both the string with the letters removed and a string made of the removed letters.
 */

import java.util.Scanner;

public class DuplicateRemoval {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String original;
		String modified = ""; //makes the modified string an empty string
		String duplicates = ""; //makes the duplicates string an empty string
		
		System.out.print("Please input a String with duplicate letters: ");
		original = input.nextLine(); //makes the original string whatever the user inputs
		original = original.trim(); // deletes any leading/trailing whitespace to avoid indexing issues
		original += ' '; // adds a space at the end of the original string to avoid out of bounds exceptions
		char[] originalArray = original.toCharArray(); //creates a character array from the original string

		
		
		for(int i = 0; i < original.length() - 1; i++) { //beginning from index 0, will increment until the last character of the input
				
				if(originalArray[i] == originalArray[i+1] || originalArray[i] == ' ') { //checks to see if two consecutive characters are duplicates
					duplicates += original.charAt(i); //adds any consecutive duplicate characters to the duplicates string
				}
				
				if(originalArray[i] != originalArray[i+1]) { //beginning from index 0, will increment until the last character of the input
					modified += original.charAt(i); //adds all characters whose next consecutive letters aren't duplicates
				}
		}
				
		System.out.println("The modified string is: " + modified);
		System.out.println("The duplicate letters removed were: " + duplicates);
		
		
		input.close();
	}

}