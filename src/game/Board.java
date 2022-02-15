package game;

import java.util.ArrayList;

import enums.Type;
import pieces.*;

public class Board {
	private int height, width;
	private Piece[][] boardArray;	// a two-dimensional array to track pieces
	private Game game;
	private ArrayList<Piece> whitePieces = new ArrayList<Piece>(16);	//arraylist of each colours pieces, starting size 16, depending on future usage could be single arraylist
	private ArrayList<Piece> blackPieces = new ArrayList<Piece>(16);
	
	//Board Constructor
	public Board(int height, int width, Game game) {
		this.height = height;
		this.width = width;
		this.game = game;
		boardArray = new Piece[height][width];
	}
	//Board methods
	public void setBoard() {	//setBoard maybe not best naming choice (confusion with setters)?
		createPlayer1Pieces();
		createPlayer2Pieces();
		placePieces();
	}
	//Method to create white pieces and add them to their arraylist
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
	//Method to create black pieces and add them to their arraylist.
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

	//Method that uses the arraylists of pieces to populate the 2 dimension board array
    public void placePieces()
    {
        for(Piece p : whitePieces) {
        	boardArray[p.getX()][p.getY()] = p;	
        }
        for(Piece p : blackPieces) {
        	boardArray[p.getX()][p.getY()] = p;	
        }
        whitePieces.clear();
        blackPieces.clear();
        //clear arraylists to use to store captured pieces

    }
	
    //Piece moving methods below (Maybe split into own class)
    //Combined method that checks if move is valid for generic piece, and then if path is valid for that specific piece. 
    //Todo sort out movement path logic, currently no checks about moving through pieces.
	public void movePiece(Piece piece, int finalX, int finalY) {
		if(isMoveValid(piece, finalX, finalY) && piece.isPathValid(finalX, finalY)) {
			isCapture(piece, finalX, finalY);
			
			setNewPosition(piece, finalX, finalY);
		}
	}
	

	//use to check validity of move in general regardless of piece type (in the board etc.), need to expand (break into seperate methods) to also cover if destination is the same as origin
	//and if destination is occupied (if friendly piece not valid if enemy need capture method).
	public boolean isMoveValid(Piece piece, int finalX, int finalY) {	
		if((isOnBoard(piece, finalX, finalY)) && (isActuallyMoved(piece, finalX, finalY)) && (isNotFriend(piece, finalX, finalY))) {
			return true;
		}
		else return false;
	}
	
	//method to check not moving into occupied friendly space
	public boolean isNotFriend(Piece piece, int finalX, int finalY) {
		if (piece.getPlayer() == this.game.player1) {
		if (boardArray[piece.getX()][piece.getY()] != null) {
			if (boardArray[piece.getX()][piece.getY()].getPlayer().equals(this.game.player1)){
				return false;
			}
			else return true;
		}
		else if (piece.getPlayer() == this.game.player1) {
		if (boardArray[piece.getX()][piece.getY()] != null) {
			if (boardArray[piece.getX()][piece.getY()].getPlayer().equals(this.game.player1)){
				return false;
			}
			else return true;
		}
		else return true;
		}
		}
		return true;
	}
	
	//method to check not leaving confines of the board
	public boolean isOnBoard(Piece piece, int finalX, int finalY) {	
		if((0 <= finalX && finalX < width) && (0 <= finalY && finalY < height)) {
			return true;
		}
		else return false;
	}
	//method to check actually changing location
	public boolean isActuallyMoved(Piece piece, int finalX, int finalY) {
		if((finalX == piece.getX()) && (finalY == piece.getY())) {
			return true;
		}
		else return false;
	}
	
	//method to check if capturing a piece or not
	public boolean isCapture(Piece piece, int finalX, int finalY) {
		if(boardArray[finalX][finalY] != null && boardArray[finalX][finalY].getPlayer() != piece.getPlayer()) {
			if(boardArray[finalX][finalY].getType() == Type.KING)
				boardArray[finalX][finalY].getPlayer().hasLost = true; //If we are actually capturing a piece then if it is the king that player has lost
			storeCaptured(finalX, finalY);	//stores the captured piece to that colours arraylist
			return true;
		}
		else return false;
	}
	
	//method to change position of a piece
	public void setNewPosition(Piece piece, int finalX, int finalY) {
		int originX = piece.getX();
		int originY = piece.getY();
		piece.setX(finalX); 
		piece.setY(finalY);
		boardArray[finalX][finalY] = piece;			
		boardArray[originX][originY] = null;	
	}
	
	//method to store captured pieces in arraylist
	public void storeCaptured(int finalX, int finalY) {
		if (boardArray[finalX][finalY].getPlayer() == this.game.player1) {
			whitePieces.add(boardArray[finalX][finalY]);
		}
		if (boardArray[finalX][finalY].getPlayer() == this.game.player2) {
			blackPieces.add(boardArray[finalX][finalY]);
		}
	}
	
	//method to check movement path is empty
	public boolean isPathClear(Piece piece, int finalX, int finalY) {
		
	}
	
	//boardarray getter
	public Piece[][] getBoardArray() {
		return boardArray;
	}
	
}
