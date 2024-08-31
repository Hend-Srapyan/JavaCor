package homework.bookStorage;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size;


    public void add(Book book){
        if (books.length == size){
            extendStorage();
        }
        books[size++] = book;
    }

    private void extendStorage() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books,0,tmp,0,size);
        books = tmp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchBookByName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookName().contains(keyword)){
                System.out.println(books[i]);
            }
        }
    }

    public void searchBookByAuthorName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthorName().contains(keyword)){
                System.out.println(books[i]);
            }
        }
    }

    public void searchBookByAuthorSurName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthorSurName().contains(keyword)){
                System.out.println(books[i]);
            }
        }
    }


    public Book getBookById(String id){
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)){
                return books[i];
            }
        }
        return null;
    }

    public void searchBookByPrice(double price){
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice(price)){
                System.out.println(books[i]);
            }
        }
    }

//    public Book deletedBookById(String id){
//        for (int i = 0; i < size; i++) {
//
//        }
//        return null;
//    }
}
