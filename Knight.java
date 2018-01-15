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

        //All eight directions accounted for:

        // Go right two and go down one direction:
        if (isInsideBounds(getX()+2,getY()+1) /*Is that move within the squares of the board? */
                && getColor() != (board[getX()+2][getY()+1]).getPieceType().getColor()
                        /*Even if it is legal board wise, is there a piece on that square that is the same color? */){
            ans[counter] = new Square(getX()+2,getY()+1,squareColor(getX(),getY()+1));
            counter++;
        }

        //Go right two and go up one direction:
        if (isInsideBounds(getX()+2,getY()-1)&& getColor() != (board[getX()+2][getY()-1]).getPieceType().getColor()){
            ans[counter] = new Square(getX()+2,getY()-1,squareColor(getX()+2,getY()-1));
            counter++;
        }

        //Go right one and go up two direction:
        if (isInsideBounds(getX()+1,getY()-2)&& getColor() != (board[getX()+1][getY()-2]).getPieceType().getColor()){
            ans[counter] = new Square(getX()+1,getY()-2,squareColor(getX()+1,getY()-2));
            counter++;
        }

        //Go right one and go down two direction:
        if (isInsideBounds(getX()+1,getY()+2)&& getColor() != (board[getX()+1][getY()+2]).getPieceType().getColor()){
            ans[counter] = new Square(getX()+1,getY()+2,squareColor(getX()+1,getY()+2));
            counter++;
        }

        //Go left two and go up one direction:
        if (isInsideBounds(getX()-2,getY()-1)&& getColor() != (board[getX()-2][getY()-1]).getPieceType().getColor()){
            ans[counter] = new Square(getX()-2,getY()-1,squareColor(getX()-2,getY()-1));
            counter++;
        }

        //Go left two and go down one direction:
        if (isInsideBounds(getX()-2,getY()+1) && getColor()!= (board[getX()-2][getY()+1]).getPieceType().getColor()){
            ans[counter] = new Square(getX()-2,getY()+1,squareColor(getX()-2,getY()+1));
            counter++;
        }

        //Go left one and go up two direction:
        if (isInsideBounds(getX()-1,getY()-2)&& getColor() != (board[getX()-1][getY()-2]).getPieceType().getColor()){
            ans[counter] = new Square(getX()-1,getY()-2,squareColor(getX()-1,getY()-2));
            counter++;
        }

        //Go left one and go down two direction:
        if (isInsideBounds(getX()-1,getY()+2)&& getColor() != (board[getX()-1][getY()+2]).getPieceType().getColor()){
            ans[counter] = new Square(getX()-1,getY()+2,squareColor(getX()-1,getY()+2));
            counter++;
        }

        return ans;
    }

}
