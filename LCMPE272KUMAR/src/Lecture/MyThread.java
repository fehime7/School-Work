package Lecture;

public class MyThread implements Runnable{
	private int n,k,l;
	
	public void run(){
		//for(int i=1; i<11;i++){
			
		//System.out.println(i);
		//printNumbers(n);
		add(k,l);
	}
	
	
	public void printNumbers(int n){
		for(int i=1; i<=n;i++){
			
			System.out.println(i);
		}
	}
	public MyThread( int k, int l){
	
		this.k=k;
		this.l=l;
	}
	
	public void add(int k, int l){
		int temp=0;
		if(k<l){
			for(int i=k;i<=l;i++){
				temp=temp+i;
				
			}
		}
		else{
			for(int i=l;i<=k;i++){
				temp=temp+i;
		}
	}
		System.out.println(temp);

}
}
