import javax.swing.ImageIcon;


public class Knight extends Piece{
    public Knight() {
	imageIcon = new ImageIcon("./images/white_knight.png");
	setIcon(imageIcon);
    }
    
    public Knight(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_knight.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_knight.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "knight";
    }
}
