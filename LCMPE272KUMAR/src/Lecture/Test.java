package Lecture;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String thrNum=args[0];
		String finalNum=args[1];
		int a=Integer.parseInt(thrNum);
		int b=Integer.parseInt(finalNum);
		Calculator cal[]=new Calculator[a];
		int sum=0;
		int start=1;
		int rate=b/a;
		int rateFinal= rate;
		for(int i=0; i< a; i++ ){
			cal[i]=new Calculator(start , rateFinal);
			start=rateFinal+1;
			rateFinal+=rate;
			cal[i].start();
			
		}
		
		
		//Calculator cal1=new Calculator(1, 50);
		//Calculator cal2=new Calculator(51, 100);
		
		//cal1.start();
		//cal2.start();
	

		
		try{
		  for(int i=0; i< a; i++ ){
			cal[i].join();
	        sum=sum+cal[i].result;
	        System.out.println(sum);
		  }
		  System.out.println(sum);
		}
		catch(InterruptedException e){
			System.out.println("Problem occured");
		}
	
		

	}

}
