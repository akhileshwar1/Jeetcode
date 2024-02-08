package graph;

import graph.Vertex;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;


class AdjList{
    List<Vertex> vertices = new ArrayList<>();

    // global variable to track the times when a vertex was discovered and finished
    // in DFS.
    int time = 0;

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public Vertex getVertexbyName(String name){
        for(Vertex v: vertices){
            if(v.name.equals(name)){
                return v;
            }
        }
        return new Vertex("nil");
    }

    // Need to initialize all the vertices in the graph that are reachable from s
    // with shortest path distance.
    // the fundamental theorem: shortest(s,v) = shortest(s, u) + 1; as (u,v) is an edge.
    // and u is reachable from s.
    // OR in more simple terms: edge is the shortest path between u and v.
    // Everything else can be derived from the above statement.
    public void BFS(Vertex s){
        Queue<Vertex> q = new LinkedList<>();
        q.offer(s);
        s.d = 0;
        while (!q.isEmpty()){
            Vertex current = q.poll();
            for (Vertex v: current.edges){
                if(v.color.equals("white")){
                // gray indicates that v is reachable from s.
                v.color = "gray";
                v.d = current.d + 1;
                // enqueue v as the vertex that was discovered.
                q.offer(v);  
                }
            }
            // black indicates that the all the paths emerging from the vertex 
            // were included for processing.
            current.color = "black"; 
        }
    }
    // NOTE: breadth first here refers to the fact that the queue at any point in 
    // time will have the vertices with shortest path first i.e edges are enqueued
    // before their children.
    

    public void DfsVisit(Vertex s){
        for(Vertex v: s.edges){
            if(v.color.equals("white")){
                time++;
                v.dt = time;
                v.color = "gray";
                v.parent = s;
                DfsVisit(v);
            }
        }
        // black means that all the edges and the paths emanating out from them
        // have been explored, unlike BFS where it just meant the immediate edges
        // are explored.
        time++;
        s.ft = time;
        s.color = "black";
        }

    public void DFS(){
        // dfs graph is a forest of trees, this loop iterates over one disjoint 
        // tree after the other.
        for(Vertex v : vertices){
            if(v.color.equals("white")){
                time++;
                v.dt = time;
                v.color = "gray";
                DfsVisit(v);
            }
        }
    }

    // Directed acyclic graph models a situation where the dependent things/children can be done after the parent, 
    // just do a simple DFS whilst printing/storing the order of vertices.
    public List<Vertex> topoSort(){
        //modified DFS.
        List<Vertex> sort = new ArrayList<>();
        for(Vertex v: vertices){
            if(v.color.equals("white")){
                time++;
                v.dt = time;
                v.color = "gray";
                DfsVisit(v);
                sort.add(0, v);
            }
        }
        return sort;
    }

    public AdjList transpose(){
        AdjList result = new AdjList();
        // add all the vertices to G transpose.
        for (Vertex v: vertices){
            Vertex vt = new Vertex(v.name);
            vt.ft = v.ft;
            vt.color = "white";
            result.addVertex(vt);
        }

        for(Vertex v : vertices){
            Vertex vt = result.getVertexbyName(v.name); 
            for(Vertex e : v.edges){
                Vertex et = result.getVertexbyName(e.name);
                if(!et.name.equals("nil")){
                    et.addEdge(vt);
                }
            }
        }
      return result;
    }

    public void  DfsVisitSCC(Vertex s, List<Vertex> lst){
        lst.add(s);
        for(Vertex v: s.edges){
            if(v.color.equals("white")){
                time++;
                v.dt = time;
                v.color = "gray";
                v.parent = s;
                DfsVisitSCC(v, lst);
            }
        }
        // black means that all the edges and the paths emanating out from them
        // have been explored, unlike BFS where it just meant the immediate edges
        // are explored.
        time++;
        s.ft = time;
        s.color = "black";
        }


    public List<List<Vertex>> SCC(){
        DFS(); // perform dfs on the graph so that strongly connected components are related by finishing times
               // in decreasing order.
        List<List<Vertex>> result = new ArrayList<>();
        AdjList tp = transpose();
        Collections.sort(tp.vertices);
        for(Vertex v: tp.vertices){
            List<Vertex> lst = new ArrayList<>();
            if(v.color.equals("white")){
                v.color = "gray";
                DfsVisitSCC(v, lst);
            }
            result.add(lst);
    }
    return result;
    }

    public static void main(String args[]){
        Vertex A = new Vertex("Akhil");
        Vertex T = new Vertex("Tam");
        A.addEdge(T);
        Vertex M = new Vertex("Rest");
        T.addEdge(M);
        AdjList lst = new AdjList();
        lst.addVertex(A);
        lst.addVertex(T);
        lst.addVertex(M);
        //lst.BFS(A);
        //System.out.println("distances are " + A.d + "" + T.d + "" + M.d);
       // lst.DFS();
        System.out.println("times are " + A.dt + "" + T.dt + "" + M.dt
                                            + M.ft + "" + T.ft + "" + A.ft
                                            + A.color);
        List<List<Vertex>> result = lst.SCC();
        System.out.println("scc's are " + result.get(0).get(0).name + result.get(1).get(0).name + result.get(2).get(0).name);
    }
}
