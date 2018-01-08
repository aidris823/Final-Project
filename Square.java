
public class Square{
    private int color;
    private int xcor;
    private int ycor;
    private int[] coordinates;
    private boolean 
    public Square(int x, int y){
	x = xcor;
	y = ycor;
	coordinates = {x,y};
    }
    public void setX(int x){
	xcor = x;
    }
    public void setY(int y){
	ycor = y;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public void setColor(int c){
	color = c;
    }
    public int getColor(){
	return color;
    }


    public boolean isPieceOn() {
	if (piece == null) {
	    return false;
	}
	return true;
    }

    public void takeSpot(Piece piece) {

	if(this.piece != null) { // if there is a piece on the square
	    // removes current piece on square and replaces it with current piece
	}
	this.piece = piece; // replaces the current piece with the piece selected
    }

    

}
