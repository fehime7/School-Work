package Lecture;

public class MyThread2 extends Thread{
	public void run(){
		numbers(10);
	}
	public void numbers(int n){
     for(int i=1; i<=n;i++){
			
			System.out.println(i);
		}
	}

}
