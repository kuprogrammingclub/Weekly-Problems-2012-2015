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
		if (a < N/2) {
			sum += a;
		} else {
			sum += N-a;
		}
		if (Math.abs(b-a) < N/2) {
			sum += Math.abs(b-a);
		} else {
			sum += N-Math.abs(b-a);
		}
		if (c-b < 0) {
			sum += b-c;
		} else {
			sum += N-(c-b);
		}
		System.out.println(sum);
	}
}
		
	
		

	
