package Totorial.RPG.Obj;

import Totorial.RPG.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SupObject {
    public BufferedImage image;
    public BufferedImage key;
    public BufferedImage calculator;
    public BufferedImage diamond;
    public BufferedImage lantern;
    public BufferedImage coin;
    public BufferedImage manaCoin;
    public BufferedImage chest;
    GamePanel gp;

    public SupObject(GamePanel gp) {
        this.gp = gp;
    }

    public Rectangle solid = new Rectangle(4, 16, 40, 32);
    public int solidDefaultX, solidDefaultY;
    public int worldX;
    public int worldY;
    public String name;

    public void draw(Graphics2D g2d, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2d.drawImage(image, screenX, screenY, gp.size, gp.size, null);
    }
}
