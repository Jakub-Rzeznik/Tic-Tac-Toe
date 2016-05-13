package com.jkr.game.ttt;

import com.jkr.game.area.Board;
import com.jkr.game.execution.TurnBasedBoardGame;
import com.jkr.game.presentation.Presentation;
import com.jkr.game.setup.MultiplayerGame;

public class TicTacToe extends TurnBasedBoardGame<Mark, Character> implements MultiplayerGame<Mark, Character> {

	@Override
	public Board<Mark> prepareCleanBoard() {
		return new TicTacToeBoard();
	}

	@Override
	protected Presentation<int[], Character> getPresentation() {
		return new TicTacToeBoardConsoleRepresentation(prepareCleanBoard());
	}

	@Override
	public Mark[] getPlayerDiscriminators() {
		return Mark.values();
	}

}
