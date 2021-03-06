import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//Main GUI class:
public class RunChess extends JFrame implements MouseListener{

    
    public static Board board = new Board();
    public boolean whitesTurn = true;
    public static boolean hasActive = false; 
    public static Square previousSquare = null;
    public static String pieceColor = "";
    public static Square source = null;
    public static int counter = 0;
    public static boolean oneMoved = false;
    public static boolean enableDeleteAction = false;
    public static JMenuBar menuBar = new JMenuBar();
    public static JMenuItem menuAbout = new JMenuItem("About");
    
    public RunChess() {
	
	getContentPane().add(board);
	
	//Adding menu bar
	setJMenuBar(menuBar);
	menuBar.add(menuAbout);
	JMenuItem mntmSetting = new JMenuItem("Setting");
	
	board.initializeChessBoard("white");


	//add action listeners for all the squares
	for(int i = 0; i < 8; i++) {
	    for(int j = 0; j < 8; j++) {
		board.square[i][j].addMouseListener(this);
	    }
	}

	
    }
    
    
    public void mouseClicked(MouseEvent e) {
	//get the reference of clicked source square 
	source = (Square) e.getSource();
	
	//if the source piece is not free then get the type and color of the piece
	if(!source.isFree()) {
	    pieceColor = source.getPiece().getColor();
		if (pieceColor.equals("white")){
			if (!whitesTurn){
				System.out.println("It is black's turn.");
				return;
			}
		}
		if (pieceColor.equals("black")){
			if (whitesTurn){
				System.out.println("It is white's turn.");
				return;
			}
		}
	}
	
	//when square clicked and is not active, not free means containing piece then can move
	if(!source.isActive && !source.isFree()) {
	    source.isActive = true;
	    hasActive = true;
	    previousSquare = source;
	}

	
	else if(hasActive) { //when there is an active and the clicked square is free

	    String pieceType = previousSquare.getPiece().getPieceType();
	    String pieceColor = previousSquare.getPiece().getColor();


	    /*  
	     * ----------------------------------------------------------------------
	     * ---------------------------- WHITE PAWN ------------------------------
	     * ----------------------------------------------------------------------
	     */


	    
	    if(pieceType.equalsIgnoreCase("pawn") && pieceColor.equalsIgnoreCase("white")) {
	
		//TODO whether the pawn is black or white is not clicked
		//if at initial position source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		if((previousSquare.getRow() == 6 && (previousSquare.getRow() == source.getRow() + 1 || previousSquare.getRow() == source.getRow() + 2)) && previousSquare.getCol() == source.getCol()) {
		
		    movePiece();
		    oneMoved = true;
		}
		//When is not at initial position & destination is row+1 at the same column
		else if( previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol()) {
		   
		    movePiece();
		    oneMoved = true;
		}
		//When move a pawn to kill opposit's piece
		//if the row is just 1 step ahead and the piece to kill is at 1 column aside
		else if(previousSquare.getRow() == source.getRow() + 1 && Math.abs(previousSquare.getCol() - source.getCol()) == 1) {
		
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		else{clear();}
	    }


	    /*  
	     * ----------------------------------------------------------------------
	     * ----------------------------- BLACK PAWN -----------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    
	    else if(pieceType.equalsIgnoreCase("pawn") && pieceColor.equalsIgnoreCase("black")) {
	
		//if at initial position source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		if((previousSquare.getRow() == 1 && (previousSquare.getRow() == source.getRow() - 1
						     || previousSquare.getRow() == source.getRow() - 2)) && previousSquare.getCol() == source.getCol()){
		    System.out.println("move piece is called for pawn");
		    movePiece();
		    oneMoved = true;
		}
		//When is not at initial position & destination is row+1 at the same column
		else if( previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol()) {
		    // UNCOMMENT FOR TESTIGN ---- System.out.println("move piece is called for pawn");
		    movePiece();
		    oneMoved = true;
		}
		//When move a pawn to kill opposit's piece
		//if the row is just 1 step ahead and the piece to kill is at 1 column aside
		else if(previousSquare.getRow() == source.getRow() - 1 && Math.abs(previousSquare.getCol() - source.getCol()) == 1) {
		 
		    enableDeleteAction = true;
		    movePiece();//call movePiece() method
		    oneMoved = true;
		}
		else{clear();}
	    }

	    /*  
	     * ----------------------------------------------------------------------
	     * ------------------------------- KNIGHT -------------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    else if(pieceType.equalsIgnoreCase("knight")) {
		//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		if((previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol() + 2)
		   || (previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol() - 2)
		   || (previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol() + 2)
		   || (previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol() - 2)
		   || (previousSquare.getRow() == source.getRow() + 2 && previousSquare.getCol() == source.getCol() + 1)
		   || (previousSquare.getRow() == source.getRow() - 2 && previousSquare.getCol() == source.getCol() + 1)
		   || (previousSquare.getRow() == source.getRow() + 2 && previousSquare.getCol() == source.getCol() - 1)
		   || (previousSquare.getRow() == source.getRow() - 2 && previousSquare.getCol() == source.getCol() - 1)){
		    
		    
		
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		
		
		else{clear();}
	    }
	    
	

	    /*  
	     * ----------------------------------------------------------------------
	     * ------------------------------- BISHOP -------------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    else if(pieceType.equalsIgnoreCase("bishop")) {
	
		//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		int rowOffset = previousSquare.getRow()- source.getRow();
		int colOffset = previousSquare.getCol() - source.getCol();
		if(Math.abs(rowOffset) == Math.abs(colOffset)) {
		
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		else{clear();}
	    }
	    
	    /*  
	     * ----------------------------------------------------------------------
	     * -------------------------------- ROOK --------------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    
	    else if(pieceType.equalsIgnoreCase("rook")) {
	
		//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		if(previousSquare.getRow() == source.getRow() || previousSquare.getCol() == source.getCol()) {
		
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		else{clear();}
	    }

	    /*  
	     * ----------------------------------------------------------------------
	     * ------------------------------- QUEEN -------------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    
	    else if(pieceType.equalsIgnoreCase("queen")) {
		//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		int rowOffset = previousSquare.getRow()- source.getRow();
		int colOffset = previousSquare.getCol() - source.getCol();
		if(Math.abs(rowOffset) == Math.abs(colOffset) 
		   || previousSquare.getRow() == source.getRow()
		   || previousSquare.getCol() == source.getCol()
		   ) {
		  
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		else{clear();}
	    }
	    
	    
	    /*  
	     * ----------------------------------------------------------------------
	     * -------------------------------- KING --------------------------------
	     * ----------------------------------------------------------------------
	     */
	    
	    
	    else if(pieceType.equalsIgnoreCase("king")) {
		
		//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
		int rowOffset = previousSquare.getRow()- source.getRow();
		int colOffset = previousSquare.getCol() - source.getCol();
		if(Math.abs(rowOffset) == 1 ||  Math.abs(colOffset) == 1) {
		    enableDeleteAction = true;
		    movePiece();
		    oneMoved = true;
		}
		else{clear();}
	    }
	}
	    whitesTurn = !whitesTurn;
    }
    
    public void movePiece() {
	if(!source.isFree() && !previousSquare.getPiece().getColor().equalsIgnoreCase(pieceColor) && enableDeleteAction) {
	    source.remove(source.getPiece());
	    source.setPiece(null);
	    enableDeleteAction = false;
	}
	source.add(previousSquare.getPiece());
	source.setPiece(previousSquare.getPiece());
	source.revalidate();
	board.repaint();
	hasActive = false;
	previousSquare.setStatus(true);
	previousSquare.setPiece(null);
	previousSquare.isActive = false;
	source.setStatus(false); 
	previousSquare = null; //clear
	whitesTurn = !whitesTurn;
    }
    
    public void clear() { //Clear the properties for the next time
	
	hasActive = false;
	oneMoved = false;
	enableDeleteAction = false;
	previousSquare.isActive = false; 
	previousSquare = null; //clear square before
	source = null;
    }
    
    
    public static void main(String[] string) {	
	JFrame frame = new RunChess();
	frame.setSize(700, 700);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
    
    
    
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}

