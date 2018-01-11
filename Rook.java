public class Rook extends Piece{

  private ChessBoard board = new ChessBoard();
  public Rook(){
    super(xcor,ycor);
    isWhite = false;
  }
  public Square[] getLegalMoves(){
    Square[] ans = new Square[14]; //Interestingly enough, if there are no pieces in the way the Rook is the only piece to always have EXACTLY fourteen legal moves.
    int counter = 0;
    ///Because of the precautions I'm making with my own n/e/w/s variables, the isInsideBounds function shouldn't be needed:
    //Int n: The number of loops a Rook should make in the NORTH direction, assuming there are no pieces in the way.
    int n = this.ycor;
    //Int w: The number of loops a Rook should make in the WEST direction, assuming there are no pieces in the way.
    int w = this.xcor;
    //Int e: The number of loops a Rook should make in the EAST direction, assuming there are no pieces in the way.
    int e = 7-this.xcor;
    //Int s: The number of loops a Rook should make in the SOUTH direction, assuming there are no pieces in the way.
    int s = 7-this.ycor;
    
    //North loop:
    for (int i = 1; i <= n; i++){
      boolean pieceInWay = false;
      while (!pieceInWay){
        if ((board[xcor][ycor-i]).hasPiece){
          //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor][ycor-i]).isPieceWhite()){
            ans[counter] = new board[xcor][ycor-i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor][ycor-i];
        }
    }
  }
    
    //West loop:
    for (int i = 1; i <= w; i++){
      while (!pieceInWay){
        if ((board[xcor-i][ycor]).hasPiece){
           //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor-i][ycor]).isPieceWhite()){
            ans[counter] = new board[xcor-i][ycor];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor-i][ycor];
        }
      }
    }
    
    //East loop:
    for (int i = 1; i <= w; i++){
      while (!pieceInWay){
        if ((board[xcor+i][ycor]).hasPiece){
           //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor+i][ycor]).isPieceWhite()){
            ans[counter] = new board[xcor+i][ycor];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor+i][ycor];
        }
      }
    }
    
    //South loop:
    for (int i = 1; i <= w; i++){
      while (!pieceInWay){
        if ((board[xcor][ycor+i]).hasPiece){
           //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor][ycor+i]).isPieceWhite()){
            ans[counter] = new board[xcor][ycor+i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor][ycor+i];
        }
      }
    }
    return ans;
  } 
}
