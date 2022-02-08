package pieces;
import game.Player;
import game.Type;


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
	public abstract boolean isPathValid(int finalX, int finalY);
	public abstract Type getType();
}