import java.util.Scanner;
public class WordsEnemy {

	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		String word1 = user_input.next();
		String word2 = user_input.next();
		int index1 = 0;
		int index2;
		boolean check;
		while (index1 != word1.length()) {
			index2 = 0;
			check = true;
			while (index2 != word2.length()) {
				if (word1.charAt(index1) == word2.charAt(index2)) {
					word1 = word1.substring(0, index1) + word1.substring(index1 + 1);
					word2 = word2.substring(0, index2) + word2.substring(index2 + 1);
					check = false;
					break;
				} else {
					index2++;
				}
			}
			if (check) {
				index1++;
			}
		}
		if (word1.length() > word2.length()) {
			System.out.println(word1 +  " > " + word2);
			System.out.println("Left wins");
		} else if (word2.length() > word1.length()) {
			System.out.println(word1 +  " < " + word2);
			System.out.println("Right wins");
		} else {
			System.out.println(word1 +  " = " + word2);
			System.out.println("Tie!");
		}
	}

}
