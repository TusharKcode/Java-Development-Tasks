package tasks.advanced.library.models;

public class Book {

    private int id;
    private final String title;
    private final String author;
    private boolean isAvailable;
    private int quantity;

    // Constructor without ID ( for adding new book )
    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Constructor with ID ( for fetching from DB )
    public Book(int id, String title, String author, boolean isAvailable, int quantity){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.quantity = quantity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                ", Available: " + isAvailable;
    }
}
