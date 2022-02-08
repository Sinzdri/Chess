package pieces;

import game.Player;
import game.Type;

public class Bishop extends Piece {
	Type type;

	public Bishop(int x, int y, Player player) {
		super(x, y, player);
		type = Type.BISHOP;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		return false;
		
	}
	

	public Type getType() {
		return type;
	}

}
