package Snake;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;


public class BackgroundPanelv2 extends JFrame {
	// Declaration part
	JButton startButton;
	JButton howToPlayButton;
	JButton scoresButton;
	JButton exitButton;
	JButton help;
	ImageIcon soru;
	JPanel h;
	JPanel o;
	JPanel p;
	BackgroundPanel backgroundpanel;
	JPanel panel;
	Border b;
	Font fnt;
	
	
	public BackgroundPanelv2(){ // Constructor
		
		backgroundpanel = new BackgroundPanel(new BorderLayout());
		panel = new JPanel(new GridLayout(7,3,50,50));
		panel.setOpaque(false);
		
		b= BorderFactory.createRaisedBevelBorder();
		fnt=new Font("Impact",Font.ITALIC,25);
		
		//---------------Constructing buttons and setting their font------------------------------
				startButton = new JButton("Start");
				startButton.setFont(fnt);
				howToPlayButton = new JButton("How to Play ?");
				howToPlayButton.setFont(fnt);
				scoresButton = new JButton("High Scores");
				scoresButton.setFont(fnt);
				exitButton = new JButton("Exit");
				exitButton.setFont(fnt);
		
		//--------------A loop for placing buttons to the GridLayout's proper cell--------------
				for(int i=0;i<=20;i++){
					if(i==3){
						ImageIcon soru=new ImageIcon("img/sorulogo.png"); //Getting a image icon for the button which is in the third cell
						JButton help=new JButton(); //Constructing a button
						help.setIcon(soru);//Adding image icon to the button
						help.setToolTipText("Need some help?"); //An explanation for the button
						help.setBorder(b); //Set the buttons border
						help.addActionListener(new HelpAction());
						JPanel h = new JPanel(); //Constructing a new panel in the third cell 
						h.setOpaque(false);
						h.setLayout(new GridLayout(2,2)); //Panel using gridLayout layout manager
						
						for(int j=0;j<=3;j++){  // A loop for placing button to any cell that into the third cell
							if(j==1){
								h.add(help); 
							}
							else{
								JPanel o= new JPanel();
								o.setOpaque(false);
								h.add(o);
							}
						}
						
						panel.add(h);  //Adding panel 'h' to the panel 'panel'
						
					}
					if(i==8 ){    //Adding start button to the 8th cell and set it's border
						panel.add(startButton);
						startButton.setBorder(b);
						startButton.addActionListener(new StartAction());
						
						
					}
					else if(i==12){  //Adding last scores button to the 12th cell and set it's border
						panel.add(scoresButton);
						scoresButton.setBorder(b);
						scoresButton.addActionListener(new ScoresAction());
					}
					else if(i==16){  //Adding exit button to the 16th cell and set it's border
						panel.add(exitButton);
						exitButton.setBorder(b);
						exitButton.addActionListener(new ExitAction());
					}
					else{  //Adding transparent panels to the other cells 
						JPanel p=new JPanel();
					    p.setOpaque(false);
						panel.add(p);}
				}
				
				backgroundpanel.add(panel);  //Adding panel to the backgroundpanel
				
				this.setTitle("SNAKE : Eating is bless !");
				this.add(backgroundpanel);
				this.setSize(800, 700);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
				this.setLocationRelativeTo(null);
				
				
	}
}
