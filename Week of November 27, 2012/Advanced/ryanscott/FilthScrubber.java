package com.xnux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//A quick-and-dirty (hehe, dirty) word-censorer.
public class FilthScrubber {
	
	//A list where our list of words to be censored will be stored.
	private static ArrayList<String> naughtyWords = new ArrayList<String>();
	//The file containing all of the words to be censored.
	private static final String PATH_TO_FILTH = System.getProperty("user.dir") + "/src/com/xnux/wordlist.csv";
	//The file containing some words, some of which may need to be censored
	private static final String PATH_TO_TEXT_FILE = System.getProperty("user.dir") + "/src/com/xnux/carlin.txt";

	//Takes a file (at the given path) and stores each of its strings in an ArrayList.
	//This will only work if the file is formatted like so:
	/*
		"string a"
		"string b"
		...
	 */
	//Note that words listed first in the file will be censored first.
	private static ArrayList<String> unleashTheProfanity(String path) {
		Scanner s = null;
		try {
			s = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNextLine()){
		    list.add(s.nextLine().replace("\"", "")); //Remove quotation marks to make things easier
		}
		s.close();
		return list;
	}
	
	//Takes a file (at the given path) and puts its contents into a String.
	private static final String openTextFile(String path) {
		Scanner s = null;
		try {
			s = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String text = "";
		while (s.hasNextLine()){
		    text += s.nextLine() + "\n"; //Don't forget the newline!
		}
		s.close();
		return text;
	}
	
	//Since Eclipse's output isn't word-wrapped, this method will print out the given String
	//with a number of characters per line roughly equal to charsInLine.
	private static void printWithWordWrap(String text, int charsInLine) {
		int charCount = 0;
		for(int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			charCount++;
			if(text.charAt(i) == '\n')
				charCount = 0;
			if(charCount == charsInLine) {
				if(text.charAt(i+1) == ' ') {
					System.out.println();
					i++; //Don't bother printing out the following space, since it's a newline
					charCount = 0;
				} else { //If the next character isn't a space, then don't make a newline; we could chop a word in half!
					charCount--; //Delay the newline by decrementing charCount
				}
			}
		}
	}
	
	public static void main(String args[]) {
		naughtyWords = unleashTheProfanity(PATH_TO_FILTH);
		String carlinBit = openTextFile(PATH_TO_TEXT_FILE);
		for(String swear: naughtyWords) { //Take each dirty word...
			String bleep = "*"; //...find how many asterisks we need to replace it...
			for(int i = 1; i < swear.length(); i++) {
				bleep += "*";
			}
			String regexSwear = Pattern.quote(swear); //...make sure the dirty word is formatted for regular expressions...
			regexSwear = "(?i)" + regexSwear; //...account for different capitalizations of the dirty word...
			carlinBit = carlinBit.replaceAll(regexSwear, bleep); //...and replace all instances of the dirty word with asterisks.
		}
		printWithWordWrap(carlinBit, 120);
	}
	
}
