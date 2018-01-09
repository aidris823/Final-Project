// First, make a working board on the Terminal.
public class ChessBoard{
    // Background colors:
    private static final int black = 40;
    private static final int white = 107;
    //Array of squares:
    private Square[][] board;
    //Set up an eight by eight grid:
    public ChessBoard(){
	board = Square[8][8];
    }
    //Sets up the board:
    public void setBoard(){
	//This double for loop is meant set up color values for each of the
	// square values.
	for (int i = 0; i < 8; i += 2){
	    for (int j = 0; j < 8; j += 2){
		(board[i][j]).setColor(white);
	    }
	}
	for (int i = 1; i <= 7; i += 2){
	    for (int j = 0; j < 8; j += 2){
		(board[i][j]).setColor(black);
	    }
	}
    }
    
    public static void main(String[] arguments){
	setBoard();
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		System.out.println((board[i][j].getColor()));
	    }
	}
    }
}
