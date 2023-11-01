import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code Author} class represents an author with a name, date of birth, and
 * a list of books written by the author.
 */
public class Author {
    private String name;
    private String dateOfBirth;
    private List<Book> books;

    /**
     * Constructs an {@code Author} object with the specified name and date of
     * birth.
     *
     * @param name        the name of the author
     * @param dateOfBirth the date of birth of the author
     */
    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = new ArrayList<>();
    }

    /**
     * Gets the name of the author.
     *
     * @return the name of the author
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the author.
     *
     * @param name the name of the author
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of birth of the author.
     *
     * @return the date of birth of the author
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the author.
     *
     * @param dateOfBirth the date of birth of the author
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the list of books written by the author.
     *
     * @return the list of books written by the author
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Adds a book to the list of books written by the author.
     *
     * @param book the book to be added
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the list of books written by the author.
     *
     * @param book the book to be removed
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Returns a string representation of the author, including their name, date of
     * birth, and the number of books written.
     *
     * @return a string representation of the author
     */
    @Override
    public String toString() {
        return "Author: " + name + "\nDate of Birth: " + dateOfBirth + "\nBooks Written: " + books.size();
    }
}
