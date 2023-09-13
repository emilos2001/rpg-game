package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class KeyObj extends SupObject {
    public KeyObj(GamePanel gp) {
        super(gp);
        name = "KEY";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("key.png")));
            key = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("key.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
