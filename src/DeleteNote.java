public class DeleteNote {

    public static void deleteNote(int userID){
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
            NoteList.delNote(resultOfFindNote);
        }
    }
}
