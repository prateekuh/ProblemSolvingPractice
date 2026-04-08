package ProblemSolving;

public class Main {
    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        User u1 = new User(1, "Prateek");
        User u2 = new User(2, "Rahul");

        // Add books
        service.addBook(1, "Java Basics", "James", "Programming");
        service.addBook(2, "Spring Boot", "Rod", "Programming");

        // Borrow
        service.borrowBook(1, u1);
        service.borrowBook(1, u2); // Goes to queue

        // Return
        service.returnBook(1); // Auto assign to Rahul

        // List
        service.listAvailableBooks();

        // Filter
        service.filterByAuthor("James");
    }
}