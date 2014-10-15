import java.util.Scanner;
public class Triangle {
	int size;
	int m;
	int n;
	boolean[][] mark;
	
	public void input() {
		Scanner input = new Scanner(System.in);
		size = input.nextInt();
		m = Sy(size);
		n = Sx(size);
		mark = new boolean[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mark[j][i] = false;
			}
		}
	}
	
	public int Sx(int x) {
		return (int) Math.pow(2, x+1);
	}
	
	public int Sy(int y) {
		return (int) Math.pow(2, y);
	}
	
	public void Sub(int x, int y, int size) {
		if (size != 0) {
			Sub(x, y, size-1);
			Sub(x-Sx(size-1)/2, y+Sy(size-1), size-1);
			Sub(x+Sx(size-1)/2, y+Sy(size-1), size-1);
		} else {
			mark[x][y] = true;
		}
	}
	
	public void print(int size) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mark[j][i]) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Triangle hung = new Triangle();
		hung.input();
		hung.Sub(hung.m, 0, hung.size);
		hung.print(hung.size);
	}
}