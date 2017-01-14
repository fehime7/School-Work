package CWTwo;



import java.util.LinkedList;
import java.util.Vector;


public class ClassWorkTwo {
	
	
	protected LinkedList<Vertex> nodes = new LinkedList<Vertex>();
    protected LinkedList<Edge> edges = new LinkedList<Edge>();
    protected boolean directed = false;
    protected boolean sortedNeighbors = false;
    
    
    public double[][] getAdjacencyMatrix() {
        double[][] adjMatrix = new double[nodes.size()][nodes.size()];
         
        
        for(int i = 0; i < nodes.size(); i++) {
            Vertex node = nodes.get(i);
            //System.out.println("Current node: " + node);
             
            for(int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                 
                if(edge.from == node) {
                    int indexOfNeighbor = nodes.indexOf(edge.to);
                     
                    adjMatrix[i][indexOfNeighbor] = edge.weight;
                }
                
            }    
        }
         
        return adjMatrix;
    }
    
    public void printAdjacencyMatrix(){
    	double [][] matrix2= getAdjacencyMatrix();
    	for(int i=0; i<matrix2.length;i++){
    		for(int j=0; j<matrix2.length; j++){
    			
    			System.out.print(matrix2[i][j]+" ");
    		}
    		System.out.print("\n");
    	}
    }
    
   /* public boolean hasEdge(Vertex v){
    	boolean result=false;
    	for(int i=0; i<nodes.size();i++){
    		for(int j=0; j<edges.size(); j++){
    			if(nodes.get(i)==edges.get(j).from )
    				
    				result= true;	
    		}
    	}
		return result;	
    }
    */
    
    public static void main(String[] args) {
    	ClassWorkTwo c=new ClassWorkTwo();
    	Vertex n0=new Vertex<String>("n0");
    	Vertex n1=new Vertex<String>("n1");
    	Vertex n2=new Vertex<String>("n1");
    	Edge edge0=new Edge(n0, n1, 2.0) ;
    	Edge edge1=new Edge(n1, n0, 2.0) ;
    	Edge edge2=new Edge(n0, n0, 3.0) ;
    	Edge edge3=new Edge(n1, n1, 4.0) ;
    	c.nodes.add(n0);
    	c.nodes.add(n1);
    	c.nodes.add(n2);
    	
    	c.edges.add(edge0);
    	c.edges.add(edge1);
    	c.edges.add(edge2);
    	c.edges.add(edge3);
    	c.printAdjacencyMatrix();
    	
		   
    	
	}
}
