import java.util.Scanner;
public class SimpleCalculator {
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input your equations in the form y = m x +b \rNote that I need a space between m and x and no \r" +
				"space between the b and its sign. Sorry!!");
		
		System.out.println("Equation 1:");
		String eq1 = input.nextLine();
		
		System.out.println("Equation 2:");
		String eq2 = input.nextLine();
		
		String[] eq1Array = eq1.split("\\s+");
		String[] eq2Array = eq2.split("\\s+");
		
		double x = ( Double.parseDouble(eq1Array[4]) - Double.parseDouble(eq2Array[4]) ) / 
					(Double.parseDouble(eq2Array[2]) - Double.parseDouble(eq1Array[2]));
		
		double y = Double.parseDouble(eq1Array[2]) * x + Double.parseDouble(eq1Array[4]);
		
		System.out.println("(" + x+ ", " + y + ")");
		
	}

}
