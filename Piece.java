public abstract class Piece {

    private int xcor;
    private int ycor;
    private int[] coords;

    public int[] getCoords() {
	return coords;
    }

    public int getX() {
	return xcor;
    }

    public int getY() {
	return ycor;
    }
    
    public void move();
}
