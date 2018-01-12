import javax.swing.ImageIcon;

public class Queen extends Piece {
    public Queen() {
	imageIcon = new ImageIcon("./images/white_queen.png");
	setIcon(imageIcon);
    }
    
    public Queen(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_queen.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_queen.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "queen";
    }
}
