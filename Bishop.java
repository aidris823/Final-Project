import javax.swing.ImageIcon;

public class Bishop extends Piece {
	

    public Bishop() {
	imageIcon = new ImageIcon("./images/white_bishop.png");
	setIcon(imageIcon);
    }
    
    public Bishop(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_bishop.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_bishop.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "bishop";
    }
}
