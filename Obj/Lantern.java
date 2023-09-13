package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Lantern extends SupObject {
    public Lantern(GamePanel gp) {
        super(gp);
        name = "LANTERN";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("lantern.png")));
            lantern = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("lantern.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
