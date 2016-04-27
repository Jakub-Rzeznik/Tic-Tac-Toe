package com.jkr.game.ttt;

import com.jkr.game.execution.GameExecutionException;
import com.jkr.game.execution.TurnBasedGame;
import com.jkr.game.interaction.Player;
import com.jkr.game.setup.MultiplayerGame;

public class TicTacToe implements MultiplayerGame, TurnBasedGame {

	@Override
	public boolean nextTurnForPlayer(Player players) throws GameExecutionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable<?>[] getPlayerDiscriminators() {
		// TODO Auto-generated method stub
		return null;
	}

}
