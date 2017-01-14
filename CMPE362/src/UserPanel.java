
/***********This program is executed by Fehime Seven for LCMPE331 Lecture final project. 
 ***********December, 2015. Istanbul Bilgi University ******************/

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;


public class UserPanel extends JFrame {
	
	private JLabel  lname, gender, department, idTake, nameTake, radiochoose, getInfo, imageLabel, image, img;
	private JTextField idInput, nameInput, lnameOut, genderOut, departmentOut;
	private JButton info, prev, next;
	private JRadioButton nameRadio, idRadio;
	private ButtonGroup radios;
	private JPanel radiosP, imageP, panel;
	private ResultSet rs1, rs, rs2;
	private JFrame Userframe;
	private JMenuBar menubar;
	private JMenu help, file;
	private JMenuItem about,  quit;

	
	public UserPanel(){
		
		
		setSize(520, 555);
		setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("User Panel");
		
		 menubar=new JMenuBar();
	     menubar.setSize(520, 35);
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
				setVisible(false);
			
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
	     
	     panel=new JPanel();
	     panel.setSize(520, 500);
	     panel.setLocation(0, 35);
		 panel.setLayout(new GridLayout(9,18));
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			//setTitle("User Panel");
		
		
		//Radio buttons to choose how to search by id or by name
		radiochoose=new JLabel("Select how would you like to search:");
		nameRadio=new JRadioButton("Search by name");		
		idRadio=new JRadioButton("Search by ID");
		radios= new ButtonGroup();
		radios.add(idRadio);
		radios.add(nameRadio);
		radiosP=new JPanel();
		radiosP.setLayout(new GridLayout(1,2));
		//end of radios
		
		//Show button to bring information from database
		getInfo=new JLabel("Click button to see student information:");
		info=new JButton("SHOW");
		//end of show button
		
		//id, name, last name, department and gender fields
		idTake=new JLabel("Please Enter Student ID:");
		idInput= new JTextField();
		idInput.setEditable(false);
		nameTake= new JLabel("Please Enter Student Name:");
		nameInput= new JTextField();
		nameInput.setEditable(false);
		department=new JLabel("Student Department:");
		departmentOut= new JTextField();
		departmentOut.setEditable(false);
		lname=new JLabel("Student Last Name");
		lnameOut= new JTextField();
		lnameOut.setEditable(false);
		gender= new JLabel("Student Gender:");
		genderOut=new JTextField();
		genderOut.setEditable(false);
		//end of basic student inforrmation fields
		
		//Next and Previous button to bring next or previous student on database
		prev= new JButton("PREVIOUS");
		next=new JButton("NEXT");
		//end of next and previous
		
		//Image panel
		imageLabel=new JLabel("Student Image");
		image=new JLabel();
		img=new JLabel(" ");
		imageP=new JPanel();
		imageP.setLayout(new GridLayout(1,2));
		imageP.add(image);
		imageP.add(img);
		
		
		//image.setIcon(a);
		image.setVerticalAlignment(JLabel.CENTER);
		image.setHorizontalAlignment(JLabel.CENTER);
		
		//ActionListener for show button
		info.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt1=conn1.createStatement();
					
					int id=Integer.parseInt(idInput.getText());	
					String nm=nameInput.getText();
					System.out.println(nm);
					if(idRadio.isSelected()){
					 rs1 = stmt1.executeQuery("select * from Student where ID="+id);
					}
					else if(nameRadio.isSelected()){
					  rs1 = stmt1.executeQuery("select * from Student where Name='"+nm+"'");
					  System.out.println(nm);	
					}
					while(rs1.next()){
				
						departmentOut.setText(rs1.getString("Department"));
						genderOut.setText(rs1.getString("Gender"));
						nameInput.setText(rs1.getString("Name"));
						lnameOut.setText(rs1.getString("LastName"));
						idInput.setText(rs1.getString("ID"));
						//String a=(rs1.getString("Image"));
						//final ImageIcon imgIcon=new ImageIcon(a);
						//image.setIcon(imgIcon);
					
						 byte[] img = rs1.getBytes("Image");
						 if(img==null){
							 String a=("/Users/fggi/Desktop/benimkiler/8.jpg");
								final ImageIcon imgIcon=new ImageIcon(a);
								image.setIcon(imgIcon);
							 
						 }else{
						 
						ImageIcon imager = new ImageIcon(img);
	                    Image im = imager.getImage();
	                    Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    image.setIcon(newImage);
						}
						
					}
					
				
				
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Problem Occured");
				
				}
			}
		   }); 
		   
	
		//ActionListener for next button
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try{
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt=conn.createStatement();
					int a = Integer.parseInt(idInput.getText()) + 1;
					rs = stmt.executeQuery("select * from Student where ID="+a);
					
					rs.next();
				
					
					  departmentOut.setText(rs.getString("Department"));
					  genderOut.setText(rs.getString("Gender"));
					  nameInput.setText(rs.getString("Name"));
					  lnameOut.setText(rs.getString("LastName"));
					  idInput.setText(String.valueOf((a)));
					  //String b=(rs.getString("Image"));
						//final ImageIcon imgIcon=new ImageIcon(b);
						//image.setIcon(imgIcon);
					  byte[] img = rs.getBytes("Image");
						ImageIcon imager = new ImageIcon(img);
	                    Image im = imager.getImage();
	                    Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    image.setIcon(newImage);
	                    

					
					
				}catch(Exception e1){
					//JOptionPane.showMessageDialog(null, "Problem Occured");
				}
			
				
			}
		});
		
		//ActionListener for Previous button
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                 try{
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt=conn.createStatement();
					int m = Integer.parseInt(idInput.getText()) - 1;
					rs = stmt.executeQuery("select * from Student where ID="+m);
					
					rs.next();
				
					departmentOut.setText(rs.getString("Department"));
					genderOut.setText(rs.getString("Gender"));
					nameInput.setText(rs.getString("Name"));
					lnameOut.setText(rs.getString("LastName"));
					idInput.setText(String.valueOf((m)));
					//String a=(rs.getString("Image"));
					//final ImageIcon imgIcon=new ImageIcon(a);
					//image.setIcon(imgIcon);
					byte[] img = rs.getBytes("Image");
					ImageIcon imager = new ImageIcon(img);
                    Image im = imager.getImage();
                    Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    image.setIcon(newImage);
                    

						
		 
					
				}catch(Exception e1){
					//System.out.println("problem");
				}
				
				
			}
		});
		
         nameRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nameRadio.isSelected()){
				   idInput.setEditable(false);
				   nameInput.setEditable(true);
				}
				
			}
		});
          
          
          idRadio.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				// TODO Auto-generated method stub
  				if(idRadio.isSelected()){
  					idInput.setEditable(true);
  					nameInput.setEditable(false);
  					
  				}
  				
  			}
  		});
		
		
	    
		
		
		radiosP.add(idRadio);
		radiosP.add(nameRadio);
		panel.add(radiochoose);
		panel.add(radiosP);
        
		panel.add(idTake);
  		panel.add(idInput); 
  		panel.add(nameTake);
		panel.add(nameInput);
		panel.add(getInfo);
		panel.add(info);	
		panel.add(lname);
		panel.add(lnameOut);
		panel.add(department);
		panel.add(departmentOut);
		panel.add(gender);
		panel.add(genderOut);
		panel.add(imageLabel);
		panel.add(imageP);
		panel.add(prev);
		panel.add(next);
		add(panel);
		
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new UserPanel();
	}

}
