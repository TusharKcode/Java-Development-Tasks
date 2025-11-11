package tasks.advanced.library.models;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private final int userId;
    private final int bookId;
    private final String action;          // "Borrow" OR "Return"
    private final LocalDate date;

    // Constructor without ID ( for inserting new transaction )
    public Transaction(int userId, int bookId, String action, LocalDate date){
        this.userId = userId;
        this.bookId = bookId;
        this.action = action;
        this.date = date;
    }

    // Constructor with ID ( when reading from DB )
    public Transaction(int id, int userId, int bookId, String action, LocalDate date){
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.action = action;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + id +
                ", User ID: " + userId +
                ", Book ID: " + bookId +
                ", Action: " + action +
                ", Date: " + date;
    }
}
