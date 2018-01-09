public abstract class Piece {

    private int xcor;
    private int ycor;
    private int[] coords;
    private boolean isCaptured;
    private String type;

    public Piece(int xcor, int ycor, String type) {
	this.xcor = xcor;
	this.ycor = ycor;
	this.type = type;
	isCaptured = false;
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

    public boolean getStatus() {
	return isCaptured;
    }
    
    public abstract void move();
    public abstract void capture();
}
