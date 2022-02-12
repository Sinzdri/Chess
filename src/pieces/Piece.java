package pieces;
import enums.Type;
import game.Player;

//establish abstract piece class that all pieces will inherit from, every piece should have an integer location (x,y) and be associated with a player.
public abstract class Piece {
	private int x, y;
	private Player player;

	//constructor
	public Piece(int x, int y, Player player) {
		this.setX(x);
		this.setY(y);
		this.setPlayer(player);
	}
	
	//methods
	public abstract boolean isPathValid(int finalX, int finalY); //method to determine if piece can make the move
	public abstract Type getType(); //method to get piece type

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}