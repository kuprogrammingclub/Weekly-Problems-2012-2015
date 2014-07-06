package week8Git;
import java.util.ArrayList;


public class WinPath {
	Cell[] path = new Cell[3];
	//private boolean isDiagonal = false;
	
	static final int WIN_NOW = 3;
	static final int LOSE_NOW = 2;
	static final int EVALUATE = 1;
	static final int CLOSED = 0;
	
	private int numEmpty() {
		int num = 0;
		for (Cell cell : path) {
			if (cell.isEmpty()) {
				num++;
			}
		}
		return num;
	}
	
	public Cell getBest(char mySymbol) {
		if (numEmpty() == 1) {
			for (Cell cell : path) {
				if (cell.isEmpty()) {
					return cell;
				}
			}
		}
		else {
			for (Cell cell : path) {
				if (cell.isCenter() && cell.isEmpty()) {
					return cell;
				}
			}
			for (Cell cell : path) {
				if (cell.isCorner() && cell.isEmpty()) {
					return cell;
				}
			}
			
			for (Cell cell : path) {
				if (cell.isEdge() && cell.isEmpty()) {
					return cell;
				}
			}
		}
		return null;
	}
	
 	public static ArrayList<WinPath> getPaths() {
		ArrayList<WinPath> winPaths = new ArrayList<WinPath>();
		
		int[][] winPathOrder = {{0,4,8}, {2,4,6}, {3,4,5}, {1,4,7}, {0,1,2}, {6,7,8}, {0,3,6}, {2,5,8}};
		for (int i = 0; i < 8; i++) {
			winPaths.add(new WinPath(winPathOrder[i]));
		}
		return winPaths;
	}
	
 	public int getPriority(char mySymbol) {
 		int numX = 0, numO = 0;

 		for (Cell cell : path) {
 			if (cell.isX()) {
 				numX++;
 			}
 			else if (cell.isO()) {
 				numO++;
 			}
 		}
 		
 		if (numX + numO == 2) {
 			if (numX == 2) {
 				return (mySymbol == 'X' ? WIN_NOW : LOSE_NOW);
 			}
 			else if (numX == 0) {
 				return (mySymbol == 'X' ? LOSE_NOW : WIN_NOW);
 			}
 			else {
 				return EVALUATE;
 			}
 		}
 		else if (numX + numO == 3) {
 			return CLOSED;
 		}
 		else {
 			return EVALUATE;
 		}
 	}
	
	public boolean isWon() {
		if (isClosed() && path[0].getSymbol() == path[1].getSymbol() && path[1].getSymbol() == path[2].getSymbol()) {
			return true;
		}
		return false;
	}
	
	public boolean isClosed() {
		return (!path[0].isEmpty() && !path[1].isEmpty() && !path[2].isEmpty());
	}
	
	public char getWinner() {
		if (!isWon()) {
			return ' ';
		}
		else {
			return path[0].getSymbol();
		}
	}
	
	public WinPath(int[] ids) {
		for (int i = 0; i < 3; i++) {
			path[i] = TicTacToe.board.get(ids[i]);
		}
	}
	
}
