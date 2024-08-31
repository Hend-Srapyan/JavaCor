package homework.bookStorage;


import java.util.Scanner;

public class Library {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = "0";
    private static final String ADD_BOOK = "1";
    private static final String PRINT_ALL_BOOKS = "2";
    private static final String SEARCH_BOOK_BY_NAME = "3";
    private static final String SEARCH_BOOK_BY_Author_Name = "4";
    private static final String SEARCH_BOOK_BY_Author_Surname = "5";
    private static final String SEARCH_BOOK_BY_PRICE = "6";
    private static final String UPDATE_BOOK = "7";
    private static final String DELETED_BOOK_BY_ID = "8";


    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case SEARCH_BOOK_BY_NAME:
                    searchBookByName();
                    break;
                case SEARCH_BOOK_BY_Author_Name:
                    searchBookByAuthorName();
                    break;
                case SEARCH_BOOK_BY_Author_Surname:
                    searchBookByAuthorSurName();
                    break;
                case SEARCH_BOOK_BY_PRICE:
                    searchBookByPrice();
                    break;
                case UPDATE_BOOK:
                    updateBook();
                    break;
                case DELETED_BOOK_BY_ID:
                    deletedBookById();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }


    private static void addBook() {
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        System.out.println("Please input book bookName");
        String bookName = scanner.nextLine();
        System.out.println("Please input author's name");
        String authorName = scanner.nextLine();
        System.out.println("Please input book author's surname");
        String authorSurName = scanner.nextLine();
        System.out.println("Please input book price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input book quantity");
        double quantity = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input book numberOfPages");
        double numberOfPages = Double.parseDouble(scanner.nextLine());
        Book book = new Book(id, bookName, authorName, authorSurName, price, quantity, numberOfPages);
        Book bookById = bookStorage.getBookById(id);
        if (bookById == null) {
            bookStorage.add(book);
            System.out.println("Book added!");
        } else {
            System.out.println("Book with " + id + " already exists!");
        }

    }

    private static void searchBookByName() {
        bookStorage.print();
        System.out.println("Please input book keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByName(keyword);
    }

    private static void searchBookByAuthorName() {
        bookStorage.print();
        System.out.println("Please input author name keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByAuthorName(keyword);
    }

    private static void searchBookByAuthorSurName() {
        bookStorage.print();
        System.out.println("Please input author surname keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByAuthorSurName(keyword);
    }

    private static void searchBookByPrice() {
        bookStorage.print();
        System.out.println("Please input minimum price");
        int minPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input maximum price");
        int maxPrice = Integer.parseInt(scanner.nextLine());
        bookStorage.searchBookByPrice(minPrice, maxPrice);
    }

    private static void updateBook() {
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById != null) {
            System.out.println("Please input book's new bookName");
            String bookName = scanner.nextLine();
            System.out.println("Please input author's new name");
            String authorName = scanner.nextLine();
            System.out.println("Please input book author's surname");
            String authorSurName = scanner.nextLine();
            System.out.println("Please input book's new price");
            String priceStr = scanner.nextLine();
            System.out.println("Please input book quantity");
            String quantity = scanner.nextLine();
            System.out.println("Please input book numberOfPages");
            String numberOfPages = scanner.nextLine();

            if (bookName != null && !bookName.isEmpty()) {
                bookById.setBookName(bookName);
            }
            if (authorName != null && !authorName.isEmpty()) {
                bookById.setAuthorName(authorName);
            }
            if (authorSurName != null && !authorSurName.isEmpty()) {
                bookById.setAuthorSurName(authorSurName);
            }
            if (priceStr != null && !priceStr.isEmpty()) {
                bookById.setPrice(Double.parseDouble(priceStr));
            }
            if (quantity != null && !quantity.isEmpty()) {
                bookById.setQuantity(Double.parseDouble(quantity));
            }
            if (numberOfPages != null && !numberOfPages.isEmpty()) {
                bookById.setNumberOfPages(Double.parseDouble(numberOfPages));
            }
            System.out.println("Update was successfully");
        }
    }


    private static void deletedBookById() {
        bookStorage.print();
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        bookStorage.deletedBookById(id);
        System.out.println("Book deleted ");
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_BOOK + " for ADD_BOOK");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for PRINT_ALL_BOOKS");
        System.out.println("Please input " + SEARCH_BOOK_BY_NAME + " for SEARCH_BOOK_BY_BOOK_NAME");
        System.out.println("Please input " + SEARCH_BOOK_BY_Author_Name + " for SEARCH_BOOK_BY_Author_Name");
        System.out.println("Please input " + SEARCH_BOOK_BY_Author_Surname + " for SEARCH_BOOK_BY_Author_Surname");
        System.out.println("Please input " + SEARCH_BOOK_BY_PRICE + " for SEARCH_BOOK_BY_PRICE");
        System.out.println("Please input " + UPDATE_BOOK + " for UPDATE_BOOK");
        System.out.println("Please input " + DELETED_BOOK_BY_ID + " for DELETED_BOOK_BY_ID");
    }
}
