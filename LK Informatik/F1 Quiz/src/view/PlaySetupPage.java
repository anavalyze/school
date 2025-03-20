package view;

import controller.Game;
import model.Question;
import model.User;

import javax.swing.*;
import java.awt.*;

public class PlaySetupPage extends JPanel {
    private static PlaySetupPage instance; // Static reference
    private JButton modeOneButton;
    private JButton modeTwoButton;
    private Game game;


    public PlaySetupPage(JPanel containerPanel, CardLayout cardLayout) {
        instance = this; // Assign the static instance

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Setup", JLabel.CENTER);
        add(label, BorderLayout.NORTH);


        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between buttons

        modeOneButton = new JButton("Guess drivers champion by year");
        modeTwoButton = new JButton("Guess Constructors champion by year");

        JSlider slider = new JSlider(5, 25, 10);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel numberLabel = new JLabel("Number of Questions:");


        gbc.gridx = 0;
        gbc.gridy = 0;
        outerPanel.add(numberLabel, JLabel.CENTER);

        gbc.gridy = 1;
        outerPanel.add(slider, gbc);

        gbc.gridy = 2;
        outerPanel.add(modeOneButton, gbc);

        gbc.gridy = 3;
        outerPanel.add(modeTwoButton, gbc);

        add(outerPanel);


        modeOneButton.addActionListener(e -> new Game(User.user, slider.getValue(), Question.driverChampionQuestion(), containerPanel, cardLayout).start());



        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton switchButton = new JButton("Back");
        switchButton.addActionListener(e -> cardLayout.show(containerPanel, "Home"));
        bottom.add(switchButton);
        add(bottom, BorderLayout.SOUTH);
    }


}