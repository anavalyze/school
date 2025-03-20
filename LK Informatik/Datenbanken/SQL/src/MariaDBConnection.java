import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDBConnection {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mariadb://192.168.178.57:3306/quiz"; // Replace with your actual IP and database name
        String user = "user"; // Use your actual database username
        String password = "12345"; // Use your actual password (default is empty in XAMPP)

        try {
            // Load MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MariaDB successfully!");

            // Create statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Print results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("users.name"));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
