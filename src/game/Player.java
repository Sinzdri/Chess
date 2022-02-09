package game;

import enums.Colour;

public class Player {	//define everything needed for a player in the game
	public Colour playerColour;
	public boolean isTurn = false; //default to not their turn
	public boolean hasLost = false; //default to not having lost
	public boolean goesFirst; //could have tied to colour?
	public Game playerGame; //
	
	
	//construct player, should only need colour and whether they go first or not
	public Player(Colour playerColour, boolean goesFirst) {
		this.playerColour = playerColour;
		this.goesFirst = goesFirst;
	}
	
	public void getOwnPieces() {
		//todo, might want method to create a list of pieces "belonging" to the player.
	}
	
	public void getEnemyPieces() {
		//todo, might want method to create a list of pieces "belonging" to the enemy player.
	}
	
	
}
