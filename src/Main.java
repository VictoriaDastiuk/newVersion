import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static String doOther;
    static String answer = "так";
    static String paramToFind;
    static String howFind;
    static UUID resultOfFindNote;
    static String whatChange;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

    // Cтворення користувача і перевірка емейлу раніше використовуваних
        WrittingForClient.newProfile();

        do {
            WrittingForClient.whatToDO();
            // Що хоче зробити створити нову, змінити стару, переглянути список нотаток, видалити?
            int answerWhatToDo = Integer.parseInt(scanner.nextLine());

            switch (answerWhatToDo) {



                // СТВОРИТИ НОТАТКУ
                case 1:
                       // введіть назву, текст, заголовок
                        WrittingForClient.newNote();

                        // Зберегти в файл?
                        WrittingForClient.WriteSaveInFileNote();
                        String wantToSaveNote = scanner.nextLine();

                        if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))){
                            // тут має бути метод збереження нотатки в файл
                        }



                //ЗМІНИТИ НОТАТКУ
                case 2:
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind,paramToFind);

                    if (resultOfFindNote.equals(null)){
                            //якшо не нашли нотатку
                            WrittingForClient.dontFind();
                        }
                        else {
                            // питаєм шо міняти в нотатці
                            WrittingForClient.whatChange();
                            whatChange = scanner.nextLine();

                            //введення нового значення
                            WrittingForClient.addNew(whatChange);
                            String param = scanner.nextLine();


                        //resultOfFindNote - ID Note
                        //param - нове значення параметру який міняєм
                        //whatChange - що треба змінити в нотатці
                        NoteList.changeNote(resultOfFindNote,param,whatChange);

                        System.out.println("Нотатка успішно змінена.");
                    }



                //ПЕРЕГЛЯНУТИ ВСІ НОТАТКИ
                case 3:
                        for (Note note : NoteList.getNoteList()) {
                            if (note.getStatusNote().equals("Created") || note.getStatusNote().equals("Modified"))
                            {
                                System.out.println(note.getNameNote() + ": " + note.getTitleNote() + " Текст нотатки:" + note.getTextNote());
                            }
                        }



                //ПЕРЕГЛЯНУТИ НОТАТКУ
                case 4:
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind,paramToFind);

                    if (resultOfFindNote == null){
                        //якшо не нашли нотатку
                        WrittingForClient.dontFind();
                    }
                    else {
                     WrittingForClient.showNote(resultOfFindNote);
                    }



                //ВИДАЛИТИ НОТАТКУ
                case 5:
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind,paramToFind);

                    if (resultOfFindNote == null){
                        //якшо не нашли нотатку
                        WrittingForClient.dontFind();
                    }
                    else {
                        WrittingForClient.showNote(resultOfFindNote);
                    }

                //ВИВАНТАЖИТИ НОТАТКИ
                case 6:

                    }

            // Бажаєте ще якусь дію здійснити?
            WrittingForClient.DoSmthMore();
            String doOther = scanner.nextLine();
            if((doOther.equals("ні")) || (doOther.equals("нет"))) {
                break;
            }

    }while (doOther.equals("так")||doOther.equals("да"));
}


}