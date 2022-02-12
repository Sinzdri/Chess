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
		int x_difference = finalX - getX();
		int y_difference = finalY - getY();
		if (x_difference <= 1 && y_difference <=1 ) {
			return true;}
		else return false;
		
		
	}
	

	public Type getType() {
		return type;
	}


}
