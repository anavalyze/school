package model;

public class User {
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public static User getUser(int id){
        String query = "SELECT users.Username AS username, users.Password AS password " +
                "FROM users " +
                "WHERE ID = ?";

        return MariaDB.runQuery(query, ptsmt -> ptsmt.setInt(1,id),  rs -> rs.next() ?
                new User(rs.getString("username"), rs.getString("password")) : null);
    }

    public static User lookForUser(String username, String password) {
        String query = "SELECT Username, Password FROM users WHERE Username = ? AND Password = ?";

        return MariaDB.runQuery(query, ptsmt -> {
            ptsmt.setString(1, username);
            ptsmt.setString(2, password);
        }, rs -> rs.next() ? new User(rs.getString("Username"), rs.getString("Password")) : null);
    }

    public static boolean addUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        return MariaDB.runUpdate(query, pstmt -> {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
        });
    }


}
