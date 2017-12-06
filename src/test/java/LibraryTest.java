import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Library library;
    Student student1;
    Student student2;

    @Before
    public void before(){
        book1 = new Book("1984", Genre.SCIFI);
        book2 = new Book("American Psycho", Genre.DRAMA);
        book3 = new Book("War and Peace", Genre.CLASSICS);
        book4 = new Book("A Peoples Tragedy", Genre.HISTORICAL);
        library = new Library("Edinburgh", 2);
        student1 = new Student("Richard Nixon", 3);
        student2 = new Student("Ronald Reagan", 0);
    }

    @Test
    public void getBookGenre() {
        assertEquals(Genre.SCIFI, book1.getGenre());
    }

    @Test
    public void getBookTitle() {
        assertEquals("1984", book1.getTitle());
    }

    @Test
    public void canCountContents() {
        assertEquals(0, library.countBooks());
    }

    @Test
    public void libraryIsFull() {
        assertEquals(false, library.isFull());
    }

    @Test
    public void canAddBookstoLibrary() {
        library.addBook(book1);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canRemoveBookFromLibrary() {
        library.addBook(book1);
        library.removeBooks(book1);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canSeeContentsOfLibrary() {
        library.addBook(book1);
        library.addBook(book2);
        ArrayList<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(expected, library.libraryContents());
    }

    @Test
    public void numberOfBooksTakenOut() {
        assertEquals(0, student1.numberOfBooks());
    }

    @Test
    public void checkMaximumBooks_False() {
        assertEquals(false, student1.maximumCapacity());
    }

    @Test
    public void canAddBooks() {
        library.addBook(book1);
        student1.takeOutBook(library, book1);
        assertEquals(1,student1.numberOfBooks());
        assertEquals(0,library.countBooks());
    }

    @Test
    public void canSeeAllBooksOnLoan() {
        library.addBook(book1);
        library.addBook(book2);
        student1.takeOutBook(library, book1);
        student1.takeOutBook(library, book2);
        ArrayList<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertEquals(expected,student1.booksOnLoan());

    }

    @Test
    public void checkMaximumBooks_True() {
        assertEquals(true, student2.maximumCapacity());
    }

    @Test
    public void canReturnBook() {
        library.addBook(book1);
        student1.takeOutBook(library, book1);
        student1.returnBook(library, book1);
        assertEquals(0, student1.numberOfBooks());
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canSearchForBooks() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals("Yes we have 1984 in stock.",student1.searchLibrary(library, book1));
        assertEquals("Sorry we don't have War and Peace in stock.",student1.searchLibrary(library, book3));
    }


}
