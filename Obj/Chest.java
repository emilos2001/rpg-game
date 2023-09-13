package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;


public class Chest extends SupObject {
    GamePanel gp;


    public Chest(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "CHEST";
        getChestImages();
    }

    public void getChestImages() {
        try {
            chest = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("chest.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d, GamePanel gp) {
        image = chest;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2d.drawImage(image, screenX, screenY, gp.size, gp.size, null);
    }
}