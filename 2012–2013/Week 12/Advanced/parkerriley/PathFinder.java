import java.util.ArrayList;
import java.util.Stack;


public class PathFinder {
	
	public static Stack<CellNode> findPath (Cell start, Cell goal) {
		ArrayList<CellNode> closed, open;
		closed = new ArrayList<CellNode>();
		open = new ArrayList<CellNode>();
		open.add(start.makeNode());
		
		while (!open.isEmpty()) {
			CellNode curNode = findLowestF(open, goal);
			if (curNode.getCell().equals(goal)) {
				return getPath(curNode);
			}
			
			open.remove(curNode);
			closed.add(curNode);
			ArrayList<CellNode> neighbors = curNode.getNeighbors();
			for (CellNode neighbor : neighbors) {
				if (containsByCell(closed, neighbor)) {
					if (neighbor.getG() >= getByCell(closed, neighbor).getG()) {
						continue;
					}
					if (neighbor.getG() < getByCell(closed, neighbor).getG()) {
						getByCell(closed, neighbor).set(neighbor);
					}
					
				}
				
				if (!containsByCell(open, neighbor)) {
					open.add(neighbor);
				}
			}
		}
		System.out.println("Unsolvable maze.");
		return null;
	}
	
	private static CellNode findLowestF (ArrayList<CellNode> stack, Cell goal) {
		double fVal = stack.get(0).getF(goal);
		CellNode lowCell = stack.get(0);
		for (CellNode node : stack) {
			if (node.getF(goal) < fVal) {
				fVal = node.getF(goal);
				lowCell = node;
			}
		}
		return lowCell;
	}

	private static Stack<CellNode> getPath(CellNode end) {
		Stack<CellNode> retStack = new Stack<CellNode>();
		CellNode curNode = end.getPrev();
		do {
			retStack.push(curNode);
			curNode = curNode.getPrev();
		} while (curNode.hasPrev());

		return retStack;
	}
	
	private static boolean containsByCell (ArrayList<CellNode> list, CellNode target) {
		for (CellNode node : list) {
			if (node.getCell().equals(target.getCell())) {
				return true;
			}
		}
		return false;
	}
	
	private static CellNode getByCell (ArrayList<CellNode> list, CellNode target) {
		for (CellNode node : list) {
			if (node.getCell().equals(target.getCell())) {
				return node;
			}
		}
		return null;
	}
}
