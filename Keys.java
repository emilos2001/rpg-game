package Totorial.RPG;

import Totorial.RPG.Entity.Entity;
import Totorial.RPG.Menu.GameMenu;
import Totorial.RPG.Menu.MyJdbc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Keys implements KeyListener {
    private final int maxLengthOfQuestion = 300;
    public boolean up, down, left, right, interact, talk, teleport, choose, sellBuy, nextDialogue, selected, chestOpen, verify, join;
    public boolean joinButtonClicked = false;
    public GameMenu gameMenu;
    public String nameField;
    public String pinField;
    public JLabel label;
    String questionField;
    Entity entity;
    public Color warningColor = new Color(255, 80, 80);
    String warningText = "The doesn't match";
    MyJdbc myJdbc = new MyJdbc();
    GamePanel gp;

    Calculator calculator;

    public Keys(GamePanel gp) {
        this.gp = gp;
        entity = new Entity(gp);
    }

    public void additionalWindow(String text, String pinGame) {
        gameMenu.frame.setVisible(false);
        JButton button = gameMenu.buttons(375, 35, 60, 30, "OK!");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        label = new JLabel(text + "  Pin : " + pinGame);
        label.setBackground(new Color(20, 82, 20));
        label.setForeground(Color.white);
        label.setBounds(10, 25, 380, 50);
        frame.setBounds(520, 400, 500, 130);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(26, 26, 0));
        panel.setBackground(new Color(20, 82, 20));
        panel.setLayout(null);
        panel.setBounds(10, 10, 480, 110);
        frame.setVisible(true);
        button.addActionListener(k -> frame.setVisible(false));
        frame.add(panel);
        panel.add(button);
        panel.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = true;
        }
        if (key == KeyEvent.VK_S) {
            down = true;
        }
        if (key == KeyEvent.VK_A) {
            left = true;
        }
        if (key == KeyEvent.VK_D) {
            right = true;
        }
        if (key == KeyEvent.VK_E) {
            interact = true;
        }
        if (key == KeyEvent.VK_R) {
            if (gp.state == gp.inventoryState) {
                gp.state = gp.playState;
            } else if (gp.state == gp.playState) {
                gp.state = gp.inventoryState;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (gp.state == gp.inventoryState) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.dialogueStateWithMerchant) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.dialogueScreen) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.chestState) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.dialogueStateWithVillagers) {
                gp.state = gp.playState;
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            nextDialogue = true;
        }
        if (key == KeyEvent.VK_ENTER) {
            verify = true;
        }
        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (key == KeyEvent.VK_T) {
            talk = true;
        }
        if (key == KeyEvent.VK_1) {
            if (gp.state == gp.playState) {
                gp.state = gp.information;
            } else if (gp.state == gp.information) {
                gp.state = gp.playState;
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (gp.ui.slotRow != 0) {
                gp.ui.slotRow = gp.ui.slotRow - 2;
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (gp.ui.slotRow != 2) {
                gp.ui.slotRow = gp.ui.slotRow + 2;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (gp.ui.slotCol != 0) {
                gp.ui.slotCol = gp.ui.slotCol - 2;
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (gp.ui.slotCol != 4) {
                gp.ui.slotCol = gp.ui.slotCol + 2;
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (gp.ui.slotRow2 != 0) {
                gp.ui.slotRow2 = gp.ui.slotRow2 - 1;
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (gp.ui.slotRow2 != 2) {
                gp.ui.slotRow2 = gp.ui.slotRow2 + 1;
            }
        }

        if (key == KeyEvent.VK_C) {
            if (gp.ui.calculator || gp.player.calculatorBuy) {
                calculator = new Calculator();
                calculator.jFrame.setVisible(true);
            }
        }
        if (key == KeyEvent.VK_H) {
            teleport = true;
        }
        if (key == KeyEvent.VK_ENTER) {
            choose = true;
        }
        if (gp.ui.subState == 0) {
            if (key == KeyEvent.VK_SPACE) {
                gp.ui.choose--;
                if (gp.ui.choose < 1) {
                    gp.ui.choose = 2;
                }
            }
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            sellBuy = true;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            selected = true;
        }
        if (key == KeyEvent.VK_Q) {
            chestOpen = true;
        }
        //menuUI
        if (key == KeyEvent.VK_RIGHT) {
            if (gp.menu.x == 30) {
                gp.menu.x = 230;
            } else if (gp.menu.x == 230) {
                gp.menu.x = 430;
            } else if (gp.menu.x == 430) {
                gp.menu.x = 630;
            } else if (gp.menu.x == 630) {
                gp.menu.x = 30;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (gp.menu.x == 630) {
                gp.menu.x = 430;
            } else if (gp.menu.x == 430) {
                gp.menu.x = 230;
            } else if (gp.menu.x == 230) {
                gp.menu.x = 30;
            } else if (gp.menu.x == 30) {
                gp.menu.x = 630;
            }
        }

        if (key == KeyEvent.VK_ENTER) {
            if (gp.menu.isMenu) {
                join = false;
                if (gp.menu.x == 30) {
                    gameMenu = new GameMenu(540, 155, 450, 400);
                    gameMenu.frame.setVisible(true);
                    gameMenu.panel.add(gameMenu.joinTextMenu);
                    gameMenu.panel.add(gameMenu.nameFieldForJoin);
                    gameMenu.panel.add(gameMenu.pinFieldForJoin);
                    gameMenu.panel.add(gameMenu.textName);
                    gameMenu.panel.add(gameMenu.textPin);
                    gameMenu.panel.add(gameMenu.closeWindow(390));
                    JButton joinButton = gameMenu.buttons(80, 330, 250, 30, "JOIN");
                    joinButton.addActionListener(a -> {
                        nameField = gameMenu.nameFieldForJoin.getText();
                        pinField = gameMenu.pinFieldForJoin.getText();
                        questionField = gameMenu.questionField.getText();
                        if (nameField.isEmpty()) {
                            gameMenu.nameFieldForJoin.setBackground(warningColor);
                            gameMenu.joinTextMenu.setText("Name field cannot be empty");
                        } else if (pinField.isEmpty()) {
                            gameMenu.joinTextMenu.setText("Pin field cannot empty");
                            gameMenu.pinFieldForJoin.setBackground(warningColor);
                        } else {
                            if (myJdbc.pinCode(pinField)) {
                                myJdbc.joinIn(nameField, pinField);
                                gp.menu.mess = "";
                                gp.menu.alert = "";
                                joinButtonClicked = true;
                                join = false;
                                gameMenu.frame.setVisible(false);
                            } else {
                                gameMenu.joinTextMenu.setText("Your pin game is wrong");
                                gameMenu.pinFieldForJoin.setBackground(warningColor);
                            }
                        }
                    });
                    gp.menu.mess = "";
                }
                if (gp.menu.x == 230) {
                    //if (gp.menu.isLogged) {
                    gameMenu = new GameMenu(400, 120, 750, 730);
                    gameMenu.panel.add(gameMenu.createMenuText);
                    gameMenu.panel.add(gameMenu.nrQuestions);
                    gameMenu.panel.add(gameMenu.writeQuestion);
                    gameMenu.panel.add(gameMenu.questionField);
                    gameMenu.nrCharInQuestionLabel.setBounds(675, 35, 300, 20);
                    gameMenu.nrCharInQuestionLabel.setForeground(Color.white);
                    gameMenu.panel.add(gameMenu.nrCharInQuestionLabel);
                    gameMenu.panel.add(gameMenu.closeWindow(690));
                    gameMenu.panel.add(gameMenu.addQuestion);
                    gameMenu.addQuestionButton();
                    gameMenu.frame.setVisible(true);
                    gameMenu.questionField.getDocument().addDocumentListener(new DocumentListener() {
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
                            String text = gameMenu.questionField.getText();
                            int length = text.length();
                            gameMenu.nrCharInQuestionLabel.setText(length + "/300");
                        }
                    });
                    AbstractDocument document = (AbstractDocument) gameMenu.questionField.getDocument();
                    document.setDocumentFilter(new DocumentFilter() {
                        @Override
                        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                            if (fb.getDocument().getLength() + string.length() <= maxLengthOfQuestion) {
                                super.insertString(fb, offset, string, attr);
                            }
                        }

                        @Override
                        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                            int currentLength = fb.getDocument().getLength();
                            int overLimit = (currentLength + text.length()) - maxLengthOfQuestion;
                            if (overLimit <= 0) {
                                super.replace(fb, offset, length, text, attrs);
                            } else {
                                String trimmedText = text.substring(0, text.length() - overLimit);
                                super.replace(fb, offset, length, trimmedText, attrs);
                            }
                        }
                    });
                    String pinGame = gameMenu.pinGame;
                    JButton addAnswers = gameMenu.buttons(310, 660, 65, 45, "\u002B");
                    addAnswers.addActionListener(a -> gameMenu.addAnswers(10));
                    gameMenu.closeButton.addActionListener(j -> {
                        if (gameMenu.nr >= 1) {
                            additionalWindow("Your questions and answers has been saved", pinGame);
                            gameMenu.setVisible(false);
                        } else {
                            gameMenu.setVisible(false);
                        }
                    });
                }
            }
            if (gp.menu.x == 430) {
                gameMenu = new GameMenu(540, 155, 450, 400);
                gameMenu.frame.setVisible(true);
                gameMenu.panel.add(gameMenu.signInText);
                gameMenu.panel.add(gameMenu.textNameForSingIn);
                gameMenu.panel.add(gameMenu.nameFieldForSignIn);
                gameMenu.panel.add(gameMenu.passwordFieldForSingIn);
                gameMenu.panel.add(gameMenu.textPasswordForSignIn);
                gameMenu.panel.add(gameMenu.checkBox);
                gameMenu.panel.add(gameMenu.closeWindow(390));
                JButton signInButton = gameMenu.buttons(80, 330, 250, 30, "SIGN IN");
                signInButton.addActionListener(s -> {
                    String nameField = gameMenu.nameFieldForSignIn.getText();
                    char[] passwordField = gameMenu.passwordFieldForSingIn.getPassword();
                    if (nameField.isEmpty()) {
                        gameMenu.nameFieldForSignIn.setBackground(warningColor);
                    } else if (passwordField.length == 0) {
                        gameMenu.passwordFieldForSingIn.setBackground(warningColor);
                    } else {
                        String password = new String(passwordField);
                        if (myJdbc.signIn(nameField, password)) {
                            System.out.println("is logged");
                            gp.menu.isLogged = true;
                            gp.menu.logged();
                            gameMenu.frame.setVisible(false);
                        } else {
                            gameMenu.signInText.setText("Username or password is incorrect");
                        }
                    }
                });
                gp.menu.mess = "";
            }
            if (gp.menu.x == 630) {
                gameMenu = new GameMenu(500, 155, 450, 500);
                gameMenu.frame.setVisible(true);
                gameMenu.panel.add(gameMenu.signUpText);
                gameMenu.panel.add(gameMenu.textNameForSingUp);
                gameMenu.panel.add(gameMenu.nameFieldForSignUp);
                gameMenu.panel.add(gameMenu.passwordTextForSignUp);
                gameMenu.panel.add(gameMenu.passwordFieldForSingUp);
                gameMenu.panel.add(gameMenu.re_passwordTextForSignUp);
                gameMenu.panel.add(gameMenu.re_passwordFieldForSingUp);
                gameMenu.panel.add(gameMenu.emailForSignUp);
                gameMenu.panel.add(gameMenu.emailFieldForSingUp);
                gameMenu.panel.add(gameMenu.checkBox);
                gameMenu.panel.add(gameMenu.closeWindow(390));
                gp.menu.mess = "";
                JButton signUpButton = gameMenu.buttons(80, 445, 250, 30, "SIGN UP");
                signUpButton.addActionListener(i -> {
                    String name = gameMenu.nameFieldForSignUp.getText();
                    String email = gameMenu.emailFieldForSingUp.getText();
                    char[] passwordChars = gameMenu.passwordFieldForSingUp.getPassword();
                    char[] reEnteredPasswordChars = gameMenu.re_passwordFieldForSingUp.getPassword();
                    if (name.isEmpty()) {
                        gameMenu.nameFieldForSignUp.setBackground(warningColor);
                        gameMenu.signUpText.setText("Your name cannot be empty");
                    } else if (email.isEmpty()) {
                        gameMenu.emailFieldForSingUp.setBackground(warningColor);
                    } else if (!gameMenu.isEmail(gameMenu.emailFieldForSingUp.getText())) {
                        gameMenu.signUpText.setText("Your e-mail address isn't valid");
                    } else if (passwordChars.length == 0) {
                        gameMenu.passwordFieldForSingUp.setBackground(warningColor);
                    } else if (reEnteredPasswordChars.length == 0) {
                        gameMenu.re_passwordFieldForSingUp.setBackground(warningColor);
                    } else if (!Arrays.equals(passwordChars, reEnteredPasswordChars)) {
                        gameMenu.passwordFieldForSingUp.setBackground(warningColor);
                        gameMenu.re_passwordFieldForSingUp.setBackground(warningColor);
                        gameMenu.signUpText.setText(warningText);
                    } else {
                        String password = new String(passwordChars);
                        myJdbc.singUp(name, email, password);
                        System.out.println("Inserted");
                        gameMenu.frame.setVisible(false);
                    }
                });
                //}
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = false;
        }
        if (key == KeyEvent.VK_S) {
            down = false;
        }
        if (key == KeyEvent.VK_A) {
            left = false;
        }
        if (key == KeyEvent.VK_D) {
            right = false;
        }
        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_T) {
            talk = false;
        }
        if (key == KeyEvent.VK_H) {
            teleport = false;
        }
        if (key == KeyEvent.VK_E) {
            interact = false;
        }
        if (key == KeyEvent.VK_Q) {
            chestOpen = false;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            sellBuy = false;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            selected = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            verify = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            nextDialogue = false;
        }
    }
}