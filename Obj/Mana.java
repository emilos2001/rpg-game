package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Mana extends SupObject{
    public Mana(GamePanel gp) {
        super(gp);
        try {
            manaCoin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("manacrystal.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
