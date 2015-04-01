import java.util.*;
public class Recurrence {
	public static String trim(String s) {
		if (s.contains(" ")) {
			String result = "";
			String[] parts = s.split("\\s+");
			for (int i = 0; i < parts.length-1; i++) {
				result = result + " " + parts[i];
			}
			return result.substring(1, result.length());
		}
		return s;
	}
	public static int number(String s) {
		String[] parts = s.split("\\s+");
		return Integer.parseInt(parts[parts.length-1].substring(1, parts[parts.length-1].length()));
	}
	public static char operator(String s) {
		String[] parts = s.split("\\s+");
		return (parts[parts.length-1].charAt(0));
	}
	public static int calculate(String s, int num) {
		if (s.contains(" ")) {
			switch (operator(s)) {
				case '+':
					return number(s)+calculate(trim(s), num);
				case '-':
					return number(s)-calculate(trim(s), num);
				case '*':
					return number(s)*calculate(trim(s), num);
				case '/':
					return number(s)/calculate(trim(s), num);
			}
		}
		switch (operator(s)) {
			case '+':
				return num+number(s);
			case '-':
				return num-number(s);
			case '*':
				return num*number(s);
			case '/':
				return num/number(s);
		}
		return 0;
	}
	public static int recurrence(String s, int endIndex, int initial) {
		if (endIndex == 0) {
			return initial;
		}
		return calculate(s, recurrence(s, endIndex-1, initial));
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String eqt = input.nextLine();
		int initial = input.nextInt();
		int endIndex = input.nextInt();
		for (int i = 0; i <= endIndex; i++) {
			System.out.
			println("Term " + i + ": " + recurrence(eqt, i, initial));
		}
	}
}
