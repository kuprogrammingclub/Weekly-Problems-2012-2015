import java.util.Scanner;

public class RepeatedChars {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String word = input.next();
		char[] wordArray = new char[word.length()];
		for (int i = 0; i < word.length(); i++){
			wordArray[i] = word.charAt(i);
		}
		
		String end = Character.toString(wordArray[0]);
		
		for(int i = 0; i < wordArray.length; i++){
			boolean fail = false;
			for(int j = 0; j < end.length(); j++){
				if (wordArray[i] == end.charAt(j)){
					fail = true;
				} 
			}
			if(!fail){
				end += wordArray[i];
			}
			
		}
		
		System.out.println(end);
	}

}
