public abstract class Piece {

    private int xcor;
    private int ycor;
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
}
