public class Square {

    private int xcor;
    private int ycor;
    public Piece piece;
    
    public Square(int xcor, int ycor) {
	this.xcor = xcor;
	this.ycor = ycor;
	piece = null;
    }

    public boolean isPieceOn() {
	if (piece == null) {
	    return false;
	}
	return true;
    }

    public void takeSpot(Piece piece) {

	if(this.piece != null) { // if there is a piece on the square
	    // removes current piece on square and replaces it with current piece
	}
	this.piece = piece; // replaces the current piece with the piece selected
    }

    
}