import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Assignment02 extends JFrame {
	

	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel select;
	private JLabel result;
	private JLabel waiting;
	private JButton buton1, buton2;
	private JTextField text1, text2, text3, text4, text5;
	private ButtonGroup group;
	private JRadioButton max,min;
	
	
	public Assignment02(){
		setSize(400,500);
		setLayout(new GridLayout( 8, 2 ));
		
		label1 = new JLabel("First Number");
		label2 = new JLabel("Second Number");
		label3 = new JLabel("Third Number");
		label4 = new JLabel("Fourth Number");
		label5 = new JLabel("Fifth Number");
		select = new JLabel("Select");
		result = new JLabel("Result");
		waiting = new JLabel("Waiting");
		
		
		text1= new JTextField();
		text2= new JTextField();
		text3= new JTextField();
		text4= new JTextField();
		text5= new JTextField();
		
		buton1= new JButton("Calculate");
	    buton1.addActionListener(new ActionListener() {
			
			/*@Override
			public void actionPerformed(ActionEvent e) {
				
					int temp1= Integer.parseInt( text1.getText());
					int temp2= Integer.parseInt( text1.getText());
					int temp3= Integer.parseInt( text1.getText());
					int temp4= Integer.parseInt( text1.getText());
					int temp5= Integer.parseInt( text1.getText());
			
				    int [] a={temp1,temp2,temp3,temp4,temp5};	
					
				    Arrays.sort(a);
				    int kSay›=a[0];
				    int bSay›=a[4];
				    
				      if(max.isSelected()){
						 
					 
					  waiting.setText(bSay›+"");
						
				    }
				      else{
				    	  waiting.setText(kSay›+"");
				      }
						
						
					}	});*/
	    	
	    	@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a, b, c, d, f;
				
				a = Integer.parseInt(text1.getText());
				b = Integer.parseInt(text2.getText());
				c = Integer.parseInt(text3.getText());
				d = Integer.parseInt(text4.getText());
				f = Integer.parseInt(text5.getText());
				int x[] = {a,b,c,d,f};
				
				
				int Ksayi, Bsayi;
		Arrays.sort(x);
		Ksayi = x[0];
		Bsayi = x[4];
		if (min.isSelected())
		 
			waiting.setText(Ksayi + "");
		else 
			waiting.setText(Bsayi + "");


		
			}	});
		
		buton2= new JButton("Reset");
		buton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
			
				
			}
		});
		
		
		max= new JRadioButton("Max", true);
		min= new JRadioButton("Min");
	
		
		JPanel p=new JPanel(new GridLayout(1,2));
		p.add(max);
		p.add(min);
		
		group=new ButtonGroup();
		group.add(max);
		group.add(min);
		
		
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		add(label3);
		add(text3);
		add(label4);
		add(text4);
		add(label5);
		add(text5);
		add(select);
		add(p);
		add(result);
		add(waiting);
		add(buton1);
		add(buton2);
		
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new Assignment02();
	}

	
	
	
	
	
			
	}


