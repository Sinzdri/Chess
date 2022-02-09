package pieces;

import enums.Type;
import game.Player;

public class Queen extends Piece {
	Type type;

	public Queen(int x, int y, Player player) {
		super(x, y, player);
		type = Type.QUEEN;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		return false;
		
	}
	

	public Type getType() {
		return type;
	}


}
