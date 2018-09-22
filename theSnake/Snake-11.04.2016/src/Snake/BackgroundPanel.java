package Snake;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {

	public BackgroundPanel(LayoutManager l) { // Backgroundpanel's constructor with LayoutManager
		super.setLayout(l);
	}

	protected void paintComponent(Graphics g){ // This method is used for BackgroundImage
		super.paintComponent(g);
		
		Image image = new ImageIcon("img/betul1.png").getImage(); // Image declaration and getting it.
		g.drawImage(image, 0, 0,getSize().width, getSize().height, null); //Drawing image respect to width and hight
		
	}

}

