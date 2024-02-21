package Totorial.RPG.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJdbc {
    public Connection connection;
    public Statement statement;
    PreparedStatement preparedStatement;
    String query;
    ResultSet resultSet;
    int pinId;

    public MyJdbc() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg_users", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void singUp(String userName, String userEmail, String password) {
        try {
            query = "INSERT INTO users (userName, userEmail, userPassword) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userEmail);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            System.out.println("Insert complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void joinIn(String userName, String pinGame) {
        try {
            query = "INSERT INTO game (userName, pinGame) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pinGame);
            preparedStatement.executeUpdate();
            System.out.println("insert complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void isEmptyTable() {
        try {
            String question = " ";
            String answer = " ";

            query = "SELECT COUNT(*) FROM answers";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                if (rowCount > 0) {
                    System.out.println("in table exist any records");
                } else {
                    query = "INSERT INTO question (question) VALUES (?)";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, question);
                    preparedStatement.executeUpdate();
                    query = "INSERT INTO answers (question, answer) VALUES (?, ?)";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, question);
                    preparedStatement.setString(2, answer);
                    preparedStatement.executeUpdate();
                    System.out.println("spaces was inserted");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertQuestion(String questionField) {
        try {
            query = "INSERT INTO question (question) VALUES (?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, questionField);
            preparedStatement.executeUpdate();
            System.out.println("question was inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertAnswer(String question, String answers, String result, String gamePin) {
        try {
            query = "INSERT INTO answers (question, answer, result, gamePin) values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answers);
            preparedStatement.setString(3, result);
            preparedStatement.setString(4, gamePin);
            preparedStatement.executeUpdate();
            System.out.println("answers was inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createGame(String pinGame) {
        try {
            int pinId = increaseId() + 1;
            query = "INSERT INTO pincode (pinId, gamePin) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pinId);
            preparedStatement.setString(2, pinGame);
            preparedStatement.executeUpdate();
            System.out.println("pincode was inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int increaseId() {
        try {
            query = "SELECT MAX(pinId) FROM pincode";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pinId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pinId;
    }

    public List<String> extractAnswers() {
        List<String> answers = new ArrayList<>();
        try {
            query = "SELECT answer FROM answers ORDER BY question ASC";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                while (resultSet.next()) {
                    String answer = resultSet.getString("answer");
                    answers.add(answer);
                }
            } else {
                System.out.println("There are no answers in the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    public List<String> extractQuestions() {
        List<String> questions = new ArrayList<>();
        try {
            query = "SELECT * FROM question";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                while (resultSet.next()) {
                    String question = resultSet.getString("question");
                    questions.add(question);
                }
            } else {
                System.out.println("There are no questions in the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void deleteLastRecords(String question) {
        try {
            query = "DELETE FROM answers WHERE question = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, question);
            preparedStatement.executeUpdate();
            String query1 = "DELETE FROM question WHERE question = ?";
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, question);
            preparedStatement.executeUpdate();
            String query2 = "DELETE FROM pincode ORDER BY pinId DESC LIMIT 1";
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean typeOfAnswers() {
        return false;
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            query = "SELECT COUNT(*) FROM answers";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                if (rowCount == 0) {
                    isEmpty = true;
                } else {
                    // Handle the case when there are no rows in the result set
                    System.out.println("No rows in the result set.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isEmpty;
    }

    public boolean pinCode(String gamePin) {
        boolean verified = false;
        try {
            query = "SELECT * FROM pincode WHERE gamePin = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gamePin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                verified = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verified;
    }

    public boolean signIn(String userName, String password) {
        boolean verified = false;
        try {
            query = "SELECT * FROM users WHERE userName = ? AND userPassword = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                verified = true;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verified;
    }

   /* public boolean joinInGame(String gamePin) {
        boolean verified = false;
        try {
            query = "SELECT question FROM question WHERE gamePin = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gamePin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                verified = true;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verified;
    }*/
}