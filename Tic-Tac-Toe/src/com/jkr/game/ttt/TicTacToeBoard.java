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
		return true;
	}
	
	private void assertCoordinates(int i, int j) throws IndexOutOfBoundsException {
		
	}

}
