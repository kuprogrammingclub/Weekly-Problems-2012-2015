/*

	SLongofono     Week 03 Fall 2015     Hard
	
	Write a method that reads in n coordinate pairs, and then travels to each from the starting
	position of (0.5,0.5).  Input is validated for x, y on [0.0, 1.0] and n is a positive integer.
	The next point is always the closest point to the current position.  The return should be the
	total distance traveled while visiting the points.

	Usage: java muchTreats.java <filename.txt>

*/

import java.util.LinkedList;
import java.io.StreamTokenizer;
import java.io.FileReader;

public class muchTreats{
	public static void main(String [] args){

		if(args.length < 1){
			System.out.println("Usage: java muchTreats <name of your text input file>...");
		}			
		
		try{
			FileReader fr = new FileReader(args[0]);
			StreamTokenizer st = new StreamTokenizer(fr);
			double work = 0.0;
			double x;
			double y;
			double xpos = 0.5;
			double ypos = 0.5;
			double temp = 0.0;
			int nextMove;
			LinkedList moves = new LinkedList();
			//build list
			while(st.nextToken()!=StreamTokenizer.TT_EOF){
				moves.add(st.nval);
			}
			moves.remove(0); //Don't need a count with this approach
			while(moves.size()>0){
				nextMove = getClosestIndex(moves, xpos, ypos, work);
				x = (double) moves.get(nextMove);
				y = (double) moves.get(nextMove+1);
				work += distance(x, y, xpos, ypos);
				xpos = x;
				ypos = y;
				moves.remove(nextMove);
				moves.remove(nextMove);
			}
			System.out.println(work);

		}
		catch(Exception e){
			System.out.println("Read failed, check your inputs...");
			System.out.println(e.getMessage());
		}

	}//end main

	public static double distance(double a, double b, double x, double y){
		return Math.sqrt((Math.abs(x-a)*Math.abs(x-a))+(Math.abs(y-b)*Math.abs(y-b)));
	}

	public static int getClosestIndex(LinkedList list, double xpos, double ypos, double work){

		double low = 2.0;
		int index = -1;
		if(list.size()<1){
			System.out.println("   [Bounds error]   ");
			return index;
		}
		for(int i = 0; i< list.size(); i=(i+2)){
			double temp = distance((double)list.get(i), (double)list.get(i+1), xpos, ypos);
			if(temp < low){
				low = temp;
				index = i;
			}
		}
		return index;
	}

}//end class
