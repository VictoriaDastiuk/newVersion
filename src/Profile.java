import java.util.ArrayList;
import java.util.List;

public class Profile {
    String Name;
    String email;
    List<String> emails = new ArrayList<>();
    int sameEmail = 0;

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
        emails.add(email);
    }
    public int checkEmail (){
        int i=0;
        if(emails.size()>1){
        while(i<emails.size()){
            if(emails.get(i).equals(email)){
                emails.remove(i);
                sameEmail = 1;
                break;
            }
            i++;
        }

        }
    return sameEmail;
    }}
