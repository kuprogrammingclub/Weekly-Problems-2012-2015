import java.util.ArrayList;


public class CellNode {
	private Cell myCell;
	private CellNode prevCell;
	private int gScore;
	
	public CellNode(Cell newCell, CellNode newNode, int newG) {
		myCell = newCell;
		prevCell = newNode;
		gScore = newG;
	}
	public CellNode(Cell newCell, CellNode newNode) {
		this(newCell, newNode, 0);
	}
	public CellNode() {
		this(null, null, 0);
	}
	
	public Cell getCell() {
		return myCell;
	}
	public CellNode getPrev() {
		return prevCell;
	}
	public int getG() {
		return gScore;
	}
	public int getF(Cell target) {
		if (myCell.getZ() == target.getZ()) {
			return myCell.distFrom(target);
		}
		else {
			int ret = 0;
			ret += (myCell.getZ() - target.getZ());
			ArrayList<Cell> levelLadders = new ArrayList<Cell>();
			for (Cell[][] xArray : Cell.getCells()) {
				for (Cell[] yArray : xArray) {
					if (yArray[myCell.getZ()].getContent() == Cell.LADDER) {
						levelLadders.add(yArray[myCell.getZ()]);
					}
				}
			}
			int minLen = Integer.MAX_VALUE;
			Cell targetLadder = null;
			for (Cell candidate : levelLadders) {
				int compVal = myCell.distFrom(candidate);
				if (compVal < minLen) {
					minLen = compVal;
					targetLadder = candidate;
				}
			}
			ret += minLen;
			
			ret+= Cell.getCellAt(targetLadder.getX(), targetLadder.getY(), target.getZ()).distFrom(target);
			return ret;
		}
	}
	
	public boolean hasPrev() {
		return (getPrev() != null);
	}
	
	public void setCell (Cell newCell) {
		myCell = newCell;
	}
	public void setPrev (CellNode newNode) {
		prevCell = newNode;
	}
	public void setG(int newG) {
		gScore = newG;
	}
	public void set(CellNode newData) {
		myCell = newData.getCell();
		prevCell = newData.getPrev();
		gScore = newData.getG();
	}
	
	public ArrayList<CellNode> getNeighbors() {
		ArrayList<Cell> neighborCells = myCell.getNeighbors();
		ArrayList<CellNode> retList = new ArrayList<CellNode>();
		for (Cell neighbor : neighborCells) {
			retList.add(neighbor.makeNode(this, getG() + 1));
		}
		return retList;
	}
	
}
