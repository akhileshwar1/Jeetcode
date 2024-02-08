import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Vertex{
    int value; 

    int dt = 0;

    int explored = 0;
    
    int discovered = 0;

    List<Vertex> edges = new ArrayList<>();

    public Vertex(int value){
        this.value = value;
    }
}

class Pairs{
    List<Vertex> adjList = new ArrayList<>();

    public void buildGraph(int n, int x, int y){
        // build the vertices first.
        for (int i = 0; i< n; i++){
            Vertex v = new Vertex(i+1);
            adjList.add(v);
        }

        //add the edges to the vertices.
        for(int i = 0; i<n; i++){
            if((i + 1) < n){
                Vertex v = adjList.get(i); //i+1th vertex.
                Vertex v1 = adjList.get(i+1); //i+2th vertex.
                v.edges.add(v1); //add edge from i+1th to i+2th.
                v1.edges.add(v); // vice versa. 
        }
        }

        //add the extra edge. 
        Vertex xv = adjList.get(x - 1);
        Vertex yv = adjList.get(y - 1);
        xv.edges.add(yv);
        yv.edges.add(xv);
    }

    public void reset(){
        for(Vertex v : adjList){
            v.dt = 0;
            v.discovered = 0; //resets the whole graph to a pre BFS state.
            v.explored = 0;
        }
    }


    public int[] BFS(int pos){
        int n = adjList.size();
        int[] counts = new int[n];
        Vertex s = adjList.get(pos);
        s.discovered = 1;
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()){ // at any time, the queue contains discovered but unexplored.
            Vertex current = queue.poll();
            for(Vertex v: current.edges){
                if(v.discovered == 0){ //only visit for undiscovered.
                    v.dt = current.dt + 1;
                    counts[v.dt - 1]++;  // since the result array is 1-indexed.
                    v.discovered = 1;
                    queue.offer(v);
                }
            }
            current.explored = 1;
        }
        return counts;
    }
    

    public static void main(String[] args){
        int n = 5;
        int y = 4;
        int x = 2;
        int[] finalCounts = new int[n];
        Pairs p = new Pairs();
        p.buildGraph(n, x, y);
        for(int i = 0; i<n; i++){
            //perform BFS from each vertex.
           int[] countss = p.BFS(i);
           for (int j = 0; j< countss.length; j++){
               finalCounts[j] += countss[j];
           }
           //reset to pre-BFS state.
           p.reset();
        }
        System.out.println("res is" + finalCounts[1]);
    }
}
