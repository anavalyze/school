package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;

import javax.swing.*;
import java.awt.*;

public class PageSwitcher {

    private CardLayout cardLayout;
    private JPanel containerPanel;
    private static boolean isDarkMode = false; // Track current theme

    public PageSwitcher() {
        // Set initial theme
        try {
            UIManager.setLookAndFeel(new FlatArcIJTheme()); // Default Light Theme
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a JFrame for the main window
        JFrame frame = new JFrame("TerraDB Quiz");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center the window

        // Set up the CardLayout and container panel
        cardLayout = new CardLayout();
        containerPanel = new JPanel(cardLayout);

        // Add pages (panels) to the container
        containerPanel.add(new HomePage(containerPanel, cardLayout), "Home");
        containerPanel.add(new PlayPage(containerPanel, cardLayout), "Play");
        containerPanel.add(new SecondPage(containerPanel, cardLayout), "Second");
        containerPanel.add(new ThirdPage(containerPanel, cardLayout), "Third");

        // Add the container panel to the frame
        frame.add(containerPanel, BorderLayout.CENTER);

        // Create a theme switcher button
        JButton themeButton = new JButton("Switch Theme");
        themeButton.addActionListener(e -> switchTheme(frame)); // Call switchTheme method

        // Add the theme switcher button at the bottom
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(themeButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void switchTheme(JFrame frame) {
        try {
            if (isDarkMode) {
                UIManager.setLookAndFeel(new FlatArcIJTheme()); // Switch to Light Mode
            } else {
                UIManager.setLookAndFeel(new FlatDarculaLaf()); // Switch to Dark Mode
            }
            isDarkMode = !isDarkMode; // Toggle the mode

            // Refresh the UI
            SwingUtilities.updateComponentTreeUI(frame);
            frame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
