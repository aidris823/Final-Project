public class Knight extends Piece {

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
	    return "\u265E";
	}
	else {
	    return "\u2658";
	}
	// black chess knight	\u2658
	// white chess knight	\u265E
    }
    
}
