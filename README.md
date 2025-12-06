# Library Management System

A simple command-line Library Management System built in Java that allows users to manage a collection of books. This application provides functionality to add, remove, search, check out, and return books, as well as load books from a CSV file.

## Features

- **Add Book**: Add a new book to the library with title, author, ISBN, and publication year
- **Remove Book**: Remove a book from the library by ISBN
- **Search Book**: Search for books by title, author, or ISBN
- **Display All Books**: View all books in the library with their availability status
- **Check Out Book**: Mark a book as checked out (unavailable)
- **Return Book**: Mark a book as returned (available)
- **Load Books from File**: Import multiple books from a CSV file

## Requirements

- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

## Installation & Setup

1. Clone or download this repository to your local machine
2. Ensure Java is installed on your system by running:
   ```bash
   java -version
   ```
3. Navigate to the project directory:
   ```bash
   cd Library
   ```

## Usage

### Compiling the Application

To compile the Java source files, navigate to the project root directory and run:

```bash
javac src/*.java
```

### Running the Application

After compilation, run the application using:

```bash
java -cp src Main
```

The application will display a menu with the following options:

```
=== Library Management System ===
1. Add Book
2. Remove Book
3. Search Book
4. Display All Books
5. Check Out Book
6. Return Book
7. Load Books From File
8. Exit
```

Enter the number corresponding to your choice and follow the prompts.

## CSV File Format

To load books from a CSV file, use option 7 in the menu. The CSV file should follow this format:

```
Title,Author,ISBN,Publication Year
```

### Example CSV Format

```csv
To Kill a Mockingbird,Harper Lee,978-0061120084,1960
1984,George Orwell,978-0451524935,1949
Pride and Prejudice,Jane Austen,978-0141439518,1813
```

**Important notes:**
- Each line represents one book
- Fields are separated by commas
- All four fields (title, author, ISBN, year) are required
- The publication year must be a valid integer
- No header row should be included

A sample CSV file (`books.csv`) is included in the `src` directory with example books.

## Project Structure

```
Library/
├── src/
│   ├── Main.java       # Main entry point and menu system
│   ├── Library.java    # Library management logic
│   ├── Book.java       # Book class definition
│   └── books.csv       # Sample book data
├── Library.iml         # IntelliJ IDEA module file
└── README.md           # This file
```

## Example Usage

1. Start the application
2. Select option 7 to load books from file
3. Enter `src/books.csv` as the filename
4. Select option 4 to display all loaded books
5. Use other menu options to manage the books as needed
