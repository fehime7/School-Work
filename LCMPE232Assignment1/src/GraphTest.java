

import java.io.*;
import java.util.*;

class Vertex implements Comparable{
    String name;
    LinkedList<Edge> outEdges;
    String color;
    Vertex pred;
    int discovery;
    int finishing;
    Vertex (String name) {
        this.name=name;
        outEdges=new LinkedList<Edge>();
    }
    void addOutEdge(Edge e) {
        outEdges.add(e);
    }
    
    public String toString(){
    	return this.name+" Color:"+this.color+" (d,f): "+discovery+
    			", "+finishing+" ";
    }
	@Override
	public int compareTo(Object o) {
		return this.finishing - ((Vertex)o).finishing;
	
	}
    
    
}

class Edge {
    Vertex from, to;
    double weight;
    Edge (Vertex from, Vertex to) {
        this.from=from;
        this.to=to;
        weight=1.0;
    }
    void setWeight(double w) {
        weight=w;
    }
}




class Graph {
	String ind="";
	int time;
    Hashtable<String,Vertex> vertices;
    LinkedList<Edge> edges;
    boolean directed;
    IList<Vertex> stack=new MyStack<Vertex>();
    
    
class TransposeGraph {
	

    
    
    public TransposeGraph(){
    	

    
    
    
    }
    
}


    public Graph() {
        vertices=new Hashtable<String,Vertex>();
        edges=new LinkedList<Edge>();
        directed=false;
    }
    void setDirected(boolean directed) {
        this.directed=directed;
    }
    boolean getDirected() {
        return directed;
    }
    void loadDot(String filename) throws Exception{
        //BufferedInputStream fr=new BufferedInputStream(new FileInputStream(filename));
        Scanner scanner=new Scanner(new File(filename));
        boolean inGraph=false;
        while (scanner.hasNext()) {
            String token=scanner.next().trim();
            if (token.equals("{")) {
                inGraph=true;
                scanner.useDelimiter(";");
            } else if (!inGraph && token.equals("graph"))
                setDirected(false);
            else if (!inGraph && token.equals("digraph"))
                setDirected(true);
            else if (inGraph && token.length()>0 && !(token.equals("}"))) {
                if (token.lastIndexOf(" ")<0) //a vertex
                    vertices.put(token,new Vertex(token));
                else {
                    String[] parts=token.split(" ");
                    String from=parts[0], to=parts[2];
                    if (vertices.get(from)==null || vertices.get(to)==null)
                        throw new Exception("from or to vertex can not be found for line: "+token);
                    Edge edge=new Edge(vertices.get(from),vertices.get(to));
                    if (parts.length>3) {
                        String[] tmp=parts[3].replace("[","").replace("]","").split("=");
                        if (tmp[0].equals("weight") || tmp[0].equals("w"))
                            edge.setWeight(Double.parseDouble(tmp[1]));
                    }
                    edges.add(edge);
                    vertices.get(from).addOutEdge(edge);
                    if (!directed) {
                        Edge reverseEdge=new Edge(vertices.get(to),vertices.get(from));
                        reverseEdge.setWeight(edge.weight);
                        vertices.get(to).addOutEdge(reverseEdge);
                    }
                }
            }
        }
}
   
public void DFS(){
	
	System.out.println("Depth First Searching");
	
	time=0;
	for(String s: this.vertices.keySet()){
		
		System.out.println("initializing "+ s);
		Vertex v=this.vertices.get(s);
		v.color="WHITE";
		v.pred=null;
	}
	
	
	System.out.println("liste:");
	for(String s: this.vertices.keySet()){
		
		Vertex v=this.vertices.get(s);
		
		if(v.color.equals("WHITE") && !hasIncome(v)){
			
			DFSVisit(v);
			
		}
	}
	
	System.out.println();
	
	for(String s: this.vertices.keySet()){
		
		Vertex v=this.vertices.get(s);
		
		System.out.println(v);
	}
	
	
}    
    
private boolean hasIncome(Vertex v) {

	for(Edge e : this.edges){
		if(e.to.equals(v)){
			return true;
		}
	}
	
	return false;

}
public void DFSVisit(Vertex u){
	ind+="\t";
	time++;
	u.discovery=time;
	u.color="GRAY";
	System.out.print("("+u.name +" ");
	for(Edge e : u.outEdges){
		Vertex v=e.to;
		
		if(v.color.equals("WHITE")){
			v.pred=u;
			
			DFSVisit(v);
			
		}
	}
	
	u.color="BLACK";
	stack.add(u);
	time++;
	u.finishing=time;
	System.out.print(" "+u.name+")");
	
}
    

public String toString() {
        String retval="VERTICES AND ADJACENCIES:\n", delim="--";
        if (directed)
            delim="->";
        for(Vertex v: vertices.values()) {
            retval+=v.name+"\n";
            for (Edge e:v.outEdges)
                retval+=String.format("  -> %s weight=%f\n",e.to.name,e.weight);
        }    
        retval+="ORIGINAL EDGES:\n";
        for (Edge e:edges)
            retval+=String.format("%s %s %s weight=%f\n",e.from.name,delim,e.to.name,e.weight);
        return retval;
    }
}



 
public class GraphTest {
    public static void main(String[] args) {
        if (args.length<1) {
            System.out.println("Usage:\n Graphs <dotfile>");
            System.exit(0);
        }
        
        
        String dotfile=args[0];
        Graph graph=new Graph();
        
        
        
        try {
            graph.loadDot(dotfile);
            System.out.println(graph);
            
            graph.DFS();
            
            System.out.println(" listing... "+graph.stack.printing());
            
            /*
            Collection<Vertex> c= graph.vertices.values();
            
            LinkedList<Vertex> l=new LinkedList<Vertex>();
            for(Vertex v : c)
            	l.add(v);
            
            
            Collections.sort(l);
            Collections.reverse(l);
            System.out.println(l);
            */
            
        }catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}