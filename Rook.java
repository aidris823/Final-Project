public class Rook extends Piece {

    public boolean checkMove(Location toSpot) {
	if (toSpot.getRow() == getLoc().getRow()
	    || toSpot.getCol() == getLoc().getCol()) {

	    return true;
	}
	return false;
    }
    
    public boolean makeMove(Location toSpot){
	return null;
    }

    public Location[] mustBeOpen(Location toSpot) {
	return null;
    }

    public String toString() {
	return null;
	// black chess rook	\u2656
	// white chess rook	\u265C
    }
    
}
