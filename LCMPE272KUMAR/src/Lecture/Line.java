package Lecture;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Line extends JPanel{
	public void paint(Graphics g){
		g.drawLine(100, 50, 200, 200);
		g.drawRect(50, 50, 300, 300);
		
	}
	
	public static void main(String[] args) {
		JFrame window=new JFrame();
		window.getContentPane().add(new Line());
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	

}