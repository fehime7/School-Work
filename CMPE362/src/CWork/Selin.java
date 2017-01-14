package CWork;



import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.PreparedStatement;


@SuppressWarnings("serial")
public class Selin extends JFrame {
	
	JPanel panel;
	JLabel name, lastname,id,department,gender,image;
	JTextField tname,tlastname,tid,tdepartment,tgender;
	@SuppressWarnings("rawtypes")
	JComboBox cgender,cdepartment;
	JButton search,add,delete,browse;
	JRadioButton rdbtnMale = new JRadioButton("Male");
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	ButtonGroup group = new ButtonGroup();
	String s;
	ImageIcon icon = new ImageIcon();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Selin(){
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setSize(438, 288);
		panel.setLocation(6,6);
		add(panel);
		setSize(700,370);
		setLocation(6,6);
		
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
			
		name=new JLabel();
		name.setText("Student Name");
		name.setSize(89, 32);
		name.setLocation(24, 10);
		tname = new JTextField();
		tname.setSize(192, 29);
		tname.setLocation(187, 12);
		
		lastname=new JLabel();
		lastname.setText("Student Lastname");
		lastname.setSize(117,32);
		lastname.setLocation(24,42);
		tlastname=new JTextField();
		tlastname.setSize(192,26);
		tlastname.setLocation(187,45);
		
		image=new JLabel();
		image.setText("Student Image \n will be here");
		image.setSize(89, 32);
		image.setLocation(24, 10);
		image.setBounds(450,10,240,320);  
		
		id=new JLabel();
		id.setText("Student ID:");
		id.setSize(117,32);
		id.setLocation(24,77);
		tid=new JTextField();
		tid.setSize(192,26);
		tid.setLocation(187,80);
		
		department = new JLabel();
		department.setSize(149, 39);
		department.setText("Department");
		department.setLocation(24,108);
		cdepartment = new JComboBox();
		cdepartment.setSize(165, 20);
		cdepartment.setLocation(187, 118);
		cdepartment.setModel(new DefaultComboBoxModel(new String [] {"Computer Engineering", "EEEN", "BOUN"}));
		
		gender = new JLabel();
		gender.setText("Gender");
		gender = new JLabel();
		gender.setSize(149,39);
		gender.setText("Gender");
		gender.setLocation(24,149);
		cgender = new JComboBox();
		cgender.setSize(165,20);
		cgender.setLocation(177,180);
		cgender.setModel(new DefaultComboBoxModel(new String []{"Female", "Male"}));
		
		
		search = new JButton();
		search.setText("Search");
		search.setSize(103, 26);
		search.setLocation(36, 220);
		
		delete = new JButton();
		delete.setSize(103, 26);
		delete.setLocation(151, 220);
		delete.setText("Delete");
		
		add = new JButton();
		add.setSize(103, 26);
		add.setLocation(271, 220);
		add.setText("New Student");
		
		browse = new JButton();
		browse.setSize(103,26);
		browse.setLocation(151,260);
		browse.setText("Browse");
		
		
		
		panel.add(name);
		panel.add(tname);
		panel.add(lastname);
		panel.add(tlastname);
		panel.add(id);
		panel.add(tid);
		panel.add(department);
		panel.add(department);
		panel.add(cdepartment);
		panel.add(gender);
		//panel.add(cgender);
		panel.add(search);
		panel.add(delete);
		panel.add(add);
		panel.add(browse);
		panel.add(image);
		rdbtnMale.setSize(67, 39);
		rdbtnMale.setLocation(187, 149);
		rdbtnMale.setActionCommand("Male");
		panel.add(rdbtnMale);
		rdbtnFemale.setSize(76, 39);
		rdbtnFemale.setLocation(253, 150);
		rdbtnFemale.setActionCommand("Female");
		panel.add(rdbtnFemale);
		
		browse.addActionListener(new ActionListener(){ 
			@Override 
			public void actionPerformed(ActionEvent e){ 
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null); 
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile(); 
					String path = selectedFile.getAbsolutePath();
					image.setIcon(ResizeImage(path));
					s = path; 
				} 
				else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No Data");
				}
			}
		});
		
		

		
		
		search.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					//System.out.println("Installed");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt=conn.createStatement();			
					ResultSet rs = stmt.executeQuery("select * from StudentList order by ID" );
					while(rs.next()){
						if(tname.getText().equals(rs.getString("Name")) || tid.getText().equals(rs.getString("ID"))){
							if(true){
					    cdepartment.setSelectedItem(rs.getString("Department"));						
						tname.setText(rs.getString("Name"));
						tlastname.setText(rs.getString("LastName"));
						tid.setText(rs.getString("ID"));
						if(rs.getString("Gender").equals("Male")){
							rdbtnMale.setSelected(true);
						}else{
							
							rdbtnFemale.setSelected(true);
							
						}
						byte[] img = rs.getBytes("Photo");
						ImageIcon imager = new ImageIcon(img);
	                    Image im = imager.getImage();
	                    Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    image.setIcon(newImage);
							}
						
						}
						
					}
			
				}
				catch(Exception e){
					System.out.println("Problem");
				
				}
			}
		});

		add.addActionListener(new ActionListener() {
	
			
			
		@Override
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");

				if(rdbtnMale.isSelected()){
					rdbtnMale.setSelected(true);
				}else{
					
					rdbtnFemale.setSelected(true);	
					
				}
					
				InputStream is = new FileInputStream(new File(s));
				

				PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into StudentList(ID,Name,LastName,Department,Gender,Image) values(?,?,?,?,?,?)");
				ps.setString(1,tname.getText() );
				ps.setString(2,tlastname.getText() );
				ps.setString(3,tid.getText() );
				ps.setString(4,(String) cdepartment.getSelectedItem());
				ps.setString(5,group.getSelection().getActionCommand());
				ps.setBlob(6,is );
				ps.executeUpdate();
				
				//stmt.executeUpdate(query);
				tid.setText(" ");
			    tname.setText(" ");
			    tlastname.setText(" ");
			    conn.close();
				
				
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("sorun");
				}
				
			}
		});

		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt=conn.createStatement();
					String query="delete from newstudent where ID="+tid.getText();
					stmt.executeUpdate(query);
					tid.setText(" ");
				    tname.setText(" ");
				    tlastname.setText(" ");
				    conn.close();
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("sorun");
				}
				
				
			}
		});
		
	
		setVisible(true);
		
		
	}
	public ImageIcon ResizeImage(String imgPath)
	{ 
		ImageIcon MyImage = new ImageIcon(imgPath);
		Image img = MyImage.getImage();
		Image newImage = img.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon image = new ImageIcon(newImage);
		return image;
	}
	
	public static void main(String[] args) {
		new Selin();
	}
}
