package dodgerakame.core;

import dodgerakame.controller.HarmonyCreation;
import dodgerakame.model.UST;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UST UST = new UST("src/dodgerakame/main.ust");
        HarmonyCreation magic = new HarmonyCreation(UST);
        File dest1 = new File("src/dodgerakame/test.ust");
        File dest2 = new File("src/dodgerakame/test2.ust");

        List<String> content1 = magic.ProcessHarmonyCreation("NotesRangeLower1");
        List<String> content2 = magic.ProcessHarmonyCreation("NotesRangeLower2");
        FileWriter fw1;
        FileWriter fw2;
        try {
            fw1 = new FileWriter(dest1);
            fw2 = new FileWriter(dest2);

            for (String line : content1) {
                fw1.write(line);
                fw1.write(System.lineSeparator());
            }

            for (String line : content2) {
                fw2.write(line);
                fw2.write(System.lineSeparator());
            }

            fw1.close();
            fw2.close();

        } catch (Exception e) {
            System.err.println(e);

        }

    }

}
