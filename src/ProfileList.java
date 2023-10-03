import java.util.ArrayList;
import java.util.List;

public class ProfileList {
    int sameEmail = 0;
    public static List<Profile> Profiles = new ArrayList<>();

    public static List<Profile> getProfileList() {
        return Profiles;
    }

    public int checkEmail(String email){
        for (Profile profile : Profiles) {
           String emailFind = profile.getEmail();
            if (emailFind.equals(email))
            {
               sameEmail = 1;
               break;
        }
    }
        return sameEmail;
    }
}
//    public int checkEmail (){
//        int i=0;
//        if(emails.size()>1){
//            while(i<emails.size()){
//                if(emails.get(i).equals(email)){
//                    emails.remove(i);
//                    sameEmail = 1;
//                    break;
//                }
//                i++;
//            }
//
//        }
//        return sameEmail;
//    }
