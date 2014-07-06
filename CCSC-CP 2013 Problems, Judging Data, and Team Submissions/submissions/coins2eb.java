import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class coins2eb {

	/*final static String FILE_NAME = "coins.in";
	static ArrayList<Integer> allScores = new ArrayList<Integer>();
	
	static void score (ArrayList<Integer> coins, int prevScore) {
		if (coins.size() == 1) {
			allScores.add(coins.get(0).intValue() + prevScore);
		}
		else {
			ArrayList<Integer> leftMove = removeLeft(coins);
			ArrayList<Integer> rightMove = removeRight(coins);
			
			int lScore = totScore - score(leftList);
			int rScore = totScore - score(rightList);
			return Math.max(lScore, rScore);
		}
	}
	
	static ArrayList<Integer> removeLeft(ArrayList<Integer> list){
		ArrayList<Integer> rightList = new ArrayList<Integer>();
		for (int i = 1; i < list.size(); i++) {
			rightList.add(list.get(i));
		}
		return rightList;
	}
	
	static ArrayList<Integer> removeRight(ArrayList<Integer> list){
		ArrayList<Integer> leftList = new ArrayList<Integer>();
		for (int i = 0; i < list.size() - 1; i++) {
			leftList.add(list.get(i));
		}
		return leftList;
	}
	
	
	public static void main(String[] args) {
		File fIn = new File(FILE_NAME);
		Scanner stdIn = null;
		try {
			 stdIn = new Scanner(fIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int num = stdIn.nextInt();
		while (num != 0) {
			ArrayList<Integer> coins = new ArrayList<Integer>();
			for (int i = 0; i < num; i++) {
				coins.add(stdIn.nextInt());
			}
			int totScore = 0;
			for (int i = 0; i < coins.size(); i++) {
				totScore += coins.get(i).intValue();
			}
			System.out.println(totScore - score(coins));
			num = stdIn.nextInt();
		}

	}
*/
}
