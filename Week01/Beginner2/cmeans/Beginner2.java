import java.util.Scanner;
public class Beginer2 {
	public static void main(String[] args){
		String original, reverse="";
		Scanner myScan= new Scanner(System.in);
		System.out.println("Enter a word you would like to check.");
		original= myScan.next();
		int length= original.length();
		for(int i = length -1; i >= 0 ; i-- ){
			reverse= reverse + original.charAt(i);
			if(original.equals(reverse))
				System.out.println("It is a palindrome.");
			else
				System.out.println("It is not a palindrome.");
}
	}
}
