package Service;

import javax.swing.JOptionPane;

import Model.Graph;

public class Menu {

    public static void menu() {
        Graph graph = null;
        int option;
        String select;

        do {
            select = JOptionPane.showInputDialog(null,
                    "Select an option:\n 1- Use the first example\n 2- Use the second example\n 3- Use the third example"+
                    "\n 4- Use the fourth example\n 5- Use the fifth example\n 6- Create a graph\n 0- Close program",
                    "Dominant set", JOptionPane.QUESTION_MESSAGE);
            option = Integer.parseInt(select);

            switch (option) {
                case 1:
                    graph = FirstExample.firstExampleGraph();
                    break;
                case 2:
                    graph = SecondExample.secondExampleGraph();
                    break;
                case 3:
                    graph = ThirdExample.thirdExampleGraph();
                    break;
                case 4:
                    graph = FourthExample.fourthExampleGraph();
                    break;
                case 5:
                    graph = FifthExample.fifthExampleGraph();
                    break;
                case 6:
                    graph = CreateGraph.createGraph();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Closing program...", "Bye", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    option = -1;
                    break;
            }

        } while (option == -1);

        JOptionPane.showMessageDialog(null, DominantSet.getDominantSet(graph.getVertex(), graph), "Result", JOptionPane.INFORMATION_MESSAGE);

    }
}
