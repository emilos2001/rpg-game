package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class House extends SupObject{

    public House(GamePanel gp){
        super(gp);
        name = "HOUSE";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("house.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
