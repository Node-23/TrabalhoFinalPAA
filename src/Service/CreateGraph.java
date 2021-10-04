package Service;

import javax.swing.JOptionPane;

import Model.Graph;

public class CreateGraph {
    public static Graph createGraph() {

        String userSetVertex = JOptionPane.showInputDialog(null, "Insert the vertex number", "Dominant set",
                JOptionPane.INFORMATION_MESSAGE);
        int vertex = Integer.parseInt(userSetVertex); // Get vertex value

        String userSetEdge = JOptionPane.showInputDialog(null, "Insert the edge number", "Dominant set",
                JOptionPane.INFORMATION_MESSAGE);
        int edge = Integer.parseInt(userSetEdge); // Get Edge value

        int matrix[][] = new int[vertex][vertex];

        for (int i = 0; i < edge; i++) {
            int[] columnAndRow = new int[2];
            for (int j = 0; j < 2; j++) {
                String connection = JOptionPane.showInputDialog(null,
                        "Insert the " + (j + 1) + "º vertex of connection", "Dominant set",
                        JOptionPane.INFORMATION_MESSAGE);
                columnAndRow[j] = Integer.parseInt(connection) - 1;
            }
            matrix[columnAndRow[0]][columnAndRow[1]] = 1;
            matrix[columnAndRow[1]][columnAndRow[0]] = 1;
        } // Get Matrix values

        Graph graph = new Graph(vertex, edge, matrix); // Set the graph
        return graph;
    }
}
