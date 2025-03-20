package model;
import java.sql.*;

@FunctionalInterface
public interface ResultSetHandler<T> {
    T handle(ResultSet rs) throws SQLException;
}
