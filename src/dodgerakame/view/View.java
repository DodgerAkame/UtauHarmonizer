package dodgerakame.view;

import dodgerakame.controller.HarmonyCreation;
import dodgerakame.model.UST;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class View {
    private JTextField pathToUSTSourceTextField;
    private JButton searchButton;
    private JButton searchButton1;
    private JTextField pathToUSTsToTextField;
    private JPanel MainPanel;
    private JPanel CheckboxPanel;
    private JButton GenerateBtn;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;

    private JFileChooser fileChooser;
    private ButtonGroup buttonGroup;

    private File input;

    public View() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    input = doSearchFile();
                    pathToUSTSourceTextField.setText(input.getAbsolutePath());
                    String[] directory = input.getAbsolutePath().split(File.separator);
                    StringBuffer output = new StringBuffer();

                    for (int i = 0; i < directory.length - 1; i++){
                     output.append(directory[i] + File.separator);
                    }

                    output.append(directory[directory.length -1].split(".ust")[0] + " - Harmony.ust");
                    pathToUSTsToTextField.setText(output.toString());

                }
                catch (Exception ex){
                    //TODO something
                }
            }
        });

        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    input = doSearchSaveFile();
                    pathToUSTsToTextField.setText(input.getAbsolutePath());
                }
                catch (Exception e){

                }
            }
        });


        buttonGroup = new ButtonGroup();

        radioButton1.setText("Range + 3");
        radioButton1.setActionCommand("3");

        radioButton2.setText("Range + 5");
        radioButton2.setActionCommand("5");

        radioButton3.setText("Range - 3");
        radioButton3.setActionCommand("-3");

        radioButton4.setText("Range - 5");
        radioButton4.setActionCommand("-5");

        radioButton5.setText("Dynamic range");
        radioButton5.setActionCommand("Note");

        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);
        buttonGroup.add(radioButton5);


        GenerateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    processRequest();
                }
                catch (Exception e){
                    System.err.println(e);
                    System.exit(-1);
                }
            }
        });
        GenerateBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    processRequest();
                }
                catch (Exception e){
                    System.err.println(e);
                    System.exit(-1);
                }
            }
        });
    }

    private void processRequest() throws IOException{
        UST src = new UST(pathToUSTSourceTextField.getText());
        UST dest = new UST(pathToUSTsToTextField.getText());
        HarmonyCreation harmonyCreation = new HarmonyCreation(src);
        String method = buttonGroup.getSelection().getActionCommand();
        List<String> fileProcessedContent = harmonyCreation.ProcessHarmonyCreation(method);
        FileWriter fw;

        try {
            ;
            fw = new FileWriter(dest.getFile());

            for (String line : fileProcessedContent) {
                fw.write(line);
                fw.write(System.lineSeparator());
            }

            fw.close();

            JOptionPane.showMessageDialog(null, "The file has been successully created");

        } catch (Exception e) {
            System.err.println(e);
            System.exit(-1);
        }

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

    private File doSearchSaveFile() throws IOException{
        File dest = null;

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int chooserState = fileChooser.showSaveDialog(null);
        if (chooserState == JFileChooser.SAVE_DIALOG){
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
