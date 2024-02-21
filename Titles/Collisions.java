package Totorial.RPG.Titles;

import Totorial.RPG.Entity.Entity;
import Totorial.RPG.GamePanel;

public class Collisions {

    GamePanel gp;

    public Collisions(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTileForPlayer(Entity entity) {
        int entityLeftX = entity.worldX + entity.solid.x;
        int entityRightX = entity.worldX + entity.solid.x + entity.solid.width;
        int entityTopY = entity.worldY + entity.solid.y;
        int entityBottomY = entity.worldY + entity.solid.y + entity.solid.height;

        int leftCol = entityLeftX / gp.size;
        int rightCol = entityRightX / gp.size;
        int topRow = entityTopY / gp.size;
        int bottomRow = entityBottomY / gp.size;

        int num1, num2;
        switch (entity.playerDirection) {
            case "up" -> {
                topRow = (entityTopY - entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][topRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][topRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "down" -> {
                bottomRow = (entityBottomY + entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][bottomRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "left" -> {
                leftCol = (entityLeftX - entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][topRow];
                num2 = gp.manager.map[gp.currentMap][leftCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "right" -> {
                rightCol = (entityRightX + entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][rightCol][topRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
        }
    }

    public void checkTileForNpcs(Entity entity) {
        int entityLeftX = entity.worldX + (entity.solid.x * 2);
        int entityRightX = entity.worldX + (entity.solid.x * 2) + entity.solid.width;
        int entityTopY = entity.worldY + (entity.solid.y * 2);
        int entityBottomY = entity.worldY + (entity.solid.y * 2) + (entity.solid.height * 2);

        int leftCol = entityLeftX / gp.size;
        int rightCol = entityRightX / gp.size;
        int topRow = entityTopY / gp.size;
        int bottomRow = entityBottomY / gp.size;

        int num1, num2;
        switch (entity.npcDirection) {
            case "up" -> {
                topRow = (entityTopY - entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][topRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][topRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "down" -> {
                bottomRow = (entityBottomY + entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][bottomRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "left" -> {
                leftCol = (entityLeftX - entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][leftCol][topRow];
                num2 = gp.manager.map[gp.currentMap][leftCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
            case "right" -> {
                rightCol = (entityRightX + entity.speed) / gp.size;
                num1 = gp.manager.map[gp.currentMap][rightCol][topRow];
                num2 = gp.manager.map[gp.currentMap][rightCol][bottomRow];
                if (gp.manager.tile[num1].collision ||
                        gp.manager.tile[num2].collision) {
                    entity.collision = true;
                }
            }
        }
    }

    public int checkObj(Entity entity) {
        int index = 999;
        entity.solid.x += entity.worldX;
        entity.solid.y += entity.worldY;
        for (int i = 0; i < gp.supObject[1].length; i++) {
            if (gp.supObject[gp.currentMap][i] != null) {
                gp.supObject[gp.currentMap][i].solid.x += gp.supObject[gp.currentMap][i].worldX;
                gp.supObject[gp.currentMap][i].solid.y += gp.supObject[gp.currentMap][i].worldY;
                if (entity.solid.intersects(gp.supObject[gp.currentMap][i].solid)) {
                    index = i;
                }
                gp.supObject[gp.currentMap][i].solid.x = gp.supObject[gp.currentMap][i].solidDefaultX;
                gp.supObject[gp.currentMap][i].solid.y = gp.supObject[gp.currentMap][i].solidDefaultY;
            }
        }
        entity.solid.x = entity.solidDefaultX;
        entity.solid.y = entity.solidDefaultY;
        return index;
    }


    public int checkNpc(Entity entity) {
        int index = 999;
        entity.solid.x += entity.worldX;
        entity.solid.y += entity.worldY;
        for (int i = 0; i < gp.entities[1].length; i++) {
            if (gp.entities[gp.currentMap][i] != null) {
                gp.entities[gp.currentMap][i].solid.x += gp.entities[gp.currentMap][i].worldX;
                gp.entities[gp.currentMap][i].solid.y += gp.entities[gp.currentMap][i].worldY;
                if (entity.solid.intersects(gp.entities[gp.currentMap][i].solid)) {
                    index = i;
                }
                gp.entities[gp.currentMap][i].solid.x = gp.entities[gp.currentMap][i].solidDefaultX;
                gp.entities[gp.currentMap][i].solid.y = gp.entities[gp.currentMap][i].solidDefaultY;

            }
        }
        entity.solid.x = entity.solidDefaultX;
        entity.solid.y = entity.solidDefaultY;
        return index;
    }
}

