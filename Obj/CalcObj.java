package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class CalcObj extends SupObject {
    public CalcObj(GamePanel gp) {
       super(gp);
        name = "CALCULATOR";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("calculator.png")));
            calculator = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("calculator.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
