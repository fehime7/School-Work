import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DataBase extends JFrame {
	
	//private JFrame frame;
	private JPanel userPanel, adminPanel;
	private JButton enter1, enter2;
	private JLabel userEnter, adminEnter, pass;
	private JTextField password;
	private JMenuBar menubar;
	private JMenu help, file;
	private JMenuItem about,  quit;
	
	
	public DataBase(){
		setSize(500, 300);
		setLayout(null);
		setBackground(new Color(75, 75 , 175));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Student Database");
		
		 menubar=new JMenuBar();
	     menubar.setSize(500, 35);
	     menubar.setLocation(0	, 0);
	     menubar.setBackground(new Color(150, 150, 150));
	     add(menubar);
	     
	     file= new JMenu("File");
	     file.setBackground(new Color(150, 150, 150));
	     menubar.add(file);
	     
	     
	     quit=new JMenuItem("Quit");
	     file.add(quit);
	     quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			
			}
		});
	     
	     help=new JMenu("Help");
	     help.setBackground(new Color(150, 150, 150));
	     menubar.add(help);
	     
	     about=new JMenuItem("How to use");
	     help.add(about);
	     about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                
				Object [] arr={"Close"};
				
				int n=JOptionPane.showOptionDialog(null, "You can enter as student or administrator. "+"\n"
				        +"Admin can make changes, additions and deletions on database. "+"\n"
						+"Student can only make search on the database."+"\n"
				        +"  "+"\n"
						+"\n"
				        +"", "MovingBallMachine",JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null, arr, arr[0]);
				
					
			}
		});
		
		userPanel=new JPanel();
		userPanel.setSize(250, 300);
		userPanel.setLocation(0, 0);
		userPanel.setLayout(null);
		
	    adminPanel=new JPanel();
		adminPanel.setSize(250, 300);
		adminPanel.setLocation(250, 0);
	    adminPanel.setLayout(null);
		
			
		userEnter= new JLabel("Press button for user log in:");
		userEnter.setSize(250, 40);
		userEnter.setLocation(20, 60);
		enter1= new JButton("USER LOG IN");
		enter1.setSize(200, 80);
		enter1.setLocation(20, 130);
		adminEnter= new JLabel("Press button for administrator log in:");
		adminEnter.setSize(250, 30);
		adminEnter.setLocation(5, 60);
		pass=new JLabel("Password:");
		pass.setSize(100, 20);
		pass.setLocation(5, 100);
		password=new JTextField();
		password.setSize(100, 20);
		password.setLocation(105, 100);
		enter2= new JButton("ADMINISTRATOR LOG IN");
		enter2.setSize(200, 80);
		enter2.setLocation(20, 130);
		enter2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(password.getText().equals("aaa")){
				   AdminPanel ap=new AdminPanel();
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Password!");
				}
			}
		});
		
		enter1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UserPanel up=new UserPanel();
				
			}
		});
		
		userPanel.add(userEnter);
		userPanel.add(enter1);
		adminPanel.add(adminEnter);
		adminPanel.add(enter2);
		adminPanel.add(pass);
		adminPanel.add(password);
		
		add(userPanel);
		add(adminPanel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DataBase();
	}

}
