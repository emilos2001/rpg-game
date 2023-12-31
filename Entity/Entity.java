package Totorial.RPG.Entity;

import Totorial.RPG.GamePanel;
import Totorial.RPG.Obj.SupObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {
    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public BufferedImage dinoLeftUpLeft, dinoLeftUpRight, dinoRightUpRight, dinoRightUpLeft,
            npcUp1, npcUp2, npcDown1, npcDown2, npcLeft1, npcLeft2, npcRight1, npcRight2,
            merchant1, merchant2;
    public String playerDirection;
    public String npcDirection;
    public BufferedImage image = null;
    public int spriteCounter = 1;
    public int spriteNum = 1;
    public Rectangle solid = new Rectangle(10, 16, 22, 22);
    public int solidDefaultX, solidDefaultY;
    public boolean collision = false;
    public String[][] questions = new String[20][20];
    public String[][] correctOption =new String[10][10];
    public String[][][] options = new String[20][20][3];
    public int dialogueIndex = 0;
    public int dialogueSet = 0;
    public String name;
    public ArrayList<SupObject> inventory;
    public Entity(GamePanel gp) {
        this.gp = gp;
        inventory = new ArrayList<>();
    }

    public void draw(Graphics2D g2d, GamePanel gp) {

    }
}
