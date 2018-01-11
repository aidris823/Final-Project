public abstract class Piece {

    public static final int BLACK;
    public static final int WHITE;
    private int color;
    private Location loc;
    
    public Piece(char col, int row, int color) {
	if (col < 'a' || col > 'h' || row < 1 || row > 8) {
	    throw new IllegalArgumentException("a-h and 1-8");
	}
	else {
	    this.color = color;
	    loc = "" + col + row; // need to change String into Location !!! [WRONG]
	}
    }
    
    public Piece(Location loc, int color) {
	this.color = color;
	this.loc = loc;
    }

    public int getColor() {
	return color;
    }
    
    public Location getLoc() {
	return loc;
    }
    public abstract boolean checkMove(Location toSpot); // checks if move is legal 
    
    public abstract boolean makeMove(Location toSpot); // function that moves

    public abstract Location[] mustBeOpen(Location toSpot); // list of all legal moves for certain piece (uses checkMove)

    public abstract String toString();

    public abstract void move();
    /* CSDOJO NOTES:
Probably can't have move method because it doesn't say which square I can go to.
Have a legal moves */
    public abstract Square[] getLegalMoves();
    public abstract void capture();

}
