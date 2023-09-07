import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static String doOther;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

//        Cтворення користувача і перевірка емейлу раніше використовуваних
        System.out.println("Введіть своє ім'я: ");
        String user = scanner.nextLine();
        System.out.println("Введіть свій емейл: ");
        String mail = scanner.nextLine();
        Profile person = new Profile(user, mail);
        int sameEmail = person.checkEmail();
        if (sameEmail==1){
            System.out.println("Користувач з таким емейлом вже існує");
        }else {
            System.out.println("Ви успішно зареєстровані");
        }



        do {


// Що хоче зробити створити нову, змінити стару, переглянути список нотаток, видалити?
            System.out.println("Напишіть що бажаєте зробити: створити нову, змінити стару, переглянути список нотаток, переглянути нотатку, видалити нотатку, вивантажити в файл?");
            String answerWhatToDo = scanner.nextLine();





    // Cтворити нотатку
            if (answerWhatToDo.equals("створити нову")) {

            //  визначення сьогоднішньої дати
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = dateFormat.format(date);

                System.out.println("Ввведіть назву для нотатки: ");
                String namenote = scanner.nextLine();
                System.out.println("Ввведіть заголовок для нотатки: ");
                String title = scanner.nextLine();
                System.out.println("Ввведіть,текст нотатки: ");
                String bodynote = scanner.nextLine();

                Note note = new Note(namenote, title, bodynote, formattedDate, formattedDate);
                System.out.println("Нотатку успішно створено!");

            // Зберегти в файл?
                System.out.println("Бажаєте зберегти цю нотатку в файл?");
                String wantToSaveNote = scanner.nextLine();

                if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))){
            // тут має бути метод збереження нотатки в файл
                SendInFile NoteinFile = new SendInFile(namenote, title, bodynote);
                }
            }





    //ЗМІНИТИ НОТАТКУ
            if (answerWhatToDo.equals("змінити нотатку")) {

                String answer = "так";

                do {
                    System.out.println("По чому будемо шукати нотатку щоб змінити: назва чи заголовок?");
                    String howFind = scanner.nextLine();

                    //пошук по заголовку
                    if (howFind.equals("заголовок")) {
                        System.out.println("Введіть заголовок нотатки: ");
                        String title = scanner.nextLine();

                        //  пошук нотатки по заголовку та індексу цієї нотатки
                        Note note = NoteList.findInNoteListbyTitle(title);
                        int indexNote = NoteList.findIndexbyTitle(title);

                        if (note != null) {
                            System.out.println("Що бажаєте змінити в нотатці: назву, заголовок чи текст?");
                            String whatChange = scanner.nextLine();

                            if (whatChange.equals("назву")) {
                                System.out.println("Введіть нову назву для нотатки");
                                String newName = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setNameNote(newName);
                                NoteList.changeNote(indexNote, note);
                            }

                            if (whatChange.equals("заголовок")) {
                                System.out.println("Введіть новий заголовок для нотатки");
                                String newTitle = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setTitleNote(newTitle);
                                NoteList.changeNote(indexNote, note);
                            }

                            if (whatChange.equals("текст")) {
                                System.out.println("Введіть новий текст для нотатки");
                                String newText = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setTextNote(newText);
                                NoteList.changeNote(indexNote, note);
                            }
                        } else {
                            System.out.println("У вас немає нотатки з такою назвою");
                        }

                        System.out.println("Бажаєте здійснити повторно пошук?");
                        answer = scanner.nextLine();

                    }

                    //пошук по назві
                    if (howFind.equals("назва")) {
                        System.out.println("Введіть назву нотатки: ");
                        String name = scanner.nextLine();


                        //  пошук нотатки по назві та індексу цієї нотатки
                        Note note = NoteList.findInNoteListbyName(name);
                        int indexNote = NoteList.findIndexbyName(name);

                        if (note != null) {
                            System.out.println("Що бажаєте змінити в нотатці: назву, заголовок чи текст?");
                            String whatChange = scanner.nextLine();

                            if (whatChange.equals("назву")) {
                                System.out.println("Введіть нову назву для нотатки");
                                String newName = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setNameNote(newName);
                                NoteList.changeNote(indexNote, note);
                            }

                            if (whatChange.equals("заголовок")) {
                                System.out.println("Введіть новий заголовок для нотатки");
                                String newTitle = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setTitleNote(newTitle);
                                NoteList.changeNote(indexNote, note);
                            }

                            if (whatChange.equals("текст")) {
                                System.out.println("Введіть новий текст для нотатки");
                                String newText = scanner.nextLine();

                                //заміна однієї нотатки на іншу
                                note.setTextNote(newText);
                                NoteList.changeNote(indexNote, note);
                            }

                            System.out.println("Бажаєте здійснити повторно пошук?");
                            answer = scanner.nextLine();
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
            }

    //ВИДАЛИТИ НОТАТКУ



    //ВИВАНТАЖИТИ НОТАТКИ







            // Бажаєте ще якусь дію здійснити?
            System.out.println("Бажаєте ще якусь дію здійснити з нотатками?");
            String doOther = scanner.nextLine();
            if((doOther.equals("ні")) || (doOther.equals("нет"))) {
                break;
            }

    }while (doOther.equals("так")||doOther.equals("да"));
}
}