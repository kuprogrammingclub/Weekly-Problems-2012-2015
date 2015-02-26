import java.util.Scanner;
import java.util.HashSet;

public class DuplicateRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner user_input = new Scanner(System.in);
		HashSet<Character> letters = new HashSet<Character>();
		String s;
		s = user_input.nextLine();
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (!letters.contains(s.charAt(i))) {
				result += s.charAt(i);
				letters.add(s.charAt(i));
			}
		}
		System.out.println(result);
	}

}
