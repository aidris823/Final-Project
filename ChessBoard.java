// First, make a working board on the Terminal.
public class ChessBoard{
    // Background colors:
    private static final int black = 40;
    private static final int white = 107;
    //Array of squares:
    private Square[][] board;
    public ChessBoard(){
	board = Square[8][8];
    }
    
    public void setBoard() {
	for (int i = 0; i < 8; i+=2){
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
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		System.out.println((board[i][j].getColor()));
	    }
	}
    }
}
