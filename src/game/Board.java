package game;

import java.util.ArrayList;

import pieces.*;

public class Board {
	public int height, width;
	public Piece[][] boardArray;	// a two-dimensional array to track pieces
	public Game game;
	public ArrayList<Piece> whitePieces = new ArrayList<Piece>(16);	//arraylist of each colours pieces, starting size 16, depending on future usage could be single arraylist
	public ArrayList<Piece> blackPieces = new ArrayList<Piece>(16);
	
	
	public Board(int height, int width, Game game) {
		this.height = height;
		this.width = width;
		this.game = game;
		boardArray = new Piece[height][width];
	}
	
	public void setBoard() {
		createPlayer1Pieces();
		createPlayer2Pieces();
		placePieces();
	}
	public void createPlayer1Pieces() {
		for(int i=0; i <= 7; i++) {
			whitePieces.add(new Pawn(i, 1, this.game.player1));
		}
		
		whitePieces.add(new King(4, 0, this.game.player1));
		whitePieces.add(new Queen(3, 0, this.game.player1));
		whitePieces.add(new Rook(0, 0, this.game.player1));
		whitePieces.add(new Rook(7, 0, this.game.player1));
		whitePieces.add(new Knight(1, 0, this.game.player1));
		whitePieces.add(new Knight(6, 0, this.game.player1));
		whitePieces.add(new Bishop(2, 0, this.game.player1));
		whitePieces.add(new Bishop(5, 0, this.game.player1));
		
	}
	public void createPlayer2Pieces() {
		for(int i=0; i <= 7; i++) {
			blackPieces.add(new Pawn(i, 6, this.game.player1));
		}
		
		blackPieces.add(new King(3, 7, this.game.player1));
		blackPieces.add(new Queen(4, 7, this.game.player1));
		blackPieces.add(new Rook(0, 7, this.game.player1));
		blackPieces.add(new Rook(7, 7, this.game.player1));
		blackPieces.add(new Knight(1, 7, this.game.player1));
		blackPieces.add(new Knight(6, 7, this.game.player1));
		blackPieces.add(new Bishop(2, 7, this.game.player1));
		blackPieces.add(new Bishop(5, 7, this.game.player1));
		
		
	}
	
    public void placePieces()
    {
        for(Piece p : whitePieces) {
        	boardArray[p.x][p.y] = p;	//should replace with methods rather than direct call
        }
        for(Piece p : blackPieces) {
        	boardArray[p.x][p.y] = p;	//should replace with methods rather than direct call
        }


    }
	
	public void movePiece(Piece piece, int finalX, int finalY) {
		if(isMoveValid(piece, finalX, finalY) && piece.isPathValid(finalX, finalY)) {
			
		}
	}
	
	//use to check validity of move in general regardless of piece type (in the board etc.), need to expand (break into seperate methods) to also cover if destination is the same as origin
	//and if destination is occupied (if friendly piece not valid if enemy need capture method).
	public boolean isMoveValid(Piece piece, int finalX, int finalY) {	
		if((0 <= finalX && finalX < width) && (0 <= finalY && finalY < height)) {
			return true;
		}
		else return false;
	}
}
