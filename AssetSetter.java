package Totorial.RPG;

import Totorial.RPG.Entity.Merchant;
import Totorial.RPG.Entity.Villager;
import Totorial.RPG.Obj.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setIronDoor(){
        gp.supObject[gp.exteriorMap][13] = new IronDoor(gp);
        gp.supObject[gp.exteriorMap][13].worldX = 2015;
        gp.supObject[gp.exteriorMap][13].worldY = 424;
        gp.supObject[gp.castleMap][14] = new Stairs(gp);
        gp.supObject[gp.castleMap][14].worldX = 530;
        gp.supObject[gp.castleMap][14].worldY = 189;
    }
    public void setHouses(){
        gp.supObject[gp.exteriorMap][3] = new House(gp);
        gp.supObject[gp.exteriorMap][3].worldX = 774;
        gp.supObject[gp.exteriorMap][3].worldY = 143;
        gp.supObject[gp.exteriorMap][4] = new House(gp);
        gp.supObject[gp.exteriorMap][4].worldX = 348;
        gp.supObject[gp.exteriorMap][4].worldY = 720;
        gp.supObject[gp.exteriorMap][5] = new House(gp);
        gp.supObject[gp.exteriorMap][5].worldX = 338;
        gp.supObject[gp.exteriorMap][5].worldY = 880;
        gp.supObject[gp.exteriorMap][6] = new House(gp);
        gp.supObject[gp.exteriorMap][6].worldX = 386;
        gp.supObject[gp.exteriorMap][6].worldY = 1436;
        gp.supObject[gp.exteriorMap][7] = new House(gp);
        gp.supObject[gp.exteriorMap][7].worldX = 1058;
        gp.supObject[gp.exteriorMap][7].worldY = 1888;
        gp.supObject[gp.exteriorMap][8] = new House(gp);
        gp.supObject[gp.exteriorMap][8].worldX = 2258;
        gp.supObject[gp.exteriorMap][8].worldY = 1904;
        gp.supObject[gp.exteriorMap][9] = new House(gp);
        gp.supObject[gp.exteriorMap][9].worldX = 998;
        gp.supObject[gp.exteriorMap][9].worldY = 1108;
        gp.supObject[gp.exteriorMap][10] = new House(gp);
        gp.supObject[gp.exteriorMap][10].worldX = 2546;
        gp.supObject[gp.exteriorMap][10].worldY = 191;
        gp.supObject[gp.exteriorMap][11] = new House(gp);
        gp.supObject[gp.exteriorMap][11].worldX = 1298;
        gp.supObject[gp.exteriorMap][11].worldY = 300;
        gp.supObject[gp.houseMap][12] = new Door(gp);
        gp.supObject[gp.houseMap][12].worldX = 1250;
        gp.supObject[gp.houseMap][12].worldY = 815;
    }
    public void setObj() {
        gp.supObject[gp.exteriorMap][0] = new KeyObj(gp);
        gp.supObject[gp.exteriorMap][0].worldX = 478;
        gp.supObject[gp.exteriorMap][0].worldY = 144;
        gp.supObject[gp.exteriorMap][1] = new CalcObj(gp);
        gp.supObject[gp.exteriorMap][1].worldX = 283;
        gp.supObject[gp.exteriorMap][1].worldY = 1492;
        gp.supObject[gp.exteriorMap][2] = new Diamond(gp);
        gp.supObject[gp.exteriorMap][2].worldX = 1935;
        gp.supObject[gp.exteriorMap][2].worldY = 315;
        gp.supObject[gp.houseMap][13] = new Chest(gp);
        gp.supObject[gp.houseMap][13].worldX = 1258;
        gp.supObject[gp.houseMap][13].worldY = 344;
        gp.supObject[gp.castleMap][15] = new KeyObj(gp);
        gp.supObject[gp.castleMap][15].worldX = 550;
        gp.supObject[gp.castleMap][15].worldY = 436;
        gp.supObject[gp.castleMap][16] = new Chest(gp);
        gp.supObject[gp.castleMap][16].worldX = 960;
        gp.supObject[gp.castleMap][16].worldY = 999;
        gp.supObject[gp.castleMap][17] = new Chest(gp);
        gp.supObject[gp.castleMap][17].worldX = 1174;
        gp.supObject[gp.castleMap][17].worldY = 1140;
        gp.supObject[gp.castleMap][18] = new KeyObj(gp);
        gp.supObject[gp.castleMap][18].worldX = 1586;
        gp.supObject[gp.castleMap][18].worldY = 1148;
        gp.supObject[gp.castleMap][19] = new Chest(gp);
        gp.supObject[gp.castleMap][19].worldX = 1506;
        gp.supObject[gp.castleMap][19].worldY = 292;
        gp.supObject[gp.castleMap][20] = new KeyObj(gp);
        gp.supObject[gp.castleMap][20].worldX = 1810;
        gp.supObject[gp.castleMap][20].worldY = 235;
        gp.supObject[gp.castleMap][21] = new Chest(gp);
        gp.supObject[gp.castleMap][21].worldX = 1258;
        gp.supObject[gp.castleMap][21].worldY = 2188;
        gp.supObject[gp.castleMap][22] = new Coin(gp);
        gp.supObject[gp.castleMap][22].worldX = 1046;
        gp.supObject[gp.castleMap][22].worldY = 1652;
        gp.supObject[gp.castleMap][23] = new Chest(gp);
        gp.supObject[gp.castleMap][23].worldX = 486;
        gp.supObject[gp.castleMap][23].worldY = 1164;
        gp.supObject[gp.castleMap][24] = new Chest(gp);
        gp.supObject[gp.castleMap][24].worldX = 610;
        gp.supObject[gp.castleMap][24].worldY = 1832;
        gp.supObject[gp.castleMap][25] = new Chest(gp);
        gp.supObject[gp.castleMap][25].worldX = 826;
        gp.supObject[gp.castleMap][25].worldY = 2292;
        gp.supObject[gp.exteriorMap][26] = new Lantern(gp);
        gp.supObject[gp.exteriorMap][26].worldX = 2082;
        gp.supObject[gp.exteriorMap][26].worldY = 352;
        gp.supObject[gp.houseMap][27] = new KeyObj(gp);
        gp.supObject[gp.houseMap][27].worldX = 954;
        gp.supObject[gp.houseMap][27].worldY = 338;
        gp.supObject[gp.houseMap][28] = new Coin(gp);
        gp.supObject[gp.houseMap][28].worldX = 1010;
        gp.supObject[gp.houseMap][28].worldY = 754;
        gp.supObject[gp.exteriorMap][29] = new Coin(gp);
        gp.supObject[gp.exteriorMap][29].worldX = 1014;
        gp.supObject[gp.exteriorMap][29].worldY = 1292;
        gp.supObject[gp.exteriorMap][30] = new Coin(gp);
        gp.supObject[gp.exteriorMap][30].worldX = 1346;
        gp.supObject[gp.exteriorMap][30].worldY = 2304;
        gp.supObject[gp.exteriorMap][31] = new Coin(gp);
        gp.supObject[gp.exteriorMap][31].worldX = 674;
        gp.supObject[gp.exteriorMap][31].worldY = 1776;
        gp.supObject[gp.exteriorMap][32] = new Chest(gp);
        gp.supObject[gp.exteriorMap][32].worldX = 1050;
        gp.supObject[gp.exteriorMap][32].worldY = 1744;
        gp.supObject[gp.exteriorMap][33] = new Coin(gp);
        gp.supObject[gp.exteriorMap][33].worldX = 674;
        gp.supObject[gp.exteriorMap][33].worldY = 1776;
        gp.supObject[gp.castleMap][34] = new Lantern(gp);
        gp.supObject[gp.castleMap][34].worldX = 1538;
        gp.supObject[gp.castleMap][34].worldY = 297;
        gp.supObject[gp.exteriorMap][35] = new KeyObj(gp);
        gp.supObject[gp.exteriorMap][35].worldX = 2482;
        gp.supObject[gp.exteriorMap][35].worldY = 185;
        gp.supObject[gp.exteriorMap][36] = new KeyObj(gp);
        gp.supObject[gp.exteriorMap][36].worldX = 1058;
        gp.supObject[gp.exteriorMap][36].worldY = 1944;
        gp.supObject[gp.castleMap][37] = new Coin(gp);
        gp.supObject[gp.castleMap][37].worldX = 622;
        gp.supObject[gp.castleMap][37].worldY = 884;
        gp.supObject[gp.castleMap][38] = new Coin(gp);
        gp.supObject[gp.castleMap][38].worldX = 1142;
        gp.supObject[gp.castleMap][38].worldY = 656;
        gp.supObject[gp.castleMap][39] = new Coin(gp);
        gp.supObject[gp.castleMap][39].worldX = 2354;
        gp.supObject[gp.castleMap][39].worldY = 620;
        gp.supObject[gp.castleMap][40] = new Coin(gp);
        gp.supObject[gp.castleMap][40].worldX = 2402;
        gp.supObject[gp.castleMap][40].worldY = 656;
        gp.supObject[gp.castleMap][41] = new Coin(gp);
        gp.supObject[gp.castleMap][41].worldX = 2402;
        gp.supObject[gp.castleMap][41].worldY = 656;
        gp.supObject[gp.castleMap][42] = new Coin(gp);
        gp.supObject[gp.castleMap][42].worldX = 998;
        gp.supObject[gp.castleMap][42].worldY = 2156;
        gp.supObject[gp.castleMap][43] = new Coin(gp);
        gp.supObject[gp.castleMap][43].worldX = 710;
        gp.supObject[gp.castleMap][43].worldY = 1136;
        gp.supObject[gp.castleMap][44] = new Coin(gp);
        gp.supObject[gp.castleMap][44].worldX = 790;
        gp.supObject[gp.castleMap][44].worldY = 1748;
        gp.supObject[gp.castleMap][45] = new Coin(gp);
        gp.supObject[gp.castleMap][45].worldX = 998;
        gp.supObject[gp.castleMap][45].worldY = 1820;
    }

    public void setNpc() {
        //villagers
        gp.entities[gp.exteriorMap][0] = new Villager(gp);
        gp.entities[gp.exteriorMap][0].worldX = 682;
        gp.entities[gp.exteriorMap][0].worldY = 188;
        gp.entities[gp.exteriorMap][1] = new Villager(gp);
        gp.entities[gp.exteriorMap][1].worldX = 1922;
        gp.entities[gp.exteriorMap][1].worldY = 1184;
        gp.entities[gp.exteriorMap][2] = new Villager(gp);
        gp.entities[gp.exteriorMap][2].worldX = 2238;
        gp.entities[gp.exteriorMap][2].worldY = 248;
        gp.entities[gp.houseMap][3] = new Villager(gp);
        gp.entities[gp.houseMap][3].worldX = 1466;
        gp.entities[gp.houseMap][3].worldY = 384;
        gp.entities[gp.castleMap][4] = new Villager(gp);
        gp.entities[gp.castleMap][4].worldX = 690;
        gp.entities[gp.castleMap][4].worldY = 196;
        gp.entities[gp.castleMap][5] = new Villager(gp);
        gp.entities[gp.castleMap][5].worldX = 1162;
        gp.entities[gp.castleMap][5].worldY = 2200;
        gp.entities[gp.castleMap][6] = new Villager(gp);
        gp.entities[gp.castleMap][6].worldX = 1586;
        gp.entities[gp.castleMap][6].worldY = 1700;
        gp.entities[gp.castleMap][7] = new Villager(gp);
        gp.entities[gp.castleMap][7].worldX = 1502;
        gp.entities[gp.castleMap][7].worldY = 753;
        gp.entities[gp.exteriorMap][14] = new Villager(gp);
        gp.entities[gp.exteriorMap][14].worldX = 998;
        gp.entities[gp.exteriorMap][14].worldY = 1916;
        //merchant1
        gp.entities[gp.exteriorMap][8] = new Merchant(gp);
        gp.entities[gp.exteriorMap][8].worldX = 1255;
        gp.entities[gp.exteriorMap][8].worldY = 475;
        gp.entities[gp.exteriorMap][9] = new Merchant(gp);
        gp.entities[gp.exteriorMap][9].worldX = 1230;
        gp.entities[gp.exteriorMap][9].worldY = 908;
        gp.entities[gp.houseMap][10] = new Merchant(gp);
        gp.entities[gp.houseMap][10].worldX = 994;
        gp.entities[gp.houseMap][10].worldY = 528;
        gp.entities[gp.castleMap][11] = new Merchant(gp);
        gp.entities[gp.castleMap][11].worldX = 2122;
        gp.entities[gp.castleMap][11].worldY = 612;
        gp.entities[gp.castleMap][12] = new Merchant(gp);
        gp.entities[gp.castleMap][12].worldX = 2366;
        gp.entities[gp.castleMap][12].worldY = 1388;
        gp.entities[gp.castleMap][13] = new Merchant(gp);
        gp.entities[gp.castleMap][13].worldX = 1066;
        gp.entities[gp.castleMap][13].worldY = 2128;
    }
}
