import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class pD {

	final static String FILE_NAME = "lock.in";
	
	static double process (int n, int t1, int t2, int t3) {
		double ret = (double) 3.0 * n;
		ret += (double) ((Math.pow(n-1, 2) + n - 1)/(2.0*n));
		ret += (double) ((t2 - t1 + n) % n);
		ret += (double) ((t2 - t3 + n) % n);
		ret = ret * 1000;
		int hold = (int) ret;
		ret = hold / 1000.0;
		return ret;
	}
	
	public static void main(String[] args) {
		File fIn = new File(FILE_NAME);
		Scanner stdIn = null;
		try {
			 stdIn = new Scanner(fIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int n = stdIn.nextInt();
		int t1 = stdIn.nextInt();
		int t2 = stdIn.nextInt();
		int t3 = stdIn.nextInt();
		while (true) {
			if (n != 0 || t1 != 0 || t2 != 0 || t3 != 0) {
				System.out.printf("%.3f", process(n, t1, t2, t3));
				System.out.println();
			}
			else
				break;
			n = stdIn.nextInt();
			t1 = stdIn.nextInt();
			t2 = stdIn.nextInt();
			t3 = stdIn.nextInt();
			
		}
	}

}
