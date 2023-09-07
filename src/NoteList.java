import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoteList {

    public static List<Note> noteList = new ArrayList<Note>();


    public static List<Note> getNoteList() {
        return noteList;
    }

//    Знайти по заголовку нотатку
    public static Note findInNoteListbyTitle(String title) {
       for (Note note : noteList)
       {
           if (note.getTitleNote().equals(title))
           {
               return note;
           }
       }
        return null;
    }
    //    Індекс нотатки в списку по заголовку
    public static int findIndexbyTitle(String title) {
        int index = noteList.indexOf(findInNoteListbyTitle(title));
        return index;
    }

//    Знайти по назві нотатку
    public static Note findInNoteListbyName(String name) {
        for (Note note : noteList)
        {
            if (note.getTitleNote().equals(name))
            {
                return note;
            }
        }
        return null;
    }
    //    Індекс нотатки в списку по назві
    public static int findIndexbyName(String name) {
        int index = noteList.indexOf(findInNoteListbyTitle(name));
        return index;
    }


//    Розмір списку нотаток
    public int getSizeLIst(){
        return noteList.size();
    }


    //   Зміна нотатки
    public static void changeNote (int index, Object noteNew) {
        noteList.set(index, (Note) noteNew);
    }

}
