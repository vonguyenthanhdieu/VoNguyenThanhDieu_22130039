package Lap5;

public class TicTacToeGame {
	private static final char EMPTY= ' ';
	
	private char[][] board;
	public TicTacToeGame(char[][] board) {
		this.board= board;
	}
	
	public void TicTacToeCheck() {
		if (checkRows()== false && checkColumns()== false
				&& checkDiagonals()== false){
			System.out.println("game over");
		}
	}
	
	/*
	* This method checks all rows and returns true if any of 
	them are marked with
	* all of a single player's markers.
	* Otherwise, returns false.
	*/
	public boolean checkRows() {
		for (int i=0; i< 3; i++) {
			if (board[i][0]!= EMPTY && board[i][0]== board[i][1]
					&& board[i][1] == board[i][2]) {
				System.out.println(board[i][0]+ " win");
				return true;
			}
		}
		return false;
	}
	
	/*
	* This method checks all columns and returns true if any 
	of them are marked
	* with all of a single player's.
	* Otherwise, returns false.
	*/
	public boolean checkColumns() {
		for (int i=0; i< 3; i++) {
			if (board[0][i]!= EMPTY && board[0][i]== board[1][i]
					&& board[1][i] == board[2][i]) {
				System.out.println(board[0][i]+ " win");
				return true;
			}
		}
		return false;
	}
	
	/*
	* This method checks both diagonals and returns true if 
	any of them are marked
	* with all of a single player's markers. Otherwise, 
	returns false.
	*/
	public  boolean checkDiagonals() {
		// Check top-left to bottom-right
		if (board[0][2]!= EMPTY && board[0][2]==board[1][1]
				&& board[1][1]==board[2][0]){
			System.out.println(board[0][2]+ " win");
			return true;
		}
			
		// Check bottom-left to top-right
		if (board[0][0]!= EMPTY && board[0][0]==board[1][1]
				&& board[1][1]==board[2][2]){
			System.out.println(board[0][0]+ " win");
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X'},
				{' ', 'O', ' '},
				{'O', 'X', 'O'}};
		TicTacToeGame tictactoe = new TicTacToeGame(board);
		tictactoe.TicTacToeCheck();
		
		char[][] board1 = {{'O', 'X', 'X'},
				{' ', 'O', 'X'},
				{'O', ' ', 'X'}};
		TicTacToeGame tictactoe1 = new TicTacToeGame(board1);
		tictactoe1.TicTacToeCheck();
		
		char[][] board2 = {{'X', 'X', 'O'},
				{'X', 'O', ' '},
				{'O', ' ', ' '}};
		TicTacToeGame tictactoe2 = new TicTacToeGame(board2);
		tictactoe2.TicTacToeCheck();
	}
}
