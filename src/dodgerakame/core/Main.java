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
        File dest2 = new File("src/dodgerakame/test.ust");

        List<String> content2 = magic.ProcessHarmonyCreation("NotesRangeLower2");

        FileWriter fw2;
        try {
           ;
            fw2 = new FileWriter(dest2);

            for (String line : content2) {
                fw2.write(line);
                fw2.write(System.lineSeparator());
            }

            fw2.close();

        } catch (Exception e) {
            System.err.println(e);
            System.exit(-1);
        }

    }

}
