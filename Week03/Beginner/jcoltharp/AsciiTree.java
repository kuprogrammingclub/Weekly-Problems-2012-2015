
import java.util.Scanner;
public class AsciiTree
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner myScan = new Scanner(System.in);
		int n = 1;
		int nn = 1;
		int spaceM = 0;
		String t = "#";
		String l = "*";
		String runS = "";
		final String space = " ";
		boolean runSB = true;
		boolean run = true;
		do
		{
			System.out.println("Enter a positive, odd enteger greater than or equal to 3.\n"
					+ "Then, enter 2 characters. The first will be for the leaves of the tree\n"
							+ "The second will be for the trunk.\nWARNING: Will not display properly"
							+ " on Windows if the first number > 79");
			n = myScan.nextInt();
			t = myScan.next();
			l = myScan.next();
			if(n >= 3 && (n-1)%2 == 0 && n <= 79 && l.length() == 1 && t.length() == 1)
			{
				nn = n;
				spaceM = (n-1)/2;
				for(int i = 0; i <= (n-1)/2; i = i + 1)
				{
					for(spaceM = (nn-1)/2; spaceM > 0; spaceM = spaceM - 1)
					{
						System.out.print(space);
					}
					for(int k = 0; k <= i*2 ; k = k + 1)
					{
						System.out.print(l);
					}
					nn = nn - 2;
					System.out.println("");
				}
				for(spaceM = (n-3)/2; spaceM >0; spaceM = spaceM - 1)
				{
					System.out.print(space);
				}
				System.out.println(t + t + t);
				do
				{
					System.out.println("------------------------------------------------");
					System.out.print("Would you like to make a new tree? ");
					runS = myScan.next();
					if(runS.toLowerCase().equals("yes"))
					{
						runSB = false;
					}
					else if(runS.toLowerCase().equals("no"))
					{
						runSB = false;
						run = false;
					}
					else
					{
						System.out.println("------------------------------------------------");
						System.out.println("Try again!");
					}
				}
				while(runSB == true);
				System.out.println("------------------------------------------------");
				runSB = true;
			}
			else
			{
				System.out.println("------------------------------------------------");
				if(n < 3 || (n-1)%2 == 1)
				{
					System.out.println("Number must be an odd integer greater than or equal to 3!");
				}
				else if(l.length() > 1 || t.length() > 1)
				{
					System.out.println("Second and third characters must be singular characters!");
				}
				System.out.println("------------------------------------------------");
			}
		}
		while(run == true);
	}
}
