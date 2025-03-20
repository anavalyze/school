package model.persistence;
import model.Question;
import model.User;

public class QuestionDAO {


    public static String randomDriver() {
        String query = "SELECT name FROM driver ORDER BY RAND() LIMIT 1";

        return MariaDB.runQuery(query, rs -> rs.next() ? rs.getString("name") : null);
    }

    public static String randomWinner() {
        String query = """
                SELECT driver.name FROM driver
                INNER JOIN race_driver_standing
                ON driver.id = race_driver_standing.driver_id
                WHERE race_driver_standing.position_number = 1
                ORDER BY RAND()
                LIMIT 1;
                """;
        return MariaDB.runQuery(query, rs -> rs.next() ? rs.getString("name") : null);
    }

    public static String winnerByYear(int year) {
        String query = """
                SELECT driver.name
                FROM driver
                INNER JOIN race_driver_standing ON driver.id = race_driver_standing.driver_id
                INNER JOIN race ON race_driver_standing.race_id = race.id
                WHERE race_driver_standing.position_number = 1
                AND race.year = ?;
                                
                """;
        return MariaDB.runQuery(query, pstmt -> {
            pstmt.setInt(1, year);
        }, rs -> rs.next() ? rs.getString("name") : null);
    }

    public static String randomDriverByYear(int year) {
        String query = """
                SELECT driver.name
                FROM driver
                INNER JOIN race_driver_standing ON driver.id = race_driver_standing.driver_id
                INNER JOIN race ON race_driver_standing.race_id = race.id
                WHERE race.year = ?
                ORDER BY RAND()
                LIMIT 1;
                """;
        return MariaDB.runQuery(query, pstmt -> {
            pstmt.setInt(1, year);
        }, rs -> rs.next() ? rs.getString("name") : null);
    }




}
