package Snake;

import java.io.*;
import javax.swing.JFrame;

public class Snake extends JFrame {
	
    public Snake() {
    	GameScreen gs= new GameScreen();
        add(gs);
        setResizable(false);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
 }


	

