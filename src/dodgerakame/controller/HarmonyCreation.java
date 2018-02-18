package dodgerakame.controller;

import dodgerakame.model.UST;
import dodgerakame.model.USTParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HarmonyCreation {

    private UST ust;
    private USTParser parser;

    public HarmonyCreation() {
    }

    public HarmonyCreation(UST ust) {
        this.ust = ust;
        this.parser = new USTParser(this.ust);
    }

    public UST getUst() {
        return ust;
    }

    public void setUst(UST ust) {
        this.ust = ust;
    }

    public USTParser getParser() {
        return parser;
    }

    public void setParser(USTParser parser) {
        this.parser = parser;
    }

    /**
     * Return the file's content processed given the method asked for.
     *
     * @param method a string
     * @return List of string
     */
    public List<String> ProcessHarmonyCreation(String method) {
        switch (method) {
            case "3":
                return ProcessWithNumber(3);
            case "5":
                return ProcessWithNumber(5);
            case "-3":
                return ProcessWithNumber(-3);
            case "-5":
                return ProcessWithNumber(-5);
            case "NotesRangeLower2":
                return ProcessWithRangeLower2();
            default:
                return null;

        }
    }


    /**
     * This method will transform the UST to create a harmony file with the given range.
     * To do this, it will read every note of the file, and then rewrite it by using the first note of the range lower that the actual one
     * @return a list of strings representing the file's content
     */
    public List<String> ProcessWithRangeLower2() {
        List<String> toWrite = new ArrayList<String>();
        List<Integer> notes = new ArrayList<Integer>();

        for (String line : parser.getContent()) {
            // Searching for the pitch to do a list representing range
            if (line.contains("NoteNum=")) {
                String[] lineContent = line.split("=");
                int NoteNum = Integer.parseInt(lineContent[1]);
                if (!notes.contains(NoteNum))
                    notes.add(NoteNum);
            }
        }

        // Sorting the notes by ascending orders
        Collections.sort(notes);

       /* // Adding the higher pitch lower by an octave TODO sûr que ça marche ?
        notes.add(notes.get(0) - 12);
        notes.add(notes.get(1) - 12);*/

        // Creating the new file
        for (String line : parser.getContent()){
            if(line.contains("NoteNum=")){
                String[] lineContent = line.split("=");
                int actualNote = Integer.parseInt(lineContent[1]);
                int index = notes.indexOf(actualNote);
                try {
                    int newNote;
                    if (index + 2 < notes.size() )
                        newNote = notes.get(index + 2);
                    else if (index - 2 >= 0)
                        newNote = notes.get(index - 2);
                    else
                        newNote = notes.get(index - 1);

                    lineContent[1] = String.valueOf(newNote);
                    line = lineContent[0] + "=" + lineContent[1];
                }
                catch (IndexOutOfBoundsException e){
                    //TODO code pour gérer ça
                    System.err.println(e);
                    System.exit(-1);
                }
            }
            toWrite.add(line);
        }

        return toWrite;
    }

    /**
     * Returns the file's content and change all the notes' tone with the given amount
     *
     * @param number an int representing how much the notes should be upscaled or downscaled
     * @return a list of String with all the file's lines changed processed
     */
    public List<String> ProcessWithNumber(int number) {
        List<String> toWrite = new ArrayList<String>();

        for (String line : parser.getContent()) {
            // Searching for the pitch
            if (line.contains("NoteNum=")) {
                String[] lineContent = line.split("=");
                int NoteNum = Integer.parseInt(lineContent[1]);
                NoteNum += number;
                lineContent[1] = String.valueOf(NoteNum);
                line = lineContent[0] + "=" + lineContent[1];
            }
            toWrite.add(line);
        }

        return toWrite;
    }

}
