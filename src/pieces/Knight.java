package pieces;

import enums.Type;
import game.Player;

public class Knight extends Piece {
	Type type;

	public Knight(int x, int y, Player player) {
		super(x, y, player);
		type = Type.KNIGHT;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		int x_difference = finalX - x;
		int y_difference = finalY - y;
		if ((x_difference == 1 && y_difference == 2) || (y_difference == 1 && x_difference == 2)){	//should be valid move as long as moving in "L" shape
			return true;
			}
		else return false;		
	}
	

	public Type getType() {
		return type;
	}


}
