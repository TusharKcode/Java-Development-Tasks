package tasks.advanced.library.dao;

import tasks.advanced.library.DBConnection;
import tasks.advanced.library.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Add a new user
    public void addUser(User user){
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            stmt.executeUpdate();
            System.out.println("User added successfully!");

        } catch (SQLException e){
            System.out.println("Failed to add user: " + e.getMessage());
        }
    }

    // Get all users
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e){
            System.out.println("Error fetching users: " + e.getMessage());
        }
        return list;
    }

    // Find users by ID
    public User getUserById(int id){
        String sql = "SELECT * FROM users WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e){
            System.out.println("Error finding user: " + e.getMessage());
        }
        return null;
    }

    // Update user info
    public void updateUser(User user){
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            System.out.println("User updated!");

        } catch (SQLException e){
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    // Delete user
    public void deleteUser(int id){
        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("User deleted!");

        } catch (SQLException e){
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}
