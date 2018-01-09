public abstract class Piece {

    private int xcor;
    private int ycor;
    private boolean isWhite;
    //If isWhite is false, of course, then it's black.
    private int[] coords;

    public Piece(int xcor, int ycor) {
	this.xcor = xcor;
	this.ycor = ycor;
    }
    
    public int[] getCoords() {
	return coords;
    }

    public int getX() {
	return xcor;
    }

    public int getY() {
	return ycor;
    }
    
    public abstract void move();
    /* CSDOJO NOTES:
Probably can't have move method because it doesn't say which square I can go to.
Have a legal moves */
    public abstract Square[] getLegalMoves();
    public abstract void capture();
}
