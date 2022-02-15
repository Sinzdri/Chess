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
	
	public boolean getPath(int x, int y, int finalX, int finalY) {
		int dirX = finalX > x ? 1 : -1;	// if x is increasing then directions is +1, -1 if reducing
		int dirY = finalY > y ? 1 : -1;	// if y is increasing then directions is +1, -1 if reducing
		for (int i=1; i < Math.abs(finalX - x) -1; ++i){
			
		}
	}
	

	public Type getType() {
		return type;
	}

}
