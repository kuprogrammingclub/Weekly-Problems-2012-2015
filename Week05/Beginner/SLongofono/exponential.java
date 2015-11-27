/*
	SLongofono	Week 05 Fall 2015	Beginner - Functional Languages

	Write a program to calculate the first ten terms of the series expansion of e^x.
	Accept as input an integer number of values, followed by the float values to be 
	calculated.  Try to accomplish this without a mutable state or a direct
	declaration of local variables.

	I don't know enough Lisp to make this work but below is a Java interpretation
	of what I was trying to do.  I had the defines worked out but IO was Greek to me.

*/

public class exponential{

	public static void main(String[] args){
		for (int i = 1; i< args.length; i++){
			System.out.printf("%.4f\n", powerSum(Double.parseDouble(args[i]), 9));
		}
	}

	public static int fact(int x){
		return (x<2)? x : x*fact(x-1);
	}

	public static double powerSum(double x, int terms){
		return (1==terms) ? (x + 1) : (Math.pow(x, terms)/fact(terms)) + powerSum(x, terms-1);
	}
}
