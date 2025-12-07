import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize Library object
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Main menu loop
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Check Out Book");
            System.out.println("6. Return Book");
            System.out.println("7. Load Books From File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Process menu choice
            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    break;
                    
                case 2:
                    // Remove Book
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBook(removeIsbn);
                    break;
                    
                case 3:
                    // Search Book
                    System.out.print("Enter title or ISBN to search: ");
                    String searchTerm = scanner.nextLine();
                    Book foundBook = library.searchBook(searchTerm);
                    if (foundBook != null) {
                        System.out.println("\nBook found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                    
                case 4:
                    // Display All Books
                    library.displayBooks();
                    break;
                    
                case 5:
                    // Check Out Book
                    System.out.print("Enter ISBN of the book to check out: ");
                    String checkOutIsbn = scanner.nextLine();
                    library.checkOutBook(checkOutIsbn);
                    break;
                    
                case 6:
                    // Return Book
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                    
                case 7:
                    // Load Books From File
                    System.out.print("Enter filename to load books: ");
                    String filename = scanner.nextLine();
                    library.loadBooksFromFile(filename);
                    break;
                    
                case 8:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}