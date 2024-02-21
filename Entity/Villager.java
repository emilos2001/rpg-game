package Totorial.RPG.Entity;

import Totorial.RPG.GamePanel;
import Totorial.RPG.Keys;
import Totorial.RPG.Menu.MyJdbc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Villager extends Entity {
    public int actionNpc = 0;
    MyJdbc myJdbc = new MyJdbc();
    Keys keys;
    public Villager(GamePanel gp) {
        super(gp);
        keys = new Keys(gp);
        npcDirection = "right";
        speed = 2;
        name = "VILLAGER";
        getNpcImages();
    }

    public void setDialog() {
        try {
            List<String> extractedQuestions = myJdbc.extractQuestions();
            List<String> extractedAnswers = myJdbc.extractAnswers();
            if (myJdbc.isEmpty()){
                System.out.println("table is empty");
            } else {
                //villager 1
                questions[0][0] = extractedQuestions.get(0);
                answers[0][0][0] = extractedAnswers.get(0);
                answers[0][0][1] = extractedAnswers.get(1);
                answers[0][0][2] = extractedAnswers.get(2);
                answers[0][0][3] = extractedAnswers.get(3);
                answers[0][0][4] = extractedAnswers.get(4);
                questions[0][1] = extractedQuestions.get(1);
                answers[0][1][0] = extractedAnswers.get(5);
                answers[0][1][1] = extractedAnswers.get(6);
                answers[0][1][2] = extractedAnswers.get(7);
                answers[0][1][3] = extractedAnswers.get(8);
                answers[0][1][4] = extractedAnswers.get(9);
              /*  questions[0][2] = extractedQuestions.get(2);
                answers[0][2][0] = extractedAnswers.get(10);
                answers[0][2][1] = extractedAnswers.get(11);
                answers[0][2][2] = extractedAnswers.get(12);
                answers[0][2][3] = extractedAnswers.get(13);
                answers[0][2][4] = extractedAnswers.get(14);
                questions[0][3] = extractedQuestions.get(3);
                answers[0][3][0] = extractedAnswers.get(15);
                answers[0][3][1] = extractedAnswers.get(16);
                answers[0][3][2] = extractedAnswers.get(17);
                answers[0][3][3] = extractedAnswers.get(18);
                answers[0][3][4] = extractedAnswers.get(19);
                questions[0][4] = extractedQuestions.get(4);
                answers[0][4][0] = extractedAnswers.get(20);
                answers[0][4][1] = extractedAnswers.get(21);
                answers[0][4][2] = extractedAnswers.get(22);
                answers[0][4][3] = extractedAnswers.get(23);
                answers[0][4][4] = extractedAnswers.get(24);
                questions[1][0] = extractedQuestions.get(5);
                answers[1][0][0] = extractedAnswers.get(25);
                answers[1][0][1] = extractedAnswers.get(26);
                answers[1][0][2] = extractedAnswers.get(27);
                answers[1][0][3] = extractedAnswers.get(28);
                answers[1][0][4] = extractedAnswers.get(29);
                questions[1][1] = extractedQuestions.get(5);
                answers[1][1][0] = extractedAnswers.get(30);
                answers[1][1][1] = extractedAnswers.get(31);
                answers[1][1][2] = extractedAnswers.get(32);
                answers[1][1][3] = extractedAnswers.get(34);
                answers[1][1][4] = extractedAnswers.get(35);
                questions[1][2] = extractedQuestions.get(6);
                answers[1][2][0] = extractedAnswers.get(36);
                answers[1][2][1] = extractedAnswers.get(37);
                answers[1][2][2] = extractedAnswers.get(38);
                answers[1][2][3] = extractedAnswers.get(39);
                answers[1][2][4] = extractedAnswers.get(40);
                questions[1][3] = extractedQuestions.get(7);
                answers[1][3][0] = extractedAnswers.get(41);
                answers[1][3][1] = extractedAnswers.get(42);
                answers[1][3][2] = extractedAnswers.get(43);
                answers[1][3][3] = extractedAnswers.get(44);
                answers[1][3][4] = extractedAnswers.get(45);
                questions[1][4] = extractedQuestions.get(7);
                answers[1][4][0] = extractedAnswers.get(46);
                answers[1][4][1] = extractedAnswers.get(47);
                answers[1][4][2] = extractedAnswers.get(48);
                answers[1][4][3] = extractedAnswers.get(49);
                answers[1][4][4] = extractedAnswers.get(50);
                questions[2][0] = extractedQuestions.get(8);
                answers[2][0][0] = extractedAnswers.get(51);
                answers[2][0][1] = extractedAnswers.get(52);
                answers[2][0][2] = extractedAnswers.get(53);
                answers[2][0][3] = extractedAnswers.get(54);
                answers[2][0][4] = extractedAnswers.get(55);
                questions[2][1] = extractedQuestions.get(9);
                answers[2][1][0] = extractedAnswers.get(56);
                answers[2][1][1] = extractedAnswers.get(57);
                answers[2][1][2] = extractedAnswers.get(58);
                answers[2][1][3] = extractedAnswers.get(59);
                answers[2][1][4] = extractedAnswers.get(60);
                questions[2][1] = extractedQuestions.get(10);
                answers[2][1][0] = extractedAnswers.get(61);
                answers[2][1][1] = extractedAnswers.get(62);
                answers[2][1][2] = extractedAnswers.get(63);
                answers[2][1][3] = extractedAnswers.get(64);
                answers[2][1][4] = extractedAnswers.get(65);
                questions[2][2] = extractedQuestions.get(11);
                answers[2][2][0] = extractedAnswers.get(65);
                answers[2][2][1] = extractedAnswers.get(66);
                answers[2][2][2] = extractedAnswers.get(67);
                answers[2][2][3] = extractedAnswers.get(69);
                answers[2][2][4] = extractedAnswers.get(70);
                questions[2][3] = extractedQuestions.get(12);
                answers[2][3][0] = extractedAnswers.get(71);
                answers[2][3][1] = extractedAnswers.get(72);
                answers[2][3][2] = extractedAnswers.get(73);
                answers[2][3][3] = extractedAnswers.get(74);
                answers[2][3][4] = extractedAnswers.get(75);
                questions[2][4] = extractedQuestions.get(13);
                answers[2][4][0] = extractedAnswers.get(76);
                answers[2][4][1] = extractedAnswers.get(77);
                answers[2][4][2] = extractedAnswers.get(78);
                answers[2][4][3] = extractedAnswers.get(79);
                answers[2][4][4] = extractedAnswers.get(80);
                questions[3][0] = extractedQuestions.get(14);
                answers[3][0][0] = extractedAnswers.get(81);
                answers[3][0][1] = extractedAnswers.get(82);
                answers[3][0][2] = extractedAnswers.get(83);
                answers[3][0][3] = extractedAnswers.get(84);
                answers[3][0][4] = extractedAnswers.get(85);
                questions[3][1] = extractedQuestions.get(15);
                answers[3][1][0] = extractedAnswers.get(86);
                answers[3][1][1] = extractedAnswers.get(87);
                answers[3][1][2] = extractedAnswers.get(88);
                answers[3][1][3] = extractedAnswers.get(89);
                answers[3][1][4] = extractedAnswers.get(90);
                questions[3][2] = extractedQuestions.get(16);
                answers[3][2][0] = extractedAnswers.get(91);
                answers[3][2][1] = extractedAnswers.get(92);
                answers[3][2][2] = extractedAnswers.get(93);
                answers[3][2][3] = extractedAnswers.get(94);
                answers[3][2][4] = extractedAnswers.get(95);
                questions[3][4] = extractedQuestions.get(16);
                answers[3][4][0] = extractedAnswers.get(96);
                answers[3][4][1] = extractedAnswers.get(97);
                answers[3][4][2] = extractedAnswers.get(98);
                answers[3][4][3] = extractedAnswers.get(99);
                answers[3][4][4] = extractedAnswers.get(100);
                questions[4][0] = extractedQuestions.get(17);
                answers[4][0][0] = extractedAnswers.get(101);
                answers[4][0][1] = extractedAnswers.get(102);
                answers[4][0][2] = extractedAnswers.get(103);
                answers[4][0][3] = extractedAnswers.get(104);
                answers[4][0][4] = extractedAnswers.get(105);
                questions[4][1] = extractedQuestions.get(18);
                answers[4][1][0] = extractedAnswers.get(106);
                answers[4][1][1] = extractedAnswers.get(107);
                answers[4][1][2] = extractedAnswers.get(108);
                answers[4][1][3] = extractedAnswers.get(109);
                answers[4][1][4] = extractedAnswers.get(110);
                questions[4][3] = extractedQuestions.get(19);
                answers[4][3][0] = extractedAnswers.get(111);
                answers[4][3][1] = extractedAnswers.get(112);
                answers[4][3][2] = extractedAnswers.get(113);
                answers[4][3][3] = extractedAnswers.get(114);
                answers[4][3][4] = extractedAnswers.get(115);
                questions[4][4] = extractedQuestions.get(20);
                answers[4][4][0] = extractedAnswers.get(116);
                answers[4][4][1] = extractedAnswers.get(117);
                answers[4][4][2] = extractedAnswers.get(118);
                answers[4][4][3] = extractedAnswers.get(119);
                answers[4][4][4] = extractedAnswers.get(120);
                questions[5][0] = extractedQuestions.get(20);
                answers[5][0][0] = extractedAnswers.get(121);
                answers[5][0][1] = extractedAnswers.get(122);
                answers[5][0][2] = extractedAnswers.get(123);
                answers[5][0][3] = extractedAnswers.get(124);
                answers[5][0][4] = extractedAnswers.get(125);
                questions[5][1] = extractedQuestions.get(21);
                answers[5][1][0] = extractedAnswers.get(126);
                answers[5][1][1] = extractedAnswers.get(127);
                answers[5][1][2] = extractedAnswers.get(128);
                answers[5][1][3] = extractedAnswers.get(129);
                answers[5][1][4] = extractedAnswers.get(130);
                questions[5][2] = extractedQuestions.get(22);
                answers[5][2][0] = extractedAnswers.get(131);
                answers[5][2][1] = extractedAnswers.get(132);
                answers[5][2][2] = extractedAnswers.get(133);
                answers[5][2][3] = extractedAnswers.get(134);
                answers[5][2][4] = extractedAnswers.get(135);
                questions[5][3] = extractedQuestions.get(23);
                answers[5][3][0] = extractedAnswers.get(136);
                answers[5][3][1] = extractedAnswers.get(137);
                answers[5][3][2] = extractedAnswers.get(138);
                answers[5][3][3] = extractedAnswers.get(139);
                answers[5][3][4] = extractedAnswers.get(140);
                questions[5][4] = extractedQuestions.get(24);
                answers[5][4][0] = extractedAnswers.get(141);
                answers[5][4][1] = extractedAnswers.get(142);
                answers[5][4][2] = extractedAnswers.get(143);
                answers[5][4][3] = extractedAnswers.get(144);
                answers[5][4][4] = extractedAnswers.get(145);
                questions[6][0] = extractedQuestions.get(25);
                answers[6][0][0] = extractedAnswers.get(146);
                answers[6][0][1] = extractedAnswers.get(147);
                answers[6][0][2] = extractedAnswers.get(148);
                answers[6][0][3] = extractedAnswers.get(149);
                answers[6][0][4] = extractedAnswers.get(150);
                questions[6][1] = extractedQuestions.get(26);
                answers[6][1][0] = extractedAnswers.get(151);
                answers[6][1][1] = extractedAnswers.get(152);
                answers[6][1][2] = extractedAnswers.get(153);
                answers[6][1][3] = extractedAnswers.get(154);
                answers[6][1][4] = extractedAnswers.get(155);
                questions[6][2] = extractedQuestions.get(27);
                answers[6][2][0] = extractedAnswers.get(156);
                answers[6][2][1] = extractedAnswers.get(157);
                answers[6][2][2] = extractedAnswers.get(158);
                answers[6][2][3] = extractedAnswers.get(159);
                answers[6][2][4] = extractedAnswers.get(160);
                questions[6][3] = extractedQuestions.get(28);
                answers[6][3][0] = extractedAnswers.get(161);
                answers[6][3][1] = extractedAnswers.get(162);
                answers[6][3][2] = extractedAnswers.get(163);
                answers[6][3][3] = extractedAnswers.get(164);
                answers[6][3][4] = extractedAnswers.get(165);
                questions[6][4] = extractedQuestions.get(29);
                answers[6][4][0] = extractedAnswers.get(166);
                answers[6][4][1] = extractedAnswers.get(167);
                answers[6][4][2] = extractedAnswers.get(168);
                answers[6][4][3] = extractedAnswers.get(169);
                answers[6][4][4] = extractedAnswers.get(170);
                questions[7][0] = extractedQuestions.get(30);
                answers[7][0][0] = extractedAnswers.get(171);
                answers[7][0][1] = extractedAnswers.get(172);
                answers[7][0][2] = extractedAnswers.get(173);
                answers[7][0][3] = extractedAnswers.get(174);
                answers[7][0][4] = extractedAnswers.get(175);
                questions[7][1] = extractedQuestions.get(31);
                answers[7][1][0] = extractedAnswers.get(176);
                answers[7][1][1] = extractedAnswers.get(177);
                answers[7][1][2] = extractedAnswers.get(178);
                answers[7][1][3] = extractedAnswers.get(179);
                answers[7][1][4] = extractedAnswers.get(180);
                questions[7][2] = extractedQuestions.get(32);
                answers[7][2][0] = extractedAnswers.get(181);
                answers[7][2][1] = extractedAnswers.get(182);
                answers[7][2][2] = extractedAnswers.get(183);
                answers[7][2][3] = extractedAnswers.get(184);
                answers[7][2][4] = extractedAnswers.get(185);
                questions[7][3] = extractedQuestions.get(33);
                answers[7][3][0] = extractedAnswers.get(186);
                answers[7][3][1] = extractedAnswers.get(187);
                answers[7][3][2] = extractedAnswers.get(188);
                answers[7][3][3] = extractedAnswers.get(189);
                answers[7][3][4] = extractedAnswers.get(190);
                questions[7][4] = extractedQuestions.get(34);
                answers[7][4][0] = extractedAnswers.get(191);
                answers[7][4][1] = extractedAnswers.get(192);
                answers[7][4][2] = extractedAnswers.get(193);
                answers[7][4][3] = extractedAnswers.get(194);
                answers[7][4][4] = extractedAnswers.get(195);*/
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void getNpcImages() {
        try {
            npcUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_up_1.png")));
            npcUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_up_2.png")));
            npcDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_down_1.png")));
            npcDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_down_2.png")));
            npcLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_left_1.png")));
            npcLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_left_2.png")));
            npcRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_right_1.png")));
            npcRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("oldman_right_2.png")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void npcStoppedImages() {
        switch (npcDirection) {
            case "up" -> image = npcUp1;
            case "down" -> image = npcDown1;
            case "left" -> image = npcLeft1;
            case "right" -> image = npcRight1;
        }
    }

    public void draw(Graphics2D g2d, GamePanel gp) {
        setAction();
        collision = false;
        gp.collisions.checkTileForNpcs(this);
        if (!collision) {
            switch (npcDirection) {
                case "up" -> {
                    if (spriteNum == 1) {
                        image = npcUp1;
                        worldY -= speed;
                    } else if (spriteNum == 2) {
                        image = npcUp2;
                        worldY -= speed;
                    }
                }
                case "down" -> {
                    if (spriteNum == 1) {
                        image = npcDown1;
                        worldY += speed;
                    } else if (spriteNum == 2) {
                        image = npcDown2;
                        worldY += speed;
                    }
                }
                case "left" -> {
                    if (spriteNum == 1) {
                        image = npcLeft1;
                        worldX -= speed;
                    } else if (spriteNum == 2) {
                        image = npcLeft2;
                        worldX -= speed;
                    }
                }
                case "right" -> {
                    if (spriteNum == 1) {
                        image = npcRight1;
                        worldX += speed;
                    } else if (spriteNum == 2) {
                        image = npcRight2;
                        worldX += speed;
                    }
                }
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
        if (gp.state == gp.dialogueStateWithMerchant) {
            npcStoppedImages();
        }

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2d.drawImage(image, screenX, screenY, gp.size, gp.size, null);
    }


    public void setAction() {
        actionNpc++;
        if (actionNpc == 35) {
            Random random = new Random();
            int i = random.nextInt(10) + 1;
            if (i < 3) {
                npcDirection = "up";
            }
            if (i > 3 && i < 6) {
                npcDirection = "down";
            }
            if (i > 6 && i < 9) {
                npcDirection = "left";
            }
            if (i == 10) {
                npcDirection = "right";
            }
            actionNpc = 0;
        }
    }
}
