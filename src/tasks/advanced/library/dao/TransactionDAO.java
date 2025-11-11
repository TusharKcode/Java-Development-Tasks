package tasks.advanced.library.dao;

import tasks.advanced.library.DBConnection;
import tasks.advanced.library.models.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Add a new transaction (borrow/return)
    public void addTransaction(Transaction t){
        String sql = "INSERT INTO transactions (user_id, book_id, action, date) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, t.getUserId());
            stmt.setInt(2, t.getBookId());
            stmt.setString(3, t.getAction());
            stmt.setDate(4, Date.valueOf(t.getDate()));

            stmt.executeUpdate();
            System.out.println("Transaction recorded successfully!");

        } catch (SQLException e){
            System.out.println("Error adding transaction: " + e.getMessage());
        }
    }

    // Get all transactions
    public List<Transaction> getAllTransactions(){
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                list.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getString("action"),
                        rs.getDate("date").toLocalDate()
                ));
            }
        } catch (SQLException e){
            System.out.println("Error fetching transactions: " + e.getMessage());
        }
        return list;
    }

    // Get transaction for one user
    public List<Transaction> getTransactionsByUser(int userId){
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                list.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getString("action"),
                        rs.getDate("date").toLocalDate()
                ));
            }
        } catch (SQLException e){
            System.out.println("Error fetching user transactions: " + e.getMessage());
        }
        return list;
    }
}
