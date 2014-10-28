import java.util.Scanner;
public class SimpleCalculator {
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input your equations in the form y = m x + b \rNote that I need a space between m and x. Sorry!!");
		
		System.out.println("Equation 1:");
		String eq1 = input.nextLine();
		
		System.out.println("Equation 2:");
		String eq2 = input.nextLine();
		
		String[] eq1Array = eq1.split("\\s+");
		String[] eq2Array = eq2.split("\\s+");
		
		if (Double.parseDouble(eq2Array[2]) == Double.parseDouble(eq1Array[2])){
			if (Double.parseDouble(eq2Array[5]) == Double.parseDouble(eq1Array[5]) && 
					eq2Array[4].charAt(0) == eq1Array[4].charAt(0)){
				System.out.println("Same line");
			} else {
				System.out.println("Parallel");
			}
			
		} else {
				
			if ((int)eq2Array[4].charAt(0) == 45){
				eq2Array[5] = Double.toString(0 - Double.parseDouble(eq2Array[5]));
			}
			if ((int)eq1Array[4].charAt(0) == 45){
				eq1Array[5] = Double.toString(0 - Double.parseDouble(eq1Array[5]));
			}
			

			double x = ( Double.parseDouble(eq1Array[5]) - Double.parseDouble(eq2Array[5]) ) /
					(Double.parseDouble(eq2Array[2]) - Double.parseDouble(eq1Array[2]));
			double y = Double.parseDouble(eq1Array[2]) * x + Double.parseDouble(eq1Array[5]);

			System.out.printf("(%.3f, %.3f)\r", x , y);
		}
		
		
		
	}

}
