import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.FileInputStream;
import java.io.InputStream;

import com.mysql.jdbc.PreparedStatement;


public class AdminPanel extends JFrame{
	
	private JButton add, search, delete, imageChoose;
	private JLabel id, name, lname, department, gender, searchB, imageLabel, imageURL;
	private JTextField idT, nameT, lnameT ;
	private JComboBox departmentC,genderC;
	private JRadioButton maleRadio, femaleRadio;
	private ButtonGroup radios;
	private JPanel radiosP, imageP;
	private String genderSelection, imageSelect;

	
	public AdminPanel(){
		
		setSize(600,600);
		setLayout(new GridLayout(8,16));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Administrator Panel");
		
		maleRadio=new JRadioButton("Male");
		maleRadio.setActionCommand("Male");
		femaleRadio=new JRadioButton("Female");
		femaleRadio.setActionCommand("Female");
		radios=new ButtonGroup();
	    radios.add(maleRadio);
	    radios.add(femaleRadio);
	    radiosP=new JPanel();
	    radiosP.setLayout(new GridLayout(1,2));
	    radiosP.add(maleRadio);
	    radiosP.add(femaleRadio);
	   
	    
		id=new JLabel("Enter Student ID");
		idT=new JTextField();
		name=new JLabel("Enter Student Name");
		nameT=new JTextField();
		searchB=new JLabel("Press button to see student information");
		lname=new JLabel("Student Last Name");
		lnameT=new JTextField();
		department=new JLabel("Student Department");
		departmentC=new JComboBox();
		departmentC.setModel(new DefaultComboBoxModel(new String []{"Computer Engineering", "Electric-Electronics Engineering", "Economics"}));
		gender=new JLabel("Student Gender");
		genderC=new JComboBox();
		genderC.setModel(new DefaultComboBoxModel(new String []{"Female", "Male"}));
		add=new JButton("ADD");
		delete=new JButton("DELETE");
		search=new JButton("SEARCH");
		
		imageLabel=new JLabel("Choose the photo of student: ");
		imageURL=new JLabel();
		imageChoose=new JButton("PHOTO");
		imageP=new JPanel(new GridLayout(1,2));
		imageP.add(imageURL);
		imageP.add(imageChoose);
		
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					//System.out.println("Installed");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/fehime", "root", "12345");
					Statement stmt=conn.createStatement();
					
					int id=Integer.parseInt(idT.getText());		
					
					ResultSet rs = stmt.executeQuery("select * from Student where ID="+id);
					while(rs.next()){

					    departmentC.setSelectedItem(rs.getString("Department"));						
						nameT.setText(rs.getString("Name"));
						lnameT.setText(rs.getString("LastName"));
						if(rs.getString("Gender").equals("Male")){
							maleRadio.setSelected(true);
						}else{
							femaleRadio.setSelected(true);
						}
						
						
						//genderC.setSelectedItem(rs.getString("Gender"));
						//idT.setText(rs.getString("ID"));
						//imageURL.setText(rs.getString("Image"));
						
						byte[] img = rs.getBytes("Image");
						if(img==null){
							String a=("/Users/fggi/Desktop/benimkiler/8.jpg");
							final ImageIcon imgIcon=new ImageIcon(a);
							imageURL.setIcon(imgIcon);
						}
						else{
						ImageIcon imager = new ImageIcon(img);
	                    Image im = imager.getImage();
	                    Image myImg = im.getScaledInstance(imageURL.getWidth(), imageURL.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    imageURL.setIcon(newImage);
						}
						
						
					}
						
				
				}catch(Exception e){
					System.out.println("Problem");
					JOptionPane.showMessageDialog(null, "OH! Problem Occured!");
			
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
					Statement stmt=conn.createStatement();
					//System.out.println(newID);
					//IDgen();	
					
				    if(maleRadio.isSelected()){
						genderSelection="Male";
					}else{
						genderSelection="Female";
					}
					
					//String query="insert into Student (ID, Name, LastName,Department,Gender,Image) values ('"
					//+null+"','"+lnameT.getText()+"','"+nameT.getText()+"','"+departmentC.getSelectedItem()
					//+"','"+genderSelection+"','"+imageURL.getText()+"')";
					
					//stmt.executeUpdate(query);
		
					
					//idT.setText(" ");
				    //nameT.setText(" ");
				    //lnameT.setText(" ");
					
					InputStream is = new FileInputStream(new File(imageSelect));
					

					PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into Student (ID,Name,LastName,Department,Gender,Image) values(?,?,?,?,?,?)");
					ps.setString(1, null);
					ps.setString(2, nameT.getText());
					ps.setString(3, lnameT.getText());
					ps.setString(4, (String) departmentC.getSelectedItem());
					ps.setString(5, radios.getSelection().getActionCommand());
					ps.setBlob(6, is);
					ps.executeUpdate();
				
					
				    conn.close();
				    JOptionPane.showMessageDialog(null, "Student is added to database ");	
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("sorun");
					JOptionPane.showMessageDialog(null, "Problem ");
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
					String query="delete from Student where ID="+idT.getText();
					stmt.executeUpdate(query);
				    
				    idT.setText(" ");
				    nameT.setText(" ");
				    lnameT.setText(" ");
				    
				    conn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("sorun");
				}
				
				
			}
		});
		
		imageChoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null); 
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile(); 
					String path = selectedFile.getAbsolutePath();
					imageURL.setIcon(imageSetter(path));
					imageSelect = path; 
					
				} 
				else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No Data");
				}
				
			}
		});
		
	
		add(id);
		add(idT);
		add(searchB);
		add(search);
		add(name);
		add(nameT);
		add(lname);
		add(lnameT);
		add(department);
		add(departmentC);
		add(gender);
		add(radiosP);
		add(imageLabel);
		add(imageP);
		add(add);
		add(delete);
		
		setVisible(true);
	}
	
        public ImageIcon imageSetter(String path){
		
		ImageIcon img = new ImageIcon(path);
		Image a = img.getImage();
		Image b = a.getScaledInstance(imageURL.getWidth(), imageURL.getHeight(),Image.SCALE_SMOOTH); 
		ImageIcon image = new ImageIcon(b);
		return image;
	}
	
	
	
	public static void main(String[] args) {
		new AdminPanel();
	}

}
