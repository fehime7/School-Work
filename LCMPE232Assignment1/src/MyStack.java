

public class MyStack<T> implements IList<T> {
	 
		Node<T> head=null;
		
		@Override
		public void add(T t) {
			
			head= new Node<T>(t, head);
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
			int count=0;
			Node<T> temp=head;
			while(temp!=null){
				count++;
				temp=temp.next;
			}
			
			return count;
		}

		@Override
		public boolean has(T t) {
			
			Node<T> temp=head;
			while(temp!=null){
			   if(temp.getData().equals(t))
				   return true;
				temp=temp.next;
			}
			
			return false;
		}

		public String printing() {
			
			if(head==null) return "EMPTY";
			
			return head.toPrint();
			
		}


		
}
