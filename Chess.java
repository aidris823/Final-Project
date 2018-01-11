import java.util.Scanner;

public class Chess {

    public static String getMove(Scanner in) {
	String s;
	do {
	    System.out.println("Please enter a move (e.g. \"b1 to c3\"): ");
	    s = in.nextLine();
	    makeMove(s.substring(0,2), s.substring(6);
	} while( s.length() != 8 );
	
	return s;
    }
    
    public static void main(String[] args) {
	Board b = new Board();
	System.out.println(b);
    }
}
