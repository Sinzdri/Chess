package game;

import pieces.*;

public class Board {
	public int height, width;
	public Game game;
	
	
	public Board(int height, int width, Game game) {
		this.height = height;
		this.width = width;
		this.game = game;
	}
	
	public void createPieces() {
//todo, perhaps establish methods for create each players pieces and "placing" them on the board that are then called by this method
	}
	public void createPlayer1Pieces() {
		Piece king = new King(4, 0, this.game.player1);
	}
	public void createPlayer2Pieces() {
		
	}
	
}
