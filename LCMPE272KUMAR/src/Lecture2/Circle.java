package Lecture2;

import java.awt.Color;
import java.util.Random;

public class Circle {
	private int radius;
	private int x;
	private int y;
	private int diameter;
	private int speedX, speedY;
	private Color color;
	private Random random;
	
	public Circle(){
		
		random =new Random();
		x=random.nextInt(100);
		y=random.nextInt(100);
		speedX=10;
		speedY=5;
		radius=random.nextInt(200)+50;
		diameter=radius*2;
		color=new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		
	}

	public int getRadius() {
		return radius;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	
	public void moveToRightLeft(){
		x+=speedX;
        if(x<=0 || x>400-radius){
        	speedX=-speedX;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
           
        }
        
        
	}
	
	public void moveToUpDown(){
		y-=speedY;
       
        if(y<=0 || y>400-radius ){
        	speedY=-speedY;
        	
        }
        
        
         try {
                Thread.sleep(10);
         } 
         catch (InterruptedException e) {
            // TODO Auto-generated catch block
           
         }
	}
	
	


	

}
