package dao;

import entity.Admin;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    private static final String SELECT_ALL_QUESTION = "SELECT id, topic, ques, answer1, answer2, answer3, answerCorrect FROM Question";
    private static final String CREATE_QUESTION = "INSERT INTO Question (topic, ques, answer1, answer2, answer3, answerCorrect) VALUES (?, ?, ?, ?, ?, ?)";
      private static final String DELETE_Question_SQL = "DELETE FROM Question WHERE id=?";

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTION); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setTopic(resultSet.getString("topic"));
                question.setQues(resultSet.getString("ques"));
                question.setAnswer1(resultSet.getString("answer1"));
                question.setAnswer2(resultSet.getString("answer2"));
                question.setAnswer3(resultSet.getString("answer3"));
                question.setAnswerCorrect(resultSet.getString("answerCorrect"));
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public boolean addQuestion(Question question) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUESTION)) {

            preparedStatement.setString(1, question.getTopic());
            preparedStatement.setString(2, question.getQues());
            preparedStatement.setString(3, question.getAnswer1());
            preparedStatement.setString(4, question.getAnswer2());
            preparedStatement.setString(5, question.getAnswer3());
            preparedStatement.setString(6, question.getAnswerCorrect());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
      public boolean deleteQuestion(Integer id) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Question_SQL)) {
            preparedStatement.setInt(1, id); 
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
