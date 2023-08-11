import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoteList {

    List<Note> noteList = new ArrayList<Note>();

    public List<Note> getNoteList() {
        return noteList;
    }
    public String findInNoteListbyTitel(String resultFind, String titleNote) {
        int find = 0;
        for (int i=0; i<noteList.size();i++){
            if (Objects.equals(titleNote, noteList.get(i).titleNote)){
                titleNote = "Текст нотатки"+ noteList.get(i).textNote;
                find=1;
                break;
            }
        }
        if(find ==0){
            titleNote = "У вас немає нотатки з таким заголовком";
        }
        return titleNote;
    }
}
