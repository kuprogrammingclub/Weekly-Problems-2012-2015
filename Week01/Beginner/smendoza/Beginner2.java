// Author: Stefan Mendoza
// Date: 29 August 2015
// KU Competitive Programming, Week 01, Beginner Problem #2

// Test with:
// Are we not drawn onward, we few, drawn onward to new era?
// Doc Note: I dissent. A fast never prevents a fatness. I diet on cod
// 12521
// RaCeCar


import java.util.Scanner;

public class Beginner2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = input.nextLine();

        String cleanedPhrase = clean(phrase);
        String reversedPhrase = reverse(cleanedPhrase);

        if(cleanedPhrase == "" || reversedPhrase == "")
            System.out.println("There weren't even any letters?!?!");
        else if(cleanedPhrase.equalsIgnoreCase(reversedPhrase))
            System.out.println("\nPalindrome");
        else
            System.out.println("Not a palindrome");
    }

    public static String clean(String s) {
        char[] dictionary = new char[52];

        for(int i = 65; i < 91; i++) {
            dictionary[i - 65] = Character.toChars(i)[0];
        }

        for(int i = 97; i < 123; i++) {
            dictionary[26 + i - 97] = Character.toChars(i)[0];
        }

        String alphabet = new String(dictionary);
        String cleansed = "";

        for(int i = 0; i < s.length(); i++) {
            if(alphabet.contains(String.valueOf(s.charAt(i)))) {
                cleansed += s.charAt(i);
            }
        }

        return cleansed;
    }

    public static String reverse(String original) {
        int len = original.length();
        String reversed = "";

        for(int i = len - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        return reversed;
    }
}
