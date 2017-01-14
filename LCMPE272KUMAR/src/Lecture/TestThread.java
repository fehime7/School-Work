package Lecture;

public class TestThread {
	public static void main(String[] args) {
		/*MyThread m=new MyThread();
		Thread k=new Thread(m);
		k.start();
		*/
		String a=args[0];
		String c=args[1];
		int p=Integer.parseInt(a);
		int z=Integer.parseInt(c);
		MyThread b=new MyThread(p,z);
		
		Thread t=new Thread(b);
		t.start();
		
		
		MyThread2 l= new MyThread2();
		l.start();
	}


}
