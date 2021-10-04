package Service;

import Model.Graph;

public class FirstExample {

    public static Graph firstExampleGraph() {
        int matrix[][] = new int[7][7];

        matrix[0][1] = 1;
        matrix[1][0] = 1;

        matrix[0][2] = 1;
        matrix[2][0] = 1;
        
        matrix[0][6] = 1;
        matrix[6][0] = 1;
        
        matrix[3][2] = 1;
        matrix[2][3] = 1;
        
        matrix[3][4] = 1;
        matrix[4][3] = 1;
        
        matrix[4][2] = 1;
        matrix[2][4] = 1;
        
        matrix[5][1] = 1;
        matrix[1][5] = 1;
        
        matrix[5][2] = 1;
        matrix[2][5] = 1;
        
        matrix[5][4] = 1;
        matrix[4][5] = 1;
        
        matrix[6][3] = 1;
        matrix[3][6] = 1;
        
        matrix[6][4] = 1;
        matrix[4][6] = 1;
        
        Graph graph = new Graph(7, 10, matrix);
        return graph;
    }
}
