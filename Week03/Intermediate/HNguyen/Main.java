import java.util.Scanner;
import java.util.LinkedList;
class Main {
	public static LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> c = new LinkedList<Integer>();
		int remainer = 0;
		while (!a.isEmpty() || !b.isEmpty()) {
			int d;
			if (a.isEmpty()) {
				d = b.remove()+remainer;
			} else if(b.isEmpty()) {
				d = a.remove()+remainer;
			} else {
				d = a.remove()+b.remove()+remainer;
			}
			if (d > 9) {
				c.add(d%10);
				remainer = 1;
			} else {
				c.add(d);
				remainer = 0;
			}
		}
		if (remainer == 1) {
			c.add(1);
		}
		return c;
	}
	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			a.add(s.charAt(i)-48);
		}
		s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			b.add(s.charAt(i)-48);
		}
		System.out.println(sum(a, b));
	}	
}