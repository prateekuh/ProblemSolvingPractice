package ProblemSolving;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("6. Filter by Author");
            System.out.println("7. Filter by Category");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    service.addBook(id, title, author, category);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    service.removeBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();

                    service.borrowBook(borrowId, new User(userId, name));
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    service.returnBook(sc.nextInt());
                    break;

                case 5:
                    service.listAvailableBooks();
                    break;

                case 6:
                    System.out.print("Enter Author: ");
                    service.filterByAuthor(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter Category: ");
                    service.filterByCategory(sc.nextLine());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}