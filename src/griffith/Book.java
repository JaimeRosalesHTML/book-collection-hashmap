package griffith;

//JAIME ROSALES 3142108

//Book class representing a book object with title, author, and publisher
public class Book {
 private String title;
 private String author;
 private String publisher;

 // Constructor to create a new Book object
 public Book(String title, String author, String publisher) {
     this.title = title;
     this.author = author;
     this.publisher = publisher;
 }

 // Getter for publisher (used as key)
 public String getPublisher() {
     return publisher;
 }

 // Getter for title (used in filtering)
 public String getTitle() {
     return title;
 }

 // Books are considered equal if they have the same publisher
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     Book book = (Book) obj;
     return publisher.equals(book.publisher);
 }

 // Hash code based only on publisher (for use in HashList)
 @Override
 public int hashCode() {
     int hash = 0;
     for (int i = 0; i < publisher.length(); i++) {
         hash = (hash * 31 + publisher.charAt(i)) % 1000;
     }
     return hash;
 }

 // toString method to display book information clearly
 @Override
 public String toString() {
     return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher;
 }
}

