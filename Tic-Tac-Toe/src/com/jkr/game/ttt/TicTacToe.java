package com.jkr.game.ttt;

import com.jkr.game.area.Board;
import com.jkr.game.execution.TurnBasedBoardGame;
import com.jkr.game.presentation.ConsoleBoardRepresentation;
import com.jkr.game.presentation.Dictionary;
import com.jkr.game.presentation.Presentation;
import com.jkr.game.setup.MultiplayerGame;

public class TicTacToe extends TurnBasedBoardGame<Mark, Character> implements MultiplayerGame<Mark, Character> {

	@Override
	public Board<Mark> prepareCleanBoard() {
		return new TicTacToeBoard();
	}

	@Override
	protected Presentation<int[], Character> getPresentation() {
		return new ConsoleBoardRepresentation<>(prepareCleanBoard(), Dictionary.getDictionary(Character.class));
	}

	@Override
	public Mark[] getPlayerDiscriminators() {
		return Mark.values();
	}

}
