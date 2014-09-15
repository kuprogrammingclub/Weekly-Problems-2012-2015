import java.util.Scanner;
public class Prog3
{
	public static void main(String[] args)
	{
		// Declaration of variables to be used in the for loops
		int i = 0;
		int j = 0;
		int numOfNums = 0;
		int numb1 = 0;
		int numb2 = 0;
		int numb3 = 0;
		int rotValue = 0;
		int initRot = 0;
		int rot1 = 0;
		int rot2 = 0;
		int rot3 = 0;
		Scanner myScan = new Scanner(System.in);
		for(i = 0; i <= 255; i = i + 1)
		{
			j = 0;
			System.out.println("Input 1 number between 1 and 255.");
			numOfNums = myScan.nextInt();
			System.out.println("Now input three numbers between 0 and " + (numOfNums - 1) + ".");
			numb1 = myScan.nextInt();
			numb2 = myScan.nextInt();
			numb3 = myScan.nextInt();
			if(numOfNums <= 255 && numb1 <= 255 && numb2 <= 255 && numb3 <= 255)
			{
				if(numb1 <= (numOfNums - 1) && numb2 <= (numOfNums - 1) && numb3 <= (numOfNums - 1))
				{
					if(numb1 >= 0 && numb2 >= 0 && numb3 >= 0)
					{
						// <Calculation BS>
						initRot = numOfNums * 2; //Initial rotation increments, two clockwise turns multiplied by the number of digits.
						rot1 = numb1; //Rotation 1 is the first digit, zero, continuing clockwise to the next digit.
						rot2 = numOfNums; //Rotation 2 starts off with a complete counterclockwise turn
						if(numb1 > numb2)
						{
							rot2 = rot2 + numb1 - numb2; //If the first number is greater, all you have to do is continue counterclockwise 
						}
						else if(numb1 < numb2)
						{
							rot2 = rot2 + numb1 + (numOfNums - numb2); /*If the second number is greater, you musc continue back counterclockwise to zero
												and then keep going to the second digit, and the incremental value of that is the number
												of digits minus the actual number.*/
						}
						else if(numb1 == numb2)
						{
							rot2 = rot2; /*If the second number equals the first number, you have already reached the second number by going counterclockwise
										once; you do nothing else.*/
						}
						if(numb3 > numb2)
						{
							rot3 = numb3 - numb2; /*If the third number is bigger, all you need to do is go clockwise to it*/	
						}
						else if(numb3 < numb2)
						{
							rot3 = numOfNums - numb3 + numb2; /*If the second number is bigger, you need to go clockwise to zero
												and then continue clockwise to the actual number.*/
						}
						else if(numb2 == numb3)
						{
							rot3 = numOfNums; /*If the two numbers are equal, you must simply go clockwise back to the same spot, a whole increment.*/
						}
						rotValue = initRot + rot1 + rot2 + rot3;
						System.out.println("The number of increments is: " + rotValue);
						// </Calculation BS>
					}
					else 
					{
						System.out.println("Numbers must be greater than zero");
					}
				}
				else
				{
					System.out.println("Numbers must be less than one minus the number of digits.");
				}
			}
			else
			{
				System.out.println("Numbers must be 255 or less!");
			}
			for(j = 0; j <= 5; j = j + 1)
			{
				System.out.println("----------------------------------------\nAre you done with the program?");
				String yn = myScan.next();
				if(yn.toLowerCase().equals("yes"))
				{
					i = 256;
					j = 6;
				}
				else if(yn.toLowerCase().equals("no"))
				{
					System.out.println("----------------------------------------");
					numOfNums = 0;
					numb1 = 0;
					numb2 = 0;
					numb3 = 0;
					j = 6;
				}
				else
				{
					System.out.println("Try again!");
				}
			}
		}
	}
}
