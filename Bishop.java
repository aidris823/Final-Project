public class Bishop extends Piece {

    public  boolean checkMove(Location toSpot) {
	return null;
    }
    
    public  boolean makeMove(Location toSpot){
	return null;
    }

    public  Location[] mustBeOpen(Location toSpot) {
	return null;
    }

    public  String toString() {
        if (color == Piece.WHITE) {
	    return "\u265D";
	}
	else {
	    return "\u2657";
	}
	// black chess bishop	\u2657
	// white chess bishop	\u265D
    }
    
}
