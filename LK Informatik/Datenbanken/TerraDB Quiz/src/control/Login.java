package control;
import control.*;
import model.User;
import view.PageSwitcher;
import view.SecondPage;

import java.awt.*;

public class Login {

    public static boolean loginAttempt(String username, String password){
        System.out.println("Attempting login for: " + username);
        User user = User.lookForUser(username, password);

        if (user == null) {
            System.out.println("User not found in database.");
            return false;
        }

        if(user.getUsername() != null){
            System.out.println("Login success");
            return true;
        }
        System.out.println("Login failed!");
        return false;
    }

    public static boolean signUp(String username, String password){
        System.out.println("Attempting sign up for: " + username);
        User user = User.lookForUser(username, password);
        if (user == null) {
            System.out.println("Creating user...");
            User.addUser(username, password);
            System.out.println("User created!");
            SecondPage.showMessage("works!", Color.GREEN);
            return true;
        }

        if(user.getUsername() != null){
            System.out.println("User already exists");
            SecondPage.showMessage("dosnt works!", Color.GREEN);
            return false;
        }
        System.out.println("Sign-up failed!");
        return false;
    }

}
