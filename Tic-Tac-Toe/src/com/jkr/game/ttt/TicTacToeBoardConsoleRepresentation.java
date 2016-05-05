package com.jkr.game.ttt;

import com.jkr.game.area.Board;
import com.jkr.game.presentation.AbstractBoardConsoleRepresentation;
import com.jkr.game.presentation.Dictionary;

class TicTacToeBoardConsoleRepresentation extends AbstractBoardConsoleRepresentation<Character>{
	
	protected TicTacToeBoardConsoleRepresentation(Board<Mark> board) {
		super(board, Dictionary.getDictionary(Character.class));
	}

}
