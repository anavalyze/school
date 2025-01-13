import java.util.HashMap;
import java.util.Map;

// Klasse mit Attributen
class MonsterAttribute {
    // Attribute
    int leben;
    int schaden;
    int ausweichen;
    int kritisch;
    int gibt_Coins;
    int gibt_Erfahrung;

    // Konstruktor
    public MonsterAttribute(int leben, int schaden, int ausweichen, int kritisch, int gibt_Coins, int gibt_Erfahrung) {
        this.leben = leben;
        this.schaden = schaden;
        this.ausweichen = ausweichen;
        this.kritisch = kritisch;
        this.gibt_Coins = gibt_Coins;
        this.gibt_Erfahrung = gibt_Erfahrung;
    }
}

// Primare Monster Klasse
public class Monster{
    // Attribute
    private int leben;
    private String name;
    private int schaden;
    private int ausweichen; // Wahrscheinlichkeit, dass ein Monster dem Angriff ausweicht
    private int kritisch;   // Kritischer Treffer Wahrscheinlichkeit
    private int gibt_Coins; // Ingame Wahrung
    private int gibt_Erfahrung; // Erfahrungspunkte

    // Map um die Attribute dem Namen zuzuordnen
    private static final Map<String, MonsterAttribute> monsterMap = new HashMap<>();

    // Zuordnung der Attributwerte zu spezifischen Namen
    static {
        // Dunkler Wald
        monsterMap.put("Wolf", new MonsterAttribute(25, 6, 15, 15, 15, 25));
        monsterMap.put("Spinne", new MonsterAttribute(15, 4, 25, 25, 15, 15));
        monsterMap.put("Bar", new MonsterAttribute(40, 18, 5, 50, 50, 65));
        monsterMap.put("Schlange", new MonsterAttribute(12, 10, 15, 35, 25, 20));
        monsterMap.put("Eber", new MonsterAttribute(20, 8, 60, 15, 30, 25));

        // Verlassene Mine
        monsterMap.put("Golem", new MonsterAttribute(60, 8, 0, 40, 40, 50));
        monsterMap.put("Rauber", new MonsterAttribute(18, 5, 20, 15, 8, 25));
        monsterMap.put("Weglagerer", new MonsterAttribute(12, 4, 10, 10, 5, 25));
        monsterMap.put("Troll", new MonsterAttribute(35, 15, 5, 10, 45, 55));

        // Altes Schloss
        monsterMap.put("Geist", new MonsterAttribute(10, 8, 60, 10, 20, 30));
        monsterMap.put("Skelett", new MonsterAttribute(15, 10, 5, 10, 12, 25));
        monsterMap.put("Hexe", new MonsterAttribute(20, 35, 10, 15, 50, 40));
        monsterMap.put("Zombie", new MonsterAttribute(5, 18, 0, 70, 8, 8));
        monsterMap.put("Falke", new MonsterAttribute(15, 20, 40, 30, 25, 30));
        monsterMap.put("Wachter", new MonsterAttribute(50, 15, 0, 20, 70, 100));

        // Berg
        monsterMap.put("Riese", new MonsterAttribute(50, 18, 5, 15, 35, 60));
        monsterMap.put("Hund", new MonsterAttribute(10, 3, 20, 30, 6, 25));
        monsterMap.put("Bergwandler", new MonsterAttribute(40, 10, 20, 30, 30, 40));
        monsterMap.put("Hohlenbar", new MonsterAttribute(35, 15, 10, 25, 35, 45));

        // Drachenhohle
        monsterMap.put("Magier", new MonsterAttribute(40, 18, 20, 25, 35, 60));
        monsterMap.put("Hollenhund", new MonsterAttribute(45, 22, 15, 30, 50, 75));

        // Boss
        monsterMap.put("Drache", new MonsterAttribute(200, 45, 25, 60, 300, 400));

        monsterMap.put("TestMonster", new MonsterAttribute(1000, 50, 0, 0, 0, 0));
    }

