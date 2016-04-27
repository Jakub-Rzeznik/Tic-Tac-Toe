package com.jkr.game.ttt;

class TicTacToeBoard {
	
	private final Mark[][] board = new Mark[3][3];

	boolean canPutMark(int i, int j) {
		return (board[i][j] == null);
	}
	
	void putMark(int i, int j, Mark mark) {
		board[i][j] = mark;
	}
	
	boolean isWinCondition(int i, int j) {
		return (board[i][j]!=null) && (checkRow(i) || checkColumn(j) || (i-j==0 && checkForwardSlant()) || (i+j==2 && checkBackwardSlant()));
	}
	
	private boolean checkRow(int i) {
		return (board[i][0]==board[i][1]) && (board[i][1]==board[i][2]);
	}
	
	private boolean checkColumn(int j) {
		return (board[0][j]==board[1][j]) && (board[1][j]==board[2][j]);
	}
	
	private boolean checkForwardSlant() {
		return (board[0][0]==board[1][1]) && (board[1][1]==board[2][2]);
	}
	
	private boolean checkBackwardSlant() {
		return (board[0][2]==board[1][1]) && (board[1][1]==board[2][0]);
	}

}
