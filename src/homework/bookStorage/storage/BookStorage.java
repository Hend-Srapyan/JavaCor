package homework.bookStorage.storage;

import homework.bookStorage.model.Book;



public class BookStorage {

    private Book[] books = new Book[10];
    private int size;


    public void add(Book book) {
        if (books.length == size) {
            extendStorage();
        }
        books[size++] = book;
    }

    private void extendStorage() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchBookByName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookName().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }
    public Book getBookById(String id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)) {
                return books[i];
            }
        }
        return null;
    }

    public void searchBookByPrice(int minPrice, int maxPrice) {
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= minPrice && books[i].getPrice() <= maxPrice) {
                System.out.println(books[i]);
            }
        }
    }

    public void deletedBookById(String id) {
        if (size > -1) {
            for (int i = 0; i < size; i++) {
                if (books[i].getId().equals(id)) {
                    for (int j = i; j < size - 1; j++) {
                        books[j] = books[j + 1];
                    }
                    size--;
                }
            }
        }
    }
}
