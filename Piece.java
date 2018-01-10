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
	char col = loc.charAt(0); // need to get char !!! [WRONG]
	int row = Integer.parseInt(loc); // need to get int !!! [WRONG]
	if (col < 'a' || col > 'h' || row < 1 || row > 8) {
	    throw new IllegalArgumentException("a-h and 1-8");
	}
	else {
	    this.color = color;
	    loc = "" + col + row;
	}
    }

    public int getColor() {
	return color;
    }

    public Location getLoc() {
	return loc;
    }
    public abstract boolean checkMove(Location toSpot);
    
    public abstract boolean makeMove(Location toSpot);

    public abstract Location[] mustBeOpen(Location toSpot);

    public abstract String toString();

    public abstract Location

    /*
      Unicode for our chess pieces:

      black chess king	        \u2654
      black chess queen  	\u2655
      black chess rook	        \u2656
      black chess bishop	\u2657
      black chess knight	\u2658
      black chess pawn  	\u2659
      
      white chess king  	\u265A
      white chess queen  	\u265B
      white chess rook  	\u265C
      white chess bishop	\u265D
      white chess knight	\u265E
      white chess pawn  	\u265F
    */

}
