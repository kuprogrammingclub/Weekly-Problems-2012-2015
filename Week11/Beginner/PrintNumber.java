
public class PrintNumber {
	public static void main(String [] args) {
		leap1000(1);
		}
		
		public static void leap10(int a) {
			print(a);
			print(a + 1);
			print(a + 2);
			print(a + 3);
			print(a + 4);
			print(a + 5);
			print(a + 6);
			print(a + 7);
			print(a + 8);
			print(a + 9);
		}
		
		public static void leap100(int a) {
			leap10(a);
			leap10(a + 10);
			leap10(a + 20);
			leap10(a + 30);
			leap10(a + 40);
			leap10(a + 50);
			leap10(a + 60);
			leap10(a + 80);
			leap10(a + 90);
		}
		
		public static void leap1000(int a) {
			leap100(a);
			leap100(a + 100);
			leap100(a + 200);
			leap100(a + 300);
			leap100(a + 400);
			leap100(a + 500);
			leap100(a + 600);
			leap100(a + 800);
			leap100(a + 900);		
		}
		public static void print(int a) {
			System.out.println(a);
		}
}
