import java.util.Random;

public class LikeAWeasel {
	static Random rand = new Random();
	static String weasel = "methinks it is like a weasel";
	static int highestScore = 0;
	//static int counter = 0;
	
	public static void main(String [] args){
		
		char[] originalSentenceArray = new char[28];
		for(int i = 0; i < originalSentenceArray.length; i++){
			if(probability(27)){
				originalSentenceArray[i] = (char)32;
			} else {
				originalSentenceArray[i] = (char)( rand.nextInt((122-97)+1) + 97 ); 				
			}
		}
				
		System.out.println("original sentence: ");
		printSentenceandPoints(originalSentenceArray);
		System.out.println("\n");
		
		generateSentences(originalSentenceArray);
		
		/*
		//I do not have the patience to start from a completely random array while testing
		String cheat = "methinks it is ekil a lesaew";
		char[] cheatArray = new char[28];
		for(int i = 0; i <28; i++){
			cheatArray[i] = cheat.charAt(i);
		}
		System.out.println("cheating sentence: ");
		printSentenceandPoints(cheatArray);
		System.out.println("\n");
	
		generateSentences(cheatArray);
		*/		
	}
	
	//generates 100 new sentences based on one sentence. the sentence with the most
	//points is passed back into generateSentences to get the sentence as close to
	//the weasel sentence as possible
	public static void generateSentences(char[] s1){
		//sometimes a counter can be useful to avoid stack overflow?
		while(highestScore < 28  /*&& counter < 10*/){
			char[][] hugeArray = new char[100][28];
	
			char[] winner = hugeArray[0];
			int highestPoints = 0;

			for( int j = 0; j < 100; j++){
			
				//points = 0;
				hugeArray[j] = generateNewSentence(s1);
			
				if(generatePoints(hugeArray[j]) > highestPoints){
					highestPoints = generatePoints(hugeArray[j]);
					winner = hugeArray[j];
				}						
			}
			//counter++;
			highestScore = highestPoints;
			printSentenceandPoints(winner);
			//calls itself until the global score is high enough
			generateSentences(winner);
		}
	}
	
	//prints the sentence and it's score to the console
	public static void printSentenceandPoints(char[] sentence){
		for(int i = 0; i < 28; i++){

			System.out.print(sentence[i]);

		}
		System.out.println("  ----" + generatePoints(sentence) + " point(s)");
	}
	
	//calculates the similarities between the current sentence and the ideal
	public static int generatePoints(char[] sentence){
		int points = 0;
		for(int i = 0; i < 28; i++){
			if (sentence[i] == weasel.charAt(i)){
				points++;
			}
		}
		return(points);
	}
	
	//generates a new sentence based on the best sentence from the last generateSentences run
	public static char[] generateNewSentence(char[] sentence){
		char[] sentence2 = new char[28];
		for(int i = 0; i < 28; i++){
			sentence2[i] = sentence[i];
		}

		for(int i = 0; i < sentence2.length; i++){
			if( probability(20) ){
				if(probability(27)){
					sentence2[i] = (char)32;
				} else {
					sentence2[i] = (char)( rand.nextInt((122-97)+1) + 97 ); 				
				}
			}
			
		}
		return(sentence2);
	}
	
	//calculates the probability of a character change/space insert
	//and returns true one out of every (chance) times
	public static boolean probability(int chance){
		int number = rand.nextInt(chance);
		if(number <=0 ){
			return(true);
		} 
		return(false);
	}

}