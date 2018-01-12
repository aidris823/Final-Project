import javax.swing.ImageIcon;

public class King extends Piece {
    public King() {
	imageIcon = new ImageIcon("./images/white_king.png");
	setIcon(imageIcon);
    }
   
    public King(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_king.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_king.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "king";
    }
}
