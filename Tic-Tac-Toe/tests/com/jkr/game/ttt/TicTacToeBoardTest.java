package com.jkr.game.ttt;

import static com.jkr.game.ttt.Mark.O;
import static com.jkr.game.ttt.Mark.X;
import static com.jkr.game.ttt.TicTacToeBoardTest.Pair.pair;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TicTacToeBoardTest {
	
	private static Set<Pair> allowedPairs = new HashSet<>();
	static {
		allowedPairs.add(pair(0,0));
		allowedPairs.add(pair(0,1));
		allowedPairs.add(pair(0,2));
		allowedPairs.add(pair(1,0));
		allowedPairs.add(pair(1,1));
		allowedPairs.add(pair(1,2));
		allowedPairs.add(pair(2,0));
		allowedPairs.add(pair(2,1));
		allowedPairs.add(pair(2,2));
	}

	@Test
	public void testValidatingAndPutting() {
		TicTacToeBoard board = new TicTacToeBoard();
		assertTrue(board.canPutMark(1, 1));
		board.putMark(1, 1, Mark.O);
		assertFalse(board.canPutMark(1, 1));
		assertTrue(board.canPutMark(2, 2));
		board.putMark(2, 2, Mark.X);
		assertFalse(board.canPutMark(2, 2));
	}

	@Test
	public void testSuccessfulIsWinCondition() {
		// X row
		testSuccessfulWin(X, pair(0,0), pair(0,1), pair(0,2));
		// O row
		testSuccessfulWin(O, pair(2,0), pair(2,1), pair(2,2));
		// X column
		testSuccessfulWin(X, pair(0, 0), pair(1,0), pair(2,0));
		// O column
		testSuccessfulWin(O, pair(0, 1), pair(1,1), pair(2,1));
		// X slant
		testSuccessfulWin(X, pair(0, 0), pair(1,1), pair(2,2));
		// O slant
		testSuccessfulWin(O, pair(0, 2), pair(1,1), pair(2,0));
	}
	
	@Test
	public void testNotSuccessful() {
		TicTacToeBoard board = createFilledBoard(X, pair(1,0), pair(1,1));
		assertWinForPairs(board);
		board = createFilledBoard(X, Pair.pair(0,0));
		assertWinForPairs(board);
		board = createFilledBoard(O, pair(1,2), pair(0,2));
		assertWinForPairs(board);
		board = createFilledBoard(O, pair(0,0), pair(0,2));
		assertWinForPairs(board);
		board = createFilledBoard(O, pair(0,0), pair(2,2));
		assertWinForPairs(board);
		board = createFilledBoard(X, pair(0,2), pair(2,0));
		assertWinForPairs(board);
		board = createFilledBoard(X, pair(0,2), pair(2,0), pair(0,0), pair(2,2));
		assertWinForPairs(board);
	}
	
	private static TicTacToeBoard createFilledBoard(Mark mark, Pair... pairs) {
		TicTacToeBoard board = new TicTacToeBoard();
		for (Pair pair : pairs) {
			System.out.println("Adding to ("+pair.i+","+pair.j+")");
			board.putMark(pair.i, pair.j, mark);
		}
		return board;
	}
	private static void assertWinForPairs(TicTacToeBoard board, Pair... pairs){
		Set<Pair> clonedAllowedPairs = new HashSet<>(allowedPairs);
		for (Pair pair : pairs) {
			System.out.println("Checking TRUE ("+pair.i+","+pair.j+")");
			assertTrue(board.isWinCondition(pair.i, pair.j));
			clonedAllowedPairs.remove(pair);
		}
		for (Pair pair : clonedAllowedPairs) {
			System.out.println("Checking FALSE ("+pair.i+","+pair.j+")");
			assertFalse(board.isWinCondition(pair.i, pair.j));
		}
		
	}
	private void testSuccessfulWin(Mark mark, Pair... pairs) {
		TicTacToeBoard board = createFilledBoard(mark, pairs);
		assertWinForPairs(board, pairs);
	}
	static final class Pair {
		final int i,j;
		private Pair(int arg0, int arg1) {
			i=arg0;
			j=arg1;
		}
		static Pair pair(int arg0, int arg1) {
			return new Pair(arg0, arg1);
		}
		@Override
		public int hashCode() {
			return i;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof Pair) {
				Pair other = (Pair) obj;
				return (i==other.i) && (j==other.j);
			}
			return false;
		}
	}
}
