public class King extends Piece{
  private boolean hasMoved; //Determines if the King can castle.
  private ChessBoard board = new ChessBoard();
  public King(){
    super(xcor,ycor);
    isWhite = false;
  }
  //Getting legal moves for the king is a bit tricky.  Since the King has royal power, the algorithm MUST make sure that only moves that will not put the King 
  // in check at any point are considered.
  public Square[] getLegalMoves(){
    Square[] ans = new Square[8]; //At most, a King can have eight legal moves.  Before you get cheeky, castling can only happen in the edge of a board.  Guess
    // where the King's movement is cut by (at least) three?  The edge of the board!
    int counter = 0;
    //If it's within bounds, does not put King in check, and is not a friendly piece, then it is a legal move:
    if (isInsideBounds(xcor+1,ycor) && !putsInCheck(xcor+1,ycor) && this.isWhite != ((board[xcor+1][ycor]).isPieceWhite())){
      ans[counter] = new Square(xcor+1,ycor);
      counter++;
    }
    //Repeat process with other directions:
    if (isInsideBounds(xcor,ycor+1) && !putsInCheck(xcor,ycor+1) && this.isWhite != ((board[xcor][ycor+1]).isPieceWhite())){
      ans[counter] = new Square(xcor,ycor+1);
      counter++;
    }
    if (isInsideBounds(xcor+1,ycor+1) && !putsInCheck(xcor+1,ycor+1) && this.isWhite != ((board[xcor+1][ycor+1]).isPieceWhite())){
      ans[counter] = new Square(xcor+1,ycor+1);
      counter++;
    }
    if (isInsideBounds(xcor,ycor-1) && !putsInCheck(xcor,ycor-1) && this.isWhite != ((board[xcor][ycor-1]).isPieceWhite())){
      ans[counter] = new Square(xcor,ycor-1);
      counter++;
    }
    if (isInsideBounds(xcor-1,ycor-1) && !putsInCheck(xcor-1,ycor-1) && this.isWhite != ((board[xcor-1][ycor-1]).isPieceWhite())){
      ans[counter] = new Square(xcor-1,ycor-1);
      counter++;
    }
    if (isInsideBounds(xcor-1,ycor) && !putsInCheck(xcor-1,ycor) && this.isWhite != ((board[xcor-1][ycor]).isPieceWhite())){
      ans[counter] = new Square(xcor-1,ycor);
      counter++;
    }
    if (isInsideBounds(xcor+1,ycor-1) && !putsInCheck(xcor+1,ycor-1) && this.isWhite != ((board[xcor+1][ycor-1]).isPieceWhite())){
      ans[counter] = new Square(xcor+1,ycor-1);
      counter++;
    }
    if (!hasMoved){
      //Check to see if it can castle Kingside:
      //If there are no pieces in the way:
      if (!(board[xcor+1][ycor]).hasPiece && !(board[xcor+2][ycor]).hasPiece && (board[xcor+3][ycor].pieceOnTile()/*Will return String of what type it is*/
                                                                                 .equals("Rook"))){
        if (this.isWhite == (board[xcor-3][ycor]).isPieceWhite() /* && Insert code checking if Rook on that tile has not moved.*/){
          ans[counter] = new Square(xcor+2,ycor);
          counter++;
        }
      }
      //Queenside:
      //If there are no pieces in the way:
      if (!(board[xcor-1][ycor]).hasPiece && !(board[xcor-2][ycor]).hasPiece && !(board[xcor-3][ycor]).hasPiece && 
          (board[xcor-4][ycor].pieceOnTile()/*Will return String of what type it is*/.equals("Rook"))){
        if (this.isWhite == (board[xcor+4][ycor]).isPieceWhite() /* && Insert code checking if Rook on that tile has not moved.*/){
          ans[counter] = new Square(xcor-2,ycor);
          counter++;
        }
      }
    }
  }
        
  //Opponent has a piece that can land on the same square that a King can go through, that being (xcor,ycor)?:
  public boolean putsInCheck(int xcor, int ycor){
    //Scan through every square on the chessboard until there is a piece that is the opposite color of the King.  
    for (int i = 0; i < 7; i++){
      for (int j = 0; j < 7; j++){
        //If it is an enemy piece, get a list of their possible legal moves.  If any of them overlap with (xcor,ycor) then return false.
        if ((board[i][j]).hasPiece && this.isWhite != (board[i][j].isPieceWhite())){
          Square[] enemyMoves = new Square[64];
          //I have yet to write a "pieceOnTile" or "isPieceWhite" function, as a reminder.
          enemyMoves = ((board[i][j].pieceOnTile()).getLegalMoves());
          for (int k = 0; k < enemyMoves.length; k++){
            if (enemyMoves[k].getXCor() == xcor && enemyMoves[k].getYCor() == ycor){
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
