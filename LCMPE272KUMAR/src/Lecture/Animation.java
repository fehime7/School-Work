package Lecture;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel{
	private int x=10;
	
	private class Actions implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
		}
		
	}
	public Animation(){
		Actions a=new Actions();
		Timer timer=new Timer(100, a);
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(x, 100, 100, 100);
		x+=5;
	}
	
	public static void main(String[] args) {
		Animation animation=new Animation();
		JPanel content=new JPanel();
		content.setLayout(new BorderLayout());
		content.add(animation, BorderLayout.CENTER);
		JFrame window=new JFrame();
		window.setContentPane(content);
		window.setSize(300, 500);
		window.setVisible(true);
	}

}
