package Totorial.RPG;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class   Keys implements KeyListener {
    public boolean up, down, left, right, interact, talk, teleport, choose, sellBuy,
            nextDialogue, selected, chestOpen, verify;
    GamePanel gp;
    Calculator calculator;
    public Keys(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = true;
        }
        if (key == KeyEvent.VK_S) {
            down = true;
        }
        if (key == KeyEvent.VK_A) {
            left = true;
        }
        if (key == KeyEvent.VK_D) {
            right = true;
        }
        if (key == KeyEvent.VK_E) {
            interact = true;
        }
        if (key == KeyEvent.VK_R) {
            if (gp.state == gp.inventoryState) {
                gp.state = gp.playState;
            } else if (gp.state == gp.playState) {
                gp.state = gp.inventoryState;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (gp.state == gp.playState) {
                gp.state = gp.pauseState;
            } else if (gp.state == gp.pauseState) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.inventoryState) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.dialogueStateWithMerchant) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.dialogueScreen) {
                gp.state = gp.playState;
            }
            if (gp.state == gp.chestState) {
                gp.state = gp.playState;
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            nextDialogue = true;
        }
        if (key == KeyEvent.VK_ENTER) {
            verify = true;
        }
        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (key == KeyEvent.VK_T) {
            talk = true;
        }
        if (key == KeyEvent.VK_1) {
            if (gp.state == gp.playState) {
                gp.state = gp.information;
            } else if (gp.state == gp.information) {
                gp.state = gp.playState;
            }
        }
        if (key == KeyEvent.VK_NUMPAD8) {
            if (gp.ui.slotRow != 0) {
                gp.ui.slotRow = gp.ui.slotRow - 2;
            }
        }
        if (key == KeyEvent.VK_NUMPAD2) {
            if (gp.ui.slotRow != 2) {
                gp.ui.slotRow = gp.ui.slotRow + 2;
            }
        }
        if (key == KeyEvent.VK_NUMPAD4) {
            if (gp.ui.slotCol != 0) {
                gp.ui.slotCol = gp.ui.slotCol - 2;
            }
        }
        if (key == KeyEvent.VK_NUMPAD6) {
            if (gp.ui.slotCol != 4) {
                gp.ui.slotCol = gp.ui.slotCol + 2;
            }
        }
        if (key == KeyEvent.VK_NUMPAD8) {
            if (gp.ui.slotRow2 != 0) {
                gp.ui.slotRow2 = gp.ui.slotRow2 - 1;
            }
        }
        if (key == KeyEvent.VK_NUMPAD2) {
            if (gp.ui.slotRow2 != 2) {
                gp.ui.slotRow2 = gp.ui.slotRow2 + 1;
            }
        }

        if (key == KeyEvent.VK_C) {
            if (gp.ui.calculator || gp.player.calculatorBuy == 1) {
                calculator = new Calculator();
                calculator.jFrame.setVisible(true);
            }
        }
        if (key == KeyEvent.VK_H) {
            teleport = true;
        }
        if (key == KeyEvent.VK_ENTER) {
            choose = true;
        }
        if (gp.ui.subState == 0) {
            if (key == KeyEvent.VK_DOWN) {
                gp.ui.choose--;
                if (gp.ui.choose < 1) {
                    gp.ui.choose = 2;
                }
            }
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            sellBuy = true;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            selected = true;
        }
        if (key == KeyEvent.VK_Q) {
            chestOpen = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = false;
        }
        if (key == KeyEvent.VK_S) {
            down = false;
        }
        if (key == KeyEvent.VK_A) {
            left = false;
        }
        if (key == KeyEvent.VK_D) {
            right = false;
        }
        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_T) {
            talk = false;
        }
        if (key == KeyEvent.VK_H) {
            teleport = false;
        }
        if (key == KeyEvent.VK_E) {
            interact = false;
        }
        if (key == KeyEvent.VK_Q) {
            chestOpen = false;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            sellBuy = false;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            selected = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            verify = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            nextDialogue = false;
        }
    }
}