package Lecture2;

import javax.swing.JFrame;

public class Animation2 extends JFrame {
	private PaintCircles myCircles;
	
	public Animation2(){
		myCircles=new PaintCircles();
		add(myCircles);
		setSize(400, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Animation2();
	}

}
