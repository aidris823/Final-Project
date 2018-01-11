public class King extends Piece {

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
	    return "\u265A";
	}
	else {
	    return "\u2654";
	}
	// black chess king	\u2654
	// white chess king	\u265A
    }
    
}
