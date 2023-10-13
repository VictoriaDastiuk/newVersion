import com.sun.org.apache.xpath.internal.operations.Mod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class ModelOfProject {
    static Scanner scanner;
    static String doOther;
    static String answer;
    static String paramToFind;
    static String howFind;
    static UUID resultOfFindNote;
    static String whatChange;
    static boolean  checkEmail;

    public static void MyNotes()
    {
        Auth ans = new Auth();
        answer = ans.startAuth();

        if (answer.equals("нет") || answer.equals("ні")) {
            checkEmail = ans.AuthForNewCustom();
        }
        else {
           checkEmail = ans.AuthForOldCustom();
        }

        if (!checkEmail) {

        }
        else {
        do {
            WrittingForClient.whatToDO();
            // Що хоче зробити створити нову, змінити стару, переглянути список нотаток, видалити?
            int answerWhatToDo = Integer.parseInt(scanner.nextLine());

            switch (answerWhatToDo) {

                // СТВОРИТИ НОТАТКУ
                case 1:
                    //  визначення сьогоднішньої дати
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(date);

                    // введіть назву, текст, заголовок
                    WrittingForClient.printNameNote();
                    String namenote = scanner.nextLine();
                    WrittingForClient.printTitleNote();
                    String title = scanner.nextLine();
                    WrittingForClient.printTextNote();
                    String bodynote = scanner.nextLine();

                    Note note = new Note(namenote, title, bodynote, formattedDate, formattedDate, userID);

                    // Зберегти в файл?
                    WrittingForClient.WriteSaveInFileNote();
                    String wantToSaveNote = scanner.nextLine();

                    if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))) {
                        // тут має бути метод збереження нотатки в файл
                    } else {
                        break;
                    }

                    //ЗМІНИТИ НОТАТКУ
                case 2:
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind, paramToFind);

                    if (resultOfFindNote == null) {
                        //якшо не нашли нотатку
                        WrittingForClient.dontFind();
                    } else {
                        // питаєм шо міняти в нотатці
                        WrittingForClient.whatChange();
                        whatChange = scanner.nextLine();

                        //введення нового значення
                        WrittingForClient.addNew(whatChange);
                        String param = scanner.nextLine();


                        //resultOfFindNote - ID Note
                        //param - нове значення параметру який міняєм
                        //whatChange - що треба змінити в нотатці
                        NoteList.changeNote(resultOfFindNote, param, whatChange);

                        System.out.println("Нотатка успішно змінена.");
                        break;
                    }


                    //ПЕРЕГЛЯНУТИ ВСІ НОТАТКИ
                case 3:
                    for (Note note1 : NoteList.getNoteList()) {
                        if (note1.getStatusNote().equals("Created") || note1.getStatusNote().equals("Modified")) {
                            System.out.println(note1.getNameNote() + ": " + note1.getTitleNote() + " Текст нотатки:" + note1.getTextNote());
                        }
                    }
                    break;

                //ПЕРЕГЛЯНУТИ НОТАТКУ
                case 4:
                    // по чому робим пошук нотатки?
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind, paramToFind);

                    if (resultOfFindNote == null) {
                        //якшо не нашли нотатку
                        WrittingForClient.dontFind();
                    } else {
                        WrittingForClient.showNote(resultOfFindNote);
                    }
                    break;

                //ВИДАЛИТИ НОТАТКУ
                case 5:
                    WrittingForClient.howFind();
                    howFind = scanner.nextLine();

                    WrittingForClient.writeParam();
                    paramToFind = scanner.nextLine();

                    //айдішнік нотатки виводить
                    resultOfFindNote = NoteList.howFindNote(howFind, paramToFind);

                    if (resultOfFindNote == null) {
                        //якшо не нашли нотатку
                        WrittingForClient.dontFind();
                    } else {
                        NoteList.delNote(resultOfFindNote);
                    }
                    break;
                //ВИВАНТАЖИТИ НОТАТКИ
                case 6:

                    break;

            }
// Бажаєте ще якусь дію здійснити?
            WrittingForClient.DoSmthMore();
            String doOther = scanner.nextLine();
            if ((doOther.equals("ні")) || (doOther.equals("нет"))) {
                System.out.println("Thanks for using app!");
                break;
            }
        } while (doOther.equals("так") || doOther.equals("да"));
    }
}}

