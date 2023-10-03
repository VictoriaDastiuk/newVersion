import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.*;

public class Note {
    String nameNote;
    String titleNote;
    String textNote;

    String addDate;
    String modifyDate;
    private String statusNote;
    private UUID id;

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }
    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public String getStatusNote() {
        return statusNote;
    }

    public void setStatusNote(String statusNote) {
        this.statusNote = statusNote;
    }

    public Note(String nameNote, String titleNote, String textNote, String addDate, String modifyDate) {
        this.nameNote = nameNote;
        this.titleNote = titleNote;
        this.textNote = textNote;
        this.addDate = addDate;
        this.modifyDate = modifyDate;
        this.statusNote = "Created";
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}