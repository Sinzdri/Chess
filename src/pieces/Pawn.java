package pieces;

import enums.Type;
import game.Player;

public class Pawn extends Piece {
	Type type;

	public Pawn(int x, int y, Player player) {
		super(x, y, player);
		type = Type.PAWN;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		return false;
		
	}
	

	public Type getType() {
		return type;
	}


}
