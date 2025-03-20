package model;
import java.sql.*;

@FunctionalInterface
public interface StatementHandler {
    void handle(PreparedStatement pstmt) throws SQLException;
}
