package Snake;


import java.awt.*; // Necessary imports.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PlayerLoginPanel extends JFrame implements ActionListener {
	
	//Declartions of Components
	JButton okButton;
	JLabel label;
	JTextField textfield;
	JPanel MainPanel;
	public String Username ;
	
	public PlayerLoginPanel(){ // PlayerLoginPanel's Consturctor
		//Setting Section of the Frame
		this.setTitle("Login");
		this.setSize(350,100);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		MainPanel = new JPanel(new BorderLayout()); // Creating a panel 
		
		//Label is created and added to main panel with BorderLayout
		label = new JLabel("Enter Your Name");
		MainPanel.add(label , BorderLayout.NORTH);
		//textfield is created and added to main panel with BorderLayout
		textfield = new JTextField("enter a name");
		
		MainPanel.add(textfield , BorderLayout.CENTER);
		//Label is created and added to main panel with BorderLayout
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		Border brd2= BorderFactory.createRaisedBevelBorder(); //"Border" for the button
		okButton.setBorder(brd2);
		MainPanel.add(okButton , BorderLayout.EAST);
		
		this.add(MainPanel); // MainPanel is added to Frame
		
		
		}
		
		public void actionPerformed(ActionEvent e){
			
			try{
	   	         File name= new File("scoresHolder/names.txt");
	    	     FileWriter fw2= new FileWriter(name);
	    	     BufferedWriter bf2 = new BufferedWriter(fw2);
	              bf2.write(textfield.getText()); // taking input from user with "getText()" ;
	              bf2.close();
	    	    }catch(Exception e2){ e2.printStackTrace();} 
			
			Snake gsnake = new Snake();
			gsnake.setVisible(true);
			this.dispose();
		}

		
	
		
		
		
	
}