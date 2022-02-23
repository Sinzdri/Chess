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

	public int[][] getPath(int finalX, int finalY) {
		int length;
		int dirX = 0;
		int dirY = 0;
		
		if(finalX == getX()) {		//vertical movement
			length = Math.abs(finalY - getY());
			if(finalY - getY() < 0) {
				dirX = -1;
			}
			else {
				dirY = 1;
			}
		}
		
		else {		//horizontal movement
			length = Math.abs(finalX - getX());
			if(finalX - getX() < 0) {
				dirX = -1;
			}
			else {
				dirY = 1;
			}
		}
		
		
		int[][] path = new int[2][length];
		
		while (length > 0) {
			for(int i = 0; i < length - 1; i++) {
				path[0][i] = getX() + dirX*1;
				path[1][i] = getY() + dirY*1;
			}
		}
		return path;
	}


}
