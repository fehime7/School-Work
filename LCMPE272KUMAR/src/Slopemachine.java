import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.activation.MailcapCommandMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.IconUIResource;




public class Slopemachine extends JFrame {
	
	private JLabel slot1, slot2, slot3, result;
	private JTextField score;
	private JButton roll;
	
	
	
	public Slopemachine() {
		setSize(1000,400);
		setLayout(new GridLayout(1, 4));
		
		slot1=new JLabel("");
		slot2=new JLabel("");
		slot3=new JLabel("");
		final ImageIcon a=new ImageIcon("/Users/fggi/Desktop/benimkiler/1.jpg");
		slot1.setIcon(a);
		slot1.setVerticalAlignment(JLabel.CENTER);
		slot1.setHorizontalAlignment(JLabel.CENTER);
		
		final ImageIcon b=new ImageIcon("/Users/fggi/Desktop/benimkiler/2.jpg");
		slot2.setIcon(b);
		slot2.setVerticalAlignment(JLabel.CENTER);
		slot2.setHorizontalAlignment(JLabel.CENTER);
		
		final ImageIcon c=new ImageIcon("/Users/fggi/Desktop/benimkiler/3.jpg");
		slot3.setIcon(c);
		slot3.setVerticalAlignment(JLabel.CENTER);
		slot3.setHorizontalAlignment(JLabel.CENTER);
		
		roll=new JButton("Roll");
		roll.addActionListener(new ActionListener() {
			int temp=0;
			@Override
			public void actionPerformed(ActionEvent img) {
				// TODO Auto-generated method stub
				
				
				try{
					Random r=new Random();
					int i=r.nextInt(3);
					if(i==0)
						slot1.setIcon(a);
					else if(i==1)
						slot1.setIcon(b);
					else if(i==2)
						slot1.setIcon(c);
					
					
					int j=r.nextInt(3);
					if(j==0)
						slot2.setIcon(a);
					else if(j==1)
						slot2.setIcon(b);
					else if(j==2)
						slot2.setIcon(c);					
					
					int k=r.nextInt(3);
					if(k==0)
						slot3.setIcon(a);
					else if(k==1)
						slot3.setIcon(b);
					else if(k==2)
						slot3.setIcon(c);
					
				if(i==j&&j==k)
					temp=temp+100;
				else
					temp=temp-25;
			
			    score.setText("" + temp);	
				
				}
				catch(Exception e){
					}
				}
		});
		
		
		
		
		score=new JTextField("Score");
		result=new JLabel("Score");
		result.setVerticalAlignment(JLabel.CENTER);
		result.setHorizontalAlignment(JLabel.CENTER);
		

		JPanel p=new JPanel(new GridLayout(3,1));
		p.add(roll);		
		p.add(result);
		p.add(score);
		
		
		add(slot1);
		add(slot2);
		add(slot3);
		add(p);
		
        setVisible(true);		
	}
	
	public static void main(String[] args) {
		new Slopemachine();
	}
	
	
	

}
