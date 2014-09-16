import java.util.Scanner;
public class Prog2 
{
	public static void main(String[] args)
	{
		Scanner myScan = new Scanner(System.in);
		String word = myScan.nextLine();
		String rWord = new StringBuilder(word).reverse().toString();
		if(word.toLowerCase().equals(rWord.toLowerCase()))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a palindrome");
		}
		Prog2.main(args);
	}
}