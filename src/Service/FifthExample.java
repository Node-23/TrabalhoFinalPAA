package Service;

import Model.Graph;

public class FifthExample {

    public static Graph fifthExampleGraph() {
        int matrix[][] = new int[8][8];

        matrix[0][5] = 1;
        matrix[5][0] = 1;

        matrix[5][4] = 1;
        matrix[4][5] = 1;

        matrix[5][1] = 1;
        matrix[1][5] = 1;
        
        matrix[1][7] = 1;
        matrix[7][1] = 1;

        matrix[7][2] = 1;
        matrix[2][7] = 1;

        matrix[2][3] = 1;
        matrix[3][2] = 1;

        matrix[2][6] = 1;
        matrix[6][2] = 1;

        Graph graph = new Graph(8, 7, matrix);
        return graph;
    }
}
