package model;

import model.persistence.QuestionDAO;

public class Question {
    public String question;
    public String correctAnswer;
    public String[] wrongAnswer;
    String[] drivers = {"Lewis Hamilton", "Sebastian Vettel", "Charles Leclerc"};

    public Question(String question, String correctAnswer, String[] wrongAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public Question(){
        this.question = "Who was drivers chamption in 20221?";
        this.correctAnswer = "Max Verstappen";
        this.wrongAnswer = drivers;
    }


    public static Question driverChampionQuestion(){
        int year = 1950 + (int) (Math.random() * (2025 - 1950));
        String question = "Who won the drivers championship in " + year + "?";
        String correctAnswer = QuestionDAO.winnerByYear(year);
        String[] wrongAnswer = {QuestionDAO.randomDriverByYear(year), QuestionDAO.randomDriverByYear(year), QuestionDAO.randomDriverByYear(year)};
        return new Question(question, correctAnswer, wrongAnswer);

    }



}
