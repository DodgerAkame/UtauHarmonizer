package dodgerakame.core;

import dodgerakame.controller.HarmonyCreation;
import dodgerakame.model.UST;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UST UST = new UST("/home/dodger/Bureau/Luka [Main].ust");
        HarmonyCreation magic = new HarmonyCreation(UST);
        File dest = new File("/home/dodger/Bureau/test.ust");

        List<String> content = magic.ProcessHarmonyCreation("3");
        FileWriter fw;
        try {
            fw = new FileWriter(dest);

            for (String line : content) {
                fw.write(line);
                fw.write(System.lineSeparator());
            }

            fw.close();
        } catch (Exception e) {
            System.err.println(e);

        }


        System.out.print("Done");
    }

}
