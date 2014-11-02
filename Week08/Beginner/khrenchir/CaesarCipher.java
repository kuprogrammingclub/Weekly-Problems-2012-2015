import java.util.Scanner;

public class CaesarCipher {
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		
		String original;
		System.out.println("original message: ");
		original = input.nextLine();
		
		char[] originalArray = original.toCharArray();
		
		System.out.println("encoded message:");
		
		for(int i = 0; i < originalArray.length; i++){
			// ascii values for A-M and a-m print out their acsii value + 13
			// ascii values for N_Z and n-z print out their ascii vlue - 13
			if ( ((int)originalArray[i] >= 65 && (int)originalArray[i] <= 77) ||
					( (int)originalArray[i] >= 97 && (int)originalArray[i] <= 109 )){
				System.out.print( (char) ((originalArray[i] + 13)));
			} else if(((int)originalArray[i] >= 78 && (int)originalArray[i] <= 90) ||
					( (int)originalArray[i] >= 110 && (int)originalArray[i] <= 122 )){
				System.out.print( (char) ((originalArray[i] - 13)));			
				
			} else if ((int)originalArray[i] == 32){
				System.out.print(" ");
			}
		}
	}

}
