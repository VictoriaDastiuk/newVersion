import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Note {
    String nameNote;
    String titleNote;
    String textNote;

    String addDate;
    String modifyDate;

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

    public Note(String nameNote, String titleNote, String textNote, String addDate, String modifyDate) {
        this.nameNote = nameNote;
        this.titleNote = titleNote;
        this.textNote = textNote;
        this.addDate = addDate;
        this.modifyDate = modifyDate;
        System.out.println("Нотатку успішно створено!");
    }


}