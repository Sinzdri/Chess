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
		int x_difference = finalX - getX();
		int y_difference = finalY - getY();
		return x_difference == y_difference;
	}
	

	public Type getType() {
		return type;
	}

}
