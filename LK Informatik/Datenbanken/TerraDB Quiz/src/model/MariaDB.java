package model;
import java.sql.*;

public class MariaDB {
    private static Connection conn;

    public MariaDB(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    // Generic query execution method
    public static <T> T runQuery(String query, ResultSetHandler<T> handler) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return handler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T runQuery(String query, StatementHandler statementHandler, ResultSetHandler<T> resultSetHandler) {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            statementHandler.handle(pstmt); // Set parameters here
            try (ResultSet rs = pstmt.executeQuery()) {
                return resultSetHandler.handle(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 🎯 Get a question for guessing a capital city
    public Question getGuessCapitalQuestion() {
        String query = "SELECT land.Name AS country, ort.Name AS capital " +
                "FROM land INNER JOIN ort ON land.HauptONR = ort.ONR " +
                "ORDER BY RAND() LIMIT 1";

        return runQuery(query, rs -> rs.next() ?
                new Question("What is the capital of " + rs.getString("country") + "?", rs.getString("capital")) : null);
    }

    // 🎯 Get a question for guessing where a river is located
    public Question getGuessPopulationQuestion() {
        String query = "SELECT land.Einwohner AS population, land.Name AS country " +
                "FROM land " +
                "ORDER BY RAND() LIMIT 1";

        return runQuery(query, rs -> rs.next() ?
                new Question("What is the population of " + rs.getString("country") + "?", rs.getString("population") + " Million") : null);
    }


    public static boolean runUpdate(String query, StatementHandler handler) {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            handler.handle(pstmt); // Apply the lambda function to set parameters
            return pstmt.executeUpdate() > 0; // True if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    // Close the connection when done
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
