package com.jkr.game.ttt;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.jkr.game.setup.AbstractMultiplayerGameTest;
import com.jkr.game.setup.MultiplayerGame;

@SuppressWarnings("all")
public class TicTacToeTest extends AbstractMultiplayerGameTest {

	@Test
	public void testGetPlayerDiscriminators() {
		Comparable[] discriminators = getTestedInstance().getPlayerDiscriminators();
		assertEquals(2, discriminators.length);
		Set<Comparable> set = Stream.of(discriminators).collect(Collectors.toSet());
		for (Mark mark : Mark.values()) {
			assertTrue("Missing mark : " + String.valueOf(mark), set.contains(mark));
		}
	}

	@Override
	protected MultiplayerGame getTestedInstance() {
		return new TicTacToe();
	}

}
