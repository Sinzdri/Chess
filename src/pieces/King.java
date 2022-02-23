package pieces;

import enums.Type;
import game.Player;

public class King extends Piece {
	private Type type;

	public King(int x, int y, Player player) {
		super(x, y, player);
		type = Type.KING;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		int x_difference = Math.abs(finalX - getX());
		int y_difference = Math.abs(finalY - getY());
		if (x_difference <= 1 && y_difference <=1 ) {
			return true;}
		else return false;
		
		
	}
	

	public Type getType() {
		return type;
	}

	public int[][] getPath(int finalX, int finalY) {
		int length = 0;	//should never leave a path as only moves one space
		return new int[2][length];	
	}


}
