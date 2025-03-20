package view;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    public HomePage(JPanel containerPanel, CardLayout cardLayout) {
        // Set the layout to BorderLayout for the main panel
        setLayout(new BorderLayout());

        // Create a label at the top and add it to the North
        JLabel label = new JLabel("Home Page", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        // Create a container panel with GridBagLayout to stack buttons vertically
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // Add spacing between buttons

        // Create buttons
        JButton playButton = new JButton("Play");
        JButton loginButton = new JButton("Login");
        JButton statsButton = new JButton("Highscores");

        // Set button size to a smaller dimension
        Dimension buttonSize = new Dimension(200, 40);  // Width 200px, Height 40px
        playButton.setPreferredSize(buttonSize);
        loginButton.setPreferredSize(buttonSize);
        statsButton.setPreferredSize(buttonSize);

        // Add action listeners
        playButton.addActionListener(e -> cardLayout.show(containerPanel, "Setup"));
        loginButton.addActionListener(e -> cardLayout.show(containerPanel, "LoginPage"));
        statsButton.addActionListener(e -> cardLayout.show(containerPanel, "Third"));

        // Add buttons to the button panel with proper constraints
        gbc.gridy = 0;
        buttonPanel.add(playButton, gbc);

        gbc.gridy = 1;
        buttonPanel.add(loginButton, gbc);

        gbc.gridy = 2;
        buttonPanel.add(statsButton, gbc);

        // Center the button panel and add it to the center of the main panel
        add(buttonPanel, BorderLayout.CENTER);
    }
}
