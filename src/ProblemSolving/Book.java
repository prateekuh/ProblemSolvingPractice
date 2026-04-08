package ProblemSolving;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;
    private User borrowedBy;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public User getBorrowedBy() { return borrowedBy; }

    public void borrow(User user) {
        this.isAvailable = false;
        this.borrowedBy = user;
    }

    public void returnBook() {
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}