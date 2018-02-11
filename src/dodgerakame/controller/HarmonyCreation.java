package dodgerakame.controller;

import dodgerakame.model.UST;
import dodgerakame.model.USTParser;

import java.util.ArrayList;
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
            case "NotesRange1":
                return ProcessWithRange1();
            case "NotesRange2":
                return ProcessWithRange2();
            default:
                return null;

        }
    }

    public List<String> ProcessWithRange1() {
        List<String> toWrite = new ArrayList<String>();
        List<Integer> notes = new ArrayList<Integer>();

        for (String line : parser.getContent()) {
            // Searching for the pitch
            if (line.contains("NoteNum=")) {
                String[] lineContent = line.split("=");
                int NoteNum = Integer.parseInt(lineContent[1]);
                notes.add(NoteNum);
            }
        }

        return toWrite;
    }

    public List<String> ProcessWithRange2() {
        return null;
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
