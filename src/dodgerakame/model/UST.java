package dodgerakame.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UST {

    private String Uri;
    private File File;


    // TODO Voir pour ajouter les metadata

    public UST(){ }

    public UST(String Uri){
        this.Uri = Uri;
        this.File = new File(Uri);

    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public java.io.File getFile() {
        return File;
    }

    public void setFile(java.io.File file) {
        File = file;
    }

}
