package Dijkstra1;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;








class Vertex implements Comparable<Vertex>{




    public final String name;

    public Edge[] adjacencies;

    public double minDistance = Double.POSITIVE_INFINITY;

    public Vertex previous;
    
    public int val;


    public Vertex(int val, String argName) { 

        name = argName; 
        this.val=val;

    }




    public String toString() { 

        return name; 

    }




    public int compareTo(Vertex other){

        return Double.compare(minDistance, other.minDistance);

    }  

}




class Edge{

	

    public final Vertex from, to;

    public final double weight;

    

    public Edge(Vertex argStart, Vertex argTarget, double argWeight){ 
        from=argStart;
    	to = argTarget; 
    	weight = argWeight; 

	}

}




public class Dijkstra{

	

    public static void computePaths(Vertex source){

        source.minDistance = 0.;

        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();

      	vertexQueue.add(source);




	   while (!vertexQueue.isEmpty()) {

	       Vertex u = vertexQueue.poll();




            for (Edge e : u.adjacencies){

                Vertex v = e.to;

                double weight = e.weight;

                double distanceThroughU = u.minDistance + weight;

				if (distanceThroughU < v.minDistance) {

				    vertexQueue.remove(v);

				    v.minDistance = distanceThroughU ;

				    v.previous = u;

				    vertexQueue.add(v);

				}

            }

        }

    }




    public static List<Vertex> getShortestPathTo(Vertex target){

    	

        List<Vertex> path = new ArrayList<Vertex>();




        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)

            path.add(vertex);




        Collections.reverse(path);

        

        return path;

    }




    public static void main(String[] args){

    	

    	Vertex v0 = new Vertex(1,"A");

        Vertex v1 = new Vertex(2,"B");

        Vertex v2 = new Vertex(3,"C");

        Vertex v3 = new Vertex(4,"D");

        Vertex v4 = new Vertex(5,"E");




        v0.adjacencies = new Edge[]{ new Edge(v0,v1, 5), new Edge(v0, v2, 10), new Edge(v0,v3, 8)};

        v1.adjacencies = new Edge[]{ new Edge( v1,v0, 5), new Edge( v1,v2, 3), new Edge( v1,v4, 7)};

        v2.adjacencies = new Edge[]{ new Edge(v2,v0, 10), new Edge(v2,v1, 3)};

        v3.adjacencies = new Edge[]{ new Edge(v3,v0, 8), new Edge(v3,v4, 2)};

        v4.adjacencies = new Edge[]{ new Edge(v4,v1, 7), new Edge(v4,v3, 2)};

        

        Vertex[] vertices = { v0, v1, v2, v3, v4 };

        computePaths(v0);
        
        System.out.println(vertices.length +"\n"+ v0+" "+ v1+" "+v2+" "+v3+" "+v4 );
        System.out.println("Source vertice: "+v0);
        
        
        

        for (Vertex v : vertices){

		    System.out.println("Distance from "+v0+" to " + v + ": " + v.minDistance);

		    List<Vertex> path = getShortestPathTo(v);

		    System.out.println("Path: " + path);


        }

    }

}
