import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Profile person1 = new Profile("Victoria", "victoriadatsiuk@gail.com");
        person1.checkEmail();

        Profile person2 = new Profile("Vic", "victoriadatsiuk@gamil.com");
        person2.checkEmail();

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        Note note = new Note("Victoria","firstNote","It`my first note",date,date);
    }
}