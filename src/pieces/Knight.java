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
		return false;
		
	}
	

	public Type getType() {
		return type;
	}


}
