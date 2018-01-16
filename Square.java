//Each tile is a Square, so we must build a functional Square class.

public class Square{
    //Color:
    private int color;
    //Has a piece on it?:
    private boolean hasPiece;
    //Coordinates on the chess grid.
    private int xcor;
    private int ycor;
    private Piece pieceCurrentlyOn;
    
  
    //Initializes a Square / Constructor for no piece:
    public Square(int xcor, int ycor, int color) {
	//Has no coordinates until the ChessBoard gives it coordinates.
	this.xcor = xcor;
	this.ycor = ycor;
	//Assume it has no color until ChessBoard gives it color:
	this.color = color;
	//Assume it has no piece on it until otherwise.
	hasPiece = false;
	pieceCurrentlyOn = null;
    }

    //Initializes a Square / Constructor for a piece:
    public Square(int xcor, int ycor, int color, Piece daPiece){
	this.xcor = xcor;
	this.ycor = ycor;
	this.color = color;
	hasPiece = true;
	pieceCurrentlyOn = daPiece;
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
    public boolean isHasPiece(){
	return hasPiece;
    }
    public void updateHasPiece(){
	hasPiece = !hasPiece;
    }
    public void updatePieceType(Piece daPiece){
	pieceCurrentlyOn = daPiece;
    }
    public Piece getPieceType(){
	return pieceCurrentlyOn;
    }
 
}
