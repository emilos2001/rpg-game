package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Stairs extends SupObject{
    public Stairs(GamePanel gp) {
        super(gp);
        name = "STAIRS";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("stairs.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
