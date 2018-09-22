package Snake;

import java.awt.*;   // Necessary imports.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class HighScoresPanel extends JFrame implements ActionListener {
	
	//Declarations of components
	JLabel number1; 
	JLabel number2;
	JLabel number3;
	JPanel panel ; 
	JButton okButton;
     
	
	public HighScoresPanel(){ // HighScoresPanel's Constructor
		
		//Setting section for the Frame
		this.setTitle("High Scores");
		this.setSize(400,400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		File f = null;
		FileReader fr  =null;
		int array[] = null;
		// Holding Scores
		try {
		
		fr= new FileReader("scoresHolder/scores.txt");
		BufferedReader br = new BufferedReader(fr);
		String scores = null;

		while((scores=br.readLine()) !=  null){
			
			    scores.split(" "); // read values are seperated with the split method
		        array = new int[(scores.length())];		          		        
		      
		   for(int i=0; i< (scores.split(" ")).length ;i++){
			   																				
			       array[i]=Integer.parseInt(scores.split(" ")[i]);
			
		   }	
		   
		br.close();
	  } //end of while loop
		
	} //end of try
		
	    catch(IOException e){}
		
		finally{
			
			 try {
				 fr.close();
				
				
			} catch (IOException e) {}
			
			System.out.println("");
			
			for(int k=0; k< array.length ; k++){ // simple sorting algorithm
				for(int l=k+1 ; l< array.length; l++){
					int swap;
					 if(array[k]<array[l]){
						 swap=array[k];
						 array[k]=array[l];
						 array[l]=swap;
					 }
			
				}
			}
		 	
			
			number1 = new JLabel("High Score is "+ array[0]);
			
			number2 = new JLabel("2. "+ array[1]);
			
			number3 = new JLabel("3. "+ array[2]);
			
			
			  panel = new JPanel(new GridLayout(4,1));
			  okButton = new JButton("OK");
			  okButton.addActionListener(this);
			  
			  for(int i=1;i<=4;i++){
			   if(i==4)	  
			    panel.add(okButton);//Button is added to panel
			   else if (i==1)
			    panel.add(number1);  //Adding labels to Frame's own panel which has GridLayout
			   else if (i==2)
			    panel.add(number2);
			   else if(i==3)
			    panel.add(number3);
			  }
				
			  this.add(panel);  //Adding panel to Frame's own panel which has GridLayout
			
		  }
		
		
		
	
	}
	
	public void actionPerformed(ActionEvent e){
		dispose();
		
	}
	
}
