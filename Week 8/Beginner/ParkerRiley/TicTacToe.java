package week8Git;
import java.util.ArrayList;
import java.util.Scanner;


public class TicTacToe {

	
	static ArrayList<Cell> board;
	static ArrayList<WinPath> paths;
	static boolean playedFirst;
	static boolean isPlaying;
	
	static final int WILL_WIN = 2;
	static final int WILL_TIE = 1;
	static final int WILL_LOSE = 0;
	static final double IMMEDIATE_WIN = Double.MAX_VALUE * -1;
	static final double IMMEDIATE_LOSS = (Double.MAX_VALUE - 1) * -1;
	
	static Scanner kb = new Scanner(System.in);
	
	private static char opp(char symbol) {
		if (symbol == 'X') {
			return 'O';
		}
		else if (symbol == 'O') {
			return 'X';
		}
		else {
			return ' ';
		}
	}
	
	private static boolean move(int col, int row, char newSym) {
		if (col > 2 || row > 2 || col < 0 || row < 0) {
			System.out.println("Invalid coordinates. Rows and Columns start from 0.");
			return false;
		}
		else {
			int targetID = (3 * row) + col;
			if (!board.get(targetID).move(newSym)) {
				System.out.println("That spot is taken.");
				printBoard();
				return false;
			}
			return true;
		}
	}
	
	private static void player1(char symbol) {
		if (isPlaying) {
			int col;
			int row;
			do {
				System.out.println("What is your move? (Column Row)");
				col = kb.nextInt();
				row = kb.nextInt();
			} while (!move(col, row, symbol));
		}
		else {
			player2(symbol);
		}
		
	}
	
	private static void player2(char symbol) {
		
		Cell best = getBestMove(symbol);
		
		if (!best.move(symbol)) {
			System.out.println("Possible logic error; best move was not legal");
			return;
		}
		
		System.out.println("Here is my move: " + best.getCoords());
	}
	
	private static Cell getBestMove(char symbol) {
		

		ArrayList<Cell> evalMoves = getEvals();
		
		double bestOutcome = Double.MAX_VALUE;
		Cell bestMove = evalMoves.get(0);
		
		for (Cell move : evalMoves) {
			double tmpOutcome;
			if (!move.move(symbol)) {
				System.out.println("Possible logic error; best move was not legal");
				continue;
			}
			if (!notOver()) {
				bestMove = move;
				move.undo();
				break;
			}
			if (hasWon(symbol)) {
				tmpOutcome = IMMEDIATE_WIN;
				move.undo();
			}
			else {
				move.undo();
				move.move(opp(symbol));
				if (hasWon(opp(symbol))) {
					tmpOutcome = IMMEDIATE_LOSS;
					move.undo();
					move.move(symbol);
				}
				else {
					move.undo();
					move.move(symbol);
					tmpOutcome = willWin(opp(symbol));
				}
			}
			
			bestOutcome = Math.min(tmpOutcome, bestOutcome);
			if (bestOutcome == tmpOutcome) {
				bestMove = move;
			}
			
			move.undo();
			
		}
		return bestMove;
	}
	
	private static void printBoard() {
		System.out.println();
		System.out.printf(" %c | %c | %c \n", board.get(0).getSymbol(), board.get(1).getSymbol(), board.get(2).getSymbol());
		System.out.println("---+---+---");
		System.out.printf(" %c | %c | %c \n", board.get(3).getSymbol(), board.get(4).getSymbol(), board.get(5).getSymbol());
		System.out.println("---+---+---");
		System.out.printf(" %c | %c | %c \n", board.get(6).getSymbol(), board.get(7).getSymbol(), board.get(8).getSymbol());
		System.out.println();
	}
	
	private static boolean notOver() {
		boolean allClosed = true;
		for (WinPath path : paths) {
			if (path.isWon()) {
				return false;
			}
			else if (!path.isClosed()) {
				allClosed = false;
			}
		}
		if (allClosed) {
			return false;
		}
		
		return true;
	}
	
	private static boolean hasWon(char symbol) {
		for (WinPath path : paths) {
			if (path.getWinner() == symbol) {
				return true;
			}
		}
		
		return false;
	}
	
	private static double willWin(char symbol) {
		
		ArrayList<Cell> evalMoves = getEvals();
		
		if (evalMoves.size() == 0) {
			printBoard();
			System.out.println("NO MOVES 1");
			return -1;
		}
		
		else {
			//double moveGrade = Double.MAX_VALUE;
			double moveGrade = 0.0;
			//double moveGrade = WILL_WIN;

			for (Cell move : evalMoves) {
	
				if (!move.move(symbol)) {
					System.out.println("Possible logic error; best move was not legal");
					continue;
				}
				if (hasWon(symbol)) {
					move.undo();
					return WILL_WIN;
				}
				else if (hasWon(opp(symbol))) {
					move.undo();
					return WILL_LOSE;
				}
				else if (evalMoves.size() == 1) {
					move.undo();
					return WILL_TIE;
				}
				
				//int winResult = willWin(opp(symbol));
				//moveGrade = Math.min(winResult, moveGrade);
				moveGrade -= willWin(opp(symbol));
				move.undo();
			}
			//return (2 - moveGrade);
			return ((double) moveGrade / evalMoves.size());
		}
		
	}
	
	private static ArrayList<Cell> getEvals() {
		ArrayList<Cell> evalMoves = new ArrayList<Cell>();
		for (Cell move: board) {
			if (move.isEmpty()) {
				evalMoves.add(move);
			}
		}
		return evalMoves;
	}
	
	public static void main(String[] args) {
		board = Cell.getBoard();
		paths = WinPath.getPaths();
		
		
		System.out.println("Would you like to play?");
		String input = kb.nextLine();
		if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
			isPlaying = true;
		}
		else {
			isPlaying = false;
			playedFirst = true;
		}
		if (isPlaying) {
			System.out.println("Would you like to play first?");
			input = kb.nextLine();
			if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
				playedFirst = true;
			}
			else {
				playedFirst = false;
			}
		}
		printBoard();
		
		final char PLAYER1_SYMBOL = playedFirst ? 'X' : 'O';
		final char PLAYER2_SYMBOL = playedFirst ? 'O' : 'X';
		int turn = playedFirst ? 0 : 1;
		while (notOver()) {
			if (turn == 0) {
				if (!isPlaying) {
					System.out.print("(Player 1) ");
				}
				player1(PLAYER1_SYMBOL);
			}
			else {
				System.out.print("(Player 2) ");
				player2(PLAYER2_SYMBOL);
			}
			turn = 1 - turn;
			printBoard();
		}
		if (isPlaying) {
			if (hasWon(PLAYER1_SYMBOL)) {
				System.out.println("The fleshbag has won!");
				System.out.println("YOU WIN!");
			}
			else if (hasWon(PLAYER2_SYMBOL)) {
				System.out.println("The fleshbag has suffered a sudden but inevitable defeat!");
				System.out.println("YOU LOSE!");
			}
			else {
				System.out.println("The fleshbag has staved off defeat... for now.");
				System.out.println("Well met, human.");
				System.out.println("CAT\'S GAME!");
			}
		}
		else {
			if (hasWon(PLAYER1_SYMBOL)) {
				System.out.println("Player 1 has WON... inconceivable!");
			}
			else if (hasWon(PLAYER2_SYMBOL)) {
				System.out.println("Player 2 has WON... inconceivable!");
			}
			else {
				System.out.println("CAT\'S GAME!");
			}
		}
		
		
	}
}
