import javax.swing.ImageIcon;


public class Rook extends Piece{
    public Rook() {
	imageIcon = new ImageIcon("./images/white_rook.png");
	setIcon(imageIcon);
    }
    
    public Rook(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_rook.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_rook.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    
    public String getPieceType() {
	return "rook";
    }
}
