// use in main method
public class Board {

    private static final char light='\u2591';
    private static final char dark='\u2593';
    private Piece[][] board = new Piece[8][8];
    private boolean whiteTurn = true;
    
    // setUpBoard or setUpBeginningBoard
    public Board() {
	setUpBeginningBoard();
	//setUpBoard();
    }
    
    /**Builds two Rook objects per side, and assigns them to the array.*/ 
    private void setUpBeginningBoard() {
	board[0][0] = new Rook(new Location(0,0),Piece.WHITE);
	board[0][7] = new Rook(new Location(7,0),Piece.WHITE);
	
	board[7][0] = new Rook(new Location(0,7),Piece.BLACK);
	board[7][7] = new Rook(new Location(7,7),Piece.BLACK);
    }
    
    /**Builds all the Piece objects for the full game.*/
    private void setUpBoard() {
	// finish all pieces files then uncomment
	/*
	  board[0][0] = new Rook(new Location(0,0),Piece.WHITE);
	  board[0][7] = new Rook(new Location(7,0),Piece.WHITE);
	  board[0][1] = new Knight(new Location(1,0),Piece.WHITE);
	  board[0][6] = new Knight(new Location(6,0),Piece.WHITE);
	  board[0][2] = new Bishop(new Location(2,0),Piece.WHITE);
	  board[0][5] = new Bishop(new Location(5,0),Piece.WHITE);
	  board[0][3] = new Queen(new Location(3,0),Piece.WHITE);
	  board[0][4] = new King(new Location(4,0),Piece.WHITE);
	  for (int c = 0; c < 8; c++)
	  board[1][c] = new Pawn(new Location(c,1),Piece.WHITE);
	  
	  board[7][0] = new Rook(new Location(0,7),Piece.BLACK);
	  board[7][7] = new Rook(new Location(7,7),Piece.BLACK);
	  board[7][1] = new Knight(new Location(1,7),Piece.BLACK);
	  board[7][6] = new Knight(new Location(6,7),Piece.BLACK);
	  board[7][2] = new Bishop(new Location(2,7),Piece.BLACK);
	  board[7][5] = new Bishop(new Location(5,7),Piece.BLACK);
	  board[7][3] = new Queen(new Location(3,7),Piece.BLACK);
	  board[7][4] = new King(new Location(4,7),Piece.BLACK);
	  for (int c = 0; c < 8; c++)
	  board[6][c] = new Pawn(new Location(c,6),Piece.BLACK);
	*/
    }

    public boolean whiteTurn() {
	return whiteTurn;
    }
    
    // -1 black win
    // 0 draw
    // 1 white win
    public int winner() {
	
	int kingCount = 0;
	
	  for (Piece[] c : board)
	  for (Piece p : c)
	  if (p != null && p instanceof King)
          if (p.getColor() == Piece.WHITE)
	  kingCount++;
          else
	  kingCount--;
	
	return kingCount;
    }
    
    /**
     * Provides the String of the board to be printed.  Depends upon each Piece
     * having the proper toString itself.  For example, if you have done:
     * <pre>
     * Board b = new Board();
     * System.out.println(b);
     * </pre>
     * then the board will be printed to the Terminal.  It may be helpful to
     * have enlarged your terminal using Ctl+.<br />
     *
     * This method depends upon each Piece object having a correct toString().
     * @return A String that visually represents the current Board's state.
     */
    public String toString() {
	String s = "\n  ";
	
	// print the column chars across the top
	for (int c = 0; c < 8; c++)
	    s+= (char)(c+'a') + " ";
	//end the column labels line
	s+='\n';
	
	// for each row,
	for (int r = 7; r >= 0; r--) {
	    // print the label for the row,
	    s+= (r+1) + " ";
	    
	    // and for each column,
	    for (int c = 0; c < 8; c++) {
		// if that spot in the board contains a Piece object,
		if (board[r][c] != null) {
		    // call that piece's toString()
		    s+=board[r][c].toString();
		    s+=' ';
		}
		// if that spot does NOT contain a Piece object, then if that spot
		//   should be a white square,
		else if ((r+c)%2 == 1) {
		    // print two light chars (light and dark are defined in the fields)
		    s+=light;
		    s+=light;
		} else {
		    // else, print two dark chars
		    s+=dark;
		    s+=dark;
		}
	    }
	    // newline at the end of each row
	    s+='\n';
	}
	return s;
    }
    