    // Konstrukor, der Attribute der Monster holt
    public Monster(String newName) {
        MonsterAttribute attribute = monsterMap.get(newName);
        if (attribute != null) {
            this.leben = attribute.leben;
            this.name = newName;
            this.schaden = attribute.schaden;
            this.ausweichen = attribute.ausweichen;
            this.kritisch = attribute.kritisch;
            this.gibt_Coins = attribute.gibt_Coins;
            this.gibt_Erfahrung = attribute.gibt_Erfahrung;
        } else {
            // default
            this.leben = 0;
            this.name = "Fehlgeburt";
            this.schaden = 0;
            this.ausweichen = 0;
            this.kritisch = 0;
            this.gibt_Coins = 0;
            this.gibt_Erfahrung = 0;
        }
    }

    // Konstruktor um Monster manuell zu erstellen
    public Monster(int newLeben, String newName, int newSchaden, int newAusweichen, int newKritisch, int newCoins, int newErfahrung) {
        this.leben = newLeben;
        this.name = newName;
        this.schaden = newSchaden;
        this.ausweichen = newAusweichen;
        this.kritisch = newKritisch;
        this.gibt_Coins = newCoins;
        this.gibt_Erfahrung = newErfahrung;
    }

    // getter
    public int getLeben() { 
		return leben; 
	}
    public String getName() { 
		return name; 
	}
    public int getSchaden() { 
		return schaden; 
	}
    public int getAusweichen() { 
		return ausweichen; 
	}
    public int getKritisch() { 
		return kritisch; 
	}
    public int getGibt_Coins() { 
		return gibt_Coins; 
	}
    public int getGibt_Erfahrung() { 
		return gibt_Erfahrung; 
	}

	// Monster lebt noch und nimmt Schaden
    public boolean isAlive() {
        return this.leben > 0;
    }
    public void nimmSchaden(int damage) {
        this.leben -= damage;
        if (this.leben < 0) {
            this.leben = 0;
        }
    }
}

/*

Kapitel 2 Monster:

String[] wuste = {"Schlange", "Spinne", "Skorpion", "Wustenskelett", "Grabrauber", "Mumie", "Wustenwurm", "Sandkriecher", "Dunenwachter", "Sphinx", "Pharao"};

String[] wuste = {"Schlange", "Spinne", "Skorpion", "Wustenskelett"};

String[] pyramide = {"Grabrauber", "Mumie", "Sphinx","Skarabaus"};

String[] dune = {"Wustenwurm", "Sandkriecher", "Dunenwachter", "Schlange", "Skorpion"};

String[] wustentempel = {"Pharao", "Skarabaus", "Sphinx", "Mumie"};

 */


/*

Kapitel 3 Monster:

String[] eis = {"Frostwolf", "Eisgeist", "Eisbar", "Frostspinne", "Winterhexe", "Frostskorpion", "Frost-Phoenix", "Frost-Rabe", "Eisdrache", "Schneegolem", "Gefrorener Troll", "Eis-Skelett", "Eis-Wachter", "Frost-Engel", "Frostspinne", "Schnee-Samurai", "Eis-Laufer", "Eis-Luchs", "Gletscher-Titan", "Eisriese", "Frostskorpion", "Frost-Engel", "Eis-Skelett", "Eis-Wachter", "Frost-Rabe"};

String[] eiswuste = {"Frostwolf", "Eisgeist", "Eisbar", "Frostspinne", "Winterhexe", "Frostskorpion", "Frost-Phoenix", "Frost-Rabe"};

String[] eishohle = {"Eisdrache", "Schneegolem", "Gefrorener Troll", "Eis-Skelett", "Eis-Wachter", "Frost-Engel"};

String[] gefrorenerSee = {"Frostspinne", "Schnee-Samurai", "Eis-Laufer", "Eis-Luchs"};

String[] gletscherklippen = {"Gletscher-Titan", "Eisriese", "Frostskorpion"};

String[] eisschloss = {"Frost-Engel", "Eis-Skelett", "Eis-Wachter", "Frost-Rabe"};

 */

/* 

Kapitel 4 Monster: 

String[] holle = {}

*/