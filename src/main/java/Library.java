import java.util.ArrayList;

public class Library {

    private String name;
    private int space;
    private ArrayList<Book> contents;

    public Library(String name, int space) {
        this.name = name;
        this.space = space;
        this.contents = new ArrayList<>();
    }

    public int countBooks() {
        return this.contents.size();
    }

    public boolean isFull() {
        if (countBooks() >= space) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addBook(Book book) {
        if (isFull() == false) {
            this.contents.add(book);
        }
    }

    public void removeBooks(Book book) {
         Book bookCopy = book;
         this.contents.remove(book);
    }


    public ArrayList<Book> libraryContents() {
        ArrayList<Book> contentsCopy = this.contents;
        return contentsCopy;
    }
}
