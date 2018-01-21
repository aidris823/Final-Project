import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ChessBoard extends JPanel {
	public Square[][] square = new Square[8][8];
	//Sets up colors of squares according to RGB configuration:
	public Color black = new Color(150,100,50);
	public Color white = new Color(255,255,255);
	
	//Black Pieces Arrays:
	public Pawn[] bPawns = new Pawn[8];
	public Bishop[] bBishops = new Bishop[2];
	public Knight[] bKnights = new Knight[2];
	public Rook[] bRooks = new Rook[2];
	public Queen[] bQueen = new Queen[1];
	public King[] bKing = new King[1];
	
	//White Piece Arrays:
	public Pawn[] wPawns = new Pawn[8];
	public Bishop[] wBishops = new Bishop[2];
	public Knight[] wKnights = new Knight[2];
	public Rook[] wRooks = new Rook[2];
	public Queen[] wQueen = new Queen[1];
	public King[] wKing = new King[1];
	
	public ChessBoard() {
		setSquares();
		setLayout(new GridLayout(8,8));
		createPieces();
		setPieces();
	}
	
	
	public void setSquares() {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
		//Declares each square in the array to exist:
			square[i][j] = new Square(i,j);
			square[i][j].setStatus(true);
			if ((i+j) % 2 == 0) {
				square[i][j].setBackground(white);
			}
			else {
				square[i][j].setBackground(black);
			}
			}
		}
	}
	
	//Now the pieces exist.
	public void createPieces() {
		//Pawns:
		for (int i = 0; i <= 7; i++) {
			bPawns[i] = new Pawn(false);
			wPawns[i] = new Pawn(true);
		}
		//Minor Pieces and Rooks:
		for (int i = 0; i <= 1; i++) {
			bBishops[i] = new Bishop(false);
			wBishops[i] = new Bishop(true);
			
			bKnights[i] = new Knight(false);
			wKnights[i] = new Knight(true);
			
			bRooks[i] = new Rook(false);
			wRooks[i] = new Rook(true);
		}
		//Kings/Queens:
		bQueen[0] = new Queen(false);
		wQueen[0] = new Queen(true);
		
		bKing[0] = new King(false);
		wKing[0] = new King(true);
	}
	
	//Set up board:
	public void setPieces() {
		//Pawns:
		for (int i = 0; i <= 7; i++) {
			square[1][i].add(bPawns[i]);
			square[1][i].setPiece(bPawns[i]);
			square[1][i].setStatus(false);
			
			square[6][i].add(wPawns[i]);
			square[6][i].setPiece(wPawns[i]);
			square[6][1].setStatus(false);
		}
		//Minor Pieces and Rooks:
		//Black Pieces:
			square[0][0].add(bRooks[0]);
			square[0][0].setPiece(bRooks[0]);
			square[0][0].setStatus(false);
			square[0][7].add(bRooks[1]);
			square[0][7].setPiece(bRooks[1]);
			square[0][7].setStatus(false);
			
			square[0][1].add(bKnights[0]);
			square[0][1].setPiece(bKnights[0]);
			square[0][1].setStatus(false);
			square[0][6].add(bKnights[1]);
			square[0][6].setPiece(bKnights[1]);
			square[0][6].setStatus(false);
			
			square[0][2].add(bBishops[0]);
			square[0][2].setPiece(bBishops[0]);
			square[0][2].setStatus(false);
			square[0][5].add(bBishops[1]);
			square[0][5].setPiece(bBishops[1]);
			square[0][5].setStatus(false);
			
		//White Pieces:
			square[7][0].add(wRooks[0]);
			square[7][0].setPiece(wRooks[0]);
			square[7][0].setStatus(false);
			square[7][7].add(wRooks[1]);
			square[7][7].setPiece(wRooks[1]);
			square[7][7].setStatus(false);
			
			square[7][1].add(wKnights[0]);
			square[7][1].setPiece(wKnights[0]);
			square[7][1].setStatus(false);
			square[7][6].add(wKnights[1]);
			square[7][6].setPiece(wKnights[1]);
			square[7][6].setStatus(false);
			
			square[7][2].add(wBishops[0]);
			square[7][2].setPiece(wBishops[0]);
			square[7][2].setStatus(false);
			square[7][5].add(wBishops[1]);
			square[7][5].setPiece(wBishops[1]);
			square[7][5].setStatus(false);
			
		//Queens:
			square[0][2].add(bQueen[0]);
			square[0][2].setStatus(false);
			square[7][2].add(wQueen[0]);
			square[7][2].setStatus(false);
			
		//Kings:
			square[0][3].add(bKing[0]);
			square[0][3].setStatus(false);
			square[7][3].add(wKing[0]);
			square[7][3].setStatus(false);
		}
	
	}
