import javax.swing.JOptionPane;

import Service.Menu;

public class App {
    public static void main(String[] args) {
        while (true) {
            Menu.menu();
            while (true) {
                String repeat = JOptionPane.showInputDialog(null, "Do it again?\n y- yes\n n-no", "Dominant set",
                        JOptionPane.QUESTION_MESSAGE);
                if (repeat.equals("y") || repeat.equals("Y")) {
                    break;
                }
                if (repeat.equals("n") || repeat.equals("N")) {
                    JOptionPane.showMessageDialog(null, "Closing program...", "Bye", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid option!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}