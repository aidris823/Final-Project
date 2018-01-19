import javax.swing.ImageIcon;
public class King extends Piece{
	public King(boolean color) {
		//If true (AKA it's White), then the imageIcon gets a picture of a White Bishop.
		super(color);
		
		if (color) {
		ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/white_king.png?raw=true");
		setImageIcon(img);
		}
		else {
			ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/black_king.png?raw=true");
			setImageIcon(img);
		}
		setPieceType("K");
		//If you lose the King you lose so I can pretty much give this any int value I want.
		setPointValue(99999);
	}
}
