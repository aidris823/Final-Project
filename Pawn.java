public class Pawn extends Piece {
        //Determines if a Pawn can move 2 squares or not.
        private boolean hasMoved = false;
        private ChessBoard daBoard;
        private Square[][] board;
        private int xcor;
        private int ycor;
        private boolean isWhite;

        public Pawn(int xcor, int ycor, boolean color, ChessBoard daBoard){
            super(xcor,ycor,color,daBoard);
            //For some reason this code is needed despite the Super statement; I'll try to get this checked:
            this.xcor = xcor;
            this.ycor = ycor;
            isWhite = color;
            this.daBoard = daBoard;
            board = daBoard.getBoard();

            //Pawn name: "P"
            setName("P");
        }

        public Square[] getLegalMoves(){
            Square[] ans = new Square[4];
            int counter = 0;
            //WoB = "White or Black?"
            int wob;
            //If it is white, it will move UP the board.  In other words, its ycor will change at a -1 basis.
            if (getColor()){
                wob = -1;
            }
            //If it is not white, then it is black, so it will move DOWN the board at a +1 basis.
            else{
                wob = 1;
            }

            //If a pawn has not moved yet, then it can move two squares ahead provided that there is no piece one or two squares in front of it:
            if (!hasMoved /*If it has not moved yet*/
                    && (!(board[this.xcor][this.ycor+wob]).isHasPiece()) /* Exactly one square ahead, there is no piece on that tile. */
                    && (!(board[this.xcor][this.ycor + (2*wob)]).isHasPiece()) /*Exactly two squares ahead, there is no piece on that tile. */){
                //If it passes these requirements, then two squares ahead will be a legal move.
                ans[counter] = new Square(this.xcor,(this.ycor+2*wob),squareColor(this.xcor,this.ycor+2*wob));
                counter++;
            }
            //A pawn can move one square ahead if there is no piece in the way.
            if ((!(board[this.xcor][this.ycor+wob]).isHasPiece())){
                ans[counter] = new Square(this.xcor,(this.ycor+wob),squareColor(this.xcor,this.ycor+2*wob)) /*One square ahead, it checks if there is a piece in front of it. */;
                counter++;
            }
            //Pawns are odd in that they capture differently from how they move: exactly one diagonal ahead of them.
            if (isInsideBounds(xcor-1,0 /*Is one piece diagonally ahead a legal square?*/) && (getColor() != (board[xcor-1][ycor+wob]).getPieceType().getColor())
            ){
                /*Is the Pawn a different color from the piece diagonally in front?*/
                ans[counter] = new Square(xcor-1,ycor+wob,squareColor(xcor-1,ycor+wob));
                counter++;
            }
            //Same thing but other direction horizontally.
            if (isInsideBounds(xcor+1,0) && (getColor() != (board[xcor+1][ycor+wob]).getPieceType().getColor())){
                ans[counter] = new Square(xcor+1,ycor+wob,squareColor(xcor-1,ycor+wob));
                counter++;
            }
            return ans;
        }
    }

