package week8Git;
import java.util.ArrayList;


public class Cell {
	private int row, col, id;
	private char symbol;
	private char lastSymbol;
	
	private static int numCells = 0;
	
	public Cell () {
		row = numCells / 3;
		col = numCells % 3;
		id = numCells;
		numCells++;
		symbol = ' ';
		lastSymbol = ' ';
	}
	
	public static ArrayList<Cell> getBoard() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 9; i++) {
			cells.add(new Cell());
		}
		return cells;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public boolean move(char newSymbol) {
		if (symbol != ' ') {
			return false;
		}
		else {
			lastSymbol = symbol;
			symbol = newSymbol;
			return true;
		}
	}
	
	public void undo() {
		symbol = lastSymbol;
	}
	
	public boolean isX() {
		return (symbol == 'X');
	}
	
	public boolean isO() {
		return (symbol == 'O');
	}
	
	public boolean isEmpty() {
		return (symbol == ' ');
	}
	
	public boolean isCorner() {
		return ((row == 0 || row == 2) && (col == 0 || col == 2));
	}
	
	public boolean isEdge() {
		return (row + col == 1 || row + col == 3);
	}
	
	public boolean isCenter() {
		return (row == 1 && col ==1);
	}
	
	public String getCoords() {
		return Integer.toString(col) + " " + Integer.toString(row);
	}
}
