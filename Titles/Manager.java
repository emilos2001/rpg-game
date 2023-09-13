package Totorial.RPG.Titles;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Manager {
    GamePanel gp;
    Tile[] tile;
    int[][][] map;

    public Manager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        map = new int[gp.maxNumberMaps][gp.maxWorldCol][gp.maxWorldRow];
        getTileImg();
        loadMap("src/Totorial/RPG/Titles/exterior.txt", 0);
        loadMap("src/Totorial/RPG/Titles/houses.txt", 1);
        loadMap("src/Totorial/RPG/Titles/castle.txt", 2);
    }

    public void getTileImg() {
        try {
            for (int i = 0; i < tile.length; i++) {
                tile[i] = new Tile();
            }
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Ground.png")));//0
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("sand.png")));//1
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water01.png")));//2
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water02.png")));//3
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water03.png")));//4
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water04.png")));//5
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water05.png")));//6
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water06.png")));//7
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water07.png")));//8
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water08.png")));//9
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("water09.png")));//10
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tree.png")));//11
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("wall.png")));//12
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("wood.png")));//13
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("house.png")));//14
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("table.png")));//15

            tile[3].collision = true;
            tile[4].collision = true;
            tile[5].collision = true;
            tile[6].collision = true;
            tile[7].collision = true;
            tile[8].collision = true;
            tile[9].collision = true;
            tile[11].collision = true;
            tile[12].collision = true;
            tile[14].collision = true;
            tile[15].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String fileName, int numberOfMap) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = bufferedReader.readLine();
                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    map[numberOfMap][col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = map[gp.currentMap][worldCol][worldRow];
            int worldX = worldCol * gp.size;
            int worldY = worldRow * gp.size;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.size, gp.size, null);
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}