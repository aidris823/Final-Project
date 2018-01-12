import java.util.Arrays;
public class ChessBoard{
    //Square colors:f
    private static final int black = 40;
    private static final int white = 107;
  
    //Array of the "Square" class:
    private Square[][] board;
  
  
  
    //Constructor that sets up board:
    public ChessBoard(){
	//Makes an eight by eight grid with "coordinates," per se.
	board = new Square[8][8];
	for (int i = 0; i <= 7; i++){
	    for (int j = 0; j <= 7; j++){
		board[i][j] = new Square(i,j);
	    }

	}
	//Gives each square a color.
	setBoardColor();
    }

    //Gets board;
    public Square[][] getBoard(){
	return board;
    }
    //Gives each Square in the board a color in an alternating (chessboard-style) fashion.
    public void setBoardColor(){
	//[Even, Even] coordinates are white.
	for (int i = 0; i <= 6; i += 2){
	    for (int j = 0; j <= 6; j += 2){
		Square squareHere = board[i][j];
		squareHere.setColor(white);
	    }
	}
	//[Odd, Odd] coordinates are white.
	for (int i = 1; i <= 7; i += 2){
	    for (int j = 1; j <= 7; j += 2){
		Square squareHere = board[i][j];
		squareHere.setColor(white);
	    }
	}
	//[Even, Odd] coordinates are black.
	for (int i = 0; i <= 6; i += 2){
	    for (int j = 1; j <= 7; j+= 2){
		Square squareHere = board[i][j];
		squareHere.setColor(black);
	    }
	}
	//[Odd, Even] coordinates are black.
	for (int i = 1; i <= 7; i += 2){
	    for (int j = 0; j <= 7; j += 2){
		Square squareHere = board[i][j];
		squareHere.setColor(black);
	    }
	}
    }
    //Sets up board...sorry Steven.
    public void setUpBoard(){
	//White pawns:
	for (int i = 0; i <= 7; i++){
	    board[1][i] = new Pawn(1,i,true,this);
	}
       
    //Moves the piece...sorry Steven.
    public void move(Square start, Square end){
	
    }
    public static void main(String[] arguments){
	//For now, I am testing to see if the grid was set up properly through this main function.

	ChessBoard x = new ChessBoard();
	Square[][] board = x.getBoard();
	
	//Make an 8x8 2D Array of Strings: 
        String[][] testBoard;
	testBoard = new String[8][8];
    
	//Give each spot a "B" if the Square at that coordinate has a color value equal to 40, "W" if it is 107:
	for (int i = 0; i <= 7; i++){
	    for (int j = 0; j <= 7; j++){
		Square squareHere = board[i][j];
		if (squareHere.getColor() == 40){
		    testBoard[i][j] = "B";
		}
		if ((board[i][j]).getColor() == 107){
		    testBoard[i][j] = "W";
		}
	    }
	}
          
	//Print the array:
	System.out.println(Arrays.deepToString(testBoard));
    }
}
