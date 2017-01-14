package Lecture;

import java.awt.Color;
import java.util.Random;

public class Circle {
	private int radius;
	private int x;
	private int y;
	private Color color;
	private Random random;
	
	public Circle(){
		
		random =new Random();
		x=random.nextInt(500);
		y=random.nextInt(500);
		radius=random.nextInt(200)+50;
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
	
	public void moveToRight(){
		if(x<900)
			x+=5;
	}
	
	


	

}
