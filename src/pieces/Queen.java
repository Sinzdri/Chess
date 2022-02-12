package pieces;

import enums.Type;
import game.Player;

public class Queen extends Piece {
	private Type type;

	public Queen(int x, int y, Player player) {
		super(x, y, player);
		type = Type.QUEEN;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		int x_difference = finalX - getX();
		int y_difference = finalY - getY();
		if (x_difference == y_difference) {
			return true;}
		else if (x_difference == 0 || y_difference == 0) {
			return true;}
		else return false;
		}

	

	public Type getType() {
		return type;
	}


}
