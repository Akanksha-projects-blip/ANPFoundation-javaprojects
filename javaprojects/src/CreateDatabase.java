import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    // Database connection details (connect to an existing database like 'mysql' or 'information_schema')
    static final String DB_URL = "jdbc:mysql://localhost:3306/"; // Connect to the server, not a specific database initially
    static final String USER = "root"; // Your MySQL username
    static final String PASS = "akankshavadvale"; // Your MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String newDatabaseName = "MyNewDatabase"; // The name of the database to be created

        try {
            // Register JDBC driver (optional for newer JDBC versions, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the MySQL server
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a Statement object
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // SQL statement to create the database
            String sql = "CREATE DATABASE " + newDatabaseName;

            // Execute the SQL statement
            System.out.println("Executing SQL: " + sql);
            stmt.executeUpdate(sql);
            System.out.println("Database '" + newDatabaseName + "' created successfully...");

        } catch (SQLException se) {
            // Handle JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are closed even if errors occur
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // Nothing to do
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}