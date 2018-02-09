package dodgerakame.model;

import java.nio.file.Files;
import java.util.List;

public class USTParser {

    private UST ust;
    private List<String> content;

    public USTParser() { }

    public USTParser(UST ust){
        this.ust = new UST(ust.getUri());

        // Reading file
        try {
            this.content  = Files.readAllLines(this.ust.getFile().toPath());
        }
        catch (Exception e){
            // TODO Générer un fichier log d'erreur ou un mail à moi
            System.exit(-1);
        }
    }

    public UST getUst() {
        return ust;
    }

    public void setUst(UST ust) {
        this.ust = ust;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
