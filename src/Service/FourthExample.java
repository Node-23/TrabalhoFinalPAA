package Service;

import Model.Graph;

public class FourthExample {

    public static Graph fourthExampleGraph() {
        int matrix[][] = new int[6][6];

        matrix[0][2] = 1;
        matrix[2][0] = 1;

        matrix[0][3] = 1;
        matrix[3][0] = 1;

        matrix[2][3] = 1;
        matrix[3][2] = 1;
        
        matrix[0][4] = 1;
        matrix[4][0] = 1;
        
        matrix[4][5] = 1;
        matrix[5][4] = 1;

        matrix[4][1] = 1;
        matrix[1][4] = 1;

        matrix[1][5] = 1;
        matrix[5][1] = 1;
        
        Graph graph = new Graph(6, 7, matrix);
        return graph;
    }
}
