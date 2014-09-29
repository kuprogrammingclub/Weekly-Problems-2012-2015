import java.util.Scanner;
@SuppressWarnings("resource")
public class CircumRadius
{
	public static void main(String[] args)
	{
		boolean run = true;
		String runS = "";
		int sides = 0;
		int j = 0;
		double radius = 0.0;
		double perimeter = 0.0;
		Scanner myScan = new Scanner(System.in);
		while(run == true)
		{
			// This is needed to prevent skipping of loop.
			j = 0;
			System.out.println("Enter the number of sides and the circumradius of the regular polygon.");
			sides = myScan.nextInt();
			radius = myScan.nextDouble();
			if(sides >=3 && sides <= 100 && radius >= .001 && radius <= 100.0)
			{
				perimeter = perimeter(sides, radius);
				System.out.print("The perimeter for the " + sides + "-sided polygon with the "
					+ "circumradius of " + radius + " is ");
				System.out.printf("%1.3f", perimeter);
				while(j <= 256)
				{
					// While loop to see if they want to find another perimeter
					// Used a while loop in case the string input was incorrect.
					System.out.println("\n------------------------------");
					System.out.println("Would you like to find another perimeter?");
					runS = myScan.next().toLowerCase();
					if(runS.equals("yes") || runS.equals("y"))
					{
						run = true;
						j = 257;
					}
					else if(runS.equals("no") || runS.equals("n"))
					{
						run = false;
						j = 257;
					}
					else
					{
						System.out.println("Try again!");
					}
					System.out.println("------------------------------");
					j = j + 1;
				}
			}
			if(sides < 3)
			{
				System.out.println("Sides must not be less than 3!");
			}
			else if(sides >100)
			{
				System.out.println("Sides must not be greater than 100!");
			}
			// Did not use else if for this statement because the radius can be out of
			// bounds as well as the sides.
			if(radius < .001)
			{
				System.out.println("Circumradius must not be less than .001!");
			}
			else if(radius > 100.0)
			{
				System.out.println("Circumradius must not be greater than 100.0!");
			}
			// Used if statement to have different text if they did it wrong.
			if(!(sides >=3 && sides <= 100 && radius >= .001 && radius <= 100.0))
			{
				while(j <= 256)
				{
					//Same while loop as before, but with different text.
					System.out.println("\n------------------------------");
					System.out.println("Would you like to try again?");
					runS = myScan.next().toLowerCase();
					if(runS.equals("yes") || runS.equals("y"))
					{
						run = true;
						j = 257;
					}
					else if(runS.equals("no") || runS.equals("n"))
					{
						run = false;
						j = 257;
					}
					else
					{
						System.out.println("Try again!");
					}
					System.out.println("------------------------------");
					j = j + 1;
				}
			}
		}		
	
	}
	public static double perimeter(int sides, double radius)
	{
		// Where the mathemagic happens
		double perimeter = sides*(radius*2*Math.sin(Math.toRadians(180/sides)));
		return perimeter;
	}
}