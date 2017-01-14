//how to rum multi threads paralel

package Lecture;

public class Calculator extends Thread{
	private int startNumber, finalNumber;
	public int result;
	
	public Calculator(int startNumber, int finalNumber){
		this.startNumber=startNumber;
		this.finalNumber=finalNumber;
		result=0;
	}
	
	public int calculateSum(){
		int sum=0;
		for(int i=startNumber; i<=finalNumber;i++)
			sum+=i;
		return sum;
	}
	
	public void run(){
		result=calculateSum();
	}
}
