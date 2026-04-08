package ProblemSolving;

import java.util.*;

public class LibraryService {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Queue<User>> reservationQueue = new HashMap<>();

    // Add Book
    public void addBook(int id, String title, String author, String category) {
        if (books.containsKey(id)) {
            System.out.println("❌ Book ID already exists!");
            return;
        }
        books.put(id, new Book(id, title, author, category));
        System.out.println("✅ Book added: " + title);
    }

    // Remove Book
    public void removeBook(int id) {
        if (!books.containsKey(id)) {
            System.out.println("❌ Book not found!");
            return;
        }
        books.remove(id);
        System.out.println("🗑️ Book removed");
    }

    // Borrow Book
    public void borrowBook(int id, User user) {
        Book book = books.get(id);

        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("📌 Book not available. Added to queue.");

            reservationQueue
                    .computeIfAbsent(id, k -> new LinkedList<>())
                    .offer(user);
            return;
        }

        book.borrow(user);
        System.out.println("✅ Book borrowed by " + user.getName());
    }

    // Return Book
    public void returnBook(int id) {
        Book book = books.get(id);

        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("❌ Book was not borrowed!");
            return;
        }

        Queue<User> queue = reservationQueue.get(id);

        if (queue != null && !queue.isEmpty()) {
            User nextUser = queue.poll();
            book.borrow(nextUser);
            System.out.println("🔁 Book assigned to next user in queue: " + nextUser.getName());
        } else {
            book.returnBook();
            System.out.println("✅ Book returned and now available");
        }
    }

    // List Available Books
    public void listAvailableBooks() {
        System.out.println("📚 Available Books:");
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    // Filter by Author
    public void filterByAuthor(String author) {
        books.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    // Filter by Category
    public void filterByCategory(String category) {
        books.values().stream()
                .filter(b -> b.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
    }
}