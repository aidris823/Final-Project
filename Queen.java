public class Queen extends Piece {

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
	    return "\u265B";
	}
	else {
	    return "\u2655";
	}
	// black chess queen	\u2655
	// white chess queen	\u265B
    }
    
}
