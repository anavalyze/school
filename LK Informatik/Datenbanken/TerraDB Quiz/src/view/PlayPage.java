package view;

import control.Login;

import javax.swing.*;
import java.awt.*;

public class PlayPage extends JPanel {
    private static PlayPage instance; // Static reference
    private JPanel center;
    private JLabel messageLabel; // Store message label

    public PlayPage(JPanel containerPanel, CardLayout cardLayout) {
        instance = this; // Assign the static instance

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Play", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        Dimension textFieldSize = new Dimension(150, 25);



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
            });
        } else {
            System.err.println("SecondPage instance is not initialized yet.");
        }
    }
}
