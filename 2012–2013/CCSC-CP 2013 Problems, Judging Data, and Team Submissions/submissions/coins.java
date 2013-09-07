import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class coins {

	final static String FILE_NAME = "coins.in";
	static HashMap<ArrayList<Integer>, Integer> scoreOf = new HashMap<ArrayList<Integer>, Integer>();
	
	static int score (ArrayList<Integer> coins, int totScore) {
		if (coins.size() == 1)
			return coins.get(0).intValue();
		else if (scoreOf.containsKey(coins)){
			return scoreOf.get(coins);
		}
		else {
			//int totScore = 0;
			//for (int i = 0; i < coins.size(); i++) {
				//totScore += coins.get(i).intValue();
		//}
			//ArrayList<Integer> leftList = (ArrayList<Integer>) coins.subList(1, coins.size());
			//ArrayList<Integer> rightList = (ArrayList<Integer>) coins.subList(0, coins.size()-1);
			ArrayList<Integer> leftList = new ArrayList<Integer>();
			ArrayList<Integer> rightList = new ArrayList<Integer>();
			for (int i = 0; i < coins.size(); i++) {
				if (i > 0) {
					leftList.add(coins.get(i));
				}
				if (i < coins.size()-1){
					rightList.add(coins.get(i));
				}
				
			}
			
			int lScore = totScore - score(leftList, totScore - coins.get(0));
			//if (lScore >= totScore/2) {
				//return lScore;
			//}
			int rScore = totScore - score(rightList, totScore - coins.get(coins.size()-1));
			int ret = Math.max(lScore, rScore);
			scoreOf.put(coins, ret);
			return ret;
		}
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
			System.out.println(2*score(coins, totScore)- totScore);
			num = stdIn.nextInt();
		}

	}

}
