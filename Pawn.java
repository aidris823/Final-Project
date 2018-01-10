public class Pawn extends Piece{
  //Determines if a Pawn can move 2 squares or not.
  private boolean hasMoved = false;
  private ChessBoard board = new ChessBoard();
  public Pawn(){
    super(xcor,ycor);
    isWhite = false;
  }
  public Square[] getLegalMoves(){
    Square[] ans = new Square[64];
    int counter = 0;
    //WoB = "White or Black?"
    int wob;
    if (isWhite){
      wob = -1;
    }
    else{
      wob = 1;
    }
      if (!hasMoved /*If it has not moved yet*/ 
          && (!(board[this.xcor][this.ycor + (2*wob)]).hasPiece) /*Exactly two squares ahead, there is no piece on that tile. */){
        ans[counter] = new Square(this.xcor,(this.ycor+2*wob));
        counter++;
      }
    if ((!(board[this.xcor][this.ycor+wob]).hasPiece)){
      ans[counter] = new Square(this.xcor,(this.ycor+wob)) /*One square ahead, it checks if there is a piece in front of it. */;
      counter++;
    }
    //Pawns are odd in that they capture differently from how they move: exactly one diagonal ahead of them.
    //I HAVE YET TO MAKE A "ISPIECEWHITE" FOR SQUARES.
    if (isInsideBounds(xcor-1,0 /*Is one piece diagonally ahead a legal square?*/) && (this.isWhite != (board[xcor-1][ycor+wob]).isPieceWhite())
       /*Is the Pawn a different color from the piece diagonally in front?*/){
      ans[counter] = new Square(xcor-1,ycor+wob);
      counter++;
    }
    //Same thing but other direction horizontally.
    if (isInsideBounds(xcor+1,0) && (this.isWhite != (board[xcor+1][ycor+wob]).isPieceWhite())){
      ans[counter] = new Square(xcor+1,ycor+wob);
      counter++;
    }
    return ans;
  }
}
