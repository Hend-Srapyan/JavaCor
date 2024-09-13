package homework.bookStorage.model;

import homework.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Book {

    private String id;
    private String bookName;
    private Author author;
    private double price;
    private double quantity;
    private double numberOfPages;
    private Date createdAt;

    public Book(String id, String bookName, Author author, double price, double quantity, double numberOfPages, Date createdAt) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.numberOfPages = numberOfPages;
        this.createdAt = createdAt;
    }

    public Book() {

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && Double.compare(quantity, book.quantity) == 0 && Double.compare(numberOfPages, book.numberOfPages) == 0 && Objects.equals(id, book.id) && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author) && Objects.equals(createdAt, book.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, price, quantity, numberOfPages, createdAt);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id + '\'' +
                ", bookName = " + bookName + '\'' +
                ", author = " + author +
                ", price = " + price +
                ", quantity = " + quantity +
                ", numberOfPages = " + numberOfPages +
                ", createdAt = " + DateUtil.fromDateToString(createdAt) +
                '}';
    }
}
