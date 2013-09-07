import java.util.Arrays;

/** Finds the first integer x such that x, 2x, 3x, 4x, 5x, and 6x are all permuted multiples. */
public class PermutedMultiples {

	/** Checks if two strings are composed of the same characters (but perhaps not in the same order). */
	private static boolean arePermutes(String word1, String word2) {
		if(word1.equals(word2)) { //Avoid unnecessary work if the strings are equal...
			return true;
		}
		if(word1.length() == word2.length()) { //...or if they have different lengths.
			
			/* I originally used this commented section, but then I realized that there was
			 * a flaw with it. Try to see what is wrong with it.
			
			for(int i = 0; i < word2.length(); i++) {
				if(!word2.contains(String.valueOf(word1.charAt(i))))
					return false;
			}
			return true;
			
			*/

			char[] wArr1 = word1.toCharArray();
			char[] wArr2 = word2.toCharArray();
			Arrays.sort(wArr1);
			Arrays.sort(wArr2);
			for(int i = 0; i < word1.length(); i++) {
				if(wArr1[i] != wArr2[i]) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		mainloop:
			for(long x = 1; true; x++) {
				String xWord = String.valueOf(x); //We need strings, since I'm too lazy to manipulate integers
				for(int multiplier = 2; multiplier <= 6; multiplier++) { //Obviously, 1*x and x are permutes, so skip 1
					if(!arePermutes(xWord, String.valueOf(multiplier*x)))
						continue mainloop;
				}
				System.out.println(xWord);
				System.out.println("Calculation took ~" +
						(System.currentTimeMillis()-startTime) +
						" milliseconds."); //For curiosity's sake
				break mainloop;
			}
	}
}
