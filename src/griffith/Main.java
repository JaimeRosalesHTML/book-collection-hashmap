package griffith;

//JAIME ROSALES 3142108

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Main class to load books.csv into HashList and display all data
public class Main {
    public static void main(String[] args) {
        HashList<Book> books = new HashList<>(6000);

        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            br.readLine(); // Skip the header line

            // Read each line, create a Book object, and add it to HashList
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

        // Display all books bucket by bucket
        books.displayLists();

        // Show percentage of buckets used
        double percent = books.percentUsed();
        System.out.printf("Percentage of Buckets Used: %.2f%%\n", percent);

        // Warn if 100% buckets used
        if (percent == 100.0) {
            System.out.println("Warning: All buckets used! Consider increasing the starting size.");
        }
    }
}

