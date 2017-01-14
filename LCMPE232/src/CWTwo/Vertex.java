package CWTwo;

import java.util.LinkedList;

public class Vertex<F> {
	    String name;
	    LinkedList<Edge> outEdges;
	    Vertex (String name) {
	        this.name=name;
	        outEdges=new LinkedList<Edge>();
	    }
	    void addOutEdge(Edge e) {
	        outEdges.add(e);
	    }

}

class Edge {
    Vertex from, to;
    double weight;
    Edge (Vertex from, Vertex to , double weight) {
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
    public double getWeight() {
		return weight;
	}
}
