package homework.bookStorage.storage;

import homework.bookStorage.model.Author;

public class AuthorStorage {

    private Author[] authors = new Author[10];
    private int size;


    public void add(Author author) {
        if (authors.length == size) {
            extendStorage();
        }
        authors[size++] = author;
    }

    private void extendStorage() {
        Author[] tmp = new Author[size + 10];
        System.arraycopy(authors, 0, tmp, 0, size);
        authors = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(authors[i]);
        }
    }

    public Author getAuthorById(String id) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getId().equals(id)) {
                return authors[i];
            }
        }
        return null;
    }

    private int getAuthorIndexById(String authorId){
        for (int i = 0; i < size; i++) {
            if (authors[i].getId().equals(authorId)){
                return i;
            }
        }
        return -1;
    }

    public void deletedAuthor(String author) {
        if (size > -1) {
            for (int i = 0; i < size; i++) {
                if (authors[i].getId().equals(author)) {
                    for (int j = i; j < size - 1; j++) {
                        authors[j] = authors[j + 1];
                    }
                    size--;
                }
            }
        }
    }
}
