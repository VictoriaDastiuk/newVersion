import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Profile {
    String Name;
    String email;
    private UUID id;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        Name = name;
    }

    public Profile(String Name, String email){
        this.Name=Name;
        this.email=email;
    }
   }
