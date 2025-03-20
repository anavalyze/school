import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import model.*;
import view.*;

import javax.swing.*;
import java.util.Scanner;


public class Main {

    //private static final String URL = "jdbc:mariadb://10.0.41.8:3306/Datenbank9";
    private static final String URL = "jdbc:mariadb://192.168.178.57:3306/quiz";
    //private static final String USER = "nutzer9";
    private static final String USER = "user";
    //private static final String PASSWORD = "ananas12345";
    private static final String PASSWORD = "12345";


    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        MariaDB db = new MariaDB(URL, USER, PASSWORD);

/*
        // Generate a "Guess the Capital" question
        Question capitalQuestion = db.getGuessCapitalQuestion();
        System.out.println(capitalQuestion != null ? capitalQuestion : "No data found.");

        // Generate a "Guess the River Location" question
        Question riverQuestion = db.getGuessPopulationQuestion();
        System.out.println(riverQuestion != null ? riverQuestion : "No data found.");

*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PageSwitcher();
            }
        });






        //db.close(); // Close connection when done
    }
}
