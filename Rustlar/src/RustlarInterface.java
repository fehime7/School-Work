import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class RustlarInterface extends JFrame{
	
	public RustlarInterface(){
		
		setSize(630,630);
		//setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
		setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D ) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.DARK_GRAY);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				g2d.drawRect(70+i*70, 200+j*70, 70, 70);
				g2d.drawOval(70+i*70, 200+j*70, 70, 70);
			}
			
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2d.drawRect(210+i*70, 60+j*70, 70, 70);
				g2d.drawOval(210+i*70, 60+j*70, 70, 70);

			}	
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2d.drawRect(210+i*70, 410+j*70, 70, 70);
				g2d.drawOval(210+i*70, 410+j*70, 70, 70);

			}	
		}
		
	}	
	
	public static void main(String[] args) {
		RustlarInterface r=new RustlarInterface();
		
	}

}
