import javax.swing.ImageIcon;
	
public class Pawn extends Piece {

    private boolean hasMoved;
    private Board daBoard;
    private Square[][] board;
    public int xcor;
    public int ycor;

    //Default/Unspecified:
    public Pawn(Board daBoard, int xcor, int ycor) {
	hasMoved = false;
	this.daBoard = daBoard;
	board = daBoard.square;
	this.xcor = xcor;
	this.ycor = ycor;

	//Default
	imageIcon = new ImageIcon("./images/white_pawn.png");
	setIcon(imageIcon);
    }

    //Specified:
    public Pawn(String color, Board daBoard, int xcor, int ycor) {
	hasMoved = false;
	this.daBoard = daBoard;
	board = daBoard.square;
	this.xcor = xcor;
	this.ycor = ycor;
	
	if(color.equals("white")) {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_pawn.png");
	    setIcon(imageIcon);
	}
	
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_pawn.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "pawn";
    }

    public Square[] getLegalMoves(){
	Square[] ans = new Square[4];
	int counter = 0;
	//White or Black?
	int wob;
	if (color.equals("white")){
	    wob = -1;
	}
	//If it's not white, then it's black.
	else{
	    wob = 1;
	}
	//Has not moved yet, so it can go 2 squares ahead:
        /* Precondition:
	   1. Pawn has not yet moved.
	   2. There is no piece one tile in front.
	   3. There is no piece two tiles in front.
	  
	   Postcondition: getLegalMoves gets updated with the square two squares in front. */
	if (!hasMoved && (board[xcor+(wob)][ycor].piece == null) && (board[xcor+(2*wob)][ycor].piece == null)){
	    ans[counter] = board[xcor+(2*wob)][ycor];
	    counter++;
	}
	/*Precondition: There is no piece one square in front.
	  Postcondition: Square one square in front is a legal move.
	*/
	if (board[xcor+(wob)][ycor].piece == null){
	    ans[counter] = board[xcor+wob][ycor];
	    counter++;
	}
	/* Precondition: There is a piece of opposite color 
	   diagonally left
	   Postcondition: Square one square diagonally left is a legal move.
	*/
	if (board[xcor+(wob)][ycor+1].piece != null){
	    if (this.getColor() != (board[xcor+(wob)][ycor+1].piece.getColor())){
		ans[counter] = board[xcor+wob][ycor+1];
		counter++;
	    }
	}
	if (board[xcor+(wob)][ycor-1].piece != null){
	    if (this.getColor() != (board[xcor+(wob)][ycor-1].piece.getColor())){
		ans[counter] = board[xcor+wob][ycor-1];
		counter++;
	    }
	}
	return ans;
    }
    	
}
