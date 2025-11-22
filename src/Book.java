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

/**
     * Returns the publication year of the book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Returns true if the book is available, otherwise false.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available TRUE if the book is available, FALSE if checked out.
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    /**
     * Returns a formatted string containing the book's details.
     */
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Checked Out";
        return "Title: " + title +
               "\nAuthor: " + author +
               "\nISBN: " + ISBN +
               "\nPublication Year: " + publicationYear +
               "\nStatus: " + status;
    }
}

