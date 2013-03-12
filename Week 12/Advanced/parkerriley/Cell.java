import java.util.ArrayList;


public class Cell {
	public static char WALL = 'W';
	public static char START = 'S';
	public static char LADDER = '#';
	public static char SPACE = ' ';
	public static char GOAL = 'X';
	public static char TRAVEL = 'O';
	private int xPos, yPos, zPos;
	private char content;
	private static Cell[][][] allCells;
	
	public Cell() {
		this(0,0,0, SPACE);
	}
	public Cell(int x, int y, int z, char c) {
		setCoords(x,y,z);
		content = c;
	}
	
	public static void initializeCells(int x, int y, int z) {
		allCells = new Cell[x][y][z];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++) {
					allCells[i][j][k] = new Cell(i, j, k, SPACE);
				}
			}
		}
	}
	
	public static Cell[][][] getCells () {
		return allCells;
	}
	public static Cell getCellAt(int x, int y, int z) {
		return allCells[x][y][z];
	}
	public static Cell getPosOf(char target) {
		for (Cell[][] xArray : allCells) {
			for (Cell[] yArray : xArray) {
				for (Cell cell : yArray) {
					if (cell.getContent() == target) {
						return cell;
					}
				}
			}
		}
		return null;
	}

	
	private int sumCoords() {
		return xPos + yPos + zPos;
	}
	public int distFrom(Cell other) {
		return Math.abs(other.sumCoords() - sumCoords());
	}
	
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	public int getZ() {
		return zPos;
	}
	public char getContent() {
		return content;
	}
	public boolean isReachableFrom(Cell origin) {
		if (getContent() == WALL) {
			return false;
		}
		if (getZ() != origin.getZ() && (getContent() != LADDER || origin.getContent() != LADDER)) {
			return false;
		}
		return true;
	}
	
	public void setCoords (int x, int y, int z) {
		xPos = x;
		yPos = y;
		zPos = z;
	}
	public void setContent (char c) {
		content = c;
	}
	public void setTraveled () {
		if (getContent() != LADDER) {
			setContent(TRAVEL);
		}
	}
	
	public CellNode makeNode() {
		return new CellNode(this, null);
	}
	public CellNode makeNode(CellNode prev) {
		return new CellNode(this, prev);
	}
	public CellNode makeNode(CellNode prev, int g) {
		return new CellNode(this, prev, g);
	}
	
	public boolean equals(Cell other) {
		return (xPos == other.getX() && yPos == other.getY() && zPos == other.getZ());
	}

	public ArrayList<Cell> getNeighbors() {
		ArrayList<Cell> tempList = new ArrayList<Cell>();
		ArrayList<Cell> retList = new ArrayList<Cell>();
		if (xPos > 0)
			tempList.add(getCellAt(xPos - 1, yPos, zPos));
		if (yPos > 0)
			tempList.add(getCellAt(xPos, yPos - 1, zPos));
		if (zPos > 0)
			tempList.add(getCellAt(xPos, yPos, zPos - 1));
		if (xPos < allCells.length-1)
			tempList.add(getCellAt(xPos + 1, yPos, zPos));
		if (yPos < allCells[0].length-1)
			tempList.add(getCellAt(xPos, yPos + 1, zPos));
		if (zPos < allCells[0][0].length-1)
			tempList.add(getCellAt(xPos, yPos, zPos + 1));
		for (Cell candidate : tempList) {
			if (candidate.isReachableFrom(this)) {
				retList.add(candidate);
			}
		}
		return retList;
	}
}
