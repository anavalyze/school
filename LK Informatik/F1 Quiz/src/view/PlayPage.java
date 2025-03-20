package view;

import controller.PlayController;
import model.Question;

import javax.swing.*;
import java.awt.*;

public class PlayPage extends JPanel {
    private static PlayPage instance; // Static reference
    private JLabel question; // Store message label
    private JButton topleftButton;
    private JButton toprightButton;
    private JButton bottomleftButton;
    private JButton bottomrightButton;

    public PlayPage(JPanel containerPanel, CardLayout cardLayout) {
        instance = this; // Assign the static instance

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Play", JLabel.CENTER);
        add(label, BorderLayout.NORTH);




        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new GridBagLayout());
        GridBagConstraints ogbc = new GridBagConstraints();
        ogbc.fill = GridBagConstraints.HORIZONTAL;
        ogbc.insets = new Insets(10, 10, 10, 10); // Add spacing between buttons


        JPanel questionPanel = new JPanel();
        question = new JLabel("Question", JLabel.CENTER);
        questionPanel.add(question, CENTER_ALIGNMENT);





        // Create a container panel with GridBagLayout to stack buttons vertically
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between buttons

        // Create buttons
        topleftButton = new JButton("");
        toprightButton = new JButton("");
        bottomleftButton = new JButton("");
        bottomrightButton = new JButton("");

        // Set button size to a smaller dimension
        Dimension buttonSize = new Dimension(200, 100);
        topleftButton.setPreferredSize(buttonSize);
        toprightButton.setPreferredSize(buttonSize);
        bottomleftButton.setPreferredSize(buttonSize);
        bottomrightButton.setPreferredSize(buttonSize);

        // Add action listeners
        //topleftButton.addActionListener(e -> PlayController.nextQuestion(new Question()));




        // Add buttons to the button panel with proper constraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(topleftButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(toprightButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(bottomleftButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonPanel.add(bottomrightButton, gbc);

        // Center the button panel and add it to the center of the main panel
        //add(buttonPanel, BorderLayout.CENTER);
        ogbc.gridx = 0; // Ensure it remains in the first column
        ogbc.gridy = 0;
        outerPanel.add(questionPanel, ogbc); // Pass ogbc explicitly

        ogbc.gridx = 0; // Ensure it remains in the first column
        ogbc.gridy = 1;
        outerPanel.add(buttonPanel, ogbc); // Pass ogbc explicitly


        add(outerPanel, BorderLayout.CENTER);





        // Bottom panel for back button
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton switchButton = new JButton("Back");
        switchButton.addActionListener(e -> cardLayout.show(containerPanel, "Home"));
        bottom.add(switchButton);
        add(bottom, BorderLayout.SOUTH);
    }


    //Static method to update the message label from anywhere with custom color

    public static void showMessage(String text) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                instance.question.setText(text);
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }



    public static void tlbMessage(String text/*, Color color*/) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                instance.topleftButton.setText(text);
                //instance.topleftButton.setBackground(color);
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }
    public static void trbMessage(String text) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                System.out.println(text);
                instance.toprightButton.setText(text);
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }
    public static void blbMessage(String text) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                instance.bottomleftButton.setText(text);
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }
    public static void brbMessage(String text) {
        if (instance != null) {
            SwingUtilities.invokeLater(() -> {
                instance.bottomrightButton.setText(text);
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }
}
