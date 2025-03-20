package view;

import controller.*;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private static LoginPage instance; // Static reference
    private JPanel center;
    private JLabel messageLabel; // Store message label
    private Timer messageTimer;

    public LoginPage(JPanel containerPanel, CardLayout cardLayout) {
        instance = this; // Assign the static instance

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Login", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        Dimension textFieldSize = new Dimension(150, 25);

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        center.add(new JLabel("Username: "), gbc);

        // Username TextField
        gbc.gridx = 1;
        JTextField usernameTF = new JTextField();
        usernameTF.setPreferredSize(textFieldSize);
        center.add(usernameTF, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        center.add(new JLabel("Password: "), gbc);

        // Password TextField
        gbc.gridx = 1;
        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setPreferredSize(textFieldSize);
        center.add(passwordTF, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> LoginController.login(usernameTF.getText(), new String(passwordTF.getPassword())));
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> LoginController.signUp(usernameTF.getText(), new String(passwordTF.getPassword())));

        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across columns
        center.add(buttonPanel, gbc);

        // Message Label (Below Buttons)
        gbc.gridx = 0;
        gbc.gridy = 3; // Below buttons
        gbc.gridwidth = 2;
        messageLabel = new JLabel(" "); // Initially empty
        center.add(messageLabel, gbc);

        add(center, BorderLayout.CENTER);

        // Bottom panel for back button
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton switchButton = new JButton("Back");
        switchButton.addActionListener(e -> cardLayout.show(containerPanel, "Home"));
        bottom.add(switchButton);
        add(bottom, BorderLayout.SOUTH);
    }


    //Static method to update the message label from anywhere with custom color

    public static void showMessage(String text, Color color) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                instance.messageLabel.setText(text);
                instance.messageLabel.setForeground(color);

                // If a previous timer exists, stop it before starting a new one
                if (instance.messageTimer != null && instance.messageTimer.isRunning()) {
                    instance.messageTimer.stop();
                }

                // Create a new timer to clear the message after 1 second (1000ms)
                instance.messageTimer = new Timer(1000, e -> instance.messageLabel.setText(""));
                instance.messageTimer.setRepeats(false); // Only run once
                instance.messageTimer.start();
            });
        } else {
            System.err.println("LoginPage instance is not initialized yet.");
        }
    }
}
