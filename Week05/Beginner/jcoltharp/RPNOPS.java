
import java.util.Scanner;
public class RPNOPS
{
	public static int q = 0;
	public static double answer = 0;
	public static void main(String[] args)
	{
		Scanner myScan = new Scanner(System.in);
		double x = 0;
		double y = 0;
		String operand = "+";
		System.out.println("Enter an operation in reverse polish notation");
		x = myScan.nextDouble();
		y = myScan.nextDouble();
		operand = myScan.next();
		for(q = q; q <= 256; q = q + 1)
		{
			answer = handler(operand, x, y);
			x = answer;
			y = myScan.nextInt();
			operand = myScan.next();
		}
		System.out.println(answer);
	}
	public static double add(double x, double y)
	{
		return x + y;
	}
	public static double subtract(double x, double y)
	{
		return x - y;
	}
	public static double multiply(double x, double y)
	{
		return x * y;
	}
	public static double divide(double x, double y)
	{
		return x / y;
	}
	public static double power(double x, double y)
	{
		return Math.pow(x, y);
	}
	public static double modulo(double x, double y)
	{
		return x%y;
	}
	public static double handler(String op, double x, double y)
	{
		if(op.equals("+")) answer = add(x, y);
		else if(op.equals("-"))  answer = subtract(x, y);
		else if(op.equals("*"))  answer = multiply(x, y);
		else if(op.equals("/"))  answer = divide(x, y);
		else if(op.equals("^"))  answer = power(x, y);
		else if(op.equals("%")) answer =  modulo(x, y);
		else end(answer);
		System.out.println(answer);
		return answer;
	}
	public static void end(double f)
	{
		q = 257;
		return;
	}
}
