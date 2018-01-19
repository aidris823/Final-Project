import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ChessBoard {
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
		
	}
	
	
	public void setSquarePositions() {
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
	public void setPieces() {
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
	public void initializeBoard() {
		//Pawns:
		for (int i = 0; i <= 7; i++) {
			square[1][i].add(bPawns[i]);
			square[1][i].setPiece(bPawns[i]);
			square[6][i].add(wPawns[i]);
			square[6][i].add(wPawns[i]);
			
		}
	}
}
