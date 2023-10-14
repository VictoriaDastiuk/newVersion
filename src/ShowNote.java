public class ShowNote {
    public static void ShowNote (int userID){
        // по чому робим пошук нотатки?
        WrittingForClient.howFind();
        howFind = scanner.nextLine();

        WrittingForClient.writeParam();
        paramToFind = scanner.nextLine();

        //айдішнік нотатки виводить
        resultOfFindNote = NoteList.howFindNote(howFind, paramToFind);

        if (resultOfFindNote == null) {
            //якшо не нашли нотатку
            WrittingForClient.dontFind();
        } else {
            WrittingForClient.showNote(resultOfFindNote);
        }
    }
}
