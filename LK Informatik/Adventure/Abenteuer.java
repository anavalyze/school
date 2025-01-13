// Code von Jakob Glaß und Kasimir Ebbing.
// Manche Inhalte wurden von ChatGPT generiert. 


// scanner und random
import java.util.Scanner;
import java.util.Random;

public class Abenteuer{
  // Globale instanziierung scanner und random
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();

  // geschwindigkeit in der der Text ausgegeben wird.
  static int textSpeed = 80;

  // methode der speziellen textausgabe 
    public static void printDelayLn(String text) {  // konstruktor
        for (char zeichen : text.toCharArray()) {       // umwandlung string -> char array, um jeden buchstaben einzeln zu printen
            System.out.print(zeichen);            // char printen
            try {
                Thread.sleep(textSpeed);        // Verzogerung zwischen den Zeichen
            } catch (InterruptedException e) {      // Fehler
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();             // Ln
    }

  // selbe Funktion nur ohne Absatz
  public static void printDelayNoLn(String text) {  // Konstruktor
    for (char zeichen : text.toCharArray()) {       // umwandlung string -> char array um jeden buchstaben einzeln zu printen
            System.out.print(zeichen);            // char printen
            try {
                Thread.sleep(textSpeed);        // Verzogerung zwischen den Zeichen
            } catch (InterruptedException e) {      // Fehler
                Thread.currentThread().interrupt();
            }
        }
  }

  // Arrays der Namen von Dorfbewohnern und Monstern um diese zufallig zu generieren. 
  static String[] mannliche_Dorfbewohner = {  
    "Seppel Strohkopf", "Gerd Ganseblum", "Otto Ochsenschwanz", "Willi Wurstzipfel", 
    "Karl-Heinz Kartoffelkonig", "Hannes Heuhaufen", "Franz Futterkrippe", 
    "Ludwig Latschenklopfer", "Horst Huhnerbein", "Bertl Brennholz", 
    "Fritzi Flachmann", "Peter Plumpsack",
    "Emil Eierkopf", "Herbert Holzscheit", "Theo Tannenfuß", 
    "Kalle Krauterschnaps", "Gustl Gansehaut", "Alfons Apfelkern", "Rupert Rubenkraut"
  };

  static String[] dunklerWaldMonster = {"Wolf", "Spinne", "Bar", "Schlange", "Eber"};
  static String[] verlasseneMineMonster = {"Golem", "Rauber", "Weglagerer", "Troll"};
  static String[] altesSchlossMonster = {"Geist", "Skelett", "Hexe", "Zombie", "Falke"};
  static String[] bergMonster = {"Riese", "Hund", "Bergwandler", "Hohlenbar", "Wolf"};
  static String[] endbossMonster = {"Magier", "Hollenhund"};
  static String Boss = "Drache";

  // Main
  public static void main (String[] args) {

    // Willkommen im Dorf, Beginn des Spiels, Namensgebung, Lesegeschwindigkeit
    printDelayLn("");
    printDelayLn("Hallo Fremder! Willkommen in unserem Dorf! Wie lautet dein Name?");

    // spieler
    String name = scanner.next();
    Held spieler;

    // Lesegeschwindigkeit
    if (!name.equals("Cheater") && !name.equals("Flash")) {
      printDelayLn("Wie schnell liest du " + name + "? (langsam/mittel/schnell)");
      String geschwindigkeit = scanner.next();
      if (geschwindigkeit.equalsIgnoreCase("langsam")) {
        textSpeed = 120;
      } else if (geschwindigkeit.equalsIgnoreCase("mittel")) {
        textSpeed = 80;
      } else if (geschwindigkeit.equalsIgnoreCase("schnell")){
        textSpeed = 40;
      } else {
        textSpeed = 80;
      }
    }

    // Entwicklermodi
    if (name.equals("Cheater")) {
            System.out.println("Entwicklermodus aktiviert!");
            Dorfbewohner freund = new Dorfbewohner(250, "MiniCheater", 30, 10, 10);
      freund.setRustungLvl(6);            // level max
      freund.setWaffeLvl(6);

            spieler = new Held(600, name, 80, 30, 20, 20000, 10000, 6, 0, freund);

      spieler.setRustungLvl(6);
      spieler.setWaffeLvl(6);

            textSpeed = 0;
        } else if (name.equalsIgnoreCase("Flash")) {
            spieler = new Held(100, name, 5, 30, 20, 0, 0, 1, 0, null);
            System.out.println("Hochste Geschwindigkeit aktiviert!");
            textSpeed = 0;
        } else {
            spieler = new Held(100, name, 5, 30, 20, 0, 0, 1, 0, null);
        }

    Schwierigkeit(spieler);

    // Eigentlicher Spielbeginn
    printDelayLn("Hallo " + name + ", unser Dorf ist in Gefahr, Monster bedrohen uns, kannst du uns helfen? (ja/nein) ");

    String will_helfen = scanner.next();

    if (will_helfen.equalsIgnoreCase("ja")) {
      printDelayLn("Vielen Dank, gehe in das Haus des Hauptlings um Munzen fur deine erste Waffe und Rustung zu bekommen.");
    }
    else {
      printDelayLn("Ach was, du wirst uns doch nicht sterben lassen, gehe in das Haus des Hauptlings um Munzen fur deine erste Waffe und Rustung zu bekommen.");
    }

    // Startmunzen
    printDelayLn("Du befindest dich im Haus des Hauptlings. Du bekommst 50 Munzen um dir Ausrustung zu kaufen. Viel Gluck bei deinem ersten Abenteuer!");
    spieler.setCoins(spieler.getCoins() + 50);
    printDelayLn("");
    printDelayLn("Ein Geist erscheint:'Ich habe lange auf dich gewartet! Ich bin Phantomis, dein Mentor. Ich werde dir bei diesem Abenteuer helfen.'");
    printDelayLn("Mit Munzen kannst du dir bessere Ausrustung kaufen. Die Munzen bekommst du, wenn du verschiedene Monster besiegst.");
    printDelayLn("Bist du bereit fur dein erstes Abenteuer? (ja/nein)");

    String bereit_furs_Abenteuer = scanner.next();

    if (bereit_furs_Abenteuer.equalsIgnoreCase("ja")) {
    }
    else {
      printDelayLn("Bist du dir sicher? Unser Dorf braucht deine Hilfe dringend! Du bist unsere letzte Hoffnung.");
      printDelayLn("Ohne dich werden die Monster unser Dorf zerstoren... Willst du wirklich wegsehen? (ja/nein)");
      
      String letzte_Hoffnung = scanner.next();

      if (letzte_Hoffnung.equalsIgnoreCase("nein")) {
        printDelayLn("Das freut mich zu horen! Du wirst uns nicht enttauschen. Bereite dich auf dein Abenteuer vor!");
      } else {
        printDelayLn("Ich verstehe deine Zweifel, aber du wirst es nicht bereuen. Das Abenteuer wartet auf dich!");
        printDelayLn("Bereite dich vor, du wirst ein Held sein.");
      }
    }
    Ortswahl(spieler);
  }

  public static void Schwierigkeit(Held spieler) {
    printDelayLn("Welchen Schwierigkeitsgrad willst du spielen?");
    printDelayLn("(leicht/mittel/schwer/hardcore)");
    printDelayLn("Bei hoherem Schwierigkeitsgrad hast du weniger Leben und machst weniger Schaden.");
    printDelayLn("Außerdem sind die Monster starker und geben weniger Belohnungen.");
    String schwierigkeit = scanner.next();
    if (!schwierigkeit.equals("leicht") && !schwierigkeit.equals("mittel") && !schwierigkeit.equals("schwer") && !schwierigkeit.equals("hardcore")) {
      printDelayLn("Keine gultige Wahl.");
      schwierigkeit = "leicht";
    }
    printDelayLn("Du spielst den Schwierigkeitsgrad \"" + schwierigkeit + "\".");
    spieler.setSchwierigkeit(schwierigkeit);
  }

  public static void Kampf(Held spieler, Monster monster, boolean kannWeglaufen) {

    // Spieler-Angriff-Nachrichten
    String[] spielerAngriffNachricht = {
      "Du sturmst vorwarts und schlagst mit voller Wucht auf %s ein, dabei verursachst du %d Schaden.",
      "Mit einem gezielten Schlag triffst du das Monster %s und fugst ihm %d Schaden zu.",
      "Dein Schwert trifft das Ziel prazise und verursacht Schaden an dem Monster %s. Es hat nun %d Leben weniger."
    };
    // Monster-Angriff-Nachrichten
    String[] monsterAngriffNachricht = {
      "Das Monster %s schlagt zu und verursacht %d Schaden an dir.",
      "Mit brutaler Gewalt trifft das Monster %s dich und verursacht %d Schaden.",
      "Ein heftiger Schlag des Monsters %s trifft dich und fugt dir %d Schaden zu."
    };
    // Dorfbewohner-Angriff-Nachrichten
    String[] dorfbewohnerAngriffNachricht = {
      "%s greift mutig an und trifft das Monster, dabei fugt er ihm %d Schaden zu.",
      "Mit einem geschickten Schlag trifft %s das Monster und verursacht %d Schaden.",
      "%s findet eine Lucke in der Verteidigung des Monsters und fugt ihm %d Schaden zu."
    };
    // Spieler-Ausweichen-Nachrichten
    String[] spielerAusweichenNachricht = {
      "Du machst einen schnellen Ausweichschritt und entgehst dem Angriff des Monsters %s.",
      "Geschickt weichst du dem Angriff des Monsters %s aus, ohne Schaden zu nehmen.",
      "Mit einem eleganten Sprung entkommst du knapp dem Hieb des Monsters %s."
    };
    // Monster-Ausweichen-Nachrichten
    String[] monsterAusweichenNachricht = {
      "Das Monster %s weicht deinem Schlag geschickt aus und entgeht deinem Angriff.",
      "Mit einer schnellen Bewegung entkommt das Monster %s deinem Schlag.",
      "Dein Angriff verfehlt, da das Monster %s rechtzeitig ausweicht."
    };
    // Dorfbewohner-Ausweichen-Nachrichten
    String[] dorfbewohnerAusweichenNachricht = {
      "%s weicht geschickt dem Angriff des Monsters aus und bleibt unverletzt.",
      "Mit blitzschneller Reaktion entgeht %s dem Schlag des Monsters.",
      "%s macht einen raschen Schritt zur Seite und entkommt dem Angriff des Monsters."
    };
    // Spieler-Kritischer-Treffer-Nachrichten
    String[] spielerKritischNachricht = {
      "Ein perfekter Treffer! Du landest einen kritischen Schlag und verursachst %d Schaden.",
      "Dein Angriff trifft genau ins Schwarze, ein kritischer Treffer! %d Schaden.",
      "Mit enormer Prazision triffst du einen wunden Punkt und fugst dem Monster %d kritischen Schaden zu."
    };
    // Monster-Kritischer-Treffer-Nachrichten
    String[] monsterKritischNachricht = {
      "Das Monster %s trifft dich an einer empfindlichen Stelle und verursacht kritischen Schaden! Du verlierst %d Leben.",
      "Ein vernichtender Schlag des Monsters %s trifft dich und verursacht %d kritischen Schaden.",
      "Das Monster %s landet einen schweren Treffer, du erleidest kritischen Schaden in Hohe von %d Leben."
    };
    // Dorfbewohner-Kritischer-Treffer-Nachrichten
    String[] dorfbewohnerKritischNachricht = {
      "%s trifft das Monster mit einem kritischen Schlag und verursacht erheblichen Schaden. Das Monster verliert %d Leben.",
      "Mit einem machtigen Hieb trifft %s das Monster und verursacht %d kritischen Schaden.",
      "%s landet einen kritischen Treffer in Hohe von %d Leben! Das Monster wird schwer verwundet."
    };
    // Spieler-Combo-Treffer-Nachrichten
    String[] spielerComboNachricht = {
      "Du greifst erneut an und triffst das Monster mit einem weiteren machtigen Schlag!",
      "Dein Momentum halt an – du landest einen weiteren Treffer hinterher!",
      "Mit blitzschnellen Bewegungen setzt du eine Kombination von Schlagen an, die das Monster schwer verwundet!"
    };

    // Schwierigkeitsgrad
    String schwierigkeit = spieler.getSchwierigkeit();
  
    // m = monster / s = spieler / d = dorfbewohner, L = leben / S = schaden / C = coins / E = erfahrung, F = faktor
    double mSF, sSF, dSF, sCF, sEF;
  
    if (schwierigkeit.equals("hardcore")) {
      mSF = 1.5;
      sSF = 0.5;
      dSF = 0.75;
      sCF = 0.75;
      sEF = 0.75;
    } else if (schwierigkeit.equals("schwer")) {
      mSF = 1.25;
      sSF = 0.75;
      dSF = 0.9;
      sCF = 0.9;
      sEF = 0.9;
    } else if (schwierigkeit.equals("mittel")) {
      mSF = 1;
      sSF = 1;
      dSF = 1;
      sCF = 1;
      sEF = 1;
    } else {
      mSF = 0.75;
      sSF = 1.5;
      dSF = 1.25;
      sCF = 1.25;
      sEF = 1.25;
    }
  
    Dorfbewohner freund = spieler.getDorfbewohner(); // Dorfbewohner holen
  
    printDelayLn("");
    printDelayLn("Das Monster " + monster.getName() + " steht vor dir.");
    // weglaufen?
    printDelayLn("Willst du kampfen? (ja/nein)");
    String willKampfen = scanner.next();
    // weglaufen und schaden
    if (willKampfen.equalsIgnoreCase("nein")) {
      if (kannWeglaufen) {
        printDelayLn("Du bist geflohen.");
        int erwischt = random.nextInt(100);
        if (erwischt < 70) {    // chance nochmal getroffen zu werden 70%
          printDelayLn("Das Monster " + monster.getName() + " hat dich noch einmal erwischt.");
          int monsterHinterher = Math.max(random.nextInt((int) Math.round(monster.getSchaden() * 1.5 * mSF)), 5); // schaden den das Monster einmalig macht
          printDelayLn(String.format(monsterAngriffNachricht[random.nextInt(monsterAngriffNachricht.length)], monster.getName(), monsterHinterher));
          spieler.nimmSchaden(monsterHinterher);  // Spieler nimmt Schaden beim Fliehen
        } else {
          printDelayLn("Das Monster war zu langsam und hat dich nicht mehr gekriegt.");
        }
        return;
      } else {    // kampf geht weiter
        printDelayLn("Das Monster hat dich uberrascht und du kannst nicht mehr fliehen.");
      }
    }
  
    // Kampf startet hier
    while (monster.isAlive() && spieler.isAlive()) {
  
      // Spieler greift an
      boolean combo = true; // combo hits, wahrscheinlichkeit 30%
      int comboWkeit = 70;
      int hit = 0;
      while (combo && monster.isAlive()) {
        hit++;
        if (hit > 1) {
          printDelayLn(spielerComboNachricht[random.nextInt(spielerComboNachricht.length)]);
        }
        int comboWert = random.nextInt(100);
        if (comboWkeit > comboWert) {
          combo = false;
        }
  
        boolean kritischerTreffer = random.nextInt(100) < spieler.getKritisch();
        int schaden = (int)(spieler.getSchaden() * sSF);
        if (kritischerTreffer) {
          schaden *= 1.5; // Kritischer Treffer, 50% mehr Schaden
          printDelayLn(String.format(spielerKritischNachricht[random.nextInt(spielerKritischNachricht.length)], schaden));
        }
  
        boolean monsterWeichtAus = random.nextInt(100) < monster.getAusweichen();
        if (monsterWeichtAus) {
          printDelayLn(String.format(monsterAusweichenNachricht[random.nextInt(monsterAusweichenNachricht.length)], monster.getName()));
        } else {
          monster.nimmSchaden(schaden);
          printDelayLn(String.format(spielerAngriffNachricht[random.nextInt(spielerAngriffNachricht.length)], monster.getName(), schaden));
        }
      }
  
      // Dorfbewohner greift an (falls vorhanden)
      if (freund != null && freund.isAlive() && monster.isAlive()) {
        printDelayLn(freund.getName() + " unterstutzt dich im Kampf!");
  
        // Dorfbewohner Kritischer Treffer
        boolean dorfbewohnerKritischerTreffer = random.nextInt(100) < freund.getKritisch();
        int dorfbewohnerSchaden = (int)(freund.getSchaden() * dSF);
        if (dorfbewohnerKritischerTreffer) {
          dorfbewohnerSchaden *= 1.5;
          printDelayLn(String.format(dorfbewohnerKritischNachricht[random.nextInt(dorfbewohnerKritischNachricht.length)], freund.getName(), dorfbewohnerSchaden));
        }
  
        monster.nimmSchaden(dorfbewohnerSchaden);
        printDelayLn(String.format(dorfbewohnerAngriffNachricht[random.nextInt(dorfbewohnerAngriffNachricht.length)], freund.getName(), dorfbewohnerSchaden));
      }
  
      // Monster tot?
      if (!monster.isAlive()) {
        printDelayLn("Du hast das Monster " + monster.getName() + " besiegt!");
        printDelayLn("");
        printDelayLn("Du erhaltst " + (int)(monster.getGibt_Coins() * sCF) + " Munzen und " + (int)(monster.getGibt_Erfahrung() * sEF) + " Erfahrung.");
        if (spieler.getAktiveFahigkeit() != null && spieler.getAktiveFahigkeit().equals("Segen der Ahnen")) {
          spieler.setLeben(spieler.getLeben() + 7);
        }
        spieler.setCoins(spieler.getCoins() + (int)(monster.getGibt_Coins() * spieler.getCoinFaktor() * sCF));
        spieler.setErfahrung(spieler.getErfahrung() + (int) (monster.getGibt_Erfahrung() * spieler.getErfFaktor() * sEF));
        printDelayLn("Du hast jetzt " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
        break;
      }
  
      // Monster greift an
      boolean greiftDorfbewohnerAn = freund != null && freund.isAlive() && random.nextInt(100) < 60; // 60% Wahrscheinlichkeit, dass der Dorfbewohner angegriffen wird
  
      if (greiftDorfbewohnerAn) {
        // Monster greift Dorfbewohner an
        printDelayLn("Das Monster greift " + freund.getName() + " an!");
      
        boolean dorfbewohnerWeichtAus = random.nextInt(100) < freund.getAusweichen();
        boolean monsterKritischerTreffer = random.nextInt(100) < monster.getKritisch(); // Kritischer Treffer fur Dorfbewohner
        int monsterSchaden = (int)(monster.getSchaden() * mSF);
      
        if (monsterKritischerTreffer) {
          monsterSchaden *= 1.5; // Kritischer Treffer, 50% mehr Schaden
          printDelayLn(String.format(monsterKritischNachricht[random.nextInt(monsterKritischNachricht.length)], monster.getName(), monsterSchaden));
        }
      
        if (dorfbewohnerWeichtAus) {
          printDelayLn(String.format(dorfbewohnerAusweichenNachricht[random.nextInt(dorfbewohnerAusweichenNachricht.length)], freund.getName()));
        } else {
          freund.nimmSchaden(monsterSchaden);
          printDelayLn(String.format(monsterAngriffNachricht[random.nextInt(monsterAngriffNachricht.length)], freund.getName(), monsterSchaden));
          printDelayLn(freund.getName() + " hat noch " + freund.getLeben() + " ubrig.");
        }
      
        // Dorfbewohner tot?
        if (!freund.isAlive()) {
          printDelayLn(freund.getName() + " wurde vom Monster besiegt.");
        }
      
      } else {
        // Monster greift Spieler an
        printDelayLn("Das Monster greift dich an!");
      
        boolean monsterKritischerTreffer = random.nextInt(100) < monster.getKritisch();
        int monsterSchaden = (int)(monster.getSchaden() * mSF);
        if (monsterKritischerTreffer) {
          monsterSchaden *= 1.5; // Kritischer Treffer, 50% mehr Schaden
          printDelayLn(String.format(monsterKritischNachricht[random.nextInt(monsterKritischNachricht.length)], monster.getName(), monsterSchaden));
        }
      
        boolean spielerWeichtAus = random.nextInt(100) < spieler.getAusweichen();
        if (spielerWeichtAus) {
          printDelayLn(String.format(spielerAusweichenNachricht[random.nextInt(spielerAusweichenNachricht.length)], monster.getName()));
        } else {
          spieler.nimmSchaden(monsterSchaden);
          printDelayLn(String.format(monsterAngriffNachricht[random.nextInt(monsterAngriffNachricht.length)], monster.getName(), monsterSchaden));
          printDelayLn("Du hast noch " + spieler.getLeben() + " Leben ubrig.");
        }
      }
      
  
      // Spieler tot?
      if (!spieler.isAlive()) {
        printDelayLn("Du wurdest von dem Monster " + monster.getName() + " besiegt!");
        printDelayLn("");
        break;
      }
    }
    // Spieler respawnt
    if (!spieler.isAlive()) {
      Respawnen(spieler);
    }
  } 

  // Spieler respawnt, 1/2 munzen, wieder 100 leben
  public static void Respawnen(Held spieler) {
    // Textbausteine fur mehr Vielfalt
    String[] respawnNachrichten = {
      "Zum Gluck haben die Dorfbewohner dich rechtzeitig gefunden.",
      "Die Dorfbewohner entdeckten dich gerade noch rechtzeitig und retteten dich.",
      "Verletzt wurdest du von den Dorfbewohnern gerettet und zuruck ins Dorf gebracht."
    };
    String[] hilfeNachrichten = {
      "Doch auch sie wurden von Monstern angegriffen, und du musst fur ihre Hilfe aufkommen.",
      "Auf dem Weg zuruck wurden ihre Pferde verletzt, und sie erwarten von dir, die Kosten zu tragen.",
      "Leider wurden auch sie angegriffen und fordern nun eine Entschadigung fur ihre Pferde."
    };

    printDelayLn(respawnNachrichten[random.nextInt(respawnNachrichten.length)]);
    printDelayLn(hilfeNachrichten[random.nextInt(hilfeNachrichten.length)]);

    int kosten = spieler.getCoins() / 2;
    printDelayLn("Das kostet dich " + kosten + " Munzen.");
    spieler.setCoins(spieler.getCoins() - kosten);
    spieler.setLeben(100);
    Ortswahl(spieler);
  }

  // Wahl der Level
  // siehe Datei: TextAdventureKarte.jpg um mehr uber die Orte zu erfahren.
  public static void Ortswahl (Held spieler) {
    // Verschiedene Level (Orte), Manche Orte werden ab bestimmten leveln freigeschaltet
    printDelayLn("");
    printDelayLn("Es gibt folgende Orte, zu denen du gehen kannst:");
    printDelayLn("");
    printDelayLn(" - Dorf: Dort findest du den Shop, ein Casino, deinen Mentor und die Kaserne.");
    printDelayLn(" - Der dunkle Wald");
    if (spieler.getLevel() >= 2) {printDelayLn(" - Die verlassene Mine");} else {printDelayLn(" - Verschlossen");}
    if (spieler.getLevel() >= 3) {printDelayLn(" - Das alte Schloss");} else {printDelayLn(" - Verschlossen");}
    if (spieler.getLevel() >= 4) {printDelayLn(" - Der große Berg");} else {printDelayLn(" - Verschlossen");}
    if (spieler.getLevel() >= 5) {printDelayLn(" - Die bedrohliche Drachenhohle");} else {printDelayLn(" - Verschlossen");}
    printDelayLn("");
    printDelayLn(" - Spielstand speichern");
    printDelayLn(" - Spielstand laden");
    printDelayLn("");

    printDelayNoLn("Wohin willst du gehen? (Dorf/Wald");
    if (spieler.getLevel() >= 2) {printDelayNoLn("/Mine");}
    if (spieler.getLevel() >= 3) {printDelayNoLn("/Schloss");}
    if (spieler.getLevel() >= 4) {printDelayNoLn("/Berg");}
    if (spieler.getLevel() >= 5) {printDelayNoLn("/Drachenhohle");}
    printDelayLn("/Speichern/Laden)");
    
    String gewahlter_Ort = scanner.next();

    // Aufruf der Orte
    if (gewahlter_Ort.equals("Dorf")) {
      printDelayLn("Du gehst ins Dorf. Es ist ein geschaftiger Ort mit freundlichen Bewohnern und bunten Standen. Der Duft von frisch gebackenem Brot liegt in der Luft.");
      Dorf(spieler);
    } else if (gewahlter_Ort.equals("Wald") && spieler.getLevel() >= 0) {
      printDelayLn("Der dunkle Wald soll Mythen zufolge gefahrliche Monster und geheimnisvolle Kreaturen beherbergen.");
      Dunkler_Wald(spieler);
    } else if (gewahlter_Ort.equals("Mine") && spieler.getLevel() >= 1) {
      printDelayLn("Die verlassene Mine ist duster und still. Wer weiß, welche Geheimnisse hier lauern.");
      Verlassene_Mine(spieler);
    } else if (gewahlter_Ort.equals("Schloss") && spieler.getLevel() >= 2) {
      printDelayLn("Das alte Schloss erhebt sich vor dir, voller Geschichten und Ratsel...");
      Altes_Schloss(spieler);
    } else if (gewahlter_Ort.equals("Berg") && spieler.getLevel() >= 3) {
      printDelayLn("Der große Berg am Horizont sieht majestatisch und beeindruckend aus. Welche Gefahren wird er wohl verbergen?");
      Großer_Berg(spieler);
    } else if (gewahlter_Ort.equals("Drachenhohle") && spieler.getLevel() >= 4) {
      printDelayLn("Die Drachenhohle offnet sich vor dir. Ein tiefes Grollen ertont aus der Dunkelheit, und du spurst die Hitze des Drachenfeuers.");
      Bedrohliche_Drachenhohle(spieler);
    } else if (gewahlter_Ort.equals("Wald") || gewahlter_Ort.equals("Mine") || gewahlter_Ort.equals("Schloss") || gewahlter_Ort.equals("Berg") || gewahlter_Ort.equals("Drachenhohle")) {
            printDelayLn("Dein Level ist nicht hoch genug, um diesen Ort zu betreten. Erobere andere Orte um diesen freizuschalten.");
      Ortswahl(spieler);
        } else if (gewahlter_Ort.equals("Testumgebung")) {    // Fur Entwickler zum Testen. Wird nicht angeboten. 
      if (spieler.getName().equals("Cheater")) { Testumgebung(spieler); }
    } else if (gewahlter_Ort.equals("Speichern")) {
      save(spieler);
    } else if (gewahlter_Ort.equals("Laden")) {
      load(spieler);
    }
    // default
    printDelayLn("Das ist keine gultige Wahl, aber das Abenteuer wird trotzdem beginnen!");
    Ortswahl(spieler);
  }

  // Ort 1: Dorf, Shop und Casino:
  public static void Dorf (Held spieler) {
    // Wahl der Aktionen im Dorf
    printDelayLn("");
    printDelayLn("Du bist im Dorf.");
    printDelayLn("Wohin willst du gehen?");
    printDelayLn("");
    printDelayLn(" - Shop");
    printDelayLn(" - Casino");
    printDelayLn(" - Rede mit deinem Mentor");
    printDelayLn(" - Kaserne");
    printDelayLn(" - Zuruck zur Ortswahl");
    printDelayLn("");
    printDelayLn("Was willst du machen? (Shop/Casino/Mentor/Kaserne/Ortswahl)");
    String Dorf_Tat = scanner.next();
    // Aufrufe der Orte
    switch(Dorf_Tat) {
      case "Shop":
        Shop(spieler);
        break;
      case "Casino":
        Casino(spieler);
        break;
      case "Mentor":
        Mentor(spieler);
        break;
      case "Kaserne":
        Kaserne(spieler);
        break;
      case "Ortswahl":
        Ortswahl(spieler);
        break;
      default:
        Ortswahl(spieler);
        break;
    }
    // default
    Ortswahl(spieler);
  }

  // Ort 2: Der dunkle Wald: Unterorte: See, Lichtung, Weiser Mann, Burgruinen
  public static void Dunkler_Wald(Held spieler) {

    printDelayLn("");

    String zufalliger_mannlicher_Dorfbewohner = mannliche_Dorfbewohner[random.nextInt(mannliche_Dorfbewohner.length)];

    printDelayLn("Du begibst dich nach Norden. Nach einigen Minuten erhebt sich der dunkle Wald am Horizont.");
    printDelayLn("Die Schatten werden langer, doch etwas in dir drangt dich, weiterzugehen.");
    printDelayLn("Eine unerklarliche Anziehungskraft des Waldes lasst dich nicht umkehren.");
    printDelayLn("Als du tiefer in den Wald vordringst, bricht plotzlich ein leises Rascheln die Stille.");
    printDelayLn("Etwas verbirgt sich im dichten Unterholz. Willst du es untersuchen? (ja/nein)");

    String entscheidung = scanner.next();
    if (entscheidung.equalsIgnoreCase("ja")) {
      printDelayLn("Du naherst dich vorsichtig dem Gebusch...");
      printDelayLn("Plotzlich springt ein wildes Tier hervor!");
      printDelayLn("Ein Wolf schießt auf dich zu, Zahne gebleckt!");
      Monster Wolf = new Monster("Wolf");
      Kampf(spieler, Wolf, true);
    } else {
      printDelayLn("Du entscheidest dich, weiterzugehen, ohne nachzusehen.");
    }
    printDelayLn("");
    printDelayLn("Du folgst einem schmalen Pfad tiefer in den finsteren Wald.");

    int pfadChance = random.nextInt(100);

    if (pfadChance < 60) {
      // 40% Wahrscheinlichkeit, dass ein Monster kommt
      printDelayLn("Aus dem Nichts springt ein Monster aus dem Dickicht!");

      Monster zufalliges_WaldMonster1 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
      Kampf(spieler, zufalliges_WaldMonster1, false);
    } else {
      printDelayLn("Der Pfad bleibt ruhig, und du setzt deinen Weg ungestort fort.");
    }
    // See oder Lichtung
    printDelayLn("");
    printDelayLn("Bald stehst du an einer Kreuzung. Auf der Karte, die dir " + zufalliger_mannlicher_Dorfbewohner + " gegeben hat, siehst du zwei Wege:");
    printDelayLn("Links fuhrt der Weg zu einem See, rechts zu einer Lichtung.");
    printDelayLn("Wohin willst du gehen? (See/Lichtung)");
    String Lichtung_See = scanner.next();
    if (Lichtung_See.equalsIgnoreCase("See")) {
      printDelayLn("Du entscheidest dich, dem Weg zum See zu folgen. Eine kuhle Erfrischung konnte gut tun.");
      See(spieler);
      printDelayLn("Auf deiner Karte erkennst du, dass das Haus des weisen Mannes nicht mehr weit entfernt ist.");
      printDelayLn("Ein schmaler Pfad fuhrt direkt dorthin, und du spurst, wie die Spannung in der Luft steigt.");
      printDelayLn("Mit wachsendem Eifer beschleunigst du deine Schritte.");
    } else if (Lichtung_See.equalsIgnoreCase("Lichtung")) {
      printDelayLn("Die Lichtung scheint dir die bessere Wahl zu sein. Vielleicht findest du dort Beeren oder andere Vorrate.");
      printDelayLn("Entschlossen und voller Tatendrang begibst du dich auf den Weg.");
      Lichtung(spieler);
    } else {
      printDelayLn("Das ist keine gultige Wahl.");
      printDelayLn("Du entscheidest dich, nach links zum See zu gehen.");
      See(spieler);
    }

    printDelayLn("Nach langen Kampfen und einem beschwerlichen Marsch stehst du endlich vor deinem Ziel.");
    printDelayLn("Mit einem Klopfen an der Tur des weisen Mannes kundigst du deine Ankunft an.");
    WeiserMann(spieler);

    printDelayLn("Deine Gedanken wandern bereits zu den Burgruinen.");
    Burgruinen(spieler);
    // dunkler wald durchquert, level++ ...
    printDelayLn("Du hast den dunklen Wald durchquert. Du hast " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
    printDelayLn("Du kannst jetzt die verlassenen Minen betreten. Außerdem bist du nun auf Level 2.");
    if (spieler.getLevel() == 1) {
      printDelayLn("Als Belohnung erhalst du 100 Munzen und 200 Erfahrung.");
      spieler.setCoins(spieler.getCoins() + 100);
      spieler.setErfahrung(spieler.getErfahrung() + 200);
    }
    if (!spieler.getName().equals("Cheater")) {
      spieler.setLevel(2);
    }
    Ortswahl(spieler);
  }

  // Unterort dunkler Wald
  public static void See (Held spieler) {
    printDelayLn("Nach einer gefuhlten Ewigkeit erreichst du den stillen, dunklen See. Das Wasser schimmert im fahlen Licht.");
    printDelayLn("Als du hinuntersteigst, um dich zu waschen, durchzuckt dich ein kalter Schauer. Irgendetwas beobachtet dich.");
    printDelayLn("Du drehst dich um, und siehst:");
    Monster zufalliges_WaldMonster2 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
    Kampf(spieler, zufalliges_WaldMonster2, false);
    Monster zufalliges_WaldMonster3 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
    Kampf(spieler, zufalliges_WaldMonster3, true);
    printDelayLn("");
    printDelayLn("Erschopft sinkst du auf den Boden und ruhst dich aus.");
    printDelayLn("... ... ... ... ... ... ...");
    printDelayLn("Nach einem kurzen Nickerchen fuhlst du dich wieder etwas gestarkt.");
    printDelayLn("Du pfluckst einige Beeren von einem nahen Busch und fuhlst dich gleich besser.");
    spieler.setLeben(spieler.getLeben() + random.nextInt(25));
    printDelayLn("Leben geheilt. Du hast nun: " + spieler.getLeben() + " Leben.");
    printDelayLn("Kurz darauf versperrt ein umgesturzter Baum den Weg. Als du hinuberklettern willst, taucht plotzlich ein Monster auf:");
    Monster zufalliges_WaldMonster4 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
    Kampf(spieler, zufalliges_WaldMonster4, true);
  }

  // Unterort dunkler Wald
  public static void Lichtung (Held spieler) {
    printDelayLn("Als du die Lichtung betrittst, wirst du von den funkelnden Augen eines Wolfsrudels begrußt.");
    printDelayLn("Ihre Blicke fixieren dich, und dann sturzen sie sich auf dich:");
    Monster Wolf1 = new Monster("Wolf");
    Kampf(spieler, Wolf1, false);
    Monster Wolf2 = new Monster("Wolf");
    Kampf(spieler, Wolf2, false);
    Monster Wolf3 = new Monster("Wolf");
    Kampf(spieler, Wolf3, false);
    Monster Wolf4 = new Monster("Wolf");
    Kampf(spieler, Wolf4, true);
    printDelayLn("Wie gehofft findest du einige Beeren, die du isst, um neue Kraft zu schopfen.");
    spieler.setLeben(spieler.getLeben() + random.nextInt(25));
    printDelayLn("Aktuelles Leben: " + spieler.getLeben());
    printDelayLn("Ohne weitere Zeit zu verlieren, begibst du dich auf den Weg zum weisen Mann.");
    printDelayLn("Laut der Karte musst du einfach nur dem Pfad folgen.");
  }

  // Unterort dunkler Wald
  public static void WeiserMann (Held spieler) {
    printDelayLn("Der weise Mann offnet die knarrende Tur und gewahrt dir Einlass. Mit ruhiger Stimme beginnt er, dir seine Weisheiten zu offenbaren.");
    printDelayLn("");
    printDelayLn("Er sagt: \"Die Gefahren des Waldes sind nur der Anfang deiner Reise.");
    printDelayLn("Jenseits der Burgruinen ruhen alte Machte, alter als das Land selbst.");
    printDelayLn("Du wirst ihnen bald gegenuberstehen.");
    printDelayLn("Denke daran: Es ist nicht nur deine Starke, die uber dein Schicksal entscheidet – auch deine Entscheidungen formen deine Zukunft.\"");
    printDelayLn("");
    printDelayLn("Seine Augen fixieren dich eindringlich:");
    printDelayLn("\"Wahle mit Bedacht. Ein falscher Schritt konnte alles verandern.");
    printDelayLn("Doch scheue das Scheitern nicht – es ist der großte Lehrmeister.");
    printDelayLn("Nur jene, die den Mut haben, falsche Wege zu gehen, finden am Ende den richtigen.");
    printDelayLn("Bereite dich gut vor, sammle, was du kannst, und vertraue auf deine innere Starke.\"");
    printDelayLn("");
    printDelayLn("Der weise Mann bietet dir eine Unterkunft an, doch du spurst, dass dein Weg dich zu den Burgruinen fuhrt.");
    printDelayLn("Du erhaltst 100 Erfahrung, weil du seine Weisheit verinnerlicht hast.");
    spieler.setErfahrung(spieler.getErfahrung() + 100);
  }

  // Unterort dunkler Wald
  public static void Burgruinen(Held spieler) {
    printDelayLn("Es ist bereits spat, als du die alten Ruinen erreichst. Die Mauern sind bemoost, und der Wind pfeift durch die zerfallenen Turme.");
    printDelayLn("Die Atmosphare ist duster und unheilvoll. Wahrend du die Ruinen erkundest, spurst du, dass du nicht allein bist.");

    int monsterChance = random.nextInt(100);
    if (monsterChance < 50) {
      printDelayLn("Plotzlich horst du ein Knacken hinter dir. Ein Schatten huscht vorbei.");
      Monster BurgruinenMonster1 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
      Kampf(spieler, BurgruinenMonster1, false);
    } 

    printDelayLn("Du gehst weiter durch die Ruinen und horst plotzlich ein leises, unheimliches Flustern aus einer dunklen Ecke.");
    printDelayLn("Ein weiterer Schatten bewegt sich schnell, und du erahnst die Prasenz eines weiteren Monsters.");

    int zweitesMonsterChance = random.nextInt(100);
    if (zweitesMonsterChance < 40) {
      printDelayLn("Ein gruseliges, schattenhaftes Wesen erscheint vor dir. Seine Augen gluhen im Dunkeln.");
      Monster BurgruinenMonster2 = new Monster(dunklerWaldMonster[random.nextInt(dunklerWaldMonster.length)]);
      Kampf(spieler, BurgruinenMonster2, false);
    } else {
      printDelayLn("Das Flustern wird schwacher, und du siehst nur einen Schatten, der sich schnell zuruckzieht.");
    }

    printDelayLn("Tief im Inneren der Ruinen stoßt du auf eine alte, halb verfallene Treppe.");
    printDelayLn("Sie fuhrt hinab in eine finstere Tiefe. Laut deiner Karte endet hier der Weg, doch ein unheilvolles Gefuhl halt dich zuruck.");
    printDelayLn("Willst du hinabsteigen? (ja/nein)");

    String entscheidung = scanner.next();
    if (entscheidung.equalsIgnoreCase("ja")) {
      printDelayLn("Du steigst die Stufen hinab, und es wird immer kalter.");
      printDelayLn("Am Fuß der Treppe offnet sich eine gewaltige, dunkle Hohle.");

      printDelayLn("In der Mitte der Hohle siehst du einen alten, verstaubten Altar, auf dem seltsame Symbole eingeritzt sind.");
      printDelayLn("Neben dem Altar liegt eine alte Truhe, die von Spinnweben bedeckt ist.");

      printDelayLn("Was wirst du tun? (altar/truhe)");
      String wahl = scanner.next();

      if (wahl.equalsIgnoreCase("altar")) {
        printDelayLn("Du naherst dich dem Altar und untersuchst die Symbole.");
        printDelayLn("Plotzlich leuchtet der Altar auf und eine mysteriose Energie stromt auf dich ein.");
        printDelayLn("Du fuhlst dich starker und erhaltst Erfahrungspunkte, die dir bei deiner Reise von Nutzen sein werden.");
        int gitbErfahrung = 50 + random.nextInt(100);
        spieler.setErfahrung(spieler.getErfahrung() + gitbErfahrung);
        printDelayLn("Du hast " + gitbErfahrung + " Erfahrungspunkte erhalten!");

      } else if (wahl.equalsIgnoreCase("truhe")) {
        printDelayLn("Du offnest die Truhe vorsichtig. Darin findest du eine Sammlung alter Munzen.");
        int munzen = random.nextInt(100) + 50;
        spieler.setCoins(spieler.getCoins() + munzen);
        printDelayLn("Du findest " + munzen + " Goldmunzen in der Truhe!");

      } else {
        printDelayLn("Du entscheidest dich, nichts zu beruhren und gehst lieber zuruck zur Treppe.");
        printDelayLn("Obwohl du nichts gefunden hast, fuhlst du dich etwas erleichtert, die Hohle nicht weiter erkundet zu haben.");
      }
    } else {
      printDelayLn("Du entscheidest dich, die Ruinen zu verlassen und spater zuruckzukehren.");
      printDelayLn("Auf dem Weg nach draußen kannst du noch einen letzten Blick auf die geheimnisvollen Ruinen werfen.");
      printDelayLn("Wer weiß, welche weiteren Geheimnisse noch auf dich warten?");
    }
  }

  // Ort 3: Die verlassene Mine: Unterorte: Eingang, In die Mine, Gang, Lore, Schlosstor
  public static void Verlassene_Mine(Held spieler) {
    printDelayLn("Du betrittst die verlassene Mine. Es ist dunkel und kalt, und der Boden knirscht unter deinen Fußen.");
    printDelayLn("In der Ferne horst du das Echo von tropfendem Wasser und das Rascheln von unbekannten Kreaturen.");
    printDelayLn("Was mochtest du tun?");

    printDelayLn(" - Tiefer in die Mine vordringen.");
    printDelayLn(" - Den Eingang untersuchen.");
    printDelayLn("(Tiefer/Eingang)");

    String auswahl = scanner.next();

    switch (auswahl) {
      case "Tiefer":
        inDieMine(spieler);
        break;
      case "Eingang":
        eingangMine(spieler);
        break;
      default:
        printDelayLn("Keine gultige Eingabe, du entscheidest dich in die Mine zu gehen.");
        inDieMine(spieler);
        break;
    }

    printDelayLn("Du hast die verlassene Mine durchquert. Du hast " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
    printDelayLn("Du kannst jetzt das alte Schloss betreten. Außerdem bist du nun auf Level 3.");
    if (spieler.getLevel() == 2) {
      printDelayLn("Als Belohnung erhalst du 120 Munzen und 240 Erfahrung.");
      spieler.setCoins(spieler.getCoins() + 120);
      spieler.setErfahrung(spieler.getErfahrung() + 240);
    }
    if (!spieler.getName().equals("Cheater")) {
      spieler.setLevel(3);
    }
    Ortswahl(spieler);
  }

  // Unterort verlassene Mine
  public static void inDieMine(Held spieler) {
    printDelayLn("Du gehst tiefer in die Mine...");
    printDelayLn("Die Gange sind in Dunkelheit gehullt, wahrend die Fackeln im sanften Wind flackern und einen modrigen Geruch verbreiten.");
    printDelayLn("Du gehst weiter und schon bald horst du Steine rollen. Du hast schon ein Gefuhl was dich erwartet. Ein Dorfbewohner hatte dir Geschichten von der Mine erzahlt.");
    Monster Golem1 = new Monster("Golem");
    Kampf(spieler, Golem1, false);
    printDelayLn("Der Golem war viel großer als du erwartet hattest. Aber du hast es geschafft.");
    printDelayLn("Du entscheidest dich schnell weiterzugehen. Die dunklen Gange sind dir nicht geheuer.");
    printDelayLn("Kurze Zeit spater kommst du zu einem Abzweig. Eine Lore fuhrt in einen dunklen engen Schacht.");
    printDelayLn("In dem Gang ist es stockdunkel und die Lore sieht sehr alt aus.");
    printDelayLn("Willst du lieber den Gang weitergehen oder in die Lore steigen? (Gang/Lore)");
    String loreGang = scanner.next();
    if (loreGang.equalsIgnoreCase("Gang")) {
      Gang(spieler);
    } else if (loreGang.equalsIgnoreCase("Lore")) {
      Lore(spieler);
    } else {
      printDelayLn("Das ist keine gultige Eingabe. Du entscheidest dich den Gang zu nehmen. Es ist heller und fuhlt sich besser an.");
      Gang(spieler);
    }
    printDelayLn("Du folgst dem Gang.");
    printDelayLn("Als du zu dem Ende des Ganges kommst siehst du ein großes goldenes Tor.");
    printDelayLn("Was du zuerst nicht bemerkst sind Kafige in denen zwei Monster liegen.");
    Monster GangMonster1 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, GangMonster1, false);
    Monster GangMonster2 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, GangMonster2, false);
    printDelayLn("Von den Kampfen erschopft offnest du die Tore und legst dich schlafen. Du bist im alten Schloss angekommen.");
  }

  // Unterort verlassene Mine
  public static void eingangMine(Held spieler) {
    printDelayLn("Du entscheidest dich den Eingang zu untersuchen. Vielleicht findest du ja etwas nutzliches.");
    printDelayLn("Du findest einen kleinen Haufen Steine, der verdachtig aussieht.");
    printDelayLn("Du fangst an zu graben und stoßt tatsachlich ziemlich schnell auf etwas hartes.");
    printDelayLn("Es ist eine Truhe. Du findest Gold und Erfahrungsflaschchen.");
    int eingangMunzen = 50 + random.nextInt(100);
    spieler.setCoins(spieler.getCoins() + eingangMunzen);
    spieler.setErfahrung(spieler.getErfahrung() + 100);
    printDelayLn("");
    inDieMine(spieler);
  }

  // Unterort verlassene Mine
  public static void Gang(Held spieler) {
    printDelayLn("Du entscheidest dich, den Gang zu Fuß weiterzugehen.");
    printDelayLn("Die Wande des Ganges sind rau, und der Boden ist uneben. Es ist still, abgesehen von deinen eigenen Schritten, die von den steinernen Wanden widerhallen.");
    printDelayLn("Der Weg wirkt sicher, aber die Dunkelheit lasst dich wachsam bleiben.");
    printDelayLn("Plotzlich horst du ein leises Kratzen an der Wand, und du siehst, wie ein Schatten sich bewegt.");
    printDelayLn("Ein Monster tritt aus der Dunkelheit hervor – eine Kreatur, die in den Tiefen der Mine lauert.");
    Monster GangMonster = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, GangMonster, false);
    printDelayLn("Nach einem kurzen, aber intensiven Kampf besiegst du das Monster " + GangMonster.getName() + ".");
    printDelayLn("Du kommst an eine weitere Kreuzung, an der eine weitere Lorenstation ist. Eine Lore kannst du jedoch nicht finden. ");
  }
  
  // Unterort verlassene Mine
  public static void Lore(Held spieler) {
    printDelayLn("Du entscheidest dich, in die alte Lore zu steigen. Sie quietscht und knarrt, als du sie in Bewegung setzt.");
    printDelayLn("Die Fahrt durch den dunklen Schacht ist schnell und holprig, und du kannst kaum etwas um dich herum erkennen.");
    printDelayLn("Plotzlich verlangsamt die Lore, und du horst ein unheimliches Knurren aus der Dunkelheit.");
    Monster LoreMonster = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    printDelayLn("Ein riesiges Monster springt dir entgegen - es ist ein " + LoreMonster.getName() + " jdessen Augen in der Dunkelheit leuchten!");
    Kampf(spieler, LoreMonster, false);
    printDelayLn("Nach einem harten Kampf besiegst du das Monster " + LoreMonster.getName() + " und die Lore setzt ihre Fahrt fort.");

    printDelayLn("Schon bald erreichst du eine große, unterirdische Hohle, die von Schatzen uberfließt. Du steigst aus und bewunderst die glitzernden Goldmunzen.");
    printDelayLn("Doch deine Anwesenheit hat die Kreaturen geweckt, die die Schatze bewachen! Du horst Schritte und Knurren aus allen Richtungen.");

    Monster LoreMonster1 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, LoreMonster1, false);

    Monster LoreMonster2 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, LoreMonster2, false);
    
    Monster LoreMonster3 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, LoreMonster3, false);

