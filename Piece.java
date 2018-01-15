public abstract class Piece{
    private int xcor;
    private int ycor;
    private boolean isWhite;
    //Needed for a square to know what TYPE of piece is on it.
    private String name;

    //If isWhite is false, of course, then it's black.
    private int[] coords;
    private Square squareCurrentlyOn;
    public ChessBoard daBoard;
    private Square[][] board;

    public Piece(int xcor, int ycor, boolean color, ChessBoard daBoard) {
        this.xcor = xcor;
        this.ycor = ycor;
        if (color) {
            isWhite = true;
        } else {
            isWhite = false;
        }
        this.daBoard = daBoard;
        board = daBoard.getBoard();

        //Black square:
        if (squareColor(xcor,ycor) == 40){
            squareCurrentlyOn = new Square(xcor,ycor,40);
        }
        //White square:
        else{
            squareCurrentlyOn = new Square(xcor,ycor,107);
        }
        name = "GENERIC PIECE";
        /*List of possible names:
        "P": Pawn
        "N": Knight
        "B": Bishop
        "R": Rook
        "Q": Queen
        "K": King

        If the custom pieces are instead used, they are:
        "M": Musketeer
        "E": Elephant
        "C": Cannon
        "L": Prince - L is for "Love Symbol" after the true Prince.
         */
    }
    //Sets the name of the piece; only to be used by the subclasses of piece.
    public void setName(String nombre){
        name = nombre;
    }
    //Gets the name of the piece; only to be used by the subclasses of piece.
    public String getName(){
        return name;
    }
    //Helper functions to determine if something is odd or even.  Technically, I only one isEven/isOdd since the other
    //is simply its boolean opposite, so I only wrote the code for isEven.
    public boolean isEven(int x){
        return (x % 2 == 0);
    }

    public int[] getCoords() {
        return coords;
    }

    public int getX() {
        return xcor;
    }

    public int getY() {
        return ycor;
    }

    //Helper function to determine whether a square at a particular coordinate should be white or black.
    public int squareColor(int x, int y) {
        //Return white for [Odd, Odd] or [Even, Even] coordinates.
        if (((x % 2 == 0) && (y % 2 == 0)) || ((x % 2 == 1) && (y % 2 == 1))) {
            return 107;
        }
        //Otherwise, return black.
        return 40;
    }

    public void updateCoordinates(int xcor, int ycor){
        squareCurrentlyOn = new Square(xcor,ycor,squareColor(xcor,ycor));
    }

    //Returns an array of legal moves that a piece has.
    public abstract Square[] getLegalMoves();

    /*Helper function to determine if a piece went out of bounds with a move: useful for determining legal squares of a
    piece and for checking if a user's input was legal: */
    public boolean isInsideBounds(int row, int col){
        if (row < 0 || row > 7 || col > 0 || col < 7){
            return false;
        }
        return true;
    }

    //No setter for color since pieces don't switch color midgame.
    //Getter:
    public boolean getColor(){
        return isWhite;
    }

}
