package CWork;

import java.util.Random;
import java.util.Scanner;

public class CAssignment {
	
	int numOfStu, numOfExam, numOfAsgn, numOfQuiz, wghtExam, wghtAsgn, wghtQuiz;
	double totalAvrg;

	
	
	public void getAllNumbers(){
		//Scanners 
		System.out.println("Enter the number of students:");
		Scanner sc= new Scanner(System.in);
		numOfStu=sc.nextInt();
		System.out.println("Enter the number of exams:");
		numOfExam=sc.nextInt();
		System.out.println("Enter the number of assignments:");
		numOfAsgn=sc.nextInt();
		System.out.println("Enter the number of quizes:");
		numOfQuiz=sc.nextInt();		
		System.out.println("Enter the weight of exams on grade:");
		wghtExam=sc.nextInt();
		System.out.println("Enter the weight of assignments on grade:");
		wghtAsgn=sc.nextInt();
		
	}
	
	public void upperBar(){
        System.out.print("StudentID"+"\t");
        System.out.print("Name"+"\t");
        System.out.print("Surname"+"\t");
        for(int k=1; k<numOfExam+1; k++){
        	
        	System.out.print("Exam"+k+"\t");
        }
        for(int k=1; k<numOfAsgn+1; k++){
        	System.out.print("Assgn"+k+"\t");
        }
        for(int k=1; k<numOfQuiz+1; k++){
        	System.out.print("Quiz"+k+"\t");
        }
        System.out.print("Average"+"\t");
        System.out.print("Grade"+"\n");
		
		
	}
	
	public void idGenerator(){
		Random id=new Random(); //student id 
		int a=id.nextInt(999999999)+1000000000;				      				      
	    System.out.print(a+"\t");
	}
	
	public void gradeGenerator(){
		Random grade=new Random();//grades
		int b=grade.nextInt(100);
	    System.out.print(b+"\t");
		
	}
	
	public void averageCalc(int et, int at, int qt){
		wghtQuiz=100-wghtAsgn-wghtExam;
		double examAvrg=(et/numOfExam)*(wghtExam);
		double asgnAvrg=(at/numOfAsgn)*(wghtAsgn);
		double quizAvrg=(qt/numOfQuiz)*(wghtQuiz);
		totalAvrg=(examAvrg+asgnAvrg+quizAvrg)/100;
		System.out.print(totalAvrg+"\t");
		
	}
	
	public void markGenerator(double ta){
		if(ta<=30){
			System.out.print("F");
		}else if(ta>30 && ta<=50){
			System.out.print("D");		
		}else if(ta>50 && ta<=70){
			System.out.print("C");
		}else if(ta>70 && ta<=80){
			System.out.print("B");
		}else{
			System.out.print("A");
		}
			
	}
	
	String[] alphabet = { "A", "B", "C", "D", "E","F","G","H","I","J","K","L",
			         "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
	Random rnd=new Random();
			
    public String studentName(){ 
		
		String name=" ";
	
	for(int i=0;i<5;i++){
		int w = rnd.nextInt(26);
		//Takes the random letter out of 26 letters
		//System.out.print(alphabet[w]);
		name+=alphabet[w];
	}
	
	
	return name;
	
	
	}
	public String studentSurname(){     //SURNAME ARRAY
		String surname=" ";
	
	for(int i=0;i<5;i++){
		int w = rnd.nextInt(26);			 //Takes the random letter out of 26 letters
		//System.out.print(alphabet[w]);
		surname+=alphabet[w];
	}
	return surname;
	
	}
	
	public void makeTable(){

		int row=numOfStu+1;//number of rows
		int col=numOfAsgn+numOfExam+numOfQuiz+5;//number of columns
		int examTotal=0; 
		int quizTotal=0;
		int asgnTotal=0;
		int grd;
		
		for(int k=0;k<6; k++){
			if(k==0){
				System.out.print("StudentID"+"\t");
			}else if(k==1){
				System.out.print("Name"+"\t");
			}else if(k==2){
				System.out.print("Surname"+"\t");
			}else if(k==4){
				System.out.print("Average"+"\t");
			}else if(k==5){
				System.out.print("Grade"+"\n");
			}else{
                for(int t=1; t<numOfExam+1; t++){
		        	
		        	System.out.print("Exam"+t+"\t");
		        }
                for(int l=1; l<numOfAsgn+1; l++){
                	System.out.print("Assgn"+l+"\t");
                }
                for(int m=1; m<numOfQuiz+1; m++){
                	System.out.print("Quiz"+m+"\t");
                }
				
			}
			
			
		}
		
		Random grade=new Random();//grades
		
		for(int i=0; i<row;i++){
			for(int j=0; j<col; j++){
			
			if(i<row-1){	
				if(j==0){
					idGenerator();
				
				}else if(j==1){
					String nm=studentName();
					System.out.print(nm+"\t");
					
				}else if(j==2){
					String surnm=studentSurname();
					System.out.print(surnm+"\t");
				}
				else if(j>2 && j<=numOfExam+2){
					grd=grade.nextInt(100);
				    System.out.print(grd+"\t");
					examTotal+=grd;
				
				}else if(j>numOfExam+2 && j<=numOfExam+numOfAsgn+2){
					grd=grade.nextInt(100);
					System.out.print(grd+"\t");
					asgnTotal+=grd;
				
				}else if(j>numOfExam+numOfAsgn+2 && j<col-2){
					grd=grade.nextInt(100);
					System.out.print(grd+"\t");
					quizTotal+=grd;
				
				}else if(j==col-2){
					averageCalc(examTotal, asgnTotal, quizTotal);
					examTotal=0;
					asgnTotal=0;
					quizTotal=0;
				
				}else{
					markGenerator(totalAvrg);
				}
				
				
			  }else if(i==row-1 && j>2 && j<col-2){
					
					System.out.print(1+"\t");
					
				}
				
			}
			System.out.print("\n");
			}	
  
		
	}
	
	public static void main(String[] args) {
		CAssignment test=new CAssignment();
		test.getAllNumbers();
		test.makeTable();
	}

}
