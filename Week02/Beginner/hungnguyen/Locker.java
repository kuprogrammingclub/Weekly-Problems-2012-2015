import java.util.Scanner;

public class Locker {

	public static void main(String[] args) {
		int N;
		int a, b, c;
		Scanner user_input = new Scanner(System.in);
		N = user_input.nextInt();
		a = user_input.nextInt();
		b = user_input.nextInt();
		c = user_input.nextInt();
		user_input.close();
		int sum = 3*N;
		sum += a;
		if (b > a) {
			sum += N-(b-a);
		} else {
			sum += a-b;
		}
		if (c > b) {
			sum += c-b;
		} else {
			sum += N-(b-c);
		}
		System.out.println(sum);
	}
}