package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementHandler {
    void handle(PreparedStatement pstmt) throws SQLException;
}
