import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.color.*; 

import javax.swing.colorchooser.*;

public class Ballmachine extends JFrame implements KeyListener{
	
	private int x,y,diameter,layoutX, layoutY, speedX, speedY, locationX, locationY;
	private JButton changeColor, rightCont;
	private Color ballColor, screenColor;
	private JPanel panel;
	private JCheckBox random;
	
	
	
	public Ballmachine(){
		 layoutX=500;
		 layoutY=300;
		 x=100;
		 y=100;
		 diameter=100;
		 locationX=x+(diameter/2);
		 locationY=y+(diameter/2);	
		 setLayout(null);
	     setSize(layoutX,layoutY);
	     addKeyListener(this);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false);
	     setVisible(true);
	    
	     ballColor=Color.BLUE;
	     screenColor=Color.PINK;
	     setBackground(screenColor);
	     
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(ballColor);
		g.fillOval(x, y, diameter, diameter);
	    
	}
	
	
	public void changeColor(){
		Random r=new Random();
		ballColor=new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		repaint();
	}
	public void changeScreen(){
		Random r=new Random();
		screenColor=new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		setBackground(screenColor);
		repaint();
	}

	
	
	
	/*	public void move_Right(){
			while(x>0){
				moveRight();
				try{
					Thread.sleep(10);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}*/
	
	
	
	public void moveRight(){
		if(locationX+(diameter/2)<layoutX){
		  x +=5;
		  locationX +=5;
		  repaint();
		  //System.out.println(locationX);

		  
		}
		 else{
		 locationX=450;
		 repaint();
			
		}
    }
	
	public void moveLeft(){
		if(locationX>50){
		  x-=5;
		  locationX -=5;
		  repaint();
		  //System.out.println(locationX);
		}
		else{
			locationX=50;
			repaint();
			  //System.out.println(locationX);

		}
	}
	public void moveUp(){
		if(locationY>70){
		y-=5;
		locationY -=5;
		repaint();
		//System.out.println(locationY);
		}
		else{
			locationY=70;
			repaint();
			//System.out.println(locationY);

		}
	}
	public void moveDown(){
		if(locationY+(diameter/2)<layoutY){
		y+=5;
		locationY +=5;
		repaint();
		}
		else{
			locationY=250;
		}
	}
	
	public void moveLeftFast(){
		x-=10;
		repaint();
	}
	public void moveUpFast(){
		y-=10;
		repaint();
	}
	public void moveDownFast(){
		y+=10;
		repaint();
	}
	
	public void moveRightFast(){
		x +=10;
		repaint();
	}
	

//KEY CODES:
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		switch(arg0.getKeyCode()) {
		    case KeyEvent.VK_DOWN:
	
		    	
		    	moveDown();
		    	break;
		    	
		    case KeyEvent.VK_UP:
		    	moveUp();
		    	break;
		    
		    case KeyEvent.VK_RIGHT:
		    	moveRight();
		        
		    	break;
		   
		    case KeyEvent.VK_LEFT:
		    	moveLeft();
		    	break;
		  
		    	
		    case KeyEvent.VK_C:
		    	changeColor();
		    	break;
		    	
		    case KeyEvent.VK_S:
		    	changeScreen();
		    	break;
		}
	
	}
	public static void main(String[] args) {
		new Ballmachine();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}