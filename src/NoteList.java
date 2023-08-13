import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoteList {

    List<Note> noteList = new ArrayList<Note>();


    public List<Note> getNoteList() {
        return noteList;
    }

//    Знайти по заголовку нотатку
    public String findInNoteListbyTitel(String resultFind, String titleNote) {
        int find = 0;
        for (int i=0; i<noteList.size();i++){
            if (Objects.equals(titleNote, noteList.get(i).titleNote)){
                resultFind = "Текст нотатки"+ noteList.get(i).textNote;
                find=1;
                break;
            }
        }
        if(find ==0){
            resultFind = "У вас немає нотатки з таким заголовком";
        }
        return resultFind;
    }

//    Знайти по назві нотатку
    public String findInNoteListbyName(String paramToFind) {
        String resultFind;
        int find = 0;
        for (int i=0; i<noteList.size();i++){
            if (Objects.equals(paramToFind, noteList.get(i).nameNote)){
                System.out.println("Текст нотатки"+ noteList.get(i).textNote);
                paramToFind = Integer.toString(i);
                find=1;
                break;
            }
        }
        if(find ==0){
            paramToFind = "notfound";
            System.out.println("У вас немає нотатки з такою назвою");
        }
        return paramToFind;
    }

//    Розмір списку нотаток
    public String getSizeLIst(String size){
        if (noteList.isEmpty()){
            System.out.println("У вас немає нотаток!");
    }else {
            size = Integer.toString(noteList.size());
        }
    return size;
    }




}
