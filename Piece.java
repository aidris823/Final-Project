public abstract class Piece{
    private int xcor;
    private int ycor;
    private boolean isWhite;
    //If isWhite is false, of course, then it's black.
    private int[] coords;
    private Square squareCurrentlyOn;

    public Piece(int xcor, int ycor) {
	this.xcor = xcor;
	this.ycor = ycor;
	squareCurrentlyOn = new Square(xcor,ycor);
    }
    public Piece(int xcor, int ycor
    public int[] getCoords() {
	return coords;
    }
    public int getX() {
	return xcor;
    }

    public int getY() {
	return ycor;
    }
    public void updateCoordinates(int xcor, int ycor){
	squareCurrentlyOn = new Square(xcor,ycor);
    }
    
    //Returns an array of legal moves that a piece has.
    public abstract Square[] getLegalMoves();
    public boolean isInsideBounds(int row, int col){
	if (row < 0 || row > 7 || col > 0 || col < 7){
	    return false;
	}
	return true;
    }
    //No setter for color since pieces don't switch color midgame.
    //Getter:
    public boolean getIsWhite(){
	return isWhite;
    }
    
}
