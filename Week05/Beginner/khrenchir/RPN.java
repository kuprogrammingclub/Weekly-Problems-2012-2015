import java.util.Scanner;
import java.lang.Math;

public class RPN {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		String equation = input.nextLine();		
		
		String[] equationArray = equation.split("\\s+");
		
		double last = Double.parseDouble(equationArray[0]);
		

		for ( int i = 0; i < equationArray.length; i++){
			if((int)equationArray[i].charAt(0) == 43 || (int)equationArray[i].charAt(0) == 45 ||
					(int)equationArray[i].charAt(0) == 42 || (int)equationArray[i].charAt(0) == 47 ||
						(int)equationArray[i].charAt(0) == 37 || (int)equationArray[i].charAt(0) == 94){
				
				if((int)equationArray[i].charAt(0) == 43){				
					last = last + Double.parseDouble(equationArray[i-1]);
				}
				if((int)equationArray[i].charAt(0) == 45){				
					last = last - Double.parseDouble(equationArray[i-1]);
				}
				if((int)equationArray[i].charAt(0) == 42){				
					last = last * Double.parseDouble(equationArray[i-1]);
				}
				if((int)equationArray[i].charAt(0) == 47){				
					last = last / Double.parseDouble(equationArray[i-1]);
				}
				if((int)equationArray[i].charAt(0) == 37){				
					last = last % Double.parseDouble(equationArray[i-1]);
				}
				if((int)equationArray[i].charAt(0) == 94){				
					last = Math.pow(last,  Double.parseDouble(equationArray[i-1]));
				}
							
			}
		}
		System.out.println(last);
		
	}

}
