package Snake;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class MainV2 {

	// main just create a BackgroundPanelv2 for the start of the program
	public static void main(String[] args) {
		BackgroundPanelv2 backgroundv2 = new BackgroundPanelv2();
	}
}

// Listener Section

class HelpAction implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		 HelpPanel h1=  new HelpPanel();
	      h1.setVisible(true);
	}

}

class ScoresAction implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		
		HighScoresPanel scoresPanel = new HighScoresPanel();
		scoresPanel.setVisible(true);
	}
}

class ExitAction implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}
}

class StartAction implements ActionListener{
	public void actionPerformed(ActionEvent e){
		PlayerLoginPanel PlayerLogin = new PlayerLoginPanel();
		PlayerLogin.setVisible(true);
			
	}
}


