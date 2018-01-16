public class Bishop extends Piece{

    private ChessBoard daBoard;
    private Square[][] board;

    public Bishop(int xcor, int ycor, boolean color, ChessBoard daBoard){
        super(xcor,ycor,color,daBoard);
        this.daBoard = daBoard;
        board = daBoard.getBoard();

        //Bishop Name: "B"
        setName("B");
    }

    public Square[] getLegalMoves() {
        Square[] ans = new Square[13]; //At most, a Bishop has 13 legal moves.
        int counter = 0;

        //Because of the precautions I'm making with my own nw/ne/sw/se variables, the isInsideBounds function shouldn't be needed:

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
