import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static int dontOther = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

//        Cтворення користувача і перевірка емейлу раніше використовуваних
        System.out.println("Введіть своє ім'я: ");
        String user = scanner.nextLine();
        System.out.println("Введіть свій емейл: ");
        String mail = scanner.nextLine();
        Profile person = new Profile(user, mail);
        person.checkEmail();

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

            // Зберегти в файл?
                System.out.println("Бажаєте зберегти цю нотатку в файл?");
                String wantToSaveNote = scanner.nextLine();

                if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))){
            // тут має бути метод збереження нотатки в файл
                SendInFile NoteinFile = new SendInFile(namenote, title, bodynote);
                }

            // Бажаєте ще якусь дію здійснити?
                System.out.println("Бажаєте ще якусь дію здійснити?");
                String doOther = scanner.nextLine();
                if((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))) {
                    dontOther = 0;
                }else {
                    dontOther = 1;
                }

        }
    //ЗМІНИТИ НОТАТКУ
            if (answerWhatToDo.equals("змінити нотатку")){
                String resultFind;
                do {
                    System.out.println("По чому будемо шукати нотаткуб щоб змінити: дата створення, дата модифікація, назва, заголовок?");
                    String howFind = scanner.nextLine();
                    if (howFind.equals("назва")){
                        System.out.println("Введіть назву нотатки: ");
                        String name = scanner.nextLine();

                        NoteList noteList1 = new NoteList();
                        List<Note> noteList = noteList1.getNoteList();
                        resultFind = noteList1.findInNoteListbyName(name);

                        if (!resultFind.equals("notfound")) {
                            System.out.println("Що бажаєте змінити в нотатці: назву, заголовок чи текст?");
                            String whatChange = scanner.nextLine();

                            if (whatChange.equals("назву")){
                                System.out.println("Введіть нову назву для нотатки");
                                String newName = scanner.nextLine();


                            }
                        }

                }while ()


                }
            }
    }while (dontOther!=1);
}
}