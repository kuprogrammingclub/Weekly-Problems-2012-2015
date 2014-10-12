import java.util.Scanner;
import java.util.Arrays;

public class ArraySubtract {

	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input the first list length: ");
		int lengthA = input.nextInt();
		System.out.print("Input the second list length: ");
		int lengthB = input.nextInt();
		int[] listA = new int[lengthA];
		int[] listB = new int[lengthB];
		int burnIndex = 0;
		for(int i = 0; i < lengthA; i++){
			System.out.println("Enter index " + i + " of the first list.");
			listA[i] = input.nextInt();
		}
		for(int i = 0; i < lengthB; i++){
			System.out.println("Enter index " + i + " of the second list.");
			listB[i] = input.nextInt();
		}
		
		for(int i = 0; i < listA.length; i++){
			for(int j = 0; j < listB.length; j++){
				if(listA[i]==listB[j]){
					if(i == 0){
						for(int k = i; k < listA.length; k++){   //if indices are equal, shift each value left, adjusted for first index
							listA[k] = listA[k+1];
						}
					}
					else{ 
						for(int k = i; k < listA.length-1; k++){ //same as above, for indices beyond 0
							listA[k] = listA[k+1];
						}
					}
					burnIndex++;								//skim this number off the size of the original list
				}
			}
		}
		int[] result = new int[listA.length-burnIndex];
		for(int i = 0; i < result.length; i++){
			result[i] = listA[i];
		}
		System.out.println("Difference of your lists: \n" + Arrays.toString(result));
	
	}
}
