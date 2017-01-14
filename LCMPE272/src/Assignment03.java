
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
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



public class Assignment03 extends JFrame {
	

	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel select;
	private JLabel result;
	private JLabel waiting;
	private JButton buton1, buton2, save, exit;
	private JTextField text1, text2, text3, text4, text5;
	private ButtonGroup group;
	private JRadioButton uppercase, lowercase;
	
	
	public Assignment03(){
		setSize(400,500);
		setLayout(new GridLayout( 9, 2 ));
		
		label1 = new JLabel("University");
		label2 = new JLabel("Department");
		label3 = new JLabel("Name");
		label4 = new JLabel("Last Name");
		label5 = new JLabel("Sutudent ID");
		select = new JLabel("Select");
		result = new JLabel("Result");
		waiting = new JLabel("Waiting");
		
		
		text1= new JTextField();
		text2= new JTextField();
		text3= new JTextField();
		text4= new JTextField();
		text5= new JTextField();
		
		buton1= new JButton("Preview");
	    buton1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
	    		if(uppercase.isSelected())
	    			JOptionPane.showMessageDialog(null, previewUp());
	    		else
	    		    JOptionPane.showMessageDialog(null, previewLow());
	    	}
	    });
	    	
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
		
		save= new JButton("Save");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try{
					FileWriter fw= new FileWriter("LCMPE.txt", true);
					if(uppercase.isSelected()){
						JOptionPane.showMessageDialog(null, previewUp());
					    fw.write(previewUp());
						fw.flush();
					    fw.close();
					}
					else{
		    		    JOptionPane.showMessageDialog(null, previewLow());
					    fw.write(previewLow());
		    		    fw.flush();
					    fw.close();
					}
					
				}	
					catch(Exception e1){
						System.out.println(e1);
				}
				
					
		
		
		}
		});
		
		exit= new JButton("Exit");
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Close?", "Close", JOptionPane.YES_NO_OPTION);
				if ( reply == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		
		uppercase= new JRadioButton("Uppercase", true);
		lowercase= new JRadioButton("Lowercase");
	
		
		JPanel p=new JPanel(new GridLayout(1,2));
		p.add(uppercase);
		p.add(lowercase);
		
		group=new ButtonGroup();
		group.add(uppercase);
		group.add(lowercase);
		
		
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
		add(save);
		add(exit);
		
		
		setVisible(true);
		
		
		
	}
	
	public String previewUp(){
	   return " University: "+ text1.getText().toUpperCase()+"\n Department: "
	       +text2.getText().toUpperCase()+"\n Name: "+ text3.getText().toUpperCase()+"\n Last Name: " 
			   + text4.getText().toUpperCase()+"\n Student ID: "+text5.getText().toUpperCase();
	}
	
	public String previewLow(){
		return " University: "+ text1.getText().toLowerCase()+"\n Department: "
			       +text2.getText().toLowerCase()+"\n Name: "+ text3.getText().toLowerCase()+"\n Last Name: " 
					   + text4.getText().toLowerCase()+"\n Student ID: "+text5.getText().toLowerCase();
	}
	
	public static void main(String[] args) {
		new Assignment03();
		
		
	}

	
	
	
	
	
			
	}



