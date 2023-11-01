import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int numCopies;
    private Status status;
    private Date dueDate;

    public Book(String title, String author, String ISBN, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
        this.status = Status.AVAILABLE;

        copies = new ArrayList<>();
        for (int i = 1; i <= numCopies; i++) {
            copies.add(new Copy(i, "Available"));
        }
    }

    private List<Copy> copies;

    public List<Copy> getCopies() {
        return copies;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDueDate(int borrowingPeriodInDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, borrowingPeriodInDays);
        this.dueDate = calendar.getTime();
    }

    public boolean isOverdue() {
        if (dueDate == null) {
            return false;
        }
        Date currentDate = new Date();
        return currentDate.after(dueDate);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void editBook(String title, String author, String ISBN, String publisher, int numCopies) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setISBN(ISBN);
        this.setPublisher(publisher);
        this.setNumCopies(numCopies);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public void returnBook(int numCopiesToReturn) {
        numCopies += numCopiesToReturn;
        if (numCopies == 0) {
            status = Status.AVAILABLE;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nPublisher: " + publisher
                + "\nCopies: " + numCopies;
    }

    public void borrowBook(int numCopiesToBorrow) {
        if (status == Status.AVAILABLE && numCopies >= numCopiesToBorrow) {
            status = Status.CHECKED_OUT;
            numCopies -= numCopiesToBorrow;
        }
    }
}
