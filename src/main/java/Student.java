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

    public ArrayList<Book> booksOnLoan() {
        ArrayList<Book> onLoanList = new ArrayList<>();
        onLoanList.addAll(onLoan);
        return onLoanList;
    }

    public String searchLibrary(Library library, Book book) {
        for (Book stock : library.libraryContents()) {
                if (book.getTitle() == stock.getTitle()) {
                    String output = String.format("Yes we have %s in stock.", book.getTitle());
                    return output;
                    }
                }
                    String output2 = String.format("Sorry we don't have %s in stock.", book.getTitle());
                    return output2;
        }

    public ArrayList<Book> searchGenre(Library library, Genre genre) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book stock : library.libraryContents()) {
            if (genre == stock.getGenre()) {
                results.add(stock);
                }
            }
           return results;
        }

}
