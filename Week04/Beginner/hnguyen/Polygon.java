import java.util.Scanner;
public class Polygon {
	public static void main(String[] args) {
		int N;
		double R;
		double O;
		Scanner user_input = new Scanner(System.in);
		N = user_input.nextInt();
		R = user_input.nextDouble();
		O = 2*Math.PI/N;
		System.out.println(N*Math.sqrt(2*R*R*(1-Math.cos(O))));
	}
}
		
	
		