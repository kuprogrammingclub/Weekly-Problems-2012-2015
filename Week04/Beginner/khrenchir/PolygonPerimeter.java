import java.util.Scanner;
import java.lang.Math;
public class PolygonPerimeter {
	public static void main (String args []){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		float r = input.nextFloat();
			while (n < 3 || n > 100){
				System.out.println("The number of sides must be between 3 and 100. Try again.");
				n = input.nextInt();
			}
			while (r < .01 || r > 100){
				System.out.println("The circumradius must be between .01 and 100. Try again.");
				r = input.nextFloat();
			}
		
		//formula for perimeter of a polygon
		double perimeter = (2*n*r*Math.sin(Math.PI/n));
		
		System.out.printf("%.3f", perimeter);		
	}
}