package Lecture;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintCircles extends JPanel implements Runnable {
	//private Circle mycircle;
    Circle [] circles= {new Circle(), new Circle(), new Circle(), new Circle(), new Circle()}; 
    JButton button;
	
	public PaintCircles(){
		//mycircle=new Circle();
		button=new JButton("deneme");
		button.setSize(50, 50);
		button.setLocation(30, 30);
		add(button);
		setVisible(true);
		Thread t=new Thread(this);
		t.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0; i<circles.length;i++){
		g.setColor(circles[i].getColor());
		g.fillOval(circles[i].getX(), circles[i].getY(), circles[i].getRadius(), circles[i].getRadius());
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				for(int i=0; i<circles.length;i++){	
			       circles[i].moveToRight();
			
			        repaint();
				}  
				
				Thread.currentThread().sleep(100);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
