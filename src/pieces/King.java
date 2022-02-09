package pieces;

import enums.Type;
import game.Player;

public class King extends Piece {
	Type type;

	public King(int x, int y, Player player) {
		super(x, y, player);
		type = Type.KING;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		return false;
		
	}
	

	public Type getType() {
		return type;
	}


}
