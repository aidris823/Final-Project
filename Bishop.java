public class Bishop extends Piece{

  private ChessBoard board = new ChessBoard();
  public Bishop(){
    super(xcor,ycor);
    isWhite = false;
  }
  public Square[] getLegalMoves(){
    Square[] ans = new Square[13]; //At most, a Bishop has 13 legal moves.
    counter = 0;
    //Because of the precautions I'm making with my own nw/ne/sw/se variables, the isInsideBounds function shouldn't be needed:
    //Int nw: The number of loops a Bishop should go in the northwest direction, assuming no pieces are in the way.
    int nw = Math.min(xcor,ycor);
    //Int ne: The number of loops a Bishop should go in the northeast direction, assuming no pieces are in the way.
    int ne = Math.min(7-xcor,ycor);
    //Int sw = The number of loops a Bishop should go in the southwest direction, assuming no pieces are in the way.
    int sw = Math.min(xcor,7-ycor);
    //Int se = The number of loops a Bishop should go in the southeast direction, assuming no pieces are in the way
    
    //North west loop:
    for (int i = 1; i <= nw; i++){
      boolean pieceInWay = false;
      while (!pieceInWay){
        if ((board[xcor-i][ycor-i]).hasPiece){
          //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor-i][ycor-i]).isPieceWhite()){
            ans[counter] = new board[xcor-i][ycor-i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor-i][ycor-i];
          counter++;
        }
      }
    }
    //Same code but for different directions.
    
    //North east loop:
    for (int i = 1; i <= ne; i++){
      boolean pieceInWay = false;
      while (!pieceInWay){
        if ((board[xcor+i][ycor-i]).hasPiece){
          //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor+i][ycor-i]).isPieceWhite()){
            ans[counter] = new board[xcor+i][ycor-i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor+i][ycor-i];
          counter++;
        }
      }
    }
    
    //South west loop:
    for (int i = 1; i <= sw; i++){
      boolean pieceInWay = false;
      while (!pieceInWay){
        if ((board[xcor-i][ycor+i]).hasPiece){
          //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor-i][ycor+i]).isPieceWhite()){
            ans[counter] = new board[xcor-i][ycor+i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor-i][ycor+i];
          counter++;
        }
      }
    }
    //South east loop:
 for (int i = 1; i <= se; i++){
      boolean pieceInWay = false;
      while (!pieceInWay){
        if ((board[xcor+i][ycor+i]).hasPiece){
          //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
          if (this.isWhite != (board[xcor+i][ycor+i]).isPieceWhite()){
            ans[counter] = new board[xcor+i][ycor+i];
            counter++;
          }
          //Essentially, if there is a piece in the way, then stop the loop.
          pieceInWay = true;
        }
        else{
          ans[counter] = new board[xcor+i][ycor+i];
          counter++;
        }
      }
    }
    return ans;
  }
}
