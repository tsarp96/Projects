package Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class HelpPanel extends JFrame implements ActionListener {
	
	JLabel label; //Declaring a label instance
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JButton okButton ; //Declaring a button instance
	
	
	public HelpPanel(){ //Constructor
		
		
		this.setTitle("How to Play"); //Constructing title of the frame
		this.setLocationRelativeTo(null); // Frame will be shown in the middle of the screen
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 300);
		this.setLayout(new GridLayout(5,1)); //Assigning a layout to the frame's panel
		this.getContentPane().setBackground(Color.WHITE); //Setting background color as white
		this.setVisible(true);  //Frame shows
		
		//---------Constructing labels with given text strings and given font 'font'-----------//
		
		Font font=new Font("Serif",Font.BOLD,20);
		
		label = new JLabel("1) Use direction keys or W,A,S,D to control your snake .");
		label.setHorizontalAlignment(JLabel.CENTER);    //Specifying the alignment of label's text as "CENTER"
		label.setFont(font);
		this.add(label); //Adding label to the frame
	
		label2 = new JLabel("2) Track your foods and your snakes will be longer.");
		label2.setHorizontalAlignment(JLabel.CENTER);    //Specifying the alignment of label's text as "CENTER"
		label2.setFont(font);
		this.add(label2);  //Adding label to the frame
		
		label3 = new JLabel("3) Do not crash to the walls and your own body.");
		label3.setHorizontalAlignment(JLabel.CENTER);    //Specifying the alignment of label's text as "CENTER"
		label3.setFont(font);
		this.add(label3);  //Adding label to the frame
		
		label4 = new JLabel("4) You can use 'P' and 'enter' keys for pause and resume.");
		label4.setHorizontalAlignment(JLabel.CENTER);    //Specifying the alignment of label's text as "CENTER"
		label4.setFont(font);
		this.add(label4);  //Adding label to the frame
		
		
		//------Constructing a button with given text string, with the font 'font' and with a border------//
		
		okButton = new JButton("OK");
		okButton.setFont(font); 
		okButton.setHorizontalAlignment(JButton.CENTER);   //Specifying the alignment of button's text as "CENTER"
		okButton.addActionListener(this);
		Border brd= BorderFactory.createRaisedBevelBorder();
		okButton.setBorder(brd);
		
		this.add(okButton);   //Adding button to the frame
		
		
	}
	public void actionPerformed(ActionEvent e){
		dispose();
	}
}



