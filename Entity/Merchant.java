package Totorial.RPG.Entity;

import Totorial.RPG.GamePanel;
import Totorial.RPG.Obj.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;
public class Merchant extends Entity {
    public Merchant(GamePanel gp) {
        super(gp);
        name = "MERCHANT";
        getMerchantImages();
        items();
    }

    public void getMerchantImages() {
        try {
            merchant1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("merchant_down_1.png")));
            merchant2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("merchant_down_2.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void items() {
        inventory.add(new KeyObj(gp));
        inventory.add(new Diamond(gp));
        inventory.add(new Lantern(gp));
        inventory.add(new CalcObj(gp));
        inventory.add(new Coin(gp));
    }

    public void merchantWhilePauseAndDialogue() {
        spriteCounter = 0;
        if (spriteNum == 1) {
            image = merchant1;
        } else if (spriteNum == 2){
            image = merchant2;
        }
    }

    public void draw(Graphics2D g2d, GamePanel gp) {
        if (spriteNum == 1) {
            image = merchant1;
        }
        if (spriteNum == 2) {
            image = merchant2;
        }

        spriteCounter++;
        if (spriteCounter > 15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if (gp.state == gp.pauseState) {
            merchantWhilePauseAndDialogue();
        }
        if (gp.state == gp.dialogueStateWithMerchant){
            merchantWhilePauseAndDialogue();
        }
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2d.drawImage(image, screenX, screenY, gp.size, gp.size, null);
    }
}
