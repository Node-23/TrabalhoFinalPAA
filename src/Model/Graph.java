package Model;
public class Graph {
    private int vertex; //Os circulos
    private int edge; //As linhas
    private int[][] matrix;


    public Graph(int vertex, int edge, int[][] matrix) {
        this.vertex = vertex;
        this.edge = edge;
        this.matrix = matrix;
    }

    public int getVertex() {
        return this.vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getEdge() {
        return this.edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public String printMatrix(){
        String result ="";
        for (int i = 0; i < vertex; i++) {
            result += i+1 + "- ";
            for (int j = 0; j < vertex; j++) {
                result += matrix[i][j] + ", ";
            }
            result+= "\n";
        }
        return result;
    }

}
