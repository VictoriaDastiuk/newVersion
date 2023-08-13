import java.io.FileWriter;
import java.io.IOException;

public class SendInFile {
    public SendInFile(String name, String title, String text) throws IOException {
            try(FileWriter SendInFile = new FileWriter("myNote.txt")) {
                SendInFile.write(name);
                SendInFile.write(title);
                SendInFile.write(text);
                System.out.println("Нотатку записаноу файл!");
            }
            catch (IOException e){
                System.out.println("Сталась помилка при завантаженні у файл.");
            }

    }
}



