import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static String doOther;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

    // Cтворення користувача і перевірка емейлу раніше використовуваних
        WrittingForClient.newProfile();

        do {
            // Що хоче зробити створити нову, змінити стару, переглянути список нотаток, видалити?
            String answerWhatToDo = scanner.nextLine();

    // СТВОРИТИ НОТАТКУ
            if (answerWhatToDo.equals("створити нову")) {

            // введіть назву, текст, заголовок
                WrittingForClient.newNote();

            // Зберегти в файл?
                WrittingForClient.WriteSaveInFileNote();
                String wantToSaveNote = scanner.nextLine();

                if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))){
            // тут має бути метод збереження нотатки в файл


                }
            }




    //ЗМІНИТИ НОТАТКУ
            if (answerWhatToDo.equals("змінити нотатку")) {
                String answer = "так";
                String paramToFind;
                String howFind;
                int indexNote = 0;

                do {
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //  пошук нотатки по параметру
                    if (howFind == "заголовок"){
                        Note note = NoteList.findInNoteListbyTitle(paramToFind);
                        if (note == null){
                            //якшо не нашли нотатку
                            WrittingForClient.FindOneMoreTime();
                            answer = scanner.nextLine();
                        }
                        else {
                            // Викликаєм метод шо міняти в нотатці
                            WrittingForClient.whatChange(indexNote,note);
                            WrittingForClient.DoSmthMore();
                            doOther = scanner.nextLine();
                        }
                    }
                    if (howFind == "назва"){
                        Note note = NoteList.findInNoteListbyName(paramToFind);
                        if (note == null){
                            //якшо не нашли нотатку
                            WrittingForClient.FindOneMoreTime();
                            answer = scanner.nextLine();
                        }
                        else {
                            // Викликаєм метод шо міняти в нотатці
                            WrittingForClient.whatChange(indexNote,note);
                            WrittingForClient.DoSmthMore();
                            doOther = scanner.nextLine();
                        }
                    }
                    } while (answer.equals("так") || answer.equals("да"));
            }


    //ПЕРЕГЛЯНУТИ ВСІ НОТАТКИ

            if (answerWhatToDo.equals("переглянути всі нотатки"))
            {
                for (Note note : NoteList.getNoteList())
                {
                    System.out.println(note.getNameNote() + ": "+ note.getTitleNote() + " Текст нотатки:" + note.getTextNote());
                }
            }



    //ПЕРЕГЛЯНУТИ НОТАТКУ
            if (answerWhatToDo.equals("переглянути нотатку")) {
                String answer = "так";
                String paramToFind;
                String howFind;
                int indexNote = 0;

                do {
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //  пошук нотатки по параметру
                    if (howFind == "заголовок") {
                        Note note = NoteList.findInNoteListbyTitle(paramToFind);
                        if (note == null) {
                            //якшо не нашли нотатку
                            WrittingForClient.FindOneMoreTime();
                            answer = scanner.nextLine();
                        } else {
                            //показуємо текст нотатки
                            System.out.println(note.getNameNote() + ": " + note.getTitleNote() + " Текст нотатки:" + note.getTextNote());
                            doOther = scanner.nextLine();
                        }
                    }
                    if (howFind == "назва") {
                        Note note = NoteList.findInNoteListbyName(paramToFind);
                        if (note == null) {
                            //якшо не нашли нотатку
                            WrittingForClient.FindOneMoreTime();
                            answer = scanner.nextLine();
                        } else {
                            //показуємо текст нотатки
                            System.out.println(note.getNameNote() + ": " + note.getTitleNote() + " Текст нотатки:" + note.getTextNote());
                            doOther = scanner.nextLine();
                        }
                    }
                } while (answer.equals("так") || answer.equals("да"));
            }
    //ВИДАЛИТИ НОТАТКУ



    //ВИВАНТАЖИТИ НОТАТКИ







            // Бажаєте ще якусь дію здійснити?
            WrittingForClient.DoSmthMore();
            String doOther = scanner.nextLine();
            if((doOther.equals("ні")) || (doOther.equals("нет"))) {
                break;
            }

    }while (doOther.equals("так")||doOther.equals("да"));
}


}