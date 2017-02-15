import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class RustlarStartPage extends JFrame{
	
	JLabel firstPlayer, secondPlayer;
	JRadioButton computerPlayer1, humanPlayer1, computerPlayer2, humanPlayer2;
	ButtonGroup group1, group2;
	JButton goButton;
	
	public RustlarStartPage(){
		
		setSize(450, 250);
		setTitle("Rustlar Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		firstPlayer = new JLabel("Select the first player:");
		firstPlayer.setLocation(50, 50);
		firstPlayer.setSize(150, 30);
		
		secondPlayer = new JLabel("Select the second player:");
		secondPlayer.setLocation(250, 50);
		secondPlayer.setSize(200, 30);
		
		computerPlayer1= new JRadioButton("Computer Player:");
		computerPlayer1.setSize(150, 30);
		computerPlayer1.setLocation(60, 80);
		
		humanPlayer1= new JRadioButton("Human Player:");
		humanPlayer1.setSize(150, 30);
		humanPlayer1.setLocation(60, 110);
		
		computerPlayer2= new JRadioButton("Computer Player:");
		computerPlayer2.setSize(150, 30);
		computerPlayer2.setLocation(250, 80);
		
		humanPlayer2= new JRadioButton("Human Player:");
		humanPlayer2.setSize(150, 30);
		humanPlayer2.setLocation(250, 110);
		
		group1=new ButtonGroup();
		group1.add(computerPlayer1);
		group1.add(humanPlayer1);
		
		group2=new ButtonGroup();
		group2.add(computerPlayer2);
		group2.add(humanPlayer2);
		
		goButton= new JButton("START");
		goButton.setSize(100, 50);
		goButton.setLocation(165, 150);
		
		goButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(computerPlayer1.isSelected() && computerPlayer2.isSelected() || 
				   computerPlayer1.isSelected() && humanPlayer2.isSelected() ||
				   humanPlayer1.isSelected() && computerPlayer2.isSelected() ||
				   humanPlayer1.isSelected() && humanPlayer2.isSelected()) {
					new RustlarInterface();
				}
				else {
					Object [] arr={"Close"};
					
					int n=JOptionPane.showOptionDialog(null, "Select one option for each player", "Rustlar",JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null, arr, arr[0]); 
				}
				
				
			}
		});

		
		add(firstPlayer);
		add(secondPlayer);
		add(computerPlayer1);
		add(humanPlayer1);
		add(computerPlayer2);
		add(humanPlayer2);
		add(goButton);

		
		setVisible(true);
	}
	public static void main(String[] args) {
		RustlarStartPage rustlarStart= new RustlarStartPage();
	}

}
