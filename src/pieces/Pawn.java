package pieces;

import enums.Colour;
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
		
		boolean rightDirection = rightDirection(finalX, finalY);
		boolean enemyPresent = enemyPresent(finalX, finalY);	
		if (y_difference == 1 && x_difference == 0 && enemyPresent == false && rightDirection == true) {
			return true;
		}
		else if (y_difference == 2 && x_difference == 0 && getMoved() == false && enemyPresent == false && rightDirection == true ) {	//if has not moved can move twice
			return true;
		}
		else if (x_difference == 1 && y_difference == 1 && enemyPresent == true && rightDirection == true) {
			return true;
		}
		else return false;
		
		
	}
	
	//method to determine if pawn is moving in the right direction
	public boolean rightDirection(int finalX, int finalY) {
		int y_difference = finalY - getY();
		
		if((this.getPlayer().playerColour == Colour.WHITE && y_difference > 0)
			|| (this.getPlayer().playerColour == Colour.BLACK && y_difference < 0)) {
			return true;
		}
		return false;
	}
	
	//method to determine if enemy is present on destination
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
		int length = Math.abs(finalY - getY());
		int dirX = 0;
		int dirY = 0;
		int[][] path = new int [2][length];
		
		if(finalY - getY() < 0) {
			dirY = -1;
		}
		else {
			dirY = 1;
		}
		
		while (length > 0) {
			for(int i = 0; i < length - 1; i++) {
				path[0][i] = getX() + dirX*1;
				path[1][i] = getY() + dirY*1;
			}
		}
		return path;
		//todo, since only has a path in circumstances of double move forward maybe alternative check in only those circumstances and avoid calling path for pawn?
				
	}


}
