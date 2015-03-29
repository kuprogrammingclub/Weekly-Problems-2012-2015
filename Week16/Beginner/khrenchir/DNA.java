import java.util.Scanner;

public class DNA {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		String orig = input.nextLine();		
		String[] origArray = orig.split("\\s+");
		
		String[] matchArray = new String[origArray.length];
		
		for(int i = 0; i < origArray.length; i++){
			if(origArray[i].charAt(0) == 'A'){
				matchArray[i] = "T";
			} else if (origArray[i].charAt(0) == 'T'){
				matchArray[i] = "A";
			} else if(origArray[i].charAt(0) == 'C'){
				matchArray[i] = "G";
			} else if (origArray[i].charAt(0) == 'G'){
				matchArray[i] = "C";
			} 
		}
		
		for(int i = 0; i<origArray.length; i++){
			System.out.print(origArray[i] + " ");
		}
		
		System.out.print("\n");
		
		for(int i = 0; i<matchArray.length; i++){
			System.out.print(matchArray[i] + " ");
		}
		
	}
	
	

}
