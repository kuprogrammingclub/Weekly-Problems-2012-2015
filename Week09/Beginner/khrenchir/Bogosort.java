import java.util.Scanner;
import java.util.Random;

public class Bogosort {
	
	public static int n;
	public static Random rand = new Random();
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		;
		
		System.out.println("how many items do you want in this (int) array?");
		n = input.nextInt();
		
		int [] list  = new int [n];
		System.out.println("\rpopulate your array: ");
		for(int i = 0; i <  list.length; i++){
			System.out.print("item " + (i+1) + ": ");
			list[i] = input.nextInt();
		}
		 
		int [] list2 = new int[n];
		for(int i = 0; i < n; i ++){
			list2[i] = list[i];
		}
		
		System.out.println("\rhere's your original list: ");
		for(int i = 0; i < list.length; i++){
			if(i == list.length-1){
				System.out.print(list[i] + "]");
			} else if (i == 0){
				System.out.print("[" + list[i] + ", ");
			} else {
				System.out.print(list[i] + ", ");
			}
		}
		
		System.out.println("\r");
		
		long startTime = System.nanoTime();
		
		for(int i = 0; i < list.length; i++){
				list[i] = list2[random()];
			
				for(int j = 0; j < i; j++){
					while (list[j] == list[i]){
						list[i] = list2[random()];
					}
				}
		}
		
		System.out.println("\rhere's your \'sorted\' list: ");
		for(int i = 0; i < list.length; i++){
			if(i == list.length-1){
				System.out.print(list[i] + "]");
			} else if (i == 0){
				System.out.print("[" + list[i] + ", ");
			} else {
				System.out.print(list[i] + ", ");
			}
		}
		
		long endTime = System.nanoTime();
		System.out.println("\r\rit took "+ (endTime - startTime) + " nanoseconds to rearrange the list"); 
		
	}
	
	public static int random(){
		return(rand.nextInt(n));
	}
	
}

