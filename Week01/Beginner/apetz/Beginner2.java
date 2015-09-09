// Author: Adam Petz
// Date: 4 September 2015
// KU Programming Club, Week 01, Beginner Problem #2

// Tests:

// A man, a plan, a canal, Panama
// Amor, Roma
// race car
// taco cat
// Was it a car or a cat I saw
// No 'x' in Nixon
// 12321

package week_1;

import java.util.Scanner;

public class Beginner2 {
	public static void main(String[] args) {
		String query = "> ";
		String exitMessage = "Thanks for palindroming!";
		String endString = "end";
		
		System.out.print(query);
		String input = readClean();
		while (! input.equalsIgnoreCase(endString))
		{
			Boolean b = isPal(input);
			if (b) System.out.println("Palindrome");
			else System.out.println("Not a palindrome");
			System.out.print(query);
			input = readClean();
		}
		System.out.println(exitMessage);	
	} // end main
	
	public static String readClean(){
		Scanner sIn = new Scanner(System.in);

		String input = sIn.nextLine(); 
		String regex = "[^a-zA-Z1-9]";
		String result = input.replaceAll(regex, "");
		
		return result;	
	} // end readClean
	
	public static String reverse(String inString){
		String reversed = "";
		int len = inString.length();
		
		for(int i = len - 1; i >= 0; i--){
			reversed += inString.charAt(i);
		}
		
		return reversed;	
	} // end reverse
	
	public static boolean isPal(String inString) {
		String reversed = reverse(inString);
		return (inString.equalsIgnoreCase(reversed));
	} // end isPal
	
}


