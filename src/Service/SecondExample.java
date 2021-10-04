package Service;

import Model.Graph;

public class SecondExample {

    public static Graph secondExampleGraph(){
        int matrix[][] = new int[9][9];

        matrix[0][2] = 1;
        matrix[2][0] = 1;

        matrix[0][7] = 1;
        matrix[7][0] = 1;
        
        matrix[0][8] = 1;
        matrix[8][0] = 1;
        
        matrix[1][2] = 1;
        matrix[2][1] = 1;
        
        matrix[1][3] = 1;
        matrix[3][1] = 1;
        
        matrix[2][4] = 1;
        matrix[4][2] = 1;
        
        matrix[2][6] = 1;
        matrix[6][2] = 1;
        
        matrix[3][4] = 1;
        matrix[4][3] = 1;
        
        matrix[3][5] = 1;
        matrix[5][3] = 1;
        
        matrix[3][8] = 1;
        matrix[8][3] = 1;
        
        matrix[4][6] = 1;
        matrix[6][4] = 1;
        
        matrix[4][8] = 1;
        matrix[8][4] = 1;
        
        matrix[5][6] = 1;
        matrix[6][5] = 1;
         
        matrix[5][7] = 1;
        matrix[7][5] = 1;
         
        matrix[5][8] = 1;
        matrix[8][5] = 1;

        Graph graph = new Graph(9, 15, matrix);   
        return graph;
    }
    
}
