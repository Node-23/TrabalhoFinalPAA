package Service;

import Model.Graph;

public class DominantSet {
    public static String getDominantSet(int size, Graph graph) { //Return a string with the dominant set
        int[] binaryArray = new int[size]; //Array with the sequency of vertex
        instatiateBinaryArray(binaryArray, size); 
        String binary = Integer.toString(sizeToBinary(size)); //Max combination quantity in binary
        int combinationQuantity = Integer.parseInt(binary, 2); //Converting binary to integer
        String formater = "%0" + size + "d";

        for (int i = 0; i < size; i++) { //Iterate all the matrix lines
            int[] line = new int[size];
            for (int j = 0; j < line.length; j++) {
                line[j] = graph.getMatrix()[i][j];
            }
            if (isSoloDominant(line,i)== true) { //Check if the dominant set has only one vertex
                return "The dominant set is: " + (i+1);
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < combinationQuantity; j++) { //Interate all the possible combinations of the dominant set
                int jInBinary = Integer.parseInt(Integer.toBinaryString(j)); //variable J converted in binary
                String jInBinaryFormated = String.format(formater, jInBinary); //jInBinary formated to have left zeros
                jInBinaryFormated = "1" + jInBinaryFormated; //We put 1 in front of the number, that way when we convert to integer the left zeros won't desappear
                jInBinary = Integer.parseInt(jInBinaryFormated); //Convert jInBinaryFormated to integer

                if (binaryModSum(jInBinary, size) == i) { //Check if the sum of 1's in jInBinary is equal to the number of vertexes in the combination
                    int[] lines = binaryToArray(jInBinary, size, i, binaryArray);//Get the vertexes that are in this combination
                    
                    if(areNeighbors(lines,graph.getMatrix()) == true){ //Check if the vertex are neighbors of each other
                        continue;
                    }

                    if (comparator(lines, size, graph.getMatrix()) == true) { //Sum the lines and check if the combination of this vertexes are filled with 1's
                        String result = "";
                        for (int k = 0; k < lines.length; k++) {
                            if(k == lines.length-1){
                                result += (lines[k] + 1);
                                continue;
                            }
                            result += (lines[k] + 1) + " - ";
                        }
                        return "The dominant set is: " + result;
                    }
                } else {
                    continue;
                }
            }
        }
        return "There is no dominant set!";
    }

    //Check if the vertexes in the array of possible solutions are connected
    public static boolean areNeighbors(int[] lines,int[][] matrix){
        for (int i = 0; i < lines.length-1; i++) {
            for (int j = i+1; j < lines.length; j++) {
                if(matrix[lines[i]][lines[j]] == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Sum the lines of the vertexes in matrix and return true if they are filled with 1's
    private static boolean comparator(int[] lines, int size, int[][] matrix) { 
        int[] result = new int[size];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < size; j++) { 
                if(lines[i] == j){ //When is a line of the vertex itself we put 1 on the array.
                    result[j] += 1;
                    continue;
                }
                result[j] += matrix[lines[i]][j];
                if (result[j] > 1) {
                    result[j] = 1;
                }
            }
        }
        return isDominant(result);
    }

    private static boolean isDominant(int[] result) { //Check if all the colums of the vertex are equal to 1
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSoloDominant(int[] result, int actualLine) { //Check if all the lines of a vertex in the matrix are 1
        for (int i = 0; i < result.length; i++) {
            if(i == actualLine){
                continue;
            }
            if (result[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] binaryToArray(int jInBinary, int size, int linesSize, int[] binaryArray) {//create an array filled with the number of the vertexes in the combination
        int binary = jInBinary;
        int[] lines = new int[linesSize];
        int linesCounter = 0;
        for (int i = 1; i <= size; i++) {
            if (binary % 10 == 1) {
                lines[linesCounter] = binaryArray[i - 1];
                linesCounter++;
            }
            binary = binary / 10;
        }
        return lines;
    }

    public static int binaryModSum(int jInBinary, int size) { //Sum all the 1's in the binary number
        int binary = jInBinary;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += binary % 10;
            binary = binary / 10;
        }
        return sum;
    }

    public static int sizeToBinary(int size) { //Get the size of the graph and make a binary number as long as the size. Ex: size- 3 => 111 => quantity - 7
        int quantity = 0;

        for (int i = 0; i < size; i++) {
            quantity += 1 * Math.pow(10, i);
        }
        return quantity;
    }

    public static void instatiateBinaryArray(int[] binaryArray, int size) { //Put the sequency of vertex in the binaryArray
        for (int i = 0; i < size; i++) {
            binaryArray[i] = i;
        }
    }

}
