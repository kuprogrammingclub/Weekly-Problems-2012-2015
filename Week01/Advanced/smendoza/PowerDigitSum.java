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
		long base = 0;
		long exponent = 0;


		// Prompts for variable input / assignment
		try {		
			System.out.print("\nPlease enter a base integer greater than or equal to 0: ");
			base = input.nextLong();
			System.out.print("Please enter an integer greater than or equal to 0 for the exponent: ");
			exponent = input.nextLong();
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
		long result = powerFunction(base, exponent);
		String tempStr = Long.toString(result);
		String[] digits_str = tempStr.split("");
		long sumOfDigits = 0;

		// Calculation of digit sum
		for(int i = 1; i < digits_str.length; i++) {
			// ===== ERROR ===== //
			// Errors at e = 63 because a minus sign (?) tries to get parsed as a long
			// At e = 64, result becomes 0
			sumOfDigits = sumOfDigits + Long.parseLong(digits_str[i]);
		}		
		
		// Final output
		System.out.println("\nThe result of the power function is: " + result);
		System.out.println("The sum of the digits is: " + sumOfDigits + "\n");
	}

	public static long powerFunction(long base, long exponent) {
		long powerResult = base;

		for(int i = 1; i < exponent; i++) {
			powerResult = powerResult * base;
		}

		return powerResult;
	}
}