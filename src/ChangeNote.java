public class ChangeNote {

    public static void WantChangeNote(int userID) {

        // по чому робим пошук нотатки?
        WrittingForClient.howFind();
        String howFind = scanner.nextLine();

        WrittingForClient.writeParam();
        paramToFind = scanner.nextLine();

        //айдішнік нотатки виводить
        resultOfFindNote = NoteList.howFindNote(howFind, paramToFind);

        if (resultOfFindNote == null) {
            //якшо не нашли нотатку
            WrittingForClient.dontFind();
        } else {
            // питаєм шо міняти в нотатці
            WrittingForClient.whatChange();
            whatChange = scanner.nextLine();

            //введення нового значення
            WrittingForClient.addNew(whatChange);
            String param = scanner.nextLine();


            //resultOfFindNote - ID Note
            //param - нове значення параметру який міняєм
            //whatChange - що треба змінити в нотатці
            NoteList.changeNote(resultOfFindNote, param, whatChange);

            System.out.println("Нотатка успішно змінена.");
            break;
        }
    }

}
