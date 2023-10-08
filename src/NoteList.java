import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        //  визначення сьогоднішньої дати
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);

        note = NoteList.findInNoteListbyID(ID);
        Objects.requireNonNull(note).setModifyDate(formattedDate);
        Objects.requireNonNull(note).setStatusNote("Modified");

                if (whatChange.equals("заголовок")) {
                 Objects.requireNonNull(note).setTitleNote(param);
                }
                if (whatChange.equals("назву")){
                    Objects.requireNonNull(note).setTitleNote(param);
                }
                if (whatChange.equals("текст")) {
                    Objects.requireNonNull(note).setTextNote(param);
                }
    }
    public static void delNote (UUID ID) {
        Note note;
            note = NoteList.findInNoteListbyID(ID);
            Objects.requireNonNull(note).setStatusNote("Deleted");

    }

}
