package game;

import enums.Colour;

public class Game {	//need to define everything needed for an instance of a game of chess (players, board, turn)
	public Player player1, player2;
	public Board gameBoard;
	public int turn;
	//todo might need something like boolean to account for game "state" (eg invalid moves or piece capturing)
	
public Game() {
	setupGame();
}


public void setupGame() {
	setupPlayers(); //setup the players
	gameBoard = new Board(8,8, this); //setup a game with players and chess board
	gameBoard.setBoard(); //should setup pieces
	turn = 1;
}

//public void testsetupGame() {
//	setupPlayers(); //setup the players
//	gameBoard = new Board(8,8, this); //setup a game with players and chess board
//	//gameBoard.setBoard(); don't want to set up pieces for any tests, will manually add pieces.
//	turn = 1;
//}

public void setupPlayers() {
	player1 = new Player(Colour.WHITE, true); //white player goes first
	player2 = new Player(Colour.BLACK, false);
	player1.playerGame = this;
	player2.playerGame = this;
}
}
