package dodgerakame.controller;

import dodgerakame.model.UST;
import dodgerakame.model.USTParser;

import java.util.ArrayList;
import java.util.List;

public class HarmonyCreation {

    private UST ust;
    private USTParser parser;

    public HarmonyCreation(){ }

    public HarmonyCreation(UST ust){
        this.ust = ust;
        this.parser = new USTParser(this.ust);
    }

    public List<String> ProcessHarmonyCreation(String method){
        switch(method){
            case "3":
               return ProcessWithNumber(3);

            case "5":
                return ProcessWithNumber(5);

            case "NotesRange":
                return ProcessWithRange();

            default:
                return null;

        }
    }

    public List<String> ProcessWithRange() {
        return null;
    }

    public List<String> ProcessWithNumber(int number){
        List<String> toWrite = new ArrayList<String>();
        for (String line : parser.getContent()){
            if (line.contains("Lyric=")){

            }
        }
        return toWrite;
    }

}
