import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class NoteList {


    public static List<Note> noteList = new ArrayList<Note>();


    public static List<Note> getNoteList() {
        return noteList;
    }

//    Знайти по заголовку нотатку
    public static UUID findInNoteListbyTitle(String title) {
       for (Note note : noteList)
       {
           if (note.getTitleNote().equals(title))
           {
               return note.getId();
           }
       }
        return null;
    }
//    знайти по айді
    public static Note findInNoteListbyID(UUID ID) {
        for (Note note : noteList)
        {
            if (note.getId().equals(ID))
            {
                return note;
            }
        }
        return null;
    }

//    Знайти по назві нотатку
    public static UUID findInNoteListbyName(String name) {
        for (Note note : noteList)
        {
            if (note.getTitleNote().equals(name))
            {
                return note.getId();
            }
        }
        return null;
    }
//    Розмір списку нотаток
    public int getSizeLIst(){
        return noteList.size();
    }

//    МЕТОД ПОШУКУ НОТАТКИ
    public static UUID howFindNote(String param, String how)
    {
        UUID id = null;
        if (how.equals("заголовок")) {
            id = NoteList.findInNoteListbyTitle(param);
        }
        if (how.equals("назва")){
            id = NoteList.findInNoteListbyName(param);
        }
         return id;
    }




    //   Зміна нотатки
    public static void changeNote (UUID ID, String param, String whatChange) {
                Note note;

                if (whatChange.equals("заголовок")) {
                 note = NoteList.findInNoteListbyID(ID);
                 Objects.requireNonNull(note).setTitleNote(param);
                }
                if (whatChange.equals("назву")){
                    note = NoteList.findInNoteListbyID(ID);
                    Objects.requireNonNull(note).setTitleNote(param);
                }
                if (whatChange.equals("текст")) {
                    note = NoteList.findInNoteListbyID(ID);
                    Objects.requireNonNull(note).setTextNote(param);
                }
    }

}
