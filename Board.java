import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Board extends JPanel {
    
    public Square[][] square = new Square[10][10];
    //Sets up colors of squares according to RGB configuration:
    public Color black = new Color(150, 100, 50);
    public Color white = new Color(255, 255, 255);
    
    // BLACK PIECES
    public Pawn[] blackPawn = new Pawn[8];
    public Bishop[] blackBishop = new Bishop[2];
    public Knight[] blackKnight = new Knight[2]; 
    public Rook[] blackRook = new Rook[2];
    public King[] blackKing = new King[1];
    public Queen[] blackQueen = new Queen[1];

    // WHITE PIECES
    public Pawn[] whitePawn = new Pawn[8];
    public Bishop[] whiteBishop = new Bishop[2];
    public Knight[] whiteKnight = new Knight[2];
    public Rook[] whiteRook = new Rook[2];
    public King[] whiteKing = new King[1];
    public Queen[] whiteQueen = new Queen[1];
    
    //Constructor: 
    public Board() {
	//Colors in all the squares:
	initilizeVariables();
	//Grid Layout of GUI
	setLayout(new GridLayout(8, 8));

	//Adding the squares to the board via setPosition
	for (int i = 0; i < 8; i++) {
	    for(int j = 0; j < 8; j++) {
		//Calls for the Square class' setPosition function, which
		//lets a specific square know its xcor and ycor.
		square[i][j].setPosition(i, j);
		//...You add.
		add(square[i][j]);
	    }
	}
    }
    
    public void initilizeVariables() {
	for(int i = 0; i < 8; i++) {
	    for(int j = 0; j < 8; j++) {
		if((i + j) % 2 == 0 ) {
		    this.square[i][j] = new Square(i, j);
		    this.square[i][j].setBackground(white); 
		}
		else {
		    this.square[i][j] = new Square(i, j);
		    this.square[i][j].setBackground(black);
		}	
	    }
	}

	/*These all loop through the piece arrays and give them a color,
	  which is a string instead of a boolean, which might be a little
	  inefficient but it works. */
	
	// PAWN
	for(int i = 0; i < 8; i++) {
	    blackPawn[i] = new Pawn("black");
	    whitePawn[i] = new Pawn("white");
	}
	
	// Minor Pieces and Rook:
	for(int i =0; i < 2; i++) {
	    blackBishop[i] = new Bishop("black");
	    whiteBishop[i] = new Bishop("white");
	    
	    blackKnight[i] = new Knight("black");
	    whiteKnight[i] = new Knight("white");
	    
	    blackRook[i] = new Rook("black");
	    whiteRook[i] = new Rook("white");
	}
	//Queens and Kings:
	blackQueen[0] = new Queen("black");
	whiteQueen[0] = new Queen("white");
	    
	blackKing[0] = new King("black");
	whiteKing[0] = new King("white");
    }
    
    //Setup the chess board with black as opponent to play(DEFAULT)
    public void initializeChessBoard() {
	//placing Pawn in the chess board
	for(int i = 0; i < 8; i++) {
	    this.square[1][i].add(blackPawn[i]);
	    this.square[6][i].add(whitePawn[i]);
	    //set the pieces for the square
	    this.square[1][i].setPiece(blackPawn[i]);
	    this.square[6][i].setPiece(whitePawn[i]);
	}
	//Initialize other square as free
	for(int i = 0; i < 8; i++) {
	    for(int j = 0; j < 8; j++) {
		this.square[i][j].setStatus(true);
	    }
	}
	//placing Rook in the chess board
	this.square[0][0].add(blackRook[0]);
	this.square[0][7].add(blackRook[1]);
	this.square[7][0].add(whiteRook[0]);
	this.square[7][7].add(whiteRook[1]);
	//set The pieces of the square
	this.square[0][0].setPiece(blackRook[0]);
	this.square[0][7].setPiece(blackRook[1]);
	this.square[7][0].setPiece(whiteRook[0]);
	this.square[7][7].setPiece(whiteRook[1]);
	//placing Knight in the chess board
	this.square[0][1].add(blackKnight[0]);
	this.square[0][6].add(blackKnight[1]);
	this.square[7][1].add(whiteKnight[0]);
	this.square[7][6].add(whiteKnight[1]);
	//set the pieces
	this.square[0][1].setPiece(blackKnight[0]);
	this.square[0][6].setPiece(blackKnight[1]);
	this.square[7][1].setPiece(whiteKnight[0]);
	this.square[7][6].setPiece(whiteKnight[1]);
	//placing Bishop in the chess board
	this.square[0][2].add(blackBishop[0]);
	this.square[0][5].add(blackBishop[1]);
	this.square[7][2].add(whiteBishop[0]);
	this.square[7][5].add(whiteBishop[1]);
	//set the pieces
	this.square[0][2].setPiece(blackBishop[0]);
	this.square[0][5].setPiece(blackBishop[1]);
	this.square[7][2].setPiece(whiteBishop[0]);
	this.square[7][5].setPiece(whiteBishop[1]);
	//placing Queen & King in the chess board
	this.square[0][3].add(blackQueen[0]);
	this.square[0][4].add(blackKing[0]);
	this.square[7][3].add(whiteQueen[0]);
	this.square[7][4].add(whiteKing[0]);	
	//set the pieces
	this.square[0][3].setPiece(blackQueen[0]);
	this.square[0][4].setPiece(blackKing[0]);
	this.square[7][3].setPiece(whiteQueen[0]);
	this.square[7][4].setPiece(whiteKing[0]);	
	
	setAsNotFree();
	
    }
    
    // SETUP
    public void initializeChessBoard(String yourPiece)
    {
	if(yourPiece.equalsIgnoreCase("white"))
	    {
		initializeChessBoard();
	    }
	else if(yourPiece.equals("black"))
	    {
		// PLACING PAWNS
		for(int i = 0; i < 8; i++)
		    {
			this.square[6][i].add(blackPawn[i]);
			this.square[1][i].add(whitePawn[i]);
			// SETTING
			this.square[6][i].setPiece(blackPawn[i]);
			this.square[1][i].setPiece(whitePawn[i]);
		    }

		// SETTING AND ADDING PIECES
		this.square[7][0].add(blackRook[0]);
		this.square[7][7].add(blackRook[1]);
		this.square[0][0].add(whiteRook[0]);
		this.square[0][7].add(whiteRook[1]);

		this.square[7][0].setPiece(blackRook[0]);
		this.square[7][7].setPiece(blackRook[1]);
		this.square[0][0].setPiece(whiteRook[0]);
		this.square[0][7].setPiece(whiteRook[1]);

		this.square[7][1].add(blackKnight[0]);
		this.square[7][6].add(blackKnight[1]);
		this.square[0][1].add(whiteKnight[0]);
		this.square[0][6].add(whiteKnight[1]);

		this.square[7][1].setPiece(blackKnight[0]);
		this.square[7][6].setPiece(blackKnight[1]);
		this.square[0][1].setPiece(whiteKnight[0]);
		this.square[0][6].setPiece(whiteKnight[1]);

		this.square[7][2].add(blackBishop[0]);
		this.square[7][5].add(blackBishop[1]);
		this.square[0][2].add(whiteBishop[0]);
		this.square[0][5].add(whiteBishop[1]);

		this.square[7][2].setPiece(blackBishop[0]);
		this.square[7][5].setPiece(blackBishop[1]);
		this.square[0][2].setPiece(whiteBishop[0]);
		this.square[0][5].setPiece(whiteBishop[1]);

		this.square[7][4].add(blackQueen[0]);
		this.square[7][3].add(blackKing[1]);
		this.square[0][4].add(whiteQueen[0]);
		this.square[0][3].add(whiteKing[1]);

		this.square[7][4].setPiece(blackQueen[0]);
		this.square[7][3].setPiece(blackKing[1]);
		this.square[0][4].setPiece(whiteQueen[0]);
		this.square[0][3].setPiece(whiteKing[1]);
		
		setAsNotFree();
	    }
	
    }
    

    public void setAsNotFree() {
	// PAWN
	for(int i = 0; i < 8; i++) {
	    this.square[6][i].setStatus(false);
	    this.square[1][i].setStatus(false);
	    
	    this.square[6][i].setStatus(false);
	    this.square[1][i].setStatus(false);
	}
	
	// OTHER PIECES
	this.square[0][0].setStatus(false);
	this.square[0][7].setStatus(false);
	this.square[7][0].setStatus(false);
	this.square[7][7].setStatus(false);
	this.square[0][1].setStatus(false);
	this.square[0][6].setStatus(false);
	this.square[7][1].setStatus(false);
	this.square[7][6].setStatus(false);
	this.square[0][2].setStatus(false);
	this.square[0][5].setStatus(false);
	this.square[7][2].setStatus(false);
	this.square[7][5].setStatus(false);
	this.square[0][3].setStatus(false);
	this.square[0][4].setStatus(false);
	this.square[7][3].setStatus(false);
	this.square[7][4].setStatus(false);
    }
    
    public void setColor(Color black, Color white) {
	this.black = black;
	this.white = white;
	for(int i = 0; i < 8; i++) {
	    for(int j = 0; j < 8; j++) {
		if((i + j) % 2 == 0 ) {
		    square[i][j].setBackground(white);
		}
		else {
		    square[i][j].setBackground(black);
		}	
	    }
	}
    }
}
