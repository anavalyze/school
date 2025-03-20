package controller;

import model.Question;
import model.QuestionType;
import model.User;
import view.PageSwitcher;
import view.PlayPage;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game game;
    private Question question;
    private int length;
    private User user;
    private Question questionType;
    private CardLayout cardLayout;
    private JPanel containerPanel;

    public Game(User user, int length, Question questionType, JPanel containerPanel, CardLayout cardLayout) {
        this.user = user;
        this.length = length;
        this.questionType = questionType;
        this.containerPanel = containerPanel;
        this.cardLayout = cardLayout;
    }


    public void start(){
        game = this;
        cardLayout.show(containerPanel, "Play");
        question = Question.driverChampionQuestion();
        PlayPage.showMessage(question.question);
        PlayPage.tlbMessage(question.correctAnswer);
        PlayPage.trbMessage(question.wrongAnswer[0]);
        PlayPage.blbMessage(question.wrongAnswer[1]);
        PlayPage.brbMessage(question.wrongAnswer[2]);

    }

    public void nextQuestion(){

    }

    public void end(){

    }
}
