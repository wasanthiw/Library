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
     * Displays all books in the library.
     * If the library is empty, prints a message indicating no books are available.
     */

    /**
     * Adds a book to the library collection.
     *
     * @param book The Book object to add
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    
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
    
}

