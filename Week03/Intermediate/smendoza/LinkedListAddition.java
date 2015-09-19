/**
 *  LinkedListAddition.java
 *
 *  Author: Stefan Mendoza
 *  Date: 18 September 2015
 *
 *  Week 3, Intermediate 1
 */

import java.lang.Math;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedListAddition {
    public static LinkedList<Integer> addLists(LinkedList<Integer> a, LinkedList<Integer> b) {
        if(a.size() + b.size() > 9) {
            BigInteger a_sum = BigInteger.valueOf(0);
            int a_size = a.size();
            for(int i = 0; i < a_size; i++) {
                a_sum = a_sum.add(BigInteger.valueOf(a.pop()).multiply(BigInteger.valueOf(10).pow(i)));
            }

            BigInteger b_sum = BigInteger.valueOf(0);
            int b_size = b.size();
            for(int i = 0; i < b_size; i++) {
                b_sum = b_sum.add(BigInteger.valueOf(b.pop()).multiply(BigInteger.valueOf(10).pow(i)));

            }

            String sum = a_sum.add(b_sum).toString();

            LinkedList<Integer> result = new LinkedList<Integer>();

            for(int i = sum.length() - 1; i >= 0; i--) {
                result.add(Character.getNumericValue(sum.charAt(i)));
            }

            return result;
        }
        else {
            int a_sum = 0;
            int a_size = a.size();
            for(int i = 0; i < a_size; i++) {
                a_sum += a.pop() * (int)Math.pow(10, i);
            }

            int b_sum = 0;
            int b_size = b.size();
            for(int i = 0; i < b_size; i++) {
                b_sum += b.pop() * (int)Math.pow(10, i);
            }

            String sum = Integer.toString(a_sum + b_sum);

            LinkedList<Integer> result = new LinkedList<Integer>();

            for(int i = sum.length() - 1; i >= 0; i--) {
                result.add(Character.getNumericValue(sum.charAt(i)));
            }

            return result;
        }
    }


    public static Vector<Integer> createVector(int[] digits) {
        Vector<Integer> result = new Vector<Integer>();

        for(int i = 0; i < digits.length; i++) {
            result.add(digits[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        LinkedList<Integer> c = new LinkedList<Integer>();
        LinkedList<Integer> d = new LinkedList<Integer>();

        // Example given
        int[] a_digits = {7, 1, 6};
        int[] b_digits = {5, 9, 2};

        // Large example
        int[] c_digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
        int[] d_digits = {8, 4, 6, 3, 8, 4, 7, 4, 1};

        a.addAll(createVector(a_digits));
        b.addAll(createVector(b_digits));
        c.addAll(createVector(c_digits));
        d.addAll(createVector(d_digits));

        LinkedList<Integer> sum1 = addLists(a, b);

        System.out.print("Small Sum: " + sum1.pop());
        while(sum1.size() > 0) {
            System.out.print(" -> " + sum1.pop());
        }
        System.out.println();

        LinkedList<Integer> sum2 = addLists(c, d);

        System.out.print("Large Sum: " + sum2.pop());
        while(sum2.size() > 0) {
            System.out.print(" -> " + sum2.pop());
        }
        System.out.println();
    }
}
