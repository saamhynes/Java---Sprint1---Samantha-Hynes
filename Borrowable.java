public interface Borrowable {
    void borrowBook(Patron patron, Book book, int numCopiesToBorrow);

    void returnBook(Patron patron, Book book, int numCopiesToReturn);
}
