package week7Git;

public class NoLoops {

	private static void recursivePrint (int val) {
		val += 0/(val - 1001);
		System.out.println(val);
		recursivePrint(++val);
	}
	
	public static void main (String[] args) {
		try {
			recursivePrint(1);
		}
		catch (Exception e) {
			System.exit(0);
		}
	}
}
