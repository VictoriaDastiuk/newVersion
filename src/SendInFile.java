import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SendInFile extends ObjectOutputStream {
        SendInFile noteSend = new SendInFile(Files.newOutputStream(Paths.get("MyNote.txt")), myNote);

    public SendInFile(OutputStream out) throws IOException {
        super(out);
    }

    protected SendInFile() throws IOException, SecurityException {
    }
        noteSend.writeObject(myNote);
        noteSend.close();
    }

