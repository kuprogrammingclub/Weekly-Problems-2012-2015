/**
 * File Name: PowerDigitSum.java
 * Author: Stefan Mendoza
 * Contact: stefanmendoza.dev@gmail.com
 * Problem Source: Project Euler
 * Date Modified: 9 September 2014
 * --- KU Competitive Programming: Week 01 (Advanced) ---
 *
 * For a given base and an exponent, the program outputs the sum of the product's digits.
 *
 */

import java.util.Scanner;

public class PowerDigitSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Variable initalization for try/catch
		int base = 0;
		int exponent = 0;

		// Prompts for variable input / assignment
		try {
			System.out.print("\nPlease enter a base integer greater than or equal to 0: ");
			base = input.nextInt();
			System.out.print("Please enter an integer greater than or equal to 0 for the exponent: ");
			exponent = input.nextInt();
		}
		catch(Exception e) {
			System.out.println("\nIncorrect input type. Exiting.");
			return;
		}

		// Verify that both the base and exponent are nonnegative
		if(base < 0 || exponent < 0) {
			System.out.println("\nNegative integer values are not allowed for the base or exponent. Exiting.");
			return;
		}

		// Power function executed as well as integer parsing
		int result = powerFunction(base, exponent);
		String tempStr = Integer.toString(result);
		String[] digits_str = tempStr.split("");
		int sumOfDigits = 0;

		// Calculation of digit sum
		for(int i = 1; i < digits_str.length; i++) {
			sumOfDigits = sumOfDigits + Integer.parseInt(digits_str[i]);
		}		
		
		// Final output
		System.out.println("\nThe result of the power function is: " + result);
		System.out.println("The sum of the digits is: " + sumOfDigits + "\n");
	}

	public static int powerFunction(int base, int exponent) {
		int powerResult = base;

		for(int i = 1; i < exponent; i++) {
			powerResult = powerResult * base;
		}

		return powerResult;
	}
}