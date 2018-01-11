import java.util.Arrays;
public class ChessBoard{
  //Square colors:
  private static final int black = 40;
  private static final int white = 107;
  
  //Array of the "Square" class:
  private Square[][] board;
  
  
  
  //Constructor that sets up board:
  public ChessBoard(){
    //Makes an eight by eight grid with "coordinates," per se.
    board = new Square[8][8];
    //Gives each square a color.
    setBoardColor();
  }
  //Gives each Square in the board a color in an alternating (chessboard-style) fashion.
  public void setBoardColor(){
    //[Even, Even] coordinates are white.
    for (int i = 0; i <= 6; i += 2){
      for (int j = 0; j <= 6; j += 2){
        (board[i][j]).setColor(white);
      }
    }
    //[Odd, Odd] coordinates are white.
    for (int i = 1; i <= 7; i += 2){
      for (int j = 1; j <= 7; j+ = 2){
        (board[i][j]).setColor(white);
      }
    }
    //[Even, Odd] coordinates are black.
    for (int i = 0; i <= 6; i += 2){
      for (int j = 1; j <= 7; j+= 2){
        (board[i][j]).setColor(black);
      }
    }
    //[Odd, Even] coordinates are black.
    for (int i = 1; i <= 7; i += 2){
      for (int j = 0; j <= 7; j += 2){
        (board[i][j].setColor(black));
      }
    }
  }
  public static void main(String[] arguments){
    //For now, I am testing to see if the grid was set up properly through this main function.
    
    //Make an 8x8 2D Array of Strings: 
    public String[][] testBoard;
    testBoard = new String[8][8];
    
    //Give each spot a "B" if the Square at that coordinate has a color value equal to 40, "W" if it is 107:
    for (int i = 0; i <= 7; i++){
      for (int j = 0; j <= 7; j++){
        if ((board[i][j]).getColor() == 40){
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
