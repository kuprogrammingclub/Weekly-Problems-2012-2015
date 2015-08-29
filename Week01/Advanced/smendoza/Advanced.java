// Author: Stefan Mendoza
// Date: 29 August 2015
// KU Competitive Programming, Week 01, Advanced Problem

import java.math.BigInteger;
import java.util.Scanner;

public class Advanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BigInteger base = BigInteger.valueOf(2);

        int exponent = 0;

        if(args.length == 0) {
            System.out.print("Enter an exponent (the base will be 2): ");
            exponent = input.nextInt();
        }
        else {
            exponent = Integer.parseInt(args[0]);
        }

        String result = base.pow(exponent).toString();
        int sum = 0;

        for(int i = 0; i < result.length(); i++) {
            sum += Character.getNumericValue(result.charAt(i));
        }

        System.out.println("The sum of the digits for 2 ^ " + exponent + " is " + sum);
    }
}
