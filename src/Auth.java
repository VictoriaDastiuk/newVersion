import java.util.Scanner;

public class Auth {
    static String answer;
    static Scanner scanner = new Scanner(System.in);
    static boolean checkEmail;

    public String startAuth(){
        WrittingForClient.printYouHaveAccount();
        answer = scanner.nextLine();
        return answer;
    }

    public boolean AuthForNewCustom(){
        //перевірка емейлу раніше використовуваних
        WrittingForClient.printName();
        String user = scanner.nextLine();
        WrittingForClient.printMAil();
        String mail = scanner.nextLine();

        ProfilesController resultMail = new ProfilesController();
        boolean checkEmail = resultMail.checkEmail(mail);
        if (!checkEmail) {
            System.out.println("Емейл такий існує");

        } else {
            // Cтворення користувача
            ProfilesController Id = new ProfilesController();
            int userId = Id.createProfile();
            ProfilesController.changeProfile(userId, user, mail);
        }
        return checkEmail;
    }

    public boolean AuthForOldCustom (){
        WrittingForClient.printMAil();
        String mail = scanner.nextLine();

        ProfilesController resultMail = new ProfilesController();
        boolean checkEmail = resultMail.checkEmail(mail);
        if (!checkEmail) {
            System.out.println("Емейл такий не зареєстрований");
        }
        return resultMail.checkEmail(mail);
    }

    public static void rePrintEmail(String answer){
        if (answer.equals("нет") || answer.equals("ні")) {
            checkEmail = resultMail.checkEmail(mail);
            checkEmail = ans.AuthForOldCustom();
        }
        else {
            checkEmail = ans.AuthForOldCustom();
        }
    }


}
