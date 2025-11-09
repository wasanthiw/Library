public class Book {

    // Properties (instance variables)
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private boolean isAvailable;

    /**
     * Constructor to initialize the Book object with core details.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The International Standard Book Number.
     * @param publicationYear The year the book was published.
     */
    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        // The book is available when it is first created and added to the system
        this.isAvailable = true;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

}

