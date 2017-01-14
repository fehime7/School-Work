import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.color.*; 

import javax.swing.colorchooser.*;

public class BallMachine2 extends JFrame {
	
	private int x,y, diameter;
	private JButton start, stop, up, down, right, left;
	private JRadioButton rl, ud, rn, sc, bc; 
	private ButtonGroup directionG, colorG;
	private JCheckBox am;
	private Color ballColor, screenColor;
	private JColorChooser color;
	private JPanel panel, directionPanel;
	
	
	
	public BallMachine2(){
		 x=200;
		 y=200;
		 diameter=100;
		 setLayout(null);
	     setSize(1000,600);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	     
	     panel=new JPanel(new FlowLayout());
	     panel.setLocation(0,500);
	     panel.setSize(1000, 100);
	     panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	     add(panel);
	     
	     
	     up=new JButton();
	     
	     
	     start=new JButton("Start");
	    
	     start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(start.isSelected()){
						//enable();
					}
					
				}
				
				catch(Exception e1){
					
				}
					
				
			}
		});
	     
	   
	     stop=new JButton("Stop");
	     stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//disable();
				
			}
		});
	     
	     color=new JColorChooser();
	     color.setSize(30, 30);
	     
 
	     rl=new JRadioButton("RL");
	     rl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	     ud=new JRadioButton("UD");
	     rn=new JRadioButton("RN");
		    
		     
	     directionPanel=new JPanel(new GridLayout(1,3));
	     directionPanel.add(rl);
	     directionPanel.add(ud);
	     directionPanel.add(rn);
	     
	     
	     directionG=new ButtonGroup();
	     directionG.add(rl);
	     directionG.add(ud);
	     directionG.add(rn);
	     
	     am=new JCheckBox("AM");
	     
	     sc=new JRadioButton("SC");
	     bc=new JRadioButton("BC");
	     
	     colorG=new ButtonGroup();
	     colorG.add(sc);
	     colorG.add(bc);
	     
	     
	     
	     panel.add(directionPanel);
	     panel.add(am);
	     panel.add(sc);
	     panel.add(bc);
	     panel.add(start);
	     panel.add(stop);
	    // panel.add(color);
	     
	     
	     
	  
	     ballColor=Color.BLUE;
	     screenColor=Color.PINK;
	     setBackground(screenColor);
	     
	     setVisible(true);
	}
	//METHODS
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(ballColor);
		g.fillOval(x, y, diameter, diameter);
	}
	//MOVE METHODS
	public void moveRight(){
		x +=5;
		repaint();
	}
	public void moveLeft(){
		x-=5;
		repaint();
	}
	public void moveUp(){
		y-=5;
		repaint();
	}
	public void moveDown(){
		y+=5;
		repaint();
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
	
   //COLOR CHANGE METHODS
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
	

	public static void main(String[] args) {
		new BallMachine2();
	}


		
	
	
}
