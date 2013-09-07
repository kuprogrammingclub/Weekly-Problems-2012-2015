import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class beautiful {

	final static String FILE_NAME = "beautiful.in";
	static HashSet<Character> charSet = new HashSet<Character>();

	//	static String removeDupes(String str) {
	//		ArrayList<Character> chars = new ArrayList<Character>();
	//		for (int i =0; i < str.length(); i++) {
	//			char c = str.charAt(i);
	//			if (!chars.contains(c)) {
	//				chars.add(c);
	//			}
	//		}
	//		String ret = "";
	//		for (Character cH : chars) {
	//			ret += cH.toString();
	//		}
	//		return ret;
	//	}

	public static void main(String[] args) {
		File fIn = new File(FILE_NAME);
		Scanner stdIn = null;
		try {
			stdIn = new Scanner(fIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numLines = stdIn.nextInt();

		for (int i = 0; i < numLines; i++) {
			String str = stdIn.next();
			String purdyStr = "";
			for (char letter : str.toCharArray()){
				if (charSet.contains(letter)) {
					String test = purdyStr.replace(String.valueOf(letter), "") + letter;
					if (test.compareTo(purdyStr) > 0) {
						purdyStr = test;
					}
				} else {
					charSet.add(letter);
					purdyStr += letter;
				}
			}
			System.out.println(purdyStr);
		}
	}

}
