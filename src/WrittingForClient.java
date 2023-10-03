import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class WrittingForClient {
    static Scanner scanner;
    static int indexNote;
    static String param;
    static boolean answer;
    static String whatChange;


    public static void whatChange() {
         System.out.println("Що бажаєте змінити в нотатці: назву, заголовок чи текст?");

        }

        public static void addNew (String whatChange){
        if (whatChange.equals("назву")) {
            System.out.println("Введіть нову назву для нотатки");
        }

        if (whatChange.equals("заголовок")) {
            System.out.println("Введіть новий заголовок для нотатки");
        }

        if (whatChange.equals("текст")) {
            System.out.println("Введіть новий текст для нотатки");
        }
    }

    public static void newNote() {
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
    }

    public static void WriteSaveInFileNote() {
        System.out.println("Бажаєте зберегти цю нотатку в файл?");
    }

    public static void newProfile() {
        System.out.println("Введіть своє ім'я: ");
        String user = scanner.nextLine();
        System.out.println("Введіть свій емейл: ");
        String mail = scanner.nextLine();
        Profile person = new Profile(user, mail);

        ProfileList Email = new ProfileList();
        int sameEmail = Email.checkEmail(mail);
        if (sameEmail==1){
            System.out.println("Користувач з таким емейлом вже існує");
        }else {
            System.out.println("Ви успішно зареєстровані");
        }
    }
    public static void whatToDO() {
        System.out.println("Напишіть що бажаєте зробити:" +
                "1 - створити нову" +
                "2 - змінити стару " +
                "3 - переглянути список нотаток" +
                "4 - переглянути нотатку" +
                "5 - видалити нотатку" +
                "6 - вивантажити в файл?");
    }
    public static void howFind() {
        System.out.println("По чому будемо шукати нотатку щоб змінити: назва чи заголовок?");
        String howFind = scanner.nextLine();
    }
    public static void writeParam() {
        String howFind = scanner.nextLine();
        //пошук по заголовку
        if (howFind.equals("заголовок")) {
            System.out.println("Введіть заголовок нотатки: ");
        }

        //пошук по назві
        if (howFind.equals("назва")) {
            System.out.println("Введіть назву нотатки: ");
        }
    }

    public static void FindOneMoreTime() {
        System.out.println("Бажаєте здійснити повторно пошук?");
    }
    public static void dontFind() {
        System.out.println("Не найшли нотатку");
    }

    public static void DoSmthMore() {
        System.out.println("Бажаєте ще якусь дію здійснити з нотатками?");
    }

    public static void showNote(UUID resultOfFindNote) {
        Note note  = NoteList.findInNoteListbyID(resultOfFindNote);
        //показуємо текст нотатки
        assert note != null;
        if (note.getStatusNote().equals("Created") || note.getStatusNote().equals("Modified"))
        {
            System.out.println(note.getNameNote() + ": " + note.getTitleNote() + " Текст нотатки:" + note.getTextNote());
        }
        else {
            System.out.println("У вас немає такої нотатки або ж вона вже видалена");
        }
    }
}
