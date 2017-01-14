

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddingMachine extends JFrame implements MouseListener, KeyListener {
 private JTextField txt1, txt2, txt3;
 private JButton btn1, btn2;
 private boolean valid;
 
 public AddingMachine() {
	 valid=true;
	 setSize(400, 400);
	 setLayout(new FlowLayout());

	 
	 txt1 = new JTextField("Text1");
	 txt1.addKeyListener(this);
	 txt1.addMouseListener(this);
	 txt2 = new JTextField("Text2");
	 txt2.addKeyListener(this);
	 txt2.addMouseListener(this);
	 txt3 = new JTextField("Text3");
	 
	 btn1 = new JButton("add");
	 btn1.addMouseListener(this);
	 btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			add();
			
		}
	});
	 
	 btn2 = new JButton("Reset");
	 btn2.addKeyListener(this);
	 btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			reset();
			
		}
	});
	 
	 add(txt1);
	 add(txt2);
	 add(btn1);
	 add(txt3);
	 add(btn2);
	 setVisible(true);
 }
 
 public static void main(String[] args) {
	new AddingMachine();
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == txt1) {
		txt1.setText("");
	}
	else if(e.getSource() == txt2) {
		txt2.setText("");
	}
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
/*if(e.getSource() == txt1) {
		txt1.setText("");
	}
	else if(e.getSource() == txt2) {
		txt2.setText("");
	} */
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	/*if(e.getSource() == txt1) {
		txt1.setText("");
	}
	else if(e.getSource() == txt2) {
		txt2.setText("");
	}*/
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == btn1) {
	btn2.requestFocus();
	}
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	int k=(int)e.getKeyChar();
	if( k<48 || k>57){
	
		
		valid=false;
	}
	
	/*
	if(e.getSource() == txt2){
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			txt1.setText("Text1");
			txt2.setText("Text2");
			txt3.setText("Text3");
			}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			add();
		}
	}
	else if(e.getSource() == btn2) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			reset();
		}
	}
	
	*/
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
	
	if(!valid){
		delete();
	}
		
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
public void add() {
	try{
	int a = Integer.parseInt(txt1.getText());
	int b = Integer.parseInt(txt2.getText());
	txt3.setText(a+b+"");
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, "Please input only integer numbers");
	}
}
public void reset() {
	txt1.setText("Text1");
	txt2.setText("Text2");
	txt3.setText("Text3");
}
public void testChar(KeyEvent e){
	
	
	if(48 >= (int)e.getKeyChar()&& (int)e.getKeyChar()   >= 57){
		String temp=txt1.getText();
		if(temp.length()==0)
			txt1.setText("");
		else{
			String kkk=temp.substring(0, temp.length());
			txt1.setText(kkk);
		}
	}
	
	
}

public void delete(){
	
	String temp=txt1.getText();
	if(temp.length()==0){
		txt1.setText("");
		System.out.println(temp.length());
		valid=true;
	}
	else{
		String kkk=temp.substring(0, temp.length()-1);
		
		txt1.setText(kkk);
		valid=true;
	}
	
}
}
