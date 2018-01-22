import javax.swing.ImageIcon;
	

public class Pawn extends Piece {
    public Pawn() {
	imageIcon = new ImageIcon("./images/white_pawn.png");
	setIcon(imageIcon);
    }
    
    public Pawn(String color) {
	if(color == "white") {
	    this.color = "white";
	    imageIcon = new ImageIcon("./images/white_pawn.png");
	    setIcon(imageIcon);
	}
	else {
	    this.color = "black";
	    imageIcon = new ImageIcon("./images/black_pawn.png");
	    setIcon(imageIcon);
	}
    }
    
    public String getColor() {
	return this.color;
    }
    
    public String getPieceType() {
	return "pawn";
    }
}
