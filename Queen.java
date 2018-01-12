
public class Queen extends Piece{

  private ChessBoard board = new ChessBoard();
  public Queen(){
    super(xcor,ycor);
    isWhite = false;
  }
  
  //Essentially just me copy and pasting Rook and Bishop code together.
  public Square[] getLegalMoves(){
    Square[] ans = new Square[27]; //Queen has 13 (Bishop) + 14 (Rook) amount of possible moves at most.
    int counter = 0;
    ///Because of the precautions I'm making with my own n/e/w/s/ne/nw/se/sw variables, the isInsideBounds function shouldn't be needed:
    //Int n: The number of loops a Queen should make in the NORTH direction, assuming there are no pieces in the way.
    int n = this.ycor;
    //Int w: The number of loops a Queen should make in the WEST direction, assuming there are no pieces in the way.
    int w = this.xcor;
    //Int e: The number of loops a Queen should make in the EAST direction, assuming there are no pieces in the way.
    int e = 7-this.xcor;
    //Int s: The number of loops a Queen should make in the SOUTH direction, assuming there are no pieces in the way.
    int s = 7-this.ycor;
    //Int nw: The number of loops a Queen should go in the NORTHWEST direction, assuming no pieces are in the way.
    int nw = Math.min(xcor,ycor);
    //Int ne: The number of loops a Queen should go in the NORTHEAST direction, assuming no pieces are in the way.
    int ne = Math.min(7-xcor,ycor);
    //Int sw = The number of loops a Queen should go in the SOUTHWEST direction, assuming no pieces are in the way.
    int sw = Math.min(xcor,7-ycor);
    //Int se = The number of loops a Queen should go in the SOUTHEAST direction, assuming no pieces are in the way
    
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
