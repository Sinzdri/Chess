package tests;


import static org.junit.Assert.assertEquals;

import org.junit.*;

import game.Game;
import pieces.Bishop;
import pieces.Piece;

public class BishopTests {

	@Test
	public void move() {
		Game game = new Game();
		Piece bishop = new Bishop(4,4, game.player2);
				
		game.gameBoard.movePiece(bishop, 3, 3);
		assertEquals(bishop, game.gameBoard.getBoardArray()[3][3]);
				
	}
	
	
	
}
