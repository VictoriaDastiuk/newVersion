public class ProfilesController {

    public boolean checkEmail(String email) {
        return ProfileList.getProfileList().stream().anyMatch(profile -> profile.getEmail().equals(email));
    }
    public static void changeProfile(int UserId, String Name, String email){

        for (Profile pr : ProfileList.getProfileList()){
            if (UserId== pr.getUserID())
            {
                pr.setName(Name);
                pr.setEmail(email);
                WrittingForClient.printProfileMade();
                break;
            }
        }
       WrittingForClient.printProfileDontMade();
    }


}
