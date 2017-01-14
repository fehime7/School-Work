package CWork;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Grades2 extends JFrame implements ActionListener {
	Random rnd = new Random();
	private JButton  btnRes, btnExit, btnCalc;
	private JTextField studentNumber, quizNumber,txtName1, txtName2, txtNameA1,txtNameA2,txtNameAmin1,txtNameAmin2,txtNameBmax1,txtNameBmax2,txtNameB1,txtNameB2,txtNameBmin1,txtNameBmin2,txtNameCmax1,txtNameCmax2,txtNameC1,txtNameC2,txtNameCmin1,txtNameCmin2,txtNameDmax1,txtNameDmax2,txtNameD1,txtNameD2,txtNameF1,txtNameF2;
	private JLabel command1, command2, commandfree,commanddeneme, gradeA,gradeAmin,gradeBmax,gradeB,gradeBmin, gradeCmax, gradeC, gradeCmin, gradeDmax, gradeD,gradeF;
    private JPanel pn, panel;
    private JTable table;
    private JScrollPane myPane;
    private int studentNr, quizNr;
	
	String[] alphabet = { "A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" }; //String Array that using to create random Names and Surnames
	int [] studentIDarray={1,2,3,4,5,6,7,8,9,0}; //Integer Array that using to create random ID Numbers
	
	int studentAverage;
	//private int studentNum;//Counter for average grades of students
	

	
	public void StudentID (int a){       //IDARRAY
		int [] IDStudent=new int[9] ;
		for(int i=0; i<9; i++){
			IDStudent[i]=rnd.nextInt(10);
			System.out.print(IDStudent[i]);
			
		}}
	public String studentName(){ 
		
		String name=" ";
		
		String[] nameStudent=new String[5];
	for(int i=0;i<5;i++){
		int w = rnd.nextInt(26);
		//Takes the random letter out of 26 letters
		//System.out.print(alphabet[w]);
		name+=alphabet[w];
	}
	
	
	return name;
	
	
	}
	 String studentSurname(){     //SURNAME ARRAY
		String surname=" ";
		
		String[] surnameStudent=new String[5];
	for(int i=0;i<5;i++){
		int w = rnd.nextInt(26);			 //Takes the random letter out of 26 letters
		//System.out.print(alphabet[w]);
		surname+=alphabet[w];
	}
	return surname;
	
	}
	public String averages(int studentAverage, int m, int n , int m1, int n1, int m2, int n2, int m3, int n3, int m4, int n4, int m5, int n5, int m6, int n6, int m7, int n7, int m8, int n8, int m9, int n9, int m10, int n10){
		String letterGrade=" ";
		
		if((studentAverage>n10)&&(studentAverage<=m10)){    			 //There we print the average and letter grading part of the table
			letterGrade="F";
			
		}else if((studentAverage>n9)&&(studentAverage<=m9)){
			letterGrade="D";
	
	}
		else if((studentAverage>n8)&&(studentAverage<=m8)){
			letterGrade="D+";
	
	}
		else if((studentAverage>n7)&&(studentAverage<=m7)){
			letterGrade="C-";
	
	}
		else if((studentAverage>n6)&&(studentAverage<=m6)){
			letterGrade="C";
	
	}
		else if((studentAverage>n5)&&(studentAverage<=m5)){
			letterGrade="C+";
	
	}
		else if((studentAverage>n4)&&(studentAverage<=m4)){
			letterGrade="B-";
	
	}
		else if((studentAverage>n3)&&(studentAverage<=m3)){
			letterGrade="B";
	
	}
		else if((studentAverage>n2)&&(studentAverage<=m2)){
			letterGrade="B+";
	
	}
		else if((studentAverage>n1)&&(studentAverage<=m1)){
			letterGrade="A-";
	}
		else if((studentAverage>n)&&(studentAverage<=m)){
			letterGrade="A";
			
	}
		return letterGrade;
	}

	
		
	
	/*public void gradeTable(int a, int b,  int m, int n , int m1, int n1, int m2, int n2, int m3, int n3, int m4, int n4, int m5, int n5, int m6, int n6, int m7, int n7, int m8, int n8, int m9, int n9, int m10, int n10) {       //Content of the table
		Random rnd = new Random();               //Generates random numbers to u parameter below
		int counter=0;     
		int r=0;
		int[][] quizTable=new int [a][b];
		int [] quizSum= new int [b];             //Creating an Integer Array for printing the average of each quiz at the bottom of the list
		
		System.out.print("   "+"ID Number"+ "\t"+ "Name"+"\t"+"Surname" + "\t"+"\t");  //For printing ID Number, Name and Surname Strings to the top of the list
		
		for(int i=0;i<b; i++){                   //For printing Quiz Numbers to the top of the list
			counter=counter+1;
		System.out.print("Quiz-"+(i+1)+ "\t");
		}                                                     
		System.out.print("Average"+ "\t"+"Letter");           //For printing Average and Letter strings to the top of the list
		System.out.println();                    //
		System.out.println();                    // The gap between the Strings and quiz grades.
		
		for (int i = 0; i < a; i++) {            //This loop makes operations for rows thats equal to Student Numbers
			
			int studentSum=0;                    //Accumulator that using for summing each students Quiz Grades
			int c=0;							 //t'th element of Integer Array quizSum (quiz number at below)
			if(i<9){							 //    
				System.out.print(" "+(i+1)+"-");
			}else{
			System.out.print((i+1)+"-");
			}		 //for the order of the student
            
			StudentID (a);           //Calls the studentId method with studentIDarray to generate the ID Numbers of each student
            System.out.print("\t");
            
			studentName();             //Calls the generateNames method with alphabet Array for student Name
			System.out.print("\t");
			
			studentSurname();             //Calls the generateNames method with alphabet Array for student Surname
			System.out.print("\t");			
			
			for (int j = 0; j < b ; j++) {       //This loop makes operations for columns that equal to Quiz Numbers
				int u =rnd.nextInt(101);         //Generating the random numbers for Quiz Grades
				
				//System.out.print("\t" + u);	     //Printing the random numbers for Quiz Grades
				studentSum=(studentSum+u);       //Summing with u parameter to keep the total Quiz Points of each Students
				

				if((i<a)&&(j==c)){				 //This clause working for Integer Array that named quizSum that collects the total Points of each quizes to generate the average point of each quiz
					quizTable[r][c]=quizTable[r][c]+u;
					System.out.print("\t"+quizTable[r][c]);			
					quizSum[c]=quizSum[c]+u;			
				} 
				c++;							 //Increases with each column
			}
			
			studentAverage=(studentSum)/b;	     //The average Grades of each student
			r++;
			averages(studentAverage,  m,  n ,  m1, n1,  m2,  n2, m3, n3, m4,n4, m5, n5,m6,n6, m7, n7, m8,n8, m9, n9, m10, n10);
			Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3","4" },
			        { "Row2-Column1", "Row2-Column2", "Row2-Column3","4435" } };
			}
		
		
		System.out.println();					    //Prints a blank line between quiz grades part and quiz averages part of table
		System.out.print("Quiz Averages ="+"\t"+"\t"+"\t"); //Prints the Quiz Averages String
		for(int k=0; k<b; k++){					    //The loop to print the average grades of each quiz for every column
			
			System.out.print("\t"+(quizSum[k]/a));  //Prints the Average grade (sum of the quizzes over student number) for each quiz
		}
			}
			
			*/
	public static void main(String[] args) {
		
		
	new Grades2();
	
	
	}


		public Grades2(){
			
			panel= new JPanel();
			panel.setSize(500,250);
			panel.setLocation(160,400);
			
			
			
	        
			command1=new JLabel ("First Number ");
			txtName1= new JTextField();
			setLayout(null);
			
			command1.setBounds(25, 25, 250, 15);
			command1.setFont(new Font("Tahoma",Font.BOLD,13));
			command1.setForeground(Color.pink);
			txtName1.setBounds(225, 25,  100, 20);
			txtName1.setBackground(Color.YELLOW);
			
			//For second Number
			
			command2=new JLabel ("Second Number ");
			txtName2= new JTextField();
			setLayout(null);
			
			command2.setBounds(25, 65, 250, 15);
			command2.setFont(new Font("Tahoma",Font.BOLD,13));
			command2.setForeground(Color.pink);
			txtName2.setBounds(225, 65,  100, 20);
			txtName2.setBackground(Color.YELLOW);
			
			
			
			//For grade A
			gradeA=new JLabel ("Grade A ");
			txtNameA1= new JTextField();txtNameA2= new JTextField();
			setLayout(null);
			
			gradeA.setBounds(475, 25, 250, 15);
			gradeA.setForeground(Color.RED);
			txtNameA1= new JTextField("100");
			txtNameA2= new JTextField("90");
			txtNameA1.setBounds(575, 25,  100, 20);
			txtNameA2.setBounds(700, 25,  100, 20);
			
			
			//For A-
			gradeAmin=new JLabel ("Grade A- ");
			txtNameAmin1= new JTextField();txtNameAmin2= new JTextField();
			setLayout(null);
			
			gradeAmin.setBounds(475, 50, 250, 15);
			gradeAmin.setForeground(Color.RED);		
			txtNameAmin1= new JTextField("89");
			txtNameAmin2= new JTextField("80");
			txtNameAmin1.setBounds(575, 50,  100, 20);
			txtNameAmin2.setBounds(700, 50,  100, 20);
			
			//For B+
			
			gradeBmax=new JLabel ("Grade B+ ");
			txtNameBmax1= new JTextField();txtNameBmax2= new JTextField();
			setLayout(null);
			
			gradeBmax.setBounds(475, 75, 250, 15);
			gradeBmax.setForeground(Color.RED);	
			txtNameBmax1= new JTextField("79");
			txtNameBmax2= new JTextField("70");
			txtNameBmax1.setBounds(575, 75,  100, 20);
			txtNameBmax2.setBounds(700, 75,  100, 20);
			
			//For B
			gradeB=new JLabel ("Grade B ");
			txtNameB1= new JTextField();txtNameB2= new JTextField();
			setLayout(null);
			
			gradeB.setBounds(475, 100, 250, 15);
			gradeB.setForeground(Color.RED);
			txtNameB1= new JTextField("69");
			txtNameB2= new JTextField("60");
			txtNameB1.setBounds(575, 100,  100, 20);
			txtNameB2.setBounds(700, 100,  100, 20);
			
			//For B-
			gradeBmin=new JLabel ("Grade B- ");
			txtNameBmin1= new JTextField();txtNameBmin2= new JTextField();
			setLayout(null);
			
			gradeBmin.setBounds(475, 125, 250, 15);
			gradeBmin.setForeground(Color.RED);		
			txtNameBmin1= new JTextField("59");
			txtNameBmin2= new JTextField("50");
			txtNameBmin1.setBounds(575, 125,  100, 20);
			txtNameBmin2.setBounds(700, 125,  100, 20);
			
			//For C+
			gradeCmax=new JLabel ("Grade C+ ");
			txtNameCmax1= new JTextField();txtNameCmax2= new JTextField();
			setLayout(null);
			
			gradeCmax.setBounds(475, 150, 250, 15);
			gradeCmax.setForeground(Color.RED);		
			txtNameCmax1= new JTextField("49");
			txtNameCmax2= new JTextField("40");
			txtNameCmax1.setBounds(575, 150,  100, 20);
			txtNameCmax2.setBounds(700, 150,  100, 20);
			
			//For C
			gradeC=new JLabel ("Grade C ");
			txtNameC1= new JTextField();txtNameC2= new JTextField();
			setLayout(null);
			
			gradeC.setBounds(475, 175, 250, 15);
			gradeC.setForeground(Color.RED);	
			txtNameC1= new JTextField("39");
			txtNameC2= new JTextField("30");
			txtNameC1.setBounds(575, 175,  100, 20);
			txtNameC2.setBounds(700, 175,  100, 20);
			
			//For C-
			gradeCmin=new JLabel ("Grade C- ");
			txtNameCmin1= new JTextField();txtNameCmin2= new JTextField();
			setLayout(null);
			
			gradeCmin.setBounds(475, 200, 250, 15);
			gradeCmin.setForeground(Color.RED);		
			txtNameCmin1= new JTextField("29");
			txtNameCmin2= new JTextField("20");
			txtNameCmin1.setBounds(575, 200,  100, 20);
			txtNameCmin2.setBounds(700, 200,  100, 20);
			
			//For D+
			gradeDmax=new JLabel ("Grade D+ ");
			txtNameDmax1= new JTextField();txtNameDmax2= new JTextField();
			setLayout(null);
			
			gradeDmax.setBounds(475, 225, 250, 15);
			gradeDmax.setForeground(Color.RED);		
			txtNameDmax1= new JTextField("19");
			txtNameDmax2= new JTextField("10");
			txtNameDmax1.setBounds(575, 225,  100, 20);
			txtNameDmax2.setBounds(700, 225,  100, 20);
			
			//For D
			gradeD=new JLabel ("Grade D ");
			txtNameD1= new JTextField();txtNameD2= new JTextField();
			setLayout(null);
			
			gradeD.setBounds(475, 250, 250, 15);
			gradeD.setForeground(Color.RED);	
			txtNameD1= new JTextField("9");
			txtNameD2= new JTextField("5");
			txtNameD1.setBounds(575, 250,  100, 20);
			txtNameD2.setBounds(700, 250,  100, 20);
			
			
			//For F
			gradeF=new JLabel ("Grade F ");
			txtNameF1= new JTextField();txtNameF2= new JTextField();
			setLayout(null);
			
			gradeF.setBounds(475, 275, 250, 15);
			gradeF.setForeground(Color.RED);	
			txtNameF1= new JTextField("5");
			txtNameF2= new JTextField("0");
			txtNameF1.setBounds(575, 275,  100, 20);
			txtNameF2.setBounds(700, 275,  100, 20);
			
			
			//Calculate
			
			btnCalc= new JButton ("Calculate");
			btnCalc.setLocation(25,215);
			btnCalc.setSize(120, 25);
			btnCalc.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,16));
			
			//Reset
			
			btnRes= new JButton ("Reset");
			btnRes.setLocation(158,215);
			btnRes.setSize(120, 25);
			btnRes.setForeground(Color.RED);
			btnRes.setFont(new Font("Tahoma",Font.ITALIC,16));
			
			//Exit
			
			btnExit= new JButton ("Exit");
			btnExit.setLocation(290,215);
			btnExit.setSize(120, 25);
			btnExit.setForeground(Color.MAGENTA);
			btnExit.setFont(new Font("Tahoma",Font.ITALIC,16));
			
			
			//commanddeneme
			commanddeneme=new JLabel ("Selamun Aleykum ");
			setLayout(null);
			
			commanddeneme.setBounds(25, 65, 250, 15);
			commanddeneme.setFont(new Font("Tahoma",Font.BOLD,13));
			commanddeneme.setForeground(Color.pink);
			
			

			
			
			//Adding Part
									//For other Buttons, Texts and Labels
			
			add(btnCalc);		add(btnRes);		add(btnExit);
			add(txtName1);		add(txtName2);		
			add(txtNameA1);		add(txtNameA2);
			add(txtNameAmin1);	add(txtNameAmin2);
			add(txtNameBmax1);	add(txtNameBmax2);
			add(txtNameB1);		add(txtNameB2);
			add(txtNameBmin1);	add(txtNameBmin2);
			add(txtNameCmax1);	add(txtNameCmax2);
			add(txtNameC1);		add(txtNameC2);
			add(txtNameCmin1);	add(txtNameCmin2);
			add(txtNameDmax1);	add(txtNameDmax2);
			add(txtNameD1);		add(txtNameD2);
			add(txtNameF1);		add(txtNameF2);
			
			add(command1);		add(command2);
			add(gradeA);		add(gradeAmin);
			add(gradeBmax);		add(gradeB);		add(gradeBmin);
			add(gradeCmax);		add(gradeC);		add(gradeCmin);
			add(gradeDmax);		add(gradeD);		
			add(gradeF);		
			//add(panel);

			panel.add(commanddeneme);
			
			
			
			
			btnRes.addActionListener (this);
			btnCalc.addActionListener(this);
			btnExit.addActionListener(this);
			
			
			setSize(850, 700);
			getContentPane().setBackground(Color.CYAN);
			setTitle("Calculator");
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCalc)){
			
				
		try{	
					
					gradeTable1();
					repaint();
					
				}
				catch(Exception e1){
					System.out.println("Please enter available datas and fill the blanks for grading... ");
			}
				}
			else if(e.getSource().equals(btnRes)){
				reset();
				
			}
			else if(e.getSource().equals(btnExit)){
				System.exit(0);
			}
		}

	
	
	public void reset(){
		txtName1.setText("");		txtName2.setText("");
		txtNameA1.setText("");		txtNameA2.setText("");		
		txtNameAmin1.setText(""); 	txtNameAmin2.setText("");
		txtNameBmax1.setText("");	txtNameBmax2.setText("");
		txtNameB1.setText("");      txtNameB2.setText("");
		txtNameBmin1.setText("");	txtNameBmin2.setText("");
		txtNameCmax1.setText("");	txtNameCmax2.setText("");
		txtNameC1.setText("");		txtNameC2.setText("");
		txtNameCmin1.setText("");	txtNameCmin2.setText("");
		txtNameDmax1.setText("");	txtNameDmax2.setText("");
		txtNameD1.setText("");		txtNameD2.setText("");
		txtNameF1.setText("");		txtNameF2.setText("");
		
	}
	
	
	
	public void gradeTable1(){
		
		String studentNum=txtName1.getText();
		String quizNumber=txtName2.getText();
		
		studentNr=Integer.parseInt(studentNum);
		quizNr=Integer.parseInt(quizNumber);
		
		
		int row=studentNr+1;
		int col=quizNr+5;
		
		int[][] quizGrades=new int [row][col];
		
		
		
		String studentNumber=txtName1.getText();
		String quizNumbr=txtName2.getText();
				String strOne=txtNameA1.getText();        
				String strTwo=txtNameA2.getText();
				String strThree=txtNameAmin1.getText();
				String strFour=txtNameAmin2.getText();
				String strFive=txtNameBmax1.getText();
				String strSix=txtNameBmax2.getText();
				String strSeven=txtNameB1.getText();
				String strEight=txtNameB2.getText();
				String strNine=txtNameBmin1.getText();
				String strTen=txtNameBmin2.getText();
				String strEleven=txtNameCmax1.getText();
				String strTwelve=txtNameCmax2.getText();
				String strThirteen=txtNameC1.getText();
				String strFourteen=txtNameC2.getText();
				String strFifteen=txtNameCmin1.getText();
				String strSixteen=txtNameCmin2.getText();
				String strSeventeen=txtNameDmax1.getText();
				String strEighteen=txtNameDmax2.getText();
				String strNineteen=txtNameD1.getText();
				String strTwenty=txtNameD2.getText();
				String strTwentyone=txtNameF1.getText();
				String strTwentytwo=txtNameF2.getText();
				
				
				studentNr=Integer.parseInt(studentNumber);
				quizNr=Integer.parseInt(quizNumbr);
				int one=Integer.parseInt(strOne);
				int two=Integer.parseInt(strTwo);
				int three=Integer.parseInt(strThree);
				int four=Integer.parseInt(strFour);
				int five=Integer.parseInt(strFive);
				int six=Integer.parseInt(strSix);
				int seven=Integer.parseInt(strSeven);
				int eight=Integer.parseInt(strEight);
				int nine=Integer.parseInt(strNine);
				int ten=Integer.parseInt(strTen);
				int eleven=Integer.parseInt(strEleven);
				int twelve=Integer.parseInt(strTwelve);
				int thirteen=Integer.parseInt(strThirteen);
				int fourteen=Integer.parseInt(strFourteen);
				int fifteen=Integer.parseInt(strFifteen);
				int sixteen=Integer.parseInt(strSixteen);
				int seventeen=Integer.parseInt(strSeventeen);
				int eighteen=Integer.parseInt(strEighteen);
				int nineteen=Integer.parseInt(strNineteen);
				int twenty=Integer.parseInt(strTwenty);
				int twentyone=Integer.parseInt(strTwentyone);
				int twentytwo=Integer.parseInt(strTwentytwo);
				
		
		int total=0; 
		int avrg=0;
		String curve=" ";
		int curveTotal=0;
		
		
		String quizes[]=new String[col];
		String myData[][]=new String [row][col];
		
		for(int i=0;i<col;i++)
			if(i==0){
				quizes[i]="id";
			}
			else if(i==1){
		    	quizes[i]="name";
		    	
		    }
			else if(i==2){
		    	quizes[i]="last name";
		    	
		    }else if(i==col-2){
		    	quizes[i]="average";
		    }else if(i==col-1){
		    	quizes[i]="letter";
		    }
			else{
		    	quizes[i]="quiz: " +(i-2);
		    }
			
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
			
			if(i<row-1){
				
				if(j==0){
					String a=(rnd.nextInt(99999999)+100000000)+" ";
					myData[i][j]=a;
				}
				else if(j==1){
					myData[i][j]= studentName();
				}else if(j==2){
					myData[i][j]= studentSurname();			
				}else if(j==col-2){
					avrg=total/(col-5);
					myData[i][j]=avrg+" ";
				}else if(j==col-1){
					String lg=averages(avrg,one, two,three,four,five,six,seven,eight,nine,ten,
						eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,
						eighteen,nineteen,twenty,twentyone,twentytwo);	
					
					myData[i][j]=lg;
				}else{
				  int x=rnd.nextInt(100);
				  myData[i][j]=x+" ";
				  total+=x;
				  
				}
				
			  }
			else if(i==row-1 && j>2 && j<col-2){
				
				for(int k=3; k<col;k++){
					for(int t=0; t<row-1; t++){
						
						//String num=myData[t][k];
						//int a=Integer.parseInt(num);
						System.out.print(myData[t][k]+"\t");
						
						curveTotal+=1;
						
					}
					curve=curveTotal+" ";
					curveTotal=0;
				}
				myData[i][j]=curve;
				
			}
			
			}
			total=0;
			avrg=0;
			
		}
		
		
			
		
		
		
		String []title={"Name", "LastName","Grade"};
		String[][] data={{"aa","bb","90"}, {"aa1","bb1","80"},{"aa2","bb2","50"}};
		table=new JTable(myData,quizes);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		myPane=new JScrollPane(table);
		myPane.setAutoscrolls(true);
		
	
		myPane.setLocation(160,400);
		myPane.setSize(500,250);
		table.setLocation(10,40);
		table.setSize(450,450);
		add(myPane);
	//	add(table);
		this.repaint();
		//table.setVisible(true);
		
	}
	}	