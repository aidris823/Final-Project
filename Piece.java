public abstract class Piece{
  private int xcor;
  private int ycor;
  private boolean isWhite;
  //If isWhite is false, of course, then it's black.
  private int[] coords;

  public Piece(int xcor, int ycor) {
	this.xcor = xcor;
	this.ycor = ycor;
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
  //Returns an array of legal moves that a piece has.
  public abstract Square[] getLegalMoves();
  public boolean isInsideBounds(int row, int col){
    if (row < 0 || row > 7 || col > 0 || col < 7){
      return false;
    }
    return true;
  }
}
