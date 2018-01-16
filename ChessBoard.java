
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
        //PAWNS:

        for (int i = 0; i <= 7; i++) {
            //White pawns:
            board[6][i].updateHasPiece();
            board[6][i].updatePieceType(new Pawn(i, 6, true, this));
            //Black pawns:
            board[1][i].updateHasPiece();
            board[1][i].updatePieceType(new Pawn(i, 1, false, this));
        }
        //KNIGHTS:

        //White Knights:
        board[7][1].updateHasPiece();
        board[7][1].updatePieceType(new Knight(1,7,true,this));
        board[7][6].updateHasPiece();
        board[7][6].updatePieceType(new Knight(6,7,true,this));
        //Black Knights:
        board[0][1].updateHasPiece();
        board[0][1].updatePieceType(new Knight(1,0,false,this));
        board[0][6].updateHasPiece();
        board[0][6].updatePieceType(new Knight(6,0,false,this));

        //BISHOPS:
        //White Bishops:
        board[7][2].updateHasPiece();
        board[7][2].updatePieceType(new Bishop(2,7,true,this));
        board[7][5].updateHasPiece();
        board[7][5].updatePieceType(new Bishop(5,7,true,this));
        //Black Bishops:
        board[0][2].updateHasPiece();
        board[0][2].updatePieceType(new Bishop(2,0,false,this));
        board[0][5].updateHasPiece();
        board[0][5].updatePieceType(new Bishop(0,5,false,this));

        //ROOKS:
        //White Rooks:
        board[7][0].updateHasPiece();
        board[7][0].updatePieceType(new Rook(0,7,true,this));
        board[7][7].updateHasPiece();
        board[7][7].updatePieceType(new Rook(7,7,true,this));
        //Black Rooks:
        board[0][0].updateHasPiece();
        board[0][0].updatePieceType(new Rook(0,0,false,this));
        board[0][7].updateHasPiece();
        board[0][7].updatePieceType(new Rook(7,0,false,this));

        //QUEENS:
        //White Queen:
        board[7][3].updateHasPiece();
        board[7][3].updatePieceType(new Queen(3,7,true,this));
        //Black Queen:
        board[0][3].updateHasPiece();
        board[0][3].updatePieceType(new Queen(3,0,false,this));

        //KING:
        //White King:
        board[7][4].updateHasPiece();
        board[7][4].updatePieceType(new King(4,7,true,this));
        //Black King:
        board[0][4].updateHasPiece();
        board[0][4].updatePieceType(new King(4,0,false,this));
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

    //Moves the piece.
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
            ans += rowToString(testBoard[i]) + "\n";
        }
        return ans;
    }

    //Show that pieces were set up properly:
    public String printPieceSetUp(){
        String[][] testBoard = new String[8][8];
        String ans = "";

            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (!board[i][j].isHasPiece()){
                        testBoard[i][j] = "_";
                    }
                    else if (board[i][j].getPieceType().getName().equals("P")) {
                        testBoard[i][j] = "P";
                    }
                    else if (board[i][j].getPieceType().getName().equals("N")) {
                        testBoard[i][j] = "N";
                    }
                    else if (board[i][j].getPieceType().getName().equals("B")){
                        testBoard[i][j] = "B";
                    }
                    else if (board[i][j].getPieceType().getName().equals("R")){
                        testBoard[i][j] = "R";
                    }
                    else if (board[i][j].getPieceType().getName().equals("Q")){
                        testBoard[i][j] = "Q";
                    }
                    else if (board[i][j].getPieceType().getName().equals("K")){
                        testBoard[i][j] = "K";
                    }
                }
            }
            for (int i = 0; i <= 7; i++){
                ans += rowToString(testBoard[i]) + "\n";
            }
            return ans;
    }


    //Takes a row and converts it into a string form:
    public String rowToString(String[] row) {
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
        System.out.println("Checkered board:" + "\n");
        System.out.println(boardie.printColorGrid());

        //Print piece set up:
        System.out.println("Piece setup:" + "\n");
        System.out.println(boardie.printPieceSetUp());
        }

    }
