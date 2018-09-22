package Snake;

// necessary imports :)
import javax.swing.*;
import java.util.*;
//import java.util.Timer;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameScreen extends JPanel implements ActionListener{
	//Board Class will added to a JFrame as a JPanel.
	//Define the constants 
	private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 3600;
    //private final int RAND_POS = 59;
    //DELAY variable is declared for the timer.
    private final int DELAY = 90;  // AZALTTIKÇA YILAN HIZLANIR 
    //Timer is declared.
    private Timer timer ;
    //Boardtaki tüm noktalar yýlana dahil olabilir
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private int dots ; // At the start of the game snake has 3 part.
    //The coordinates of the cookie is declared.
    private int cookie_x ; 
    private int cookie_y ;
    //Images are declared.
    private Image hamburger ;
    private Image noodle ;
    private Image trunk ;
    private Image gb;
    private Image obstacle ;
    private int obstacle_x; // small obs.
    private int obstacle_y ;// small obs.
    private int obstacle_x1;// small obs.
    private int obstacle_y1;// small obs.
    private int obstacle_x2;// small obs.
    private int obstacle_y2;// small obs.
    private int obstacle_x3;// small obs.
    private int obstacle_y3;// small obs.
    //----------------BIG OBSTACLE COORDINATESDECLARATION[ladder1]---------------
    private int ladderObstacle_x1 = 190;
    private int ladderObstacle_y1 = 190;
    private int ladderObstacle_x2 = 200;
    private int ladderObstacle_y2 = 200;
    private int ladderObstacle_x3 = 210;
    private int ladderObstacle_y3 = 210;
    private int ladderObstacle_x4 = 220;
    private int ladderObstacle_y4 = 220;
    private int ladderObstacle_x5 = 230;
    private int ladderObstacle_y5 = 230;
   //--------------------------------------------------
  //----------------BIG OBSTACLE COORDINATESDECLARATION[ladder2]---------------
    private int ladder2Obstacle_x1 = 390;
    private int ladder2Obstacle_y1 = 390;
    private int ladder2Obstacle_x2 = 400;
    private int ladder2Obstacle_y2 = 400;
    private int ladder2Obstacle_x3 = 410;
    private int ladder2Obstacle_y3 = 410;
    private int ladder2Obstacle_x4 = 420;
    private int ladder2Obstacle_y4 = 420;
    private int ladder2Obstacle_x5 = 430;
    private int ladder2Obstacle_y5 = 430;
  //--------------------------------------------------
  //----------------BIG OBSTACLE COORDINATESDECLARATION[ladder3]---------------
    private int ladder3Obstacle_x1 = 190;
    private int ladder3Obstacle_y1 = 430;
    private int ladder3Obstacle_x2 = 200;
    private int ladder3Obstacle_y2 = 420;
    private int ladder3Obstacle_x3 = 210;
    private int ladder3Obstacle_y3 = 410;
    private int ladder3Obstacle_x4 = 220;
    private int ladder3Obstacle_y4 = 400;
    private int ladder3Obstacle_x5 = 230;
    private int ladder3Obstacle_y5 = 390;
   //--------------------------------------------------
  //----------------BIG OBSTACLE COORDINATESDECLARATION[ladder4]---------------
    private int ladder4Obstacle_x1 = 430;
    private int ladder4Obstacle_y1 = 190;
    private int ladder4Obstacle_x2 = 420;
    private int ladder4Obstacle_y2 = 200;
    private int ladder4Obstacle_x3 = 410;
    private int ladder4Obstacle_y3 = 210;
    private int ladder4Obstacle_x4 = 400;
    private int ladder4Obstacle_y4 = 220;
    private int ladder4Obstacle_x5 = 390;
    private int ladder4Obstacle_y5 = 230;
    //--------------------------------------------------
    //Boolean values for the checkings.
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean GameOn = true;
    protected boolean gameover = false ;
    public int score = 0;
    
    
    public GameScreen(){ // Constructor of the GameScreen
  
    	addKeyListener(new KeyboardListener());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        GameOn();
    }
    
    private void loadImages() { 
    // this method provide us to adding necessary pictures from file to board
        ImageIcon body = new ImageIcon("img/greenSquare.png");
        trunk = body.getImage();
        
        ImageIcon cookie = new ImageIcon("img/hmbg1.jpg");
        hamburger = cookie.getImage();

        ImageIcon head = new ImageIcon("img/redSquare.png");
        noodle = head.getImage();
        
        ImageIcon backgroundGame = new ImageIcon("img/best.gif");
        gb = backgroundGame.getImage();
        
        ImageIcon obs = new ImageIcon("img/snakeSkinEx1.jpg");
        obstacle = obs.getImage();
    }
    
    private void GameOn() {
    	//Firstly the snake has been located.
        dots = 3; // Beginning of the game snake has 3 part.
        for (int z = 0; z < dots; z++) { 
            x[z] = 50 - z * 10; // dots are located right to the left.
            y[z] = 50; // y-axis is stationary
        }
        locateFood(); // After the snake , food has located.
        //--------LOCATING OBSTACLES---------------------------------
        locateObstacle();
        //----------------------------------------------------
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) { // basic paintComponent method
        super.paintComponent(g);
        Draw(g);
    }
    
    private void Draw(Graphics g) {
        
        if (GameOn) {
        	g.drawImage(gb,0,0,getSize().width, getSize().height, null);
            g.drawImage(hamburger, cookie_x, cookie_y, this);
            //---------------DRAWING OBSTACLES---------------------
            //--------------DRAING SMALL OBSTACLES-----------------
            g.drawImage(obstacle, obstacle_x, obstacle_y, this);
            g.drawImage(obstacle, obstacle_x1, obstacle_y1, this);
            g.drawImage(obstacle, obstacle_x2, obstacle_y2, this);
            g.drawImage(obstacle, obstacle_x3, obstacle_y3, this);
            //-----------DRAWING Ladder1 OBSTACLE------------------
            g.drawImage(obstacle, ladderObstacle_x1 , ladderObstacle_y1, this);
            g.drawImage(obstacle, ladderObstacle_x2 , ladderObstacle_y2, this);
            g.drawImage(obstacle, ladderObstacle_x3 , ladderObstacle_y3, this);
            g.drawImage(obstacle, ladderObstacle_x4 , ladderObstacle_y4, this);
            g.drawImage(obstacle, ladderObstacle_x5 , ladderObstacle_y5, this);
          
            //-----------DRAWING Ladder2 OBSTACLE------------------
            g.drawImage(obstacle, ladder2Obstacle_x1 , ladder2Obstacle_y1, this);
            g.drawImage(obstacle, ladder2Obstacle_x2 , ladder2Obstacle_y2, this);
            g.drawImage(obstacle, ladder2Obstacle_x3 , ladder2Obstacle_y3, this);
            g.drawImage(obstacle, ladder2Obstacle_x4 , ladder2Obstacle_y4, this);
            g.drawImage(obstacle, ladder2Obstacle_x5 , ladder2Obstacle_y5, this);
            
            //-------------------------------------------------
          //-----------DRAWING Ladder3 OBSTACLE------------------
            g.drawImage(obstacle, ladder3Obstacle_x1 , ladder3Obstacle_y1, this);
            g.drawImage(obstacle, ladder3Obstacle_x2 , ladder3Obstacle_y2, this);
            g.drawImage(obstacle, ladder3Obstacle_x3 , ladder3Obstacle_y3, this);
            g.drawImage(obstacle, ladder3Obstacle_x4 , ladder3Obstacle_y4, this);
            g.drawImage(obstacle, ladder3Obstacle_x5 , ladder3Obstacle_y5, this);
            
           //-------------------------------------------------
          //-----------DRAWING Ladder4 OBSTACLE------------------
            g.drawImage(obstacle, ladder4Obstacle_x1 , ladder4Obstacle_y1, this);
            g.drawImage(obstacle, ladder4Obstacle_x2 , ladder4Obstacle_y2, this);
            g.drawImage(obstacle, ladder4Obstacle_x3 , ladder4Obstacle_y3, this);
            g.drawImage(obstacle, ladder4Obstacle_x4 , ladder4Obstacle_y4, this);
            g.drawImage(obstacle, ladder4Obstacle_x5 , ladder4Obstacle_y5, this);
            //-------------------------------------------------

            for (int z = 0; z < dots; z++) { // Snake has been created.
                if (z == 0) {
                    g.drawImage(noodle, x[z], y[z], this);
                } else {
                    g.drawImage(trunk, x[z], y[z], this);
                }
            }

        } else {
        	
            gameOver(g); // Game Over screen is drew.
           
        }        
    }
    
    private void gameOver(Graphics g) { 
    	//g.drawImage(gb,0,0,getSize().width, getSize().height, null);
        String msg = "Game Over ! " +  gettName()  + "'s" + " score: " + score;
        
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
        gameover=true;
    }
    
    
    
    private void checkFood() {
    	
        if ((x[0] == cookie_x) && (y[0] == cookie_y)) { 
        // If snake's head and food is overlapped scores ++ and snake will be grow;
        	score++;
            dots++;
            locateFood(); // 
        }
        //-----------------------SMALL OBSTACLE CONTROL---------------------------
        if ((obstacle_x == cookie_x) && (obstacle_y == cookie_y)) {
            locateObstacle();
        }
        if ((obstacle_x1 == cookie_x) && (obstacle_y1 == cookie_y)) {
            locateObstacle();
        }
        if ((obstacle_x2 == cookie_x) && (obstacle_y2 == cookie_y)) {
            locateObstacle();
        }
        if ((obstacle_x3 == cookie_x) && (obstacle_y3 == cookie_y)) {
            locateObstacle();
        }
        //-------------LADDER1 OBSTACLE CONTROL-----------------------
        if ((ladderObstacle_x1 == cookie_x) && (ladderObstacle_y1 == cookie_y)) {
            locateObstacle();
        }
        if ((ladderObstacle_x2 == cookie_x) && (ladderObstacle_y2 == cookie_y)) {
            locateObstacle();
        }
        if ((ladderObstacle_x3 == cookie_x) && (ladderObstacle_y3 == cookie_y)) {
            locateObstacle();
        }
        if ((ladderObstacle_x4 == cookie_x) && (ladderObstacle_y4 == cookie_y)) {
            locateObstacle();
        }
        if ((ladderObstacle_x5 == cookie_x) && (ladderObstacle_y5 == cookie_y)) {
            locateObstacle();
        }
       //---------------------------------------------------------------
      //-------------LADDER2 OBSTACLE CONTROL-----------------------
        if ((ladder2Obstacle_x1 == cookie_x) && (ladder2Obstacle_y1 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder2Obstacle_x2 == cookie_x) && (ladder2Obstacle_y2 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder2Obstacle_x3 == cookie_x) && (ladder2Obstacle_y3 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder2Obstacle_x4 == cookie_x) && (ladder2Obstacle_y4 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder2Obstacle_x5 == cookie_x) && (ladder2Obstacle_y5 == cookie_y)) {
            locateObstacle();
        }
       //------------------------------------------------------------------ 
      //-------------LADDER3 OBSTACLE CONTROL-----------------------
        if ((ladder3Obstacle_x1 == cookie_x) && (ladder3Obstacle_y1 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder3Obstacle_x2 == cookie_x) && (ladder3Obstacle_y2 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder3Obstacle_x3 == cookie_x) && (ladder3Obstacle_y3 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder3Obstacle_x4 == cookie_x) && (ladder3Obstacle_y4 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder3Obstacle_x5 == cookie_x) && (ladder3Obstacle_y5 == cookie_y)) {
            locateObstacle();
        }
       //------------------------------------------------------------------
      //-------------LADDER4 OBSTACLE CONTROL-----------------------
        if ((ladder4Obstacle_x1 == cookie_x) && (ladder4Obstacle_y1 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder4Obstacle_x2 == cookie_x) && (ladder4Obstacle_y2 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder4Obstacle_x3 == cookie_x) && (ladder4Obstacle_y3 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder4Obstacle_x4 == cookie_x) && (ladder4Obstacle_y4 == cookie_y)) {
            locateObstacle();
        }
        if ((ladder4Obstacle_x5 == cookie_x) && (ladder4Obstacle_y5 == cookie_y)) {
            locateObstacle();
        }
       //------------------------------------------------------------------
        
    }
    
    private void move() {

        for (int z = dots; z > 0; z--) { 
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
    
    private void checkSuperposition() {

        for (int z = dots; z > 0; z--) { // Snake's head and its own body is checked with array.

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                GameOn = false;
            }
        }

        // Snake's head and walls is checked.
        if (y[0] >= B_HEIGHT) {
            GameOn = false;
        }

        if (y[0] < 0) {
            GameOn = false;
        }

        if (x[0] >= B_WIDTH) {
            GameOn = false;
        }

        if (x[0] < 0) {
            GameOn = false;
        }
        //--------------------OBSTACLE AND SNAKE LOCATE-CONTROL---------------
        if ((x[0] == obstacle_x) && (y[0] == obstacle_y)) {
            GameOn = false;
        }
        if ((x[0] == obstacle_x1) && (y[0] == obstacle_y1)) {
            GameOn = false;
        }
        if ((x[0] == obstacle_x2) && (y[0] == obstacle_y2)) {
            GameOn = false;
        }
        if ((x[0] == obstacle_x3) && (y[0] == obstacle_y3)) {
            GameOn = false;
        }
        //---------LADDER1 OBSTACLE AND SNAKE LOCATE CONTROL---------
        if ((x[0] == ladderObstacle_x1) && (y[0] == ladderObstacle_y1)) {
            GameOn = false;
        }
        if ((x[0] == ladderObstacle_x2) && (y[0] == ladderObstacle_y2)) {
            GameOn = false;
        }
        if ((x[0] == ladderObstacle_x3) && (y[0] == ladderObstacle_y3)) {
            GameOn = false;
        }
        if ((x[0] == ladderObstacle_x4) && (y[0] == ladderObstacle_y4)) {
            GameOn = false;
        }
        if ((x[0] == ladderObstacle_x5) && (y[0] == ladderObstacle_y5)) {
            GameOn = false;
        }
       //-------------------------------------------------------
      //---------LADDER2 OBSTACLE AND SNAKE LOCATE CONTROL---------
        if ((x[0] == ladder2Obstacle_x1) && (y[0] == ladder2Obstacle_y1)) {
            GameOn = false;
        }
        if ((x[0] == ladder2Obstacle_x2) && (y[0] == ladder2Obstacle_y2)) {
            GameOn = false;
        }
        if ((x[0] == ladder2Obstacle_x3) && (y[0] == ladder2Obstacle_y3)) {
            GameOn = false;
        }
        if ((x[0] == ladder2Obstacle_x4) && (y[0] == ladder2Obstacle_y4)) {
            GameOn = false;
        }
        if ((x[0] == ladder2Obstacle_x5) && (y[0] == ladder2Obstacle_y5)) {
            GameOn = false;
        }
        //--------------------------------------------------------------------
      //---------LADDER3 OBSTACLE AND SNAKE LOCATE CONTROL---------
        if ((x[0] == ladder3Obstacle_x1) && (y[0] == ladder3Obstacle_y1)) {
            GameOn = false;
        }
        if ((x[0] == ladder3Obstacle_x2) && (y[0] == ladder3Obstacle_y2)) {
            GameOn = false;
        }
        if ((x[0] == ladder3Obstacle_x3) && (y[0] == ladder3Obstacle_y3)) {
            GameOn = false;
        }
        if ((x[0] == ladder3Obstacle_x4) && (y[0] == ladder3Obstacle_y4)) {
            GameOn = false;
        }
        if ((x[0] == ladder3Obstacle_x5) && (y[0] == ladder3Obstacle_y5)) {
            GameOn = false;
        }
        //--------------------------------------------------------------------
      //---------LADDER4 OBSTACLE AND SNAKE LOCATE CONTROL---------
        if ((x[0] == ladder4Obstacle_x1) && (y[0] == ladder4Obstacle_y1)) {
            GameOn = false;
        }
        if ((x[0] == ladder4Obstacle_x2) && (y[0] == ladder4Obstacle_y2)) {
            GameOn = false;
        }
        if ((x[0] == ladder4Obstacle_x3) && (y[0] == ladder4Obstacle_y3)) {
            GameOn = false;
        }
        if ((x[0] == ladder4Obstacle_x4) && (y[0] == ladder4Obstacle_y4)) {
            GameOn = false;
        }
        if ((x[0] == ladder4Obstacle_x5) && (y[0] == ladder4Obstacle_y5)) {
            GameOn = false;
        }
        //--------------------------------------------------------------------
        
        if(!GameOn) { // for record and holding game's scores
          
        	timer.stop();
        	
           	try{
        	     File f= new File("scoresHolder/scores.txt");
         	     FileWriter fw= new FileWriter(f,true);
         	     BufferedWriter bf = new BufferedWriter(fw);
                 bf.write(score + " ");
                 bf.close();
         	       }catch(Exception e){ e.printStackTrace();} 
            	
        }
    }
    
    private void locateFood() { // food is created at a random location.

        int r = (int) (Math.random() * 59);
        cookie_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * 59);
        cookie_y = ((r * DOT_SIZE));
    }
    //---------------LOCATING OBSTACLES---------------------------------------
    private void locateObstacle(){
    	
    	int obs1 = (int)(Math.random() * 59);
    	obstacle_x = ((obs1 * DOT_SIZE));
    	obs1 = (int)(Math.random() * 59);
    	obstacle_y = ((obs1 * DOT_SIZE));
    	
    	int obs2 = (int)(Math.random() * 59);
    	obstacle_x1 = ((obs2 * DOT_SIZE));
    	obs2 = (int)(Math.random() * 59);
    	obstacle_y1 = ((obs2 * DOT_SIZE));
    	
    	int obs3 = (int)(Math.random() * 59);
    	obstacle_x2 = ((obs3 * DOT_SIZE));
    	obs3 = (int)(Math.random() * 59);
    	obstacle_y2 = ((obs3 * DOT_SIZE));
    	
    	int obs4 = (int)(Math.random() * 59);
    	obstacle_x3 = ((obs4 * DOT_SIZE));
    	obs4 = (int)(Math.random() * 59);
    	obstacle_y3 = ((obs4 * DOT_SIZE));
    	
    }
    //--------------------------------------------------------------------------
    
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (GameOn) {
            checkFood();
            checkSuperposition();
            move();
        }
        repaint();
	}
	
	private class KeyboardListener extends KeyAdapter { 

        public void keyPressed(KeyEvent e) { 
        // assigning the booelean values for the movement with the listener

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT || key== KeyEvent.VK_A) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && (!leftDirection)) { 
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && (!downDirection)) { 
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            // pause part
            if((key == KeyEvent.VK_P)){
            	timer.stop();
            }
            if((key == KeyEvent.VK_ENTER || key == KeyEvent.VK_E)){
            	timer.start();
            }
            
            
            //RESTART PART
            /*
            
            if (key==KeyEvent.VK_R){
            	int k = 0 ; 
            	if(gameover && (score>=5) && k==0){
            		GameOn = true;
            		k++;
            		timer.start();
            		
            	}
             
            	 
            }
            
            */
        }
	}
	
	public String gettName(){ // provide to get player's name from the txt file.
		
		try {
			
			FileReader fr= new FileReader("scoresHolder/names.txt");
			BufferedReader br = new BufferedReader(fr);
			String nameee = br.readLine();
			br.close();
			
			return nameee ;
		} //end of try
			
		    catch(IOException e){ return "warning" ;}
			
	}
	
	
}


