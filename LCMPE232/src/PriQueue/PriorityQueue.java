package PriQueue;

class Vertex {
    public int item;
    
    public Vertex next;
    
    public Vertex(int val)
    {
        item = val;
    }
}

class PQSort{
	
    private Vertex first;
    public PQSort(){
    	first = null; 
    }
    
    public void insert(Vertex k)
    {
    	Vertex previous = null;
    	Vertex current = first;
        while(current != null && k.item > current.item)
        {
            previous = current;
            current = current.next;
        }
        if(previous==null)
            first = k;
        else
            previous.next = k;
            k.next = current;
    }
    public Vertex pop()
    {
    	Vertex temp = first;
        first = first.next;
        return temp;
    }
}

class PriorityQueue{
	
    public static void main(String[] args)
    {
        int size = 10;
        PQSort thePQSort = new PQSort();
        for(int j=0; j<size; j++)
        {
            int n = (int)(java.lang.Math.random()*99);
            Vertex newLink = new Vertex(n);
            thePQSort.insert(newLink);          
        }
        System.out.println("Inserted elements at random into the queue such that Priority queue contains highest element at the end");
        System.out.println("sorted List based on Priority Queue . removing minimum element from the front of the list and displaying: ");
     
        for(int j=0; j<size; j++)
            System.out.print(thePQSort.pop().item + " ");
            System.out.println("");
    }
}

