package CWThree;


class Vertex {
	    
	 public int val;
	 public String name;   
     public Vertex next;
	    
     public Vertex(int val, String name)
	    {
	        this.val = val;
	        this.name=name;
	        
	    }
     public int getValueOfVertex(){
    	 return val;
     }
     public String getNameOfVertex(){
    	 return name;
     }
	}

class PriorityQueueSort{
	
	Vertex [] sortedVerticies;
	private Vertex first;
	
	public PriorityQueueSort(){
		first=null;
	}
	
	public void insert(Vertex node){
		Vertex previous=null;
		Vertex current=first;
		 while(current != null && node.val > current.val)
	        {
	            previous = current;
	            current = current.next;
	        }
	        if(previous==null)
	            first = node;
	        else
	            previous.next = node;
	            node.next = current;
	    }
	    
	public Vertex pop() {
	    Vertex temp = first;
	    first = first.next;
	    return temp;
	    }
  }
	class ClassWorkThree {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Vertex [] verticies={new Vertex(1,"a") ,new Vertex(6,"f"),new Vertex(2,"b"),new Vertex(26,"z"),new Vertex(10,"j"),new Vertex(13,"m")};
			PriorityQueueSort pqSort=new PriorityQueueSort();
			for (int i=0; i<verticies.length;i++)
				pqSort.insert(verticies[i]);
			
			for(int j=0; j<verticies.length; j++)
	            System.out.print(pqSort.pop().getNameOfVertex()+" ");
			    //System.out.print(pqSort.pop().getValueOfVertex()+" ");
	            System.out.println("");
	            
	        
   		 }

	  }

	
 



