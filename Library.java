import java.util.ArrayList;
import java.util.List;

public class Library implements Borrowable {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void editBook(Book book, String title, String author, String ISBN, String publisher, int numCopies) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setPublisher(publisher);
        book.setNumCopies(numCopies);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    // search books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // search books by author
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // search books by ISBN
    public List<Book> searchBookByISBN(String ISBN) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    public Status getBookStatus(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book.getStatus();
            }
        }

        return null;
    }

    // Borrow a book
    public void borrowBook(Patron patron, Book book, int numCopiesToBorrow) {
        Status bookStatus = getBookStatus(book.getISBN());

        if (bookStatus == Status.AVAILABLE && book.getNumCopies() >= numCopiesToBorrow) {
            book.setStatus(Status.CHECKED_OUT);
            patron.addBorrowedBook(book, numCopiesToBorrow);
            System.out.println(patron.getName() + " borrowed " + numCopiesToBorrow + " copies of " + book.getTitle());
        } else {
            System.out.println("Not enough copies available to borrow.");
        }
    }

    // Return a book
    public void returnBook(Patron patron, Book book, int numCopiesToReturn) {
        Status bookStatus = getBookStatus(book.getISBN());

        if (bookStatus == Status.CHECKED_OUT) {
            book.setStatus(Status.AVAILABLE);
            patron.removeBorrowedBook(book, numCopiesToReturn);
            System.out.println(patron.getName() + " returned " + numCopiesToReturn + " copies of " + book.getTitle());
        } else {
            System.out.println("Book is not checked out.");
        }
    }

    // managing authors
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void editAuthor(Author author, String name, String dateOfBirth) {
        author.setName(name);
        author.setDateOfBirth(dateOfBirth);
    }

    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    // managing patrons

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // edit patron
    public void editPatron(Patron patron, String name, String address, String phoneNumber) {
        patron.setName(name);
        patron.setAddress(address);
        patron.setPhoneNumber(phoneNumber);
    }

    public void deletePatron(Patron patron) {
        patrons.remove(patron);
    }

    // list all patrons
    public List<Patron> getAllPatrons() {
        return patrons;
    }
}
