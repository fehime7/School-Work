//GraphTest i korumak için tutulmuﬂ kopta classt›r.

import java.io.*;
import java.util.*;

class Vertex {
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
    Hashtable<String,Vertex> vertices;
    LinkedList<Edge> edges;
    boolean directed;
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
        }catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
