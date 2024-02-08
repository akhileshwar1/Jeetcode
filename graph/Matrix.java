import java.util.List;
import java.util.ArrayList;

class Matrix{

    List<String> vertices = new ArrayList<>();

    List<List<Integer>> matrix = new ArrayList<>();

    Matrix(List<String> vs){
        vertices = vs;
        int length = vs.size();
        for (int i = 0; i < length; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                rowList.add(0); // Initializing with some default value
            }
            matrix.add(rowList);
        }
    }

    public void addEdge(String from, String to){
        if(vertices.contains(from) && vertices.contains(to)){
            int row = vertices.indexOf(from);
            int column = vertices.indexOf(to);
            matrix.get(row).set(column, 1);
        }
    }

    public static void main(String args[]){
        List<String> vs = new ArrayList<>();
        vs.add("Akhil");
        vs.add("Tam");
        Matrix m = new Matrix(vs);
        m.addEdge("Akhil", "Tam");
        m.addEdge("Tam", "Akhil");
        System.out.println(m.matrix.get(0).get(1));
    }
}
