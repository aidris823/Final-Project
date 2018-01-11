
public class Knight extends Piece{
  //Determines if a Pawn can move 2 squares or not.
  private boolean hasMoved = false;
  private ChessBoard board = new ChessBoard();
  public Knight(){
    super(xcor,ycor);
    isWhite = false;
  }
  public Square[] getLegalMoves(){
    Square[] ans = new Square[8];
    counter = 0;
    if (isInsideBounds(xcor+2,ycor+1) /*Is that move within the squares of the board? */
        && this.isWhite != (board[xcor+2][ycor+1]).isPieceWhite() /*Even if it is legal board wise, is there a piece on that square that is the same color? */){
      ans[counter] = new Square(xcor+2,ycor+1);
      counter++;
    }
    //Same thing but for the other seven moves that the Knight could possibly have:
    if (isInsideBounds(xcor+2,ycor-1)&& this.isWhite != (board[xcor+2][ycor-1]).isPieceWhite()){
      ans[counter] = new Square(xcor+2,ycor-1);
      counter++;
    }
    if (isInsideBounds(xcor+1,ycor-2)&& this.isWhite != (board[xcor+1][ycor-2]).isPieceWhite()){
      ans[counter] = new Square(xcor+1,ycor-2);
      counter++;
    }
    if (isInsideBounds(xcor+1,ycor+2)&& this.isWhite != (board[xcor+1][ycor+2]).isPieceWhite()){
      ans[counter] = new Square(xcor+1,ycor+2);
      counter++;
    }
    if (isInsideBounds(xcor-2,ycor-1)&& this.isWhite != (board[xcor-2][ycor-1]).isPieceWhite()){
      ans[counter] = new Square(xcor-2,ycor-1);
      counter++;
    }
    if (isInsideBounds(xcor-2,ycor+1)&& this.isWhite != (board[xcor-2][ycor+1]).isPieceWhite()){
      ans[counter] = new Square(xcor-2,ycor+1);
      counter++;
    }
    if (isInsideBounds(xcor-1,ycor-2)&& this.isWhite != (board[xcor-1][ycor-2]).isPieceWhite()){
      ans[counter] = new Square(xcor-1,ycor-2);
      counter++;
    }
    if (isInsideBounds(xcor-1,ycor+2)&& this.isWhite != (board[xcor-1][ycor+2]).isPieceWhite()){
      ans[counter] = new Square(xcor-1,ycor+2);
      counter++;
    }
    return ans;
  }

}
