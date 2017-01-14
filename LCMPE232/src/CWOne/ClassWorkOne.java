package CWOne;


import java.util.LinkedList;



public class ClassWorkOne {
	
	private LinkedList<Vertex> verticies= new LinkedList<Vertex>();
	private LinkedList<Edge> edges=new LinkedList<Edge>();
	
	
    public void  getAdjacencyList(){
    	for(int i=0; i<verticies.size();i++){
    		Vertex<String> vertex= verticies.get(i);
    		
    		for(int j=0; j<edges.size(); j++){
    		    Edge edge=edges.get(j);
    			
    			if(vertex==edge.from ){
    				System.out.println(vertex.name+"-->"+ edge.to.name+"["+ edge.weight+"]");
    			}
    		}
    		
    	}
		
	}
	public static void main(String[] args) {
		ClassWorkOne c= new ClassWorkOne();
		Vertex v0=new Vertex("a");
		Vertex v1=new Vertex("b");
		Vertex v2=new Vertex("c");
		Vertex v3=new Vertex("d");
		Vertex v4=new Vertex("e");

		c.verticies.add(v0);
		c.verticies.add(v1);
		c.verticies.add(v2);
		c.verticies.add(v3);
		c.verticies.add(v4);
		
		
		Edge e0=new Edge(v0, v1, 2.0);
		Edge e1=new Edge(v0, v2, 3.0);
		Edge e2=new Edge(v1, v2, 3.0);
		Edge e3=new Edge(v1, v3, 4.0);
		Edge e4=new Edge(v0, v0, 3.0);
		
		c.edges.add(e0);
		c.edges.add(e1);
		c.edges.add(e2);
		c.edges.add(e3);
		c.edges.add(e4);
		
		c.getAdjacencyList();
	}
}

