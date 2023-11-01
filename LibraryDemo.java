import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryDemo {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        ArrayList<Copy> libraryCopies = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<Patron> patrons = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Library Management System");
            System.out.println("1. Book Management");
            System.out.println("2. Author Management");
            System.out.println("3. Patron Management");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Check Book Status");
            System.out.println("7. Exit");
            System.out.println("Please select an option(1-7): ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    // Book Management Menu

                    while (true) {
                        System.out.println();
                        System.out.println("Book Management Menu");
                        System.out.println("1. Add a Book");
                        System.out.println("2. Edit a Book");
                        System.out.println("3. Delete a Book");
                        System.out.println("4. List Books");
                        System.out.println("5. Search Books by Title");
                        System.out.println("6. Search Books by Author");
                        System.out.println("7. Search Books by ISBN");
                        System.out.println("8. Return to Main Menu");
                        System.out.println("Please select an option(1-5): ");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        String authorName = "";

                        switch (choice) {
                            case 1:
                                // Add a Book
                                System.out.println("Enter title: ");
                                String title = scanner.nextLine();

                                System.out.println("Enter author: ");
                                String author = scanner.nextLine();

                                Author bookAuthor = null;
                                for (Author existingAuthor : authors) {
                                    if (existingAuthor.getName().equalsIgnoreCase(author)) {
                                        bookAuthor = existingAuthor;
                                        break;
                                    }
                                }

                                if (bookAuthor == null) {
                                    bookAuthor = new Author(authorName, "");
                                    authors.add(bookAuthor);
                                }

                                System.out.println("Enter ISBN: ");
                                String ISBN = scanner.nextLine();

                                System.out.println("Enter publisher: ");
                                String publisher = scanner.nextLine();

                                System.out.println("Enter the number of copies: ");
                                int numCopies = scanner.nextInt();
                                scanner.nextLine();

                                Book newBook = new Book(title, author, ISBN, publisher, numCopies);

                                library.add(newBook);

                                bookAuthor.addBook(newBook);

                                libraryCopies.addAll(newBook.getCopies());
                                System.out.println("Book added to the library.");
                                break;

                            case 2:
                                // Edit a Book
                                System.out.println("Enter the ISBN of the book you want to edit: ");
                                String editISBN = scanner.nextLine();

                                boolean found = false;
                                for (Book book : library) {
                                    if (book.getISBN().equals(editISBN)) {
                                        System.out.println("Enter the new title: ");
                                        String newTitle = scanner.nextLine();
                                        book.setTitle(newTitle);

                                        System.out.println("Enter the new author: ");
                                        String newAuthor = scanner.nextLine();
                                        book.setAuthor(newAuthor);

                                        System.out.println("Enter the new ISBN: ");
                                        String newISBN = scanner.nextLine();
                                        book.setISBN(newISBN);

                                        System.out.println("Enter the new publisher: ");
                                        String newPublisher = scanner.nextLine();
                                        book.setPublisher(newPublisher);

                                        System.out.println("Enter new number of copies: ");
                                        int newNumCopies = scanner.nextInt();
                                        book.setNumCopies(newNumCopies);

                                        scanner.nextLine();
                                        found = true;

                                        System.out.println("Book edited successfully.");
                                    }
                                }

                                if (!found) {
                                    System.out.println("Book not found in the library.");
                                }
                                break;

                            case 3:
                                // Delete a Book
                                System.out.println("Enter the ISBN of the book you want to delete: ");
                                String deleteISBN = scanner.nextLine();

                                boolean removed = false;
                                for (Book book : library) {
                                    if (book.getISBN().equals(deleteISBN)) {
                                        library.remove(book);
                                        removed = true;

                                        // remove all associated copies
                                        for (Copy copy : book.getCopies()) {
                                            libraryCopies.remove(copy);

                                        }
                                        System.out.println("Book and associated copies deleted from the library.");
                                        break;
                                    }
                                }

                                if (!removed) {
                                    System.out.println("Book not found in the library.");
                                }
                                break;

                            case 4:
                                // List Books
                                // Number of Books in Library
                                System.out.println("Number of books in the library: " + library.size());

                                // List Books
                                System.out.println("List of books in the library: ");
                                for (Book book : library) {
                                    System.out.println(book);
                                    System.out.println("----------------------------");
                                }
                                break;

                            case 5:
                                // Search Books by Title
                                System.out.println("Enter the title of the book you want to search: ");
                                String searchTitle = scanner.nextLine();

                                searchBooksByTitle(library, searchTitle);
                                break;

                            case 6:
                                // Search Books by Author
                                System.out.println("Enter the author of the book you want to search: ");
                                String searchAuthor = scanner.nextLine();

                                searchBooksByAuthor(library, searchAuthor);
                                break;

                            case 7:
                                // Search Books by ISBN
                                System.out.println("Enter the ISBN of the book you want to search: ");
                                String searchISBN = scanner.nextLine();

                                searchBookByISBN(library, searchISBN);
                                break;

                            case 8:
                                // Back to Main Menu
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (choice == 8) {
                            break;
                        }

                    }
                    break;

                case 2:
                    // Author Management Menu
                    while (true) {
                        System.out.println();
                        System.out.println("Author Management Menu");
                        System.out.println("1. Add an Author");
                        System.out.println("2. Edit an Author");
                        System.out.println("3. Delete an Author");
                        System.out.println("4. List of Authors and their books");
                        System.out.println("5. Return to Main Menu");
                        System.out.println("Please select an option(1-5): ");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                // Add an Author
                                System.out.println("Enter the author's name: ");
                                String authorName = scanner.nextLine();

                                System.out.println("Enter the author's date of birth: ");
                                String dateOfBirth = scanner.nextLine();

                                Author newAuthor = new Author(authorName, dateOfBirth);

                                authors.add(newAuthor);
                                System.out.println("Author added to the library.");

                                break;

                            case 2:
                                // Edit an Author
                                System.out.println("Enter the name of the author you want to edit: ");
                                String editAuthorName = scanner.nextLine();

                                boolean authorFound = false;
                                for (Author author : authors) {
                                    if (author.getName().equals(editAuthorName)) {
                                        System.out.println("Enter the new name for the author: ");
                                        String newAuthorName = scanner.nextLine();

                                        System.out.println("Enter the new date of birth for the author: ");
                                        String newDateOfBirth = scanner.nextLine();

                                        author.setName(newAuthorName);
                                        author.setDateOfBirth(newDateOfBirth);

                                        authorFound = true;
                                        System.out.println("Author edited successfully.");
                                        break;
                                    }
                                }

                                if (!authorFound) {
                                    System.out.println("Author not found in the library.");
                                }
                                break;

                            case 3:
                                // Delete an Author
                                System.out.println("Enter the name of the author you want to delete: ");
                                String deleteAuthorName = scanner.nextLine();

                                boolean authorRemoved = false;
                                for (Author author : authors) {
                                    if (author.getName().equals(deleteAuthorName)) {
                                        authors.remove(author);

                                        for (Book book : library) {
                                            if (book.getAuthor().equals(deleteAuthorName)) {
                                                library.remove(book);
                                            }
                                        }

                                        authorRemoved = true;
                                        System.out.println("Author and associated books deleted from the library.");
                                        break;
                                    }
                                }

                                if (!authorRemoved) {
                                    System.out.println("Author not found in the library.");
                                }
                                break;

                            case 4:
                                // List Authors
                                for (Author author : authors) {
                                    System.out.println("Author: " + author.getName());
                                    System.out.println("Date of Birth: " + author.getDateOfBirth());

                                    // System.out.println("Books Written by " + author.getName() + ":");

                                    for (Book book : author.getBooks()) {
                                        System.out.println("Title: " + book.getTitle());
                                    }
                                    System.out.println("----------------------------");

                                }
                                break;

                            case 5:
                                // Back to Main Menu
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (choice == 5) {
                            break;
                        }
                    }

                    break;

                case 3:
                    // Patron Management Menu
                    while (true) {
                        System.out.println();
                        System.out.println("Patron Management Menu");
                        System.out.println("1. Add a Patron");
                        System.out.println("2. Edit a Patron");
                        System.out.println("3. Delete a Patron");
                        System.out.println("4. List of Patrons");
                        System.out.println("5. Return to Main Menu");
                        System.out.println("Please select an option(1-5): ");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                // Add a Patron
                                System.out.println("Enter the name of the patron: ");
                                String patronName = scanner.nextLine();

                                System.out.println("Enter the address of the patron: ");
                                String patronAddress = scanner.nextLine();

                                System.out.println("Enter the phone number of the patron: ");
                                String patronPhoneNumber = scanner.nextLine();

                                Patron newPatron = new Patron(patronName, patronAddress, patronPhoneNumber);

                                patrons.add(newPatron);
                                System.out.println("Patron added to the library.");

                                break;

                            case 2:
                                // Edit a Patron
                                System.out.println("Enter the name of the patron you want to edit: ");
                                String editPatronName = scanner.nextLine();

                                boolean patronFound = false;
                                for (Patron patron : patrons) {
                                    if (patron.getName().equals(editPatronName)) {
                                        System.out.println("Enter the new name for the patron: ");
                                        String newPatronName = scanner.nextLine();

                                        System.out.println("Enter the new address for the patron: ");
                                        String newPatronAddress = scanner.nextLine();

                                        System.out.println("Enter the new phone number for the patron: ");
                                        String newPatronPhoneNumber = scanner.nextLine();

                                        patron.setName(newPatronName);
                                        patron.setAddress(newPatronAddress);
                                        patron.setPhoneNumber(newPatronPhoneNumber);

                                        patronFound = true;
                                        System.out.println("Patron edited successfully.");
                                        break;
                                    }
                                }
                                if (!patronFound) {
                                    System.out.println("Patron not found in the library.");
                                }
                                break;

                            case 3:
                                // Delete a Patron
                                System.out.println("Enter the name of the patron you want to delete: ");
                                String deletePatronName = scanner.nextLine();

                                boolean patronRemoved = false;
                                for (Patron patron : patrons) {
                                    if (patron.getName().equals(deletePatronName)) {
                                        patrons.remove(patron);
                                        patronRemoved = true;

                                        // remove patron's borrowed books
                                        for (Book book : patron.getBorrowedBooks()) {
                                            book.returnBook(1);
                                        }
                                        System.out.println("Patron and associated books deleted from the library.");
                                        break;
                                    }
                                }

                                if (!patronRemoved) {
                                    System.out.println("Patron not found in the library.");
                                }
                                break;

                            case 4:
                                // List Patrons
                                for (Patron patron : patrons) {
                                    System.out.println("Name: " + patron.getName());
                                    System.out.println("Address: " + patron.getAddress());
                                    System.out.println("Phone Number: " + patron.getPhoneNumber());

                                    System.out.println("Borrowed Books: ");
                                    for (Book book : patron.getBorrowedBooks()) {
                                        System.out.println("Title: " + book.getTitle());
                                    }
                                    System.out.println("----------------------------");
                                }
                                break;

                            case 5:
                                // Back to Main Menu
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (choice == 5) {
                            break;
                        }

                    }
                    break;
                case 4:
                    // Borrow a book
                    System.out.println("Enter the ISBN of the book you want to borrow: ");
                    String borrowISBN = scanner.nextLine();

                    System.out.println("Enter your patron name: ");
                    String patronName = scanner.nextLine();

                    boolean bookFound = false;
                    boolean patronFound = false;

                    for (Book book : library) {
                        if (book.getISBN().equals(borrowISBN)) {
                            bookFound = true;

                            for (Patron patron : patrons) {
                                if (patron.getName().equalsIgnoreCase(patronName)) {
                                    patronFound = true;

                                    if (book.getStatus() == Status.AVAILABLE) {
                                        System.out.println("How many copies would you like to borrow? ");
                                        int numCopiesToBorrow = scanner.nextInt();
                                        scanner.nextLine();

                                        if (book.getNumCopies() >= numCopiesToBorrow) {
                                            book.borrowBook(numCopiesToBorrow);
                                            patron.addBorrowedBook(book, numCopiesToBorrow);
                                            System.out.println(patronName + " borrowed " + numCopiesToBorrow
                                                    + " copies of " + book.getTitle());
                                        } else {
                                            System.out.println("Not enough copies available to borrow.");
                                        }
                                    } else {
                                        System.out.println("Book is not available for borrowing.");
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book not found in the library.");
                    } else if (!patronFound) {
                        System.out.println("Patron not found in the library.");
                    }
                    break;

                case 5:
                    // Return a book
                    System.out.println("Enter the ISBN of the book you want to return: ");
                    String returnISBN = scanner.nextLine();

                    System.out.println("Enter your patron name: ");
                    String returnPatronName = scanner.nextLine();

                    boolean returnBookFound = false;
                    boolean returnPatronFound = false;

                    for (Book book : library) {
                        if (book.getISBN().equals(returnISBN)) {
                            returnBookFound = true;

                            for (Patron patron : patrons) {
                                if (patron.getName().equalsIgnoreCase(returnPatronName)) {
                                    returnPatronFound = true;

                                    if (patron.hasBorrowedBook(book)) {
                                        System.out.println("How many copies would you like to return?");
                                        int numCopiesToReturn = scanner.nextInt();

                                        if (numCopiesToReturn > 0) {
                                            book.returnBook(numCopiesToReturn);
                                            patron.removeBorrowedBook(book, numCopiesToReturn);
                                            System.out.println(patron.getName() + " returned " + numCopiesToReturn
                                                    + " copies of " + book.getTitle());
                                        } else {
                                            System.out.println("Invalid number of copies to return.");
                                        }
                                    } else {
                                        System.out.println("You have no borrowed this book.");
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if (!returnBookFound) {
                        System.out.println("Book not found in the library.");
                    } else if (!returnPatronFound) {
                        System.out.println("Patron not found in the library.");
                    }
                    break;

                case 6:
                    // Check Book Status
                    System.out.println("Enter the ISBN of the book you want to check: ");
                    String statusISBN = scanner.nextLine();

                    boolean statusBookFound = false;

                    for (Book book : library) {
                        if (book.getISBN().equals(statusISBN)) {
                            statusBookFound = true;

                            System.out.println("Book Status: " + book.getStatus());
                            break;
                        }
                    }
                    if (!statusBookFound) {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Thank you for using the Library Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }

    private static void searchBooksByTitle(List<Book> books, String title) {
        boolean found = false;
        System.out.println("Books with title " + title + ":");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with given title.");
        }
    }

    private static void searchBooksByAuthor(ArrayList<Book> library, String author) {
        boolean found = false;
        System.out.println("Books by author '" + author + "':");
        for (Book book : library) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with given author.");
        }
    }

    private static void searchBookByISBN(ArrayList<Book> library, String ISBN) {
        boolean found = false;
        System.out.println("Books with ISBN " + ISBN + ":");
        for (Book book : library) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                System.out.println(book);
                System.out.println("----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with given ISBN.");
        }
    }

}
