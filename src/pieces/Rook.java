package pieces;

import enums.Type;
import game.Player;

public class Rook extends Piece {
	Type type;

	public Rook(int x, int y, Player player) {
		super(x, y, player);
		type = Type.ROOK;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		return false;
		
	}
	

	public Type getType() {
		return type;
	}


}
