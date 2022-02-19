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
		int x_difference = Math.abs(finalX - getX());
		int y_difference = Math.abs(finalY - getY());
		if (x_difference == y_difference) {
			return true;}
		else if (x_difference == 0 || y_difference == 0) {
			return true;}
		else return false;
		}

	

	public Type getType() {
		return type;
	}

	public int[][] getPath(int finalX, int finalY) {	//different form for direction logic
		int length;
		int dirX = 0;
		int dirY = 0;
		if(finalX == getX()) {		//purely vertical movement
			length = Math.abs(finalY - getY());
			if(finalY - getY() < 0) {
				dirX = -1;
			}
			else {
				dirY = 1;
			}
		}
		
		else if(finalY == getY()) {		//purely horizontal movement
			length = Math.abs(finalX - getX());
			if(finalX - getX() < 0) {
				dirX = -1;
			}
			else {
				dirY = 1;
			}
		}
		
		else {
			length = Math.abs(finalX - getX());
			if(finalX - getX() > 0) {
				dirX = -1;
			}
			else dirX = 1;
			if(finalY - getY() > 0) {
				dirY = -1;
			}
			else dirX = 1;
		}
		
		int[][] path = new int[2][length];
		
		
	}


}
