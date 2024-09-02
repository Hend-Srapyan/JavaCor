package homework.bookStorage;

public interface LibraryCommands {

    String EXIT = "0";
    String ADD_BOOK = "1";
    String PRINT_ALL_BOOKS = "2";
    String SEARCH_BOOK_BY_NAME = "3";
    String SEARCH_BOOK_BY_AUTHOR_NAME = "4";
    String SEARCH_BOOK_BY_AUTHOR_SURNAME = "5";
    String SEARCH_BOOK_BY_PRICE = "6";
    String UPDATE_BOOK = "7";
    String DELETED_BOOK_BY_ID = "8";

     static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_BOOK + " for ADD_BOOK");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for PRINT_ALL_BOOKS");
        System.out.println("Please input " + SEARCH_BOOK_BY_NAME + " for SEARCH_BOOK_BY_BOOK_NAME");
        System.out.println("Please input " + SEARCH_BOOK_BY_AUTHOR_NAME + " for SEARCH_BOOK_BY_AUTHOR_NAME");
        System.out.println("Please input " + SEARCH_BOOK_BY_AUTHOR_SURNAME + " for SEARCH_BOOK_BY_AUTHOR_SURNAME");
        System.out.println("Please input " + SEARCH_BOOK_BY_PRICE + " for SEARCH_BOOK_BY_PRICE");
        System.out.println("Please input " + UPDATE_BOOK + " for UPDATE_BOOK");
        System.out.println("Please input " + DELETED_BOOK_BY_ID + " for DELETED_BOOK_BY_ID");
    }
}
