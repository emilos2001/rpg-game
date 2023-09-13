package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Diamond extends SupObject{

    public Diamond(GamePanel gp){
        super(gp);
        name = "DIAMOND";
        try{
            diamond = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("blueheart.png")));
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("blueheart.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
