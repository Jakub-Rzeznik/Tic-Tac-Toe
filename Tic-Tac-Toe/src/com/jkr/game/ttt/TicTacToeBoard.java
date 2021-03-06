package com.jkr.game.ttt;

import com.jkr.game.area.Board;

class TicTacToeBoard implements Board<Mark> {
	
	private final Mark[][] board = new Mark[3][3];

	TicTacToeBoard() {}
	
	public boolean canPutMark(int i, int j) {
		return (board[i][j] == null);
	}
	
	public void putMark(int i, int j, Mark mark) {
		board[i][j] = mark;
	}
	
	public boolean isWinConditionMet(int i, int j) {
		return (board[i][j]!=null) && (checkRow(i) || checkColumn(j) || (i-j==0 && checkForwardSlant()) || (i+j==2 && checkBackwardSlant()));
	}
	
	public boolean isFullyFilled() {
		for (Mark[] marks : board) {
			for (Mark mark : marks) {
				if (mark == null) {
					return false;
				}
			}
		}
		return true;
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

	@Override
	public int getWidth() {
		return 3;
	}

	@Override
	public int getHeight() {
		return 3;
	}
	
	@Override
	public Mark[][] getBoardState() {
		return board.clone();
	}

}
