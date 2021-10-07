package Service;

import Model.Graph;

public class ThirdExample {

    public static Graph thirdExampleGraph() {
        int matrix[][] = new int[5][5];

        matrix[0][1] = 1;
        matrix[1][0] = 1;

        matrix[0][2] = 1;
        matrix[2][0] = 1;
        
        matrix[1][3] = 1;
        matrix[3][1] = 1;
       
        matrix[2][3] = 1;
        matrix[3][2] = 1;

        matrix[1][4] = 1;
        matrix[4][1] = 1;
        
        Graph graph = new Graph(5, 5, matrix);
        return graph;
    }
}
