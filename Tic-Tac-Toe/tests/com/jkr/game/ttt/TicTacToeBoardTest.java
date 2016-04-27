package com.jkr.game.ttt;

import static com.jkr.game.ttt.Mark.O;
import static com.jkr.game.ttt.Mark.X;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class TicTacToeBoardTest {
	
	private static Set<int[]> allowedPairs = Arrays.stream(new int[][]{{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}}).collect(Collectors.toSet());

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
		board = createFilledBoard(X, pair(0,0));
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
	
	private static int[] pair(int i, int j) {
		return new int[] {i,j};
	}
	private static TicTacToeBoard createFilledBoard(Mark mark, int[]... pairs) {
		TicTacToeBoard board = new TicTacToeBoard();
		for (int[] pair : pairs) {
			System.out.println("Adding to ("+pair[0]+","+pair[1]+")");
			board.putMark(pair[0], pair[1], mark);
		}
		return board;
	}
	private static void assertWinForPairs(TicTacToeBoard board, int[]... pairs){
		Set<int[]> clonedAllowedPairs = new HashSet<>(allowedPairs);
		for (int[] pair : pairs) {
			System.out.println("Checking TRUE ("+pair[0]+","+pair[1]+")");
			assertTrue(board.isWinCondition(pair[0], pair[1]));
			clonedAllowedPairs.remove(pair);
		}
		for (int[] pair : clonedAllowedPairs) {
			System.out.println("Checking FALSE ("+pair[0]+","+pair[1]+")");
			assertFalse(board.isWinCondition(pair[0], pair[1]));
		}
		
	}
	private void testSuccessfulWin(Mark mark, int[]... pairs) {
		TicTacToeBoard board = createFilledBoard(mark, pairs);
		assertWinForPairs(board, pairs);
	}
}
