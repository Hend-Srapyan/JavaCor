package homework.bookStorage;

import java.util.Objects;

public class Book {

    private String id;
    private String bookName;
    private String authorName;
    private String authorSurName;
    private double price;
    private double quantity;
    private double numberOfPages;

    public Book(String id, String bookName, String authorName, String authorSurName,
                double price, double quantity, double numberOfPages) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.authorSurName = authorSurName;
        this.price = price;
        this.quantity = quantity;
        this.numberOfPages = numberOfPages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(double numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && Double.compare(quantity, book.quantity) == 0 &&
               Double.compare(numberOfPages, book.numberOfPages) == 0 && Objects.equals(id, book.id) &&
               Objects.equals(bookName, book.bookName) && Objects.equals(authorName, book.authorName) && Objects.equals(authorSurName, book.authorSurName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, authorName, authorSurName, price, quantity, numberOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id + '\'' +
                ", bookName = " + bookName + '\'' +
                ", authorName = " + authorName + '\'' +
                ", authorSurName = " + authorSurName + '\'' +
                ", price = " + price +
                ", quantity = " + quantity +
                ", numberOfPages = " + numberOfPages +
                '}';
    }
}
