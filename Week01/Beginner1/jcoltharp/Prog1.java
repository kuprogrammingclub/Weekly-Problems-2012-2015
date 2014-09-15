import java.util.Scanner;
public class Prog1 
{
	public static void main(String[] args)
	{
		Scanner myScan = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = myScan.nextLine();
		System.out.println("Hello, " + name + "!");
	}
}
