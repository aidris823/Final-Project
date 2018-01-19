import javax.swing.ImageIcon;
public class Bishop extends Piece{
	public Bishop(boolean color) {
		//If true (AKA it's White), then the imageIcon gets a picture of a White Bishop.
		super(color);
		
		if (color) {
		//Source: Wikipedia
		ImageIcon img = new ImageIcon("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Chess_blt45.svg/2000px-Chess_blt45.svg.png");
		setImageIcon(img);
		}
		else {
		//Source: Wikipedia
			ImageIcon img = new ImageIcon("https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Chess_bdt45.svg/2000px-Chess_bdt45.svg.png");
			setImageIcon(img);
		}
		setPieceType("B");
	}
}
