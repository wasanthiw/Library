import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Represents a library that manages a collection of books.
 */
public class Library {
    // PROPERTIES
    /** List of books in the library */
    private ArrayList<Book> books;
    
    // CONSTRUCTOR
    /**
     * Constructs a new Library with an empty collection of books.
     */
    public Library() {
        books = new ArrayList<>();
    }

    // METHODS

    /**
     * Searches for a book in the library by title or ISBN.
     *
     * @param searchTerm The title or ISBN to search for
     * @return the matching Book object, or null if not found
     */
    public Book searchBook(String searchTerm) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTerm) ||
                book.getISBN().equalsIgnoreCase(searchTerm)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Removes a book from the library using its ISBN.
     *
     * @param isbn The ISBN of the book to remove
     * @return true if the book was found and removed, false otherwise
     */
    public boolean removeBook(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                books.remove(book);
                System.out.println("Book removed: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }

    /**
     * Adds a book to the library collection.
     *
     * @param book The Book object to add
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    
    /**
     * Displays all books in the library.
     * If the library is empty, prints a message indicating no books are available.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book book : books) {
            System.out.println(" ");
            System.out.println("-----------------------");
            System.out.println(book);
            System.out.println("-----------------------");
            System.out.println(" ");
        }
    }
    
    /**
     * Loads books from a CSV file into the library.
     * Each line in the file should contain: title, author, ISBN, year (comma-separated).
     * 
     * @param filename the name of the file to load books from
     */
    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    try {
                        String title = data[0].trim();
                        String author = data[1].trim();
                        String isbn = data[2].trim();
                        int year = Integer.parseInt(data[3].trim());
                        
                        Book book = new Book(title, author, isbn, year);
                        books.add(book);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid book data format: " + line);
                    }
                } else {
                    System.out.println("Invalid book data format: " + line);
                }
            }
            System.out.println("Books loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Checks out a book by ISBN.
     * Sets the book's availability to false.
     *
     * @param ISBN The ISBN of the book to check out
     */
    public void checkOutBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You checked out: " + book.getTitle());
                } else {
                    System.out.println("That book is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    /**
     * Returns a book by ISBN.
     * Sets the book's availability to true.
     *
     * @param ISBN The ISBN of the book to return
     */
    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You returned: " + book.getTitle());
                } else {
                    System.out.println("This book was not checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

