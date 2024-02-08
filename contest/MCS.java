import java.util.List;
import java.util.ArrayList;

// Minimum cost to convert the string. 
class Edge{
    Vertex to;

    Vertex from;
    
    int weight;

    public Edge(Vertex x, Vertex y, int weight){
        this.to = y;
        this.from = x;
        this.weight = weight;
    }
}

class Vertex{
    char name;
    
    int value = 0;

    int dt = 0;

    int explored = 0;
    
    int discovered = 0;

    List<Edge> edges = new ArrayList<>();

    public Vertex(int value){
        this.value = value;
    }

    public Vertex(char c){
        this.name = c;
    }

    public void addEdge(Vertex to, int weight){
        Edge e = new Edge(this, to, weight);
        edges.add(e);
    }
}

class MCS{
    List<Vertex> vertices = new ArrayList<>();
   
    public Vertex inVertices(char c){
        for(Vertex v: vertices){
            if(v.name == c){
                return v;
            }
        }
        return new Vertex(-1);
    }

    public void buildGraph(char[] original, char[] changed, int[] cost){
        for(int i = 0; i< original.length; i++){
            char x = original[i];
            char y = changed[i];

            Vertex X = inVertices(x);
            Vertex Y = inVertices(y);
            // already present.
            if(X.value != 0){
                X = new Vertex(x);
                vertices.add(X);
            }
            if(Y.value == 0){
                X.addEdge(Y, cost[i]);
            }
            else{
                Y = new Vertex(y);
                vertices.add(Y);
                X.addEdge(Y, cost[i]);
            }
    }

    }

    public long minWeight(char x, char y, char start, int w){
        Vertex X = inVertices(x);
        Vertex Y = inVertices(y);
        long min = Integer.MAX_VALUE;
        for(Edge e: X.edges){
            if(e.to.name == y){
                min = Math.min(min, e.weight + w);
            }
            else if(e.to.name == start){ //detect cycles and skip.
                min = min;
            }
            else{
                min = Math.min(min, minWeight(e.to.name, y, start, w + e.weight));
            }
        }
       return min;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long min = 0;
        for(int i = 0; i< source.length(); i++){
            char x = source.charAt(i);
            char y = target.charAt(i);
            if(x != y){
                min = min + minWeight(x, y, x, 0);
            }
        }
        return min;
    }

    public static void main(String args[]){
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed  = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};
        MCS obj = new MCS();
        obj.buildGraph(original, changed, cost);
        System.out.println("graph is" +  obj.minimumCost(source, target, original, changed, cost));
    }
}
