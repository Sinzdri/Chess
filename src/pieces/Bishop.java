package pieces;

import enums.Type;
import game.Player;

public class Bishop extends Piece {
	private Type type;

	public Bishop(int x, int y, Player player) {
		super(x, y, player);
		type = Type.BISHOP;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
//		return finalX - x == finalY - y;
		int x_difference = Math.abs(finalX - getX());		
		int y_difference = Math.abs(finalY - getY());
		return x_difference == y_difference;
	}
	
	public int[][] getPath(int finalX, int finalY) {
		int dirX = finalX > getX() ? 1 : -1;	// if x is increasing then direction is +1, -1 if reducing
		int dirY = finalY > getY() ? 1 : -1;	// if y is increasing then direction is +1, -1 if reducing
		int [][] path = new int[2][Math.abs(finalX - getX())];	//2d array to store path taken
		for (int i=1; i < Math.abs(finalX - getX()) -1; ++i){	//increments through array for length of path, using directions to calculate path taken
			path[0][i] = getX() + dirX*1;
			path[1][i] = getY() + dirY*1;
		}
		return path;
	}
	

	public Type getType() {
		return type;
	}

}
