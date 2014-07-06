import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class primebases {

	final static String FILE_NAME = "primebases.in";
	final static int maxVal = 65535;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static HashMap<Integer, Long> pSums = new HashMap<Integer, Long>();
	static HashMap<Integer, String> pStrs = new HashMap<Integer, String>();

	static void sieve() {
		boolean[] vals = new boolean[maxVal];
		Arrays.fill(vals, true);
		vals[0] = false;
		vals[1] = false;
		for (int i = 2; i <= maxVal/2; i++) {
			for (int j = i+i; j < maxVal; j += i) {
				vals[j] = false;
			}
		}
		for (int i = 2; i < vals.length; i++){
			if (vals[i]) {
				primes.add(i);
			}
		}
	}

	static int getPrime(int i) {
		return primes.get(i);
	}

	static long pProd(int i) {
		if (i == 0)
			return 1;
		if (pSums.containsKey(i)) {
			return pSums.get(i);
		}
		else {
			long ret = 1;
			String str = "";
			for (int k = 0; k < i; k++) {
				ret = ret * getPrime(k);
				if (k < i)
					str += "*";
				str += String.valueOf(getPrime(k));
			}
			pSums.put(i, ret);
			pStrs.put(i, str);
			return ret;
		}
		
	}
	
	static int maxI(long n) {
		int i = 0;
		while (pProd(i) < n) {
			i++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		File fIn = new File(FILE_NAME);
		Scanner stdIn = null;
		try {
			stdIn = new Scanner(fIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long n = stdIn.nextLong();
		sieve();
		while (n != 0) {
			System.out.print(n);
			System.out.print(" = ");
			long[]ret = new long[maxI(n)];
			if (pProd(maxI(n)) == n) {
				System.out.print("1");
				System.out.println(pStrs.get(maxI(n)));
			}
			else {
				for (int i = ret.length - 1; i >= 0; i--) {
					long pHold = pProd(i);
					long hold = (n/pHold);
					ret[i] = hold;
					n = (n % pProd(i));
				}
				for (int i = 0; i < ret.length; i++) {
					if (ret[i] != 0) {
						System.out.print(ret[i]);
						if (pStrs.containsKey(i)) {
							System.out.print(pStrs.get(i));
						}
						else
							System.out.print("");
						
						if (i < ret.length - 1) {
							System.out.print(" + ");
						}
					}
				}
				System.out.println();
			}
			
			n = stdIn.nextLong();
		}
		//System.out.println(primes);
		//while (stdIn.hasNext()) {
		//	String str = stdIn.next();
		//}
	}

}
