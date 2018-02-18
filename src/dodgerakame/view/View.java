package dodgerakame.view;

import javax.swing.*;

public class View {
    private JTextField pathToUSTSourceTextField;
    private JButton searchButton;
    private JButton searchButton1;
    private JTextField pathToUSTsToTextField;
    private JPanel MainPanel;
    private JPanel CheckboxPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new View().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
