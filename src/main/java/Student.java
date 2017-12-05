import java.util.ArrayList;

public class Student {

    private String name;
    private int maximumBooks;
    private ArrayList<Book> onLoan;


    public Student(String name, int maximumBooks) {
        this.name = name;
        this.maximumBooks = maximumBooks;
        this.onLoan = new ArrayList<>();
    }

    public int numberOfBooks() {
        return this.onLoan.size();
    }

    public boolean maximumCapacity() {
        if (numberOfBooks() >= maximumBooks) {
            return true;
        }
         else {
            return false;
        }
    }

    public void takeOutBook(Library library, Book book) {
        if (maximumCapacity() == false)
        {
            library.removeBooks(book);
            this.onLoan.add(book);
        }
    }

    public void returnBook(Library library, Book book) {
        if (library.isFull() == false) {
            this.onLoan.remove(book);
            library.addBook(book);
        }
    }
}
