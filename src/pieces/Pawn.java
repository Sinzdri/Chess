package pieces;

import enums.Type;
import game.Player;

public class Pawn extends Piece {	//todo, maybe break up valid path and have methods for each type of conditional movement a pawn would make.
	private Type type;
//	boolean hasMoved = false;	//will need a method to track if pawn has moved since needed for double move (probably just have boolean change in move method).

	public Pawn(int x, int y, Player player) {
		super(x, y, player);
		type = Type.PAWN;
	}
	
	//method to determine if pawn move is valid
	public boolean isPathValid(int finalX, int finalY) {

		int x_difference = Math.abs(finalX - getX());
		int y_difference = Math.abs(finalY - getY());
		
		boolean enemyPresent = enemyPresent(finalX, finalY);	
		if (y_difference == 1 && x_difference == 0 && enemyPresent == false) {
			return true;
		}
		else if (y_difference == 2 && x_difference == 0 && getMoved() == false && enemyPresent == false) {	//if has not moved can move twice
			return true;
		}
		else if (x_difference == 1 && y_difference == 1 && enemyPresent == true) {
			return true;
		}
		else return false;
		
		
	}
	
	public boolean enemyPresent(int finalX, int finalY) {	//shouldn't need to worry about friendly present as already checked with generic move check
		Piece[][] board = this.getPlayer().playerGame.gameBoard.getBoardArray();
		if(board[finalX][finalY] == null) {
			return false;
		}
		else return true;
	}
	

	

	public Type getType() {
		return type;
	}

	public int[][] getPath(int finalX, int finalY) {
		return null;	//todo
	}


}
