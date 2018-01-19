import javax.swing.JPanel;

public class Square extends JPanel{
	private boolean status; //Necessary for isFree
	private Piece piece;
	public boolean isActivated;
	private int row;
	private int col;
	
	//Assumes no piece is on it:
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		piece = null;
		status = true;
		isActivated = false;
	}
	
	//Assumes a piece is on it:
	public Square(int row, int col, Piece piece) {
		this.row = row;
		this.col = col;
		this.piece = piece;
		status = true;
		isActivated = false;
	}
	
	//Getters/Setters:
	public boolean isFree() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Piece getPiece() {
		return piece;
	}
	public void updatePosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
}