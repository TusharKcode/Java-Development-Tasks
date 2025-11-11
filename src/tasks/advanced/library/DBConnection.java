package tasks.advanced.library;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to: " + conn.getCatalog());
            return conn;
        } catch (Exception e){
            throw new RuntimeException("Database Connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();

        if (conn != null){
            System.out.println("Database connected successfully");
        } else {
            System.out.println("Database connection failed");
        }
    }
}
