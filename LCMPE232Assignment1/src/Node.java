

public class Node<T> {
   T data;
   Node<T> next;
 
   public Node(T data, Node<T> next) {
	super();
	this.data = data;
	this.next = next;
  } 
   
   public T getData(){
	   return data;
   }
   
   public void addTail(T t){
	   if(next==null)
		   next=new Node<T>(t, null);
	   else
		   next.addTail(t);
   }

   public int count(){
	if(next==null) return 1;
	return 1+ next.count(); 
   }
   
   public boolean contains(T t){
	   if(next==null)
		   return data.equals(t);
	   
	   return data.equals(t)|| next.contains(t);
	   
   }

public String toPrint() {
	
	if(next==null) return this.data+" ";
	
	return this.data+" "+ next.toPrint();
	
}

}
