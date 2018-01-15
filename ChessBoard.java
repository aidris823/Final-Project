import java.util.Arrays;
public class ChessBoard {
    //Square colors:
    private static final int black = 40;
    private static final int white = 107;

    //Array of the "Square" class:
    private Square[][] board;

    //Constructor that sets up board:
    public ChessBoard() {
        //Makes an eight by eight grid with "coordinates," per se.
        board = new Square[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[i][j] = new Square(i, j, squareColor(i, j));
            }
        }
        //Gives each square a color.
        setBoardColor();
        setUpBoard();
    }

    //Gets board;
    public Square[][] getBoard() {
        return board;
    }

    //Gives each Square in the board a color in an alternating (chessboard-style) fashion.
    public void setBoardColor() {
        //Squares with an even x coordinate:
        for (int i = 0; i <= 6; i += 2) {
            //[Even, Even] coordinates are white.
            for (int j = 0; j <= 6; j += 2) {
                Square squareHere = board[i][j];
                squareHere.setColor(white);
            }
            //[Even, Odd] coordinates are black.
            for (int j = 1; j <= 7; j += 2) {
                Square squareHere = board[i][j];
                squareHere.setColor(black);
            }
        }

        //Squares with an odd x coordinate:
        for (int i = 1; i <= 7; i += 2) {
            //[Odd, Odd] coordinates are white.
            for (int j = 1; j <= 7; j += 2) {
                Square squareHere = board[i][j];
                squareHere.setColor(white);
            }
            //[Odd, Even] coordinates are black.
            for (int j = 0; j <= 7; j += 2) {
                Square squareHere = board[i][j];
                squareHere.setColor(black);
            }
        }
    }

    // new Pawn(1, i, true, this);
    //Sets up board...sorry Steven.
    public void setUpBoard() {
        //Pawns:
        for (int i = 0; i <= 7; i++) {
            //White pawns:
            board[i][7].updateHasPiece();
            board[i][7].updatePieceType(new Pawn(i, 7, true, this));
            //Black pawns:
            board[i][1].updateHasPiece();
            board[i][1].updatePieceType(new Pawn(i, 7, false, this));
        }
        //Knights:

        //White Knights:
        board[1][0].updateHasPiece();
        board[1][0].updatePieceType(new Knight(1,0,true,this));
        
        board[6][0].updateHasPiece();
        board[6][0].updatePieceType(new Knight(1,0,true,this));

    }

    //Helper function to determine whether a square at a particular coordinate should be white or black.
    public int squareColor(int x, int y) {
        //Return white for [Odd, Odd] or [Even, Even] coordinates.
        if (((x % 2 == 0) && (y % 2 == 0)) || ((x % 2 == 1) && (y % 2 == 1))) {
            return white;
        }
        //Otherwise, return black.
        return black;
    }

    //Moves the piece...sorry Steven
    public void move(int xcorStart, int ycorStart, int xcorEnd, int ycorEnd) {
    }

    //Helper method that converts chess talk (E4, A1, etc) into usable variables:
    public void moveInEnglish(String start, String end) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int xcorStart = start.charAt(0);
        for (int i = 0; i <= 7; i++) {
            if (xcorStart == letters[i]) {
                xcorStart = i;
            }
        }
        int ycorStart = Integer.parseInt(start.substring(1, 2));
        int xcorEnd = end.charAt(0);
        for (int i = 0; i <= 7; i++) {
            if (xcorEnd == letters[i]) {
                xcorEnd = i;
            }
        }
        int ycorEnd = Integer.parseInt(end.substring(1, 2));
        move(xcorStart, ycorStart, xcorEnd, ycorEnd);
    }

    //Demo: Show that a Black and White chess board is possible:
    public String printColorGrid() {
        String[][] testBoard = new String[8][8];
        String ans = "";
        //Give each spot a "B" if the Square at that coordinate has a color value equal to 40, "W" if it is 107:
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                Square squareHere = board[i][j];
                if (squareHere.getColor() == 40) {
                    testBoard[i][j] = "B";
                }
                if ((board[i][j]).getColor() == 107) {
                    testBoard[i][j] = "W";
                }
            }
        }
        for (int i = 0; i <= 7; i++) {
            ans += toString(testBoard[i]) + "\n";
        }
        return ans;
    }

    public String toString(String[] row) {
        String ans = "";
        for (int i = 0; i < row.length; i++) {
            ans += (row[i]);
            ans += " ";
        }
        return ans;
    }

    //Demo for Tuesday:
    public static void main(String[] arguments) {
        ChessBoard boardie = new ChessBoard();
        //Print colored board:
        System.out.println(boardie.printColorGrid());

    }
}
