
public class Test {
	
	public static void main(String[] args) {
		
		
		Integer x1=new Integer(64);
		Integer x2=new Integer(65);
		Integer x3=new Integer(16);
		Integer x4=new Integer(26);
		Integer x5=new Integer(5);
		Integer x6=new Integer(9);
		
		
		IList<Integer> mylist2=new MyQueue<Integer>();
		//IList<Integer> mylist2=new MyStack<Integer>();
		
		mylist2.add(x1);
		mylist2.add(x2);
		mylist2.add(x3);
		mylist2.add(x4);
		mylist2.add(x5);
		mylist2.add(x6);
		
		System.out.println(mylist2.size());
		System.out.println(mylist2.isEmpty());
		System.out.println(mylist2.take());
		System.out.println(mylist2.has(9));
		System.out.println(mylist2.has(99999));
		System.out.println(mylist2.size());
		
		
	
		method(mylist2);
		
		
	}
	
	private static void method(IList<Integer> liste) {
		//System.out.println("empty ");

	}

}
