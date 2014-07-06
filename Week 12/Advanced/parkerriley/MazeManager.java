import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class MazeManager {
	private static int xDim, yDim, zDim;
	
	public static void main (String[] args) {
		File inFile = new File(args[0]);
		Scanner inScan = null;
		try {
			inScan = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] nums = inScan.nextLine().split(" ");
		xDim = Integer.parseInt(nums[0]);
		yDim = Integer.parseInt(nums[1]);
		zDim = Integer.parseInt(nums[2]);
		Cell.initializeCells(xDim, yDim, zDim);
		
		ArrayList<String> lines = new ArrayList<String>();
		while (inScan.hasNextLine()) {
			lines.add(inScan.nextLine());
		}
		
		for (int z = 0; z < zDim; z++) {
			for (int y = 0; y < yDim; y++) {
				String line = lines.get(y + (z*yDim) + z);
				for (int x = 0; x < xDim; x++) {
					Cell.getCells()[x][y][z].setContent(line.charAt(x));
				}
				if (inScan.hasNextLine()) {
					inScan.nextLine();
				}
			}
		}
		//printMaze();
		printPath(PathFinder.findPath(Cell.getPosOf(Cell.START), Cell.getPosOf(Cell.GOAL)));
	}
	
	private static void printPath(Stack<CellNode> path) {
		System.out.println("Length: " + path.size());
		while (!path.empty()) {
			CellNode tmp = path.pop();
			tmp.getCell().setTraveled();
		}
		printMaze();
		
	}
	private static void printMaze() {
		for (int z = 0; z < zDim; z++) {
			for (int y = 0; y < yDim; y++) {
				for (int x = 0; x < xDim; x++) {
					System.out.print(Cell.getCells()[x][y][z].getContent());
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
