
public class MyQueue<T> implements IList<T> {
 
	Node<T> head=null;
	
	@Override
	public void add(T t) {
		
		if(head==null){
			head=new Node<T>(t, null);
			return;
		}
		
		head.addTail(t);
		
		
		/*
		Node<T> temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		
		temp.next=new Node<T>(t, null);
		*/
		
	}

	@Override
	public T take() {
		T t= head.getData();
		head=head.next;
		return t;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public int size() {
		if(head==null)
			return 0;
		
		return head.count();
		
	}

	@Override
	public boolean has(T t) {
		if(head==null) return false;
		
		return head.contains(t);
		
		
	}

	@Override
	public String printing() {
		
		if(head==null) return "EMPTY";
		
		return head.toPrint();
		
	}

	
	
}
