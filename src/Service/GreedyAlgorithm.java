package Service;

import java.util.ArrayList;

import Model.Graph;

public class GreedyAlgorithm {

    public static String greedyAlgorithm(int size, Graph graph) {
        long startTime = System.nanoTime();
        long endTime;
        ArrayList<Integer> dominantSetArray = new ArrayList<>();
        int StartVertexIndex = getStartVertexIndex(size, graph.getMatrix());
        dominantSetArray.add(StartVertexIndex);
        int[] line = getVertexLine(size, 0, graph.getMatrix());

        if (isDominant(line, dominantSetArray) == true) {
            return "The dominant set is: " + dominantSetArray.get(0);
        }

        do {
            dominantSetArray.add(getGreaterVertexIndex(size, graph.getMatrix(), dominantSetArray));
            line = dominantLineSum(size, dominantSetArray, graph.getMatrix());
        } while (isDominant(line, dominantSetArray) == false);

        endTime = System.nanoTime();
        Long elapsedTime = (endTime - startTime);
        float time = elapsedTime.floatValue();
        time = time / 1000000000;
        System.out.println("--------------------------------------");
        System.out.printf("Tempo: %.6f %n", time);
        return "The dominant set is: " + resultString(dominantSetArray);
    }

    // Return a string with index of the vertex of dominant set
    private static String resultString(ArrayList<Integer> dominantSetArray) {
        String result = "";

        for (int i = 0; i < dominantSetArray.size(); i++) {
            if (i == dominantSetArray.size() - 1) {
                result += (dominantSetArray.get(i) + 1);
                continue;
            }
            result += (dominantSetArray.get(i) + 1) + "- ";
        }
        return result;
    }

    // Return an array with matrix lines of the vertexes in the dominant set
    private static int[] dominantLineSum(int size, ArrayList<Integer> dominantSetArray, int[][] matrix) {
        int[] line = new int[size];
        for (int i = 0; i < size; i++) {
            line[i] = 0;
        }

        for (Integer integer : dominantSetArray) {
            for (int i = 0; i < size; i++) {
                line[i] += matrix[integer][i];
                if (line[i] > 1) {
                    line[i] = 1;
                }
            }
        }
        return line;
    }

    // Check if the vertex has a link with at least one vertex of the dominant set
    private static boolean isLinked(int vertexIndex, ArrayList<Integer> dominantSetArray, int[][] matrix) {
        for (Integer integer : dominantSetArray) {
            if (matrix[integer][vertexIndex] == 1) {
                return true;
            }
        }
        return false;
    }

    /*
     * Retorna o indice do primeiro vertice com maior quantidade de ligações que não
     * esteja no conjunto dominante e que esteja ligado a algum vértice do conjunto
     * dominante
     */

    /*
     * Return index of the first vertex with most link connections that: 1- Isn't in
     * the dominant set; 2- Has a link with at least one vertex in the dominant set;
     */
    private static int getGreaterVertexIndex(int size, int[][] matrix, ArrayList<Integer> dominantSetArray) {
        int vertexIndex = -1;
        int greater = 0;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            if (isThisVertexInDominantArray(i, dominantSetArray)) {
                continue;
            }
            for (int j = 0; j < size; j++) {
                sum += matrix[i][j];
            }
            if (sum > greater) {
                if (isLinked(i, dominantSetArray, matrix) == false) {
                    vertexIndex = i;
                    greater = sum;
                }
            }
        }
        return vertexIndex;
    }

    // Return an array with the matrix line of the vertex
    private static int[] getVertexLine(int size, int index, int[][] matrix) {
        int[] line = new int[size];
        for (int i = 0; i < line.length; i++) {
            line[i] = matrix[index][i];
        }

        return line;
    }

    // Check if all the colums of the vertex are equal to 1
    private static boolean isDominant(int[] vertexLine, ArrayList<Integer> dominantSetArray) {

        for (int i = 0; i < vertexLine.length; i++) {
            boolean isInDominant = false;
            for (int j = 0; j < dominantSetArray.size(); j++) {
                if (i == dominantSetArray.get(j)) {
                    isInDominant = true;
                }
            }
            if (vertexLine[i] == 0 && isInDominant == false) {
                return false;
            }
        }
        return true;
    }

    // Return index of the first vertex with most link connections
    private static int getStartVertexIndex(int size, int[][] matrix) {
        int vertexIndex = -1;
        int greater = 0;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += matrix[i][j];
            }
            if (sum > greater) {
                vertexIndex = i;
                greater = sum;
            }
        }
        return vertexIndex;
    }

    // Check if the vertex already belong to the dominant set
    private static boolean isThisVertexInDominantArray(int vertexIndex, ArrayList<Integer> dominantSetArray) {
        for (Integer integer : dominantSetArray) {
            if (integer == vertexIndex) {
                return true;
            }
        }
        return false;
    }

}
