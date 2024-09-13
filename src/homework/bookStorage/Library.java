package homework.bookStorage;


import homework.bookStorage.model.Author;
import homework.bookStorage.model.Book;
import homework.bookStorage.storage.AuthorStorage;
import homework.bookStorage.storage.BookStorage;
import homework.bookStorage.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Library implements LibraryCommands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            LibraryCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_ALL_AUTHORS:
                    authorStorage.print();
                    break;
                case SEARCH_BOOK_BY_NAME:
                    searchBookByName();
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

    private static void addAuthor() {
        System.out.println("Pleas input id, name, surname, phone, dateOfBirthday(01-01-2001)");
        String authorDataStr = scanner.nextLine();
        String[] authorDataArr = authorDataStr.split(",");
        if (authorDataArr.length == 5) {
            String id = authorDataArr[0];
            if (authorStorage.getAuthorById(id) == null) {
                try {
                    Author author = new Author();
                    author.setId(id);
                    author.setName(authorDataArr[1]);
                    author.setSurname(authorDataArr[2]);
                    author.setPhone(authorDataArr[3]);
                    author.setDateOfBirthday(DateUtil.fromStringToDate(authorDataArr[4]));
                    authorStorage.add(author);
                    System.out.println("Author added!");
                } catch (ParseException e) {
                    System.err.println("DATE OF BIRTHDAY IS INCORRECT!");
                }
            } else {
                System.out.println("Author with id " + id + " already exist.");
            }

        }
    }


    private static void addBook() {
        authorStorage.print();
        System.out.println("Please choose author id");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if (author != null) {
            System.out.println("Please input book id");
            String id = scanner.nextLine();
            System.out.println("Please input book bookName");
            String bookName = scanner.nextLine();
            System.out.println("Please input book price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input book quantity");
            double quantity = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input book numberOfPages");
            double numberOfPages = Double.parseDouble(scanner.nextLine());
            Book book = new Book(id, bookName, author, price, quantity, numberOfPages, new Date());
            Book bookById = bookStorage.getBookById(id);
            if (bookById == null) {
                bookStorage.add(book);
                System.out.println("Book added!");
            } else {
                System.out.println("Book with " + id + " already exists!");
            }
        } else {
            System.out.println("Wrong id!");
        }


    }

    private static void searchBookByName() {
        bookStorage.print();
        System.out.println("Please input book keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByName(keyword);
    }


    private static void searchBookByPrice() {
        bookStorage.print();
        try {
            System.out.println("Please input minimum price");
            int minPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input maximum price");
            int maxPrice = Integer.parseInt(scanner.nextLine());
            bookStorage.searchBookByPrice(minPrice, maxPrice);
        } catch (NumberFormatException e) {
            System.out.println("PLEASE INPUT ONLY DIGITS");
        }
    }

    private static void updateBook() {
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById != null) {
            authorStorage.print();
            System.out.println("Please choose author id");
            String authorId = scanner.nextLine();
            Author author = authorStorage.getAuthorById(authorId);
            if (author != null) {
                System.out.println("Please input book's new bookName");
                String bookName = scanner.nextLine();
                System.out.println("Please input book's new price");
                String priceStr = scanner.nextLine();
                System.out.println("Please input book quantity");
                String quantity = scanner.nextLine();
                System.out.println("Please input book numberOfPages");
                String numberOfPages = scanner.nextLine();

                if (bookName != null && !bookName.isEmpty()) {
                    bookById.setBookName(bookName);
                }
                bookById.setAuthor(author);
                try {
                    if (priceStr != null && !priceStr.isEmpty()) {
                        bookById.setPrice(Double.parseDouble(priceStr));
                    }
                    if (quantity != null && !quantity.isEmpty()) {
                        bookById.setQuantity(Double.parseDouble(quantity));
                    }
                    if (numberOfPages != null && !numberOfPages.isEmpty()) {
                        bookById.setNumberOfPages(Double.parseDouble(numberOfPages));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("PLEASE INPUT ONLY DIGITS");
                }

                System.out.println("Update was successfully");
            }
        }
    }


    private static void deletedBookById() {
        bookStorage.print();
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        bookStorage.deletedBookById(id);
        System.out.println("Book deleted ");
    }


}
