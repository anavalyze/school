package model.persistence;

import model.ResultSetHandler;
import model.StatementHandler;

import java.sql.*;

public class MariaDB {
    /*
    private static final String URL = "jdbc:mariadb://10.0.41.8:3306/Datenbank9";
    private static final String USER = "nutzer9";
    private static final String PASSWORD = "DBr5ye8T";
    */

    private static final String URL = "jdbc:mariadb://192.168.178.57:3306/quiz";
    private static final String USER = "user";
    private static final String PASSWORD = "12345";

    private static Connection conn;

    public MariaDB(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public static boolean runUpdate(String query, StatementHandler handler) {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            handler.handle(pstmt); // Apply the lambda function to set parameters
            return pstmt.executeUpdate() > 0; // True if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}