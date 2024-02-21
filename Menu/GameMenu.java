package Totorial.RPG.Menu;

import Totorial.RPG.GamePanel;
import Totorial.RPG.Keys;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu extends JPanel {
    private static final Font font = new Font("Sans-serif", Font.BOLD, 15);
    private final int maxLengthOfAnswer = 300;
    public String[] answers = new String[5];
    public JFrame frame;
    public JPanel panel;
    public JPanel answerPanel;
    public JButton addButton;
    public JTextArea nameFieldForJoin = fields(80, 145, 250, 30);
    public JTextArea pinFieldForJoin = fields(80, 225, 250, 30);
    public JTextArea questionField = fields(10, 55, 645, 85);
    public JTextArea answerField = fields(10, 570, 655, 85);
    public JTextArea nameFieldForSignIn = fields(80, 145, 250, 30);
    public JTextArea nameFieldForSignUp = fields(80, 135, 250, 30);
    public JTextArea emailFieldForSingUp = fields(80, 365, 250, 30);
    public JButton closeButton;
    public JButton addQuestion = new JButton();
    public JTextArea[] answerText = new JTextArea[6];
    public JTextArea answerTextArea;
    public int currentIndex = 0;
    public String result = "false";
    public JLabel nrCharInAnswerLabel = new JLabel("0/300");
    public JLabel nrCharInQuestionLabel = new JLabel("0/300");
    public int nr = 0;
    public char[] c = new char[10];
    public String pinGame = pinGame();
    GamePanel gp = new GamePanel();
    Keys keys = new Keys(gp);
    MyJdbc myJdbc = new MyJdbc();
    JPasswordField passwordField;
    public JPasswordField passwordFieldForSingIn = passwordField(225);
    public JPasswordField passwordFieldForSingUp = passwordField(215);
    //JOIN IN OTHER GAME
    public JPasswordField re_passwordFieldForSingUp = passwordField(290);
    JTextArea textArea;
    public JTextArea joinTextMenu = texts(70, 50, 300, 30, "JOIN IN A GAME");

    public JTextArea textName = texts(170, 115, 300, 30, "USERNAME");
    public JTextArea textPin = texts(185, 195, 300, 30, "PIN");
    //CRETE YOUR OWN GAME
    public JTextArea createMenuText = texts(20, 5, 300, 30, "CREATE YOUR OWN GAME QUESTIONS");
    public JTextArea writeQuestion = texts(20, 35, 300, 20, "WRITE YOUR QUESTION : ");
    public JTextArea nrQuestions = texts(220, 35, 150, 20, String.valueOf(nr) + " / 32");
    //SIGN IN
    public JTextArea signInText = texts(70, 50, 350, 30, "SIGN IN");
    public JTextArea textNameForSingIn = texts(170, 115, 200, 30, "USERNAME");
    public JTextArea textPasswordForSignIn = texts(155, 195, 200, 30, "PASSWORD");
    //SIGN UP
    public JTextArea signUpText = texts(70, 45, 300, 30, "SIGN UP");
    public JTextArea textNameForSingUp = texts(170, 105, 200, 30, "NAME");
    public JTextArea passwordTextForSignUp = texts(145, 185, 200, 30, "PASSWORD");
    public JTextArea re_passwordTextForSignUp = texts(145, 255, 200, 30, "RE-PASSWORD");
    public JTextArea emailForSignUp = texts(145, 330, 300, 30, "EMAIL");
    public final JTextArea instruction = texts(55, 675, 350, 25, "<- false true ->");
    JButton button;

    public GameMenu(int x, int y, int width, int height) {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(20, 82, 20));
        panel.setBounds(10, 10, width - 20, height - 20);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setUndecorated(true);
        frame.setLayout(null);
        //frame.setAlwaysOnTop(true);
        frame.getContentPane().setBackground(new Color(26, 26, 0));
        frame.setVisible(true);
    }

    private JCheckBox box() {
        checkBox = new JCheckBox();
        checkBox.setBorder(null);
        checkBox.setFont(font);
        checkBox.setText("show");
        checkBox.setFocusable(false);
        checkBox.setBounds(360, 225, 80, 30);
        checkBox.setBackground(new Color(20, 82, 20));
        checkBox.setForeground(Color.white);
        checkBox.setSelected(false);
        checkBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (checkBox.isSelected()) {
                    passwordFieldForSingIn.setEchoChar((char) 0);
                    passwordFieldForSingUp.setEchoChar((char) 0);
                    re_passwordFieldForSingUp.setEchoChar((char) 0);
                    checkBox.setText("hide");
                } else {
                    passwordFieldForSingIn.setEchoChar('*');
                    passwordFieldForSingUp.setEchoChar('*');
                    re_passwordFieldForSingUp.setEchoChar('*');
                    checkBox.setText("show");
                }
            }
        });
        return checkBox;
    }

    private JTextArea fields(int x, int y, int width, int height) {
        JTextArea textField = new JTextArea(100, 100);
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setBounds(x, y, width, height);
        textField.setFont(font);
        textField.setBorder(new LineBorder(new Color(26, 26, 0), 3));
        textField.setEditable(true);
        textField.setBackground(new Color(102, 255, 153));
        textField.setForeground(Color.BLACK);
        return textField;
    }

    public boolean isEmail(String email) {
        String sPattern = "^[A-Za-z0-9+.]+@(.+)$";
        Pattern p = Pattern.compile(sPattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private JPasswordField passwordField(int y) {
        passwordField = new JPasswordField();
        passwordField = new JPasswordField();
        passwordField.setBounds(80, y, 250, 30);
        passwordField.setBorder(new LineBorder(new Color(26, 26, 0), 3));
        passwordField.setBackground(new Color(102, 255, 153));
        passwordField.setForeground(Color.BLACK);
        passwordField.setEchoChar('*');
        return passwordField;
    }

    public void addQuestionButton(){
        addQuestion = buttons(655, 55, 65, 85, "\u002B");
        addQuestion.addActionListener(q -> {
            String question = questionField.getText();
            if (question.isEmpty()) {
                createMenuText.setText("Question field cannot be empty");
                questionField.setBackground(keys.warningColor);
            } else if (currentIndex < 2) {
                createMenuText.setText("Question can have from 2 to 5 answers");
                answerField.setBackground(keys.warningColor);
            } else {
                questionField.setText("");
                panel.remove(answerField);
                panel.remove(addButton);
                panel.remove(answerPanel);
                panel.remove(instruction);
                panel.remove(nrCharInAnswerLabel);
                panel.revalidate();
                panel.repaint();
                createMenuText.setText("CREATE YOUR OWN GAME QUESTIONS");
                answerPanel.removeAll();
                answerPanel.revalidate();
                answerPanel.repaint();
                nr += 1;
                nrQuestions.setText(nr + " /35");
                if (nr == 35) {
                    frame.setVisible(false);
                    keys.additionalWindow("You reached the maximum number of question", pinGame);
                }
                while (currentIndex < 5) {
                    myJdbc.insertAnswer(question, null, null, pinGame);
                    currentIndex++;
                }
            }
        });
    }
    public void addAnswers(int y) {
        answerPanel = new JPanel();
        answerPanel.setLayout(null);
        answerPanel.setBackground(new Color(20, 82, 20));
        answerPanel.setBounds(10, 140, 710, 430);
        nrCharInAnswerLabel.setForeground(Color.white);
        nrCharInAnswerLabel.setBounds(675, 650, 250, 20);
        panel.add(nrCharInAnswerLabel);
        panel.add(answerPanel);
        panel.add(answerField);
        panel.add(instruction);
        answerField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                countLength();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                countLength();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                countLength();
            }

            private void countLength() {
                String text = answerField.getText();
                int length = text.length();
                nrCharInAnswerLabel.setText(length + "/300");
            }
        });
        AbstractDocument document = (AbstractDocument) answerField.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= maxLengthOfAnswer) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int overLimit = (currentLength + text.length()) - maxLengthOfAnswer;
                if (overLimit <= 0) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    String trimmedText = text.substring(0, text.length() - overLimit);
                    super.replace(fb, offset, length, trimmedText, attrs);
                }
            }
        });
        addButton = buttons(665, 570, 50, 85, "↵");
        addButton.addActionListener(a -> {
            if (answerField.getText().isEmpty()) {
                createMenuText.setText("Answer field cannot be empty");
                answerField.setBackground(new Color(225, 80, 80));
            } else {
                if (currentIndex < answers.length) {
                    String answer = answerField.getText();
                    String question = questionField.getText();
                    answers[currentIndex] = answer;
                    answerTextArea = new JTextArea(answer, 200, 200);
                    answerTextArea.setWrapStyleWord(true);
                    answerTextArea.setLineWrap(true);
                    answerTextArea.setBackground(new Color(20, 82, 20));
                    answerTextArea.setForeground(Color.white);
                    answerTextArea.setBounds(20, y + (currentIndex * 90), 655, 90);
                    answerTextArea.setFont(new Font(null, Font.PLAIN, 15));
                    answerText[currentIndex] = answerTextArea;
                    JCheckBox wrongAnswer = new JCheckBox();
                    JCheckBox correctAnswer = new JCheckBox();
                    correctAnswer.setBackground(new Color(20, 82, 20));
                    wrongAnswer.setBackground(new Color(20, 82, 20));
                    for (int i = 0; i < answerText.length; i++) {
                        i = answerTextArea.getHeight() /2;
                        correctAnswer.setBounds(675, i + (currentIndex * 90), 20, 20);
                        wrongAnswer.setBounds(0, i + (currentIndex * 90), 23, 20);
                    }
                    correctAnswer.addItemListener(j -> {
                        if (correctAnswer.isSelected()) {
                            result = "True";
                            tech(question, pinGame,answer, result);
                        } else {
                            myJdbc.deleteLastRecords(question);
                        }
                        if (wrongAnswer.isSelected() && correctAnswer.isSelected()) {
                            correctAnswer.setSelected(false);
                            wrongAnswer.setSelected(false);
                            createMenuText.setText("choose just one type of answer");
                            myJdbc.deleteLastRecords(question);
                        }
                    });
                    wrongAnswer.addItemListener(j -> {
                        if (wrongAnswer.isSelected()) {
                            result = "False";
                            tech(question, pinGame, answer, result);
                        } else {
                            myJdbc.deleteLastRecords(question);
                        }
                        if (wrongAnswer.isSelected() && correctAnswer.isSelected()) {
                            correctAnswer.setSelected(false);
                            wrongAnswer.setSelected(false);
                            createMenuText.setText("choose just one type of answer");
                            myJdbc.deleteLastRecords(question);
                        }
                    });
                    answerPanel.add(correctAnswer);
                    answerPanel.add(wrongAnswer);
                }
            }

            answerPanel.add(answerText[currentIndex]);
            currentIndex++;
            System.out.println(currentIndex);
            if (currentIndex == answers.length) {
                answerField.setVisible(false);
                addButton.setVisible(false);
                nrCharInQuestionLabel.setVisible(false);
                answerText[currentIndex] = answerTextArea;
                answerField.setText("");
            } else {
                answerField.setText("");
            }
            panel.revalidate();
            panel.repaint();
        });
        panel.add(addButton);
        answerField.setVisible(true);
        currentIndex = 0;
        panel.revalidate();
        panel.repaint();
    }

    private void tech(String question, String pinGame, String answer, String result) {
        myJdbc.isEmptyTable();
        myJdbc.createGame(pinGame);
        myJdbc.insertQuestion(question);
        myJdbc.insertAnswer(question, answer, result, pinGame);
    }

    public String pinGame() {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        String combination = upperCase + numbers;
        int length = 6;
        Random random = new Random();
        c = new char[length];
        for (int i = 0; i < length; i++) {
            c[i] = combination.charAt(random.nextInt(combination.length()));
        }
        return String.valueOf(c);
    }

    public JTextArea texts(int x, int y, int width, int height, String text) {
        textArea = new JTextArea();
        textArea.setText(text);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBounds(x, y, width, height);
        textArea.setFont(font);
        textArea.setBackground(new Color(20, 82, 20));
        textArea.setForeground(Color.white);
        return textArea;
    }

    public JButton buttons(int x, int y, int width, int height, String text) {
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.setFont(font);
        button.setBorder(null);
        button.setBackground(new Color(136, 204, 0));
        panel.add(button);
        return button;
    }

    public JButton closeWindow(int x) {
        closeButton = new JButton("X");
        closeButton.addActionListener(e -> frame.setVisible(false));
        closeButton.setBounds(x, 0, 40, 35);
        closeButton.setForeground(Color.white);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        closeButton.setFont(font);
        closeButton.setBackground(new Color(26, 26, 0));
        return closeButton;
    }

    public JCheckBox checkBox = box();
}