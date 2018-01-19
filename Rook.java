import javax.swing.ImageIcon;
public class Rook extends Piece{
	public Rook(boolean color) {
		//If true (AKA it's White), then the imageIcon gets a picture of a White Bishop.
		super(color);
		
		if (color) {
		ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/white_rook.png?raw=true");
		setImageIcon(img);
		}
		else {
			ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/black_rook.png?raw=true");
			setImageIcon(img);
		}
		setPieceType("R");
		setPointValue(5);
	}
}
