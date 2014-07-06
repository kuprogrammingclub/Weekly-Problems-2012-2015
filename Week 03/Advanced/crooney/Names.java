

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Names {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long nameSum = 0; //Total score of the NAMES file. I made it a long because I thought that there would be a lot of names.
		String[] names = getNames(new File("names.txt"));
		
		Arrays.sort(names); //I wonder if I was supposed to implement this myself......... NAH.
		for(int x = 0; x < names.length; x++) { //iterate over all of the names 
			int numInList = x + 1;
			
			char[] blah = names[x].toCharArray();
			int thisScore = 0;
			
			for(int y = 0; y < blah.length; y++) { //calculate first part of the score
				thisScore += blah[y]-64;
				
			}
			
			thisScore *= numInList;	//finalize the total score of this name
			nameSum += thisScore;	//add this name to the total score
			
		}
		System.out.println(nameSum);
		
	}

	
	public static String[] getNames(File file) {
		Scanner input = null;
		
		try{
			input = new Scanner(new FileInputStream(file));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(2);
		}
		
		String rawString = input.nextLine();
		input.close();
		String[] output = rawString.split(","); //make the huge string into an array where output[x] = "\"NAME\""
		
		for(int x = 0; x < output.length; x++) {
			output[x] = output[x].substring(1, output[x].length()-1);	//trim all the quotes away. now output[x] = "NAME" 
			
		}
		
		return output;
	}
	
	
	
}
