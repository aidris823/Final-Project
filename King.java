public class King extends Piece{
    private boolean hasMoved = false; //Determines if the King can castle.
    private ChessBoard daBoard;
    private Square[][] board;

    public King(int xcor, int ycor, boolean color, ChessBoard daBoard){
        super(xcor,ycor,color,daBoard);
        this.daBoard = daBoard;
        board = daBoard.getBoard();

        //King name: "K"
        setName("K");
    }

    //Getting legal moves for the king is a bit tricky.  Since the King has royal power, the algorithm MUST make sure that only moves that will not put the King
    // in check at any point are considered.
    public Square[] getLegalMoves() {
        Square[] ans = new Square[8]; //At most, a King can have eight legal moves.  Before you get cheeky, castling can only happen in the edge of a board.  Guess
        // where the King's movement is cut by (at least) three?  The edge of the board!
        int counter = 0;
        //If it's within bounds, does not put King in check, and is not a friendly piece, then it is a legal move:
        if (isInsideBounds(getX() + 1, getY()) && !putsInCheck(getX() + 1, getY()) && getColor() != ((board[getX() + 1][getY()]).getPieceType().getColor())) {
            ans[counter] = new Square(getX() + 1, getY(), squareColor(getX() + 1, getY()));
            counter++;
        }
        //Repeat process with other directions:
        if (isInsideBounds(getX(), getY() + 1) && !putsInCheck(getX(), getY() + 1) && getColor() != ((board[getX()][getY() + 1]).getPieceType().getColor())) {
            ans[counter] = new Square(getX(), getY() + 1, squareColor(getX() + 1, getY()));
            counter++;
        }
        if (isInsideBounds(getX() + 1, getY() + 1) && !putsInCheck(getX() + 1, getY() + 1) && getColor() != ((board[getX() + 1][getY() + 1]).getPieceType().getColor())) {
            ans[counter] = new Square(getX() + 1, getY() + 1, squareColor(getX() + 1, getY() + 1));
            counter++;
        }
        if (isInsideBounds(getX(), getY() - 1) && !putsInCheck(getX(), getY() - 1) && getColor() != ((board[getX()][getY() - 1]).getPieceType().getColor())) {
            ans[counter] = new Square(getX(), getY() - 1, squareColor(getX() + 1, getY() + 1));
            counter++;
        }
        if (isInsideBounds(getX() - 1, getY() - 1) && !putsInCheck(getX() - 1, getY() - 1) && getColor() != ((board[getX() - 1][getY() - 1]).getPieceType().getColor())) {
            ans[counter] = new Square(getX() - 1, getY() - 1, squareColor(getX() - 1, getY()));
            counter++;
        }
        if (isInsideBounds(getX() - 1, getY()) && !putsInCheck(getX() - 1, getY()) && getColor() != ((board[getX() - 1][getY()]).getPieceType().getColor())) {
            ans[counter] = new Square(getX() - 1, getY(), squareColor(getX() - 1, getY()));
            counter++;
        }
        if (isInsideBounds(getX() + 1, getY() - 1) && !putsInCheck(getX() + 1, getY() - 1) && getColor() != ((board[getX() + 1][getY() - 1]).getPieceType().getColor())) {
            ans[counter] = new Square(getX() + 1, getY() - 1, squareColor(getX() + 1, getY() - 1));
            counter++;
        }
        if (!hasMoved) {
            //Check to see if it can castle Kingside:
            //If there are no pieces in the way:
            if (!(board[getX() + 1][getY()]).isHasPiece() && !(board[getX() + 2][getY()]).isHasPiece() && (board[getX() + 3][getY()].getPieceType().getName().equals("R"))
                    && (getColor() == board[getX() + 3][getY()].getPieceType().getColor())) {
                ans[counter] = new Square(getX() + 2, getY(), squareColor(getX() + 2, getY()));
                counter++;
            }
            //Queenside:
            //If there are no pieces in the way:
            if (!(board[getX() - 1][getY()]).isHasPiece() && !(board[getX() - 2][getY()]).isHasPiece() && (!board[getX() - 2][getY()].isHasPiece()) && (board[getX() - 4][getY()].getPieceType().getName().equals("R"))
                    && (getColor() == board[getX() + 3][getY()].getPieceType().getColor())) {
                ans[counter] = new Square(getX() + 2, getY(), squareColor(getX() + 2, getY()));
                counter++;
            }
        }
        return ans;
    }

    //Opponent has a piece that can land on the same square that a King can go through, that being (xcor,ycor)?:
    public boolean putsInCheck(int xcor, int ycor){
        //Scan through every square on the chessboard until there is a piece that is the opposite color of the King.
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                //If it is an enemy piece, get a list of their possible legal moves.  If any of them overlap with (xcor,ycor) then return false.
                if ((board[i][j]).isHasPiece() && getColor() != (board[i][j].getPieceType().getColor())){
                    Square[] enemyMoves = new Square[64];
                    //I have yet to write a "pieceOnTile" or "isPieceWhite" function, as a reminder.
                    enemyMoves = ((board[i][j].getPieceType().getLegalMoves()));
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
