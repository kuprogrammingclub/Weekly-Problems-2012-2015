import java.util.Scanner; 

public class WordsWithEnemies {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String player1 = input.next();
		String player2 = input.next();
		
		//puts player 1's input into two strings: one that can be changed
		//and one that can be compared to player 2's input
		char[] p1 = new char[player1.length()];
		for(int i = 0; i<player1.length(); i++) {
			p1[i] = player1.charAt(i);
		}		
		char[] p1Orig = p1;
		
		//put's player 2's input into two strings: one that can be changed
		//and one that can be compared to player 1's input
		char[] p2 = new char[player2.length()];
		for (int i =0; i < player2.length(); i++){
			p2[i] = player2.charAt(i);
		}
		char[] p2Orig = p2;
		
		String player1end = "";
		String player2end = "";
		
		//compares player 1's input to player 2
		for(int i = 0; i < p1.length; i++){
			for(int j = 0; j < player2.length(); j++){
				if(p1[i] == p2Orig[j] ) {
					p1[i] = '0' ;
					p2Orig[j] = '0';
				}
			}
		}
		
		//concatenates player 1's remaining letters into a string
		for(int i = 0; i < p1.length; i++){
			if(p1[i] != '0'){
				player1end += p1[i];
			}
		}
		
		//compares player 2's input to player 1's
		for(int i = 0; i < p2.length; i++){
			for(int j = 0; j < player1.length(); j++){
				if(p2[i] == p1Orig[j]) {
					p2[i] = '0' ;
					p1Orig[j] = '0';
				}
			}
		}
		
		//concatenates player 2's remaining letters into a string
		for(int i = 0; i < p2.length; i++){
			if(p2[i] != '0'){
				player2end += p2[i];
			}
		}
		
			
		char sign = 'x';
		String winner = "";
		
		//determines which sign and winner declaration to display
		if (player2end.length() > player1end.length() ){
			sign = '<';
			winner = "Right wins!";
		} else if (player1end.length() > player2end.length() ) {
			sign = '>';
			winner = "Left wins!";
		} else {
			sign = '=';
			winner = "Tie!";
		}
		
		//prints the ending letters and results
		System.out.print("\"" + player1end + "\"");
		System.out.print(" " + sign + " ");
		System.out.print("\"" + player2end + "\"");
		System.out.print('\n' + winner);
	}

}
