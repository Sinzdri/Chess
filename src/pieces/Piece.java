package pieces;
import enums.Type;
import game.Player;

//establish abstract piece class that all pieces will inherit from, every piece should have an integer location (x,y) and be associated with a player.
public abstract class Piece {
	public int x, y;
	public Player player;

	//constructor
	public Piece(int x, int y, Player player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	//methods
	public abstract boolean isPathValid(int finalX, int finalY); //method to determine if piece can make the move
	public abstract Type getType(); //method to get piece type
}