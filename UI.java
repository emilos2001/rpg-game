package Totorial.RPG;

import Totorial.RPG.Entity.Entity;
import Totorial.RPG.Entity.Merchant;
import Totorial.RPG.Entity.Player;
import Totorial.RPG.Entity.Villager;
import Totorial.RPG.Menu.MyJdbc;
import Totorial.RPG.Obj.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    public static double currentProgress;
    public int slotCol = 0;
    public int slotRow = 0;
    public int slotCol2 = 0;
    public int slotRow2 = 0;
    public boolean calculator = false;
    public boolean key = false;
    public boolean lantern = false;
    public boolean dcoin = false;
    public boolean diamond = false;
    public int subState;
    public int choose = 1;
    public String currentDialogue = "";
    public int cursorX;
    public int cursorY;

    Villager villager;
    Merchant merchant;
    Mana mana;
    Coin coin;
    KeyObj keyObj;
    Diamond diamondObj;
    Chest chest;
    GamePanel gp;
    Keys keys;
    Entity entity;
    SupObject supObject;
    Graphics2D g2d;
    BufferedImage dinoRightUpLeft, dinoLeftUpLeft, dinoLeftUpRight, dinoRightUpRight, npcLeft1, npcLeft2, merchant1, merchant2,
            dinCoin, chestOpen, manaCoin, keyImg, diamondImg;
    boolean message = false;
    String messageShow = "";
    int counter = 0;
    int spriteNum = 1;
    int spriteCounter = 1;
    int spriteNum2 = 1;
    int spriteCounter2 = 1;
    int x = 48;
    final int slotsX = x + 10;
    int y = 308;
    final int slotsY = y + 10;

    public UI(GamePanel gp, Keys keys) {
        this.gp = gp;
        this.keys = keys;
        supObject = new SupObject(gp);
        entity = new Entity(gp);
        villager = new Villager(gp);
        npcLeft1 = villager.npcLeft1;
        npcLeft2 = villager.npcLeft2;
        merchant = new Merchant(gp);
        merchant1 = merchant.merchant1;
        merchant2 = merchant.merchant2;
        Player player = new Player(gp, keys);
        dinoLeftUpLeft = player.dinoLeftUpLeft;
        dinoRightUpLeft = player.dinoRightUpLeft;
        dinoRightUpRight = player.dinoRightUpRight;
        dinoLeftUpRight = player.dinoLeftUpRight;
        coin = new Coin(gp);
        chest = new Chest(gp);
        mana = new Mana(gp);
        keyObj = new KeyObj(gp);
        diamondObj = new Diamond(gp);
        manaCoin = mana.manaCoin;
        diamondImg = diamondObj.diamond;
        keyImg = keyObj.key;
        dinCoin = coin.coin;
    }

    public void message(String text) {
        message = true;
        messageShow = text;
    }

    //gp.size, gp.size * 2, gp.size * 14, 630
    public void dialogueScreenWithVillager() {
        int x = 35;
        int y = 120;
        villager.setDialog();
        dialoguesScreen(5, gp.size * 2, 760, 640);
        g2d.setColor(Color.white);
        if (villager.questions[villager.dialogueSet][villager.dialogueIndex] != null) {
            currentDialogue = villager.questions[villager.dialogueSet][villager.dialogueIndex];
        } else {
            villager.dialogueIndex = 0;
            villager.dialogueSet++;
            if (villager.questions[villager.dialogueSet][0] == null) {
                villager.dialogueSet = 0;
            }
            if (gp.state == gp.dialogueStateWithVillagers) {
                gp.state = gp.playState;
            }
        }
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.drawImage(dinCoin, 695, 100, 30, 30, null);
        g2d.drawString("X:" + gp.player.coin, 720, 120);
        String typeOfAnswers = "MULTIPLE ANSWERS";
        g2d.drawString(typeOfAnswers, 565, 790);
        nextLineText(currentDialogue, x, y, 700);
        if (spriteNum == 1) {
            g2d.drawImage(dinoLeftUpRight, 310, 750, 50, 50, null);
        }
        if (spriteNum == 2) {
            g2d.drawImage(dinoRightUpRight, 310, 750, 50, 50, null);
        }
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if (spriteNum2 == 1) {
            g2d.drawImage(npcLeft1, 370, 750, 50, 50, null);
        }
        if (spriteNum2 == 2) {
            g2d.drawImage(npcLeft2, 370, 750, 50, 50, null);
        }
        spriteCounter2++;
        if (spriteCounter2 > 10) {
            if (spriteNum2 == 1) {
                spriteNum2 = 2;
            } else if (spriteNum2 == 2) {
                spriteNum2 = 1;
            }
            spriteCounter2 = 0;
        }
        answers();
    }

    public void answers() {
        int slotsX = x + 80;
        int slotsY = y + 80;
        cursorX = slotsX + (gp.size * slotCol2) - 5;
        cursorY = slotsY + (gp.size * slotRow2) - 5;
        g2d.setColor(Color.white);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(new Color(26, 26, 0));
        g2d.setStroke(new BasicStroke(3));
        // g2d.drawRoundRect(cursorX - 55, cursorY + 300, 30, 35, 10, 10);
        g2d.setColor(Color.white);
        for (int i = 0; i < 6; i++) {
            int x = 35;
            int y = 230 + (i * 90);
            if (villager.answers[villager.dialogueSet][villager.dialogueIndex][i] != null) {
                String line = villager.answers[villager.dialogueSet][villager.dialogueIndex][i];
                nextLineText(line, x, y, 700);
            }
        }
        if (villager.answers[villager.dialogueSet][0] == null) {
            villager.dialogueSet = 0;
        }
        correctAnswers();
    }

    private void nextLineText(String text, int x, int y, int maxWidth) {
        FontMetrics fontMetrics = g2d.getFontMetrics();
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (fontMetrics.stringWidth(sb.toString() + " " + word) < maxWidth) {
                sb.append(word).append(" ");
            } else {
                g2d.drawString(sb.toString(), x, y);
                y += fontMetrics.getHeight();
                sb = new StringBuilder(word + " ");
            }
        }
        g2d.drawString(sb.toString(), x, y);
    }

    private void correctAnswers() {
        if (keys.verify) {
            g2d.setColor(new Color(0, 255, 0));
            g2d.setStroke(new BasicStroke(3));
            g2d.drawRoundRect(cursorX - 55, cursorY + 300, 30, 35, 10, 10);
            keys.verify = false;
            if (keys.nextDialogue) {
                villager.dialogueIndex++;
                g2d.setFont(new Font(null, Font.ITALIC, 20));
                g2d.drawString("Correct", 630, 630);
                gp.player.coin = gp.player.coin + 5;
                keys.nextDialogue = false;
            }
            currentProgress = currentProgress + 0.025;
        }
    }


    /*  private void wrongAnswers() {
          if (keys.verify) {
              g2d.setColor(new Color(255, 0, 0));
              g2d.setStroke(new BasicStroke(3));
              g2d.drawRoundRect(cursorX - 55, cursorY + 300, 30, 35, 10, 10);
              g2d.setFont(new Font(null, Font.ITALIC, 20));
              g2d.drawString("Wrong", 630, 630);
              gp.player.coin = gp.player.coin - 7;
              keys.verify = false;
          }
      }
  */
    public void dialogueScreenWithMerchant() {
        int x2 = 63;
        int y2 = 480;
        dialoguesScreen(gp.size, (gp.size * 12), (gp.size * 14), (gp.size * 14));
        g2d.setFont(new Font(null, Font.ITALIC, 20));
        g2d.setColor(Color.white);
        for (String line : currentDialogue.split("\n")) {
            g2d.drawString(line, x2, y2 + 120);
            y2 += 30;
        }
        g2d.setFont(new Font(null, Font.ITALIC, 25));
        g2d.drawString("BUY", 630, 670);
        g2d.drawString("SELL", 630, 715);
        currentDialogue = "If you come to me,you ne to sell or buy something \n " + "what do you to want,\n " + "to buy or sell?";
        if (choose == 1) {
            g2d.drawString(">", 610, 670);
            if (gp.keys.choose) {
                buy();
                currentDialogue = "If you come to me,you need to sell or buy something, " + " \nwhat do you to want to buy?"
                        + "\nyour choose, your money, our stuff" + "\nPRESS  'ESC'  TO EXIT";
            }
        }
        if (choose == 2) {
            g2d.drawString(">", 610, 715);
            if (gp.keys.choose) {
                sell();
                currentDialogue = "If you come to me,you need to sell or buy something, " + " \nwhat do you to want to sell?"
                        + " \nLet's see, what you got." + "\nPRESS  'ESC'  TO EXIT";
            }
        }


        if (spriteNum == 1) {
            g2d.drawImage(dinoLeftUpRight, 310, 780, 50, 50, null);
        }
        if (spriteNum == 2) {
            g2d.drawImage(dinoRightUpRight, 310, 780, 50, 50, null);
        }
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if (spriteNum2 == 1) {
            g2d.drawImage(merchant1, 370, 780, 50, 50, null);
        }
        if (spriteNum2 == 2) {
            g2d.drawImage(merchant2, 370, 780, 50, 50, null);
        }
        spriteCounter2++;
        if (spriteCounter2 > 10) {
            if (spriteNum2 == 1) {
                spriteNum2 = 2;
            } else if (spriteNum2 == 2) {
                spriteNum2 = 1;
            }
            spriteCounter2 = 0;
        }
    }

    public void buy() {
        //window1 your inventory
        int x = gp.size;
        int y = 308;
        int width = gp.size * 7;
        int height = gp.size * 4;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x, y, width, height + 70, 25, 25);
        g2d.setColor(new Color(20, 82, 20));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height + 60, 30, 30);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(Color.white);
        g2d.drawString("Your Inventory", 270, 335);
        //window2 buy items
        int x2 = 390;
        int y2 = 308;
        int width2 = gp.size * 7;
        int height2 = gp.size * 4;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x2, y2, width2, height2 + 70, 25, 25);
        g2d.setColor(new Color(20, 82, 20));
        g2d.fillRoundRect(x2 + 5, y2 + 5, width2 - 10, height2 + 60, 30, 30);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(Color.white);
        g2d.drawString("Buy", 680, 335);
        g2d.setColor(new Color(26, 26, 0));
        g2d.setStroke(new BasicStroke(3));
        //cursor on buy
        cursorX = slotsX + (gp.size * slotCol) - 5;
        cursorY = slotsY + (gp.size * slotRow) - 5;
        g2d.drawRoundRect(cursorX + 365, cursorY + 20, 70, 65, 15, 15);
        itemBuy();
        String text = " ";
        //your inventory window
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            g2d.drawImage(gp.player.inventory.get(i).coin, 60, 310, 30, 30, null);
            g2d.setColor(Color.white);
            g2d.drawString(" : " + gp.player.coin, 85, 330);
            if (gp.player.key >= 1 || gp.player.keyBuy > 0) {
                g2d.drawImage(gp.player.inventory.get(i).key, slotsX + 15, slotsY + 30, 40, 40, null);
                g2d.drawString(" " + gp.player.key, slotsX + 40, slotsY + 70);
            }
            if (gp.player.key < 1) {
                g2d.drawImage(null, slotsX + 20, slotsY + 30, 40, 40, null);
                g2d.drawString(text, slotsX + 40, slotsY + 70);
            }
            if (gp.player.diamond >= 1 || gp.player.diamondBuy > 0) {
                g2d.drawImage(gp.player.inventory.get(i).diamond, slotsX + 202, slotsY + 30, 40, 40, null);
                g2d.drawString(" " + gp.player.diamond, slotsX + 235, slotsY + 65);
            }
            if (gp.player.diamond < 1) {
                g2d.drawImage(null, slotsX + 202, slotsY + 30, 40, 40, null);
                g2d.drawString(text, slotsX + 40, slotsY + 70);
            }
            if (gp.player.mana >= 0) {
                g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 107, slotsY + 125, 40, 40, null);
                g2d.drawString(" " + gp.player.mana, slotsX + 139, slotsY + 155);
            }
            if (gp.player.mana <= 0) {
                g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 107, slotsY + 125, 40, 40, null);
                g2d.drawString("0", slotsX + 139, slotsY + 155);
            }
            if (calculator || gp.player.calculatorBuy) {
                g2d.drawImage(gp.player.inventory.get(i).calculator, slotsX + 107, slotsY + 28, 40, 40, null);
            }
            if (!calculator) {
                g2d.drawImage(null, slotsX + 107, slotsY + 28, 40, 40, null);
            }
            if (lantern || gp.player.lanternBuy) {
                g2d.drawImage(gp.player.inventory.get(i).lantern, slotsX + 15, slotsY + 125, 40, 40, null);
            }
            if (!lantern) {
                g2d.drawImage(null, slotsX + 20, slotsY + 60, 40, 40, null);
            }
        }
    }

    public void sell() {
        //window1 your inventory
        int x = gp.size;
        int y = 308;
        int width = gp.size * 7;
        int height = gp.size * 4;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x, y, width, height + 70, 25, 25);
        g2d.setColor(new Color(20, 82, 20));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height + 60, 30, 30);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(Color.white);
        g2d.drawString("Your Inventory", 270, 335);
        g2d.setColor(new Color(26, 26, 0));
        g2d.setStroke(new BasicStroke(3));
        itemSell();
        //cursor on sell your items
        int cursorX = slotsX + (gp.size * slotCol) - 5;
        int cursorY = slotsY + (gp.size * slotRow) - 5;
        g2d.drawRoundRect(cursorX + 10, cursorY + 25, 70, 65, 15, 15);
        //window2 sell items
        int x2 = 390;
        int y2 = 308;
        int width2 = gp.size * 7;
        int height2 = gp.size * 4;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x2, y2, width2, height2 + 70, 25, 25);
        g2d.setColor(new Color(20, 82, 20));
        g2d.fillRoundRect(x2 + 5, y2 + 5, width2 - 10, height2 + 60, 30, 30);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(Color.white);
        g2d.drawString("Sell", 680, 335);
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            //items which you can sell
            //buy window
            g2d.drawImage(gp.player.inventory.get(i).key, slotsX + 375, slotsY + 25, 40, 40, null);
            g2d.drawImage(gp.player.inventory.get(i).calculator, slotsX + 467, slotsY + 23, 40, 40, null);
            g2d.drawImage(gp.player.inventory.get(i).diamond, slotsX + 559, slotsY + 25, 40, 40, null);
            g2d.drawImage(gp.player.inventory.get(i).lantern, slotsX + 375, slotsY + 115, 40, 40, null);
            g2d.drawImage(gp.player.inventory.get(i).coin, slotsX + 467, slotsY + 115, 40, 40, null);
            g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 559, slotsY + 115, 40, 40, null);
        }
    }

    public void itemBuy() {
        int price;
        int cursorX = slotsX + (gp.size * slotCol) - 5;
        int cursorY = slotsY + (gp.size * slotRow) - 5;
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            //ITEMS WHICH YOU CAN BUY
            g2d.drawImage(gp.player.inventory.get(i).key, slotsX + 375, slotsY + 25, 40, 40, null);
            if (cursorX == 53 && cursorY == 313) {
                price = 50;
                g2d.setColor(Color.white);
                g2d.drawString("Key : " + price + " dincoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.coin) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                    g2d.drawImage(null, slotsX + 375, slotsY + 25, 40, 40, null);
                } else if (keys.sellBuy) {
                    gp.player.key++;
                    gp.player.coin = gp.player.coin - price;
                    keys.sellBuy = false;
                }

            }
            g2d.drawImage(gp.player.inventory.get(i).calculator, slotsX + 467, slotsY + 23, 40, 40, null);
            if (cursorX == 149 && cursorY == 313) {
                price = 42;
                g2d.setColor(Color.white);
                g2d.drawString("Calculator : " + price + " manacoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.coin) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                } else if (calculator || gp.player.calculatorBuy) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You have already a calculator", slotsX + 355, slotsY + 230);
                    keys.sellBuy = false;
                } else if (keys.sellBuy) {
                    gp.player.calculatorBuy = true;
                    gp.player.mana = gp.player.mana - price;
                }
            }
            g2d.drawImage(gp.player.inventory.get(i).diamond, slotsX + 559, slotsY + 25, 40, 40, null);
            if (cursorX == 245 && cursorY == 313) {
                price = 75;
                g2d.setColor(Color.white);
                g2d.drawString("Diamond : " + price + " dincoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.coin) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                    keys.sellBuy = false;
                } else if (keys.sellBuy) {
                    gp.player.diamond++;
                    gp.player.coin = gp.player.coin - price;
                }
            }
            g2d.drawImage(gp.player.inventory.get(i).lantern, slotsX + 375, slotsY + 115, 40, 40, null);
            if (cursorX == 53 && cursorY == 409) {
                price = 45;
                g2d.setColor(Color.white);
                g2d.drawString("Lantern : " + price + " manacoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.mana) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                } else if (lantern || gp.player.lanternBuy) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You have already a lantern", slotsX + 355, slotsY + 230);
                } else if (keys.sellBuy) {
                    gp.player.lanternBuy = true;
                    gp.player.mana = gp.player.mana - price;
                    keys.sellBuy = false;
                }
            }
            g2d.drawImage(gp.player.inventory.get(i).coin, slotsX + 467, slotsY + 115, 40, 40, null);
            if (cursorX == 149 && cursorY == 409) {
                price = 51;
                g2d.setColor(Color.white);
                g2d.drawString("Dincoin : " + price + " manacoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.mana) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                } else if (keys.sellBuy) {
                    gp.player.coin = gp.player.coin + 23;
                    gp.player.mana = gp.player.mana - price;
                    keys.sellBuy = false;
                }

            }
            g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 559, slotsY + 115, 40, 40, null);
            if (cursorX == 245 && cursorY == 409) {
                price = 42;
                g2d.setColor(Color.white);
                g2d.drawString("Manacoin : " + price + " dincoin", slotsX + 360, slotsY + 200);
                if (price > gp.player.coin) {
                    g2d.setColor(Color.white);
                    g2d.drawString("You don't have enough money for that item", slotsX + 355, slotsY + 230);
                } else if (keys.sellBuy) {
                    gp.player.mana = gp.player.mana + 33;
                    gp.player.coin = gp.player.coin - price;
                    keys.sellBuy = false;
                } else if (gp.player.mana <= 0) {
                    g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 107, slotsY + 125, 40, 40, null);
                    g2d.drawString("0", slotsX + 139, slotsY + 155);
                }
            }
        }
    }

    public void itemSell() {
        int price;
        int cursorX = slotsX + (gp.size * slotCol) - 5;
        int cursorY = slotsY + (gp.size * slotRow) - 5;
        System.out.println("X: " + cursorX);
        System.out.println("Y: " + cursorY);
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            //your dincoins
            g2d.drawImage(gp.player.inventory.get(i).coin, 60, 310, 30, 30, null);
            g2d.setColor(Color.white);
            g2d.drawString(" : " + gp.player.coin, 85, 330);
            //your items
            if (gp.player.key > 0 || gp.player.keyBuy >= 1) {
                g2d.drawImage(gp.player.inventory.get(i).key, slotsX + 15, slotsY + 30, 40, 40, null);
                g2d.drawString(" " + gp.player.key, slotsX + 40, slotsY + 70);
                if (cursorX == 53 && cursorY == 313) {
                    price = 25;
                    g2d.drawString("Key : " + price + "  dincoin", slotsX + 140, slotsY + 230);
                    if (keys.sellBuy) {
                        gp.player.coin = gp.player.coin + price;
                        gp.player.key--;
                        keys.sellBuy = false;
                    }
                    if (gp.player.key < 1) {
                        g2d.drawImage(null, slotsX + 15, slotsY + 30, 40, 40, null);
                    }
                }
            }
            if (calculator || gp.player.calculatorBuy) {
                g2d.drawImage(gp.player.inventory.get(i).calculator, slotsX + 107, slotsY + 28, 40, 40, null);
                if (cursorX == 149 && cursorY == 313) {
                    g2d.drawString("Calculator : This item cannot be sold", slotsX + 50, slotsY + 230);
                    if (!calculator) {
                        String text = " ";
                        g2d.drawString(text, slotsX + 140, slotsY + 230);
                    }
                }
            }
            if (gp.player.diamond > 0 || gp.player.diamondBuy >= 1) {
                g2d.drawImage(gp.player.inventory.get(i).diamond, slotsX + 202, slotsY + 30, 40, 40, null);
                g2d.drawString(" " + gp.player.diamond, slotsX + 235, slotsY + 65);
                if (cursorX == 245 && cursorY == 313) {
                    price = 50;
                    g2d.drawString("Diamond " + price + " : dincoin", slotsX + 140, slotsY + 230);
                    if (keys.sellBuy) {
                        gp.player.coin = gp.player.coin + price;
                        gp.player.diamond--;
                        keys.sellBuy = false;
                    }
                    if (gp.player.diamond <= 0) {
                        gp.player.inventory.get(i).diamond = null;
                    }
                }
                if (gp.player.diamond < 1) {
                    g2d.drawImage(null, slotsX + 15, slotsY + 30, 40, 40, null);
                }
            }
            if (lantern || gp.player.lanternBuy) {
                g2d.drawImage(gp.player.inventory.get(i).lantern, slotsX + 15, slotsY + 125, 40, 40, null);
                if (cursorX == 53 && cursorY == 409) {
                    g2d.drawString("Lantern : This item cannot be sold", slotsX + 70, slotsY + 230);
                    if (!lantern) {
                        String text = " ";
                        g2d.drawString(text, slotsX + 140, slotsY + 230);
                    }
                }
            }
            if (gp.player.mana > 0) {
                g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 107, slotsY + 125, 40, 40, null);
                g2d.drawString(" " + gp.player.mana, slotsX + 139, slotsY + 155);
                if (cursorX == 149 && cursorY == 409) {
                    price = 10;
                    g2d.drawString("Manacoin : " + price + " dincoin", slotsX + 50, slotsY + 230);
                    if (keys.sellBuy) {
                        gp.player.mana--;
                        gp.player.coin = gp.player.coin + price;
                        keys.sellBuy = false;
                    }
                }
            }
            if (gp.player.mana <= 0) {
                g2d.drawImage(null, slotsX + 107, slotsY + 125, 40, 40, null);
            }
        }
    }

    public void dialoguesScreen(int x, int y, int width, int height) {
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x, y, width, height + 70, 25, 25);
        g2d.setColor(new Color(20, 82, 20));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height + 60, 30, 30);
    }


    public void draw(Graphics2D g2d) {
        counter++;
        this.g2d = g2d;
        if (gp.state == gp.dialogueStateWithVillagers) {
            dialogueScreenWithVillager();
            progressBar(g2d, currentProgress);
        }
        if (gp.state == gp.dialogueStateWithMerchant) {
            dialogueScreenWithMerchant();
        }
        if (gp.state == gp.inventoryState) {
            inventory();
        }
        if (gp.state == gp.information) {
            information();
            progressBar(g2d, currentProgress);
        }
        if (gp.state == gp.dialogueScreen) {
            dialogueScreenWithMerchant();
        }
        if (gp.state == gp.chestState) {
            chestScreen();
        }

        if (message) {
            g2d.setFont(new Font(null, Font.BOLD | Font.ITALIC, 20));
            g2d.setColor(Color.white);
            g2d.drawString(messageShow, 10, 820);
        }
        if (counter > 5) {
            counter = 0;
            message = false;
        }
    }

    public void chestScreen() {
        int x = gp.size * 3;
        int y = gp.size * 7;
        int width = gp.size * 9;
        int height = gp.size * 2;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x, y, width, height + 85, 25, 25);
        g2d.setColor(new Color(20, 85, 20));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height + 75, 30, 30);
        g2d.setFont(new Font(null, Font.ITALIC, 15));
        g2d.setColor(Color.white);
        g2d.drawString("YOU OBTAIN 15 MANACOINS!", 240, 360);
        g2d.drawString("YOU OBTAIN 1 KEY!", 240, 390);
        g2d.drawString("YOU OBTAIN 3 DIAMONDS!", 240, 420);
        g2d.drawImage(manaCoin, 240, 455, 45, 45, null);
        g2d.drawImage(diamondImg, 300, 455, 45, 45, null);
        g2d.drawImage(keyImg, 360, 455, 45, 45, null);
        g2d.drawImage(chestOpen, 530, 340, 35, 35, null);
    }

    public void inventory() {
        int x = gp.size * 3;
        int y = gp.size * 6;
        int width = gp.size * 9;
        int height = gp.size * 5;
        g2d.setColor(new Color(26, 26, 0));
        g2d.fillRoundRect(x, y, width, height, 25, 25);
        g2d.setColor(new Color(20, 82, 21));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height - 10, 30, 30);
        final int slotsX = x + 20;
        final int slotsY = y + 20;
        int cursorX = slotsX + (gp.size * slotCol) - 5;
        int cursorY = slotsY + (gp.size * slotRow) - 5;
        int cursorWidth = 35;
        int cursorHeight = 35;
        playerInInventory();
        g2d.setFont(new Font(null, Font.BOLD, 10));
        g2d.setColor(Color.white);
        g2d.setColor(new Color(26, 26, 0));
        g2d.drawRoundRect(cursorX + 5, cursorY, 76, 71, 15, 15);
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            g2d.drawImage(gp.player.inventory.get(i).coin, slotsX + 15, slotsY - 5, cursorWidth, cursorHeight, null);
            g2d.setColor(Color.white);
            g2d.drawString("COIN x" + gp.player.coin, slotsX + 12, slotsY + 55);

            if (calculator || gp.player.calculatorBuy) {
                g2d.drawImage(gp.player.inventory.get(i).calculator, slotsX + 107, slotsY - 3, cursorWidth, cursorHeight, null);
                g2d.setColor(Color.white);
                g2d.drawString("CALCULATOR", slotsX + 100, slotsY + 55);
            }
            if (!calculator) {
                g2d.drawImage(null, slotsX + 107, slotsY - 3, cursorWidth, cursorHeight, null);
                String text = " ";
                g2d.drawString(text, slotsX + 100, slotsY + 55);
            }
            if (gp.player.diamond >= 1 || gp.player.diamondBuy == 1) {
                g2d.drawImage(gp.player.inventory.get(i).diamond, slotsX + 202, slotsY - 5, cursorWidth, cursorHeight, null);
                g2d.setColor(Color.white);
                g2d.drawString("DIAMOND x" + gp.player.diamond, slotsX + 200, slotsY + 55);
            }
            if (gp.player.diamondBuy < 1) {
                g2d.drawImage(null, slotsX + 15, slotsY + 30, 40, 40, null);
                String text = " ";
                g2d.drawString(text, slotsX + 40, slotsY + 70);
            }
            if (lantern || gp.player.lanternBuy) {
                g2d.drawImage(gp.player.inventory.get(i).lantern, slotsX + 15, slotsY + 95, cursorWidth, cursorHeight, null);
                g2d.setColor(Color.white);
                g2d.drawString("LANTERN", slotsX + 15, slotsY + 155);
            }

            if (!lantern) {
                g2d.drawImage(null, slotsX + 15, slotsY + 95, cursorWidth, cursorHeight, null);
                String text = " ";
                g2d.drawString(text, slotsX + 15, slotsY + 155);
            }
            if (gp.player.key >= 1 || gp.player.keyBuy > 0) {
                g2d.drawImage(gp.player.inventory.get(i).key, slotsX + 107, slotsY + 95, cursorWidth, cursorHeight, null);
                g2d.setColor(Color.white);
                g2d.drawString("KEY x" + gp.player.key, slotsX + 107, slotsY + 155);
            }
            if (gp.player.key < 1) {
                g2d.drawImage(null, slotsX + 15, slotsY + 30, 40, 40, null);
                String text = " ";
                g2d.drawString(text, slotsX + 40, slotsY + 70);
            }
            g2d.drawImage(gp.player.inventory.get(i).manaCoin, slotsX + 205, slotsY + 95, cursorWidth + 5, cursorHeight + 5, null);
            g2d.setColor(Color.white);
            g2d.drawString("MANA x" + gp.player.mana, slotsX + 205, slotsY + 155);
        }
    }

    public void playerInInventory() {
        int width = gp.size;
        int height = gp.size;
        g2d.setColor(new Color(26, 26, 0));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(480, 300, width + 40, height + 100, 15, 15);
        if (spriteNum == 1) {
            g2d.drawImage(dinoLeftUpLeft, 490, 340, 80, 80, null);
        }
        if (spriteNum == 2) {
            g2d.drawImage(dinoRightUpLeft, 490, 340, 80, 80, null);
        }
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void progressBar(Graphics2D g2d, double progress) {
        int x = 10;
        int y = 10;
        int width = (int) ((gp.screenWidth - 50) * progress);
        int height = 50;
        g2d.setColor(new Color(0, 26, 0, 190));
        g2d.fillRoundRect(x, y, gp.screenWidth - 50, height, 25, 25);
        g2d.setColor(new Color(0, 0, 0, 170));
        g2d.fillRoundRect(x + 5, y + 5, gp.screenWidth - 60, height - 10, 30, 30);
        g2d.setColor(new Color(0, 255, 0));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height - 10, 30, 30);
        g2d.setFont(new Font("MV Boli", Font.BOLD, 25));
        g2d.setColor(Color.white);
        g2d.drawString(String.format("%.1f%%", progress * 100), (gp.screenWidth - 60) / 2, 45);
    }

    public void information() {
        int x = 400;
        int y = 750;
        int width = 335;
        int height = 50;
        g2d.setColor(new Color(102, 255, 102, 170));
        g2d.fillRoundRect(x, y, width, height, 25, 25);
        g2d.setColor(new Color(179, 255, 179, 170));
        g2d.fillRoundRect(x + 5, y + 5, width - 10, height - 10, 30, 30);
        g2d.setFont(new Font("Arial", Font.ITALIC, 20));
        g2d.setColor(Color.BLACK);
        g2d.drawString("X:" + gp.player.worldX, 420, 780);
        g2d.drawString("Y:" + gp.player.worldY, 520, 780);
        g2d.drawString("FPS:" + gp.count, 620, 780);
    }
}