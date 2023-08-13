import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean dontOther = true;

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
            String doOther;

// Що хоче зробити створити нову, змінити стару, переглянути список нотаток, видалити?
            System.out.println("Напишіть що бажаєте зробити: створити нову, змінити стару, переглянути список нотаток, видалити нотатку, вивантажити в файл?");
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
                doOther = scanner.nextLine();
                if((!doOther.equals("так")) || (!doOther.equals("да"))) {
                    dontOther = false;
                }

        }
    }while (!dontOther);
}
}