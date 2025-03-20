package controller;

import model.User;
import model.persistence.UserDAO;
import view.*;

import java.awt.*;

public class LoginController {

    public static void login(String username, String password){
        try{
            User.user.setUsername(UserDAO.readForUser(username, password).getUsername());
            User.user.setPassword(UserDAO.readForUser(username, password).getPassword());
            LoginPage.showMessage("Login successful!", Color.GREEN);
        }catch(NullPointerException npe){
            LoginPage.showMessage("Login failed!", Color.RED);
        }
    }

    public static void signUp(String username, String password){
        try{
            UserDAO.readForUser(username, password).getUsername();
            LoginPage.showMessage("User already exists!", Color.RED);
        }catch(NullPointerException npe){
            UserDAO.createNewUser(username, password);
            User.user = new User(username, password);
            LoginPage.showMessage("User created!", Color.GREEN);
        }
    }

}
