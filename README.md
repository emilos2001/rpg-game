THIS IS MAIN FILE
package Totorial.RPG;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePanel gp = new GamePanel();
        frame.setResizable(false);
        frame.add(gp);
        frame.pack();
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gp.setupGame();
        gp.startGame();

    }
}
