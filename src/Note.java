import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Note {
    String nameNote;
    String titleNote;
    String textNote;

    Date addDate;
    Date modifyDate;

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

    public Note(String nameNote, String titleNote, String textNote, Date addDate, Date modifyDate) {
        this.nameNote = nameNote;
        this.titleNote = titleNote;
        this.textNote = textNote;
        this.addDate = addDate;
        this.modifyDate = addDate;
    }

    List<Note> noteList = new ArrayList<Note>();

    public List<Note> getNoteList() {
        return noteList;
    }
    public void findInNoteListbyTitel(String titleNote) {
        int find = 0;
     for (int i=0; i<noteList.size();i++){
         if (Objects.equals(titleNote, noteList.get(i).titleNote)){
             System.out.println("Текст нотатки"+ noteList.get(i).textNote);
             find=1;
             break;
         }
     }
     if(find ==0){
         System.out.println("У вас немає нотатки з таким заголовком");
     }
    }
}