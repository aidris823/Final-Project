//Each tile is a Square, so we must build a functional Square class.

public class Square{
    //Color:
    private int color;
    //Has a piece on it?:
    private boolean hasPiece;
    //Coordinates on the chess grid.
    private int xcor;
    private int ycor;
    private ChessBoard board = new ChessBoard();
  
    //Initializes 
    public Square(int xcor, int ycor) {
	//Has no coordinates until the ChessBoard gives it coordinates.
	this.xcor = -1;
	this.ycor = -1;
	//Assume it has no color until ChessBoard gives it color:
	color = -1;
	//Assume it has no piece on it until otherwise.
	hasPiece = false;
    }
    //Getters and setters for fields:
    public void setColor(int color) {
	this.color = color;
    }
    public int getColor() {
	return color;
    }
    public void setXCor(int x){
	xcor = x;
    }
    public int getXCor(){
	return xcor;
    }
    public void setYCor(int y){
	ycor = y;
    }
    public int getYCor(){
	return ycor;
    }
    public void updateHasPiece(){
	hasPiece = !hasPiece;
    }
    //   public Piece getPieceType(){]
 
}