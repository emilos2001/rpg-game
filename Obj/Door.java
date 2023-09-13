package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Door extends SupObject{
    public Door(GamePanel gp) {
        super(gp);
        name = "DOOR";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("door.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