    /**
     * This method should be called by the main method in Chess to make a move;
     * <b>YOU SHOULD COMPLETELY UNDERSTAND THIS METHOD BEFORE WRITING
     * PIECE.JAVA</b>.
     * This method depends upon Piece having the following methods:
     * <ul>
     * <li>getColor()</li>
     * <li>makeMove()</li>
     * <li>and for Step 4, mustBeOpen()</li>
     * </ul>
     *@param from This String should contain a board location in algebraic
     notation (eg "a5").  The Piece in that location will be moved.
     *@param to This String should also contain a board location in algebraic
     notation.  The piece in location "from" will be moved to this location.
     *@throws IllegalArgumentException if, for any reason, that move isn't
     possible.  Reasons include:
     <ul>
     <li>from or to not being valid Locations,</li>
     <li>from not containing a Piece,</li>
     <li>from having a Piece of the wrong color,</li>
     <li>to having a Piece the same color as from,</li>
     <li>the move is not a valid move for the Piece in from, or</li>
     <li>depending on if you are before or after Step 4, Pieces being in the
     way of the move</li>
     </ul>
    */
    public void makeMove(String from, String to) throws
	IllegalArgumentException {
	
	// Build a Location from "from" - note this constructor may throw an
	//   IllegalArgumentException
	Location a = new Location(from);
	// Get that location's indices for the board array
	int ar = a.getRowIndex();
	int ac = a.getColIndex();
	// If there is no piece at that location, throw an Exception
	if (board[ar][ac] == null)
	    throw new IllegalArgumentException(from + " does not have a piece on it.");
	
	// If the Piece at that location is the wrong color for whose turn it is,
	//   throw an Exception
	if ((board[ar][ac].getColor()==Piece.WHITE) != whiteTurn)
	    throw new IllegalArgumentException(from + 
					       " has a Piece of the wrong color.");
	
	// Build a Location from "to".  Note this may throw an Exception. 
	Location b = new Location(to);
	
	//Get to's array indices
	int br = b.getRowIndex();
	int bc = b.getColIndex();
	
	// If the array has pieces at "from" and "to" that are the same color,
	//   throw an Exception.  Note this depends on Piece having a getColor()
	//   method.
	if (board[br][bc] != null &&
	    (board[br][bc].getColor()==board[ar][ac].getColor()))
	    throw new IllegalArgumentException(to + 
					       " holds a piece the same color as " + from);
	
	// This code handles checking to see if there are pieces in the way of the
	// move.  You should uncomment this to achieve Step 4.  Note it depends
	// on Piece having a .mustBeOpen() function that returns an array of all
	// Locations that must be open.
	/*
	  Location[] locs = board[ar][ac].mustBeOpen(b);
	  // For every element of this array but the last one,
	  for (int i = 0; i < locs.length-1; i++) {
	  // if there is a piece in that spot, throw an Exception.
	  if (board[locs[i].getRowIndex()][locs[i].getColIndex()] != null)
	  throw new IllegalArgumentException("Other pieces in the way.");
	  }*/
	
	// If the Piece successfully makes the move, update the board array, and
	// change whose turn it is.  Note that this depends upon Piece having a
	// method called .makeMove() that returns a boolean indicating if the move
	// was successful.
	if (board[ar][ac].makeMove(b)) {
	    board[br][bc] = board[ar][ac];
	    board[ar][ac] = null;
	    whiteTurn = !whiteTurn;
	} else
	    // If the move was unsuccessful, throw an Exception
	    throw new IllegalArgumentException("Illegal move for the Piece.");
    }
}
