import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class Piece extends JLabel{
	//Color field for a piece.  Of course, White if true and Black if false.
	private boolean isWhite;
	//ImageIcon for each image of a piece.
	private ImageIcon imageIcon;
	//Declares the piece's type via a string.
	private String pieceType;
	private int pointValue;
	
	/* Names for all pieces:
	 * 
	 "P" = Pawn
	 "N" = Knight
	 "B" = Bishop
	 "R" = Rook
	 "Q" = Queen
	 "K" = King
	 
	 */
	public Piece(boolean color) {
		isWhite = color;
	}
	public Piece(String piece, ImageIcon image) {
		pieceType = piece;
		imageIcon = image;
	}
	public Piece(String piece, ImageIcon image, boolean color) {
		pieceType = piece;
		imageIcon = image;
		isWhite = color;
	}
	//Getters and setters:
	
	//Intentionally NO setters for color, as pieces don't change color mid-game.
	public boolean getColor() {
		return isWhite;
	}
	
	public void setImageIcon(ImageIcon icon) {
		imageIcon = icon;
	}
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	
	public void setPieceType(String piece) {
		pieceType = piece;
	}
	public String getPieceType() {
		return pieceType;
	}
	public void setPointValue(int points) {
		pointValue = points;
	}
}
