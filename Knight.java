public class Knight extends Piece{

    private ChessBoard daBoard;
    private Square[][] board;

    public Knight(int xcor, int ycor, boolean color,ChessBoard daBoard){
        super(xcor,ycor,color,daBoard);
        this.daBoard = daBoard;
        board = daBoard.getBoard();

    }
    public Square[] getLegalMoves(){
        Square[] ans = new Square[8];
        int counter = 0;
        if (isInsideBounds(getX()+2,getY()+1) /*Is that move within the squares of the board? */
                && getColor() != (board[getX()+2][getY()+1]).getPieceType().getColor()
                        /*Even if it is legal board wise, is there a piece on that square that is the same color? */){
            ans[counter] = new Square(getX()+2,getY()+1,squareColor(getX(),getY()+1));
            counter++;
        }
        //Same thing but for the other seven moves that the Knight could possibly have:
        if (isInsideBounds(xcor+2,ycor-1)&& getColor() != (board[xcor+2][ycor-1]).isPieceWhite()){
            ans[counter] = new Square(xcor+2,ycor-1);
            counter++;
        }
        if (isInsideBounds(xcor+1,ycor-2)&& getColor() != (board[xcor+1][ycor-2]).isPieceWhite()){
            ans[counter] = new Square(xcor+1,ycor-2);
            counter++;
        }
        if (isInsideBounds(xcor+1,ycor+2)&& getColor() != (board[xcor+1][ycor+2]).isPieceWhite()){
            ans[counter] = new Square(xcor+1,ycor+2);
            counter++;
        }
        if (isInsideBounds(xcor-2,ycor-1)&& getColor() != (board[xcor-2][ycor-1]).isPieceWhite()){
            ans[counter] = new Square(xcor-2,ycor-1);
            counter++;
        }
        if (isInsideBounds(xcor-2,ycor+1)&& getColor()!= (board[xcor-2][ycor+1]).isPieceWhite()){
            ans[counter] = new Square(xcor-2,ycor+1);
            counter++;
        }
        if (isInsideBounds(xcor-1,ycor-2)&& getColor() != (board[xcor-1][ycor-2]).isPieceWhite()){
            ans[counter] = new Square(xcor-1,ycor-2);
            counter++;
        }
        if (isInsideBounds(xcor-1,ycor+2)&& getColor() != (board[xcor-1][ycor+2]).isPieceWhite()){
            ans[counter] = new Square(xcor-1,ycor+2);
            counter++;
        }
        return ans;
    }

}
