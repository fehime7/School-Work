package Lecture2;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintCircles extends JPanel implements Runnable {
	private Circle mycircle;
    
	
	
	public PaintCircles(){
		mycircle=new Circle();
		
		Thread t=new Thread(this);
		t.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(mycircle.getColor());
		g.fillOval(mycircle.getX(), mycircle.getY(), mycircle.getRadius(), mycircle.getRadius());
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				
			       mycircle.moveToRightLeft();
			       mycircle.moveToUpDown();
			
			        repaint();
				 
				
				Thread.currentThread().sleep(100);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
