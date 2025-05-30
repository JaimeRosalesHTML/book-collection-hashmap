# Book Collection HashMap – Java DSA Project

This Java project demonstrates a custom hash-based data structure to manage a large collection of books loaded from a CSV file. It simulates a lightweight in-memory database and showcases core data structures and functional programming in Java.

---

## 🚀 Features

- Load 5000 books from a CSV file using BufferedReader
- Hash them using a custom `HashList` implementation
- Display values per bucket and hash table usage statistics
- Filter books using lambda expressions and `Predicate` functional interfaces
- Override key object methods like `equals`, `hashCode`, and `toString`

---

## 📂 Project Structure:
src/
└── griffith/

├── Book.java // Represents each book (title, publisher, etc.)

├── HashList.java // Custom generic hash table implementation

├── Main.java // Loads CSV and populates the hash list

└── TestHashList.java // Contains tests using lambda-based filters

books.csv // Dataset with 5000 book entries

---

## 💡 Concepts Demonstrated

- Custom data structures using Java Generics
- Functional programming with `Predicate` and Lambdas
- File I/O and parsing with BufferedReader
- Hashing techniques and load factor analysis
- Object-Oriented Design and class hierarchy

---

## 🛠 How to Run

1. Make sure `books.csv` is in the root of the project.
2. Compile the Java files:
   ```bash
   javac src/griffith/*.java
3. Run the main class:
     java griffith.Main

---   

📌 Notes
This project was developed as part of my coursework in Data Structures and Algorithms. It reflects practical implementation of hash tables, filtering, and real-world data handling. I created this project to deepen my understanding of Java’s object model and data processing capabilities.





