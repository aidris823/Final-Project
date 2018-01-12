import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RunChess extends JFrame implements ActionListener {

    private Container main;

    


    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	
    }
    
    public static void main(String[] args) {
	Board chess = new Board();
	System.out.println(chess);
    }

}
