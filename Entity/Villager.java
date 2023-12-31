package Totorial.RPG.Entity;

import Totorial.RPG.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Villager extends Entity {
    public int actionNpc = 0;

    public Villager(GamePanel gp) {
        super(gp);
        npcDirection = "right";
        speed = 2;
        name = "VILLAGER";
        setDialogue();
        getNpcImages();
    }


    public void setDialogue() {
        //1st villager
        questions[0][0] = "Care este valoarea anuității pentru un credit bancar în valoare de 100.000 care se\n" +
                "rambursează cu anuități constante pe o perioadă de 2 ani, cu rambursări semestriale\n" +
                "și cu o rată a dobânzii anuale de 12%?\n";
        options[0][0][0] = "A        32.923";
        options[0][0][1] = "B        25.000";
        options[0][0][2] = "C        28.859";
        correctOption[0][0] = options[0][0][2];

        questions[0][1] = "În cadrul gestiunii prin excepție a clienților se urmărește:\n ";
        options[0][1][0] = "A         Încadrarea clienților pe clase de risc și menținerea unor proporții pentru fiecare\n" +
                "           clasă de risc definită";
        options[0][1][1] = "B        Exceptarea din cadrul portofoliului de clienți a acelor clienți cărora li s-au acordat\n" +
                "            termene foarte scurte de plată";
        options[0][1][2] = "C        Exceptarea din cadrul portofoliului de clienți a acelor clienți cărora li s-au acordat\n" +
                "            termene foarte lungi de plată\n";
        correctOption[0][1] = options[0][1][0];

        questions[0][2] = "Un necesar de fond de rulment negatov rezultată al creșterii vitezei de rotație a\n" +
                "stocurilor și creanțelor reprezintă pentru întreprindere o situație";
        options[0][2][0] = "A        Nefavorabilă în condițiile în care trezoreria netă este pozitivă";
        options[0][2][1] = "B        favorabilă";
        options[0][2][2] = "C        Nefavorabilă";
        correctOption[0][2] = options[0][2][2];

        questions[0][3] = "În care din următoarele cazuri existența unei trezorerii nete pozitive nu poate fi\n" +
                "considerată un fapt pozitiv?\n";
        options[0][3][0] = "A        Fond de rulment negativ și necesar de fond de rulment negativ mai mare în suma\n" +
                "           absolută în comparație cu fondul de rulment net";
        options[0][3][1] = "B        Fond de rulment net pozitiv este inferior procentului de 33% din CA (Cifra de Afaceri) și\n"
                +"          necesarul de fond de rulment este pozitiv, dar inferior fondului de rulment net.";
        options[0][3][2] = "C        Fond de rulment pozitiv și necesar rulment negativ apărut ca urmare a creșterii\n" +
                "           vitezei de rotație a stocurilor și creanțelor";
        correctOption[0][3] = options[0][3][1];

        questions[0][4] = "Încadrarea creditului solicitat de către societatea comercială în categoria C de\n" +
                "performanță semnifică";
        options[0][4][0] = "A        Performanțe financiare scăzute, în condițiile unor fluctuații ciclice la intervale\n" +
                "           scurte de timp";
        options[0][4][1] = "B         Performanțe financiare actuale și cele previzionate sunt foarte bune";
        options[0][4][2] = "C         Performanțe financiare actuale sunt foarte bune sau bune, dar pe\n" +
                "           termen lung nivelul actual al acestora nu se poate menține.";
        correctOption[0][4] = options[0][4][2];
        //2nd villager
        questions[1][0] = "Care ar fi procentul maxim al discountului acordat la plate unui produl unui client\n" +
                "pentru a-l face atractiv în condițiile în care dacă același client plătește marfa la\n" +
                "termen de 90 de zile costul resurselor împrumutate pentru a finanța creditul client în\n" +
                "valoare de 2500 RON este de 8% pe luna:";
        options[1][0][0] = "A        16%";
        options[1][0][1] = "B        8%";
        options[1][0][2] = "C        24%";
        correctOption[1][0] = options[1][0][1];

        questions[1][1] = "Lichiditatea societății comerciale depinde de: a.evoluția în timp a activelor lichide,\n" +
                "b.evoluția în timp a imobilizărilor; c.evoluția în timp a pasivelor exigibile";
        options[1][1][0] = "A        a+b";
        options[1][1][1] = "B        b+c";
        options[1][1][2] = "C        a+b+c";
        correctOption[1][1] = options[1][1][2];

        questions[1][2] = "Un fond de rulment propriu negativ reflectă:";
        options[1][2][0] = "A        Un echilibru stabil utilizări-resurse pe termen lung";
        options[1][2][1] = "B         O autonomie financiară a societății capabilă să acopere finanțarea integrală a\n" +
                "           activelor imobilizate și parțială a activelor circulante";
        options[1][2][2] = "C        Finanțarea parțială a activelor imobilizate prin intermediul capitalurilor permanente\n" +
                "           și parțial din datorii pe termen scurt.";
        correctOption[1][2] = options[1][2][2];

        questions[1][3] = "În cadrul contractului de leasing financiar plata activului specific către furnizor se\n" +
                "realizează de către:";
        options[1][3][0] = "A         Locatar";
        options[1][3][1] = "B         Banca locatarului";
        options[1][3][2] = "C         Locator";
        correctOption[1][3] = options[1][3][0];

        questions[1][4] = "Valoarea netă de rambursat aferentă unui contract de leasing în valoare de 100.000\n" +
                "ca valoarea avansului și valoarea reziduală 20% respectiv 15% din valoarea\n" +
                "contractului care se derulează pe parcursul a doi ani ( cu rambursări semestriale), cu\n" +
                "o rată a dobânzii anuale de 8% și cu anuități constante este:";
        options[1][4][0] = "A        34.463";
        options[1][4][1] = "B        362.407";
        options[1][4][2] = "C        19.625";
        correctOption[1][4] = options[1][4][1];

        //3rd villager
        questions[2][0] = "În cadrul politicii echilibrate de finanțare a activelor circulante:";
        options[2][0][0] = "A        Toate activele circulante permanente sunt finanțate din resurse aferente datoriilor\n" +
                "           pe termen scurt";
        options[2][0][1] = "B        Toate activele circulante permanente sunt finanțate din resurse pe termen lung\n";
        options[2][0][2] = "C        O parte a activelor circulante permanente sunt fiinanțate de resurse aferent\n" +
                "           datoriilor pe termen scurt";
        correctOption[2][0] = options[2][0][0];

        questions[2][1] = "Rata lichidității curente se determină ca:";
        options[2][1][0] = "A        Disponibilității/datorii pe termen scurt";
        options[2][1][1] = "B         Active curente /datorii curente";
        options[2][1][2] = "C        (creanțe de exploatare + disponibilități) /datorii curente";
        correctOption[2][1] = options[2][1][2];

        questions[2][2] = " Cine calculează și evidențiază amortizarea activului care face obiectul leasingului în\n" +
                "cazul leasingului financiar:";
        options[2][2][0] = "A        Locatorul";
        options[2][2][1] = "B        Locatorul";
        options[2][2][2] = "C        Societatea care a realizat respectivul activ";
        correctOption[2][2] = options[2][2][0];

        questions[2][3] = "Ciclul de conversie a numerarului se calculează ca fiind:";
        options[2][3][0] = "A        Perioada de conversie a stocurilor – perioada de întârziere a plățiilor + perioada de\n" +
                "          conversie a efectelor comerciale de primit";
        options[2][3][1] = "B        Perioada de conversie a stocurilor + perioada de întârziere a plățiilor + perioada de\n" +
                "           conversie a efectelor comerciale de primit";
        options[2][3][2] = "C        Perioada de conversie a stocurilor + perioada de întârziere a plățiilor + perioada de\n" +
                "           conversie a efectelor comerciale de primit";
        correctOption[2][3] = options[2][3][1];

        questions[2][4] = "Care dintre urmatoarele elemente conduc la cresterea fondului de rulment: a)\n" +
                "reducerea capitalurilor proprii, b) emisiunea de actiuni c) vanzarea de mijloace fixe";
        options[2][4][0] = "A        B+c";
        options[2][4][1] = "B        A+b+c";
        options[2][4][2] = "C        A+b";
        correctOption[2][4] = options[2][4][2];

        //4th villager
        questions[3][0] = "Prin emisiunea de bilete de trezorerie societatile comerciale isi procura";
        options[3][0][0] = "A        capitaluri imprumutate pe termen lung";
        options[3][0][1] = "B        capitaluri proprii externe";
        options[3][0][2] = "C        capitaluri imprumutate pe termen scurt";
        correctOption[3][0] = options[3][0][2];

        questions[3][1] = " In cadrul politicii agresive de finantare a activelor circulante";
        options[3][1][0] = "A        O parte a activelor circulante permanente sunt finantate din resurse aferente\n" +
                "           datoriilor pe termen scurt ";
        options[3][1][1] = "B        Toate activele circulante permanente sunt finantate din resurse pe termen lung";
        options[3][1][2] = "C        Toate activele circulante permanente sunt finantate din resurse aferente datoriilor\n" +
                "           pe termen scurt";
        correctOption[3][1] = options[3][1][0];

        questions[3][2] = " Biletele de trezorerie sunt emise de catre societati pentru a face fata necesitatilor curente de\n" +
                "finantare la o rata a dobanzii:";
        options[3][2][0] = "A        superioara celei de pe piata monetara";
        options[3][2][1] = "B        egala cu cea de pe piata monetara";
        options[3][2][2] = "C        inferioara celei de pe piata monetara a creditului";
        correctOption[3][2] = options[3][2][2];

        questions[3][3] = "În cadrul sistemului celor 5C pentru estimarea calității creditului, capitalul se referă la:";
        options[3][3][0] = "A        abilitatea clientului de a realiza plati";
        options[3][3][1] = "B        Situația financiară generală a clientului";
        options[3][3][2] = "C        propabilitatea ca un client sa incerce sa onoreze obligatia sa de plata";
        correctOption[3][3] = options[3][3][1];

        questions[3][4] = "In cazul in care valoarea stocurilor este de 45.000, valoarea efectelor comerciale de primit este\n" +
                "34.000, valoarea efectelor comerciale de plata etede 56.000, valoarea cifrei de afaceri este de\n" +
                "560.000 iar costul total al achizitiilor este de 389.000, perioada medie de colectare este:";
        options[3][4][0] = "A        29 de zile";
        options[3][4][1] = "B        53 de zile";
        options[3][4][2] = "C        26 de zile";
        correctOption[3][4] = options[3][4][2];

        //5th villager
        questions[4][0] = "Modul sintetic de estimare al pasivelor stabile consta in";
        options[4][0][0] = "A         determinarea numarului mediu de zile de intarziere al platilor cuvenite furnizorilor si \n" +
                "           inmultirea " +
                "" +
                "acestora cu aprovizionarile previzonate zilnice";
        options[4][0][1] = "B        determinarea datoriilor cu sold variabil si termene de plata variabile si insumarea lor";
        options[4][0][2] = "C        Însumarea soldurilor medii zilnice a elementelor cu sold zilnic crescător și " +
                "           termen fix de plată.";
        correctOption[4][0] = options[4][0][2];

        questions[4][1] = " În cazul contractului de leasing financiar alegerea activului specific ce va fi finanțat în\n" +
                "cadrul contractului se realizează de către:";
        options[4][1][0] = "A        Furnizorul bunului";
        options[4][1][1] = "B        Locatar";
        options[4][1][2] = "C        Locator";
        correctOption[4][1] = options[4][1][1];

        questions[4][2] = "Costurile administrative sunt în cazul contractării unui credit, în raport cu cele aferente\n" +
                "emisiunii de acțiuni:";
        options[4][2][0] = "A        Mai mici";
        options[4][2][1] = "B        Egale";
        options[4][2][2] = "C        Mai mari";
        correctOption[4][2] = options[4][2][2];

        questions[4][3] = "Perisabilitatea produselor vândute afectează perioadele de creditare a clienților în\n" +
                "sensul";
        options[4][3][0] = "A        Creșterii acestora";
        options[4][3][1] = "B        Scăderii acestora";
        options[4][3][2] = "C        Menținerii neschimbate";
        correctOption[4][3] = options[4][3][0];

        questions[4][4] = "Care dinre următoarele afirmații este falsă:";
        options[4][4][0] = "A        Valoarea negativă a fondului de rulment reflect un dezechilibru atat pe termen lung\n" +
                "           cât și pe termen scurt";
        options[4][4][1] = "B        Valoarea negativă a fondului de rulment reflectă un excedent de disponibilități pe\n" +
                "           termen lung ce poate fi utilizat pe termen scurt";
        options[4][4][2] = "C         Valoarea pozitivă a fondului de rulment permite finanțarea unei părți din necesarul\n" +
                "           de fond de rulment pe baza fondului de rulment\n";
        correctOption[4][4] = options[4][4][1];

        //6th villager
        questions[5][0] = "Ce metodă de control a stocurilor ați folosi pentru a ține evidența stocurilor de\n" +
                "materii prime în condițiile în care aceste materii prime sunt reprezentate de nisip și\n" +
                "pietriș?\n";
        options[5][0][0] = "A        Metoda codurilor de bare";
        options[5][0][1] = "B        Metoda identificării frecvenței radio";
        options[5][0][2] = "C        Metoda liniei roșii";
        correctOption[5][0] = options[5][0][0];

        questions[5][1] = "Care dintre următoarele formule reprezintă expresia fondului de rulment:";
        options[5][1][0] = "A        FR= capital permanent – active imobilizate";
        options[5][1][1] = "B        FR= active circulante – stocuri fără mișcare";
        options[5][1][2] = "C        FR = active imobilizate – datorii pe termen scurt";
        correctOption[5][1] = options[5][1][2];

        questions[5][2] = "Care dintre următorii factori nu se iau in considerare la determinarea volumului\n" +
                "necesar al stocurilor:";
        options[5][2][0] = "A        Gradul de uzură a mijloacelor fixe";
        options[5][2][1] = "B        Perisabilitatea materiilor prime";
        options[5][2][2] = "C        Volumul estimat al vanzărilor";
        correctOption[5][2] = options[5][2][0];

        questions[5][3] = "Serviciul datoriei este considerat slab atunci cand ratele și dovânzile sunt plătite cu\n" +
                "întârziere de până la:";
        options[5][3][0] = "A        12 zile";
        options[5][3][1] = "B        30 zile";
        options[5][3][2] = "C        90 zile";
        correctOption[5][3] = options[5][3][1];

        questions[5][4] = " În cazul metodei analitice de determinare a pasivului stabil pentru datoriile furnizori\n" +
                "numărul mediu de zile de întârziere a plăților se determină:";
        options[5][4][0] = "A        Ca medie ponderată a numerelor de zile de întârziere a plăților la facturile\n" +
                "           anterioare cu valoriile facturilor respective";
        options[5][4][1] = "B        Ca medie simplă aritmetică a numerelor de zile de întârziere a plăților la facturile\n" +
                "           anterioare";
        options[5][4][2] = "C        Ca medie simplă aritmetică a numerelor de zile de întârziere a plăților la facturile\n" +
                "           anterioare";
        correctOption[5][4] = options[5][4][2];

        //7th villager
        questions[6][0] = "Perioada de tragere in cazul unui credit bancar reprezinta:";
        options[6][0][0] = "A        Suma dintre perioada de gratie si perioada in care se ramburseaza creditul";
        options[6][0][1] = "B        Perioada dintre angajarea integrala si data primei rate scadente";
        options[6][0][2] = "C        Perioada din momentul in care se angajeaza contractul de punere a creditului la\n" +
                "           dispozitia societatii imprumutate si pana la angajarea integrala a creditului";
        correctOption[6][0] = options[6][0][2];

        questions[6][1] = "Costurile administrative sunt in cazul contractarii unui credit, in raport cu cele aferente emisiunii\n" +
                "de actiuni:";
        options[6][1][0] = "A        Mai mari";
        options[6][1][1] = "B        Egale";
        options[6][1][2] = "C        Mai mici";
        correctOption[6][1] = options[6][1][0];

        questions[6][2] = "Modelul sintetic de estimare al pasivelor stabile constă în:";
        options[6][2][0] = "A        însumarea soldurilor medii zilnice a elementelor cu sold zilnic crescător și termen fix\n" +
                "           de plată";
        options[6][2][1] = "B        determinarea datoriilor cu sold variabil și termene de plată variabile și însumarea lor";
        options[6][2][2] = "C        determinarea numărului mediu de zile de întârziere al plăților cuvenite furnizorilor și\n" +
                "           înmulțirea acestuia cu aprovizionările previzionate zilnice";
        correctOption[6][2] = options[6][2][1];

        questions[6][3] = "Care din urmatoarele elemente conduc la cresterea fondului de\n" +
                "rulment : a) reducerea cap.propri, b) emisiunia de actiunu, c)\n" +
                "vanzarea de mijloace fixe :";
        options[6][3][0] = "A        a+b+c";
        options[6][3][1] = "B        b+c";
        options[6][3][2] = "C        a+b";
        correctOption[6][3] = options[6][3][0];

        questions[6][4] = "Care din urmatoarele elemente de active are cea mai mica\n" +
                "lichiditate :";
        options[6][4][0] = "A        Creante asupra tertilor";
        options[6][4][1] = "B        Stacurile de materii prime si materiale";
        options[6][4][2] = "C        Actiunile ale unor firme coate detinute in portofoliu investitional al\n" +
                "           societatii comerciale";
        correctOption[6][4] = options[6][4][2];

        //8th villager
        questions[7][0] = "In functiile scor folosite pentru aprecierea calitatii creditului acordat\n" +
                "clientilor riscul de faliment reprezinta :";
        options[7][0][0] = "A        Variabila dependent a ecuatiei liniare ";
        options[7][0][1] = "B        Variabila independent a ecuatiei liniare ";
        options[7][0][2] = "C        Coeficientul de importanta folosit pentru aprecierea impactului unei\n" +
                "           modificari cu o unitate a variabilelor independente";
        correctOption[7][0] = options[7][0][0];

        questions[7][1] = "Incadrarea creditului solicitat de catre societatea comerciala in categoria B de performanta\n" +
                "semnifica:";
        options[7][1][0] = "A        performante financiare scazute, in conditiile unor fluctuatii ciclice la intervale scurte de timp";
        options[7][1][1] = "B        performantele financiare actuale si cele previzionate sunt foarte bune";
        options[7][1][2] = "C         performanțele financiare actuale sunt foarte bune sau bune, dar pe termen lung\n"
                + "         nivelul actual al acestora nu se poate menține.";
        correctOption[7][1] = options[7][1][2];

        questions[7][2] = "Care dintre urmatoarele afirmatii este falsa?";
        options[7][2][0] = "A        valoarea negativa a fondului de rulment reflecta un excedent de disponibilitati pe\n" +
                "           termen lung ce poate fi utilizat pe termen scurt.";
        options[7][2][1] = "B        valoarea negativa a fondului de rulment reflecta un dezechilibru atat pe termen\n" +
                "           lung cat si pe termen scurt";
        options[7][2][2] = "C        valoarea pozitiva a fondului de rulment permite finantarea unei pari din necesarul\n" +
                "           de fond de rulment pe baza fondului de rulment";
        correctOption[7][2] = options[7][2][0];

        questions[7][3] = "În situația în care o societate, datorită amânării plățiilor, ajunge să aibă\n" +
                "datorii de exploatare mai mari ca valoarea stocurilor materiale și a creanțelor,\n" +
                "necesarul de fond de rulment devine:";
        options[7][3][0] = "A        neutru";
        options[7][3][1] = "B        negativ";
        options[7][3][2] = "C        pozitiv";
        correctOption[7][3] = options[7][3][1];

        questions[7][4] = "Politica de participare directă vizează";
        options[7][4][0] = "A         asigurarea unei rate relativ constante de distribuire a proftului din profitul net\n" +
                "           pe acțiune";
        options[7][4][1] = "B        menținerea dividendelor la nivelul anterior sau asigurarea unei creșteri anuale\n" +
                "           ale acesteia";
        options[7][4][2] = "C        plata de dividende numai dacă profitul net disponibil este superior celui\n" +
                "           necesar pentru finanțarea investițiilor considerate oportune";
        correctOption[7][4] = options[7][4][2];
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

    public void npcPositionWhilePause() {
        switch (npcDirection) {
            case "up" -> npcDirection = "up";
            case "down" -> npcDirection = "down";
            case "left" -> npcDirection = "left";
            case "right" -> npcDirection = "right";
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
        switch (npcDirection) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = npcUp1;
                } else if (spriteNum == 2) {
                    image = npcUp2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = npcDown1;
                } else if (spriteNum == 2) {
                    image = npcDown2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = npcLeft1;
                } else if (spriteNum == 2) {
                    image = npcLeft2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = npcRight1;
                } else if (spriteNum == 2) {
                    image = npcRight2;
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

        if (gp.state == gp.pauseState) {
            npcPositionWhilePause();
            npcStoppedImages();
        }

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2d.drawImage(image, screenX, screenY, gp.size, gp.size, null);
    }


    public void setAction() {
        actionNpc++;
        if (actionNpc == 200) {
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