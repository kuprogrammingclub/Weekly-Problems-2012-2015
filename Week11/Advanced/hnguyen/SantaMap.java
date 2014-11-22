package SantaMap;
import java.util.Stack;
import java.util.Scanner;
public class SantaMap {
	static char[][] map;
	static boolean[][] visit;
	static int rows;
	static int cols;
	static int startRow;
	static int startCol;
	static Stack<Coord> stack = new Stack<Coord>();
	static Stack result = new Stack();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		cols = input.nextInt();
		input.nextLine();
		map = new char[rows][cols];
		visit = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			String s = input.nextLine();
			map[i] = s.toCharArray();
			for (int j = 0; j < cols; j++) {
				visit[i][j] = false;
				if (map[i][j] == 'S') {
					startRow = i;
					startCol = j;
				}
			}
		}
		visit[startRow][startCol] = true;
		stack.push(new Coord(startRow, startCol));
		Try(startRow, startCol);
	}
	
	 private static class Coord {
	    	public int myX, myY;
	    	
	    	public Coord(int x, int y) {
	    		myX = x;
	    		myY = y;
	    	}
	    
	    	@Override
	    	public boolean equals(Object o) {
	    		if (o instanceof Coord) {
	    			Coord c = (Coord) o;
	    			return this.myX == c.myX && this.myY == c.myY;
	    		} else {
	    			return false;
	    		}
	    	}
	 }
	 
	public static void print() {
		System.out.println("Found");
		while (!stack.isEmpty()) {
			Coord coord1 = stack.pop();
			if (!stack.isEmpty()) {
				Coord coord2 = stack.peek();
				if (coord1.myX > coord2.myX) {
					result.push("South");
				} else if (coord1.myX < coord2.myX) {
					result.push("North");
				} else if (coord1.myY > coord2.myY) {
					result.push("East");
				} else if (coord1.myY < coord2.myY) {
					result.push("West");
				}
			}
		}
		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}
	public static void Try(int i, int j) {
		if (map[i][j] == '1') {
			visit[i][j] = true;
			stack.push(new Coord(i, j));
			print();
			return;
		} else { 
			if (i > 0 && map[i-1][j] != '#' && !visit[i-1][j]) {
				stack.push(new Coord(i-1, j));
				visit[i-1][j] = true;
				Try(i-1, j);
			} else if (i < rows - 1 && map[i+1][j] != '#' && !visit[i+1][j]) {
				stack.push(new Coord(i+1, j));
				visit[i+1][j] = true;
				Try(i+1, j);
			} else if (j > 0 && map[i][j-1] != '#' && !visit[i][j-1]) {
				stack.push(new Coord(i, j-1));
				visit[i][j-1] = true;
				Try(i, j-1);
			} else if (j < cols-1 && map[i][j+1] != '#' && !visit[i][j+1]) {
				stack.push(new Coord(i, j+1));
				visit[i][j+1] = true;
				Try(i, j+1);
			}
		}
	}

}
