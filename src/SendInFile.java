import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SendInFile extends ObjectOutputStream {

    public SendInFile(OutputStream out, Object Note) throws IOException {
        super(out);
        SendInFile noteSend = new SendInFile(Files.newOutputStream(Paths.get("MyNote.txt")), Note);
        noteSend.writeObject(Note);
        noteSend.close();
    }
}
