import javax.swing.JPanel;

public class Square extends JPanel {
    private boolean status = true; // isFree
    private Piece piece; // the piece on square
    public boolean isActive = false; // true if its clicked
    private int row;
    private int col;
    
    public Square(int row, int col) {
	    this.row = row;
	    this.col = col;
    }
    
    public boolean isFree() {
	return this.status; 
    }
    
    public void setStatus(boolean status) {
	this.status = status;
    }
    
    public Piece getPiece() {
	return this.piece;
    }
    
    public void setPiece(Piece piece) {
	this.piece = piece;
    }
    public void setPosition(int row, int col) {
	this.row = row;
	this.col = col;
    }
    
    public int getRow(){
	return this.row;
    }
    public int getCol() {
	return this.col;
    }
}
