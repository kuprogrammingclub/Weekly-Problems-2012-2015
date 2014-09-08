/**
 * File Name: PowerDigitSum.java
 * Author: Stefan Mendoza
 * Contact: stefanmendoza.dev@gmail.com
 * Problem Source: Project Euler
 * Date Modified: 8 September 2014
 * --- KU Competitive Programming: Week 01 (Advanced) ---
 *
 * For a given base and an exponent, the program outputs the sum of the product's digits.
 *
 */

import java.util.Scanner;

public class PowerDigitSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter the base integer: ");
		int base = input.nextInt();
		System.out.print("Please enter the exponent: ");
		int exponent = input.nextInt();

		int result = powerFunction(base, exponent);
		String tempStr = Integer.toString(result);
		String[] digits_str = tempStr.split("");
		int sumOfDigits = 0;
		
		for(int i = 1; i < digits_str.length; i++) {
			sumOfDigits = sumOfDigits + Integer.parseInt(digits_str[i]);
		}		
		
		System.out.println("The result of the power function is: " + result);
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