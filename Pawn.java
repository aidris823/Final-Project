public class Pawn extends Piece {

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
	    return "\u265F";
	}
	else {
	    return "\u2659";
	}
	// black chess pawn	\u2659
	// white chess pawn	\u265F
    }
    
}
