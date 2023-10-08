import java.io.*;

public class Files {
    File folder = new File("./Notes");
    public Files(String name, String title, String text, String UserID) throws IOException {
        try(FileWriter SendInFile = new FileWriter("note"+ userID +".txt")) {
            SendInFile.write(name);
            SendInFile.write(title);
            SendInFile.write(text);
            System.out.println("Нотатку записаноу файл!");
        }
        catch (IOException e){
            System.out.println("Сталась помилка при завантаженні у файл.");
        }

    }

    public String addEmailToProfilesFile(String email)
    {

        return email;
    }
    public String FindEmailInProfilesFile(String email)
    {

        return email;
    }
}
