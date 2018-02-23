package dodgerakame.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class View {
    private JTextField pathToUSTSourceTextField;
    private JButton searchButton;
    private JButton searchButton1;
    private JTextField pathToUSTsToTextField;
    private JPanel MainPanel;
    private JPanel CheckboxPanel;

    private JFileChooser fileChooser;

    private File input;

    public View() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    input = doSearchFile();
                    pathToUSTSourceTextField.setToolTipText(input.getAbsolutePath());
                }
                catch (Exception ex){
                    //TODO something
                }
            }
        });
    }

    private File doSearchFile() throws IOException {
        File dest = null;
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int chooserState = fileChooser.showOpenDialog(null);
        if (chooserState == JFileChooser.APPROVE_OPTION){
            dest = fileChooser.getSelectedFile();
        }

        return dest;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new View().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
