package CWork;

import java.util.Random;
import java.util.Scanner;


public class CPractice {
	
	
	public int averageCalc(int a[]){
		int avrg=0;
		int leng=a.length;
		
		for(int i=0; i<leng;i++){
			
		}
		
		
		
		return avrg;
	}

	
	public static void main(String[] args) {
		System.out.println("Enter the number of students:");
		Scanner sc= new Scanner(System.in);
		int numOfStu=sc.nextInt();
		System.out.println("Enter the number of exams");
		int numOfExam=sc.nextInt();
		System.out.println("Enter the number of assignments:");
		int numOfAsgn=sc.nextInt();
		System.out.println("Enter the number of quizes");
		int numOfQuiz=sc.nextInt();
		System.out.println("Enter the weight of quizes on grade:");
		int wghtQuiz=sc.nextInt();
		System.out.println("Enter the weight of assignments on grade:");
		int wghtAssg=sc.nextInt();
		 
		int row=numOfStu;//number of rows
		int col=numOfAsgn+numOfExam+numOfQuiz+3;//number of columns
		
        String [] bar= new String [numOfAsgn+numOfExam+numOfQuiz+3];
		int [][] gradesTable=new int [row][col]; 
         
        Random id=new Random(); 
        
        Random grade=new Random();
        
        System.out.print("\n");
        System.out.println("GRADE TABLE:");
        
        bar[0]="StudentID";
        System.out.print(bar[0]+"\t");
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
        
        
		int quizAvg=wghtQuiz/(numOfQuiz*100);
		int assgAvg=wghtAssg/(numOfAsgn*100);
		int examAvg=(100-(wghtAssg+wghtQuiz))/(numOfExam*100);
		
        int i,j,k,t,v;
        
        
		for( i=0; i<row; i++){
			 for( j=0; j<=col; j++){
				try{
				if(j==0){
				      int a=id.nextInt(999999999)+1000000000;				      
				      gradesTable[i][0]=a;				      
				      System.out.print(gradesTable[i][0]+"\t");
				}
				
				else if(j==col-2){
					//int d=0;
					//int f=0;
					//int g=0;
					int temp=0;
					
					for(k=1;k<=col-2;k++){
						
						if(k<=numOfExam){
							temp=temp+gradesTable[i][k]*examAvg;
							
						}else if(k>numOfExam && k<=numOfExam+numOfAsgn){
							temp=+gradesTable[i][k]*assgAvg;
							//temp=f+temp;
						}else if(k>numOfExam+numOfAsgn){
							temp=+gradesTable[i][k]*quizAvg;
							//temp=g+temp;
						}
						
					   
					/*d=gradesTable[i][k]*examAvg;
					temp=d+temp;
					}
					for(t=numOfExam+1; t<numOfExam+1+numOfAsgn;t++ ){
					f=gradesTable[i][t]*assgAvg;
					temp=f+temp;
					}
					for(v=numOfExam+numOfAsgn+1; t<numOfExam+1+numOfAsgn+numOfQuiz;t++ ){
						g=gradesTable[i][v]*quizAvg;
						temp=g+temp;
					}
					*/
					}
					gradesTable[i][j]=temp;
					System.out.print(temp+"\t");

				
				    
				}
				else if(j==col-1){
					int strF=Integer.parseInt("F");
		
					if(gradesTable[i][col-2]<50){
						gradesTable[i][j]=strF;
						
					}
					else if(gradesTable[i][col-2]>50 && gradesTable[i][col-2]<70){
						gradesTable[i][j]=Integer.parseInt("D");
						
					}
					else if(gradesTable[i][col-2]>69 && gradesTable[i][col-2]<86){
						gradesTable[i][j]=Integer.parseInt("C");
						
					}
					else if(gradesTable[i][col-2]>85 && gradesTable[i][col-2]<91){
						gradesTable[i][j]=Integer.parseInt("B");
						
					}
					else if(gradesTable[i][col-2]>90 && gradesTable[i][col-2]<101){
						gradesTable[i][j]=Integer.parseInt("A");
						
					}
					System.out.print(gradesTable[i][j]);
					
				}
				
				else{
					int b=grade.nextInt(100);
				    gradesTable[i][j]=b;
				    if(b<10){
				    System.out.print(gradesTable[i][j]+"\t");
				    }
				    else{
				    	System.out.print(gradesTable[i][j]+"\t");
				    }
				}
				}
				catch(Exception e){
					
				}
				
			}
			System.out.print("\n");
			
		}
        
	}

}



