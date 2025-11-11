package tasks.advanced.library.dao;

import tasks.advanced.library.DBConnection;
import tasks.advanced.library.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Add a new book to the database
    public void addBook(Book book){
        String sql = "INSERT INTO books (title, author, available, quantity) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setBoolean(3, book.isAvailable());
            stmt.setInt(4, book.getQuantity());

            stmt.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (SQLException e){
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }

    // Get all books
    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e){
            System.out.println("Error fetching books: " + e.getMessage());
        }
        return list;
    }

    // Find books by ID
    public Book getBookById(int id){
        String sql = "SELECT * FROM books WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e){
            System.out.println("Error finding book: " + e.getMessage());
        }
        return null;
    }

    // Update availability of books (borrow/return)
    public void updateAvailability(int bookId, boolean available){
        String sql = "UPDATE books SET available = ? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setBoolean(1, available);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("Error updating availability: " + e.getMessage());
        }
    }

    // Update quantity of books (borrow/return)
    public void updateQuantity(int bookId, int newQuantity){
        String sql = "UPDATE books SET quantity = ? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, newQuantity);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("Error updating availability: " + e.getMessage());
        }
    }

    // Delete a book
    public void deleteBook(int id){
        String sql = "DELETE FROM books WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Book deleted!");

        } catch (SQLException e){
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}
