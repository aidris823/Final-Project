public class Queen extends Piece{
    private ChessBoard daBoard;
    private Square[][] board;

    public Queen(int xcor, int ycor, boolean color, ChessBoard daBoard) {
        super(xcor, ycor, color, daBoard);
        this.daBoard = daBoard;
        board = daBoard.getBoard();

        //Queen Name: "Q"
        setName("Q");
    }

    public Square[] getLegalMoves(){
        Square[] ans = new Square[27];
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

        //Int nw: The number of loops a Bishop should go in the northwest direction, assuming no pieces are in the way.
        int nw = Math.min(getX(), getY());
        //Int ne: The number of loops a Bishop should go in the northeast direction, assuming no pieces are in the way.
        int ne = Math.min(7 - getX(), getY());
        //Int sw = The number of loops a Bishop should go in the southwest direction, assuming no pieces are in the way.
        int sw = Math.min(getX(), 7 - getY());
        //Int se = The number of loops a Bishop should go in the southeast direction, assuming no pieces are in the way
        int se = Math.min(7 - getX(), 7 - getY());

        //North west loop:
        for (int i = 1; i <= nw; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                //If there is a piece in the way, check if it's friendly or not:
                if ((board[getX() - i][getY() - i]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square,
                    // albeit now the loop has stopped.
                    if (getColor() != (board[getX() - i][getY() - i]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX() - i, getY() - i, squareColor(getX() - i, getY() - i));
                        counter++;
                    }
                    //Do nothing if it's a friendly, but writing "else { counter += 0 }" is kinda redundant.

                    //Stop the loop because there is a piece in the way.
                    pieceInWay = true;
                }
                //If there is no piece in the way, then carry on:
                else {
                    ans[counter] = new Square(getX() - i, getY() - i, squareColor(getX() - i, getY() - i));
                    counter++;
                }
            }
        }
        //Same code but for different directions...

        //North east loop:
        for (int i = 1; i <= ne; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                //If there is a piece in the way, check if it's friendly or not:
                if ((board[getX() + i][getY() - i]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square,
                    // albeit now the loop has stopped.
                    if (getColor() != (board[getX() + i][getY() - i]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX() + i, getY() - i, squareColor(getX() + i, getY() - i));
                        counter++;
                    }
                    //Do nothing if it's a friendly, but writing "else { counter += 0 }" is kinda redundant.

                    //Stop the loop because there is a piece in the way.
                    pieceInWay = true;
                }
                //If there is no piece in the way, then carry on:
                else {
                    ans[counter] = new Square(getX() + i, getY() - i, squareColor(getX() + i, getY() - i));
                    counter++;
                }
            }
        }

        //South west loop:
        for (int i = 1; i <= sw; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                //If there is a piece in the way, check if it's friendly or not:
                if ((board[getX() - i][getY() + i]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square,
                    // albeit now the loop has stopped.
                    if (getColor() != (board[getX() - i][getY() + i]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX() - i, getY() + i, squareColor(getX() + i, getY() - i));
                        counter++;
                    }
                    //Do nothing if it's a friendly, but writing "else { counter += 0 }" is kinda redundant.

                    //Stop the loop because there is a piece in the way.
                    pieceInWay = true;
                }
                //If there is no piece in the way, then carry on:
                else {
                    ans[counter] = new Square(getX() - i, getY() + i, squareColor(getX() - i, getY() + i));
                    counter++;
                }
            }
        }


        //South east loop:
        for (int i = 1; i <= se; i++) {
            boolean pieceInWay = false;
            while (!pieceInWay) {
                //If there is a piece in the way, check if it's friendly or not:
                if ((board[getX() + i][getY() + i]).isHasPiece()) {
                    //Even if there is a piece in the way, if it's an enemy piece you still record that square as a legal square,
                    // albeit now the loop has stopped.
                    if (getColor() != (board[getX() + i][getY() + i]).getPieceType().getColor()) {
                        ans[counter] = new Square(getX() + i, getY() + i, squareColor(getX() + i, getY() + i));
                        counter++;
                    }
                    //Do nothing if it's a friendly, but writing "else { counter += 0 }" is kinda redundant.

                    //Stop the loop because there is a piece in the way.
                    pieceInWay = true;
                }
                //If there is no piece in the way, then carry on:
                else {
                    ans[counter] = new Square(getX() + i, getY() + i, squareColor(getX() + i, getY() + i));
                    counter++;
                }
            }
        }
        return ans;
    }
}
