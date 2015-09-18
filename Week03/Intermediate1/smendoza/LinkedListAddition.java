/**
 *  LinkedListAddition.java
 *
 *  Author: Stefan Mendoza
 *  Date: 18 September 2015
 *
 *  Week 3, Intermediate 1
 */


import java.lang.Math;
import java.util.LinkedList;

public class LinkedListAddition {
    public static LinkedList<Integer> addLists(LinkedList<Integer> a, LinkedList<Integer> b) {
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

        int sum = a_sum + b_sum;
        String sum_length = Integer.toString(sum);

        LinkedList<Integer> result = new LinkedList<Integer>();

        for(int i = 0; i < sum_length.length(); i++) {
            int amount = sum;

            for(int j = sum_length.length(); j > i; j--) {
                amount -= (amount / (int)Math.pow(10, j)) * (int)Math.pow(10, j);
            }

            int digit = amount / (int)Math.pow(10, i);

            sum -= amount;
            result.add(digit);
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        a.add(7);
        a.add(1);
        a.add(6);

        b.add(5);
        b.add(9);
        b.add(2);

        LinkedList<Integer> sum = addLists(a, b);

        System.out.print("Sum: " + sum.pop());
        while(sum.size() > 0) {
            System.out.print(" -> " + sum.pop());
        }
        System.out.println();
    }
}
