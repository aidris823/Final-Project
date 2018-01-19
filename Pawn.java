import javax.swing.ImageIcon;
public class Pawn extends Piece{
	public Pawn(boolean color) {
		//If true (AKA it's White), then the imageIcon gets a picture of a White Bishop.
		super(color);
		
		if (color) {
		ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/white_pawn.png?raw=true");
		setImageIcon(img);
		}
		else {
			ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/black_pawn.png?raw=true");
			setImageIcon(img);
		}
		setPieceType("P");
		setPointValue(1);
	}
}
