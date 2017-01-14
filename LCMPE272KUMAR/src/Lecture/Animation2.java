package Lecture;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Animation2 extends JFrame {
	private PaintCircles myCircles;
	
	
	public Animation2(){
		
		myCircles=new PaintCircles();
		
		add(myCircles);
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Animation2();
	}

}
