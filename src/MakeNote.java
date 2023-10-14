import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class MakeNote {
    static Scanner scanner = new Scanner(System.in);
public static void makeNote(int userID) {
    //  визначення сьогоднішньої дати
    String formattedDate = NotesController.getDate();

    // введіть назву, текст, заголовок
    WrittingForClient.printNameNote();
    String name = scanner.nextLine();
    WrittingForClient.printTitleNote();
    String title = scanner.nextLine();
    WrittingForClient.printTextNote();
    String text = scanner.nextLine();

    Note note = new Note(userID);
    UUID ID = note.getId();
    NotesController.changeAllNote(ID,title,name,text);

    // Зберегти в файл?
    WrittingForClient.WriteSaveInFileNote();
    String wantToSaveNote = scanner.nextLine();

    if ((wantToSaveNote.equals("так")) || (wantToSaveNote.equals("да"))) {
        // тут має бути метод збереження нотатки в файл
    }


    }
}
