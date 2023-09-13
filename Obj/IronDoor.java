package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class IronDoor extends SupObject {
    public IronDoor(GamePanel gp) {
        super(gp);
        name = "IRON-DOOR";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("door_iron.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
