package pieces;

import enums.Type;
import game.Player;

public class Rook extends Piece {
	private Type type;

	public Rook(int x, int y, Player player) {
		super(x, y, player);
		type = Type.ROOK;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		if(finalX == getX() || finalY == getY()) {	//as long as only moving in one dimension should be a valid rook move
			return true;
		}
		else return false;
	}
	

	public Type getType() {
		return type;
	}


}
