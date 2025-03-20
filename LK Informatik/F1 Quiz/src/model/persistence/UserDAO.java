package model.persistence;
import model.*;

import java.sql.*;

public class UserDAO {

    public static User readForUser(String username, String password) {
        String query = "SELECT Username, Password FROM users WHERE Username = ? AND Password = ?";
        return MariaDB.runQuery(query, ptsmt -> {
            ptsmt.setString(1, username);
            ptsmt.setString(2, password);
        }, rs -> rs.next() ? new User(rs.getString("Username"), rs.getString("Password")) : null);
    }

    public static boolean createNewUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        return MariaDB.runUpdate(query, pstmt -> {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
        });
    }

}
