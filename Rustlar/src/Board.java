
import java.util.*;

public class Board {
	private Cell [][] board;
	
	/**
	 * The public Board() constructor of the board class creates a board
	 * with full of null objects, and adds a few arbitrary pieces to the 
	 * board.  
	 */
	public Board(){
		
		board = new Cell[7][7]; //initializes board
		//this for loop interates through board and fills it with null objects
		
	}
	/**
	 * The second constructor public Board(Board b) constructs a new board object based on an existing board.
	 * 
	 * This is used to copy the board to be copied when the Minimax AI is computing future moves.  
	 * 
	 * @param b
	 */
	public Board(Board b){
		board = new Cell[7][7]; //initializes board
		//this for loop interates through board and fills it with null objects
		for(int i = 0; i<7; i++){
			for(int j = 0; j<7; j++){
				board[i][j] = null;
			}
		}
		/*
		 * This loop iterates through the board passed as a parameter,
		 * and for each piece found in the board, a piece of the same color
		 * and type is added to the new board object.
		 */
		for(int i = 0; i<7; i++){
			for(int j=0; j<7; j++){
				if(b.hasPiece(i,j)){
					if(b.getSquare(i, j).getPiece().getColor() == 0){ //case that piece is white
						if(b.getSquare(i, j).getPiece() instanceof Rider){
							board[i][j] = new Cell(i, j, new Rider("WR1", "White_Pawn.png", 0));
						}else if(b.getSquare(i,j).getPiece() instanceof Horse){
							board[i][j] = new Cell(i, j, new Horse("WH", "White_Horse.png", 0));
						}
					}else{ //case that piece is black
						if(b.getSquare(i, j).getPiece() instanceof Rider){
							board[i][j] = new Cell(i, j, new Rider("BR1", "Black_Pawn.png", 1));
						}else if(b.getSquare(i,j).getPiece() instanceof Horse){
							board[i][j] = new Cell(i, j, new Horse("BH", "Black_Horse.png", 1));
						}
					}
				}
			}
		}
	}

	/**
	 * the getSquare(int row, int col) returns whatever piece is on a given square given a row and column.
	 * 
	 * @param row
	 * @param col
	 * @return piece on the given square
	 */
	public Cell getSquare(int row, int col){
		return board[row][col];
	}
	
	/**
	 * the setSquare(int row, int col, Piece piece) method adds a given piece to the board, also given a row
	 * and column to put the piece.
	 * 
	 * @param row
	 * @param col
	 * @param piece
	 */
	public void setSquare(int row, int col, Piece piece){
		board[row][col].setPiece(piece);
	}
	/**
	 * The clearSquare(int row, int col) method sets a given square to null
	 * @param row
	 * @param col
	 */
	public void clearSquare(int row, int col){
		board[row][col] = null;
	}
	
	/**
	 * The hasPiece(int row, int col) method checks if a square has a piece given a row or column
	 * 
	 * @param row
	 * @param col
	 * @return boolean, true if a square has a piece, false if the square has no piece
	 */
	public boolean hasPiece(int row, int col){
		if(getSquare(row,col) != null){
			return true;
		}else{
			return false;
		}
	}
	
}
