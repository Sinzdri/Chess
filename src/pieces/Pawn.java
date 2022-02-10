package pieces;

import enums.Type;
import game.Player;

public class Pawn extends Piece {	//todo, maybe break up valid path and have methods for each type of conditional movement a pawn would make.
	Type type;
	boolean hasMoved = false;	//will need a method to track if pawn has moved since needed for double move 

	public Pawn(int x, int y, Player player) {
		super(x, y, player);
		type = Type.PAWN;
	}
	
	public boolean isPathValid(int finalX, int finalY) {
		int x_difference = finalX - x;
		int y_difference = finalY - y;
		boolean enemyPresent = false;	//temporary boolean, will need method to determine if enemy piece is present or not
		if (y_difference == 1) {
			return true;
		}
		else if (y_difference == 2 && hasMoved == false) {	//if has not moved can move twice
			return true;
		}
		else if (x_difference == 1 && y_difference == 1 && enemyPresent == true) {
			return true;
		}
		else return false;
		
		
	}
	

	public Type getType() {
		return type;
	}


}
