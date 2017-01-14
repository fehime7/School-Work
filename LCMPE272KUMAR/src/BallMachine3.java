import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BallMachine3 extends JFrame implements ActionListener{

    private int x, y, radius, speedX, speedY;
    private JButton up, down, left, right, stop;
    private Thread t;
    private JPanel panel;
    
    public BallMachine3() {
    	speedX=1;
    	speedY=1;
        x = 50;
        y = 50;
        radius = 50;
        
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel=new JPanel(new GridLayout(1,5));
        panel.setLocation(0, 0);
        panel.setSize(400, 20);
        add(panel);
        
        up = new JButton("UP");
        up.addActionListener(this);
        
        
        down = new JButton("DOWN");
        down.addActionListener(this);
       
        
        right = new JButton("RIGHT");
        right.addActionListener(this);
        
        
        left = new JButton("LEFT");
        left.addActionListener(this);
        
        stop = new JButton("STOP");
        stop.addActionListener(this);
        
           
        panel.add(up);
        panel.add(down);
        panel.add(right);
        panel.add(left);
        panel.add(stop);
        
        
        setVisible(true);
    }
        
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, radius, radius);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == up) {
            t = new Thread(goUp);
            t.start();
        }
        else if (e.getSource() == down) {
            t = new Thread(goDown);
            t.start();
        }
        else if (e.getSource() == right) {
            t = new Thread(goRight);
            t.start();
        }
        else if (e.getSource() == left) {
            t = new Thread(goLeft);
            t.start();
        }
        else if(e.getSource()== stop){
        	t.interrupt();
        }
    }
     Runnable goUp = new Runnable() {
        public void run() {
        	
            up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
            
            while(true) {
            	y-=speedY;
                repaint();
                if(y<=40 || y>350 ){
                	speedY=-speedY;
                	
                }
                
                
                 try {
                        Thread.sleep(10);
                 } 
                 catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                     break;
                 }
                    
            }
            up.setEnabled(true);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
          
        }
    };
    
    Runnable goDown = new Runnable() {
        public void run() {
            up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
            while(true) {
                y+=speedY;
                repaint();
                if(y<=40 || y>350 ){
                	speedY=-speedY;
                	
                }
                try {
                    Thread.sleep(10);
                } 
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    break;
                }
            }
            up.setEnabled(true);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
           
        }
    };
    
    Runnable goRight = new Runnable() {
        public void run() {
            up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
            
            while(true) {
                x+=speedX;
                repaint();
                if(x<=0 || x>350){
                	speedX=-speedX;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    break;
                }
            }
            up.setEnabled(true);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
        }
    };
    
    Runnable goLeft = new Runnable() {
        public void run() {
        	up.setEnabled(false);
            down.setEnabled(false);
            left.setEnabled(false);
            right.setEnabled(false);
            
            while(true) {
            	x-=speedX;
                repaint();
            	if(x<=0 || x>350){
            		speedX=-speedX;
            	}
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    break;
                }
            }
            up.setEnabled(true);
            down.setEnabled(true);
            left.setEnabled(true);
            right.setEnabled(true);
        }
        
    };
    
    
    public static void main(String[] args) {
        new BallMachine3();
    }
     
    
}
