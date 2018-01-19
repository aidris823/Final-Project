import javax.swing.ImageIcon;
public class Queen extends Piece{
	public Queen(boolean color) {
		//If true (AKA it's White), then the imageIcon gets a picture of a White Bishop.
		super(color);
		
		if (color) {
		ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/white_queen.png?raw=true");
		setImageIcon(img);
		}
		else {
			ImageIcon img = new ImageIcon("https://github.com/aidris823/Final-Project/blob/master/images/black_queen.png?raw=true");
			setImageIcon(img);
		}
		setPieceType("Q");
		setPointValue(9);
	}
}
