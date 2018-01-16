public class Rook extends Piece {

    private ChessBoard daBoard;
    private Square[][] board;

    public Rook(int xcor, int ycor, boolean color, ChessBoard daBoard) {
        super(xcor, ycor, color, daBoard);
        this.daBoard = daBoard;
        board = daBoard.getBoard();

        //Rook Name: "R"
        setName("R");
    }

    public Square[] getLegalMoves() {
        Square[] ans = new Square[14]; //Interestingly enough, if there are no pieces in the way the Rook
        // is the only piece to always have EXACTLY fourteen legal moves.
        int counter = 0;
        ///Because of the precautions I'm making with my own n/e/w/s variables, the isInsideBounds function shouldn't be needed:
        //Int n: The number of loops a Rook should make in the NORTH direction, assuming there are no pieces in the way.
        int n = getY();
        //Int w: The number of loops a Rook should make in the WEST direction, assuming there are no pieces in the way.
        int w = getX();
        //Int e: The number of loops a Rook should make in the EAST direction, assuming there are no pieces in the way.
        int e = 7 - getX();
        //Int s: The number of loops a Rook should make in the SOUTH direction, assuming there are no pieces in the way.
        int s = 7 - getY();

        //North loop:
        for (int i = 1; i <= n; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                if ((board[getX()][getY() - i]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square
                    // as a legal square, albeit now the loop has stopped.
                    if (getColor() != (board[getX()][getY() - i]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX(), getY() - i, squareColor(getX(), getY() - i));
                        counter++;
                    }
                    //There is a piece in the way, so stop the loop.
                    pieceInWay = true;
                } else {
                    ans[counter] = new Square(getX(), getY() - i, squareColor(getX(), getY() - i));
                    counter++;
                }
            }
        }

        //West loop:
        for (int i = 1; i <= w; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                if ((board[getX() - i][getY()]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
                    if (getColor() != (board[getX() - i][getY()]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX() - i, getY(), squareColor(getX() - i, getY()));
                        counter++;
                    }
                    //Essentially, if there is a piece in the way, then stop the loop.
                    pieceInWay = true;
                } else {
                    ans[counter] = new Square(getX() - i, getY(), squareColor(getX() - i, getY()));
                    counter++;
                }
            }
        }

        //East loop:
        for (int i = 1; i <= e; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                while (!pieceInWay) {
                    if ((board[getX() + i][getY()]).isHasPiece()) {
                        //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
                        if (getColor() != (board[getX() + i][getY()]).getPieceType().getColor()) {
                            ans[counter] = new Square(getX() + i, getY(), squareColor(getX() - i, getY()));
                            counter++;
                        }
                        //Essentially, if there is a piece in the way, then stop the loop.
                        pieceInWay = true;
                    } else {
                        ans[counter] = new Square(getX() + i, getY(), squareColor(getX() + i, getY()));
                        counter++;
                    }
                }
            }
        }

        //South loop:
        for (int i = 1; i <= s; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                while (!pieceInWay) {
                    if ((board[getX()][getY() + i]).isHasPiece()) {
                        //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square, albeit now the loop has stopped.
                        if (getColor() != (board[getX()][getY() + i]).getPieceType().getColor()) {
                            ans[counter] = new Square(getX(), getY() + i, squareColor(getX(), getY() + i));
                            counter++;
                        }
                        //Essentially, if there is a piece in the way, then stop the loop.
                        pieceInWay = true;
                    } else {
                        ans[counter] = new Square(getX(), getY() + i, squareColor(getX(), getY() + i));
                        counter++;
                    }
                }
            }
        }
        return ans;
    }
}
