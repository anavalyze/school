package model;

import model.persistence.QuestionDAO;

public class QuestionType {

    public static Question driverChamptionQuestion(){
        int year = 1950 + (int) (Math.random() * (2025 - 1950));
        String question = "Who won the drivers championship in " + year + "?";
        String correctAnswer = QuestionDAO.winnerByYear(year);
        String[] wrongAnswer = {QuestionDAO.randomDriverByYear(year), QuestionDAO.randomDriverByYear(year), QuestionDAO.randomDriverByYear(year)};
        return new Question(question, correctAnswer, wrongAnswer);

    }


}
