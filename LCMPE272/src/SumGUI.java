import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SumGUI extends JFrame{

	private static final String ActionListener = null;
	private JLabel labelOne;
	private JLabel labelTwo;
	private JLabel labelTh;
	private JButton hesapla;
	private JButton reset;
	private JButton exit;
	private JTextField inputOne;
	private JTextField inputTwo;
	private JTextField inputTh;
	
	public SumGUI(){
		setLayout(null);
		
		hesapla = new JButton("Calculate");
		hesapla.setLocation(100, 120);
		hesapla.setSize(100,50);
		hesapla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int temp = Integer.parseInt(inputOne.getText()) + Integer.parseInt(inputTwo.getText());
					inputTh.setText(temp+"");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Hatal› bir input girildi");
				}
				
			}
		});
		
		reset = new JButton("Reset");
		reset.setLocation(220, 120);
		reset.setSize(100, 50);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputOne.setText("");
				inputTwo.setText("");
				inputTh.setText("");
				
			}
		});
		
		exit = new JButton("Exit");
		exit.setLocation(340, 120);
		exit.setSize(100,50);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "C›k›ﬂ?", "Close", JOptionPane.YES_NO_OPTION);
				if ( reply == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		labelOne = new JLabel("First Number");
		labelOne.setLocation(100, 20 );
		labelOne.setSize(100, 30);
		 
		labelTwo = new JLabel("Second Number");
		labelTwo.setLocation(100, 50 );
		labelTwo.setSize(100, 30);
		
		labelTh = new JLabel("Result");
		labelTh.setLocation(100, 80 );
		labelTh.setSize(100, 30);
		
		inputOne= new JTextField(" Write the first integer ");
		inputOne.setLocation(250, 20);
		inputOne.setSize(200, 30);
		
		inputTwo= new JTextField(" Write the second integer ");
		inputTwo.setLocation(250, 50);
		inputTwo.setSize(200, 30);
		
		inputTh= new JTextField( );
		inputTh.setLocation(250, 80);
		inputTh.setSize(200, 30);
		inputTh.setEditable(false);
		
		
		
		
		setTitle("LCMPE 272");
		setSize(550, 250);
		setVisible(true);
		setResizable(false);
		
		add(hesapla);
		add(reset);
		add(exit);
		add(labelOne);
		add(labelTwo);
		add(labelTh);
     	add(inputOne);
    	add(inputTwo);
    	add(inputTh);
		
		
		
		
		
	}
	
	
		
	

	public static void main(String[] args) {
		new SumGUI();
	}
}
