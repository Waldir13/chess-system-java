package boardgame;

public class Board {
	
	private int rowns;
	private int columns;
	private Piece [][] pieces;
	
	
	public Board(int rowns, int columns) {
		
		if(rowns < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		
		this.rowns = rowns;
		this.columns = columns;
		pieces = new Piece[rowns] [columns];
	}


	public int getRowns() {
		return rowns;
	}

	
	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row] [column];
	}
	
	public Piece piece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()] [position.getColumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()] [position.getColumn()] = piece;
		piece.position = position;		
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rowns && column >= 0 && column < columns;		
	}
	
	private boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	private boolean thereIsAPiece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null;
	}
	
	
	

}
