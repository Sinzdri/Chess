package pieces;

import enums.Type;
import game.Player;

public class Bishop extends Piece {
	Type type;

	public Bishop(int x, int y, Player player) {
		super(x, y, player);
		type = Type.BISHOP;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
//		return finalX - x == finalY - y;
		int x_difference = finalX - x;
		int y_difference = finalY - y;
		return x_difference == y_difference;
	}
	

	public Type getType() {
		return type;
	}

}
