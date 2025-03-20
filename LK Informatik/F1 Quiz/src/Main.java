import model.persistence.MariaDB;
import model.persistence.QuestionDAO;
import view.PageSwitcher;
import model.*;
import javax.swing.*;

public class Main {


    private static final String URL = "jdbc:mariadb://10.0.41.8:3306/Datenbank9";
    private static final String USER = "nutzer9";
    private static final String PASSWORD = "ananas12345";


/*
    private static final String URL = "jdbc:mariadb://192.168.178.57:3306/quiz";
    private static final String USER = "user";
    private static final String PASSWORD = "12345";
*/

    public static void main(String[] args){
        MariaDB db = new MariaDB(URL, USER, PASSWORD);


        System.out.println(QuestionDAO.randomDriverByYear(1955));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PageSwitcher();
            }
        });







    }
}
