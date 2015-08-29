// Author: Stefan Mendoza
// Date: 29 August 2015
// KU Competitive Programming, Week 01, Beginner Problem #1

import java.util.Scanner;

public class Beginner1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("What's your name?\n> ");

        String name = input.nextLine();

        System.out.println("Hello, " + name + "!");
    }
}
