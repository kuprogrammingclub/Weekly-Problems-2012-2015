// Author: Adam Petz
// Date: 4 September 2015
// KU Programming Club, Week 01, Beginner Problem #1

package week_1;

import java.util.Scanner;

public class Beginner1 {

	public static void main(String args[])
	{	
		String queryForInput = "What's your name?";
		String responseInit = "Looking good, ";
		Scanner sIn = new Scanner (System.in);
	
		System.out.println(queryForInput);
		String inputName = sIn.nextLine();
		System.out.println(responseInit + inputName + "!");
		sIn.close();
	}
}
