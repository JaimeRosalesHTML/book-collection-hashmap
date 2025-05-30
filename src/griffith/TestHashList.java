package griffith;

//	JAIME ROSALES 3142108

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;

// Test class to filter books using lambda functions and display results
public class TestHashList {

    // Method to filter books based on a given Predicate
    public static HashList<Book> filterBooks(Predicate<Book> condition, HashList<Book> books) {
        HashList<Book> filtered = new HashList<>(books.getSize());
        
        for (Book book : books.getAllEntries()) {
            if (condition.test(book)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    public static void main(String[] args) {
        HashList<Book> books = new HashList<>(6000);

        // Load the books.csv into the HashList
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    String publisher = parts[2].trim();

                    Book book = new Book(title, author, publisher);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lambda: Title longer than 50 characters
        Predicate<Book> longTitle = (Book b) -> b.getTitle().length() > 50;

        // Lambda: Publisher is "Del Rey Books"
        Predicate<Book> delReyPublisher = (Book b) -> b.getPublisher().equalsIgnoreCase("Del Rey Books");

        // Filter and display books with title longer than 50 characters
        HashList<Book> longTitleBooks = filterBooks(longTitle, books);
        System.out.println("Books with title longer than 50 characters:");
        longTitleBooks.displayLists();

        // Filter and display books published by 'Del Rey Books'
        HashList<Book> delReyBooks = filterBooks(delReyPublisher, books);
        System.out.println("\nBooks published by 'Del Rey Books':");
        delReyBooks.displayLists();
    }
}

