package graph;

import java.util.List;
import java.util.ArrayList;

class Vertex implements Comparable<Vertex> {
    String name;

    String color;

    Vertex parent;

    //distance used for BFS.
    int d; 

    // discovery time in DFS.
    int dt;

    // Exploration finish time in DFS.
    int ft;

    List<Vertex> edges = new ArrayList<>();

    Vertex(String str){
        this.name = str;
        this.d = 0;
        this.color = "white";
    }

    public void addEdge(Vertex v){
        edges.add(v);
    }

    public int compareTo(Vertex other){
        return other.ft - ft;
    }

    public static void main(String args[]){
        Vertex a = new Vertex("Akhil");
        Vertex t = new Vertex("Tam");
        a.addEdge(t);
        t.addEdge(a);
        System.out.println("a is " + a.edges.get(0).name);
        System.out.println("t is " + t.edges.get(0).name);
        //adj list is List<Vertices>.
    }
}

// if you have vertex, how will you go for the entire adjacency list?
// do you maintain that as a seperate class or just make the vertices 
// and chill? what is the use case? lets say if there is an edge betwee
// n A and B? for this I need to have all the vertices and just access
// two of them. or simply put I could have just used a List<List<V>>
// for the entire adjacency list, no need of a different class.
// any other way to do it? if you had a single class, with attrs such as
// vertices and edges, vertices are just names/anything, and edges are
// what? how do you map it to an edge? basically maintain an attr of 
// List<List<V>> initialized with vertices, and let veritces have a differ
// ent array.
