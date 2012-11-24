package com.xnux;

public class NumberCharCombos {
	
	/** This ASCII value represents ` when converted to a char, so adding a positive
	 * value to it will yield a lowercase character (e.g., adding 1 yields a, adding
	 * 2 yields b, etc.
	 * */
	public static final int ASCII_OFFSET = 96;
	
	/** Converts a string with the value of a number to its corresponding ASCII letter.
	 * @param numStr A string whose contents are a number less than 27 (e.g., "12").
	 * @return A letter such that "1" is converted to 'a', "2" is converted to 'b', etc.
	 */
	private static char asciify(String numStr) {
		int numStrVal = Integer.parseInt(numStr);
		return (char) (numStrVal + ASCII_OFFSET);
	}

	/** Goes through a string of numbers and outputs each possible alphabetical
	 * representation of the numbers.
	 * @param decoded The portion of the string that is letters (i.e., has been decoded).
	 * @param tail The portion of the string that is numbers (i.e., needs to be decoded).
	 */
	public static void decode(String decoded, String tail) {
		if(tail.equals("")) { //The string is already decoded
			System.out.println(decoded);
		} else if(tail.length() == 1) { //Simply asciify the tail, output the results, and we are done
			System.out.println(decoded + asciify(tail));
		} else {
			char tailChar1 = asciify(tail.substring(0, 1)); //At the very least, asciify the first character of tail and concatenate it to decoded
			decode(decoded + String.valueOf(tailChar1), tail.substring(1)); //Decode the remaining part of tail
			char tailChar2 = asciify(tail.substring(0, 2));
			if(tailChar2 <= 'z') { //If the first two characters of tail also represent a letter...
				decode(decoded + String.valueOf(tailChar2), tail.substring(2)); //...concatenate it to decoded and decode the remaining part of tail.
			}
		}
	}
	
	public static void main(String[] args) {
		decode("", args[0]);
	}
}
