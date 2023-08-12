import java.util.ArrayList;
import java.util.List;

public class Profile {
    String Name;
    String email;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        Name = name;
    }
    List<String> emails = new ArrayList<>();
    public Profile(String Name, String email){
        this.Name=Name;
        this.email=email;
        emails.add(email);
    }
    int sameEmail = 0;
    public void checkEmail (){
        int i=0;
        if(emails.size()>1){
        while(i<emails.size()){
            if(emails.get(i).equals(email)){
                emails.remove(i);
                System.out.println("Користувач з таким емейлом вже існує");
                sameEmail = 1;
                break;
            }
            i++;
        }
        } else if ((sameEmail==0)||(emails.size()==1)) {
            System.out.println("Вітаю! Ви успішно зареєструвались.");
        }
        }

    }
