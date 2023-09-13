package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Coin extends SupObject{

    public Coin(GamePanel gp) {
        super(gp);
        name = "DINCOIN";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("coin_bronze.png")));
            coin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("coin_bronze.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