    Monster LoreMonster4 = new Monster(verlasseneMineMonster[random.nextInt(verlasseneMineMonster.length)]);
    Kampf(spieler, LoreMonster4, true);

    printDelayLn("Nachdem du die Kreaturen besiegt hast, kannst du endlich die Schatze in Ruhe einsammeln.");
    int gefundenesGold = 250 + random.nextInt(350);
    spieler.setCoins(spieler.getCoins() + gefundenesGold);
    printDelayLn("Du sammelst " + gefundenesGold + " Goldmunzen ein.");
    printDelayLn("Es scheint, dass der einzige Weg zuruck ebenfalls mit der Lore moglich ist.");
    printDelayLn("Du steigst wieder in die Lore und fahrst den Weg zuruck. Die Ruckfahrt verlauft ohne weitere Zwischenfalle.");
    printDelayLn("Ziemlich schnell kommst du zuruck zu dem Gang. Zwar an einer anderen Stelle, aber das ist ja nicht schlimm.");
  }

  // Ort 4: Das alte Schloss: Unterorte: Haupteingang, Bibliothek, Geheimgang, Turm
  public static void Altes_Schloss(Held spieler) {
    printDelayLn("Du betrittst das alte Schloss. Fruher lebte hier der Konig, der die ganze Region kontrollierte.");
    printDelayLn("Jetzt wirkt das Schloss duster und verlassen. Der einst prachtige Thronsaal ist von Spinnweben und Staub bedeckt.");
    printDelayLn("Die Luft ist schwer von Geheimnissen und alten Legenden, die in den Mauern des Schlosses eingeschlossen sind.");
    printDelayLn("Was mochtest du tun?");
    printDelayLn("");
    printDelayLn(" - Den Haupteingang untersuchen.");
    printDelayLn(" - Die alte Bibliothek erkunden.");
    printDelayLn("");
    printDelayLn("(Haupteingang/Bibliothek)");
    
    String auswahl = scanner.next();
    
    switch (auswahl) {
      case "Haupteingang":
        eingangSchloss(spieler);
        break;
      case "Bibliothek":
        bibliothek(spieler);
        break;
      default:
        printDelayLn("Keine gultige Eingabe, du entscheidest dich den Haupteingang zu untersuchen.");
        eingangSchloss(spieler);
        break;
    }

    printDelayLn("Du hast das alte Schloss eingenommen. Du hast " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
    printDelayLn("Du kannst jetzt den großen Berg erklimmen. Außerdem bist du nun auf Level 4.");
    if (spieler.getLevel() == 3) {
      printDelayLn("Als Belohnung erhalst du 140 Munzen und 280 Erfahrung.");
      spieler.setCoins(spieler.getCoins() + 140);
      spieler.setErfahrung(spieler.getErfahrung() + 280);
    }
    if (!spieler.getName().equals("Cheater")) {
      spieler.setLevel(4);
    }
    Ortswahl(spieler);
  }

  // Unterort altes Schloss
  public static void eingangSchloss(Held spieler) {
    printDelayLn("Du entscheidest dich, den Haupteingang des Schlosses zu untersuchen.");
    printDelayLn("Die riesige Tur ist von Rissen durchzogen und knarrt bedrohlich, als du sie offnest. Der Eingang fuhrt in eine große Haupthalle.");
    printDelayLn("Die Halle ist von imposanten Saulen gesaumt und die Wande sind mit verblassten Wandteppichen geschmuckt.");
    printDelayLn("Plotzlich horst du ein seltsames Gerausch. Ein Monster, das hier haust, hat dich bemerkt.");
    
    Monster EingangMonster = new Monster(altesSchlossMonster[random.nextInt(altesSchlossMonster.length)]);
    Kampf(spieler, EingangMonster, false);
    
    printDelayLn("Nach dem Kampf schaust du dich weiter um und entdeckst eine Treppe, die in die obere Etage fuhrt.");
    printDelayLn("Es gibt auch eine große, verstaubte Tur, die in die alte Bibliothek fuhrt.");
    printDelayLn("Mochtest du die Treppe hinaufgehen oder die Bibliothek erkunden? (Treppe/Bibliothek)");
    
    String auswahl = scanner.next();
    if (auswahl.equalsIgnoreCase("Treppe")) {
      turm(spieler);
    } else if (auswahl.equalsIgnoreCase("Bibliothek")) {
      bibliothek(spieler);
    } else {
      printDelayLn("Das ist keine gultige Eingabe. Du entscheidest dich, die Treppe hinaufzugehen.");
      turm(spieler);
    }
  }

  // Unterort altes Schloss
  public static void turm(Held spieler) {
    printDelayLn("Du gehst die Treppe hinauf und gelangst in den alten Turm des Schlosses.");
    printDelayLn("Der Turm ist noch verlassener als der Rest des Schlosses. Staub liegt auf allem und das Licht scheint nur schwach durch die kaputten Fenster.");
    printDelayLn("Plotzlich siehst du eine dunkle Gestalt in der Ecke des Raumes – ein Monster, das sich hier versteckt hat.");
    
    Monster TurmMonster = new Monster(altesSchlossMonster[random.nextInt(altesSchlossMonster.length)]);
    Kampf(spieler, TurmMonster, false);
    
    printDelayLn("Nachdem du das Monster besiegt hast, entdeckst du eine alte Truhe in der Ecke des Turms.");
    printDelayLn("Die Truhe enthalt einige wertvolle Gegenstande. Du findest 100 Goldmunzen und eine mysteriose Schriftrolle.");
    
    int gefundenesGold = 100 + random.nextInt(100);
    spieler.setCoins(spieler.getCoins() + gefundenesGold);
    printDelayLn("Du sammelst " + gefundenesGold + " Goldmunzen ein.");
    
    printDelayLn("Es scheint keinen weiteren Weg nach oben zu geben. Du gehst in die Bibliothek.");
    bibliothek(spieler);
  }

  // Unterort altes Schloss
  public static void bibliothek(Held spieler) {
    printDelayLn("Du entscheidest dich, die alte Bibliothek zu erkunden.");
    printDelayLn("Die Bibliothek ist voller verstaubter Bucher und zerbrochener Regale. Die Luft riecht nach altem Papier und vergilbten Seiten.");
    printDelayLn("Wahrend du durch die Bucher stoberst, findest du ein verstecktes Geheimnis – einen Geheimgang hinter einem Regal.");
    printDelayLn("Der Geheimgang fuhrt dich zu einem geheimen Raum, der mit alten Schatzen und magischen Artefakten gefullt ist.");
    
    printDelayLn("Plotzlich wirst du von einem Monster angegriffen, das die Schatze bewacht.");
    Monster BibliothekMonster = new Monster(altesSchlossMonster[random.nextInt(altesSchlossMonster.length)]);
    Kampf(spieler, BibliothekMonster, false);
    
    printDelayLn("Nach dem Sieg uber das Monster kannst du die Schatze durchsuchen.");
    int gefundenesGold = 100 + random.nextInt(500);
    spieler.setCoins(spieler.getCoins() + gefundenesGold);
    printDelayLn("Du sammelst " + gefundenesGold + " Goldmunzen ein.");
    printDelayLn("Zusatzlich findest du ein machtiges magisches Artefakt, das deine Fahigkeiten verbessert.");
    
    printDelayLn("Es gibt noch eine weitere Tur, die dich moglicherweise zu einem weiteren Abenteuer fuhren konnte.");
    printDelayLn("Mochtest du diese Tur offnen oder den Geheimgang zuruck zum Haupteingang nehmen? (Tur/Geheimgang)");
    
    String auswahl = scanner.next();
    if (auswahl.equalsIgnoreCase("Tur")) {
      geheimraum(spieler);
    } else if (auswahl.equalsIgnoreCase("Geheimgang")) {
      printDelayLn("Du entscheidest dich zum Haupteingang zuruckzukehren.");
    } else {
      printDelayLn("Das ist keine gultige Eingabe. Du entscheidest dich, den Geheimgang zuruck zum Haupteingang zu nehmen.");
    }
  }
  
  // Unterort altes Schloss
  public static void geheimraum(Held spieler) {
    printDelayLn("Du offnest die Tur und betrittst einen geheimen Raum, der von seltsamen Lichtern erleuchtet wird.");
    printDelayLn("Der Raum ist mit alten Schatzen und mysteriosen Relikten gefullt. In der Mitte des Raumes steht ein großer Altar.");
    printDelayLn("Plotzlich wird der Raum von einem starken Wind durchzogen, und eine Erscheinung erscheint vor dir – ein machtiger Wachter, der die Schatze schutzt.");
    
    Monster Wachter = new Monster("Wachter");
    Kampf(spieler, Wachter, false);
    
    printDelayLn("Nachdem du den Wachter besiegt hast, kannst du die Schatze.");
    int gefundenesGold = 100 + random.nextInt(200);
    spieler.setCoins(spieler.getCoins() + gefundenesGold);
    printDelayLn("Du sammelst " + gefundenesGold + " Goldmunzen ein.");
    
    printDelayLn("Es scheint, dass deine Reise hier endet.");
    printDelayLn("Du verlasst den geheimen Raum und kehrst zuruck zum Haupteingang.");
  }

  // Ort 5: Der große Berg: Unterorte: Weg links, Weg rechts, Gipfel, Bergspitze
  public static void Großer_Berg (Held spieler) {
    printDelayLn("");
  
    printDelayLn("Mutig entscheidest du dich, den imposanten großen Berg zu erklimmen. Schon aus der Ferne kannst du seine schroffen Gipfel sehen, die in den Himmel ragen.");
    printDelayLn("Ziemlich schnell kommst du zu einer Weggabelung. Nach rechts ist der Weg breit und ordentlich. Nach links jedoch fuhrt nur ein schmaler Trampelpfad und alles ist voll mit Dornen.");
    printDelayLn("Wohin willst du gehen? (links/rechts)");
    String links_rechts = scanner.next();
    if (links_rechts.equalsIgnoreCase("links")) {
      printDelayLn("Du entscheidest dich den linken Pfad zu nehmen. Du hoffst auf spannende Abenteuer.");
      links(spieler);
    } else if (links_rechts.equalsIgnoreCase("rechts")) {
      printDelayLn("Du entscheidest dich fur den rechten Weg. Du denkst, es ware die sichere Variante.");
      rechts(spieler);
    } else {
      printDelayLn("Keine gultige Eingabe. Du entscheidest dich nach links zu gehen.");
      links(spieler);
    }

    printDelayLn("Du hast den großen Berg erklommen. Du hast " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
    printDelayLn("Du kannst jetzt die bedrohliche Drachenhohle betreten. Außerdem bist du nun auf Level 5.");
    if (spieler.getLevel() == 4) {
      printDelayLn("Als Belohnung erhalst du 160 Munzen und 320 Erfahrung.");
      spieler.setCoins(spieler.getCoins() + 160);
      spieler.setErfahrung(spieler.getErfahrung() + 320);
    }
    if (!spieler.getName().equals("Cheater")) {
      spieler.setLevel(5);
    }
    Ortswahl(spieler);
  }

  // Unterort großer Berg
  public static void links (Held spieler) {
    printDelayLn("Du kampfst dich stundenlang durch Gestrupp und Dornenbusche.");
    printDelayLn("Es ist ein beschwerlicher Weg.");
    Monster linksMonster = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, linksMonster, false);
    Monster linksMonster1 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, linksMonster1, false);
    printDelayLn("Die Monster tauchten aus dem Nichts auf. In dem dichten Gestrupp konntest du nichts erkennen.");
    printDelayLn("Du laufst weiter. Der Weg wird immer enger.");
    Monster linksMonster2 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, linksMonster2, false);
    Monster linksMonster3 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, linksMonster3, false);
    printDelayLn("Es wird dunkler. Der Weg wird steiler. Du kommst auf einen Gipfel und schaust dich um. In der Ferne siehst du die Spitze des Berges. Dort musst du hin.");

    Gipfel(spieler);
  }

  // Unterort großer Berg
  public static void rechts (Held spieler) {
    printDelayLn("Entspannt laufst du den breiten Weg entlang.");
    printDelayLn("Du kommst auf einen Platz. Der Boden ist sandig, am Rande des Weges sind vereinzelt Busche.");
    Monster rechtsMonster = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, rechtsMonster, false);
    Monster rechtsMonster1 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, rechtsMonster1, false);
    Monster rechtsMonster2 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, rechtsMonster2, true);
    printDelayLn("Schnell verlasst du den Platz und laufst weiter. Es wird langsam dunkler.");
    printDelayLn("Auf dem Weg begegnet dir ein weiteres Monster.");
    Monster rechtsMonster3 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, rechtsMonster3, false);
    printDelayLn("Der Weg wird steiler. Langsam bist du erschopft. Du kommst auf einen Gipfel und schaust dich um. In der Ferne siehst du die Spitze des Berges. Da willst du hin.");

    Gipfel(spieler);
  }

  // Unterort großer Berg
  public static void Gipfel (Held spieler) {
    printDelayLn("Auf dem Gipfel angekommen schaust du dich um. In den Schatten der Baume siehst du einige Monster die sich verstecken.");
    Monster GipfelMonster = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, GipfelMonster, false);
    Monster GipfelMonster1 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, GipfelMonster1, false);
    Monster GipfelMonster2 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, GipfelMonster2, false);
    Monster GipfelMonster3 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, GipfelMonster3, false);
    printDelayLn("Du schaust dich noch ein bisschen um aber kannst keine weiteren Monster entdecken.");
    printDelayLn("Du kletterst auf einen Baum und entscheidest dich dort etwas zu schlafen.");
    printDelayLn("Der Wind ist sehr laut und du kannst Monster unter dem Baum horen");
    Monster GipfelMonster4 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, GipfelMonster4, true);
    printDelayLn("Schnell gehst du weiter. Du willst schnell zu der Spitze des Berges gelangen.");
    Bergspitze(spieler);
  }

  // Unterort großer Berg
  public static void Bergspitze(Held spieler) {
    printDelayLn("Du erreichst die Spitze des Berges. Der Wind peitscht dir ins Gesicht, und der Himmel ist von dichten Wolken bedeckt.");
    printDelayLn("Die Erschopfung sitzt tief in deinen Knochen, aber du weißt, dass du hier oben nicht sicher bist. Die Luft ist voller Spannung.");
  
    Monster BergspitzeMonster1 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    printDelayLn("Plotzlich horst du ein tiefes Grollen hinter dir. Ein Monster sturzt aus dem Nichts auf dich zu!");
    Kampf(spieler, BergspitzeMonster1, false);
  
    printDelayLn("Du atmest schwer nach dem Kampf, doch die Gefahr ist noch nicht gebannt. Etwas bewegt sich schnell auf dich zu.");
    Monster BergspitzeMonster2 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, BergspitzeMonster2, false);
  
    printDelayLn("Ein lautes Kreischen durchdringt die Luft, und ohne Vorwarnung musst du dich einem weiteren Gegner stellen.");
    Monster BergspitzeMonster3 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, BergspitzeMonster3, false);
  
    printDelayLn("Kaum hast du das dritte Monster besiegt, merkst du, dass etwas Großeres auf dich zukommt. Die Erde unter deinen Fußen vibriert.");
    Monster BergspitzeMonster4 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, BergspitzeMonster4, true);
  
    printDelayLn("Du siehst dich um, wahrend der Nebel dichter wird. Ein weiteres Monster taucht aus der Dunkelheit auf – diesmal noch starker.");
    Monster BergspitzeMonster5 = new Monster(bergMonster[random.nextInt(bergMonster.length)]);
    Kampf(spieler, BergspitzeMonster5, true);
  
    printDelayLn("Nach dem letzten Kampf bist du erschopft. Es scheint ruhig zu sein, doch du bleibst wachsam. Es konnte noch mehr auf dich warten.");
    printDelayLn("Die Nacht bricht herein, und du entscheidest dich, den schmalen Pfad hinunterzusteigen, um einen sichereren Ort zu finden.");
    printDelayLn("Mit letzter Kraft gehst du weiter, wissend, dass der Berg dir nichts geschenkt hat – außer Kampfen und der standigen Bedrohung.");
  }
  

  // Ort 6: Bosskampf: Die bedrohliche Drachenhohle: Unterorte: Vulkan, Berg, Drache, Ein Held
  public static void Bedrohliche_Drachenhohle(Held spieler) {
    printDelayLn("Du hast die bedrohliche Drachenhohle erreicht. Hier wird sich alles entscheiden.");
    printDelayLn("Der alte, machtige Drache terrorisiert seit Jahrzehnten das Land. Du musst ihn besiegen.");
    Vulkan(spieler);

    printDelayLn("Du hast die bedrohliche Drachenhohle erobert und den machtigen Drachen besiegt.");
    printDelayLn("Du hast " + spieler.getCoins() + " Munzen, " + spieler.getErfahrung() + " Erfahrung und " + spieler.getLeben() + " Leben.");
    printDelayLn("Du hast das Land gerettet. Kehre ins Dorf zuruck. Du bist ein Held!");
    printDelayLn("");
    
    if (spieler.getLevel() == 5) {
      printDelayLn("Als Belohnung erhalst du 180 Munzen und 360 Erfahrung.");
      spieler.setCoins(spieler.getCoins() + 180);
      spieler.setErfahrung(spieler.getErfahrung() + 360);
    }

    if (!spieler.getName().equals("Cheater")) {
      spieler.setLevel(6);
    }
    EinHeld(spieler);
  }

  // Unterort bedrohliche Drachenhohle
  public static void Vulkan(Held spieler) {
    printDelayLn("Du gehst zum Vulkan. Die Luft ist schwul und es stinkt. Es wird immer heißer.");
    printDelayLn("Ziemlich schnell hast du dein Wasser ausgetrunken.");
    
    Monster vulkan1 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, vulkan1, false);
    
    Monster vulkan2 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, vulkan2, true);
    
    Monster vulkan3 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, vulkan3, false);
    
    Monster vulkan4 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, vulkan4, false);
    
    Berg(spieler);
  }

  // Unterort bedrohliche Drachenhohle
  public static void Berg(Held spieler) {
    printDelayLn("Du hast den Vulkan uberlebt und stehst nun vor einem steilen Berg.");
    printDelayLn("Der Aufstieg ist anstrengend, aber du weißt, dass es keinen anderen Weg zur Drachenhohle gibt.");
    printDelayLn("Plotzlich horst du ein tiefes Grollen und vor dir taucht ein weiteres Monster auf.");
    
    Monster berg1 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, berg1, false);
    
    printDelayLn("Du setzt deinen Weg fort, doch der Berg wird immer steiler. Du kannst den Gipfel schon sehen.");
    printDelayLn("Ein weiteres Monster lauert hinter einer Felswand und greift dich an.");
    
    Monster berg2 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, berg2, true); // Moglichkeit zur Flucht
    
    printDelayLn("Mit letzter Kraft erreichst du den Gipfel des Berges. Vor dir liegt die bedrohliche Drachenhohle.");
    Drache(spieler);
  }

  // Unterort bedrohliche Drachenhohle
  public static void Drache(Held spieler) {
    printDelayLn("Du hast die bedrohliche Drachenhohle erreicht. Hier wird sich alles entscheiden.");
    printDelayLn("Der alte, machtige Drache terrorisiert seit Jahrzehnten das Land. Du musst ihn besiegen.");
    
    printDelayLn("Bevor du den Drachen erreichst, wirst du von einem finsteren Wesen angegriffen.");
    Monster drache1 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, drache1, false);
    
    printDelayLn("Ein weiteres Monster taucht aus den Schatten auf und versucht, dich zu uberwaltigen.");
    Monster drache2 = new Monster(endbossMonster[random.nextInt(endbossMonster.length)]);
    Kampf(spieler, drache2, true);
    
    printDelayLn("Du hast die Monster besiegt und stehst nun vor der letzten Kammer. Der Drache erwartet dich.");
    
    // Endboss Kampf gegen den Drachen
    Monster boss = new Monster("Drache");
    Kampf(spieler, boss, false);
  }

  // Drache besiegt, Kapitel beendet, Unterort bedrohliche Drachenhohle
  public static void EinHeld(Held spieler) {
    printDelayLn("Nach deinem heldenhaften Sieg uber den Drachen kehrst du ins Dorf zuruck.");
    printDelayLn("Die Dorfbewohner haben von deinem Sieg gehort und empfangen dich mit Jubel und Applaus.");
    printDelayLn("Die Menschen sind dir zutiefst dankbar. Ein großes Fest zu deinen Ehren wird im Dorfplatz abgehalten.");
    printDelayLn("Musik erklingt, und uberall um dich herum tanzen und feiern die Menschen.");
    
    printDelayLn("Die Dorfaltesten kommen auf dich zu und verleihen dir den Titel des Drachenbezwingers.");
    printDelayLn("\"Du hast uns gerettet!\", rufen sie und uberreichen dir eine machtige, alte Rustung, die einst dem großten Krieger des Landes gehorte.");
    printDelayLn("Du fuhlst, wie die Rustung dir neue Kraft verleiht.");
    
    spieler.setCoins(spieler.getCoins() + 200);
    spieler.setErfahrung(spieler.getErfahrung() + 500);
    
    printDelayLn("Nach dem Fest ruhst du dich in einer der Hutten aus, wissend, dass deine Reise noch nicht zu Ende ist.");

    Ortswahl(spieler);
  }

  // Shop, hier konnen Rustungen, Waffen, Ausrustung und Objekte gekauft werden.
  public static void Shop(Held spieler) {
    
    printDelayLn("");
    printDelayLn("Willkommen im Shop, was willst du kaufen?");
    printDelayLn("");
    printDelayLn(" - Rustung");
    printDelayLn(" - Waffe");
    printDelayLn(" - Ausrustung");
    printDelayLn(" - Fahigkeiten");
    printDelayLn(" - Zuruck ins Dorf.");
    printDelayLn("");
    printDelayLn("(Rustung/Waffe/Ausrustung/Fahigkeiten/Dorf)");

    String kaufen = scanner.next();

    switch (kaufen) {
      case "Rustung": // Rustung verbessern
        int levelR = spieler.getRustungLvl();
        int[] rustung = spieler.rustungWerte(levelR);

        if (rustung != null) {
          printDelayLn("Willst du die Rustung upgraden? (ja/nein)");
          printDelayLn("Ein Upgrade wurde " + rustung[1] + " kosten und " + rustung[0] + " Leben geben.");

          String upgradeR = scanner.next();
          if (upgradeR.equalsIgnoreCase("ja") && spieler.getErfahrung() >= rustung[2] && spieler.getCoins() >= rustung[1]) {
            spieler.setLeben(spieler.getLeben() + rustung[0]);
            spieler.setCoins(spieler.getCoins() - rustung[1]);
            spieler.setRustungLvl(spieler.getRustungLvl() + 1);
            printDelayLn("Rustung auf Level " + rustung[3] + " verbessert.");
            printDelayLn("Du hast jetzt " + spieler.getLeben() + " Leben und noch " + spieler.getCoins() + " Munzen.");
          } else if (spieler.getErfahrung() < rustung[2]) {
            printDelayLn("Zu wenig Erfahrung!");
          } else if (spieler.getCoins() < rustung[1]) {
            printDelayLn("Zu wenige Munzen!");
          }         
        } else {
          printDelayLn("Die Rustung ist schon auf dem maximalen Level!");
        }
        break;
    
      case "Waffe": // Waffe verbessern
        int levelW = spieler.getWaffeLvl();
        int[] waffe = spieler.waffeWerte(levelW);

        if (waffe != null) {
          printDelayLn("Willst du die Waffe upgraden? (ja/nein)");
          printDelayLn("Ein Upgrade wurde " + waffe[1] + " kosten und " + waffe[0] + " Schaden hinzufugen.");
          String upgradeW = scanner.next();
          if (upgradeW.equalsIgnoreCase("ja") && spieler.getErfahrung() >= waffe[2] && spieler.getCoins() >= waffe[1]) {
            spieler.setSchaden(spieler.getSchaden() + waffe[0]);
            spieler.setCoins(spieler.getCoins() - waffe[1]);
            spieler.setWaffeLvl(spieler.getWaffeLvl() + 1);
            printDelayLn("Waffe auf Level " + waffe[3] + " verbessert.");
            printDelayLn("Du machst jetzt " + spieler.getSchaden() + " Schaden und hast noch " + spieler.getCoins() + " Munzen.");
          } else if (spieler.getErfahrung() < waffe[2]) {
            printDelayLn("Zu wenig Erfahrung!");
          } else if (spieler.getCoins() < waffe[1]) {
            printDelayLn("Zu wenige Munzen");
          }
        } else {
          printDelayLn("Die Waffe ist schon auf dem maximalen Level!");
        }

        break;
  
      case "Ausrustung": // Ausrustung kaufen
        printDelayLn("Welchen Ausrustungsgegenstand willst du kaufen?");
        printDelayLn(" - Heiltrank");
        printDelayLn(" - Erfahrungstrank");
        printDelayLn("(Heiltrank/Erfahrungstrank)");
        String ausrustungKauf = scanner.next();
        if (ausrustungKauf.equals("Heiltrank")) { // Heiltrank kaufen
          // Werte fur Progression
          int kostenHeilung = 15 + 2 * spieler.getLevel();
          int heilung = 20 + 5 * spieler.getLevel();
          printDelayLn("Der Heiltrank ist auf Level " + spieler.getLevel() + ". Ein Heiltrank wurde " + kostenHeilung + " Munzen kosten.");
          printDelayLn("Du hast " + spieler.getCoins() + " Munzen.");
          if (spieler.getCoins() >= kostenHeilung) {
            printDelayLn("Mochtest du einen Heiltrank kaufen? (ja/nein)");
            String entscheidung = scanner.next();
            if (entscheidung.equalsIgnoreCase("ja")) {
              spieler.setCoins(spieler.getCoins() - kostenHeilung);
              spieler.setLeben(spieler.getLeben() + heilung);
              printDelayLn("Heiltrank benutzt. Du hast jetzt " + spieler.getLeben() + " Leben!");
            }
          } else {
            printDelayLn("Du hast nicht genug Munzen.");
          }
        } else if (ausrustungKauf.equals("Erfahrungstrank")) {  // Erfahrungstrank kaufen
          // Werte fur Progression
          int kostenErfahrung = 40 + 10 * spieler.getLevel();
          int erfahrung = 10 + 3 * spieler.getLevel();

          printDelayLn("Der Erfahrungstrank ist auf Level " + spieler.getLevel() + ". Ein Erfahrungstrank wurde " + kostenErfahrung + " Munzen kosten.");
          printDelayLn("Du hast " + spieler.getCoins() + " Munzen.");
          if (spieler.getCoins() >= kostenErfahrung) {
            printDelayLn("Mochtest du einen Erfahrungstrank kaufen? (ja/nein)");
            String entscheidung = scanner.next();
            if (entscheidung.equalsIgnoreCase("ja")) {
              spieler.setCoins(spieler.getCoins() - kostenErfahrung);
              spieler.setErfahrung(spieler.getErfahrung() + erfahrung);
              printDelayLn("Erfahrungstrank benutzt. Du hast jetzt " + spieler.getLeben() + " Erfahrung!");
            }
          } else {
            printDelayLn("Du hast nicht genug Munzen.");
          }
        } else {
          printDelayLn("Keine gultige Eingabe!");
          Shop(spieler);
        }
        break;

      case "Fahigkeiten": // Fahigkeiten kaufen

        if (spieler.getErfahrung() < 500) {
          printDelayLn("Du hast noch keine Fahigkeiten freigeschaltet. Sammle mehr Erfahrung.");
        }
        if (spieler.getErfahrung() >= 500) {
          printDelayLn("Es gibt folgende Fahigkeiten:");
          printDelayLn("1. Steinhaut: Held kriegt mehr Leben.");
          printDelayNoLn("(1");
        }
        if (spieler.getErfahrung() >= 1000) {
          printDelayLn("2. Flinke Fuße: Ausweichen Wert wird verbessert.");
          printDelayNoLn("/2");
          printDelayLn("3. Schicksalsschlag: Kritisch Wert wird verbessert.");
          printDelayNoLn("/3");
          printDelayLn("4. Kraft der Titanen: Basisschaden wird verbessert.");
          printDelayNoLn("/4");
        }
        if (spieler.getErfahrung() >= 2000) {
          printDelayLn("5. Gieriger Griff: Mehr Munzen nach jedem Kampf.");
          printDelayNoLn("/5");
          printDelayLn("6. Lehrmeister: Mehr Erfahrung nach jedem Kampf.");
          printDelayNoLn("/6");       
        }
        if (spieler.getErfahrung() >= 3000) {
          printDelayLn("7. Segen der Ahnen: Heilt nach jedem Kampf ein Paar leben.");
          printDelayNoLn("/7");       
        }
        if (spieler.getErfahrung() >= 500) {
          printDelayNoLn(")");
        }
      
        int fahigkeit = scanner.nextInt();
        
        // uberprufen, ob bereits eine Fahigkeit aktiv ist
        if (spieler.getAktiveFahigkeit() != null) {
          printDelayLn("Du hast bereits die Fahigkeit " + spieler.getAktiveFahigkeit() + " aktiviert.");
          printDelayLn("Mochtest du sie ersetzen? (ja/nein)");
          String antwort = scanner.next();
          if (!antwort.equalsIgnoreCase("ja")) {
            printDelayLn("Fahigkeit nicht geandert.");
            break;
          } else {
            printDelayLn("Fahigkeit " + spieler.getAktiveFahigkeit() + " wurde deaktiviert.");
            spieler.deaktiviereAktiveFahigkeit(); // Alte Fahigkeit zurucksetzen
          }
        }
      
        // Fahigkeiten zuweisen und aktivieren
        if (fahigkeit == 1 && spieler.getErfahrung() >= 500) {
          spieler.setLeben(spieler.getLeben() + 50);
          spieler.setAktiveFahigkeit("Steinhaut");
          printDelayLn("Fahigkeit Steinhaut gewahlt. + 50 Leben.");
        } else if (fahigkeit == 2 && spieler.getErfahrung() >= 1000) {
          spieler.setAusweichen(spieler.getAusweichen() + 25);
          spieler.setAktiveFahigkeit("Flinke Fuße");
          printDelayLn("Fahigkeit Flinke Fuße gewahlt. + 25 Ausweichen.");
        } else if (fahigkeit == 3 && spieler.getErfahrung() >= 1000) {
          spieler.setKritisch(spieler.getKritisch() + 20);
          spieler.setAktiveFahigkeit("Schicksalsschlag");
          printDelayLn("Fahigkeit Schicksalsschlag gewahlt. + 20 Kritisch.");
        } else if (fahigkeit == 4 && spieler.getErfahrung() >= 1000) {
          spieler.setSchaden(spieler.getSchaden() + 15);
          spieler.setAktiveFahigkeit("Kraft der Titanen");
          printDelayLn("Fahigkeit Kraft der Titanen gewahlt. + 15 Schaden.");
        } else if (fahigkeit == 5 && spieler.getErfahrung() >= 2000) {
          spieler.setCoinFaktor(1.2);
          spieler.setAktiveFahigkeit("Gieriger Griff");
          printDelayLn("Fahigkeit Gieriger Griff gewahlt. 20% mehr Munzen nach jedem Kampf.");
        } else if (fahigkeit == 6 && spieler.getErfahrung() >= 2000) {
          spieler.setErfFaktor(1.4);
          spieler.setAktiveFahigkeit("Lehrmeister");
          printDelayLn("Fahigkeit Lehrmeister gewahlt. 40% mehr Erfahrung nach jedem Kampf.");
        } else if (fahigkeit == 7 && spieler.getErfahrung() >= 3000) {
          spieler.setAktiveFahigkeit("Segen der Ahnen");
          printDelayLn("Fahigkeit Segen der Ahnen gewahlt. + 7 Leben nach jedem Kampf.");
        } else {
          printDelayLn("Keine gultige Eingabe.");
          Shop(spieler);
        }
        break;

      case "Dorf":  // Dorf
        Dorf(spieler);
        break;
  
      default:  // default -> zuruck in den Shop
        printDelayLn("Ungultige Wahl.");
        break;
    }
    Shop(spieler);
  }

  // Casino: Gewinnwahrscheinlichkeit 45%
  public static void Casino(Held spieler) {
        printDelayLn("");

        while (true) {
            printDelayLn("Du bist im Casino");
            printDelayLn("Die Wahrscheinlichkeit, dass du gewinnst liegt bei 45%.");
            printDelayLn("Gebe 0 an um zuruck ins Dorf zu gehen.");
            printDelayLn("Du hast ubrigens " + spieler.getCoins() + " Munzen. Wie viel willst du setzen?");
            
            int einsatz = scanner.nextInt();
            
            if (einsatz == 0) {
                Dorf(spieler);
                break;
            } else if (einsatz > 0 && einsatz <= spieler.getCoins()) {
                Random random = new Random();
                boolean gewonnen = random.nextDouble() < 0.45;
                
                if (gewonnen) {
                    printDelayLn("Herzlichen Gluckwunsch! Du hast gewonnen!");
                    spieler.setCoins(spieler.getCoins() + einsatz);
                } else {
                    printDelayLn("Leider verloren. Viel Gluck beim nachsten Mal!");
                    spieler.setCoins(spieler.getCoins() - einsatz);
                }
                
                printDelayLn("Du hast jetzt " + spieler.getCoins() + " Munzen.");
            } else if (einsatz > spieler.getCoins()) {
                printDelayLn("Soviel Munzen hast du nicht.");
            } else {
                printDelayLn("Keine gultige Eingabe!");
            }
        }
    }

  // FAQ ingame: Mentor
  public static void Mentor(Held spieler) {
    printDelayLn("");

    boolean weiterFragen = true;
    
    while (weiterFragen) {
      printDelayLn("Zu welchem Thema hast du Fragen?");
      printDelayLn("");
      printDelayLn(" - Wie funktioniert der Shop?");
      printDelayLn(" - Wie funktionieren Fahigkeiten?");
      printDelayLn(" - Wie funktioniert die Kaserne?");
      printDelayLn(" - Ich finde mich nicht in der Welt zurecht!");
      printDelayLn(" - Wie funktioniert die Funktion mit der man den Spielstand speichern kann?");
      printDelayLn(" - Zuruck ins Dorf");
      printDelayLn("");
      printDelayLn("(Shop/Fahigkeiten/Kaserne/Welt/Spielstand/Dorf)");
      
      String fragen = scanner.next();
      switch (fragen) {
        case "Shop":
          printDelayLn("In dem Shop kannst du dir Waffen, Rustungen und Ausrustungsgegenstande kaufen und deine Fahigkeiten auswahlen.");
          break;
        case "Fahigkeiten":
          printDelayLn("Es gibt sieben verschiedene Fahigkeiten, die ab einer bestimmten Erfahrung freigeschaltet werden.");
          printDelayLn("Es kann immer nur eine Fahigkeit aktiv sein. Wahle zum deaktivieren einfach die neue Fahigkeit aus.");
          printDelayLn("Du kannst ubrigens immer wechseln.");
          break;
        case "Kaserne":
          printDelayLn("In der Kaserne kannst du einen Dorfbewohner ausbilden. Dieser hat auch eine Waffe und Rustung und hilft dir im Kampf.");
          printDelayLn("Die Kaserne wird ab 5000 Erfahrung freigeschaltet.");
          break;
        case "Welt":
          printDelayLn("Die Datei TextAdventureKarte.jpg konnte dir helfen!");
          break;
        case "Spielstand":
          printDelayLn("Du kannst deinen aktuellen Spielstand speichern. Du bekommst dann eine Zeichenfolge. Diese musst du beim Laden eingeben.");
          printDelayLn("Es werden alle deine aktuellen Attribute gespeichert.");
          break;
        case "Dorf":
          Dorf(spieler);
          break;
        default:
          printDelayLn("Das ist keine gultige Eingabe.");
          break;
      }

      printDelayLn("Hast du weitere Fragen? (ja/nein)");
      String weitereFragen = scanner.next();
      if (!weitereFragen.equalsIgnoreCase("ja")) {
        weiterFragen = false;
      }
    }
    Ortswahl(spieler);
  }

  // Kaserne, bildet Dorfbewohner aus damit diese spater mitkampfen.
  public static void Kaserne(Held spieler) {
    if (spieler.getDorfbewohner() == null) {
      if (spieler.getErfahrung() <= 1000) {
        printDelayLn("Du hast nicht genug Erfahrung. Besiege Monster um mehr zu sammeln.");
        Shop(spieler);
      } else {
        printDelayLn("Du bist in der Kaserne. Hier kannst du einen Dorfbewohner ausbilden, der mit dir kampft.");
        printDelayLn("Der Dorfbewohner hat ebenfalls eine Waffe und Rustung, die du verbessern kannnst.");
        printDelayLn("Wie willst du deinen Lehrling, den Dorfbewohner, nennen?");
        String nameFreund = scanner.next();
        Dorfbewohner freund = new Dorfbewohner(50, nameFreund, 3, 10, 10);
        spieler.setDorfbewohner(freund);
        printDelayLn(freund.getName() + " ist bereit fur dich zu kampfen.");
        printDelayLn("");;
        Kaserne(spieler);
      } 
    } else {
      Dorfbewohner freund = spieler.getDorfbewohner();

      printDelayLn("Was willst du machen?");
      printDelayLn("");
      printDelayLn(" - Rustung des Lehrlings verbessern");
      printDelayLn(" - Waffe des Lehrlings verbessern");
      printDelayLn(" - Lehrling umbenennen");
      printDelayLn(" - Zuruck ins Dorf");
      printDelayLn("");
      printDelayLn("(Rustung/Waffe/Name/Dorf)");
      String kaserneAktion = scanner.next();
      if (kaserneAktion.equals("Rustung")) {
        int levelR = freund.getRustungLvl();
        int[] rustung = freund.rustungWerte(levelR);

        printDelayLn("Willst du die Rustung von " + freund.getName() + " upgraden? (ja/nein)");
        printDelayLn("Ein Upgrade wurde " + rustung[1] + " kosten und " + freund.getName() + " " + rustung[0] + " Leben geben.");

        String upgradeR = scanner.next();
        if (upgradeR.equalsIgnoreCase("ja") && spieler.getErfahrung() >= rustung[2] && spieler.getCoins() >= rustung[1]) {
          freund.setLeben(freund.getLeben() + rustung[0]);
          spieler.setCoins(spieler.getCoins() - rustung[1]);
          freund.setRustungLvl(freund.getRustungLvl() + 1);
          printDelayLn("Rustung von " + freund.getName() + " auf Level " + rustung[3] + " verbessert.");
          printDelayLn(freund.getName() + " hat jetzt " + freund.getLeben() + " Leben und du hast noch " + spieler.getCoins() + " Munzen.");
        } else if (spieler.getErfahrung() < rustung[2]) {
          printDelayLn("Zu wenig Erfahrung!");
        } else if (spieler.getCoins() < rustung[1]) {
          printDelayLn("Zu wenige Munzen!");
        }
      } else if (kaserneAktion.equals("Waffe")) {
        int levelW = freund.getWaffeLvl();
        int[] waffe = freund.waffeWerte(levelW);

        printDelayLn("Willst du die Waffe von " + freund.getName() + " upgraden? (ja/nein)");
        printDelayLn("Ein Upgrade wurde " + waffe[1] + " kosten und " + freund.getName() + " wurde dann " + waffe[0] + " mehr Schaden machen.");

        String upgradeW = scanner.next();
        if (upgradeW.equalsIgnoreCase("ja") && spieler.getErfahrung() >= waffe[2] && spieler.getCoins() >= waffe[1]) {
          freund.setSchaden(freund.getSchaden() + waffe[0]);
          spieler.setCoins(spieler.getCoins() - waffe[1]);
          freund.setWaffeLvl(freund.getWaffeLvl() + 1);
          printDelayLn("Waffe von " + freund.getName() + " auf Level " + waffe[3] + " verbessert.");
          printDelayLn(freund.getName() + " macht jetzt " + freund.getSchaden() + " Schaden und du hast noch " + spieler.getCoins() + " Munzen.");
        } else if (spieler.getErfahrung() < waffe[2]) {
          printDelayLn("Zu wenig Erfahrung!");
        } else if (spieler.getCoins() < waffe[1]) {
          printDelayLn("Zu wenige Munzen!");
        }
      } else if (kaserneAktion.equals("Name")) {
        printDelayLn("Wie willst du deinen Lehrling nennen?");
        String newName = scanner.next();
        spieler.getDorfbewohner().setName(newName);
        printDelayLn("Name geandert. Dein Lehrling heißt jetzt " + spieler.getDorfbewohner().getName());
        Kaserne(spieler);

      } else if (kaserneAktion.equals("Dorf")) {
        Dorf(spieler);
      } else {  // -> default
        printDelayLn("Keine gultige Eingabe.");
        Kaserne(spieler);
      }
    }
  }

  public static void Testumgebung(Held spieler) {
    printDelayLn("Du bist in der Testumgebung.");
    Monster testMonster = new Monster("TestMonster");
    Kampf(spieler, testMonster, true);
    printDelayLn("Willst du erneut kampfen?");
    printDelayLn("(ja/nein)");
    String testKampf = scanner.next();
    if (testKampf.equalsIgnoreCase("ja")) {
      Testumgebung(spieler);
    }
    Ortswahl(spieler);
  }

  // speichern des Spielstandes
  public static void save(Held spieler) {
    printDelayLn("Du bekommst eine Zeichenfolge, die deinen Spielstand kodiert.");
    printDelayLn("Speicher dir diese um den aktuellen Spielstand zu laden.");

    Dorfbewohner freund = spieler.getDorfbewohner();

    // Kodierung der Werte des Spielers
    String name = encodeName(spieler.getName());
    String leben = encodeInt(spieler.getLeben(), 2);
    String schaden = encodeInt(spieler.getSchaden(), 2);
    String ausweichen = encodeInt(spieler.getAusweichen(), 2);
    String kritisch = encodeInt(spieler.getKritisch(), 2);
    String coins = encodeInt(spieler.getCoins(), 3);
    String erfahrung = encodeInt(spieler.getErfahrung(), 3);
    String level = encodeInt(spieler.getLevel(), 1);
    String schild = encodeInt(spieler.getSchild(), 2);
    String sRL = encodeInt(spieler.getRustungLvl(), 1);
    String sWL = encodeInt(spieler.getWaffeLvl(), 1);

    // Speicherstring ohne Dorfbewohner
    String saveString = name + "-" 
            + leben + "-" 
            + schaden + "-" 
            + ausweichen + "-" 
            + kritisch + "-" 
            + coins + "-" 
            + erfahrung + "-" 
            + level + "-" 
            + schild + "-" 
            + sRL + "-" 
            + sWL;

    // Werte vielleicht dranhangen
    if (freund != null) {
      // Kodierung der Werte
      String freundName = encodeName(freund.getName());
      String freundLeben = encodeInt(freund.getLeben(), 2);
      String freundSchaden = encodeInt(freund.getSchaden(), 2);
      String freundAusweichen = encodeInt(freund.getAusweichen(), 2);
      String freundKritisch = encodeInt(freund.getKritisch(), 2);
      String fRL = encodeInt(freund.getRustungLvl(), 1);
      String fWL = encodeInt(freund.getWaffeLvl(), 1);

      // Hinzufugen der Werte
      saveString += "-" + freundName + "-"
            + freundLeben + "-"
            + freundSchaden + "-"
            + freundAusweichen + "-"
            + freundKritisch + "-"
            + fRL + "-"
            + fWL;
    }
    // Ausgabe des Speicherstrings
    System.out.println("");
    System.out.println(saveString);
    System.out.println("");
    Ortswahl(spieler);
  }

  // Laden eines Spielstandes
  public static void load(Held spieler) {
    printDelayLn("Gib die Zeichenfolge ein, die du beim Speichern bekommen hast:");
    scanner.nextLine(); // nach scanner.next() kommt auch immer ein Zeilenumbruch, der hier die eingabe zerstoren wurde. Deshalb muss dieser Zeilenumbruch erstmal weggeworfen werden.
    String saveString = scanner.nextLine();

    // Speicherstand aufteilen (basierend auf dem Trennzeichen "-")
    String[] daten = saveString.split("-");

    // uberprufen, ob genugend Daten vorhanden sind (11 fur Held und optional 7 fur Dorfbewohner)
    if (daten.length != 11 && daten.length != 18) {
      printDelayLn("Ungultiger Speicherstand! Es mussen 11 oder 18 Werte sein.");
      return;
    }

    try {
      // Dekodierung der Held-Daten
      String name = decodeName(daten[0]);
      int leben = decodeInt(daten[1]);
      int schaden = decodeInt(daten[2]);
      int ausweichen = decodeInt(daten[3]);
      int kritisch = decodeInt(daten[4]);
      int coins = decodeInt(daten[5]);
      int erfahrung = decodeInt(daten[6]);
      int level = decodeInt(daten[7]);
      int schild = decodeInt(daten[8]);
      int sRL = decodeInt(daten[9]);
      int sWL = decodeInt(daten[10]);

      // Setzen der Held-Daten
      spieler.setName(name);
      spieler.setLeben(leben);
      spieler.setSchaden(schaden);
      spieler.setAusweichen(ausweichen);
      spieler.setKritisch(kritisch);
      spieler.setCoins(coins);
      spieler.setErfahrung(erfahrung);
      spieler.setLevel(level);
      spieler.setSchild(schild);
      spieler.setRustungLvl(sRL);
      spieler.setWaffeLvl(sWL);

      // Wenn Dorfbewohner-Daten vorhanden sind
      if (daten.length == 18) {
        // Dekodierung der Werte des Dorfbewohners
        String freundName = decodeName(daten[11]);
        int freundLeben = decodeInt(daten[12]);
        int freundSchaden = decodeInt(daten[13]);
        int freundAusweichen = decodeInt(daten[14]);
        int freundKritisch = decodeInt(daten[15]);
        int fRL = decodeInt(daten[16]);
        int fWL = decodeInt(daten[17]);

        // Setzen der Werte
        Dorfbewohner freund = new Dorfbewohner(0, "Fehler", 0, 0, 0);
        if (freund != null) {
          freund.setName(freundName);
          freund.setLeben(freundLeben);
          freund.setSchaden(freundSchaden);
          freund.setAusweichen(freundAusweichen);
          freund.setKritisch(freundKritisch);
          freund.setRustungLvl(fRL);
          freund.setWaffeLvl(fWL);
        }
      }

      printDelayLn("Spielstand erfolgreich geladen.");
      printDelayLn("Jegliche aktiven Fahigkeiten wurden deaktiviert.");
    } catch (Exception e) {
      printDelayLn("Fehler beim Laden des Speicherstands: " + e.getMessage());
    }

    Schwierigkeit(spieler);
    Ortswahl(spieler);
  }
  // Kodierung

  // Methode um Ints zu codieren.
  public static String encodeInt(int nummer, int stellen) {
    // Die Basis-64-Zeichenkette: 0-9, a-z, A-Z, !@
    final String zeichen = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@";
    final int basis = zeichen.length();
  
    if (stellen < 1) {  // Fehler
      throw new IllegalArgumentException("Fehler beim Codieren!");
    }
  
    int maxWert = (int) Math.pow(basis, stellen) - 1;
    if (nummer < 0 || nummer > maxWert) {   // Fehler
      throw new IllegalArgumentException("Fehler beim Codieren!");
    }
  
    StringBuilder string = new StringBuilder();
    do {
      int remainder = nummer % basis;
      string.insert(0, zeichen.charAt(remainder));
      nummer /= basis;
    } while (nummer > 0);
  
    // Ergebnis auf die gewunschte Anzahl Stellen auffullen, falls es weniger hat
    while (string.length() < stellen) {
      string.insert(0, '0');
    }
  
    return string.toString();
  }

  // Methode um Strings zu codieren
  public static String encodeName(String name) {
    // Name zu Zahl
    long zahlenWert = Zahl(name);
    
    // Kodierung in Basis 64
    String nameCodiert = nummerZu64(zahlenWert);
    
    return nameCodiert;
  }

  // Umwandlung der zeichen in die Werte 0 - 52 fur Klein- und Großbuchstaben sowie 53-56 fur Sonderzeichen
  public static long Zahl(String name) {
    long result = 0;
    for (char zeichen : name.toCharArray()) {
      int value = zeichenWert(zeichen);
      result = result * 56 + value;
    }
    return result;
  }

  // Konvertiere die numerische Darstellung in Basis 64
  public static String nummerZu64(long nummer) {
    StringBuilder encoded = new StringBuilder();
    String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@"; // Basis-64-Zeichen
    int BASE = characterSet.length();
    
    while (nummer > 0) {
      int remainder = (int) (nummer % BASE);
      encoded.insert(0, characterSet.charAt(remainder));
      nummer /= BASE;
    }
    return encoded.toString();
  }

  // Zuweisung eines eindeutigen Wertes fur jede Zahl
  public static int zeichenWert(char zeichen) {
    if (zeichen >= 'a' && zeichen <= 'z') {
      return zeichen - 'a' + 1;  // a = 1, b = 2, ..., z = 26
    } else if (zeichen >= 'A' && zeichen <= 'Z') {
      return zeichen - 'A' + 27; // A = 27, B = 28, ..., Z = 52
    } else if (zeichen == ' ') {
      return 53; // Leerzeichen
    } else if (zeichen == '_') {
      return 54; // Unterstrich
    } else if (zeichen == '-') {
      return 55; // Bindestrich
    } else if (zeichen == '.') {
      return 56; // Punkt
    } else {
      throw new IllegalArgumentException("Unerlaubtes Zeichen im String!");
    }
  }
  
  // Dekodierung

  // Methode um codierte Ints zu dekodieren
  public static int decodeInt(String kodiert) {
    // Die Basis-64-Zeichenkette: 0-9, a-z, A-Z, !@
    final String zeichen = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@";
    final int basis = zeichen.length();
    int result = 0;
    
    for (int i = 0; i < kodiert.length(); i++) {
      char ch = kodiert.charAt(i);
      int wert = zeichen.indexOf(ch);
      if (wert == -1) {  // Fehler, wenn ein ungultiges Zeichen gefunden wird
        throw new IllegalArgumentException("Ungultiges Zeichen beim Dekodieren!");
      }
      result = result * basis + wert;
    }
    return result;
  }

  // Methode um einen kodierten String zu dekodieren.
  public static String decodeName(String codiert) {
    // String aus der Basis-64 Kodierung zu einer Zahl
    long zahl = basis64ZuNummer(codiert);

    // Zahl zuruck zu einem String
    String originalName = zahlZuName(zahl);

    return originalName;
  }

  // Methode um eine Basis-64-Zeichenkette zu einer Zahl zu dekodieren
  public static long basis64ZuNummer(String codiert) {
    String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@"; // Basis-64-Zeichen
    int BASE = characterSet.length();
    long result = 0;

    for (int i = 0; i < codiert.length(); i++) {
      char ch = codiert.charAt(i);
      int wert = characterSet.indexOf(ch);
      if (wert == -1) {  // Fehler, wenn ein ungultiges Zeichen gefunden wird
        throw new IllegalArgumentException("Ungultiges Zeichen beim Dekodieren!");
      }
      result = result * BASE + wert;
    }

    return result;
  }

  // Methode um eine Zahl in einen String zu konvertieren
  public static String zahlZuName(long zahl) {
    StringBuilder name = new StringBuilder();

    while (zahl > 0) {
      int wert = (int) (zahl % 56); // 56 wegen unserer ZeichenWert-Methode
      name.insert(0, wertZuZeichen(wert));
      zahl /= 56;
    }

    return name.toString();
  }

  // Methode um den Wert eines Zeichens zu ermitteln (Umkehrung der zeichenWert Methode)
  public static char wertZuZeichen(int wert) {
    if (wert >= 1 && wert <= 26) {
      return (char) ('a' + wert - 1);  // 1 = a, 2 = b, ..., 26 = z
    } else if (wert >= 27 && wert <= 52) {
      return (char) ('A' + wert - 27); // 27 = A, 28 = B, ..., 52 = Z
    } else if (wert == 53) {
      return ' ';  // Leerzeichen
    } else if (wert == 54) {
      return '_';  // Unterstrich
    } else if (wert == 55) {
      return '-';  // Bindestrich
    } else if (wert == 56) {
      return '.';  // Punkt
    } else {
      throw new IllegalArgumentException("Ungultiger Wert beim Dekodieren!");
    }
  }

}