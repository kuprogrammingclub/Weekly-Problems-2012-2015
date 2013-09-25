import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class VerticalText {

    public static void main(String[] args) {
	
	/******DECLARE VARIABLES**************/
	Scanner input = new Scanner(System.in);
	int numLines = input.nextInt();
	String[] lines = new String[numLines];
	int longestString = 0;
	/******GET INPUT FROM FILE************/
	input.nextLine();
	for(int x = 0; x < numLines; x++) {
	    lines[x] = input.nextLine();
	    if(lines[x].length() > longestString) {
		longestString = lines[x].length();
	    }
	}
	

	/******PRINT INVERTED OUTPUT**********/
	for(int y = 0; y < longestString; y++) {
	    for(int z = 0; z < numLines; z++) {
		try {
		    System.out.print(lines[z].charAt(y)); //I'm using String[] as a kind of a char[][] here...
		} catch(IndexOutOfBoundsException e) {	//I guess I could do an if statement, but this seemed like a good idea at the time.
		    System.out.print(" ");		//basically if we go outside the max length of a string that's smaller than the longest string, it prints a space.
		}
	    }
	    System.out.println("");
	}
	
	
	input.close();
    }


}
