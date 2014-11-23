package SantaMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class SantaMap {
	static char[][] map;
	static boolean[][] visit;
	static Coord[][] prev;
	static Coord cur, start;
	static int rows, cols, endRow, endCol;
	static LinkedList<Coord> list = new LinkedList<Coord>();
	static LinkedList<String> result = new LinkedList<String>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		cols = input.nextInt();
		input.nextLine();
		map = new char[rows][cols];
		visit = new boolean[rows][cols];
		prev = new Coord[rows][cols];
		for (int i = 0; i < rows; i++) {
			String s = input.nextLine();
			map[i] = s.toCharArray();
			Arrays.fill(visit[i], false);
			Arrays.fill(prev[i], new Coord(0, 0));
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'S') {
					start = new Coord(i, j);
				}
			}
		}
		walkMaze();
		print();
	}
	
	private static class Coord {
    	public int myX, myY;
    	
    	public Coord(int x, int y) {
    		myX = x;
    		myY = y;
    	}
	}
 
	public static void print() {
		int i = endRow;
		int j = endCol;
		int temp;
		while (i != start.myX || j != start.myY) {
			if (i > prev[i][j].myX) {
				result.addFirst("South");
			}
			if (i < prev[i][j].myX) {
				result.addFirst("North");
			} 
			if (j > prev[i][j].myY) {
				result.addFirst("East");
			} 
			if (j < prev[i][j].myY) {
				result.addFirst("West");
			}
			temp = i;
			i = prev[temp][j].myX;
			j = prev[temp][j].myY;
		}
		
		while (result.size() != 0) {
			System.out.print(result.removeFirst() + " ");
		}
	}
	
	public static void walkMaze() {
		move(start);
		while (!isGoalReached()) {
			storeValidMoves();
			if (list.size() == 0) {
				break;
			}	
			move(list.getFirst());
			list.removeFirst();
		}
	}
	
	public static void storeValidMoves() {
		int i = cur.myX;
		int j = cur.myY;
		Coord x = new Coord(i, j);
		if (i < rows - 1 && map[i+1][j] != '#' && !visit[i+1][j]) {
			list.addLast(new Coord(i+1, j));
			visit[i+1][j] = true;
			prev[i+1][j] = x;
		}  
		if (i > 0 && map[i-1][j] != '#' && !visit[i-1][j]) {
			list.addLast(new Coord(i-1, j));
			visit[i-1][j] = true;
			prev[i-1][j] = x;
		} 
		if (j > 0 && map[i][j-1] != '#' && !visit[i][j-1]) {
			list.addLast(new Coord(i, j-1));
			visit[i][j-1] = true;
			prev[i][j-1] = x;
		}  
		if (j < cols-1 && map[i][j+1] != '#' && !visit[i][j+1]) {
			list.addLast(new Coord(i, j+1));
			visit[i][j+1] = true;
			prev[i][j+1] = x;
		}
	}
	
	public static void move(Coord c) {
		cur = c;
		visit[cur.myX][cur.myY] = true;
	}
	
	public static boolean isGoalReached() {
		if (map[cur.myX][cur.myY] == '1') {
			endRow = cur.myX;
			endCol = cur.myY;
			return true;
		} else {
			return false;
		}
	}
}
