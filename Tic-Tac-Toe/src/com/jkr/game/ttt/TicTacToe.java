package com.jkr.game.ttt;

import com.jkr.game.area.Board;
import com.jkr.game.execution.TurnBasedBoardGame;
import com.jkr.game.presentation.Presentation;

public class TicTacToe extends TurnBasedBoardGame<Mark, Character> {

	@Override
	public Comparable<?>[] getPlayerDiscriminators() {
		return Mark.values();
	}

	@Override
	public Board<Mark> prepareCleanBoard() {
		return new TicTacToeBoard();
	}

	@Override
	protected Presentation<int[], Character> getPresentation() {
		return new TicTacToeBoardConsoleRepresentation(prepareCleanBoard());
	}

}
